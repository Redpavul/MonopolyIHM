package Jeu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import Data.Carreau;
import Data.CarreauArgent;
import Data.CarreauMouvement;
import Data.Compagnie;
import Data.CouleurPropriete;
import Data.Gare;
import Data.Groupe;
import Data.Joueur;
import Data.ProprieteAConstruire;

public class  Monopoly {
    
    

	private Interface interf;
	private int nbMaisons = 32;
	private int nbHotels = 12;
	private HashMap<String, Groupe> listGroupes = new HashMap();
	private Groupe g;
	//private HashMap<Integer, Carreau> listCarreaux = new HashMap();
	private Carreau [] listCarreaux = new Carreau[41];
	private int des1;
	private int des2;
	private LinkedList<Joueur> joueurs;
    
	
	public Monopoly(String dataFilename)
	{
		setJoueurs(new LinkedList<Joueur>());
		buildGamePlateau(dataFilename);
		initialiserPartie();
		JouerUnCoup(this.getJoueurs().getFirst());
	}
	
	private void buildGamePlateau(String dataFilename)
	{
		for(CouleurPropriete c : CouleurPropriete.values())
		{
			
			//System.out.println("Le groupe de couleur "+c.toString()+" a bien �t� cr��e");
			g = new Groupe(new ArrayList<ProprieteAConstruire>(), c);
			listGroupes.put(c.toString(), g);
			
		}
		try{
			ArrayList<String[]> data = readDataFile(dataFilename, ",");
			
			//TODO: create cases instead of displaying
			for(int i=0; i<data.size(); ++i){
				String caseType = data.get(i)[0];
				if(caseType.compareTo("P") == 0){
					//System.out.println("Propri�t� :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
					
					int[] loyers = {Integer.parseInt(data.get(i)[5]), Integer.parseInt(data.get(i)[6]), 
								Integer.parseInt(data.get(i)[7]), Integer.parseInt(data.get(i)[8]),
								Integer.parseInt(data.get(i)[9]),Integer.parseInt(data.get(i)[10])};
					int prixMaison = Integer.parseInt(data.get(i)[11]);
					int prixHotel = Integer.parseInt(data.get(i)[12]);
					Groupe g = listGroupes.get(data.get(i)[3]);
					String nomCarreau = data.get(i)[2];
					int numeroCarreau = Integer.parseInt(data.get(i)[1]);
					int prixAchat = Integer.parseInt(data.get(i)[4]);
					ProprieteAConstruire p = new ProprieteAConstruire(prixAchat, nomCarreau, numeroCarreau, g, loyers, prixMaison, prixHotel);
					
					listCarreaux[numeroCarreau]= p;
					
					
				}
				else if(caseType.compareTo("G") == 0){
					//System.out.println("Gare :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
					int numeroCarreau = Integer.parseInt(data.get(i)[1]);
					String nomCarreau = data.get(i)[2];
					int prixAchat = Integer.parseInt(data.get(i)[3]);
					Gare g = new Gare(prixAchat, nomCarreau, numeroCarreau);
					listCarreaux[numeroCarreau]= g;
				}
				else if(caseType.compareTo("C") == 0){
					//System.out.println("Compagnie :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
					int numeroCarreau = Integer.parseInt(data.get(i)[1]);
					String nomCarreau = data.get(i)[2];
					int prixAchat = Integer.parseInt(data.get(i)[3]);
					Compagnie c = new Compagnie(prixAchat, nomCarreau, numeroCarreau);
					listCarreaux[numeroCarreau]= c;
				
				}
				else if(caseType.compareTo("CT") == 0){
					//System.out.println("Case Tirage :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
					int numeroCarreau = Integer.parseInt(data.get(i)[1]);
					String nomCarreau = data.get(i)[2];
					CarreauArgent ct = new CarreauArgent(nomCarreau, numeroCarreau);
					listCarreaux[numeroCarreau]= ct;
				}
				else if(caseType.compareTo("CA") == 0){
					//System.out.println("Case Argent :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
					int numeroCarreau = Integer.parseInt(data.get(i)[1]);
					String nomCarreau = data.get(i)[2];
					CarreauArgent ca = new CarreauArgent(nomCarreau, numeroCarreau);
					listCarreaux[numeroCarreau]= ca;
					
				}
				else if(caseType.compareTo("CM") == 0){
					//System.out.println("Case Mouvement :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
					int numeroCarreau = Integer.parseInt(data.get(i)[1]);
					String nomCarreau = data.get(i)[2];
					CarreauMouvement cm = new CarreauMouvement(nomCarreau, numeroCarreau);
					listCarreaux[numeroCarreau]= cm;
				}
				else
					System.err.println("[buildGamePleateau()] : Invalid Data type");
			}
			
			
		} 
		catch(FileNotFoundException e){
			System.err.println("[buildGamePlateau()] : File is not found!");
		}
		catch(IOException e){
			System.err.println("[buildGamePlateau()] : Error while reading file!");
		}
		/*for(int i=1;i<=40;i++)
		{
			Carreau c = listCarreaux[i];
			System.out.println(c.getNomCarreau());
		}*/
	}
	
