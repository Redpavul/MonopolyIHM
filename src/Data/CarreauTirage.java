package Data;

import Jeu.Monopoly;

public class CarreauTirage extends CarreauAction {

    public CarreauTirage(String nom, int num) {
	super(nom, num);
    }

    public void action() {
	String nom = getNomCarreau();
	if (nom == "Chance") {
	    while (effetChance(getMonopoly().getPositionChance())) {
		getMonopoly().setPositionChance(getMonopoly().getPositionChance() + 1);
		if (getMonopoly().getPositionChance() > getMonopoly().getNbDeCarteChance()) {
		    getMonopoly().setPositionChance(1);
		}
	    }
	} else {
	    while (effetCaisse(getMonopoly().getPositionCaisse())) {
		getMonopoly().setPositionCaisse(getMonopoly().getPositionCaisse() + 1);
		if (getMonopoly().getPositionCaisse() > getMonopoly().getNbDeCarteCaisse()) {
		    getMonopoly().setPositionCaisse(1);
		}
	    }
	}
    }

    public boolean effetChance(int id) {
	boolean ok = true;
	if (id == 1) {
	    ok = effet0();
	} else if (id == 2) {
	    effet0();
	} else if (id == 3) {
	    effet0();
	} else if (id == 4) {
	    effet0();
	} else if (id == 5) {
	    effet0();
	} else if (id == 6) {
	    effet0();
	} else if (id == 7) {
	    effet0();
	} else if (id == 8) {
	    effet0();
	} else if (id == 9) {
	    effet0();
	} else if (id == 10) {
	    effet0();
	} else if (id == 11) {
	    effet0();
	} else if (id == 12) {
	    effet0();
	} else if (id == 13) {
	    effet0();
	} else if (id == 14) {
	    effet0();
	} else if (id == 15) {
	    effet0();
	} else if (id == 16) {
	    effet0();
	}
	return ok;
    }

    public boolean effetCaisse(int id) {
	boolean ok = true;
	if (id == 1) {
	    ok = effet0();
	} else if (id == 2) {
	    effet0();
	} else if (id == 3) {
	    effet0();
	} else if (id == 4) {
	    effet0();
	} else if (id == 5) {
	    effet0();
	} else if (id == 6) {
	    effet0();
	} else if (id == 7) {
	    effet0();
	} else if (id == 8) {
	    effet0();
	} else if (id == 9) {
	    effet0();
	} else if (id == 10) {
	    effet0();
	} else if (id == 11) {
	    effet0();
	} else if (id == 12) {
	    effet0();
	} else if (id == 13) {
	    effet0();
	} else if (id == 14) {
	    effet0();
	} else if (id == 15) {
	    effet0();
	} else if (id == 16) {
	    effet0();
	}
	return ok;
    }

    public boolean effet0() {
	return false;
    }

    public boolean effetChance1()
    {
	if (getMonopoly().getCarteSortieDePrisonChance()) {
	    System.out.println("Vous recevez une carte sortie de Prison");
	    Joueur j = getMonopoly().getJoueurs().getFirst();
	    j.setCarteSortieDePrison(j.getCarteSortieDePrison() + 1);
	    System.out.println("vous �tes lib�r� de prison. Cette carte peut �tre conserv�e jusqu'� ce qu'elle soit utilis�e.");
	    getMonopoly().setCarteSortieDePrisonChance(false);
	    return true;
	} else {
	    return false;
	}

    }

    public void effetChance2()
    {
	System.out.println("Reculez de trois cases.");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setPositionCourante(getMonopoly().getListCarreaux()[j.getPositionCourante().getNumeroCarreau()-3]);
	    }

    public void effetChance3() {
	System.out.println("Vous �tes impos�s pour les r�parations de voirie � raison de :");
	System.out.println("  -40� par maison");
	System.out.println("  -115� par h�tel");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	int nbMaison = 0;
	int nbHotel = 0;
	for (ProprieteAConstruire pro : j.getProprietes()) {
	    nbMaison = nbMaison + pro.getNbMaisons();
	    nbHotel = nbHotel + pro.getNbHotels();
	}
	int aPayer = nbMaison * 40 + nbHotel * 115;
	System.out.println("");
	System.out.println("Vous devez payer " + aPayer + "�");
	j.setCash(j.getCash() - aPayer);
    }

