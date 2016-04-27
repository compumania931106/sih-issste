
import java.sql.Connection;
import java.sql.ResultSet;
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
public class TDA_Informacion {
    String RFC;
    
   public TDA_Informacion(String rfc){
         setRFC(RFC);
    }
   
  public TDA_Informacion(){
       
   }
    
  public Object[] valores(){
        
        Connection miCon = (new Conexion_BD()).conexion();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
                Object o[]=new Object[4];
                String sql = "SELECT * FROM Personal";
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
            //stmt.executeQuery("SELECT COUNT(1) AS TOTAL FROM ANALISIS");
            ResultSet res= stmt.executeQuery("select count(*) as TOTAL from Personal;");
            res.next();
            x=res.getInt("TOTAL");
            //JOptionPane.showMessageDialog(null,x);
            res.close();
        }
        
        catch(Exception e){
            return null;
        }
        
        Object[]s= new String[7];
        
        try{
            Statement stmt=miCon.createStatement();
            ResultSet res= stmt.executeQuery("select RFC_Personal, Nombre_Personal, APaterno_Personal, Direccion_Personal, TelefonoCelular_Personal, FechaIniServicio_Personal, id_Clinica from Personal");
            
            
            while(res.next()){
                String id=res.getString("RFC_Personal");
                String nom=res.getString("Nombre_Personal");
                String des=res.getString("APaterno_Personal");
                String val=res.getString("Direccion_Personal");
                String tel=res.getString("TelefonoCelular_Personal");
                String fecha=res.getString("FechaIniServicio_Personal");
                String cli=res.getString("id_Clinica");
                //Object a=""+0;
                
                s[0]=id;
                s[1]=nom;
                s[2]=des;
                s[3]=val;
                s[4]=tel;
                s[5]=fecha;
                s[6]=cli;
                
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
    
     public void setRFC(String RFC) {
        this.RFC=RFC;
    }
    
}
