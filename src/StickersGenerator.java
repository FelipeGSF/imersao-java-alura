import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickersGenerator {
  

  public void create(InputStream url, String fileName, String notaFilme) throws Exception{
    
    //leitura da imagem
    //InputStream inputStream = new FileInputStream(new File("entrada/filme.png"))
    //InputStream inputStream = new URL(url).openStream();
    BufferedImage originalImage = ImageIO.read(url);

    //cria nova imagem em memória com transparência e com tamanho novo
    int imgWidth = originalImage.getWidth();
    int imgHeight = originalImage.getHeight();
    int newImgHeight = imgHeight + 200;// adiciona 200 pixels de transparencia logo abaixo da imagem

    

    BufferedImage newImage = new BufferedImage(imgWidth, newImgHeight, BufferedImage.TRANSLUCENT);

    //copiar a imagem original para nova imagem (em memória)
    Graphics2D graphics = (Graphics2D) newImage.getGraphics();
    graphics.drawImage(originalImage, 0, 0, null);

    //configurar a fonte
    Font font = new Font(Font.SANS_SERIF, Font.BOLD, 32);
    graphics.setColor(Color.YELLOW);
    graphics.setFont(font);

    //escrever uma frase na nova imagem
    int textPosX = 0;
    int textPosY = (newImgHeight - imgHeight) / 2 - (font.getSize() / 2); // centraliza texto na parte transparente

    //insere um texto na parte transparente logo abaixo da imagem usando o textPosY que centraliza a altura do texto
    graphics.drawString("Assista!!!", textPosX, newImgHeight - textPosY);

    //escrever a nova imagem em um arquivo
    ImageIO.write(newImage, "png", new File("saida/"+ notaFilme + " - " + fileName + ".png"));

  }

  /** main test
  public static void main(String[] args) throws Exception {
    
    StickersGenerator stickersGenerator = new StickersGenerator();
    stickersGenerator.create();
    
  }*/
}
