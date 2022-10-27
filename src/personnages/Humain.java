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
			parler("J'ai " + sousEnPoche + "" );
		}
	}
	
	public void gagnerArgent(int gain) {
		//TODO coder gain
	}
	
	public void perdreArgent(int perte) {
		//TODO coder perdre argent
	}
	
	private void parler(String texte) {
		System.out.println("(" + nom +") - " + "<< " + texte + " >>");
	}
	
	public static void main(String[] args) {
		Humain prof = new Humain("Prof","café",100);
		prof.direBonjour();
	}
}
