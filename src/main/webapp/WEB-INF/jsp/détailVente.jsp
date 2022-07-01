<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="fr.eni.tp.enchere.bo.Article"%>
<%@ page import="fr.eni.tp.enchere.bo.Retrait"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Détail vente</title>
</head>
<body>

	<!-- Nom de l'article -->
	<h3>${ requestScope.nouvelArticle.nomArticle }</h3>
	<!-- Description de l'objet -->
	<p>Description :${ requestScope.nouvelArticle.description }</p>
	<!-- Catégorie de l'objet -->
	<p>Catégorie :${ requestScope.nouvelArticle.categorie.libelle }</p>
	<!-- /!\ A tester une fois les enchères mise en place /!\ Meilleure offre actuelle sur l'objet -->
	<!-- <p>Meilleure offre :${ empty requestScope.nouvelArticle.encheres? "Aucunes enchères en cour" : requestScope.nouvelArticle.encheres}</p> -->
	<!--  Mise à prix de base de l'objet -->
	<p>Mise à prix :${ requestScope.nouvelArticle.miseAPrix }</p>
	<!-- Date de fin de l'enchere -->
	<p>Fin de l'enchère :${ requestScope.nouvelArticle.dateFinEncheres }</p>
	<!-- Lieu de retrait -->
	<p>Retrait :${ requestScope.nouvelArticle.retrait.rue }, ${ requestScope.nouvelArticle.retrait.code_postal },
		${ requestScope.nouvelArticle.retrait.ville }</p>
	<!-- Pseudo du vendeur -->
	<p>Vendeur :${ requestScope.nouvelArticle.vendeur.pseudo }</p>
	<!-- Proposition actuelle de l'utilisateur -->
	<!-- Rajouter la fonctionnalité enchérir -->

	<!-- Si l'utilisateur en cour n'est pas le vendeur et si il est bien connecté -->
	<c:if
		test="${requestScope.nouvelArticle.vendeur.pseudo != sessionScope.pseudo && empty session.pseudo}">
		<form action="<c:url value="" />" method="post">
			<label for="encherir">Ma proposition :</label> <input type="number"
				id="encherir" name="ajoutEnchere">
			<button type="submit">Enchérir</button>
		</form>
	</c:if>



</body>
</html>