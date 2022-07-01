<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<%@ page import="fr.eni.tp.enchere.bo.Utilisateur"%>
<html>
<head>
<meta charset="UTF-8">
<title>Profil</title>
</head>
<body>
	<%@ page import="fr.eni.tp.enchere.bo.Utilisateur"%>

	<h1>ENI-Enchères</h1>
	<p>Pseudo: ${ sessionScope.user.pseudo }</p>
	<p>Nom: ${ sessionScope.user.nom }</p>
	<p>Prénom: ${ sessionScope.user.prenom }</p>
	<p>Email: ${ sessionScope.user.email }</p>
	<p>Teléphone: ${ sessionScope.user.telephone }</p>
	<p>Rue: ${ sessionScope.user.rue }</p>
	<p>Code postal: ${ sessionScope.user.codePostal }</p>
	<p>Ville: ${ sessionScope.user.ville }</p>

	<a href="<c:url value="/inscription" />"><button>Modifier</button></a>
</body>
</html>