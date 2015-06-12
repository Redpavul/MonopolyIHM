package Data;

import Jeu.Monopoly;

public class CarreauTirage extends CarreauAction {

    public CarreauTirage(String nom, int num, Monopoly monopoly) {
	super(nom, num, monopoly);

    }

    public void action() {
	String nom = getNomCarreau();
	if (nom.equalsIgnoreCase("Chance")) {
	    while (!effetChance(getMonopoly().getTabChance()[getMonopoly().getPositionChance()])) {
		getMonopoly().setPositionChance(getMonopoly().getPositionChance() + 1);
		if (getMonopoly().getPositionChance() > getMonopoly().getNbDeCarteChance()) {
		    getMonopoly().setPositionChance(1);
		}
	    }
	} else {
	    while (!effetCaisse(getMonopoly().getTabCaisse()[getMonopoly().getPositionCaisse()])) {
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
	    ok = effetChance1();
	} else if (id == 2) {
	    effetChance2();
	} else if (id == 3) {
	    effetChance3();
	} else if (id == 4) {
	    effetChance4();
	} else if (id == 5) {
	    effetChance5();
	} else if (id == 6) {
	    effetChance6();
	} else if (id == 7) {
	    effetChance7();
	} else if (id == 8) {
	    effetChance8();
	} else if (id == 9) {
	    effetChance9();
	} else if (id == 10) {
	    effetChance10();
	} else if (id == 11) {
	    effetChance11();
	} else if (id == 12) {
	    effetChance12();
	} else if (id == 13) {
	    effetChance13();
	} else if (id == 14) {
	    effetChance14();
	} else if (id == 15) {
	    effetChance15();
	} else if (id == 16) {
	    effetChance16();
	}
	return ok;
    }

    public boolean effetCaisse(int id) {
	boolean ok = true;
	if (id == 1) {
	    ok = effetCaisse1();
	} else if (id == 2) {
	    effetCaisse2();
	} else if (id == 3) {
	    effetCaisse3();
	} else if (id == 4) {
	    effetCaisse4();
	} else if (id == 5) {
	    effetCaisse5();
	} else if (id == 6) {
	    effetCaisse6();
	} else if (id == 7) {
	    effetCaisse7();
	} else if (id == 8) {
	    effetCaisse8();
	} else if (id == 9) {
	    effetCaisse9();
	} else if (id == 10) {
	    effetCaisse10();
	} else if (id == 11) {
	    effetCaisse11();
	} else if (id == 12) {
	    effetCaisse12();
	} else if (id == 13) {
	    effetCaisse13();
	} else if (id == 14) {
	    effetCaisse14();
	} else if (id == 15) {
	    effetCaisse15();
	} else if (id == 16) {
	    effetCaisse16();
	}
	return ok;
    }

    public boolean effet0() {
	return false;
    }

    public boolean effetChance1() {
	if (getMonopoly().getCarteSortieDePrisonChance()) {
	    print("Vous recevez une carte sortie de Prison", monopoly);
	    Joueur j = getMonopoly().getJoueurs().getFirst();
	    j.setCarteSortieDePrison(j.getCarteSortieDePrison() + 1);
	    print("Cette carte peut être conservée jusqu'à ce qu'elle soit utilisée.", monopoly);
	    getMonopoly().setCarteSortieDePrisonChance(false);
	    return true;
	} else {
	    return false;
	}

    }

    public void effetChance2() {
	print("Reculez de trois cases.", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	if (j.getPositionCourante().getNumeroCarreau() > 2) {
	    j.setPositionCourante(getMonopoly().getListCarreaux()[j.getPositionCourante().getNumeroCarreau() - 3]);
	} else {
	    j.setPositionCourante(getMonopoly().getListCarreaux()[j.getPositionCourante().getNumeroCarreau() + 37]);

	    print("Vous passez par la case dépar et recevez 200€", monopoly);
	    j.setCash(j.getCash() + 200);
	}
    }

    public void effetChance3() {
	print("Vous êtes imposés pour les réparations de voirie à raison de :", monopoly);
	print("  -40€ par maison", monopoly);
	print("  -115€ par hôtel", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	int nbMaison = 0;
	int nbHotel = 0;
	for (ProprieteAConstruire pro : j.getProprietes()) {
	    nbMaison = nbMaison + pro.getNbMaisons();
	    nbHotel = nbHotel + pro.getNbHotels();
	}
	int aPayer = nbMaison * 40 + nbHotel * 115;
	
	print("Vous devez payer " + aPayer + "à", monopoly);
	j.setCash(j.getCash() - aPayer);
    }

    public void effetChance4() {
	print("Amende pour excès de vitesse 15€", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() - 15);
    }

    public void effetChance5() {
	print("Faites des réparations :", monopoly);
	print("  -25€ par maison", monopoly);
	print("  -100€ par hôtel", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	int nbMaison = 0;
	int nbHotel = 0;
	for (ProprieteAConstruire pro : j.getProprietes()) {
	    nbMaison = nbMaison + pro.getNbMaisons();
	    nbHotel = nbHotel + pro.getNbHotels();
	}
	int aPayer = nbMaison * 25 + nbHotel * 100;

	print("Vous devez payer " + aPayer + " à la banque", monopoly);
	j.setCash(j.getCash() - aPayer);
    }

    public void effetChance6() {
    	print("Amende pour ivresse 20€", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() - 20);
    }

    public void effetChance7() {
	print("Avancer jusqu'à la case Départ et recevez 200€", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setPositionCourante(getMonopoly().getListCarreaux()[40 - j.getPositionCourante().getNumeroCarreau()]);
	j.setCash(j.getCash()+200);
    }

    public void effetChance8() {
	print("Aller en prison, ne passez pas par la case Départ", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setPrison(true);//fonction qui fait avancer un joueur directement � la case d�part.
    }

    public void effetChance9() {
	print("Rendez-vous à l'Avenue Henri-Martin", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	if (25 - j.getPositionCourante().getNumeroCarreau() > 0) {
	    j.setPositionCourante(getMonopoly().getListCarreaux()[25 - j.getPositionCourante().getNumeroCarreau()]);
	} else {
	    j.setPositionCourante(getMonopoly().getListCarreaux()[40 + 25 - j.getPositionCourante().getNumeroCarreau()]);
		print("Vous passez par la case départ et recevez 200€", monopoly);
		j.setCash(j.getCash() + 200);
	}
    }

    public void effetChance10() {
	print("Rendez-vous à la gare de Lyon", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	if (16 - j.getPositionCourante().getNumeroCarreau() > 0) {
	    j.setPositionCourante(getMonopoly().getListCarreaux()[16 - j.getPositionCourante().getNumeroCarreau()]);
	} else {
	    j.setPositionCourante(getMonopoly().getListCarreaux()[40 + 16 - j.getPositionCourante().getNumeroCarreau()]);
		print("Vous passez par la case départ et recevez 200€", monopoly);
		j.setCash(j.getCash() + 200);
	}
    }

    public void effetChance11() {
	print("Payer pour frais de scolarité 150€", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() - 150);
    }

    public void effetChance12() {
	print("Vous avez gagnez le prix de mots croisés. Recevez 100€", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() + 100);
    }

    public void effetChance13() {
	print("La Banque vous verse un dividende de 50€", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() + 50);
    }

    public void effetChance14() {
	print("Rendez-vous à la Rue de la Paix.", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	if (39 - j.getPositionCourante().getNumeroCarreau() > 0) {
	    j.setPositionCourante(getMonopoly().getListCarreaux()[39 - j.getPositionCourante().getNumeroCarreau()]);
	} else {
	    j.setPositionCourante(getMonopoly().getListCarreaux()[40 + 39 - j.getPositionCourante().getNumeroCarreau()]);
		print("Vous passez par la case départ et recevez 200€", monopoly);
		j.setCash(j.getCash() + 200);
	}
    }

    public void effetChance15() {
	print("Votre immeuble et votre prêt rapportent. Vous devez toucher 150€", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() + 150);
    }

    public void effetChance16() {
	print("Accédez au Boulevard de la Villette.", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	if (12 - j.getPositionCourante().getNumeroCarreau() > 0) {
	    j.setPositionCourante(getMonopoly().getListCarreaux()[12 - j.getPositionCourante().getNumeroCarreau()]);
	} else {
	    j.setPositionCourante(getMonopoly().getListCarreaux()[40 + 12 - j.getPositionCourante().getNumeroCarreau()]);
		print("Vous passez par la case départ et recevez 200€", monopoly);
		j.setCash(j.getCash() + 200);
	}

    }

    public boolean effetCaisse1() {
	if (getMonopoly().getCarteSortieDePrisonCaisse()) {
	    print("Vous recevez une carte sortie de Prison", monopoly);
	    Joueur j = getMonopoly().getJoueurs().getFirst();
	    j.setCarteSortieDePrison(j.getCarteSortieDePrison() + 1);
	    print("Cette carte peut être conservée jusqu'à ce qu'elle soit utilisée.", monopoly);
	    getMonopoly().setCarteSortieDePrisonCaisse(false);
	    return true;
	} else {
	    return false;
	}

    }

    public void effetCaisse2() {
	print("Payer une amende de 10€", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() - 10);
    }

    public void effetCaisse3() {
	print("C'est votre anniversaire, chaque joueur doit vous donner 10€", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	for (Joueur joueur : getMonopoly().getJoueurs()) {
	    if (joueur != j) {
		int arg = joueur.getCash();
		if (arg >= 10) {
		    joueur.setCash(joueur.getCash() - 10);
		    j.setCash(j.getCash() + 10);
		} else {
		    joueur.setCash(joueur.getCash() - arg);
		    j.setCash(j.getCash() + arg);
		}
	    }
	}
    }

    public void effetCaisse4() {
	print("Erreur de la banque en votre faveur, recevez 200€", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() + 200);
    }

    public void effetCaisse5() {
	print("Retournez à Belleville", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	if (2 - j.getPositionCourante().getNumeroCarreau() > 0) {
	    j.setPositionCourante(getMonopoly().getListCarreaux()[2 - j.getPositionCourante().getNumeroCarreau()]);
	} else {
	    j.setPositionCourante(getMonopoly().getListCarreaux()[40 + 2 - j.getPositionCourante().getNumeroCarreau()]);
	}
    }

    public void effetCaisse6() {
	print("Payez la note du médecin 50€", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() - 50);
    }

    public void effetCaisse7() {
	print("Les contributions vous remboursent la somme de 20€", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() + 20);
    }

    public void effetCaisse8() {
	print("Payez à l'hôpital 100€", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() - 100);
    }

    public void effetCaisse9() {
	print("Vous héritez : 100€", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() + 20);
    }

    public void effetCaisse10() {
	print("Aller en prison, ne passez pas par la case Départ", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setPrison(true);//fonction qui fait avancer un joueur directement � la case d�part.
    }

    public void effetCaisse11() {
	print("Payer votre Police d'Assurance : 50€", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() - 50);
    }

    public void effetCaisse12() {
	print("La vente de votre stock vous rapporte 50€", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() + 50);
    }

    public void effetCaisse13() {
	print("Avancer jusqu'à la case Départ et recevez 200€", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setPositionCourante(getMonopoly().getListCarreaux()[40 - j.getPositionCourante().getNumeroCarreau()]);
	j.setCash(j.getCash() + 200);
    }

    public void effetCaisse14() {
	print("Recevez votre interêt sur l'emprunt à 7% : 25€", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() + 25);
    }

    public void effetCaisse15() {
	print("Recevez votre revenu annuel : 100€", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() + 100);
    }

    public void effetCaisse16() {
	print("Vous avez gagné le deuxième prix de beauté: recevez 10€", monopoly);
	Joueur j = getMonopoly().getJoueurs().getFirst();
	j.setCash(j.getCash() + 10);
    }

    public void afficherCommu() {
	print("1- Vous recevez une carte sortie de Prison", monopoly);
	print("2- Payer une amende de 10€", monopoly);
	print("3- C'est votre anniversaire, chaque joueur doit vous donner 10€", monopoly);
	print("4- Erreur de la banque en votre faveur, recevez 200€", monopoly);
	print("5- Retournez à Belleville", monopoly);
	print("6- Payez la note du médecin 50€", monopoly);
	print("7- Les contributions vous remboursent la somme de 20€", monopoly);
	print("8- Payez à l'hôpital 100€", monopoly);
	print("9- Vous héritez : 100€", monopoly);
	print("10- Aller en prison, ne passez pas par la case Départ", monopoly);
	print("11- Payer votre Police d'Assurance : 50€", monopoly);
	print("12- La vente de votre stock vous rapporte 50€", monopoly);
	print("13- Avancer jusqu'à la case Départ", monopoly);
	print("14- Recevez votre intérêt sur l'emprunt à 7% : 25€", monopoly);
	print("15- Recevez votre revenu annuel : 100€", monopoly);
	print("16- Vous avez gagne le deuxième prix de beauté: recevez 10€", monopoly);

    }

    public void afficherChance()
    {
	print("1- Vous recevez une carte sortie de Prison", monopoly);
	print("2- Reculez de trois cases.", monopoly);
	print("3- Vous êtes imposés pour les réparations de voirie à raison de :", monopoly);
	print("4- Amende pour excès de vitesse 15€", monopoly);
	print("5- Faites des réparations ", monopoly);
	print("6- Amende pour ivresse 20€", monopoly);
	print("7- Avancer jusqu'à la case Départ", monopoly);
	print("8- Aller en prison, ne passez pas par la case Départ", monopoly);
	print("9- Rendez-vous à l'Avenue Henri-Martin", monopoly);
	print("10- Rendez-vous à la gare de Lyon", monopoly);
	print("11- Payer pour frais de scolarité 150€", monopoly);
	print("12- Vous avez gagnez le prix de mots croisés. Recevez 100€", monopoly);
	print("13- La Banque vous verse un dividende de 50€", monopoly);
	print("14- Rendez-vous à la Rue de la Paix.", monopoly);
	print("15- Votre immeuble et votre prêt rapportent. Vous devez toucher 150€", monopoly);
	print("16- Accédez au Boulevard de la Villette.", monopoly);
    }
}
