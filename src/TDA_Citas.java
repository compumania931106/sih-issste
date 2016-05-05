
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abril
 */
public class TDA_Citas {
    String rfc;
    
   public Object[] valores(){
        
        Connection miCon = (new Conexion_BD()).conexion();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
                Object o[]=new Object[4];
                String sql = "SELECT * FROM CitaMedica";
                ResultSet r = stmt.executeQuery(sql);
                while(r.next()){
                    
                    
                   
                }
                
                miCon.close();
                return null;
            }
            catch(Exception e){
                //JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }
        return null;
    }
   
   
   public Object[] getDatos(DefaultTableModel modelo){
        Connection miCon=(new Conexion_BD()).conexion();
        int x=0;//Obtención de registros existentes
        try{
            Statement stmt=miCon.createStatement();
            ResultSet res= stmt.executeQuery("SELECT COUNT(*) AS CONSULTAS FROM CitaMedica");
            res.next();
            x=res.getInt("Consultas");
            //JOptionPane.showMessageDialog(null,x);
            res.close();
        }
        
        catch(Exception e){
            return null;
        }
        
        Object[]s= new String[6];
        boolean[]s1=new boolean[1];
        
        try{
            Statement stmt=miCon.createStatement();
            ResultSet res= stmt.executeQuery("SELECT * FROM CitaMedica where status='A'");
            
            
            while(res.next()){
                String id=res.getString("id_CitaMedica");
                String nom=res.getString("Fecha_CitaMedica");
                String des=res.getString("Hora_CitaMedica");
                String rfc=res.getString("RFC_Derechoh");
                String con=res.getString("NoConsultorio");
                //boolean status=res.getBoolean("Status_CitaMedica");
                
                //Object a=""+0;
                
                s[0]=id;
                s[1]=nom;
                s[2]=des;
                s[3]=rfc;
                s[4]= con;
                //s[5]=status;
                
                modelo.addRow(s);
                
            }
            
            res.close();
            return s;
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        
    }
   
   /*public boolean status(){
       Connection miCon = (new Conexion_BD()).conexion();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
               //String sql = "Update CitaMedica set 'C' where"
               miCon.close();
               return true;
   }catch(Exception e){
       JOptionPane.showMessageDialog(null, "El campo fue actualizado correctamente");
       return false;
   }
    
}
   }*/
}
