import java.io.File;

public class Main {
    public static void main(String[] args) {
        Compactador zip = new Compactador();
        while (true) {
            System.out.println("Bem vindo ao Compact Unifor, qual ação você deseja fazer?");
            System.out.println("Digite 1 para compactar um arquivo");
            System.out.println("Digite 2 para descompactar um arquivo");

            File file = new File("C:\\Users\\tiago\\Compactador-de-arquivos\\Compacter\\src\\Mensagem.txt");
           zip.LerArquivo(file);
           zip.GerarArvoreHuffman();
           zip.GerarCodigoCaractere();
           zip.CodificarMensagem(file);

            break;

        }
    }
}
