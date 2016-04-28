
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Conexion_BD {
    
         
    public static Connection conexion()
    {
        Connection con=null;
     
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/sihissste_db", "vmcc", "sih-issste");
            System.out.println("Conexion exitosa");
        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD "
                    +ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            con=null;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD "+
                    ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            con=null;
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            con=null;
        }
        finally
        {
            return con;
        }
    }
    
    public void prueba(){
        System.out.println("Hola");
        boolean estado = false;
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