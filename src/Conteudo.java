public class Conteudo {
    
  private final String titulo;
  private final String urlImagem;
  private final String notaIMDB;

  /* CONSTRUTOR */
  //SOBRECARGA DO CONSTRUTOR PARA FUNCIONAR COM API IMDB
  public Conteudo(String titulo, String urlImagem, String notaIMDB) {
    this.titulo = titulo;
    this.urlImagem = urlImagem;
    this.notaIMDB = notaIMDB;
  }
  //SOBRECARGA DO CONSTRUTOR PARA FUNCIONAR COM API NASA
  public Conteudo(String titulo, String urlImagem) {
    this.notaIMDB = null; // NECESSARIO PARA NÃO DAR ERRO DO COMPILADOR DIZENDO QUE A VARIÁVEL NÃO FOI INICIALIZADA
    this.titulo = titulo;
    this.urlImagem = urlImagem;
  }

  /* GETTERS */
  public String getTitulo() {
    return titulo;
  }

  public String getUrlImagem() {
    return urlImagem;
  }

  public String getNotaIMDB(){
    return notaIMDB;
  }

}
