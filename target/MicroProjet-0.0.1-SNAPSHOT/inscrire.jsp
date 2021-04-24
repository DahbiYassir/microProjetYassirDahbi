<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<meta charset="UTF-8">
<style><%@include file="CSS/formStyle.css"%></style>
<title>Inscrire</title>
</head>
<body>
<div class="row justify-content-center">
<div class="col-8">	
	<div class="container mt-4 text-center"><h1>Inscrivez-vous</h1></div>
	<div class="container mt-5">
		<form action="InscriptionServlet" method="post" validate>
		      <div class="mb-3 row">
			      <label for="inputNom" class="col-sm-4 col-form-label">Nom</label>
			      <div class="col-sm-8">
			      	<input type="text" class="form-control" id="inputNom" name="txt_nom" required>
			      </div>
		      </div>
		      
			  <div class="mb-3 row">
			      <label for="inputPrenom" class="col-sm-4 col-form-label">Prénom</label>
			      <div class="col-sm-8">
			      	<input type="text" class="form-control" id="inputPrenom" name="txt_prenom" required>
			      </div>
		      </div>
		      
		      <div class="mb-3 row">
			      <label for="inputAdresse" class="col-sm-4 col-form-label">Adresse</label>
			      <div class="col-sm-8">
			      	<input type="text" class="form-control" id="inputAdresse" name="txt_adresse" required>
			      </div>
		      </div>
		      
		      <div class="mb-3 row">
			      <label for="inputTel" class="col-sm-4 col-form-label">Tel</label>
			      <div class="col-sm-8">
			      	<input type="tel" class="form-control" id="inputTel" name="txt_tel" requiered>
			      </div>
		      </div>
		     
			 <div class="mb-3 row">
		      <label for="inputEmail" class="col-sm-4 col-form-label">Email</label>
		      <div class="col-sm-8">
		      	<input type="email" class="form-control" id="inputEmail" placeholder="name@example.com" name="txt_email" required>
		      </div>
		      </div>
		      
			<div class="mb-3 row">
		      <label for="inputPassword" class="col-sm-4 col-form-label">Mot de Passe</label>
		      <div class="col-sm-8">
		      	<input type="password" class="form-control" id="inputPassword" name="txt_mdp" required>
		      </div>
		    </div> 
		    
		    <div class="row">
			    <button type="submit" class="btn-block btn-primary mb-3">S'inscrire</button>
			</div>
		</form>         
    </div>
</div>
</div>		
	
	
</body>
</html>