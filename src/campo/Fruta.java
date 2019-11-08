
package campo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;



public class Fruta extends Posicao{
    public static BufferedImage frutinha = null;
    
    public  Fruta(int x, int y) {
        super(x, y);
        try{
            frutinha = ImageIO.read(new File("fruta.png"));
        }catch (IOException e) {
            System.out.println(e);
        }
    }
    
     public static BufferedImage getImagem()
    {
        return frutinha;
    }
    
}
