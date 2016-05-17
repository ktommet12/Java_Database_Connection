import database.*;

public class Main {

	public static void main(String[] args) {
		try{
			DB.retrieveItems();
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}

	}

}
