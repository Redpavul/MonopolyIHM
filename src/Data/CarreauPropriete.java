package Data;

import Jeu.Monopoly;


public abstract class CarreauPropriete extends Carreau
{

	private Joueur proprietaire;

	protected int prixAchat;
        protected int loyer;

	
    public CarreauPropriete(int prixAchat, String nomCarreau, int numeroCarreau,Monopoly monopoly)
    {
		super(nomCarreau, numeroCarreau,monopoly);
		this.prixAchat = prixAchat;
    }

    public Joueur getProprietaire() {
	return proprietaire;
    }

    public void setProprietaire(Joueur proprietaire) {
	this.proprietaire = proprietaire;
    }

    public int getPrixAchat() {
	return prixAchat;
    }

    public void setPrixAchat(int prixAchat) {
	this.prixAchat = prixAchat;
    }
    
    public abstract void acheterPropriete(Joueur j);
    
    public abstract void payerLoyer(Joueur j);
    
    public void payer(Joueur j, int montant) {
	
	//CarreauPropriete c = (CarreauPropriete) this.listCarreaux[j.getPositionCourante().getNumeroCarreau() - 1];
    if (this.getProprietaire() == null) {
        if (j.getCash() >= montant) {

		print("Vous devez " + montant + "€ à la banque !", monopoly);
		j.setCash(j.getCash()-montant);
	    }
	} else {
	    Joueur j2 = this.getProprietaire();
	    if (j.getCash() <= montant && j != j2) {
		print("\nVous n'avez pas assez d'argent pour payer, vous avez perdu ! Vous avez pu payer " + j.getCash() + "€ à " + j2.getNomJoueur() + "\n", monopoly);
                j2.setCash(j2.getCash()+j.getCash());
		monopoly.getJoueurs().removeFirst();
	    } else if (j != j2) {
		j.setCash(j.getCash()-montant);
                j2.setCash(j2.getCash()+montant);

	    }
	}

    }

}