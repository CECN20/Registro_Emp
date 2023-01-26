/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleado;

/**
 *
 * @author mariopatriciogonzalezgallegos
 */
public class Empleado {

    //atributos
    private String rut;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String tipoEmpleado;
    private int telefono;
    private Boolean esIndefinido;

    //constructores
    public Empleado(
            String rut, 
            String nombres, 
            String apellidoPaterno, 
            String apellidoMaterno,
            String tipoEmpleado, 
            int telefono,
            Boolean esIndefinido) {
        this.rut = rut;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.tipoEmpleado = tipoEmpleado;
        this.telefono = telefono;
        this.esIndefinido = esIndefinido;
    }
    
    public Empleado() {
       
    }
    
    public void ClearEmpleado(){
        
    }
    //Getter y Setters

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
        /**
     * @return the tipoEmpleado
     */
    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    /**
     * @param tipoEmpleado the tipoEmpleado to set
     */
    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    /**
     * @return the esIndefinido
     */
    public Boolean getEsIndefinido() {
        return esIndefinido;
    }

    /**
     * @param esIndefinido the esIndefinido to set
     */
    public void setEsIndefinido(Boolean esIndefinido) {
        this.esIndefinido = esIndefinido;
    }
    
    public String IndefinidoToString(Boolean comp){
        String esIndefinidoStr = "";
       if(this.getEsIndefinido() == true){
           return esIndefinidoStr = "Indefinido";
       }else{
           return esIndefinidoStr = "No es indefinido";
       }
    }
    
    public void imprimir(){
       
        String imp = "EMPLEADO\n\n" +
                     "RUT: " + this.getRut() + "\n"+
                     "NOMBRES: " + this.getNombres() + "\n" +
                     "APELLIDOS: " + this.getApellidoPaterno() + " " + this.getApellidoMaterno() + "\n"+
                     "TIPO EMPLEADO:"+this.getTipoEmpleado()+"\n"+
                     "TELEFONO CONTACTO:"+this.getTelefono()+"\n"+
                     "TIPO CONTRATO:"+IndefinidoToString(this.getEsIndefinido())+"\n";
        System.out.println(imp);
    }

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }


    
    
    
    
    
}
