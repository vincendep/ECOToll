package it.univaq.oosd.ecotoll;

import it.univaq.oosd.ecotoll.veicolo.*;

import java.util.ArrayList;
import java.util.List;

public class Autostrada {
	
	private String nome;
	private Tipologia tipo;
	private List<Casello> caselli;
	private double[] tariffePianura;
	private double[] tariffeMontagna;

	public enum Tipologia {
		MONTAGNA,
		PIANURA
	}

	public Autostrada(String nome, Tipologia tipo, double[] tariffePianura, double[] tariffeMontagna) {
		this.nome = nome;
		this.tipo = tipo;
		this.tariffePianura = tariffePianura;
		this.tariffeMontagna = tariffeMontagna;
		this.caselli = new ArrayList<Casello>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Tipologia getTipo() {
		return tipo;
	}

	public void setTipo(Tipologia tipo) {
		this.tipo = tipo;
	}

	public List<Casello> getCaselli() {
		return caselli;
	}

	public void setCaselli(List<Casello> caselli) {
		this.caselli = caselli;
	}

	public double[] getTariffePianura() {
		return tariffePianura;
	}

	public void setTariffePianura(double[] tariffe) {
		this.tariffePianura = tariffe;
	}

	public double[] getTariffeMontagna() {return this.tariffeMontagna;}

	public void setTariffeMontagna(double[] tariffe) {this.tariffeMontagna = tariffe;}

	public void addCaselli(List<Casello> caselli) {
		for (Casello casello: caselli) {
			addCasello(casello);
		}
	}

	public Autostrada addCasello(Casello c) {
		this.caselli.add(c);
		c.setAutostrada(this);
		return this;
	}

	public double getTariffaVeicolo(Veicolo veicolo) {
		double[] tariffe;
		if (this.tipo == Tipologia.MONTAGNA) {
			tariffe = tariffeMontagna;
		} else {
			tariffe = tariffePianura;
		}

		if (veicolo.isClasseA()) {
			return tariffe[0];
		} else if (veicolo.isClasseB()) {
			return tariffe[1];
		} else if (veicolo.isClasse3()) {
			return tariffe[2];
		} else if(veicolo.isClasse4()) {
			return tariffe[3];
		} else {
			return tariffe[4];
		}
	}

	public boolean equals(Object o) {
		if (o instanceof Autostrada) {
			Autostrada a = (Autostrada) o;
			return this.nome.equals(a.nome) && this.caselli.equals(a.caselli);
		} else return false;
	}
}