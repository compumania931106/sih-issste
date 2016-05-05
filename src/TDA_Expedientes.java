
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class TDA_Expedientes {
    private String rfc, sangre, fecha, hora, estatura, presion, temp, peso, IMC, frecuenciaC, frecuenciaR,
            perTor, perAb, percef, numExp, diagnostico, observaciones, pronostico;
    private int edad;
    
    public TDA_Expedientes(String rfc){
        setRfc(rfc);
    }
    
    public TDA_Expedientes(){
    
}
    
    public boolean registrarHistorial(){
        Connection miCon = (new Conexion_BD()).conexion();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
        String sql = 
   "insert into `HistorialClinico`(`id_ExpedienteClinico`, `Fecha_HistorialClinico`, `Hora_HistorialClinico`, `Estatura_HistorialClinico`, `Peso_ExpedienteClinico`, `FCardiaca_HistorialClinico`, `FRespiratoria_HistorialClinico`, `Temp_HistorialClinico`, `CabezaPerCef_HistorialClinico`, `PerToraxico_HistorialClinico`, `PerAbdominal_HistorialClinico`, `Presion_Historial`)values('"+numExp
      +"', '"+fecha+"', '"+hora+"', '"+estatura+"', '"+peso+"', '"+frecuenciaC+"', '"+frecuenciaR+"', '"+temp+"', '"+percef+"', '"+perTor+"', '"+
                        perAb+"'. '"+presion+"');";
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
    
    public boolean registrarExpediente(){
        Connection miCon = (new Conexion_BD()).conexion();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
        String sql = "insert into `ExpedienteClinico` (`RFC_Derechoh`, `TiSang_ExpedienteClinico`)values('"+rfc+"', '"+sangre+"');";
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

    public boolean numExpediente(){
        
        Connection miCon = (new Conexion_BD()).conexion();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
        String sql = "select id_ExpedienteClinico from ExpedienteClinico where RFC_Derechoh = '"+rfc+"';";
   ResultSet r = stmt.executeQuery(sql);//consultas regresa algo executeUpdate
                    if(r.next()==true){
                        numExp=r.getString("id_ExpedienteClinico");
                        javax.swing.JOptionPane.showMessageDialog(null, "Obteniendo");
                        return true;
                    }else{
                        miCon.close();
                    }
            }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
        }
        return true;
    }
    
    public boolean consultaExp(){
        Connection miCon = (new Conexion_BD()).conexion();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
        String sql="select h.id_ExpedienteClinico, h.Presion_Historial, h.Temp_HistorialClinico, e.TiSang_ExpedienteClinico, h.FCardiaca_HistorialClinico, h.FRespiratoria_HistorialClinico, h.PerAbdominal_HistorialClinico from HistorialClinico h inner join ExpedienteClinico e on e.id_ExpedienteClinico = h.id_ExpedienteClinico where RFC_Derechoh= '"+rfc+"';";
   ResultSet r = stmt.executeQuery(sql);//consultas regresa algo executeUpdate
                    while(r.next()==true){
                        numExp=r.getString("id_ExpedienteClinico");
                        presion=r.getString("Presion_Historial");
                        temp=r.getString("Temp_HistorialClinico");
                        sangre=r.getString("TiSang_ExpedienteClinico");
                        frecuenciaC=r.getString("FCardiaca_HistorialClinico");
                        frecuenciaR=r.getString("FRespiratoria_HistorialClinico");
                        perAb=r.getString("PerAbdominal_HistorialClinico");
                        javax.swing.JOptionPane.showMessageDialog(null, "Obteniendo");
                        return true;
                    }//else{
                        miCon.close();
                    //}
            }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
        }
        return true;
    }
    
    private int historialReciente(String RFC){
       this.rfc=RFC;
    numExpediente();
    String id=getNumExp();
        Connection miCon = (new Conexion_BD()).conexion();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
            String sql= "Select id_HistorialClinico from HistorialClinico where id_ExpedienteClinico= '"+id+"';";
            ResultSet r = stmt.executeQuery(sql);//consultas regresa algo executeUpdate
                    while(r.next()!=false){
                       if(r.next()==false){
                           miCon.close();
    return Integer.parseInt(r.getString("id_historial")); 
                
                  }
                    else
                       r.next();
                    miCon.close();
                    return 0; 
                    }
    
    }catch(Exception e){
       
    }
        }
      return 0;
    }
    
    /*public boolean actualizarHistorial(){
        Connection miCon = (new Conexion_BD()).conexion();
        if(miCon!=null){
            try{
               Statement stmt = miCon.createStatement();
               //String sql = 'Update HistorialClinico set PadecActual_HistorialClinico='diagnostico', Diagnostico_HistorialClinica ='observaciones', '
    }catch(Exception e){
        
    }
        }
    }*/
    
    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getSangre() {
        return sangre;
    }

    public void setSangre(String sangre) {
        this.sangre = sangre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstatura() {
        return estatura;
    }

    public void setEstatura(String estatura) {
        this.estatura = estatura;
    }

    public String getPresion() {
        return presion;
    }

    public void setPresion(String presion) {
        this.presion = presion;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getIMC() {
        return IMC;
    }

    public void setIMC(String IMC) {
        this.IMC = IMC;
    }

    public String getFrecuenciaC() {
        return frecuenciaC;
    }

    public void setFrecuenciaC(String frecuenciaC) {
        this.frecuenciaC = frecuenciaC;
    }

    public String getFrecuenciaR() {
        return frecuenciaR;
    }

    public void setFrecuenciaR(String frecuenciaR) {
        this.frecuenciaR = frecuenciaR;
    }

    public String getPerTor() {
        return perTor;
    }

    public void setPerTor(String perTor) {
        this.perTor = perTor;
    }

    public String getPerAb() {
        return perAb;
    }

    public void setPerAb(String perAb) {
        this.perAb = perAb;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNumExp() {
        return numExp;
    }

    public void setNumExp(String numExp) {
        this.numExp = numExp;
    }
    
}