/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Habitacion_data {
    private Connection conexion=null;
    private Habitacion h = new Habitacion();
    private TipoHabitacion th = new TipoHabitacion();
    
    public Habitacion_data(Conexion con){
    
        this.conexion=con.buscarConexion();
        
    }
    
    public List listarHabitaciones(){
        List  <Habitacion> habitacionList = new ArrayList<>();
        String sql = "SELECT * FROM habitacion h JOIN tipohabitacion th ON (h.idTipoHabitacion = th.idTipoHabitacion)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                h.setIdHabitacion(rs.getInt("idHabitacion"));
                h.setNroHabitacion(rs.getInt("nroHabitacion"));
                h.setNroHabitacion(rs.getInt("piso"));
                h.setOcupada(rs.getBoolean("ocupada"));
                h.setTipoHab(th);
                th.setCantidadCamas(rs.getInt("cantidadCamas"));
                th.setCantidadPersonas(rs.getInt("cantidadPersonas"));
                th.setTipoCamas(rs.getString("tipoCamas"));
                th.setPrecioPorNoche(rs.getDouble("precioPorNoche"));
                habitacionList.add(h);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }

        return habitacionList;
        
        
     
    }    
    
    
    public void agregarHabitacion(TipoHabitacion tipo, int nro, int piso, boolean ocupada){
        
        String sql = "INSERT INTO habitacion (idTipoHabitacion, nroHabitacion, piso, ocupada) VALUES (?,?,?,?);";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,tipo.getIdTipoHabitacion());
            ps.setInt(2,nro);
            ps.setInt(3,piso);
            ps.setBoolean(4,ocupada);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                h.setIdHabitacion(rs.getInt(1));           
            }else{
                JOptionPane.showMessageDialog(null,"Error al obtener el ID");
            }           
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de sentencia");
        }
    }    
    

    public Habitacion buscarHabitacion(int nro, int piso){
                
        String sql = "SELECT * FROM habitacion h JOIN tipoHabitacion th ON (h.idTipoHabitacion = th.idTipoHabitacion) WHERE nroHabitacion = ? AND piso = ?";
        
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ps.setInt(1, nro);
            ps.setInt(2, piso);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){                
                h.setIdHabitacion(rs.getInt("idHabitacion"));
                h.setNroHabitacion(rs.getInt("nroHabitacion"));
                h.setPiso(rs.getInt("piso"));                
                h.setOcupada(rs.getBoolean("ocupada"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }        
        return h;
    }
    
    public void modificarHabitacion(String nombreHabitacion, int anio, boolean estado){
        String sql="UPDATE habitacion SET anio=?,estado=? WHERE nombreHabitacion LIKE ?";

        
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);            
            ps.setInt(1, anio);
            ps.setBoolean(2, estado);
            ps.setString(3, nombreHabitacion);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "La habitacion ha sido actualizada");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }    
    }

    public void modificarEstado(String nombreHabitacion, boolean estado){
        String sql="UPDATE habitacion SET estado=? WHERE nombreHabitacion LIKE ?";
        
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setString(2, nombreHabitacion);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "El estado de la habitacion ha sido actualizada");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sentencia");
        }
    }
    
    public void eliminarHabitacion(String nombre){
    

        String sql="DELETE FROM habitacion WHERE nombreHabitacion LIKE ?";
        
        try {
            PreparedStatement ps=conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "La habitacion ha sido eliminada");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error. La habitacion se encuentra vinculada");
        } catch (Exception e){
          JOptionPane.showMessageDialog(null, "Error");
        }
        
    }
    
}
