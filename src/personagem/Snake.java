package personagem;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import campo.Posicao;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Snake {
    public static ArrayList<Posicao> corpoCobra = new ArrayList();
    public static Posicao cabecaCobra = new Posicao(0,0);
    public static BufferedImage imagem = null;
    
    private Posicao inicio = new Posicao(0,0);
        
    public void Setinicio(int x, int y){
        inicio.x = x;
        inicio.y = y;
    }
  
    public Snake(int x,int y) {      //usaremos sempre x DEPOIS y por padrão
      
        cabecaCobra = new Posicao(x,y);
        
        try {
            imagem = ImageIO.read(new File("snake.png"));
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
    

    public BufferedImage getImagem()
    {
        return imagem;
    }
    
    public void reset()
    {
        System.out.println("vose perdeo");
        cabecaCobra.x = inicio.x;
        cabecaCobra.y = inicio.y;
        corpoCobra.clear();
    }
}


