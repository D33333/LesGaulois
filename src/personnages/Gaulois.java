package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	
	public Gaulois(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup((force / 3)*effetPotion);
	}
	
	public void boirePotion(int force) {
		effetPotion = force;
		if (effetPotion == 3) {
			parler("Merci Druide, je sens que ma force est 3 fois décuplée.");
		}
	}
	
	@Override //le mettre en commentaire aussi pour avoir l'ancien affichage : nomPaquage.nomClasse@addresseMemoire
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain minus = new Romain("Minus", 7);
		System.out.println(asterix.toString());
		asterix.prendreParole();
		asterix.parler("Bonjour !");
		asterix.frapper(minus);
		asterix.boirePotion(3);
		System.out.println(asterix.toString());
		asterix.frapper(minus);
	}
}