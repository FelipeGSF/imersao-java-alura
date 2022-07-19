import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // extrair só os dados que interessa (títulos, postees, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        // System.out.println(listaDeFilmes.get(0));

        // exibir e manipular os dados
        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println();
            System.out.println("\u001b[38;2;255;209;0m" + filme.get("title") + "\u001b[0m");
            System.out.println("\u001b[38;2;42;122;228m" +filme.get("image") + "\u001b[0m");
            System.out.print("\u001b[92;1m" +filme.get("imDbRating")+"\u001b[0m ");
            Double x = Double.parseDouble(filme.get("imDbRating"));
            Long estrelas = Math.round(x);
            for (int stars = 0; stars < estrelas; stars++) {
                System.out.printf("\u2b50");
            }
            System.out.println("\n");
            System.out.println("-----------------------------------------------------------------");
        }

    }
}
