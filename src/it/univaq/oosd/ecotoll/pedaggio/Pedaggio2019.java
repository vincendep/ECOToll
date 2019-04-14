package it.univaq.oosd.ecotoll.pedaggio;

import it.univaq.oosd.ecotoll.Autostrada;
import it.univaq.oosd.ecotoll.Casello;
import it.univaq.oosd.ecotoll.exception.PercorsoException;
import it.univaq.oosd.ecotoll.veicolo.Veicolo;

public class Pedaggio2019 implements Pedaggio {

	public double calcola(Veicolo veicolo, Casello entrata, Casello uscita) throws Exception {

		// calcola il pedaggio solo se il percorso è contenuto in un'unica autostrada
		Autostrada autostrada = entrata.getAutostrada();
		if (! entrata.getAutostrada().equals(uscita.getAutostrada()) || entrata.equals(uscita)) {
			throw new PercorsoException();
		}

		double kilometri = Math.abs(uscita.getKilometro() - entrata.getKilometro());
		double tariffa = autostrada.getTariffaVeicolo(veicolo);
		double costo = tariffa * kilometri;
		double costoTassato = costo + costo * IVA;

		return Math.round(costoTassato * 10) / 10d;
	}
}