import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Compactador zip = new Compactador();
        File file = new File("C:\\Users\\tiago\\Compactador-de-arquivos\\Compacter\\src\\Mensagem.txt");
        File file2 = new File("C:\\Users\\tiago\\Compactador-de-arquivos\\Compacter\\src\\MensagemCodificada.txt");
        Scanner dado = new Scanner(System.in);
        while (true) {
            try {
                while (true) {
                    System.out.println("Bem vindo ao zipDurant, qual ação você deseja fazer?");
                    System.out.println("Digite 1 para compactar um arquivo");
                    System.out.println("Digite 2 para descompactar um arquivo");

                    if (dado.nextInt() == 1) {
                        zip.LerArquivo(file);
                        zip.GerarArvoreHuffman();
                        zip.GerarCodigoCaractere();
                    }

                    if (dado.nextInt() == 2) {
                        zip.pegarArvoreDoArquivo(file2);
                        zip.DecodificarMensagem(file2);
                    } else {
                        System.out.println("Entrada inválida");
                    }
                }

            } catch (InputMismatchException E) {
                System.out.println("Entrada inválida");
            }
        }
    }
}
