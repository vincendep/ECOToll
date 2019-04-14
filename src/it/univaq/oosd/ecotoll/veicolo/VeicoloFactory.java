package it.univaq.oosd.ecotoll.veicolo;

import it.univaq.oosd.ecotoll.veicolo.Veicolo.ClasseAmbientale;

public class VeicoloFactory extends AbstractFactory {

    @Override
    public Veicolo creaVeicolo(String marca, String modello, String targa, byte numeroAssi, short altezzaCentimetri, ClasseAmbientale classeAmbientale) {

        Veicolo veicolo;
        if (numeroAssi == 2) {
            if (altezzaCentimetri <= 130) {
                veicolo = new VeicoloClasseA(marca, modello, targa, numeroAssi, altezzaCentimetri, classeAmbientale);
            } else {
                veicolo = new VeicoloClasseB(marca, modello, targa, numeroAssi, altezzaCentimetri, classeAmbientale);
            }
        } else if (numeroAssi == 3) {
            veicolo = new VeicoloClasse3(marca, modello, targa, numeroAssi, altezzaCentimetri, classeAmbientale);
        } else if (numeroAssi == 4) {
            veicolo = new VeicoloClasse4(marca, modello, targa, numeroAssi, altezzaCentimetri, classeAmbientale);
        } else {
            veicolo = new VeicoloClasse5(marca, modello, targa, numeroAssi, altezzaCentimetri, classeAmbientale);
        }
        return  veicolo;
    }
}
