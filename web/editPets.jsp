<%-- 
    Document   : registerMascota
    Created on : 8/07/2022, 4:25:09 p. m.
    Author     : xespi
--%>

<!DOCTYPE html>
<html>
    <head>
        <title>Formulario Mascota</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="CSS/style.css">
    </head>
    <body>
        <%@page import="java.util.ArrayList"%>      
        <%@page import="java.util.List"%> 
        <%@page import="Modelo.claseMascota"%> 

        <div class="login2">
            <% if((List<claseMascota>) request.getAttribute("listEditPet") != null) {

                 List<claseMascota> mascota = (List<claseMascota>) request.getAttribute("listEditPet"); %>

            <h1>Formulario Editar Mascota</h1>
            <form action="EditPetServlet" method="post">
                <table style="with: 60%">
                    <tr>
                        <td>Nombre:</td>
                        <td><input type="text" name="name" value="<%out.println(mascota.get(0).getNombre());%>" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Raza:</td>
                        <td><input type="text" name="raza" value="<%out.println(mascota.get(0).getRaza());%>" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Especie:</td>
                        <td><input type="text" name="specie" value="<%out.println(mascota.get(0).getEspecie());%>" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Color:</td>
                        <td><input type="text" name="color" value="<%out.println(mascota.get(0).getColor());%>" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Género:</td>
                      
                        <td><select id="gender" name="gender">

                                <option selected="selected" value="<%out.println(mascota.get(0).getGenero());%>"><%out.println(mascota.get(0).getGenero());%></option>
                                <option value="Macho">MACHO</option>
                                <option value="Macho">HEMBRA</option>

                            </select>
                        </td>

                    </tr>
                    <tr>
                        <td>Peso:</td>
                        <td><input type="text" name="weight" value="<%out.println(mascota.get(0).getPeso());%>" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Edad:</td>
                        <td><input type="text" name="age" value="<%out.println(mascota.get(0).getEdad());%>" required="required"/></td>
                    <tr>
                        <td>Diagnóstico:</td>
                        <td><p><label for="diagnostic"></label></p>
                            <textarea id="diagnostic" name="diagnostic" rows="5" cols="30" maxlenght="500"><%out.println(mascota.get(0).getDiagnostico());%></textarea></td>   
                    </tr></table><br/>
                <button type="submit" class="btn btn-primary btn-block btn-large">Actualizar Mascotas</button><br/>
                <a href="RegisterPetServlet?return=1">Regresar</a>

            </form>

            <% } %>
        </div>
    </body>
</html>
