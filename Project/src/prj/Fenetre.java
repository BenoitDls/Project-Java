package prj;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

public class Fenetre extends JFrame {
	
	private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
	
		JLabel label = new JLabel("Bienvenue dans 4 mots pour 1 mot \n");
		JLabel regles = new JLabel("Règles du jeu :\n");
		JLabel regles1 = new JLabel("L'utilisateur doit déduire des quatres mot affiché l'idée ou le mot approprié dans un minimum de temps.\n");
		JLabel regles2 = new JLabel("Pour donner le mot exact, il devra sélectionner parmi les lettres qui lui sont proposées.\n");		
		
		regles.setHorizontalAlignment(JLabel.CENTER);
	    regles.setVerticalAlignment(JLabel.CENTER);
		
		panel.add(label);
		panel.add(regles);
		panel.add(regles1);
		panel.add(regles2);
	 
		return panel;
	}	
	


	public Fenetre(){
		
		this.setTitle("4 mots pour 1 mot");
		this.setSize(700, 700);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(buildContentPane());
		
		
		this.setVisible(true);
	}

}
