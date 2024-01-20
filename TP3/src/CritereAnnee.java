
public class CritereAnnee implements Critere{
	int annee;
	public CritereAnnee(int a){
		annee = a;
	}
	public boolean estSatisfaitPar(Voiture V) {
		if (V.annee() == this.annee)
			return true;
		else 
			return false;
	}
	public String toString() {
		return "Annee = " + annee;
	}
}
