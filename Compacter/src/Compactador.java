import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Compactador {
    public static FilaPrioridade fp = new FilaPrioridade();
    public static HashMap<Character, Integer> map = new HashMap();
    public ArvoreBusca ArvoreHuffman = new ArvoreBusca();
    public ArvoreBusca ArvoreHuffmanArquivo = new ArvoreBusca();
    public ArrayList<tabelaCodigo> tabelaCodigos = new ArrayList<>();
    public String ArvoreCodificada = "";
    public int posicaoLinhaArvore = 0;
    public static class tabelaCodigo {
        public String caractere = null;
        public String codigo = "";
    }


    public void CompactarArquivo(File Arquivo) {
        LerArquivo(Arquivo);
        GerarArvoreHuffman();
        GerarCodigoCaractere();
        CodificarMensagem(Arquivo);
    }

    public void DescompactarArquivo(File Arquivo){
        pegarArvoreDoArquivo(Arquivo);
        DecodificarMensagem(Arquivo);
    }

    public void LerArquivo(File Arquivo) {
        try {
            Scanner reader = new Scanner(Arquivo);
            while (reader.hasNextLine()) {

                String data = reader.nextLine();
                //data = data.toLowerCase();
                if(reader.hasNextLine()){
                   data += '\n';
                }

                for (int i = 0; i < data.length(); i++) {

                    char c = data.charAt(i);
                    map.merge(c, 1, Integer::sum);

                }



            }


            for (Character i : map.keySet()) {
                No no = new No(String.valueOf(i), map.get(i));
                fp.enqueue(no);
            }
            fp.exibir();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo inexistente");
        }
    }

    public void GerarArvoreHuffman() {

        while (!fp.empty()) {
            No no = new No(null, 0);
            no.Esquerdo = fp.front();
            fp.dequeue();
            no.Direito = fp.front();
            fp.dequeue();
            no.prioridade = no.Esquerdo.prioridade + no.Direito.prioridade;
            if (!fp.empty()) {
                fp.enqueue(no);
            } else {
                ArvoreHuffman.adicionar(no);
            }
        }


    }

    public void MostrarTabelaCodigo() {
        for (int i = 0; i < this.tabelaCodigos.size(); i++) {
            System.out.println("Caractere: " + tabelaCodigos.get(i).caractere + " Codigo: " + tabelaCodigos.get(i).codigo);
        }
    }

    public void GerarCodigoCaractere() {
        if (!ArvoreHuffman.vazio()) {
            String Codigo = "";

            percorrerArvore(ArvoreHuffman.raiz, Codigo);
            MostrarTabelaCodigo();

        }
    }

    public void percorrerArvore(No ramo, String codigo) {
        if (ramo.Esquerdo != null) {
            codigo += "0";
            percorrerArvore(ramo.Esquerdo, codigo);
        }

        if (ramo.dado != null) {
            tabelaCodigo tc = new tabelaCodigo();
            tc.caractere = ramo.dado;
            tc.codigo = codigo;
            tabelaCodigos.add(tc);

        }
        if (codigo.length() > 0) {
            codigo = (codigo.substring(0, codigo.length() - 1));
        }
        if (ramo.Direito != null) {
            codigo += "1";
            percorrerArvore(ramo.Direito, codigo);
        }
    }


    public void CodificarMensagem(File file) {
        try {
            Scanner reader = new Scanner(file);
            StringBuilder codigo = new StringBuilder();
            File Compactado = new File("C:\\Users\\tiago\\Compactador-de-arquivos\\Compacter\\src\\MensagemCodificada.txt");
            while (reader.hasNextLine()) {

                String data = reader.nextLine();

                if(reader.hasNextLine()){
                    data += '\n';
                }
                for (int i = 0; i < data.length(); i++) {
                    char c = data.charAt(i);
                    for (Compactador.tabelaCodigo tabelaCodigo : tabelaCodigos) {
                        if (String.valueOf(c).equals(tabelaCodigo.caractere)) {
                            codigo.append(tabelaCodigo.codigo);
                            break;
                        }

                    }

                }


            }

            GerarArvoreNoArquivo();

            FileWriter W = new FileWriter(Compactado);
            BufferedWriter BW = new BufferedWriter(W);
            BW.write(ArvoreCodificada);
            BW.newLine();
            BW.write(codigo.toString());
            BW.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo inexistente");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void GerarArvoreNoArquivo() {

        if (!ArvoreHuffman.vazio()) {

            PercorrerArvoreArquivo(ArvoreHuffman.raiz);
        }

    }

    public void PercorrerArvoreArquivo(No ramo) {
        if (ramo.dado != null) {
            this.ArvoreCodificada += "1";
            System.out.println(ramo.dado + ": " + String.format("%8s", Integer.toBinaryString(ramo.dado.charAt(0))).replaceAll(" ", "0"));
            this.ArvoreCodificada += String.format("%8s", Integer.toBinaryString(ramo.dado.charAt(0))).replaceAll(" ", "0");
            return;
        }
        this.ArvoreCodificada += "0";
        if (ramo.Esquerdo != null) {
            PercorrerArvoreArquivo(ramo.Esquerdo);
        }
        if (ramo.Direito != null) {
            PercorrerArvoreArquivo(ramo.Direito);
        }
    }

    public void DecodificarMensagem(File file) {
        try {
            Scanner reader = new Scanner(file);
            StringBuilder codigo = new StringBuilder();
            File Compactado = new File("C:\\Users\\tiago\\Compactador-de-arquivos\\Compacter\\src\\MensagemDecodificada.txt");


                String vazio = reader.nextLine();
               String data  =  reader.nextLine();
               String saida = "";
                No aux = ArvoreHuffmanArquivo.raiz;
                for (int i = 0; i < data.length(); i++) {
                        if (data.charAt(i) == '0') {
                            aux = aux.Esquerdo;
                        } else {
                            aux = aux.Direito;
                        }
                    if(aux.dado != null) {
                        saida += aux.dado;
                        aux = ArvoreHuffmanArquivo.raiz;
                    }


                }


            FileWriter W = new FileWriter(Compactado);
            BufferedWriter BW = new BufferedWriter(W);
            BW.write(saida);

            BW.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo inexistente");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void pegarArvoreDoArquivo(File file) {
       if(ArvoreHuffmanArquivo.vazio()){
           ArvoreHuffmanArquivo.raiz = new No(null, null);
       }
        try {
            Scanner reader = new Scanner(file);
                String data = reader.nextLine();


                pegarArvoreDoArquivo(ArvoreHuffmanArquivo.raiz,data);

            }


        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void pegarArvoreDoArquivo(No ramo,String linha){
       //
        if(linha.charAt(posicaoLinhaArvore) == '1'){
            String caractere = "";
            for (int i = posicaoLinhaArvore + 1; i < posicaoLinhaArvore + 9 ; i++) {
                caractere += linha.charAt(i);

            }
            int charCode = Integer.parseInt(caractere, 2);
            ramo.dado = Character.toString((char) charCode);
            posicaoLinhaArvore = posicaoLinhaArvore + 8;
            return;
        }

        if(linha.charAt(posicaoLinhaArvore) == '0'){

            ramo.Esquerdo = new No(null, ramo);
            posicaoLinhaArvore++;
            pegarArvoreDoArquivo(ramo.Esquerdo,linha);

            ramo.Direito = new No(null,ramo);
            posicaoLinhaArvore++;
            pegarArvoreDoArquivo(ramo.Direito,linha);
        }

    }


}
