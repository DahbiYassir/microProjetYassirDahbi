<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<title>Catalogue</title>
</head>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<body>
	<div class="container mt-4">
		<h1>Catalogue</h1>
	</div>
	<div class="container mt-4">
	<form class="row g-3" action="CatalogueServlet">
	  
	  <div class="col-auto">
	    		  <select class="form-select" aria-label="Default select example" name="categorie">
				  	<option value="90">-- Choisissez une catégorie --</option>
				    <c:forEach items="${listeCategorie}" var="category">
				        <option value="${category.id}">${category.categorie}</option>
				    </c:forEach>
				    
				  </select>
	  </div>
	  <div class="col-auto">
	    <button type="submit" class="btn btn-primary mb-3">Rechercher</button>
	  </div>
	</form>
</div>
	
<div class="container mt-4">
	<table class="table table-bordered">
	  <thead>
	    <tr>
	      <th scope="col">Id</th>
	      <th scope="col">Titre</th>
	      <th scope="col">Photo</th>
	      <th scope="col">Prix</th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach items="${article}" var="dataItem">
        <tr>
            <td><a href="ArticleServlet?id=${dataItem.codeArticle }">${dataItem.codeArticle}</a></td>
            <td>${dataItem.designation}</td>
            <td><img style=" width:80pt; height:80pt;" src="${dataItem.photo }" /></td>
            <td>${dataItem.prix}</td>
        </tr>
    	</c:forEach>
    	
	  </tbody>
	</table>
</div>
</body>
</html>