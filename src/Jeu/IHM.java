package Jeu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Ui.FenetreUI;
import Ui.InfosUI;
import Ui.PlateauUI;




public class IHM extends JPanel
{
	private PlateauUI plateau;
	private InfosUI infos;
	private FenetreUI fenetre;
	private Monopoly monopoly;
	
	public IHM (Monopoly monopoly)
	{
		this.monopoly=monopoly;
		initUI();
		
	}
	
	private void initUI() {
        /* Onglets */
        plateau = new PlateauUI(this, getMonopoly()){


			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
 
                ImageIcon m = new ImageIcon("monop.jpg");
                Image monImage = m.getImage();
                g.drawImage(monImage, 0, 0,this);
 
            }
        };
        infos = new InfosUI(this);
        

        /* Fenêtre principale */
        fenetre = new FenetreUI(this);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        plateau.setPreferredSize(new Dimension(500,500));
        this.add(plateau);
        this.add(infos);
        fenetre.add(this);
         
        
        fenetre.afficher();
    }

    /**
     * @return the monopoly
     */
    public Monopoly getMonopoly() {
        return monopoly;
    }

    /**
     * @param monopoly the monopoly to set
     */
    public void setMonopoly(Monopoly monopoly) {
        this.monopoly = monopoly;
    }
}
