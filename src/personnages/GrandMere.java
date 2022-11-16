package personnages;
import java.security.SecureRandom;
import java.util.Random;

public class GrandMere extends Humain {
	TypeHumain[] types =TypeHumain.values();
	private Random rnd = new Random();
	
	private enum TypeHumain {
		HABITANT("Habitant"),COMMERCANT("Commerçant"),RONIN("Ronin"),
		SAMOURAI("Samourai"),YAKUZA("Yakuza"),GRANDMERE("Grand-Mère");
		private String nom;
		
		private TypeHumain(String nom) {
			this.nom = nom;
		}
//		public String toString() {
//			return nom;
//		}
	}

	public GrandMere(String nom, int argent) {
		super(nom, "tisane", argent);
		// TODO Auto-generated constructor stub
		this.nbConnaissanceMax = 5;
	}
	
	@Override
	protected void memoriser(Humain interlocuteur) {
		if (nbConnaissance < 5) {
			super.memoriser(interlocuteur);
		} else {
			parler("Oh ma tête ! Je ne peux plus retenir le nom d'une personne supplémentaire !");
		}
	}
	
	private String humainHasard() {
		String nomClasseHasard = types[rnd.nextInt(types.length)].nom;
		if ("Grand-Mère".equals(nomClasseHasard)) {
			return "une " + nomClasseHasard;
		}else {
			return "un " + nomClasseHasard;
		}
	}
	
	public void ragoter() {
		for (int i=0;i <nbConnaissance;i++) {
			if (memoire[i] instanceof Traitre) {
				parler("Je sais que " + memoire[i].getNom() + " est un traitre. Petit chenapan !");
			} else {
			parler("Je crois que " + memoire[i].getNom() + " est " + humainHasard());
			}
		};
		
	}
}
