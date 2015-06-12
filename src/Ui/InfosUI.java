package Ui;

import Data.Carreau;
import Data.CarreauArgent;
import Data.CarreauPropriete;
import Data.Joueur;
import Data.ProprieteAConstruire;
import Jeu.IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class InfosUI  extends JPanel
{

	protected IHM ihm ;
	private JButton maker;
	private JButton jouer;
	private JButton construire;
	private JPanel joueurs;
	private JPanel caseSelectionee;
	private JPanel bouttons;
	private JLabel space;
	private JTextArea propriete;
	private JTextArea logs;
	private JScrollPane scroll;
	public int selec;
	private boolean typeSelec;
	private String proprieteselectionner;
	
    public int getSelec() {
		return selec;
	}
    
	public void setSelec(int selec) {
		this.selec = selec;
	}
	
	public Carreau getInfoSelec() {
    	return ihm.getMonopoly().getListCarreaux()[getSelec()];
		
	}



	public InfosUI(IHM ihm) {
        super();
        setBackground(Color.gray);
        this.ihm=ihm;
        joueurs = new JPanel();
        caseSelectionee = new JPanel();
        bouttons = new JPanel();
        space = new JLabel("");
        propriete= new JTextArea();
        propriete.setEditable(false);
        logs= new JTextArea();
        logs.setEditable(false);
        scroll = new JScrollPane (logs);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        typeSelec=false;
        initUIComponents();
    }
    
    private void initUIComponents() 
    {
        this.setLayout(new GridLayout(3, 1));
        joueurs.setLayout(new GridLayout(1, 6));
        bouttons.setLayout(new GridLayout(1, 3));
        caseSelectionee.setLayout(new GridLayout(1,2));
        
        int j = 1 ;
        joueurs.setPreferredSize(new Dimension(50,50));
        for( Joueur i : ihm.getMonopoly().getJoueurs())
        {
        	joueurs.add(new JLabel("<html>Joueur n°"+j+ "<br>"+
        						"Nom :" + i.getNomJoueur() +" <br>"+
        						"cash : " +i.getCash() +"<br> </html>"));
        	j++;
        }
    		while(j<6)
    		{
    			joueurs.add(new JLabel(""));
    			j++;
    		}

    	
    	maker = new JButton("Made by...");
    	construire = new JButton(" contruire");
    	jouer = new JButton("jouer !");
    	logs.append("Lorem ipsu"+"\n"+"m dolor sit amet, conse"+"\n"+"ctetur adi"+"\n"+"piscing elit."+"\n"+" Pellentes"+"\n"+"que ultrices "+"\n"+"interdum nisl"+"\n"+" sit amet t"+"\n"+"incidunt. Proin el"+"\n"+"eifend ligu"+"\n"+"la ut odio ru"+"\n"+"trum, ac rho"+"\n"+"ncus "+"\n"+"enim imperdiet"+"\n"+". Nullam"+"\n"+" vehicu"+"\n"+"la tempor metus, ut r"+"\n"+"utru"+"\n"+"m tortor imperdiet sed."+"\n"+" Vivamus eget felis quis lectus tincidunt rhoncus eu "+"\n"+"tristique"+"\n"+" mauris. In ac ipsum id felis"+"\n"+" porta iaculis eu placerat felis. Nunc convallis d"+"\n"+"ignissim"+"\n"+" nis"+"\n"+"i, quis eleife"+"\n"+"nd justo"+"\n"+" malesuada ut. Cras in tempor tur"+"\n"+"pis, a he"+"\n"+"ndrerit enim. Morbi "+"\n"+"sed vestibulum sem."+"\n"+" Suspendisse metu"+"\n"+"s metus, bibendum sed "+"\n"+"pellentesque eu, "+"\n"+"laoreet a urna. Praesent at"+"\n"+" quam eu nibh tristique elementum eget a eros. Cras justo urna, "+"\n"+"scelerisque aliquam lobortis id, m"+"\n"+"olestie "+"\n"+"nec quam. Pellentesque mollis faucibus s"+"\n"+"apien, eget euismod dui "+"\n"+"condimentum "+"\n"+"at. Morbi co"+"\n"+"nva"+"\n"+"llis lectus et ultrices vehi"+"\n"+"cula. Morbi eg"+"\n"+"et justo quis"+"\n"+""+"\n"+"");
    	//this.setLayout(new BorderLayout());
    	bouttons.add(jouer);
    	bouttons.add(construire);
    	bouttons.add(maker);
    	
    	maker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message;
                

                JOptionPane.showMessageDialog(
                        null,
                        "Créé par : \n" +
                        "Chef de projet : REYMANN Paul\n" +
                        "Codeur Alpha		: CONGIO  Jorane\n" +
                        "IHMan 			: GLIERE  Swann\n" +
                        "Codeur Bravo		: ARTAUD  Matthieu\n" +
                        "Codeur Echo		: LALANDE Fabien\n", 
                        "", 
                        JOptionPane.PLAIN_MESSAGE);
            }
        });
    	
    	jouer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Joueur j;
            	if (!ihm.getMonopoly().isEndGame()) {
            	    j = ihm.getMonopoly().getJoueurs().getFirst();
            	    
            	    ihm.getMonopoly().jouerUnCoup(j);
            	    if (j == ihm.getMonopoly().getJoueurs().getFirst()) {

            	    	ihm.getMonopoly().getJoueurs().addLast(ihm.getMonopoly().getJoueurs().pollFirst()); //On remet le joueur à la fin de la LinkedList .
            	    }
            	}else{

            		addlogs("Le joueur gagnant est : " + ihm.getMonopoly().getJoueurs().getFirst().getNomJoueur());

            }
            	}
        });
    	
    	construire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(typeSelec==false){
            		
	                
	
	               boiteError("Pas de propriété selectionné ! \n"+
	                        "veulliez en selectionné une ");
            	}else{ ((ProprieteAConstruire) ihm.getMonopoly().getListCarreaux()[Integer.parseInt(getProprieteselectionner())]).construireIHM(ihm.getMonopoly()); 
            		}
            	
            }
        });

    	Carreau c = getInfoSelec();

    	caseSelectionee.add(propriete);
    	

    	selection();
    	caseSelectionee.add(propriete);
    //	caseSelectionee.add(space);
    	caseSelectionee.add(scroll);

    	this.add(joueurs);
    	this.add(caseSelectionee);
    	this.add(bouttons);
    }
    public void selection() 
    {
    Carreau c = getInfoSelec();
	if (getSelec()==30 ||getSelec()==2 ||getSelec()==7 ||getSelec()==17 ||getSelec()==22 ||getSelec()==33 ||getSelec()==36 ){
    	propriete.setText("nom : "+c.getNomCarreau()+"\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n");
    	this.typeSelec=false;
	}else if(getSelec()==0 ||getSelec()==10 ||getSelec()==20 ||getSelec()==4 ||getSelec()==38){
    	propriete.setText("nom : "+c.getNomCarreau()+"\n" +
                "prix : "+((CarreauArgent) c).getMontant()+"\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n");
    	this.typeSelec=false;
	}else if(getSelec()==5 ||getSelec()==15||getSelec()==25 ||getSelec()==35 ||getSelec()==12 ||getSelec()==28){
		String proprio;
		if(((CarreauPropriete) c).getProprietaire()!=null){
    		
    		proprio=((CarreauPropriete) c).getProprietaire().getNomJoueur();
    	}else{
    		proprio="banque";}
		propriete.setText("nom : "+c.getNomCarreau()+"\n" +
                "prix : "+((CarreauPropriete) c).getPrixAchat()+"\n" +
                "Propiétaire : "+proprio+"\n" +
                "\n" +
                "\n" +
                "\n");
		this.typeSelec=false;
	}else{
		int montant;
		String proprio;
		if (((ProprieteAConstruire) c).getNbHotels() == 0) {
			montant = ((ProprieteAConstruire) c).getLoyerMaison()[((ProprieteAConstruire) c).getNbMaisons()];
		    } else {
			montant = ((ProprieteAConstruire) c).getLoyerMaison()[5];
		    }
    	if(((CarreauPropriete) c).getProprietaire()!=null){
    		proprio=((CarreauPropriete) c).getProprietaire().getNomJoueur();
    	}else{
    		proprio="banque";}
    	propriete.setText("nom : "+c.getNomCarreau()+"\n" +
                "prix : "+((ProprieteAConstruire) c).getPrixAchat()+"\n" +
                "Propiétaire : "+proprio+"\n" +
                "nb maison : "+((ProprieteAConstruire) c).getNbMaisons()+"\n" +
                "nb hotel : "+((ProprieteAConstruire) c).getNbHotels()+"\n" +
                "loyer : "+montant+"\n" +
                "prix de construction : "+((ProprieteAConstruire) c).getGroupePropriete().getPrixMaison()+"\n" +
                "\n");
    	this.typeSelec=true;
	}
    }
    public void addlogs(String str) 
    {
    	logs.append(str+"\n");
    }
    public String boiteMessage(String str) 
    {
        Object choix;
        String message;
        
    	
        choix=JOptionPane.showConfirmDialog(null,str, str, JOptionPane.YES_NO_OPTION);
        if(choix.toString().equals("0")){
        	message="oui";
        }else{
        	message="non";
        }
        addlogs(message);
		return message;
    }
    public void boiteError(String str){
        JOptionPane.showMessageDialog(
                null,
                str, 
                "", 
                JOptionPane.PLAIN_MESSAGE);
    	
    }

	public String getProprieteselectionner() {
		return proprieteselectionner;
	}

	public void setProprieteselectionner(String proprieteselectionner) {
		this.proprieteselectionner = proprieteselectionner;
	}


        	
}
