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
			<c:if test="${ empty sessionScope.pseudo }">
				<a href="<c:url value="/seconnecter" />">S'incrire - Se
					connecter</a>
			</c:if>
		</div>
	</div>

	<c:if test="${ !empty sessionScope.pseudo }">
		<a href="#">Enchères</a>
		<a href="<c:url value="/nouvelle_vente" />">Vendre un article</a>
		<a href="#">Mon profil</a>
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
				<label class="clabelcategorie" for="list-categorie">Catégorie : </label>
				<div class="cchxoicategories">
					<select name="categories" id="list-categorie">
						<option value="">---Selectionnez une catégorie---</option>
						<option value="informatique">Informatique</option>
						<option value="ameublement">Ameublement</option>
						<option value="vetement">Vêtement</option>
						<option value="sport&loisirs">Sport & Loisirs</option>
					</select>
				</div>
				<div class="cboutonrechercher">
					<button class="button-54" type="submit">Rechercher</button>
				</div>
			</div>

		</div>


	</form>
	<p>Ici se trouvera prochainement l'affichage des enchères en cour
		et leur détail</p>

</body>
</html>