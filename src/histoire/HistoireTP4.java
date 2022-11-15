package histoire;

import personnages.*;

public class HistoireTP4 {

	public static void main(String[] args) {
		//Humain prof = new Humain("Prof","café",100);
		Commercant marco = new Commercant("Marco", 20);
		Yakuza yaku = new Yakuza("Yaku Le Noir", "whisky", 30, "Nobunaga");
		Ronin roro = new Ronin("Roro", "shochu", 60);
		roro.provoquer(yaku);
	}

}
