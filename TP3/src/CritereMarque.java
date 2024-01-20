
public class CritereMarque implements Critere{
	private String marque;
	public CritereMarque(String marque) {
		this.marque = marque;
	}
	public boolean estSatisfaitPar(Voiture V) {
		if (V.marque().equalsIgnoreCase(this.marque))
			return true;
		else 
			return false;
	}
	public String toString() {
		return "Marque ("+marque+")";
	}
}
