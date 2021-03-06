
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


 */

/**
 *
 * @author VictorManuel
 */
public class ConexionDB {
    Connection con = null;
    
    public Connection conexion(){
        try{
           Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost/sihissste_db", "root", "Thebigboss931106{}");
           System.out.println("Conexion exitosa");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Problemas con la conexion (" + e.getMessage().toString() + ")");
        }
        return con;
    }
    
    public ResultSet SeleccionarTodoMedicamento(){
        Connection cn = conexion();
        Statement st;
        ResultSet rs = null;
        try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM medicamentos;");
        }catch(SQLException ex){
            System.out.println("Error al llenar la tabla de medicamentos");
        }
        return rs;
    }
    
    public ResultSet buscarPorNombreMedicamento(String cadena){
        Connection cn = conexion();
        Statement st;
        ResultSet rs = null;
        try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM medicamentos WHERE NombreGen_Medicamentos LIKE '"+ cadena +"%'");
        }catch(SQLException ex){
            System.out.println("Error" + ex.getMessage());
        }
        return rs;
    }
    
    
    
    public ResultSet buscarMedicamento(int id){
        Connection cn = conexion();
        Statement st;
        ResultSet rs = null;
        try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM medicamentos WHERE id_Medicamentos = "+ id +"");
        }catch(SQLException ex){
            System.out.println("Error al realiza consulta");
        }
        return rs;
    }
    
    
    public int actualizarMedicamentos(int idAct, String nombreAct, String descripAct, int cantAct, String presenAct, int id){
    int resultado = 0;
    String SQL = "UPDATE medicamentos SET id_Medicamentos = "+ idAct +", NombreGen_Medicamentos = '"+ nombreAct +"', Descripcion_Medicamentos = '"+ descripAct +"',Cantidad_Medicamento = "+ cantAct +", Presentacion = '"+ presenAct +"' WHERE id_Medicamento = "+ id +"";
    try{
            Connection cn = conexion();
            Statement comando=cn.createStatement();
            resultado = comando.executeUpdate(SQL);
        }catch(Exception e){}
        
        return resultado;
    }
    
    public int actualizarCantidadMedicamento(int cantidad, int id){
        int resultado = 0;
        String SQL = "UPDATE medicamentos SET Cantidad_Medicamento = "+ cantidad +" WHERE id_Medicamentos = "+ id +"";
        try{
            Connection cn = conexion();
            Statement comando=cn.createStatement();
            resultado = comando.executeUpdate(SQL);
        }catch(Exception e){}
        
        return resultado;
    }
    
    public boolean InsertarMedicamentos(int codigo, String nombre, String descripcion, int cantidad, String presentacion){
        Connection cn = conexion();
        String SQL = "INSERT INTO medicamentos VALUES (?,?,?,?,?);";
        try{
            PreparedStatement pst = cn.prepareStatement(SQL);
            
            pst.setInt(1, codigo);
            pst.setString(2, nombre);
            pst.setString(3, descripcion);
            pst.setInt(4, cantidad);
            pst.setString(5, presentacion);
            
            int n = pst.executeUpdate();
            
            if(n != 0){
               return true;
            }else{
                return false;
            }
            
        }catch(SQLException ex){
            System.out.println(ex);
        }
        
        return false;
    }
    
    
}
