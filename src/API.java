public enum API {

  IMDB("https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060",
      new ExtratorDeConteudoDoIMDB()),

  NASA("https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json",
      new ExtratorDeConteudoDaNASA()),

  MEME("https://api.mocki.io/v2/549a5d8b/Memes",
      new ExtratorDeConteudoDeMeme()),

  LOCAL("http://localhost:8080/linguagens", new ExtratordeConteudoDeLocalHost());

  private String url;
  private ExtratorDeConteudo extrator;

  API(String url, ExtratorDeConteudo extrator) {
    this.url = url;
    this.extrator = extrator;
  }

  public String url() {
    return url;
  }

  public ExtratorDeConteudo extrator() {
    return extrator;
  }

}
