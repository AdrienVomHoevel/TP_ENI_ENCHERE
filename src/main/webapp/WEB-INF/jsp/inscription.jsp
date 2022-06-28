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
	<form action="">
		<label for="">Pseudo: </label> <input type="text" id="saisiePseudo" />
		<label for="saisieNom">Nom:</label> <input type="text" id="saisieNom" />
		<label for="saisiePrenom">Prénom:</label> <input type="text"
			id="saisiePrenom" /> <label for="">Email:</label> <input type="text"
			id="saisiePseudo" /> <label for="">Téléphone:</label> <input
			type="text" id="saisiePseudo" /> <label for="saisieRue">Rue:</label>
		<input type="text" id="saisieRue" /> <label for="saisieCodePostal">Code
			postal:</label> <input type="text" id="saisieCodePostal" /> <label
			for="saisieVille">Ville:</label> <input type="password"
			id="saisieVille" /> <label for="saisieMotDePasse">Mot de
			passe:</label> <input type="text" id="saisieMotDePasse" /> <label
			for="saisieComfirmationMotDePasse">Comfirmation:</label> <input
			type="password" id="saisieComfirmationMotDePasse" />
		<button type="submit">Créer</button>
	</form>
	<a href="/accueil"><button>Annuler</button></a>
</body>
</html>