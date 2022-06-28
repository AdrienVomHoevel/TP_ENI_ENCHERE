<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<body>
	<form action="<c:url value="/servLog" />" method="post">
		<label for="">Pseudo: </label> <input name="saisiePseudo" type="text"
			id="saisiePseudo" /> <label for="saisieNom">Nom:</label> <input
			name="saisieNom" type="text" id="saisieNom" /> <label
			for="saisiePrenom">Prénom:</label> <input name="saisiePrenom"
			type="text" id="saisiePrenom" /> <label for="">Email:</label> <input
			name="saisieEmail" type="text" id="saisiePseudo" /> <label for="">Téléphone:</label>
		<input name="saisieTelephone" type="text" id="saisiePseudo" /> <label
			for="saisieRue">Rue:</label> <input name="saisieRue" type="text"
			id="saisieRue" /> <label for="saisieCodePostal">Code postal:</label>
		<input name="saisieCodePostal" type="text" id="saisieCodePostal" /> <label
			for="saisieVille">Ville:</label> <input name="saisieVille"
			type="text" id="saisieVille" /> <label for="saisieMotDePasse">Mot
			de passe:</label> <input name="saisieMotDePasse" type="password"
			id="saisieMotDePasse" /> <label for="saisieComfirmationMotDePasse">Comfirmation:</label>
		<input name="saisieComfirmation" type="password"
			id="saisieComfirmationMotDePasse" />
		<button type="submit">Créer</button>
	</form>
	<a href="/accueil"><button>Annuler</button></a>
</body>
</html>