<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<style><%@include file="CSS/formStyle.css"%></style>
<title>Article</title>
</head>
<body>
	<div class="container mt-4">
		<h1>Détail du Produit</h1>
	</div>
	<div class="container mt-4"><img style="width:100pt;height:100pt;" src="${article.photo }"> </div>
	
	<div class="container mt-5">
		<form class="row row-cols-2 ">
				
				  <div class="col ">
				    <label for="inputId" class="col-sm col-form-label">ID</label>
			      	<input type="text" class="form-control" id="inputId" name="txt_id" value="${article.codeArticle }" readonly>
			      </div>
			      
			      <div class="col">
			      	<label for="inputDesignation" class="col-sm col-form-label">Designation</label>
			      	<input type="text" class="form-control" id="inputDesignation" name="txt_designation" value="${article.designation }" readonly>
			      </div>
			      
			       <div class="col mt-4">
			      <label for="inputStock" class="col-sm col-form-label">Stock</label>
			      	<input type="text" class="form-control" id="inputStock" name="txt_Stock" value="${article.stock }" readonly>
			      </div>
			      
			      <div class="col mt-4">
			        <label for="inputPrix" class="col-sm col-form-label">Prix</label>
			      	<input type="text" class="form-control" id="inputPrix" name="txt_Prix" value="${article.prix }" readonly>
			      </div>
			      
			      <div class="col mt-4">
				    <a class="btn btn-primary" href="#" role="button">Ajouter au Panier</a>
				  </div>
				  
				  <div class="col mt-4">
				    <a class="btn btn-primary" href="http://localhost:8080/MicroProjet/CatalogueServlet?categorie=90" role="button">Retour</a>
				  </div>
		</form>
	</div>
</body>
</html>