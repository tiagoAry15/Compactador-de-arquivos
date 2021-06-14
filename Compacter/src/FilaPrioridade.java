public class FilaPrioridade {
    private No primeiro;
    private No ultimo;
    private int contador;

    public FilaPrioridade() {
        primeiro = null;
        ultimo = null;
        contador = 0;
    }

    public void enqueue(No novo) {
        int flag = 0;
        if (primeiro == null) {  // Lista vazia?
            primeiro = novo;
            ultimo = novo;

        }
        else if (novo.prioridade < primeiro.prioridade){
            novo.proximo = primeiro;
            primeiro.anterior = novo;
            primeiro = novo;

        }
        else if (novo.prioridade >= ultimo.prioridade) {
            ultimo.proximo = novo;
            novo.anterior = ultimo;
            ultimo = novo;
        }
        else{
            No aux = primeiro;

            while (aux != null && novo.prioridade >= aux.prioridade){
                aux = aux.proximo;
            }
            novo.proximo = aux;
            novo.anterior = aux.anterior;
            aux.anterior = novo;
            novo.anterior.proximo = novo;


        }
        contador++;

    }
    public void dequeue() {
        if(primeiro != null) {
            primeiro = primeiro.proximo;
            contador--;
        }
    }

    public No front() {
        if(primeiro != null) {
            return primeiro;
        }
        return null;

    }

    public boolean empty(){
        return contador == 0;
    }



    public int size() {
        return contador;
    }

    public void exibir() {
        No aux = primeiro;

        while (aux != null) {
            System.out.println(aux.dado);

            aux = aux.proximo;
        }
    }
}
