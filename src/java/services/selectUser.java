/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import Modelo.claseUsuario;
import java.sql.*;

/**
 *
 * @author xespi
 */
public class selectUser {

    public claseUsuario checkUser(String username, String password) throws SQLException,
            ClassNotFoundException {
        String jdbcURL = "jdbc:mysql://localhost:3306/veterinaria";
        String dbUser = "root";
        String dbPassword = "3809";

        Class.forName("com.mysql.jdbc.Driver");
        claseUsuario user = null;
        try ( Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String sql = "SELECT * FROM usuarios WHERE usuario = ? and contrasena = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                user = new claseUsuario();
                user.setIdUsuario(result.getInt("idUsuario"));
                user.setFirstname(result.getString("nombre"));
                user.setLastname(result.getString("apellidos"));
                user.setPassword(result.getString("contrasena"));
                user.setDirection(result.getString("direccion"));
                user.setPhone(result.getString("telefono"));
                user.setUsername(result.getString("usuario"));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return user;

    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException sQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + sQLException.getSQLState());
                System.err.println("Error Code: " + sQLException.getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
