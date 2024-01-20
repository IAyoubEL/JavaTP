import java.util.Scanner;

public class TestAgence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Agence A = new Agence();
		Client C1,C2,C3,C4;
		C1 = new Client("El Mazgouri","Ayoub","BH123",0);
		C2 = new Client("El Kerbani","Abdellatif","BH456",0);
		C3 = new Client("Sabhi","Walid","BH789",0);
		C4 = new Client("Bourmaila","Aya","BH999",2);
		A.ajouterClient(C1,C2,C3,C4);
		Voiture V1 = new Voiture("BMW","M5",2015,75000);
		Voiture V2 = new Voiture("Mercedes","GT63s",2022,150000);
		Voiture V3 = new Voiture("Audi","RS6",2020,105000);
		Voiture V4 = new Voiture("BMW","M2",2018,60000);
		Voiture V5 = new Voiture("BMW","M3",2021,70000);
		Voiture V6 = new Voiture("BMW","X5M",2021,80000);
		Voiture V7 = new Voiture("TESLA","MODEL X",2018,100000);
		Voiture V8 = new Voiture("DODGE","HELLCAT",2021,855000);
		Voiture V9 = new Voiture("Toyota", "Camry", 2020, 35000);
        Voiture V10 = new Voiture("Ford", "Mustang", 2018, 55000);
        Voiture V11 = new Voiture("Honda", "Civic", 2019, 25000);
        Voiture V12 = new Voiture("Tesla", "Model S", 2022, 90000);
        Voiture V13 = new Voiture("Chevrolet", "Corvette", 2021, 80000);
        Voiture V14 = new Voiture("Audi", "A4", 2017, 45000);
        Voiture V15 = new Voiture("Nissan", "Altima", 2016, 30000);
        Voiture V16 = new Voiture("Mercedes-Benz", "E-Class", 2023, 100000);
        Voiture V17 = new Voiture("Kia", "Optima", 2014, 20000);
		A.ajouterVoiture(V1,V2,V3,V4,V5,V6,V7,V8,V9,V10,V11,V12,V13,V14,V15,V16,V17);
		//A.afficheSelection(C1);
		//A.afficheSelection(C2);	
		//A.afficheSelection(C3);
		//A.afficheSelection(IC);
