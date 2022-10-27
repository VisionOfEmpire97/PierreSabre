package personnages;

public class Humain {
	private String nom;
	private String boissonFav;
	private int argent;
	
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
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boissonFav);
	}
	
	public void boire(String boisson) {
		parler("Mmmm, un bon verre de " + boisson + " ! GLOUPS !");
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
		parler("J'ai à présent " + argent + " sous en poche.");
	}
	
	protected void perdreArgent(int perte) {
		this.argent -= perte;
		parler("Il me reste " + argent + " sous en poche.");
	}
	
	protected void parler(String texte) {
		System.out.println("(" + nom +") - " + "<< " + texte + " >>");
	}
}
