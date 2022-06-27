package fr.eni.tp.enchere.bo;

import java.time.LocalDate;

public class testBo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Utilisateur didier = new Utilisateur(1,"Did" ,"Dabar", "Didier", "didier.dabar@outlook.com", "0642315876", "Rue du bar", 44521, "Nantes","Pa$$W0rd", 0, "Solange");
		
		
		
		System.out.println(didier.encherit(LocalDate.now(), 70000));
		System.out.println(didier.encherit(LocalDate.now(), 50000));
		
		
		
	}

}