//		try {
//			A.loueVoiture(C3, V3);
//			A.loueVoiture(C1, V1);
//			A.loueVoiture(C4, V2);
//		} catch (LocationException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e);
//		}	
//		System.out.println("\n***********************************************************\n");
//		A.voituresLouees();
//		System.out.println("\n***********************************************************\n");
//		A.ClientLoue();
		
		
		
		
		
		
		Scanner scanner = new Scanner(System.in);
		int choix;
	    do {
	        System.out.println("Menu:");
	        System.out.println("1. Ajouter une voiture");
	        System.out.println("2. Afficher la liste des voitures");
	        System.out.println("3. Supprimer une voiture"); 
	        System.out.println("4. Afficher les voitures selon des criteres");
	        System.out.println("5. Afficher les voitures louées");
	        System.out.println("6. Ajouter un client");
	        System.out.println("7. Afficher la liste des clients");
	        System.out.println("8. Supprimer un client");
	        System.out.println("9. Afficher les clients loueurs");
	        System.out.println("10. Louer une voiture");
	        System.out.println("11. Rendre une voiture louée par un client");
	        System.out.println("12. Afficher Les Locations de l'Agence");
	        
	        
	        System.out.println("20. Quitter");

	        System.out.print("Choix : ");
	        choix = scanner.nextInt();
	        scanner.nextLine();  // Consume the newline character

	        switch (choix) {
	            case 1:
	                ajouterVoiture(scanner, A);
	                break;
	            case 2:
	                afficherListeVoitures(A);
	                break;
	            case 3:
	            	supprimerVoiture(scanner,A);
	                break; 
	            case 4:
	                afficherSelection(scanner, A);
	                break;
	            case 5:
	            	A.voituresLouees();
	                break;
	            case 6:
	            	ajouterClient(scanner,A);
	                break;
	            case 7:
	            	afficherListeClients(A);
	                break;
	            case 8:
	            	supprimerClient(scanner,A);
	            	break; 
	            case 9:
                	A.ClientLoue();
	                break;
	            case 10:
	            	louerVoiture(scanner,A);
	            	break;         
	            case 11:
	            	rendreVoiture(scanner, A);
	                break;
	            case 12:
	            	A.afficherLocations();
	                break;

	            case 20:
	                System.out.println("Au revoir !");
	                break;
	            default:
	                System.out.println("Choix non valide. Veuillez réessayer.");
	        }
	    } while (choix != 20);

	    scanner.close();
	}
	
	private static void supprimerClient(Scanner scanner, Agence A) {
		System.out.println("Donnez le CIN du client a supprimer :");
		Client cl = A.findClientByCIN(scanner.nextLine());
		if(cl == null) {
			System.out.println("Le numero que vous avez donnee n'existe pas deja!");
		}
		else{
			A.removeClient(cl);
		}
	}
	
	
	private static void ajouterClient(Scanner scanner, Agence A) {
		
		//creation du client;
	    System.out.println("Entrez les informations du client :");
	    
	    System.out.print("CIN : ");
	    String Cin = scanner.nextLine();
	    
	    Client test = A.findClientByCIN(Cin);
	    
	    if(test == null) {
		    System.out.print("Nom : ");
		    String nom = scanner.nextLine();
	
		    System.out.print("Prénom : ");
		    String prenom = scanner.nextLine();
		    
		    System.out.print("Civilité (0=M 1=Mlle 2=Mme) : ");
		    int civilite = scanner.nextInt();
			
		    Client client = new Client(nom,prenom,Cin,civilite);
		    		    
		    A.ajouterClient(client);
		    System.out.println("Client ajoute avec succes ! ");
	    }else {
	    	System.out.println("Ce client existe deja! ");
	    }	
	}
		

	private static void supprimerVoiture(Scanner sc, Agence A) {
		System.out.println("Donnez le numero de la voiture a supprimer :");
		Voiture V = A.findCarByNum(sc.nextInt());
		if(V == null) {
			System.out.println("Le numero que vous avez donnee n'existe pas!");
		}
		else{
			A.removeVoiture(V);
		}
	}
	
	
	private static void louerVoiture(Scanner scanner, Agence A) {
		//creation du client;
	    System.out.println("Entrez le CIN du client :");
	    String Cin = scanner.nextLine();
	    Client cl = A.findClientByCIN(Cin);
	    
	    if(cl != null) {
	    	System.out.println("Do you want to show Cars by the selected Criterias: (y/n)");
	    	String choix = scanner.next();scanner.nextLine();
	    	while (!choix.equalsIgnoreCase("y") && !choix.equalsIgnoreCase("n")) {
	    		System.out.println("Choix invalid\nChoisir (y/n)");
				choix = scanner.next();scanner.nextLine();
	    	}
			if(choix.equalsIgnoreCase("y")) {
	    		afficherSelection(scanner,A);
	    	}
		    System.out.print("Numero de la voiture à louer : ");
		    int num = scanner.nextInt();scanner.nextLine();
		    Voiture voiture = A.findCarByNum(num);
		    if(voiture != null) {
			    try {
			        A.loueVoiture(cl, voiture);
			        System.out.println("Location effectuée avec succès !");
			    } catch (LocationException e) {
			        System.out.println(e.getMessage());
			    }
		    }else {
		    	//voiture n'existe pas
		    }
	    }else{
	    	//client n'existe pas
	    }
	}


	private static void rendreVoiture(Scanner scanner, Agence agence) {
	    System.out.print("Entrer CIN du client : ");
	    String cinClient = scanner.nextLine();

	    Client client = agence.findClientByCIN(cinClient);
	    
	    if(client==null) {
	    	System.out.print("client n'existe pas!! ");
	    }else {
		    agence.rendVoiture(client);
		    System.out.println("Voiture rendue avec succès !");
	    }
	}


    private static void ajouterVoiture(Scanner scanner, Agence agence) {
        System.out.println("Entrez les informations de la voiture :");

        System.out.print("Marque : ");
        String marque = scanner.nextLine();

        System.out.print("Modèle : ");
        String modele = scanner.nextLine();


        int annee;
        int prix;

        // Gérer l'entrée de l'année
        while (true) {
            try {
                System.out.print("Année : ");
                annee = Integer.parseInt(scanner.nextLine());
                break;  // Sortir de la boucle si la conversion réussit
            } catch (NumberFormatException e) {
                System.out.println("Erreur : Veuillez entrer une année valide.");
            }
        }
        // Gérer l'entrée du prix
        while (true) {
            try {
                System.out.print("Prix : ");
                prix = Integer.parseInt(scanner.nextLine());
                break;  // Sortir de la boucle si la conversion réussit
            } catch (NumberFormatException e) {
                System.out.println("Erreur : Veuillez entrer un prix valide.");
            }
        }
        
        Voiture voiture = new Voiture(marque, modele, annee, prix);
        agence.ajouterVoiture(voiture);

        System.out.println("Voiture ajoutée avec succès !");
    }
    
    private static void afficherListeClients(Agence agence) {
        System.out.println("Liste des Clients de l'agence :");
        for (Client cl : agence.getListeClients()) {
            System.out.println(cl);
        }
    }
    

    private static void afficherListeVoitures(Agence agence) {
        System.out.println("Liste des voitures dans l'agence :");
        for (Voiture voiture : agence.getListeVoitures()) {
            System.out.println(voiture);
        }
    }

    private static void afficherSelection(Scanner scanner, Agence agence) {
        InterCritere interCritere = new InterCritere();
        boolean chAnnee=false;
        boolean chPrix=false;
        boolean chMarque=false;
        int choixCritere;
        do{
            System.out.println("Choisissez le type de critère :");
            if(!chAnnee)System.out.println("1. Critère d'année");
            if(!chMarque)System.out.println("2. Critère de marque");
            if(!chPrix)System.out.println("3. Critère de prix");
            System.out.println("4. Afficher");
            System.out.print("Votre choix : ");
            choixCritere = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
            switch (choixCritere) {
                case 1:
                	if(!chAnnee) {
                		chAnnee = true;
	                	int annee;
	                    while (true) {
	                        try {
	                            System.out.print("Année : ");
	                            annee = Integer.parseInt(scanner.nextLine());
	                            break;  // Sortir de la boucle si la conversion réussit
	                        } catch (NumberFormatException e) {
	                            System.out.println("Erreur : Veuillez entrer une année valide.");
	                        }
	                    }
	                    interCritere.addCritere(new CritereAnnee(annee));
                	}else {
                		System.out.println("Choix Invalide, Vouz s'avez deja choisit le critere Annee");
                	}
                    break;     
                case 2:
                	if(!chMarque) {
                		chMarque = true;
	                    System.out.print("Marque : ");
	                    String marque = scanner.nextLine();
	                    interCritere.addCritere(new CritereMarque(marque));
                	}else {
                		System.out.println("Choix Invalide, Vouz s'avez deja choisit le critere Marque");
                	}
                    break;
                case 3:
                	if(!chPrix) {
                		chPrix = true;
	                 	int prix;
	                    while (true) {
	                        try {
	                            System.out.print("Prix : ");
	                            prix = Integer.parseInt(scanner.nextLine());
	                            break;  // Sortir de la boucle si la conversion réussit
	                        } catch (NumberFormatException e) {
	                            System.out.println("Erreur : Veuillez entrer une prix valide.");
	                        }
	                    }
	                    interCritere.addCritere(new CriterePrix(prix));
                	}else {
                		System.out.println("Choix Invalide, Vouz s'avez deja choisit le critere Prix");
                	}
                    break;
                case 4:
                	agence.afficheSelection(interCritere);
                	break;
                default:
                	System.out.println("choix invalide");
            }
            
            if(chAnnee && chPrix && chMarque) agence.afficheSelection(interCritere);
            
        }while( (choixCritere!= 4) && ( !chAnnee || !chPrix || !chMarque ) );
        //( choixCritere = 4 || chAnnee && chPrix && chMarque)

    }		
}

