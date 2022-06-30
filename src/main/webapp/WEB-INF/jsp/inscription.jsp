<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:if test="${ empty sessionScope.pseudo }">
	<title>Inscription</title>
</c:if>
<c:if test="${ !empty sessionScope.pseudo }">
	<title>Modification du profil</title>
</c:if>
</head>
<body>
	<c:if test="${ empty sessionScope.pseudo }">
		<form action="<c:url value="/servLog" />" method="post">
	</c:if>
	<c:if test="${ !empty sessionScope.pseudo }">
		<form action="<c:url value="/servUpdate" />" method="post">
	</c:if>
	<label for="">Pseudo: </label>
	<input name="saisiePseudo" type="text" id="saisiePseudo" />
	<label for="saisieNom">Nom:</label>
	<input name="saisieNom" type="text" id="saisieNom" />
	<label for="saisiePrenom">Prénom:</label>
	<input name="saisiePrenom" type="text" id="saisiePrenom" />
	<label for="">Email:</label>
	<input name="saisieEmail" type="text" id="saisiePseudo" />
	<label for="">Téléphone:</label>
	<input name="saisieTelephone" type="text" id="saisiePseudo" />
	<label for="saisieRue">Rue:</label>
	<input name="saisieRue" type="text" id="saisieRue" />
	<label for="saisieCodePostal">Code postal:</label>
	<input name="saisieCodePostal" type="text" id="saisieCodePostal" />
	<label for="saisieVille">Ville:</label>
	<input name="saisieVille" type="text" id="saisieVille" />
	<label for="saisieMotDePasse">Mot de passe:</label>
	<input name="saisieMotDePasse" type="password" id="saisieMotDePasse" />
	<label for="saisieComfirmationMotDePasse">Comfirmation:</label>
	<input name="saisieComfirmation" type="password"
		id="saisieComfirmationMotDePasse" />
	<c:if test="${ empty sessionScope.pseudo }">
		<button type="submit">Créer</button>
	</c:if>
	<c:if test="${ !empty sessionScope.pseudo }">
		<button type="submit">Modifier</button>
	</c:if>
	</form>
	<c:if test="${ empty sessionScope.pseudo }">
		<a href="<c:url value="/seconnecter" />"><button>Annuler</button></a>
	</c:if>
	<c:if test="${ !empty sessionScope.pseudo }">
		<a href="<c:url value="/accueil" />"><button>Annuler</button></a>
	</c:if>
</body>
</html>