package histoire;

import personnages.*;

public class HistoireTP4 {

	public static void main(String[] args) {
		Humain prof = new Humain("Prof","café",100);
		Commercant marco = new Commercant("Marco", 20);
		prof.direBonjour();
		marco.direBonjour();
		marco.seFaireExtorquer();
		marco.recevoir(15);
		prof.acheter("kombucha", 12);
		prof.boire("kombucha");
		prof.acheter("palanquin", 1000);

	}

}
