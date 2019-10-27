package principal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;
import campo.Posicao;
import java.awt.image.BufferedImage;
import personagem.Snake;


public class Tela extends JFrame implements KeyListener {
	
	
	JPanel painel = null;
        
	personagem.Snake snake = new personagem.Snake(240,100); // onde a cobra começa
    BufferedImage cobra = snake.getImagem();
        
	public Tela() {	
		super("SNAKE");
		setSize(800, 600);
        snake.Setinicio(240,100);// onde a cobra restarta(de preferência o mesmo de onde ela começa)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		painel = new JPanel();
		getContentPane().add(painel);
		addKeyListener(this);         
	}

	public void desenhar( Graphics g ){		
		Graphics gPainel = painel.getGraphics();
		gPainel.clearRect(0, 0, getWidth(), getHeight());
		
		 for(int y = 1; y < 800; y+=20) {
	        	g.drawLine(y, 0, y, 600);
	        	g.setColor(Color.lightGray);
	        }
	        
	        for(int x = 1; x < 600; x+=20) {
	        	g.drawLine(0, x, 800, x);
	        	g.setColor(Color.lightGray);
	        }
                
        g.drawImage(cobra,snake.cabecaCobra.x, snake.cabecaCobra.y, null);
        snake.corpoCobra.forEach((posicao) -> desenharCorpo(posicao, g)); 	 
	}
        
        public void desenharCorpo(Posicao posicao, Graphics g){
            g.drawImage(cobra,posicao.x, posicao.y, null);
        }
	
	  public void paint(Graphics g) {
		  desenhar(g);
	    }

	  public void update(Graphics g) {
		  desenhar(g);
	    }

	  
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (snake.cabecaCobra.x <580)  //não passar da borda direita
                    {
                        snake.corpoCobra.add(snake.cabecaCobra);
                        snake.cabecaCobra.x+=10;
                        repaint();
                    }else
                    {
                   // jogo.morreu();
                   //scoreboard.add(this.score);//implementações futuras
                    snake.reset();
                    }
                }
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (snake.cabecaCobra.x > -50) //não passar da borda esquerda
                    {
                        snake.corpoCobra.add(snake.cabecaCobra);
                        snake.cabecaCobra.x-=10 ;
                        repaint();
                    }else
                    {
                   // jogo.morreu();
                   //scoreboard.add(this.score);//implementações futuras
                    snake.reset();
                    }
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (snake.cabecaCobra.y > -170)//não passar da borda superior
                    { 
                        snake.corpoCobra.add(snake.cabecaCobra);
                        snake.cabecaCobra.y-=10;
                        repaint();
                    }else
                    {
                   // jogo.morreu();
                   //scoreboard.add(this.score);//implementações futuras
                    snake.reset();
                    }
                }
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (snake.cabecaCobra.y < 340) //não passar da borda inferior
                    {
                        snake.corpoCobra.add(snake.cabecaCobra);
                        snake.cabecaCobra.y+=10;
                        repaint();
                    }else
                    {
                   // jogo.morreu();
                   //scoreboard.add(this.score); //implementações futuras
                    snake.reset();
                    }
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
