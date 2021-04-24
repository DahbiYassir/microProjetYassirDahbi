<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<title>Identifier</title>
</head>
<style><%@include file="CSS/formStyle.css"%></style>
<body>
<div class="row justify-content-center">
<div class="col-8">
<div class="container mt-4 text-center"><h1>Identifiez-vous</h1></div>
<div class="container mt-4">
	<form action="IdentificationServlet" method="post">
	  <div class="mb-3 col-sm-12">
	    <label for="exampleInputEmail1" class="form-label">Email</label>
	    <input type="email" class="form-control" id="exampleInputEmail1" name="txt_email">
	    
	  </div>
	  <div class="mb-3 col-sm-12">
	    <label for="exampleInputPassword1" class="form-label">Mot de Passe</label>
	    <input type="password" class="form-control" id="exampleInputPassword1" name="txt_password">
	  </div>
	  <div class="row">
			    <button type="submit" class="btn-block btn-primary mb-3">S'identifier</button>
	  </div>
	</form>
</div>
</div>
</div>
</body>
</html>