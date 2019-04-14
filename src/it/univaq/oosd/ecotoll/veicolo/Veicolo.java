package it.univaq.oosd.ecotoll.veicolo;

public abstract class Veicolo {

	private String marca;
	private String modello;
	private String targa;
	private byte numeroAssi;
	private short altezzaCentimetri;
	private ClasseAmbientale classeAmbientale;

	public enum ClasseAmbientale {
		EURO_0,
		EURO_1,
		EURO_2,
		EURO_3,
		EURO_4,
		EURO_5,
		EURO_6,	
	}

	public Veicolo(String marca, String modello, String targa, byte numeroAssi,
				   short altezzaCentimetri, ClasseAmbientale classeAmbientale) {
		this.marca = marca;
		this.modello = modello;
		this.targa = targa;
		this.numeroAssi = numeroAssi;
		this.altezzaCentimetri = altezzaCentimetri;
		this.classeAmbientale = classeAmbientale;
	}

	public String getMarca() { return marca; }

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public byte getNumeroAssi() {
		return numeroAssi;
	}

	public void setNumeroAssi(byte numeroAssi) {
		this.numeroAssi = numeroAssi;
	}

	public short getAltezzaCentimetri() {
		return altezzaCentimetri;
	}

	public void setAltezzaCentimetri(short altezzaCentimetri) {
		this.altezzaCentimetri = altezzaCentimetri;
	}

	public ClasseAmbientale getClasseAmbientale() {
		return classeAmbientale;
	}

	public void setClasseAmbientale(ClasseAmbientale classeAmbientale) {
		this.classeAmbientale = classeAmbientale;
	}

	public boolean isClasseA() {
		return this instanceof VeicoloClasseA;
	}

	public boolean isClasseB() {
		return this instanceof VeicoloClasseB;
	}

	public boolean isClasse3() {
		return this instanceof VeicoloClasse3;
	}

	public boolean isClasse4() {
		return this instanceof VeicoloClasse4;
	}

	public boolean isClasse5() {
		return this instanceof VeicoloClasse5;
	}
}