/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaException;



/**
 *
 * @author Usuario
 */
public class BDException extends Exception {
//Recibe un String message (mensaje de error que quieras mostrar).
//super(message) llama al constructor de la 
//clase Exception y guarda ese mensaje para 
//que después puedas acceder a él con getMessage().
    public BDException(String message) {
        super(message);
    }
     
    }


    
    

