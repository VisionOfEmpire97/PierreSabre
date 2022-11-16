package personnages;

public class Humain {
	private String nom;
	private String boissonFav;
	private int argent;
	protected int nbConnaissance = 0;
	protected int nbConnaissanceMax = 30;
	protected Humain[] memoire = new Humain[nbConnaissanceMax];
	
	public Humain(String nom, String boissonFav, int argent) {
		this.nom = nom;
		this.boissonFav = boissonFav;
		this.argent = argent;
	}
	/**
	 * @return the name
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @return the money
	 */
	public int getArgent() {
		return argent;
	}
	
	public void direBonjour() {
		parler("Bonjour! Je m'appelle " + nom + " et j'aime boire du " + boissonFav);
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFav + " ! GLOUPS !");
	}
	
	public void acheter(String bien, int prix) {
		int sousEnPoche = this.getArgent();
		if (prix < sousEnPoche) {
			parler("J'ai " + sousEnPoche + " sous en poche. Je vais pouvoir m'offir " + bien + " à " + prix + " sous !" );
			perdreArgent(prix);
		} else {
			parler("Je n'ai plus que " + sousEnPoche + " sous en poche. Je ne peux même pas m'offrir un " + bien + " à " + prix + " sous.");
		}
	}
	
	protected void gagnerArgent(int gain) {
		this.argent += gain;
		/* décommenter pour tester*/
		//parler("J'ai à présent " + argent + " sous en poche.");
	}
	
	protected void perdreArgent(int perte) {
		this.argent -= perte;
		/* décommenter pour tester*/
		//parler("Il me reste " + argent + " sous en poche.");
	}
	
	protected void parler(String texte) {
		System.out.println("(" + nom +") - " + "<< " + texte + " >>");
	}
	
	protected void memoriser(Humain interlocuteur) {
		if (this.nbConnaissance < nbConnaissanceMax) {
			memoire[nbConnaissance] = interlocuteur;
			this.nbConnaissance += 1;
		} else {
			for (int i = 0; i < nbConnaissance-1; i++) {
				memoire[i] =memoire[i+1];
			}
			memoire[nbConnaissance-1] = interlocuteur;
		}
	}
	
	private void repondre(Humain premierMec) {
		direBonjour();
		memoriser(premierMec);
	}
	public void faireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		autreHumain.repondre(this);
		this.memoriser(autreHumain);
	}
	
	public void listerConnaissance() {
		String concat = "";
		for (int i = 0; i < nbConnaissance; i++) {
			concat += (memoire[i]).getNom();
			if ((i+1)<nbConnaissance ) concat += ", ";
		}
		parler("Je connais beacoup de monde dont : " + concat);
	}
}
