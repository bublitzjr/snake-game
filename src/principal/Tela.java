package principal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;
import campo.Posicao;
import campo.Fruta;
import java.awt.image.BufferedImage;
import personagem.Snake;
import java.util.Random;


public class Tela extends JFrame implements KeyListener {

	JPanel painel = null;
        
	personagem.Snake snake = new personagem.Snake(380,302); // onde a cobra começa
    BufferedImage cobra = null;
    BufferedImage frutaimg = null;
    Fruta fruta = null;
        
	public Tela() {	                
		super("SNAKE");
                
        Random rng = new Random();
		setSize(800, 600);
        snake.Setinicio(380,302);// onde a cobra restarta(de preferência o mesmo de onde ela começa)       
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		painel = new JPanel();
		getContentPane().add(painel);
		addKeyListener(this);         
                        
        fruta = new Fruta(20*rng.nextInt(37)+20,20*rng.nextInt(28)+2+40);
        
         new Thread(new Runnable() {
         public void run() {             
            try {                   
                for(int i = 0;i<Integer.MAX_VALUE; i+=5){  
                    if(i<100)
                        Thread.sleep(1000);          
                    if(i>=100 && i<300)
                        Thread.sleep(800);
                    if(i>=300 && i<500)
                        Thread.sleep(600);   
                        andar(snake.direcao);
                 }
                                    
                } catch (Exception ex) {
                     ex.printStackTrace();
                }
         }
        }).start();
        
	}

	public void desenhar( Graphics g ){
                if(fruta.x == snake.cabecaCobra.x && fruta.y == snake.cabecaCobra.y){
                    snake.tamanho++;
                    fruta.novaFruta(1);
                }
                   
		frutaimg = Fruta.getImagem();
		cobra = snake.getImagem();
		Graphics gPainel = painel.getGraphics();
		gPainel.clearRect(0, 0, getWidth(), getHeight());
		
        g.drawImage(frutaimg, fruta.x, fruta.y, null);
       
       desenharBordas(g);
	     
        g.drawImage(cobra,snake.cabecaCobra.x, snake.cabecaCobra.y, null);
        snake.corpoCobra.forEach((posicao) -> desenharCorpo(posicao, g)); 	 
	
		}
        
        public void desenharCorpo(Posicao posicao, Graphics g){
            g.drawImage(snake.corpo,posicao.x, posicao.y, null);
        }
	
        public void paint(Graphics g) {
		  desenhar(g);
	    }

        public void update(Graphics g) {
		  desenhar(g);
	    }

	 	public void adicionarCorpo(){
              if(snake.corpoCobra.size() <= snake.tamanho)
              {
            	  snake.corpoCobra.add( new Posicao(snake.cabecaCobra.x,snake.cabecaCobra.y)); 
              }else{
                  snake.corpoCobra.get(snake.corpoCobra.size() - 1).x = snake.cabecaCobra.x;
                  snake.corpoCobra.get(snake.corpoCobra.size() - 1).y = snake.cabecaCobra.y;
                  if(snake.tamanho>=1){
                    for(int i = 1; i<snake.corpoCobra.size();i++){
                    snake.corpoCobra.get(i-1).x = snake.corpoCobra.get(i).x;
                    snake.corpoCobra.get(i-1).y = snake.corpoCobra.get(i).y;
                    }
                  }
              }
          }
          
	@Override
	public void keyPressed(KeyEvent e) {
                
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (snake.cabecaCobra.x < 760)  //não passar da borda direita                  
            {
                adicionarCorpo();
                snake.cabecaCobra.x+=20;
                repaint();
            }else
            
            {
           // jogo.morreu();
           //scoreboard.add(this.score);//implementações futuras
            snake.reset();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (snake.cabecaCobra.x > 20) //não passar da borda esquerda
            {
                adicionarCorpo();
                snake.cabecaCobra.x-=20 ;
                repaint();
            }else
            {
           // jogo.morreu();
           //scoreboard.add(this.score);//implementações futuras
            snake.reset();
            }
}
	if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (snake.cabecaCobra.y > 42)//não passar da borda superior
            { 
                adicionarCorpo();
                snake.cabecaCobra.y-=20;
                repaint();
            }else
            {
           // jogo.morreu();
           //scoreboard.add(this.score);//implementações futuras
            snake.reset();
            }
        }
	if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (snake.cabecaCobra.y < 560) //não passar da borda inferior
            {
                adicionarCorpo();
                snake.cabecaCobra.y+=20;
                repaint();
            }else
            {
           // jogo.morreu();
           //scoreboard.add(this.score); //implementações futuras
            snake.reset();
            }
			}
        for(int i = 0; i < (snake.corpoCobra.size() - 1); i++){
            if((snake.cabecaCobra.x == snake.corpoCobra.get(i).x) && (snake.cabecaCobra.y == snake.corpoCobra.get(i).y))
                snake.reset();
        	}
        }
        
        public void andar(String direcao){
            if(direcao == "norte"){
                adicionarCorpo();
                snake.cabecaCobra.y-=20;
                repaint();
            }else if(direcao == "leste"){
                adicionarCorpo();
                snake.cabecaCobra.x+=20;
                repaint();
            }else if(direcao == "oeste"){
                adicionarCorpo();
                snake.cabecaCobra.x-=20 ;
                repaint();
            }else if(direcao == "sul"){
                adicionarCorpo();
                snake.cabecaCobra.y+=20;
                repaint();
            }
        }
	
	@Override
	public void keyReleased(KeyEvent e) {
	
		}

	@Override
	public void keyTyped(KeyEvent e) {}

    private void desenharBordas(Graphics g) {
         int x = 0;
        int y = 0;
        
        for(y = 0; y < 800; y+=20) {
			g.drawLine(y, 0, y, 600);
	        g.setColor(Color.lightGray);
	     
	         //LIMITE VISUAL
	        if(y <= 0) {
		         g.setColor(Color.black);
	        }
	         
	        if(y == 760 && x <= 750) {
	        	 g.setColor(Color.black);
	        }
		 }
	        
	     for(x = 0;  x < 600; x+=20) {
	        g.drawLine(0, x, 800, x);
	        g.setColor(Color.lightGray);
	        	
	      //LIMITE VISUAL
	        if(x <= 20) {
	        	g.setColor(Color.black);
	        }
	        	
	        if(x == 560 && y <= 800) {
	        	g.setColor(Color.black);
		    }
	        	
	     }
    }
	
}
