// Exception personnalisée pour la gestion des locations
@SuppressWarnings("serial")
public class LocationException extends Exception {
	String message;
	LocationException(String Message){
		message=Message;
	}
	@Override
	public String toString() {
		return message;
		}
}

