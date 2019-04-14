package it.univaq.oosd.ecotoll.client;

import it.univaq.oosd.ecotoll.Autostrada;
import it.univaq.oosd.ecotoll.Casello;
import it.univaq.oosd.ecotoll.pedaggio.Pedaggio2019;
import it.univaq.oosd.ecotoll.veicolo.AbstractFactory;
import it.univaq.oosd.ecotoll.veicolo.VeicoloFactory;
import it.univaq.oosd.ecotoll.pedaggio.Pedaggio;
import it.univaq.oosd.ecotoll.veicolo.Veicolo;

import java.util.ArrayList;
import java.util.List;

class ClientTest {

	// tariffe Autostrade per l'Italia
	private static double[] TARIFFE_PIANURA = {0.07231, 0.07401, 0.09826, 0.14864, 0.17530};
	private static double[] TARIFFE_MONTAGNA = {0.08547, 0.08749, 0.11414, 0.17426, 0.20629};

	private static AbstractFactory factory;
	private static Pedaggio pedaggio;
	private static List<Veicolo> veicoli;
	private static List<Autostrada> autostrade;

	public static void main(String argv[]) throws Exception{

		init();

		for (int j = 0; j < veicoli.size(); j++) {
			Veicolo veicolo = veicoli.get(j);

			for (int i = 0; i < autostrade.size(); i++) {
				Autostrada autostrada = autostrade.get(i);

				for (int n = 0; n < autostrada.getCaselli().size(); n++) {
					Casello entrata = autostrada.getCaselli().get(n);

					for (int m = n + 1; m < autostrada.getCaselli().size(); m++) {
						Casello uscita = autostrada.getCaselli().get(m);
						int kilometriPercorsi = (int) Math.round(Math.abs(entrata.getKilometro() - uscita.getKilometro()));
						double costoPedaggio = pedaggio.calcola(veicolo, entrata, uscita);

						System.out.println(veicolo.getMarca() + " " + veicolo.getModello() + " - from: "
								+ entrata.getNome() + " to " + uscita.getNome() + " - costo: " + costoPedaggio
								+ " euro - distanza: " + kilometriPercorsi + " km");
					}
				}
				System.out.println("\n" + "-----------------------" + "\n");
			}
		}
	}

	public static void init() {

		factory = new VeicoloFactory();
		pedaggio = new Pedaggio2019();
		autostrade = new ArrayList<>();
		veicoli = new ArrayList<>();

		veicoli.add(factory.creaVeicolo("Ford", "Fiesta", "XX456ZZ", (byte) 2, (short) 120, Veicolo.ClasseAmbientale.EURO_5));
		veicoli.add(factory.creaVeicolo("Scania", "R730", "EE999KK", (byte) 4, (short) 400, Veicolo.ClasseAmbientale.EURO_4));

		Autostrada A24 = new Autostrada("A24", Autostrada.Tipologia.MONTAGNA, TARIFFE_PIANURA, TARIFFE_MONTAGNA);
		A24.addCasello(new Casello("Teramo", 146.1))
			.addCasello(new Casello("Colledara", 136.6))
			.addCasello(new Casello("Assergi", 116.8))
			.addCasello(new Casello("L'Aquila Est", 106.7))
			.addCasello(new Casello("L'Aquila Ovest", 101));
		autostrade.add(A24);

		Autostrada A14 = new Autostrada("A14", Autostrada.Tipologia.PIANURA, TARIFFE_PIANURA, TARIFFE_MONTAGNA);
		A14.addCasello(new Casello("Roseto", 344))
			.addCasello(new Casello("Pineto", 352))
			.addCasello(new Casello("Città Sant'Angelo", 364))
			.addCasello(new Casello("Chieti", 380))
			.addCasello(new Casello("Francavilla", 393));
		autostrade.add(A14);
	}
}