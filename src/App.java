import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        API minhaAPI = API.MEME;

        // fazer uma conexão HTTP e buscar os conteúdos da API
        ClienteHttp http = new ClienteHttp();
        String json = http.buscaDados(minhaAPI.url());

        List<Conteudo> conteudos = minhaAPI.extrator().extraiConteudos(json);

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
