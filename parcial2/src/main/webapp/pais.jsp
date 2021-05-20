<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Paises.</title>
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="#" class="navbar-brand"> Gestión de Paises. </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Paises</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">

                        <c:if test="${pais != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${pais == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${pais != null}">
                                    Editar Usuario
                                </c:if>
                                <c:if test="${pais == null}">
                                    Agregar Nuevo Usuario
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${pais != null}">
                            <input type="hidden" name="id" value="<c:out value='${pais.id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Nombre de Pais</label> <input type="text" value="<c:out value='${pais.nombre}' />" class="form-control" name="nombre" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Id del pais</label> <input type="text" value="<c:out value='${pais.id}' />" class="form-control" name="id">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Pais del Usuario</label> <input type="text" value="<c:out value='${usuario.pais}' />" class="form-control" name="pais">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Guardar</button>
                        </form>
                    </div>
                </div>
            </div>



</body>
</html>