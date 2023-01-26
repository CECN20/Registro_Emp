/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validador;

/**
 *
 * @author mariopatriciogonzalezgallegos
 */
public class Validador {
    

    public static boolean validarRut(String rut) {

        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }
    
    
    public static void validarTamanioTexto(String texto,
            int tamanioInicial, int tamanioFinal,
            String nombreCampo) throws Exception{
    
        
        if(texto.length() < tamanioInicial ||
                texto.length() > tamanioFinal){
        
            String mensajeError = "EL TAMAÑO DE " +
                    nombreCampo + " DEBE SER MAYOR QUE "  +
                    tamanioInicial + " Y MENOR QUE " +
                    tamanioFinal;
            
            throw new Exception(mensajeError);
        }        
    }
    
    public void validarTextoVacio(String texto, 
            String nombreCampo) throws Exception{
    
        
        if(texto == null || "".equals(texto)){
            
            String mensajeError = "DEBE INGRESAR " +
                    "INFORMACIÓN EN EL CAMPO " + 
                    nombreCampo;
            
            throw new Exception(mensajeError);
        }
        
    }
}
