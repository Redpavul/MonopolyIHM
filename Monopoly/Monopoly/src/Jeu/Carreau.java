package Jeu;

import Jeu.Monopoly;

public abstract class Carreau
{

	private Monopoly monopoly;
	private int numeroCarreau;
	private String nomCarreau;
	
	public Carreau(String nomCarreau, int numeroCarreau)
	{
		this.numeroCarreau = numeroCarreau;
		this.nomCarreau = nomCarreau;		
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

}