public class ArvoreBusca {
    private No raiz;


    public ArvoreBusca(){
        this.raiz = null;
    }
/*
    public void adicionar(String elemento){
        if(vazio()){
            this.raiz = new No(elemento,null);
        }else{
            adicionar(elemento, raiz);
        }
    }

 */

    /*
    public void adicionar(String elemento, No ramo, ){
        if(elemento < ramo.dado){
            if(ramo.Esquerdo == null){
                ramo.Esquerdo = new No(elemento,ramo);
            }else{
                adicionar(elemento, ramo.Esquerdo);
            }

        }else if(elemento > ramo.dado){
            if(ramo.Direito == null){
                ramo.Direito = new No(elemento,ramo);
            }else{
                adicionar(elemento, ramo.Direito);
            }

        }else{
            ramo.contador++;
        }



    }

     */

    public boolean vazio(){
        return raiz == null;
    }

    /*
    public void remover(int elemento){
        if(vazio()){
            remover(elemento, raiz);

        }

    }

    public void remover(String elemento, No raiz){
        if(elemento == raiz.dado){
            if(raiz.Esquerdo == null && raiz.Direito == null){
                if(raiz == raiz.pai.Esquerdo){
                    raiz.pai.Esquerdo = null;
                }else{
                    raiz.pai.Direito = null;
                }
            }else if(raiz.Esquerdo != null && raiz.Direito == null){
                if(raiz == raiz.pai.Esquerdo){
                    raiz.pai.Esquerdo = raiz.Esquerdo;
                }
                else{
                    raiz.pai.Direito = raiz.Esquerdo;
                }

            }

            else if(raiz.Esquerdo == null && raiz.Direito != null){
                if(raiz == raiz.pai.Esquerdo){
                    raiz.pai.Esquerdo = raiz.Direito;
                }
                else{
                    raiz.pai.Direito = raiz.Direito;
                }

            }
            else if(raiz.Esquerdo != null && raiz.Direito != null){

                raiz.dado = min(raiz.Direito);// max(raiz.Esquerdo);
                remover(raiz.dado, raiz.Direito); // remover(raiz.dado, raiz.Esquerdo);
            }


        }else if(elemento < raiz.dado){
            if(raiz.Esquerdo != null){
                remover(elemento, raiz.Esquerdo);
            }
        }

        else if(elemento > raiz.dado){
            if(raiz.Direito != null){
                remover(elemento, raiz.Direito);
            }
        }

    }

     */

    /*
    public int min(No raiz){
        if(raiz.Esquerdo != null) {
            return min(raiz.Esquerdo);
        }
        return raiz.dado;
    }



    public int max(No raiz){
        if(raiz.Direito != null) {
            return min(raiz.Direito);
        }
        return raiz.dado;
    }


    public boolean  pesquisar(int elemento){
        if(this.raiz == null){
            return false;
        }
        else{
            return pesquisar(elemento, raiz);

        }

    }



     */


/*
    public boolean  pesquisar(String elemento,No ramo){
        if(elemento == ramo.dado){
            return true;
        }
        if(elemento < ramo.dado){
            if(ramo.Esquerdo == null){
                return false;
            }else{
                return pesquisar(elemento, ramo.Esquerdo);
            }

        }else if(elemento > ramo.dado){
            if(ramo.Direito == null){
                return false;
            }else{
                return pesquisar(elemento, ramo.Direito);
            }

        }
        return false;
    }

 */
    public void exibirPreOrdem(){
        exibirPreOrdem(raiz);
        System.out.println();

    }

    public void exibirPreOrdem(No raiz){
        System.out.print(" " + raiz.dado);
        if(raiz.Esquerdo != null){
            exibirPreOrdem(raiz.Esquerdo);
        }
        if(raiz.Direito != null) {
            exibirPreOrdem(raiz.Direito);
        }
    }

    public void exibirEmOrdem(){
        exibirEmOrdem(raiz);
        System.out.println();
    }

    public void exibirEmOrdem(No raiz){
        if(raiz.Esquerdo != null){
            exibirEmOrdem(raiz.Esquerdo);
        }

        System.out.print(" " + raiz.dado);

        if(raiz.Direito != null) {
            exibirEmOrdem(raiz.Direito);
        }
    }
    public void exibirPosOrdem(){
        exibirPosOrdem(raiz);
        System.out.println();
    }

    public void exibirPosOrdem(No raiz){
        if(raiz.Esquerdo != null){
            exibirPosOrdem(raiz.Esquerdo);
        }
        if(raiz.Direito != null) {
            exibirPosOrdem(raiz.Direito);
        }

        System.out.print(" " + raiz.dado);
    }


}
