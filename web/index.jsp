<!DOCTYPE html>

<html>
    <head>
        <title>Peluditos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="CSS/style.css">

    </head>
    <body>
        
        <div style="text-align: center"><%
                String msg=(String)request.getAttribute("success");  
                if(msg!=null)
                out.println("<font color=cadetblue size=4px>"+msg+"</font>");
                %></div><br/>

        <h1 class="titulo">Veterinaria Mascotas</h1>
        <p class="parrafo">Especializada en sanar y cuidar muy bien a tus animalitos.<p>

        <div class="login">
            <h1>Login</h1>
            <div><%
                String login_msg=(String)request.getAttribute("error");  
                if(login_msg!=null)
                out.println("<font color=red size=4px>"+login_msg+"</font>");
                %></div><br/>

            <form action="LoginServlet" method="post">
                <input type="text" name="username" placeholder="Username" required="required" />
                <input type="password" name="password" placeholder="Password" required="required" />
                <button type="submit" class="btn btn-primary btn-block btn-large">Ingresar</button><br/>
            </form>
                <button onclick="location.href = 'register.jsp';" class="btn btn-primary btn-block btn-large" >Registro</button><br/>
               
        </div>

    </body>
</html>
