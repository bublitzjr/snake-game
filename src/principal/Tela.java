package principal;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Tela extends JFrame implements KeyListener {
	int x = 100;
	int y = 100;
	
	JPanel painel = null;
	
	public Tela() {	
		super("SNAKE");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		painel = new JPanel();
		getContentPane().add(painel);
	    addKeyListener(this);
	}
	

	public void desenhar( Graphics g ){
		Graphics gPainel = painel.getGraphics();
		gPainel.clearRect(0, 0, getWidth(), getHeight());
		g.drawRect(x, y, 50, 50);
		 
	}
	
	  public void paint(Graphics g) {
			desenhar(g);
	    }

	  public void update(Graphics g) {
		
	    }

	  
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			x+=10;
			repaint();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			x-=10 ;
			repaint();
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			y-=10;
			repaint();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			y+=10;
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
