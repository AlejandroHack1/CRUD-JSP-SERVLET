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
        <div class="login2">
            <h1>Formulario Registro de Mascotas</h1>
            <form action="RegisterPetServlet" method="post">
                <table style="with: 60%">
                    <tr>
                        <td>Nombre:</td>
                        <td><input type="text" name="name" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Raza:</td>
                        <td><input type="text" name="raza" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Especie:</td>
                        <td><input type="text" name="specie" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Color:</td>
                        <td><input type="text" name="color" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Género:</td>
                        <td><select id="gender" name="gender">
                                <option value="Hembra"></option>
                                <option value="Hembra">HEMBRA</option>
                                <option value="Macho">MACHO</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Peso:</td>
                        <td><input type="text" name="weight" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Edad:</td>
                        <td><input type="text" name="age" required="required"/></td>
                    <tr>
                        <td>Diagnóstico:</td>
                        <td><p><label for="diagnostic"></label></p>
                            <textarea id="diagnostic" name="diagnostic" rows="5" cols="30" maxlenght="500"></textarea></td>   
                    </tr></table><br/>
                <button type="submit" class="btn btn-primary btn-block btn-large">Registrar Mascotas</button><br/>
                <a href="RegisterPetServlet?return=1">Regresar</a>

            </form>
        </div>
    </body>
</html>
