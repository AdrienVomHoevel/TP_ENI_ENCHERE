<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
	<form action="<c:url value="/connexionSession" />" method="post">
		<label for="identifiant">Identifiant: </label> <input name="saisieIdentifiant" id="identifiant"
			type="text" /> <label for="motDePasse">Mot de passe:</label> <input
			name="saisieMotDePasse" id="motDePasse" type="password" />
		<button type="submit">Connexion</button>
		<input id="seSouvenir" type="checkbox"> <label
			for="seSouvenir">Se souvenir de moi</label> <a href="#">Mot de
			passe oublié</a>
	</form>
	<a href="<c:url value="/inscription" />"><button>Créer un
			compte</button></a>
</body>
</html>