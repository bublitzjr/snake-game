
package campo;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;


public class Fruta extends Posicao{
    public static BufferedImage frutinha = null;
  
    public Fruta(int x, int y) {
    	super(x, y);
    	
    //SPAW FRUTINHA ALETORIO falta programa ele pra lançar random apenas qnd fruta for comida
   	Random gerador = new Random();
   	for(int i = 0; i < 1; i++) {
    	x = gerador.nextInt(700);
    	y = gerador.nextInt(500);
    	System.out.println(x+" , "+y);
    	}
    	
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
