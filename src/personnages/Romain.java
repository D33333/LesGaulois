package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		assert force > 0 : "la force d'un Romain est toujours positive";
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0 : "la force d'un Romain est positive";
		int forceInit = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe !");
		} else {
			parler("J'abandonne...");
		}
		assert forceInit > force : "la force d'un Romain a diminué";
	}
	
	public void sEquiper(Equipement nomEq) {
		switch(nbEquipement) {
			case 2 :
				System.out.println("Le soldat "+nom+" est déjà bien protégé !");
				break;
			case 1 :
				if (nomEq == equipements[0]) {
					System.out.println("Le soldat "+nom+" possède déjà un "+nomEq.toString()+" !");
				} else {
					extracted(nomEq);
				}
				break;
			default :
			extracted(nomEq);
		}
	}

	private void extracted(Equipement nomEq) {
		equipements[nbEquipement] = nomEq;
		nbEquipement+=1;
		System.out.println("Le soldat "+nom+" s'équipe avec un "+nomEq.toString()+".");
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.prendreParole();
		minus.parler("Je suis Minus !");
		minus.recevoirCoup(4);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
	}
}