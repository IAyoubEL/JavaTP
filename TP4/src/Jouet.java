
public class Jouet {
	private int num;
	private boolean estVerifie;
	static int JouetCount=0;
	public int num() {
		return this.num;
		
	}
	public Jouet(){ 
		this.num = JouetCount++;
		this.estVerifie = false;
	}
	
	public void tuEsVerifiePar(VerificateurJouet V) throws InterruptedException{

			
			if(!this.estVerifie || V.niveau()==1) {//si le jouet n'est pas verifiee ou un super verificateur
				synchronized(this){
					if(V.niveau()==1) while(!this.estVerifie) this.wait();//le super verificateur attents la verification du jouet

						if(!this.estVerifie || V.niveau()==1) {
							estVerifie = true; 
							V.verifieJouet(num);
							if(V.niveau() == 2) {this.notify();}
						}
				}
			}
	}

	
	public boolean getEstVerifie() {
		return estVerifie;
	}
	public void setEstVerifie(boolean estVerifie) {
		this.estVerifie = estVerifie;
	}
}
