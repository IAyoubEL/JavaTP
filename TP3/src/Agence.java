import java.util.ArrayList;
//import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


class Agence {
    private List<Voiture> voitures;
    private Map<Client,Voiture> Locations;
    private List<Client>clients;
    // Constructeur, méthodes pour ajouter des voitures, etc.
    public Agence() {
    	 this.voitures = new ArrayList<Voiture>();
    	 this.Locations = new TreeMap<Client,Voiture>();
    	 this.clients = new ArrayList<Client>();
    }
    
    
    public void ajouterClient(Client ...Clients) {
        for(Client c:Clients) {
        	clients.add(c);
        }
    }
    
    public void removeClient(Client cl) {
    	if(!this.estLoueur(cl)) {
    		clients.remove(cl);
    		System.out.println("client supprimee avec succes");
    	}else {
    		/// exception !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    		System.out.println("impossible de supprimer un client loueur");
    	}
    }

    public List<Client> getListeClients() {
        return clients;
    }


    // Ajouter une méthode pour afficher la liste des clients
    
 // Méthode pour ajouter une voiture au garage
    public void ajouterVoiture(Voiture ...Voitures) {
        for(Voiture v: Voitures) {
        	voitures.add(v);
        }
    }
    
    public void removeVoiture(Voiture V) {
    	if(!this.estLoue(V)) {
    		voitures.remove(V);
    		System.out.println("Voiture supprimee avec succes");
    	}else {
    		/// exception !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    		System.out.println("Cant remove a rented car");
    	}
    }

    // Méthode pour obtenir la liste complète des voitures dans le garage
    public List<Voiture> getListeVoitures() {
        return voitures;
    }

    public Voiture findCarByNum(int num) {

        for (Voiture v : voitures) {
            if (v.num()==num) {
            	return v;
            }
        }
        return null;
    }
    
    // Méthode pour sélectionner les voitures satisfaisant un critère
    public Iterator<Voiture> selectionne(Critere c) {
        List<Voiture> voituresSatisfaisantes = new ArrayList<>();

        for (Voiture v : voitures) {
            if (c.estSatisfaitPar(v) && !this.estLoue(v)) {
                voituresSatisfaisantes.add(v);
            }
        }

        return voituresSatisfaisantes.iterator();
    }
    
    public void afficheSelection(Critere c) {
    	
        Iterator<Voiture> it = selectionne(c);

        if(it.hasNext() == false) System.out.println("No car found for the chosen criteras");
        else {
        	System.out.println("Voitures satisfaisant "+c+" :");
	        do{ 
	            Voiture v = it.next();
	            System.out.println(v); // Supposons que la classe Voiture ait une méthode toString appropriée
	        }while (it.hasNext());
        }
    }
    //needs exceptions
    public void loueVoiture(Client client, Voiture v) throws LocationException  {
	    	
	    	if(voitures.indexOf(v)!= -1) {
	    		//verifier si la voiture est deja loue
	    		if(!estLoue(v)){
		    		Voiture V = Locations.putIfAbsent(client, v);
		    		if(V != null) {
		    			throw new LocationException("Le client "+ client.nom() + " loue deja une autre voiture: "+ V);
		    		}else {
		    			v.setRented(true);
		    		}
	    		}
	    		else {
	    			throw new LocationException("Voiture deja louee");
	    		}
	    	}
	    	else {
	    		throw new LocationException("La Voiture n'existe pas");
	    	}
        	
    }
    
    public boolean estLoue(Voiture v) {
    	
    	return Locations.containsValue(v);
    }
    
    public boolean estLoueur(Client client) {
    	
    	return Locations.containsKey(client);
    }
    
    public void rendVoiture(Client client) {
    	Voiture V = Locations.remove(client);
    	V.setRented(false);
    }
    
    public void afficherLocations(){
    	if(!Locations.isEmpty()) {
    		Locations.forEach((cl,v)->System.out.println(cl.nom()+" "+cl.prenom()+" Loue "+v.marque()+" "+v.modele()));
    	}else {
    		System.out.println("No Locations yet!! :'( ");
    	}
    }
    
    public Iterator<Voiture> lesVoituresLouees() {
    	
    	List<Voiture> VLouees = new ArrayList<Voiture>();
    	
    	for(Voiture v : voitures) {
    		if(estLoue(v)) VLouees.add(v); 
    	}
    	return VLouees.iterator();
    	
    }
    
	public void voituresLouees() {
    	
        Iterator<Voiture> it = lesVoituresLouees();

        System.out.println("Les Voitures Louees de l'Agence sont :");
        while (it.hasNext()) {
            Voiture v = it.next();
            System.out.println(v); // Supposons que la classe Voiture ait une méthode toString appropriée
        }
        
    }
	
	

	
	
	public Iterator<Client> lesClientsLoue() {
    	
    	List<Client> CLoue = new ArrayList<Client>();
    	
    	for(Client c : Locations.keySet()) {
    		CLoue.add(c);
    	}
    	return CLoue.iterator();
    	
    }
	
	public Client findClientByCIN(String cin) { 
		    	
    	for(Client c : clients) {
    		if(c.cin().equalsIgnoreCase(cin)) {
    			return c;
    		}
    	}
    	return null;
	}
    
	public void ClientLoue() {
    	
        Iterator<Client> it = lesClientsLoue();

        System.out.println("Les Client qui Loue de l'Agence sont :");

        while (it.hasNext()) {
            Client c = it.next();
            System.out.println(c); // Supposons que la classe Voiture ait une méthode toString appropriée
        }
        
    }
       
}