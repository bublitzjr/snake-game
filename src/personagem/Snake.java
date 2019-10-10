package personagem;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Snake {
	public static int x;
        public static int y;
    BufferedImage imagem = null;

    public Snake(int x,int y) {
       this.x = x;
       this.y=y;
        try {
            imagem = ImageIO.read(new File("snake.png"));
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }


    public BufferedImage getImagem() {
        return imagem;
    }

}


