package Jeu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class  Monopoly {
    
    

	private Joueur[] joueurs;
	private Interface interf;
	private int nbMaisons = 32;
	private int nbHotels = 12;
	private HashMap<String, Groupe> listGroupes = new HashMap();
	private Groupe g;
	private Carreau [] listeCarreaux;
	private int des1 ;
	private int des2 ;
    
	
	public Monopoly(String dataFilename)
	{
		buildGamePlateau(dataFilename);
	}
	
	private void buildGamePlateau(String dataFilename)
	{
		
		for(CouleurPropriete c : CouleurPropriete.values())
		{
			System.out.println("Le groupe de couleur "+c.toString()+" a bien été créée");
			g = new Groupe(new ArrayList<ProprieteAConstruire>(), c);
			listGroupes.put(c.toString(), g);
			
		}
		try{
			ArrayList<String[]> data = readDataFile(dataFilename, ",");
			
			//TODO: create cases instead of displaying
			for(int i=0; i<data.size(); ++i){
				String caseType = data.get(i)[0];
				if(caseType.compareTo("P") == 0){
					System.out.println("Propriété :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
					
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
					System.out.println(nomCarreau);
					
				}
				else if(caseType.compareTo("G") == 0){
					System.out.println("Gare :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
				}
				else if(caseType.compareTo("C") == 0){
					System.out.println("Compagnie :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
				}
				else if(caseType.compareTo("CT") == 0){
					System.out.println("Case Tirage :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
				}
				else if(caseType.compareTo("CA") == 0){
					System.out.println("Case Argent :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
				}
				else if(caseType.compareTo("CM") == 0){
					System.out.println("Case Mouvement :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
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

	

	public Joueur[] getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(Joueur[] joueurs) {
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

			
}


