package it.univaq.oosd.ecotoll;

public class Casello implements Comparable<Casello> {

	Autostrada autostrada;
	String nome;
	double kilometro;

	public Casello(String nome, double kilometro) {

		this.nome = nome;
		this.kilometro = kilometro;
	}

	public Autostrada getAutostrada() { return autostrada; }

	public void setAutostrada(Autostrada autostrada) { this.autostrada = autostrada; }

	public String getNome() { return nome; }

	public void setNome(String nome) { this.nome = nome; }

	public double getKilometro() { return kilometro; }

	public void setKilometro(double kilometro) { this.kilometro = kilometro; }

	public boolean equals(Object o) {
		if (o instanceof Casello) {
			Casello c = (Casello) o;
			return this.nome.equals(c.nome) && this.autostrada.equals(c.autostrada);
		} else {
			return false;
		}
	}

	public int compareTo(Casello c) {

		return (int) (c.kilometro - this.kilometro);
	}
}