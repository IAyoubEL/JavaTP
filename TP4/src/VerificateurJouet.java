import java.util.*;
public class VerificateurJouet implements Runnable {

	private String nom;
	private Jouet[] Jouets;
	private int niveau;//1:superieur 2:verificateur
	private int vitesse;
	
	public String nom() { 
		return this.nom;
	}
	public int niveau() { 
		return this.niveau;
	}
	public VerificateurJouet(String n,Jouet[] J,int niv) {
		nom = n;
		Jouets = J;
		niveau = niv;
		if(niveau == 1) {
			vitesse = new Random().nextInt(0,1000);
		}else {
			vitesse = new Random().nextInt(0,1000);
		}
	}
	
	public void verifieJouet(int j) throws InterruptedException {
		//verifier que j est entre 0 et 9
		System.out.println(this.nom()+" verifie le jouet #"+j);
		Thread.sleep(this.vitesse);
		System.out.println(this.nom()+" a fini la verification du jouet #"+j);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(Jouet J : Jouets) {
			try {
				J.tuEsVerifiePar(this);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
