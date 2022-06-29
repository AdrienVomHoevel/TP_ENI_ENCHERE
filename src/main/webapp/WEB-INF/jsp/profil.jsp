<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>profil</title>
</head>
<body>
	<h1>ENI-Enchères</h1>
	<label for="">Pseudo:${sessionScope.Utilisateur.getPseudo()}</label>
	<label for="">Nom:</label>
	<label for="">Prénom:</label>
	<label for="">Email:</label>
	<label for="">Teléphone:</label>
	<label for="">Rue:</label>
	<label for="">Code postal:</label>
	<label for="">Ville:</label>
</body>
</html>