package it.univaq.oosd.ecotoll.pedaggio;

import it.univaq.oosd.ecotoll.Casello;
import it.univaq.oosd.ecotoll.veicolo.Veicolo;

public interface Pedaggio {

    public static final double IVA = 0.22;

    public double calcola(Veicolo veicolo, Casello entrata, Casello uscita) throws Exception;
}
