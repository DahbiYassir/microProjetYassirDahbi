import com.microProjet.beans.Inscription;
import com.microProjet.connection.JpaConnection;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inscription inscription = new Inscription("socoma","yassir@dahbi.com","pass","yassir","dahbi",0625255,6);
		//JpaConnection.jpaRegister(inscription);
		System.out.println(JpaConnection.loginJpa(inscription)); 
		//System.out.println(JpaConnection.listeProduitJpa("pop"));

	}

}
