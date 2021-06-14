public class No {


    public No Esquerdo;
    public No Direito;
    public String dado;
    public int prioridade;
    public No anterior;
    public No proximo;
    public No pai;

    public No(String dado, int prioridade) {
        this.prioridade = prioridade;
        this.dado = dado;
    }

    public No(String dado, No pai) {

        this.dado = dado;
        this.pai = pai;
    }

}