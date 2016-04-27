
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static javax.print.attribute.Size2DSyntax.MM;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abril
 */
public class TDA_Personal {
    private String nombre, APat, AMat, Dir, RFC, especialidad, telca, telcel, 
              pass, correo, fecha, Hora, CP, Status;
            int clinica, puesto, areaT;
            
            
      public boolean registrar(){
         Connection miCon = (new Conexion_BD()).conexion();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
        String sql = "insert into `SihISSSTE_DB`.`Personal`(`RFC_Personal`, `Nombre_Personal`, `APaterno_Personal`, `AMaterno_Personal`, `Direccion_Personal`, `CodigoPos_Personal`, `TelefonoCasa_Personal`, `TelefonoCelular_Personal`, `HorarioTrab_Personal`, `CorreoElec_Personal`, `Password_Personal`, `NomEsp_Personal`, `FechaIniServicio_Personal`, `id_Puesto`, `id_Clinica`, `id_AreaT`)values('"
                +RFC+"', '"+nombre+"', '"+APat+"', '"+AMat+"', '"+Dir+"', '"+CP+"', '"
                +telca+"', '"+telcel+"', '"+Hora+"', '"+correo+"', '"+pass+"', '"+especialidad+"', '"+fecha+"', '"+puesto+"', '"+clinica+"', '"+areaT+"');";
            stmt.executeUpdate(sql);
                 //JOptionPane.showMessageDialog(null, "Registro exitoso");
                         
              miCon.close();
              return true;
            
            }catch(Exception e){
               // JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
              return false;
              
            }
            
        } 
        return true;
      }
      
     /* public boolean comprobarReubicacion(){
          Connection miCon =(new Conexion_BD()).conexion();
          if(miCon!=null){
              try{
               Statement stmt = miCon.createStatement();
               String sql= "select count(`Status_CitaMedica`) from ``SihISSSTE_DB`.`CitaMedica` where RFC_Personal = '"+RFC+"' and Status_CitaMedica= '"+Status+"';";
        ResultSet r = stmt.executeQuery(sql);//consultas regresa algo executeUpdate
       
                    if(a!=0){
                      reubicacion();
                    }
                    
                    
              }catch(Exception e){
                  return false;
              }
          }
         return true;
      }*/

      public boolean reubicacion(){
          Connection miCon =(new Conexion_BD()).conexion();
          if(miCon!=null){
              try{
               Statement stmt = miCon.createStatement();
        String sql ="UPDATE `SihISSSTE_DB`.`Personal` SET `id_Clinica`='"+clinica+"', `id_AreaT`='"+areaT+"' WHERE `RFC_Personal`='"+RFC+"';";
         stmt.executeUpdate(sql);
          JOptionPane.showMessageDialog(null, "Registro exitoso");
         miCon.close();
              return true;
              }catch(Exception e){
                  JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                  return false;
              }
      }
         return true;
      }
      
  public String getNombre(){
   return nombre;  
}
  
  public void setNombre(String nombre){
      this.nombre= nombre;
  }
      
  public String getApellidoPat(){
      return APat;
  }
  
  public void setApellidoPat(String APat){
      this.APat=APat;
  }
  
  public String getAMaterno(){
      return AMat;
  }
  
  public void setAMaterno(String AMat){
      this.AMat=AMat;
  }
  
  public String getDir(){
      return Dir;
  }
  
  public void setDir(String Dir){
      this.Dir=Dir;
  }
  
  public String getRFC(){
      return RFC;
  }
  
  public void setRFC(String RFC){
      this.RFC=RFC;
  }
  public String getEspecialidad(){
      return especialidad;
  }
  
  public void setEspecialidad(String especialidad){
      this.especialidad=especialidad;
  }
  
  public String getTelefonoCasa(){
      return telca;
  }
  
  public void setTelefonoCasa(String telefono){
      this.telca=telefono;
  }
  
  public String getTelefonoCel(){
      return telcel;
  }
  
  public void setTelefonoCel(String telcel){
      this.telcel= telcel;
  }
  
  public int getClinica(){
      return clinica;
  }
  
  public void setClinica(int clinica){
      this.clinica=clinica;
  }
  
  public int getPuesto(){
      return puesto;
  }
  public void setPuesto(int puesto){
      this.puesto=puesto;
  }
  public String getPass(){
      return pass;
  }
  
  public void setPass(String pass){
      this.pass=pass;
  }
  
  public String getEmail(){
      return correo;
  }
  
  public void setEmail(String correo){
      this.correo=correo;
  }
  
  public String getHora(){
      return Hora;
  }
  
  public void setHora(String Hora){
      this.Hora=Hora;
  }
  public String getPostalCode(){
      return CP;
  }
  public void setPostalCode(String CP){
      this.CP=CP;
  }
 
  public int getArea(){
      return areaT;
  }
  
  public void setArea(int areaT){
      this.areaT=areaT;
  }
  
  public String getFecha(){
      return fecha;
  }
  
  public void setFecha(String fecha){
       
      
        this.fecha = fecha;

}
  
  public String getStatus(){
    return Status;
  }
  
  public void setStatus(String Status){
      this.Status=Status;
  }
      
}
  


