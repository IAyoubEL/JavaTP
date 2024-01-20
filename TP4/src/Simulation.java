
public class Simulation {

	public static void main(String[] args) {
		
		Jouet[] Jouets = new Jouet[10];
		
		for(int i=0 ; i<10 ; i++){
			Jouets[i] = new Jouet();
		}

		VerificateurJouet Ahmed = new VerificateurJouet("Ahmed",Jouets,2);
		VerificateurJouet Amine = new VerificateurJouet("Amine",Jouets,2);
		VerificateurJouet Bachir = new VerificateurJouet("Bachir",Jouets,1);
		Thread T1 = new Thread(Ahmed);
		Thread T2 = new Thread(Amine);
		Thread T3 = new Thread(Bachir);
		T1.start();
		T2.start();	
		T3.start();	
	}

}
