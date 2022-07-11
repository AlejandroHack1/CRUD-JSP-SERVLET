package services;

import Modelo.claseMascota;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class operationPets {

    String jdbcURL = "jdbc:mysql://localhost:3306/veterinaria";
    String dbUser = "root";
    String dbPassword = "3809";

    public int registerPets(claseMascota mascotas) throws ClassNotFoundException {

        String INSERT_USERS_SQL = "INSERT INTO mascotas"
                + "  (idUsuario, nombre, raza, especie, color, genero, peso, edad, diagnostico) VALUES "
                + " (?, ?, ?, ?, ?,?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try ( Connection connection = DriverManager
                .getConnection(jdbcURL, dbUser, dbPassword);  PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {

            preparedStatement.setInt(1, mascotas.getIdUsuario());
            preparedStatement.setString(2, mascotas.getNombre());
            preparedStatement.setString(3, mascotas.getRaza());
            preparedStatement.setString(4, mascotas.getEspecie());
            preparedStatement.setString(5, mascotas.getColor());
            preparedStatement.setString(6, mascotas.getGenero());
            preparedStatement.setInt(7, mascotas.getPeso());
            preparedStatement.setInt(8, mascotas.getEdad());
            preparedStatement.setString(9, mascotas.getDiagnostico());

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }

    public List listPets(int idUsuario) throws SQLException,
            ClassNotFoundException {
        List<claseMascota> listaMascota = new ArrayList<>();

        Class.forName("com.mysql.jdbc.Driver");
        try ( Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String sql = "SELECT * FROM mascotas WHERE idUsuario = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idUsuario);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                claseMascota mascota = new claseMascota();
                mascota.setIdMascota(result.getInt("idMascota"));
                mascota.setColor(result.getString("color"));
                mascota.setDiagnostico(result.getString("diagnostico"));
                mascota.setEdad(result.getInt("edad"));
                mascota.setNombre(result.getString("nombre"));
                mascota.setEspecie(result.getString("especie"));
                mascota.setGenero(result.getString("genero"));
                mascota.setPeso(result.getInt("peso"));
                mascota.setRaza(result.getString("raza"));

                listaMascota.add(mascota);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return listaMascota;

    }

    public List listPetsEdit(int idMascota) throws SQLException,
            ClassNotFoundException {
        List<claseMascota> listaMascotaById = new ArrayList<>();

        Class.forName("com.mysql.jdbc.Driver");
        try ( Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String sql = "SELECT * FROM mascotas WHERE idMascota = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idMascota);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                claseMascota mascota = new claseMascota();
                mascota.setIdMascota(result.getInt("idMascota"));
                mascota.setColor(result.getString("color"));
                mascota.setDiagnostico(result.getString("diagnostico"));
                mascota.setEdad(result.getInt("edad"));
                mascota.setNombre(result.getString("nombre"));
                mascota.setEspecie(result.getString("especie"));
                mascota.setGenero(result.getString("genero"));
                mascota.setPeso(result.getInt("peso"));
                mascota.setRaza(result.getString("raza"));

                listaMascotaById.add(mascota);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return listaMascotaById;

    }

    public int updatePets(claseMascota mascotas) throws ClassNotFoundException {

        String UPDATE_USERS_SQL = "UPDATE mascotas SET nombre=?, raza=?, especie=?, color=?, genero=?, peso=?, edad=?, diagnostico=? WHERE idMascota = ? ";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try ( Connection connection = DriverManager
                .getConnection(jdbcURL, dbUser, dbPassword);  PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {

            preparedStatement.setString(1, mascotas.getNombre());
            preparedStatement.setString(2, mascotas.getRaza());
            preparedStatement.setString(3, mascotas.getEspecie());
            preparedStatement.setString(4, mascotas.getColor());
            preparedStatement.setString(5, mascotas.getGenero());
            preparedStatement.setInt(6, mascotas.getPeso());
            preparedStatement.setInt(7, mascotas.getEdad());
            preparedStatement.setString(8, mascotas.getDiagnostico());
            preparedStatement.setInt(9, mascotas.getIdMascota());

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }

    public int deletePets(int idUsuario) throws ClassNotFoundException {

        String DELETE_USERS_SQL = "DELETE FROM mascotas WHERE idMascota = ?";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try ( Connection connection = DriverManager
                .getConnection(jdbcURL, dbUser, dbPassword);  PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL)) {
            preparedStatement.setInt(1, idUsuario);
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
