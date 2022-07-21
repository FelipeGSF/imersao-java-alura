import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        //salva o endereço da API desejada
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060"; //IMDB MOCKIDATA
        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json"; //NASA MOCKIDATA

        // fazer uma conexão HTTP e buscar os conteúdos da API
        ClienteHttp http = new ClienteHttp();
        String json = http.buscaDados(url);


        // exibir e manipular os dados
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNASA();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        for (Conteudo conteudo : conteudos) {
            
            // new StickersGenerator().create(new URL(conteudo.getUrlImagem()).openStream(), conteudo.getTitulo()); //, conteudo.get("imDbRating"));
            new StickersGenerator().create(new URL(conteudo.getUrlImagem()).openStream(), conteudo.getTitulo(), conteudo.getNotaIMDB());

            System.out.println();
            System.out.println("\u001b[38;2;255;209;0m" + conteudo.getTitulo() + "\u001b[0m");
            System.out.println("\u001b[38;2;42;122;228m" + conteudo.getUrlImagem().replaceAll("(@+)(.*).jpg$", "$1.jpg") + "\u001b[0m");
            // System.out.print("\u001b[92;1m" +conteudo.get("imDbRating")+"\u001b[0m ");
            // Double x = Double.parseDouble(conteudo.get("imDbRating"));
            // Long estrelas = Math.round(x);
            // for (int stars = 0; stars < estrelas; stars++) {
            //    System.out.printf("⭐"); //\u2b50
            // }
            System.out.println("\n");
            System.out.println("-----------------------------------------------------------------");
        }

    }
}
