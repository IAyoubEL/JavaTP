
public class Client implements Comparable<Client>{
	private String nom;
	private String prenom;
	private String cin;
	private Civilite c;
	
	
	public String cin() {
		return cin;
	}
	
	public String nom() {
		return nom;
	}
	
	public String prenom() {
		return prenom;
	}
	
	public Client(String Nom, String Pre, String CIN, int C) {
		nom = Nom;
		prenom = Pre;
		cin = CIN;
		switch(C) {
			case 0:
				c = Civilite.M;
				break;
			case 1:
				c = Civilite.Mlle;
				break;
			case 2:
				c = Civilite.Mme;
				break;
			default:
				
				;
		}
		
	}
	@Override
	public boolean equals(Object c) {
        if (this == c) {
            return true; // Same object reference
        }

        if (c == null || getClass() != c.getClass()) {
            return false; // Different classes or null
        }


        // Perform content-based comparison
        return this.cin() == ((Client) c).cin();
    }
	
	
	public String toString() {
		return "Client { "+nom+", "+prenom+", "+cin+", "+c+" }";
	}

	@Override
	public int compareTo(Client o) {
		return this.nom.compareTo(o.nom());
	}

	public void setNom(String n) {
		// TODO Auto-generated method stub
		nom = n;
	}

	public void setPrenom(String p) {
		// TODO Auto-generated method stub
		prenom = p;
	}

	public void setCin(String c) {
		// TODO Auto-generated method stub
		cin = c;
	}

	public void setCivilite(int C) {
		// TODO Auto-generated method stub
		switch(C) {
		case 0:
			c = Civilite.M;
			break;
		case 1:
			c = Civilite.Mlle;
			break;
		case 2:
			c = Civilite.Mme;
			break;
		default:
			//exception
			;
	}
		
	}
	
}
