package Data;

import java.util.Scanner;

import Jeu.Monopoly;


public class Gare extends CarreauPropriete
{
        private int montant ;

	public Gare(int prixAchat, String nomCarreau, int numeroCarreau,Monopoly monopoly)
	{
		super(prixAchat, nomCarreau, numeroCarreau,monopoly);
                prixAchat = 200;
	}
	
	public void calculLoyerGare() {
		Joueur jProprio = getProprietaire();
		int nb = jProprio.getGares().size();
		int p = nb * 50;
		print(jProprio + " est proprietaire de " + nb + " gares, vous devez donc lui payer " + p + " €", monopoly);
		Joueur j = monopoly.getJoueurs().getFirst();
		int c = j.getCash();
		int total = c - p;
                montant = p;
		print("Il vous restera " + total + " €", monopoly); 
		j.setCash(j.getCash()-p);
		jProprio.setCash(jProprio.getCash()+p);
	}
        
        


        
	public void acheterPropriete(Joueur j){
		int prix;
	boolean bon = true;
	Scanner sca = new Scanner(System.in);
	    prix = this.getPrixAchat();
	    if (j.getCash() >= prix) {

		    String choix = monopoly.getInterf().getIhm().getInfos().boiteMessage("joueur " + j.getNomJoueur() + " voulez vous acheter la gare " +
                    this.getNomCarreau() + " pour un prix de " + prixAchat + " ? (oui/non)");
		    if (choix.contentEquals("oui")) {
			bon = false;
			payer(j, prix);
			setProprietaire(j);
			j.getGares().add(this);
		    } else if (choix.contentEquals("non")) {
			bon = true;
		    
		}

	    }
	} 
	public void payerLoyer(Joueur j) 
	{
	    Joueur j2 = this.getProprietaire();
	    
	    if (j != j2) {
                calculLoyerGare();
		print("joueur " + j.getNomJoueur() + " vous êtes arrivé sur la " + this.getNomCarreau() + " qui appartiens a " + j2.getNomJoueur() + " vous lui devez " + montant + "€ ", monopoly);
		
	    }

	}

    }
        
        
