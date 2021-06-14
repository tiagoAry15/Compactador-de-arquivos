public class No {



    public No Esquerdo;
    public No Direito;
    public String dado;
    public int prioridade;
    public No anterior;
    public No proximo;

    public No(String dado, int prioridade){
        this.prioridade = prioridade;
        this.dado = dado;
    }
    public No(String dado, int prioridade, No Esquerdo, No Direito, No Anterior, No Proximo){
        this.prioridade = prioridade;
        this.dado = dado;
        this.anterior = Anterior;
        this.proximo = Proximo;
        this.Esquerdo = Esquerdo;
        this.Direito = Direito;
    }
}
