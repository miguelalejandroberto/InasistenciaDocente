/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaException.BDException;
import CapaException.PersonaException;
import CapaPersistencia.PersistenciaDocente;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
/**
    *Metodo encargado de  comunicar con la persistencia
    * @throws PersonaException
    */
public class FachadaPersona {
    public void guardarInasistencia(InasistenciaDocente doc) throws  Exception {
        
         PersistenciaDocente pers = new PersistenciaDocente();
         pers.guardarInasistecia(doc);
      
    }
//    public  Persona busquedaPorCi(String ci) throws PersonaException,Exception {
//        Persona per = new Persona();
//        PersistenciaDocente pers = new PersistenciaDocente();
//        per = pers.busquedaPorCi(ci);
//        return per;
//    }
//        
   public void eliminarIansistencia(String ci) throws PersonaException, Exception {
      PersistenciaDocente pers = new PersistenciaDocente();
        pers.eliminarInasistencia(ci);

    }
   // Llama al método de persistencia para registrar
    public void registrarUsuario(Login login) throws Exception {
        PersistenciaDocente pers = new PersistenciaDocente();
        pers.registrar(login);
    }

    // Llama al método de persistencia para iniciar sesión
    public boolean iniciarSesion(String usuario, String contrasenia) throws Exception {
        PersistenciaDocente pers = new PersistenciaDocente();
        return pers.iniciarSesion(usuario, contrasenia);
    }
}
