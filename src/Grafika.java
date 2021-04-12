import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Grafika  implements KeyEventDispatcher{
	
	public JFrame  frame = new JFrame("2048");
	public JPanel polja[][] = new JPanel[4][4];
	public Logika logika = new Logika();
	Container p = new Container();
	public Grafika()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setSize(new Dimension(500, 500));
		//frame.setLayout(new GridLayout(2, 1));
		setPanel();
		setPanel2();
		
		keyboardControler();
		
	}

	private void keyboardControler()
	{
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher( this);
	}
	public boolean dispatchKeyEvent(KeyEvent e) {
		if(e.getID() == KeyEvent.KEY_PRESSED)
		{
			switch(e.getKeyCode())
			{
			case KeyEvent.VK_UP:
				logika.gore();
				System.out.println("gore");
				osveziGUI();
				break;
			case KeyEvent.VK_DOWN:
				logika.dole();
				System.out.println("dole");
				osveziGUI();
				break;
			case KeyEvent.VK_LEFT:
				logika.levo();
				osveziGUI();
				
				break;
			case KeyEvent.VK_RIGHT:
				logika.desno();
				osveziGUI();
				break;
			}
		}
		
		return false;
		
	}
	

	private void setPanel()
	{
		
		p.setLayout(new GridLayout(4, 4,5,5));
		
		for (int i = 0; i < 4; i++) 
		{
			for (int j = 0; j < 4; j++) 
			{
				polja[i][j] = new JPanel();
				
				JLabel l;
				if(logika.polja[i][j] != 0)
					 l = new JLabel(""+logika.polja[i][j]);
				else
					 l = new JLabel("");
				
				polja[i][j].setLayout(new GridLayout(1, 1));
				polja[i][j].setPreferredSize(new Dimension(33, 33));
				Font f = new Font("F", Font.BOLD, 40);
				l.setFont(f);
				l.setHorizontalAlignment(0);
				l.setOpaque(true);
				
				Color c;
				switch (logika.polja[i][j]) {
				case 0:
					c  = new Color(234, 216, 171);
					break;
				case 2:
					 c = new Color(255, 255, 204);
					break;
				case 4:
					 c = new Color(244, 194, 66);
					break;
				case 8:
					 c = new Color(255, 255, 204);
					break;
				case 16:
					 c = new Color(255, 255, 204);
					 break;
				case 32: 
					c = new Color(255, 255, 204);
					break;
				case 64:
					c = new Color(255, 255, 204);
					break;
				case 128:
					c = new Color(255, 255, 204);
					break;
				case 256:
					c = new Color(255, 255, 204);
					 break;
				case 512:
					c = new Color(255, 255, 204);
					 break;
	
				default:
					c = new Color(255, 255, 204);
					break;
				}
				
				l.setBackground(c);
				
				polja[i][j].add(l);
				
				p.add(polja[i][j]);
			}
		}
		
		frame.add(p, BorderLayout.CENTER);		
		
	}
	
	private void setPanel2()
	{
		JPanel p = new JPanel();
		
		JButton b = new JButton("NOVA IGRA");
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logika = new Logika();
				osveziGUI();
				
			}
		});
		p.setLayout(new GridLayout(1, 1));
		
		
		p.add(b);
		frame.add(p, BorderLayout.SOUTH);
	}
	
	private void osveziGUI()
	{
		for (int i = 0; i < polja.length; i++) 
		{
			for (int j = 0; j < polja[1].length; j++)
			{
				polja[i][j].removeAll();
				JLabel l;
				if(logika.polja[i][j] != 0)
					 l = new JLabel(""+logika.polja[i][j]);
				else
					 l = new JLabel("");
				polja[i][j].setLayout(new GridLayout(1, 1));
				polja[i][j].setPreferredSize(new Dimension(33, 33));
				Font f = new Font("F", Font.BOLD, 40);
				l.setFont(f);
				l.setHorizontalAlignment(0);
				l.setOpaque(true);
				
				Color c;
				
				switch (logika.polja[i][j]) {
				case 0:
					c  = new Color(234, 216, 171);
					break;
				case 2:
					 c = new Color(255, 255, 204);
					break;
				case 4:
					 c = new Color(244, 194, 66);
					break;
				case 8:
					 c = new Color(255, 102, 0);
					break;
				case 16:
					 c = new Color(204, 102, 0);
					 break;
				case 32: 
					c = new Color(204, 51, 0);
					break;
				case 64:
					c = new Color(255, 0, 0);
					break;
				case 128:
					c = new Color(128, 0, 0);
					break;
				case 256:
					c = new Color(255, 255, 204);
					 break;
				case 512:
					c = new Color(255, 255, 204);
					 break;
	
				default:
					c = new Color(255, 255, 204);
					break;
				}
				
				l.setBackground(c);
				
				
				
				polja[i][j].add(l);
				frame.revalidate();
			}
		}
	}
}	
