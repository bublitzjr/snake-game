package principal;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Personagem.*;
import java.awt.image.BufferedImage;


public class Tela extends JFrame implements KeyListener {
	
	
	JPanel painel = null;
	personagem.Snake snake = new personagem.Snake(400,300);
        BufferedImage cobra = snake.getImagem();
        
	public Tela() {	
		super("SNAKE");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		painel = new JPanel();
		getContentPane().add(painel);
                addKeyListener(this);
                
               
	}
	

	public void desenhar( Graphics g ){
		Graphics gPainel = painel.getGraphics();
		gPainel.clearRect(0, 0, getWidth(), getHeight());
		 
                g.drawImage(cobra,snake.x, snake.y, null);
               
                
		 
	}
	
	  public void paint(Graphics g) {
			desenhar(g);
	    }

	  public void update(Graphics g) {
		
	    }

	  
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (snake.x <100)  //não passar da borda direita
			snake.x+=10;
			repaint();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (snake.x > 0) //não passar da borda esquerda
			snake.x-=10 ;
			repaint();
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (snake.y > -160) //não passar da borda superior
			snake.y-=10;
			repaint();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (snake.y < 100) //não passar da borda inferior
			snake.y+=10;
			repaint();
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
