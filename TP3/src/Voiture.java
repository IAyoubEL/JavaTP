
public class Voiture {
	private int num;
	private String marque;
	private String modele;
	private int annee;
	private int prix;
	private boolean isRented;
	private static int voitureCount = 0; 
	
	public Voiture(String marque,String modele,int annee,int prix) {
		this.marque = marque;
		this.modele = modele;
		this.annee = annee;
		this.prix = prix;
		this.num = voitureCount++;
		isRented = false;
	}

	public boolean isRented() {
		return this.isRented;
	}
	
	public void setRented(boolean r) {
		this.isRented = r;
	}
	
	public int num() {
		return this.num;
	}
	
	public String marque() {
		return this.marque;
	}
	
	public String modele() {
		return this.modele;
	}
	
	public int annee() {
		return this.annee;
	}
	
	public int prix() {
		return this.prix;
	}
	
	public boolean equals(Voiture V) {
        if (this == V) {
            return true; // Same object reference
        }

        if (V == null || getClass() != V.getClass()) {
            return false; // Different classes or null
        }


        // Perform content-based comparison
        return this.num() == V.num();
    }
	
	public String toString() {
		return "Voiture{" +
				"Numero = " + num +
                ", Marque = " + marque +
                ", Modele = " + modele +
                ", Annee = " + annee +
                ", prix = " + prix +
                ", Louée = " + isRented +
                "}";
	}
}
