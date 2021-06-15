import java.util.ArrayList;

public class Compactador {
    public static class tabelaCodigo{
        public String caractere = null;
        public String codigo = "";
    }
    ArvoreBusca ArvoreHuffman = new ArvoreBusca();
    ArrayList<tabelaCodigo> tabelaCodigos = new ArrayList<>();


    public void GerarArvoreHuffman(FilaPrioridade fila){
        while (!fila.empty()){
           No no = new No(null, 0);
           no.Esquerdo = fila.front();
           fila.dequeue();
           no.Direito = fila.front();
           fila.dequeue();
           no.prioridade = no.Esquerdo.prioridade + no.Direito.prioridade;
           if(!fila.empty()){
              fila.enqueue(no);
           }
           ArvoreHuffman.adicionar(no);
        }

    }
    public void GerarCodigoCaractere(){
        if(!ArvoreHuffman.vazio()) {
            tabelaCodigo tc = new tabelaCodigo();
            percorrerArvore(ArvoreHuffman.raiz, tc);
        }
    }
    public void percorrerArvore(No ramo, tabelaCodigo tc){
        if(ramo.Esquerdo != null){
            tc.codigo += "0";
            percorrerArvore(ramo.Esquerdo, tc);
        }

       if(ramo.dado != null){
           tc.caractere = ramo.dado;
           tabelaCodigos.add(tc);
           if(tc.caractere.length() > 0){
             tc.caractere =  (tc.caractere.substring(0, tc.caractere.length() - 1));
           }
       }

        if(ramo.Direito != null) {
            tc.codigo += "1";
            percorrerArvore(ramo.Direito,tc);
        }
    }
}
