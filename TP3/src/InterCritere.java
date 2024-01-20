import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuffer;


public class InterCritere implements Critere{
	private List<Critere> LesCriteres;
	public InterCritere() {
		LesCriteres = new ArrayList<Critere>();
	}
	
	public void addCritere(Critere ... Criteres) {
		
		for(Critere Cr : Criteres)
		LesCriteres.add(Cr);
	}

	@Override
	public boolean estSatisfaitPar(Voiture v) {
		// TODO Auto-generated method stub
		for(Critere Cr : LesCriteres) {
			if(!Cr.estSatisfaitPar(v)) return false;
		}
		return true;
	}
	public String toString() {
		StringBuffer st = new StringBuffer("Les Criteres: ");
		for(Critere Cr : LesCriteres) {
			
			st.append(Cr+" ");
			
		}
		return st.toString();
	}
}
