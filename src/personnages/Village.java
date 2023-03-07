package personnages;

//import personnages.Chef;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			//on incrémente après puisque le 1er villageois est stocké à l'indice 0
			villageois[nbVillageois] = gaulois;
			nbVillageois+=1;
		}
	}
	
	public Gaulois trouverHabitant(int indiceVillageois) {
		return villageois[indiceVillageois];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef "+chef+"vivent les légendaires gaulois :");
		for(int i=0; i<nbVillageois; i++) {
			System.out.println("- "+villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
//		Gaulois gaulois = village.trouverHabitant(30); //Erreur : Index 30 out of bounds for length 30
//		Erreur parce que les villageois sont stockés de l'indice 0 à l'indice 29. Donc il n'y a pas de villageois à l'indice 30 => erreur d'accès mémoire.
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		Réponse: null car asterix se trouve à l'indice 0 et comme c'est le seul gaulois du village, il n'y a personne à l'indice 1.
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}
}
