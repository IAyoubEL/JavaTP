
public class CriterePrix implements Critere{
	
		private int prix;
		public CriterePrix(int prix) {
			this.prix = prix;
		}
		public boolean estSatisfaitPar(Voiture V) {
			if (V.prix() <= this.prix)
				return true;
			else 
				return false;
		}
		public String toString() {
			return "Prix < " + prix;
		}
}
