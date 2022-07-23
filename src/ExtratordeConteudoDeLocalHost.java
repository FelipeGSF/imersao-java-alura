import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratordeConteudoDeLocalHost implements ExtratorDeConteudo{

  @Override
  public List<Conteudo> extraiConteudos(String json) {
      
    // extrair só os dados que interessa (títulos, postees, classificação)
    JsonParser parser = new JsonParser();
    List<Map<String, String>> listaAtributosJson = parser.parse(json);
    // System.out.println(listaDeFilmes.get(0));

    // cria lista vazia
    List<Conteudo> conteudos = new ArrayList<>();

    // popula a lista com Conteudos
    for (Map<String, String> atributos : listaAtributosJson) {
      
      String titulo = atributos.get("title");
      String urlImagem = atributos.get("image");
      String ranking = atributos.get("ranking");

      // grava cada titulo e imagem em uma variavel do tipo conteúdo
      Conteudo conteudo = new Conteudo(titulo, urlImagem, ranking);

      conteudos.add(conteudo);
    }

    return conteudos;
  }

}
