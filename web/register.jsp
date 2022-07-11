<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>Formulario</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="CSS/style.css">

    </head>
    <body>
        <div class="login">
            <h1>Formulario de Registro</h1>
            <form action="RegisterServlet" method="post">
                <table style="with: 50%">
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="first_name" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Apellido</td>
                        <td><input type="text" name="last_name" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Usuario</td>
                        <td><input type="text" name="username" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Contraseña</td>
                        <td><input type="password" name="password" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Dirección</td>
                        <td><input type="text" name="address" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Número de Contacto</td>
                        <td><input type="text" name="contact" required="required"/></td>
                    </tr></table><br/>
                <button type="submit" class="btn btn-primary btn-block btn-large">Registrar</button><br/>
                <button onclick="location.href = 'index.jsp';" class="btn btn-primary btn-block btn-large" >Regresar</button>

            </form>
        </div>
    </body>
</html>