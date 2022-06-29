<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/style.css" />
</head>
<body>
	<div class="cpageidentifiant">
		<div class="cdeuxiemepageidentifiant">
			<form action="<c:url value="/connexionSession" />" method="post">
				<div class="cidentifiant">
					<label for="identifiant">Identifiant: </label> <input
						name="saisieIdentifiant" id="identifiant" type="text" />
				</div>

				<div class="cmotdepasse">
					<label for="motDePasse">Mot de passe:</label> <input
						name="saisieMotDePasse" id="motDePasse" type="password" />
				</div>

				<div class="cCSM">
					<div>
						<button style="height: 40px;" class="cboutonConnexion" type="submit">Connexion</button>
					</div>

					<div class="cSM">
						<div class="cS">
							<input id="seSouvenir" type="checkbox"> <label
								for="seSouvenir">Se souvenir de moi</label>
						</div>

						<div>
							<a href="#">Mot de passe oublié</a>
						</div>
					</div>
				</div>
			</form>
			<div>
				<a  href="<c:url value="/inscription" />"><button style="width: 400px; height: 60px;" class="cboutonCreerUnCompte">Créer
						un compte</button></a>
			</div>
		</div>
	</div>
</body>
</html>