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
	<p>Pseudo: ${ requestScope.utilisateur.pseudo }</p>
	<p>Nom: ${ requestScope.utilisateur.nom }</p>
	<p>Prénom: ${ requestScope.utilisateur.prenom }</p>
	<p>Email: ${ requestScope.utilisateur.email }</p>
	<p>Teléphone: ${ requestScope.utilisateur.telephone }</p>
	<p>Rue: ${ requestScope.utilisateur.rue }</p>
	<p>Code postal: ${ requestScope.utilisateur.codePostal }</p>
	<p>Ville: ${ requestScope.utilisateur.ville }</p>

	<a href="<c:url value="/inscription" />"><button>Modifier</button></a>
</body>
</html>