package Data;

import Jeu.Monopoly;

public abstract class CarreauAction extends Carreau
{
	public CarreauAction(String nomCarreau, int numeroCarreau, Monopoly monopoly)
	{
		super(nomCarreau, numeroCarreau);
		   setMonopoly(monopoly);
	}
	public abstract void action();
}
