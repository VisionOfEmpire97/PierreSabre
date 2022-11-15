package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation;

	public Yakuza(String nom, String boissonFav, int argent, 
			String Clan, int reputation) {
		super(nom, boissonFav, argent);
		this.clan = Clan;
		this.reputation = reputation;
	}
	
	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int gain = victime.getArgent();
		this.gagnerArgent(victime.getArgent());
		victime.seFaireExtorquer();
		this.reputation += 1;
		parler("J’ai piqué les "+ gain + " sous de Marco, ce qui me fait "+ getArgent() + 
				" sous dans ma poche. Hi ! Hi !");
	}
}
