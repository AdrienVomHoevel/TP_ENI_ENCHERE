package fr.eni.tp.enchere.bo;

import java.time.LocalDate;

public class testBo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Utilisateur didier = new Utilisateur(1,"Did" ,"Dabar", "Didier", "didier.dabar@outlook.com", "0642315876", "Rue du bar", "0652874632", "Nantes","Pa$$W0rd", 0, true);
		
//	    Article a1 = new Article("Ordinateur Portable", "Un pc portalbe.", LocalDate.now(), LocalDate.now(), 500, 600, "en cours", didier, "informatique", "rue de la paix", 28000, "Chartres");
//		
//	    System.out.println(a1);
//	    System.out.println(a1.getCategorie());
	    
		System.out.println(didier.encherit(LocalDate.now(), 70000));
		System.out.println(didier.encherit(LocalDate.now(), 50000));
		
		
		
	}

}
