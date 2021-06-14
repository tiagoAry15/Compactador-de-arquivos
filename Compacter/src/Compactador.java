public class Compactador {
    ArvoreBusca ArvoreHuffman = new ArvoreBusca();

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
        if(!ArvoreHuffman.vazio()){
            
        }
    }

}
