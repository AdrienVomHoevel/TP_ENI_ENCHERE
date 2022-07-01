<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil ENI-Enchères</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/style.css" />
</head>
<body>

	<div class="cTitreAccueil">
		<div class="cTitre">
			<h1>ENI-Enchères</h1>
		</div>
		<div class="cinscrire">
			<c:if test="${ empty sessionScope.user.pseudo }">
				<a href="<c:url value="/seconnecter" />">S'incrire - Se
					connecter</a>
			</c:if>
		</div>
	</div>

	<c:if test="${ !empty sessionScope.user.pseudo }">
		<a href="#">Enchères</a>
		<a href="<c:url value="/routeservletnouvellevente" />">Vendre un
			article</a>
		<a href="<c:url value="/verifProfil" />">Mon profil</a>
		<a href="<c:url value="/sedeconnecter" />  ">Déconnexion</a>
	</c:if>
	<div class="cListeEnchere">
		<h2>Liste des enchères</h2>
	</div>


	<form action="<c:url value="/rechRapide" />" method="post">
		<div class="cfiltre">
			<p>Filtres :</p>
		</div>

		<div>

			<input name="saisieUtilisateur" type="text"
				placeholder="Le nom de l'article contient" value="${ param.saisie }" />

			<div class="cchoix">
				<label class="clabelcategorie" for="list-categorie">Catégorie
					: </label>
				<div class="cchxoicategories">
					<label for="list-categorie">Catégorie :</label> <select
						name="categories" id="list-categorie">
						<option value="">---Selectionnez une catégorie---</option>
						<c:forEach var="categorie" items="${listeCat}">
							<option value="${categorie.libelle }">${categorie.libelle }</option>
						</c:forEach>
					</select>
				</div>
				<div class="cboutonrechercher">
					<button class="button-54" type="submit">Rechercher</button>
				</div>
			</div>

		</div>
	</form>
	<!-- Visuel des enchères en cour -->
	<div>
		<!-- Si aucune session n'est en cour -->
		<c:if test="${ empty sessionScope.user.pseudo }">
			<c:forEach var="article" items="${listeEnchere }">
				<h4>${article.nomArticle }</h4>
				<p>Prix : ${article.miseAPrix }</p>
				<p>Fin de l'enchère : ${article.dateFinEncheres }</p>
				<p>Vendeur : ${article.vendeur.nom }</p>
			</c:forEach>
		</c:if>
		<!-- Si une session est en cour -->
		<c:if test="${ !empty sessionScope.user.pseudo }">

		</c:if>
	</div>

</body>
</html>