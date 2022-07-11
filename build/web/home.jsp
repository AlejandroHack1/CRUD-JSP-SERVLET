
<!DOCTYPE html>
<html>
    <head>
        <title>Bienvenido</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="CSS/style.css">

    </head>
    <body>
        <%@page import="java.util.ArrayList"%>      
        <%@page import="java.util.List"%> 
        <%@page import="Modelo.claseMascota"%> 

        <div  style="text-align: center; color:cadetblue">

            <a style="float: right; margin-right: 15px" href="/WebApplication/LogoutServlet">Salir</a><br/>

            <div style="text-align: center"><%
              String error_msg=(String)request.getAttribute("error");  
              if(error_msg!=null)
              out.println("<font color=red size=4px>"+error_msg+"</font>");
                
                String success_msg=(String)request.getAttribute("success");  
                if(success_msg!=null)
                out.println("<font color=cadetblue size=4px>"+success_msg+"</font>");
                
               String msg_update_success=(String)request.getAttribute("successUpdate");  
              if(msg_update_success!=null)
              out.println("<font color=cadetblue size=4px>"+msg_update_success+"</font>");
                
                String msg_update_error=(String)request.getAttribute("errorUpdate");  
                if(msg_update_error!=null)
                out.println("<font color=red size=4px>"+msg_update_error+"</font>");
                %>
            </div><br/>

            <h1>Bienvenido Veterinaria Mascotas</h1><br/>
            <b>Usuario: (${user.username})</b><br>
            <b>Nombre: (${user.firstname})</b><br>
            <b>Apellidos: (${user.lastname})</b><br>
            <b>Dirección: (${user.direction})</b><br>
            <b>Teléfono: (${user.phone})</b><br>

            <br><br>

            <button onclick="location.href = 'registerPets.jsp';" class="btn btn-primary btn-large" >Registro Mascotas</button>
            <a href="RegisterPetServlet?showList=1">Listar Mascotas</a>

        </div> 

        <div style="text-align: center"><%
              
            String success_delete_msg=(String)request.getAttribute("successDelete");  
            if(success_delete_msg!=null)
            out.println("<font color=cadetblue size=4px>"+success_delete_msg+"</font>");
            %>
        </div><br/>

        <% 
             
         if((List<claseMascota>) request.getAttribute("listPets") != null) {
            
         List<claseMascota> mascotas= (List<claseMascota>) request.getAttribute("listPets"); %>

        <br/>

        <table id="pets">
            <tr>
                <th>Nombre</th>
                <th>Especie</th>
                <th>Raza</th>
                <th>Color</th>
                <th>Genero</th>
                <th>Peso</th>
                <th>Edad</th>
                <th>Diagnostico</th>
                <th>Opción</th>

            </tr>

            <% for (int i = 0; i < mascotas.size(); i++) { %>


            <tr>
                <td> <% out.println(mascotas.get(i).getNombre()); %></td>
                <td><% out.println(mascotas.get(i).getEspecie()); %></td>
                <td><% out.println(mascotas.get(i).getRaza()); %></td>
                <td><% out.println(mascotas.get(i).getColor()); %></td>
                <td><% out.println(mascotas.get(i).getGenero()); %></td>
                <td><% out.println(mascotas.get(i).getPeso()); %></td>
                <td><% out.println(mascotas.get(i).getEdad()); %></td>
                <td><% out.println(mascotas.get(i).getDiagnostico()); %></td>
                <td> 
                    <a href="RegisterPetServlet?idMascotaEdit=<%=mascotas.get(i).getIdMascota()%>">Editar</a>
                    <a href="RegisterPetServlet?idMascota=<%=mascotas.get(i).getIdMascota()%>" onclick="return confirm('Estas seguro de Eliminar?')">Eliminar</a>

                </td>


            </tr>


            <% } %> 
            <% } %> 
        </table>


        <footer>

            <div class="footer-content">

                <p>Autor: Alejandro Polanco<br>
                    <a href="mailto:xespitia@hotmail.com">xespitia@hotmail.com</a></p>
                <p>Copyright &copy; 2021-2022</p>
            </div>
        </footer>

    </body>
</html>
