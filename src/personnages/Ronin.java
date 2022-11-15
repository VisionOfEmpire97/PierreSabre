package personnages;

public class Ronin extends Humain {
	private int honneur = 1;

	public Ronin(String nom, String boissonFav, int argent) {
		super(nom, boissonFav, argent);
	}
	public void donner(Commercant beneficiaire) {
		int sous = getArgent();
		int don = sous/10; //est-ce un entier?
		parler(beneficiaire.getNom() + ", prend ces " + don + " sous");
		beneficiaire.recevoir(don);
	}
	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		int force = 2 * this.honneur;
		if (force >= adversaire.getReputation()) {
			int gain = adversaire.perdre();
			gagnerArgent(gain);
			honneur += 1;
			parler("Je t’ai eu petit yakusa!");
		} else {
			adversaire.gagner(getArgent());
			perdreArgent(getArgent());
			honneur -= 1;
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
		}
	}
}
