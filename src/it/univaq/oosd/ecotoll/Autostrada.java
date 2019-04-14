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
			casello.setAutostrada(this);
			this.caselli.add(casello);
		}
	}

	public Autostrada addCasello(Casello c) {
		this.caselli.add(c);
		c.setAutostrada(this);
		return this;
	}

	public double getTariffaVeicolo(Veicolo veicolo) {
		if (veicolo.isClasseA()) {
			return getTariffaVeicoloClasseA(veicolo);
		} else if (veicolo.isClasseB()) {
			return getTariffaVeicoloClasseB(veicolo);
		} else if (veicolo.isClasse3()) {
			return getTariffaVeicolo3Assi(veicolo);
		} else if(veicolo.isClasse4()) {
			return getTariffaVeicolo4Assi(veicolo);
		} else {
			return getTariffaVeicolo5Assi(veicolo);
		}
	}

	private double getTariffaVeicoloClasseA(Veicolo veicolo) {
		if (this.tipo == Tipologia.MONTAGNA)
			return this.tariffeMontagna[0];
		else
			return this.tariffePianura[0];
	}

	private double getTariffaVeicoloClasseB(Veicolo veicolo) {
		if (this.tipo == Tipologia.MONTAGNA)
			return this.tariffeMontagna[1];
		else
			return this.tariffePianura[1];
	}

	private double getTariffaVeicolo3Assi(Veicolo veicolo) {
		if (this.tipo == Tipologia.MONTAGNA)
			return this.tariffeMontagna[2];
		else
			return this.tariffePianura[2];
	}

	private double getTariffaVeicolo4Assi(Veicolo veicolo) {
		if (this.tipo == Tipologia.MONTAGNA)
			return this.tariffeMontagna[3];
		else
			return this.tariffePianura[3];
	}

	private double getTariffaVeicolo5Assi(Veicolo veicolo) {
		if (this.tipo == Tipologia.MONTAGNA)
			return this.tariffeMontagna[4];
		else
			return this.tariffePianura[4];
	}

	public boolean equals(Object o) {
		if (o instanceof Autostrada) {
			Autostrada a = (Autostrada) o;
			return this.nome.equals(a.nome) && this.caselli.equals(a.caselli);
		} else return false;
	}
}