package Data;

import Jeu.Monopoly;

public class Carreau
{

	protected Monopoly monopoly;
	private int numeroCarreau;
	private String nomCarreau;

	public Carreau(String nomCarreau, int numeroCarreau,Monopoly monopoly)
	{
		this.numeroCarreau = numeroCarreau;
		this.nomCarreau = nomCarreau;
		this.monopoly=monopoly;
		
	}

	public int getNumeroCarreau()
	{
		return numeroCarreau;
	}

	public void setNumeroCarreau(int numeroCarreau)
	{
		this.numeroCarreau = numeroCarreau;
	}

	public String getNomCarreau()
	{
		return nomCarreau;
	}

	public void setNomCarreau(String nomCarreau)
	{
		this.nomCarreau = nomCarreau;
	}
	public Monopoly getMonopoly()
	{
		return monopoly;
	}

	public void setMonopoly(Monopoly mono)
	{
		this.monopoly = mono;
	}
	public void print(String str,Monopoly monopoly){
		monopoly.getInterf().getIhm().getInfos().addlogs(str);
	}
}
