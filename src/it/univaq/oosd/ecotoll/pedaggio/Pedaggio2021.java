package it.univaq.oosd.ecotoll.pedaggio;

import it.univaq.oosd.ecotoll.Casello;
import it.univaq.oosd.ecotoll.veicolo.Veicolo;

class Pedaggio2021 extends Pedaggio2019 {

    @Override
    public double calcola(Veicolo veicolo, Casello entrata, Casello uscita) throws Exception {
        if (!(veicolo.isClasseA())) {
            //TODO pedaggio 2021 con inquinamento
            return 0;
        } else {
           return super.calcola(veicolo, entrata, uscita);
        }
    }
}