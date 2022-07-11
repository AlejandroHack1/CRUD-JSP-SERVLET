
package services;

import Modelo.claseUsuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class insertUser {

    public int registerUser(claseUsuario usuarios) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO usuarios"
                + "  (nombre, apellidos, usuario, contrasena, direccion, telefono) VALUES "
                + " (?, ?, ?, ?, ?,?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try ( Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/veterinaria?useSSL=false", "root", "3809");  PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, usuarios.getFirstname());
            preparedStatement.setString(2, usuarios.getLastname());
            preparedStatement.setString(3, usuarios.getUsername());
            preparedStatement.setString(4, usuarios.getPassword());
            preparedStatement.setString(5, usuarios.getDirection());
            preparedStatement.setString(6, usuarios.getPhone());

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
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
