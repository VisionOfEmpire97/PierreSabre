package personnages;

public class Commercant extends Humain {
	
	public Commercant(String nom, int argent) {
		super(nom, "thé", argent);
	}
	public int seFaireExtorquer() {
		this.perdreArgent(getArgent());
		parler("J’ai tout perdu! Le monde est trop injuste...");
		return 0;
	}
	
	public void recevoir(int argent) {
		this.gagnerArgent(argent);
		parler(argent + " sous ! Je te remercie généreux donateur!");
	}
}
