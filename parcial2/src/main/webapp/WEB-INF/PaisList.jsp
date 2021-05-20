<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<meta charset="ISO-8859-1">
<title>Aplicación del Giro de Italia</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
			<div>
                <a href="#" class="navbar-brand"> Gestión de Pais </a>
            </div>
            
            <ul class="navbar-nav">
            	<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Usuarios</a></li>
            </ul>
		
		</nav>
	</header>
	<br/>
	
	<div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">Listado de Paises</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Agregar Nuevo Pais</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="usuario" items="${listPais}">

                                <tr>
                                    <td>
                                        <c:out value="${pais.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${pais.nombre}" />
                                    </td>
                                    <td>
                                  
                                    </td>
                                    <td><a href="edit?id=<c:out value='${pais.id}' />">Editar</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${pais.id}' />">Elimnar</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>


</body>
</html>