	 private void initialiserPartie() {
		    
		    // Inscription des Joueurs
		    
		    

		    Scanner sc = new Scanner(System.in);
		    int nbJoueur;
		    System.out.println("Nombre de joueurs :");
		    nbJoueur = sc.nextInt();
		    Joueur [] joueursTemp = new Joueur[nbJoueur];
		    
		    // Cr�ation des joueurs et lancers de des
		     String nom;
		     nom = sc.nextLine(); // Permet de r�initialiser le scanner, qui contient le caract�re \n, car on a utilis� un nextInt()
		     Joueur j;
		    for (int i = 0; i < nbJoueur; i++)
		    {
		     System.out.println("Nom du joueur n�" + (i+1) + " : ");
		     nom = sc.nextLine();
		     roll();//Il faudra g�rer dans cette fonction les cas où les joueur fait un double
		     System.out.println("Il a obtenu " + des1 + " et " + des2 + " soit au total " + (des1+des2) + ".");
		     j = new Joueur(listCarreaux[1], nom, (des1+des2));
		     joueursTemp[i] = j;
		    }
		    
		    triBulleDecroissant(joueursTemp);
		    

		   for (Joueur i : joueursTemp)
		    {
			   System.out.println(i.getNomJoueur());
			   joueurs.add(i);
		    }
		   }
	 
	 public static void triBulleDecroissant(Joueur tableau[])
	 {
			int longueur = tableau.length;
			Joueur tampon ;
			boolean permut;
	 
			do {
				// hypoth�se : le tableau est tri�
				permut = false;
				for (int i = 0; i < longueur - 1; i++) {
					// Teste si 2 �l�ments successifs sont dans le bon ordre ou non
					if (tableau[i].getDes() < tableau[i + 1].getDes()) {
						// s'ils ne le sont pas, on �change leurs positions
						tampon = tableau[i];
						tableau[i] = tableau[i + 1];
						tableau[i + 1] = tampon;
						permut = true;
					}
				}
			} while (permut);
		}


	 
	 private boolean JouerUnCoup(Joueur j) {
			 roll();
			 int des = des1+des2;
			 j.setDes(des);
			 System.out.println("Tour de " + j.getNomJoueur() + " :");
			 System.out.println("Lanc� de d�s : " + des1 + "+" + des2 + " = " + des);
			 int numCar = j.getPositionCourante().getNumeroCarreau()+j.getDes();
			 j.setPositionCourante(this.getListCarreaux()[numCar]);
			 System.out.println("Nouvelle position : " + j.getPositionCourante());
			 for (Joueur i : joueurs) {
				 System.out.println(i.getNomJoueur() + " : case n�" + i.getPositionCourante() + ", " + i.getCash() + "�, couleur " + i.getCouleur());
				 
			// AJOUTER nbMaison + NbHotels	 
			 }
			 return des1 == des2;
	 }
	
	private ArrayList<String[]> readDataFile(String filename, String token) throws FileNotFoundException, IOException
	{
		ArrayList<String[]> data = new ArrayList<String[]>();
		
		BufferedReader reader  = new BufferedReader(new FileReader(filename));
		String line = null;
		while((line = reader.readLine()) != null){
			data.add(line.split(token));
		}
		reader.close();
		
		return data;
	}
	
	
	public void roll(){
		setDes1((int)(Math.random()*6)+1);
		setDes2((int)(Math.random()*6)+1);
	}

	

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Get/Set
	public LinkedList<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(LinkedList<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
	
	public Interface getInterf() {
		return interf;
	}

	public void setInterf(Interface interf) {
		this.interf = interf;
	}

	public int getNbMaisons() {
		return nbMaisons;
	}

	public void setNbMaisons(int nbMaisons) {
		this.nbMaisons = nbMaisons;
	}

	public int getNbHotels() {
		return nbHotels;
	}

	public void setNbHotels(int nbHotels) {
		this.nbHotels = nbHotels;
	}

	public int getDes1() {
		return des1;
	}

	private void setDes1(int des1) {
		this.des1 = des1;
	}

	public int getDes2() {
		return des2;
	}

	private void setDes2(int des2) {
		this.des2 = des2;
	}

	public HashMap<String, Groupe> getListGroupes()
	{
		return listGroupes;
	}

	public void setListGroupes(HashMap<String, Groupe> listGroupes)
	{
		this.listGroupes = listGroupes;
	}

	public Groupe getG()
	{
		return g;
	}

	public void setG(Groupe g)
	{
		this.g = g;
	}

	public Carreau[] getListCarreaux()
	{
		return listCarreaux; 
	}

	public void setListCarreaux(Carreau[] listCarreaux)
	{
		this.listCarreaux = listCarreaux;
	}


			
}


