<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<title>Accueil 1</title>
</head>
<body>
	<div class="container mt-4">
		<h1>Bonjour, <%=session.getAttribute("nom") %> <%=session.getAttribute("prenom") %></h1>
	</div>
	<hr style="width:100%;text-align:center;margin:auto;height:5px;">
	<div class ="container mt-4">
		<a href="CatalogueServlet?categorie=90">Consulter le catalogue</a><br>
		<a href="#">Suivre vos commandes</a><br>
		<a href="#">Visualiser votre panier</a>
	</div>
</body>
</html>