    public void effetChance4() {
	System.out.println("Amende pour exc�s de vitesse 15�");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() - 15);
    }

    public void effetChance5() {
	System.out.println("Faites des r�parations :");
	System.out.println("  -25� par maison");
	System.out.println("  -100� par h�tel");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	int nbMaison = 0;
	int nbHotel = 0;
	for (ProprieteAConstruire pro : j.getProprietes()) {
	    nbMaison = nbMaison + pro.getNbMaisons();
	    nbHotel = nbHotel + pro.getNbHotels();
	}
	int aPayer = nbMaison * 25 + nbHotel * 100;
	System.out.println("");
	System.out.println("Vous devez payer " + aPayer + "�");
	j.setCash(j.getCash() - aPayer);
    }

    public void effetChance6() {
	System.out.println("Amende pour ivresse 20�");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() - 20);
    }

    public void effetChance7() {
	System.out.println("Avancer jusqu'� la case D�part");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setPositionCourante(getMonopoly().getListCarreaux()[40 - j.getPositionCourante().getNumeroCarreau()]);
    }

    public void effetChance8() {
	System.out.println("Aller en prison, ne passez pas par la case D�part");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setPrison(true);//fonction qui fait avancer un joueur directement � la case d�part.
    }

    public void effetChance9() {
	System.out.println("Rendez-vous � l'Avenue Henri-Martin");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	if (25 - j.getPositionCourante().getNumeroCarreau() > 0) {
	    j.setPositionCourante(getMonopoly().getListCarreaux()[25 - j.getPositionCourante().getNumeroCarreau()]);
			} else {
	    j.setPositionCourante(getMonopoly().getListCarreaux()[40 + 25 - j.getPositionCourante().getNumeroCarreau()]);
			}
    }

    public void effetChance10() {
	System.out.println("Rendez-vous � la gare de Lyon");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	if (16 - j.getPositionCourante().getNumeroCarreau() > 0) {
	    j.setPositionCourante(getMonopoly().getListCarreaux()[16 - j.getPositionCourante().getNumeroCarreau()]);
			} else {
	    j.setPositionCourante(getMonopoly().getListCarreaux()[40 + 16 - j.getPositionCourante().getNumeroCarreau()]);
			}
    }

    public void effetChance11() {
	System.out.println("Payer pour frais de scolarit� 150�");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() - 150);
    }

    public void effetChance12() {
	System.out.println("Vous avez gagnez le prix de mots crois�s. Recevez 100�");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() + 100);
    }

    public void effetChance13() {
	System.out.println("La Banque vous verse un dividende de 50�");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() + 50);
    }

    public void effetChance14() {
	System.out.println("Rendez-vous � la Rue de la Paix.");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	if (39 - j.getPositionCourante().getNumeroCarreau() > 0) {
	    j.setPositionCourante(getMonopoly().getListCarreaux()[39 - j.getPositionCourante().getNumeroCarreau()]);
			} else {
	    j.setPositionCourante(getMonopoly().getListCarreaux()[40 + 39 - j.getPositionCourante().getNumeroCarreau()]);
			}
    }

    public void effetChance15() {
	System.out.println("Votre immeuble et votre pr�t rapportent. Vous devez toucher 150�");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() + 150);
    }

    public void effetChance16() {
	System.out.println("Acc�dez au Boulevard de la Villette.");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	if (12 - j.getPositionCourante().getNumeroCarreau() > 0) {
	    j.setPositionCourante(getMonopoly().getListCarreaux()[12 - j.getPositionCourante().getNumeroCarreau()]);
			} else {
	    j.setPositionCourante(getMonopoly().getListCarreaux()[40 + 12 - j.getPositionCourante().getNumeroCarreau()]);
			}

    }

    public boolean effetCaisse1() {
	if (getMonopoly().getCarteSortieDePrisonCaisse()) {
	    System.out.println("Vous recevez une carte sortie de Prison");
	    Joueur j = getMonopoly().getJoueurs().getFirst();
	    j.setCarteSortieDePrison(j.getCarteSortieDePrison() + 1);
	    System.out.println("vous �tes lib�r� de prison. Cette carte peut �tre conserv�e jusqu'� ce qu'elle soit utilis�e.");
	    getMonopoly().setCarteSortieDePrisonCaisse(false);
	    return true;
	} else {
	    return false;
	}

    }

    public void effeCaisset2() {
	System.out.println("Payer une amende de 10�");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() - 10);
    }

    public void effetCaisse3() {
	System.out.println("C'est votre anniversaire, chaque joueur doit vous donner 10�");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	Monopoly m = getMonopoly();
	for (Joueur joueur : getMonopoly().getJoueurs()) {
	    if (joueur != j) {
		int arg=joueur.getCash();
		if(arg>=10){
			joueur.setCash(joueur.getCash()-10);
			j.setCash(j.getCash()+10);
		}else{
			joueur.setCash(joueur.getCash()-arg);
			j.setCash(j.getCash()+arg);
		}
	    }
	}
    }

    public void effetCaisse4() {
	System.out.println("Erreur de la banque en votre faveur, recevez 200�");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() + 200);
    }

    public void effetCaisse5() {
	System.out.println("Retournez � Belleville");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	if (2 - j.getPositionCourante().getNumeroCarreau() > 0) {
		j.setPositionCourante(getMonopoly().getListCarreaux()[2 - j.getPositionCourante().getNumeroCarreau()]);
	} else {
		j.setPositionCourante(getMonopoly().getListCarreaux()[40 + 2 - j.getPositionCourante().getNumeroCarreau()]);
	}
    }

    public void effetCaisse6() {
	System.out.println("Payez la note du m�decin 50�");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() - 50);
    }

    public void effetCaisse7() {
	System.out.println("Les contributions vous remboursent la somme de 20�");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() + 20);
    }

    public void effetCaisse8() {
	System.out.println("Payez � l'h�pital 100�");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() - 100);
    }

    public void effetCaisse9() {
	System.out.println("Vous h�ritez : 100�");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() + 20);
    }

    public void effetCaisse10() {
	System.out.println("Aller en prison, ne passez pas par la case D�part");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setPrison(true);//fonction qui fait avancer un joueur directement � la case d�part.
    }

    public void effetCaisse11() {
	System.out.println("Payer votre Police d'Assurance : 50�");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() - 50);
    }

    public void effetCaisse12() {
	System.out.println("La vente de votre stock vous rapporte 50�");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() + 50);
    }

    public void effetCaisse13() {
	System.out.println("Avancer jusqu'� la case D�part");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setPositionCourante(getMonopoly().getListCarreaux()[40 - j.getPositionCourante().getNumeroCarreau()]);
    }

    public void effetCaisse14() {
	System.out.println("Recevez votre int�r�t sur l'emprunt � 7% : 25�");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() + 25);
    }

    public void effetCaisse15() {
	System.out.println("Recevez votre revenu annuel : 100�");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() + 100);
    }

    public void effetCaisse16() {
	System.out.println("Vous avez gagn� le deuxi�me prix de beaut�: recevez 10�");
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() + 10);
    }
}
