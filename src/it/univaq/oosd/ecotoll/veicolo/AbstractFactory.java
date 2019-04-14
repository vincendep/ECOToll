package it.univaq.oosd.ecotoll.veicolo;

import it.univaq.oosd.ecotoll.veicolo.Veicolo;
import it.univaq.oosd.ecotoll.veicolo.Veicolo.ClasseAmbientale;

public abstract class AbstractFactory {

    public abstract Veicolo creaVeicolo(String marca, String modello, String targa, byte numeroAssi,
                                 short altezzaCentimetri, ClasseAmbientale classeAmbientale);
}
