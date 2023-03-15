package personnages;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;
	
	public void donnerTrophees(Gaulois gauloisFaitDon, Trophee eqDonne) {
		if (nbTrophee < trophees.length) {
			trophees[nbTrophee] = eqDonne;
			nbTrophee+=1;
		}
	}
	
	public String extraireInstructionsCaml() {
		String codeCaml = "let musee = [\n";
		for(int i=0; i<nbTrophee; i++) {
			codeCaml+= '"'+trophees[i].donnerNom()+'"'+", "+'"'+trophees[i].getEquipement()+'"';
			if (i+1 == nbTrophee) {
				codeCaml += "\n";
			} else {
				codeCaml += ";\n";
			}
		}
		return codeCaml+"]";
	}
}
