/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author el3ctrix
 */
public class Conexion {
    
    public Conexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        }catch(Exception e){
            System.out.println("Driver Not found error:" + e.getMessage());
        }
    }
    
    public int iniciaConexion(String name, String password){
        Connection conn = null;
        int result = 0;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajax",
                    "root","riekaneko117");
            String query = "select * from USUARIO where nombre ='"+name+"' and contraseña='"+password+"'";
            Statement st = conn.prepareStatement(query);
            
            ResultSet rs = st.executeQuery(query);
            if(rs.next()){
                result = 1;
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return result;
    }
    
    public int insertarUsuario(String name, String password){
        Connection conn = null;
        int result = 0;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajax",
                    "root","riekaneko117");
            String query = "insert into USUARIO values('"+name+"','"+password+"');";
            Statement st = conn.createStatement();
            if(!(iniciaConexion(name,password) > 0)){
                st.executeUpdate(query);
                result = 1;
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return result;
    }
    
    public String obtenImagen(int id){
        Connection conn = null;
        String result = "";
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajax",
                    "root","riekaneko117");
            String query = "select * from IMAGENES where id ="+id;
            Statement st = conn.prepareStatement(query);
            
            ResultSet rs = st.executeQuery(query);
            if(rs.next()){
                result = rs.getString(2);
                
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return result;
    }
}
