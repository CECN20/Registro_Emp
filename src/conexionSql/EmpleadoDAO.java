/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionSql;

import empleado.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mariopatriciogonzalezgallegos
 */
public class EmpleadoDAO {
    //CAmbiar query y revisar

    public String validarRut(String rut) {
        boolean resultado = false;
        String query = "SELECT RUT FROM EMPLEADO WHERE RUT = ?";
        String rutEncontrado = "";

        try {
            PreparedStatement emp = ConexionDAO.getConnection().prepareStatement(query);

            int i = 1;
            emp.setString(i++, rut);
            ResultSet rs = emp.executeQuery();

            while (rs.next()) {

                rutEncontrado = rs.getString("RUT");
            }

        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        return rutEncontrado;
    }

    public boolean insertar(Empleado empleado) {

        //validar que rut no exista        
        String rutExiste = validarRut(empleado.getRut());
        if (rutExiste.length() > 0) {
            JOptionPane.showMessageDialog(null, "El rut ya se encuentra registrado.");
            return false;
        }

        boolean resultado = false;
        String query = "INSERT INTO EMPLEADO (RUT, NOMBRES, APELLIDO_PATERNO,"
                + "APELLIDO_MATERNO, TIPO_EMPLEADO, TELEFONO_CONTACTO, CONTRATO_INDEFINIDO) VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement emp = ConexionDAO.getConnection().prepareStatement(query);

            int i = 1;
            emp.setString(i++, empleado.getRut());
            emp.setString(i++, empleado.getNombres());
            emp.setString(i++, empleado.getApellidoPaterno());
            emp.setString(i++, empleado.getApellidoMaterno());
            emp.setString(i++, empleado.getTipoEmpleado());
            emp.setInt(i++, empleado.getTelefono());
            emp.setString(i++, empleado.getEsIndefinido().toString());

            emp.execute();

            resultado = true;
        } catch (SQLException ex) {

            ex.printStackTrace();
        }

        return resultado;
    }

    public List<Empleado> listar() {

        List<Empleado> empleados = new ArrayList<>();

        String query = "SELECT RUT, NOMBRES, APELLIDO_PATERNO, "
                + "APELLIDO_MATERNO,TIPO_EMPLEADO,TELEFONO_CONTACTO, CONTRATO_INDEFINIDO"
                + " FROM EMPLEADO";

        try {

            PreparedStatement ps = ConexionDAO.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                //Crear objeto empleado
                Empleado emp = new Empleado();
                emp.setRut(rs.getString("RUT"));
                emp.setNombres(rs.getString("NOMBRES"));
                emp.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
                emp.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
                emp.setTipoEmpleado(rs.getString("TIPO_EMPLEADO"));
                emp.setTelefono(rs.getInt("TELEFONO_CONTACTO"));
                emp.setEsIndefinido(Boolean.TRUE);

                empleados.add(emp);
            }

        } catch (Exception ex) {
            System.out.println("Error => " + ex.getMessage());
            ex.printStackTrace();
        }

        return empleados;
    }

    public boolean actualizar(Empleado empleado) {

        boolean resultado = false;
        String query = "UPDATE EMPLEADO SET NOMBRES = ?, APELLIDO_PATERNO = ?, "
                + "APELLIDO_MATERNO = ?, TIPO_EMPLEADO = ?, TELEFONO_CONTACTO = ?, CONTRATO_INDEFINIDO = ? WHERE RUT = ?";

        try {
            PreparedStatement emp = ConexionDAO.getConnection().prepareStatement(query);

            int i = 1;
            emp.setString(i++, empleado.getNombres());
            emp.setString(i++, empleado.getApellidoPaterno());
            emp.setString(i++, empleado.getApellidoMaterno());
            emp.setString(i++, empleado.getTipoEmpleado());
            emp.setInt(i++, empleado.getTelefono());
            emp.setBoolean(i++, empleado.getEsIndefinido());
            emp.setString(i++, empleado.getRut());

            emp.execute();

            resultado = true;
        } catch (SQLException ex) {

            ex.printStackTrace();
        }

        return resultado;
    }

    /**
     * Método borrar según rut
     *
     * @param rut
     * @return
     */
    public boolean borrar(String rut) {

        boolean resultado = false;

        String query = "DELETE FROM EMPLEADO WHERE RUT = ?";

        try {

            PreparedStatement emp = ConexionDAO.getConnection().prepareStatement(query);
            int i = 1;
            emp.setString(i++, rut);

            emp.execute();
            resultado = true;

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return resultado;
    }

    public Empleado buscarPorRut(String rut) {

        Empleado emp = null;

        String query = "SELECT RUT, NOMBRES, APELLIDO_PATERNO, "
                + "APELLIDO_MATERNO, TIPO_EMPLEADO, TELEFONO_CONTACTO, CONTRATO_INDEFINIDO"
                + " FROM EMPLEADO "
                + "WHERE RUT = ?";

        try {

            PreparedStatement connection = ConexionDAO.getConnection().prepareStatement(query);

            int i = 1;
            connection.setString(i++, rut);

            ResultSet rs = connection.executeQuery();

            while (rs.next()) {

                //Crear objeto paciente
                emp = new Empleado();
                emp.setRut(rs.getString("RUT"));
                emp.setNombres(rs.getString("NOMBRES"));
                emp.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
                emp.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
                emp.setTipoEmpleado(rs.getString("TIPO_EMPLEADO"));
                emp.setTelefono(rs.getInt("TELEFONO_CONTACTO"));
                emp.setEsIndefinido(Boolean.TRUE);
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return emp;
    }

}
