package Data;

import Jeu.Monopoly;
import java.util.Scanner;

public class Compagnie extends CarreauPropriete {

    public Compagnie(int prixAchat, String nomCarreau, int numeroCarreau,Monopoly monopoly) {
	super(prixAchat, nomCarreau, numeroCarreau,monopoly);
	prixAchat = 150;
    }

    public void calculLoyerCompagnie() {
	Joueur jProprio = this.getProprietaire();
	int nb = jProprio.getCompagnies().size();
	Joueur j = monopoly.getJoueurs().getFirst();
	int des = j.getDes();
	int prix;
	if (nb == 1) {
	    prix = des * 4;
	} else {
	    prix = des * 10;
	}
	//System.out.println(jProprio + " possède " + nb + " compagnies, vous avez fait " + des + " aux dés, vous devez donc lui payer " + prix);
	loyer = prix;
	j.setCash(j.getCash() - prix);
	jProprio.setCash(jProprio.getCash() + prix);
    }




	public void acheterPropriete(Joueur j)
	{

	int prix;
	boolean bon = true;
	    prix = this.getPrixAchat();
	    if (j.getCash() >= prix) {
		

		    String choix = monopoly.getInterf().getIhm().getInfos().boiteMessage("joueur " + j.getNomJoueur() + " voulez vous acheter la gare " + this.getNomCarreau() + " pour un prix de " + prixAchat + " ? (oui/non)");
		    if (choix.contentEquals("oui")) {
			bon = false;
			payer(j, prix);
			setProprietaire(j);
			j.getCompagnies().add(this);
		    } else if (choix.contentEquals("non")) {
			bon = true;
		    }
		

	    }
	}
	    
	public void payerLoyer(Joueur j) 
	{
	    Joueur j2 = this.getProprietaire();

	    if (j != j2) {
		calculLoyerCompagnie();
		print("joueur " + j.getNomJoueur() + " vous êtes arrivé sur la " + this.getNomCarreau() + " qui appartiens a " + j2.getNomJoueur() + " vous lui devez " + loyer + "€ ",monopoly);

	    }

	}

    
}
