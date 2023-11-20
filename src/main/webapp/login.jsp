<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Iniciar Sesion</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
	 <header>
		<nav class="navbar bg-primary" data-bs-theme="dark">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">Inicio Sesion BBVA</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	  </div>
	</nav>
	</header>
     <br>
     <div class="container col-md-5">
         <div class="card">
             <div class="card-body">
                 <form action="login" method="post">
                 <fieldset class="form-group">
                     <label>Username</label> <input type="text" value="<c:out value='${user.username}' />" class="form-control" name="username" required="required">
                 </fieldset>

                 <fieldset class="form-group">
                     <label>Password</label> <input type="password" value="<c:out value='${user.pass}' />" class="form-control" name="pass">
                 </fieldset>
                 <button type="submit" class="btn btn-primary">Iniciar Sesion</button>
                 </form>
             </div>
         </div>
     </div>
</body>
</html>