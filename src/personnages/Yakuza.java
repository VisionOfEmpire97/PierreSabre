package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;

	public Yakuza(String nom, String boissonFav, int argent, 
			String Clan) {
		super(nom, boissonFav, argent);
		this.clan = Clan;
	}
	
	/**
	 * @return the reputation
	 */
	public int getReputation() {
		return reputation;
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mon clan est celui de " + clan + ".");
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
	

	protected int perdre() {
		int perte = getArgent();
		perdreArgent(getArgent());
		this.reputation -= 1;
		parler("J’ai perdu mon duel et mes " + perte +
				" sous, snif... J'ai déshonoré le clan de "+ clan);
		return perte;
	}
	
	protected void gagner(int gain) {
		gagnerArgent(gain);
		this.reputation += 1;
		parler("Ce ronin pensait vraiment battre " + getNom() + " du clan de "+ clan +  
				 "? Je l'ai dépouillé de ses "+ gain + " sous.");
	}
}
