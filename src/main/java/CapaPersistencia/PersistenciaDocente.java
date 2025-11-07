/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaPersistencia;

import CapaException.PersonaException;
import CapaException.BDException;
import CapaLogica.InasistenciaDocente;
import CapaLogica.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class PersistenciaDocente {
    private static final String SQL_GUARDAR_INASISTENCIA=("INSERT INTO miguel.inasistenciadocente(ci,fecha_in,fecha_fin,motivo,turno,grupo) VALUES (?,?,?,?,?,?)");
    private static final String SQL_CONSULTA_PERSONA = ("SELECT * FROM miguel.inasistenciadocente where ci=?");
    private static final String SQL_ELIMINAR_INASISTENCIA = ("DELETE FROM inasistenciadocente WHERE Ci= ?");
     private static final String SQL_REGISTRAR = ("INSERT INTO miguel.usuario(nombre_usuario, contrasenia) VALUES (?, ?)");
    private static final String SQL_INICIAR_SESION = ("SELECT * FROM miguel.usuario WHERE nombre_usuario = ? AND contrasenia = ?");
    public Conexion cone=new Conexion();
     public PreparedStatement ps;//prepara los datos
     public ResultSet rs;//devuelve los datos
//PreparedStatement es una interfaz en Java que hereda de la interfaz Statement. 
//Se utiliza para representar una sentencia SQL precompilada. 
//A diferencia de un objeto Statement normal, un PreparedStatement se precompila 
//y se almacena en caché en el servidor de la base de datos,lo que puede mejorar significativamente 
//el rendimiento en situaciones donde se ejecutan consultas similares varias veces.  
// Un PreparedStatement se compila una vez y puede ser reutilizado con diferentes 
//     conjuntos de parámetros. Esto puede ser más eficiente 
  //que crear y ejecutar nuevas declaraciones SQL cada vez que se necesita realizar 
 //una consulta o una actualización. 
  // Método para registrar un nuevo usuario
    public void registrar(Login login) throws Exception {
        try {
            Connection con = cone.getConnection();
            ps = con.prepareStatement(SQL_REGISTRAR);
            ps.setString(1, login.getNombre_usuario());
            ps.setString(2, login.getContrasenia());
            int resultado = ps.executeUpdate();

            if (resultado <= 0) {
                throw new Exception("No se pudo registrar el usuario.");
            }
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error al registrar usuario: " + e.getMessage());
        }
    }

    // Método para validar usuario y contraseña
    public boolean iniciarSesion(String nombreUsuario, String contrasenia) throws Exception {
        boolean valido = false;
        try {
            Connection con = cone.getConnection();
            ps = con.prepareStatement(SQL_INICIAR_SESION);
            ps.setString(1, nombreUsuario);
            ps.setString(2, contrasenia);
            rs = ps.executeQuery();

            if (rs.next()) {
                valido = true; // usuario encontrado
            }
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error al validar inicio de sesión: " + e.getMessage());
        }
        return valido;
    }    
      public void  guardarInasistecia(InasistenciaDocente doc)throws Exception,SQLException {
 //try: Marca el comienzo del bloque de código en el que se intentará ejecutar ciertas operaciones. 
 //Si ocurre una excepción durante la ejecución de este bloque, el control se transfiere al bloque 
 //catch correspondiente.        
        try { 
        int resultado = 0;


//Connection: Es una interfaz en Java que representa una conexión con una base de datos. 
//Se utiliza para crear objetos Statement, manejar transacciones y ejecutar consultas SQL.

//base: Es una instancia del objeto que tiene un método llamado getConnection(). 
//En el contexto de bases de datos, es común que este método devuelva una conexión a una base de datos.
 //Significa que se está obteniendo una conexión a una base de datos utilizando el método getConnection() 
 //de la instancia base, y esa conexión se almacena en la variable con para su posterior uso en 
 //operaciones de base de datos, como ejecutar consultas o transacciones.      

            Connection con = cone.getConnection();
//con.prepareStatement(SQLGuardar): Aquí, con es una instancia de la clase Connection, y prepareStatement
//(SQLGuardar) es un método que se utiliza para crear un objeto PreparedStatement. 
//Un PreparedStatement es una clase que representa una instrucción SQL precompilada.
//esta línea de código está preparando una instrucción SQL para guardar un personaje en la base de datos 
//y asignando esa instrucción preparada a una variable ps de tipo PreparedStatement.
            ps = (PreparedStatement) con.prepareStatement(SQL_GUARDAR_INASISTENCIA);
            ps.setString(1, doc.getCi());  
            ps.setString(2, doc.getFecha_in());
            ps.setString(3, doc.getFecha_fin());
            ps.setString(4, doc.getMotivo());
            ps.setString(5, doc.getTurno()); 
            ps.setString(6, doc.getGrupo()); 
          
            
//Este método executeUpdate,se emplea para ejecutar consultas SQL que realizan actualizaciones, 
//eliminaciones o inserciones en una base de datos. 
//Este método devuelve un entero que indica el número de filas afectadas por la operación.
            resultado = ps.executeUpdate();
//catch: Es una palabra clave que indica el comienzo de un bloque de código que manejará 
//una excepción específica.

//(SQLException e)Especifica el tipo de excepción que este bloque catch manejará. En este caso, 
//se está manejando una excepción de tipo SQLException. 
//La variable e es una referencia a la instancia de la excepción, y se puede usar para acceder a 
//información sobre la excepción, como mensajes de error.

        } catch (SQLException e) {
//El comando throw en Java se utiliza para lanzar una excepción manualmente. 
//Cuando se detecta una condición inusual o un error en tu código y deseas notificar ese error.
//Aquí, excepcion es una instancia de una clase que hereda de la clase Throwable. 
//Puedes lanzar tanto excepciones estándar proporcionadas por Java como crear tus propias clases de excepción.
//La clase Throwable es la clase base para todas las clases de excepciones y errores en Java. 
//Tanto las excepciones como los errores son subclases de Throwable. 
//Esta clase implementa la interfaz Serializable, lo que significa que las instancias de sus subclases 
//se pueden convertir en una secuencia de bytes y posteriormente restaurar.
            throw new Exception("Tuve un problemita en la base");

        }
    }
    public InasistenciaDocente busquedaPorCi(String ci) throws Exception, BDException, SQLException { 
       InasistenciaDocente perso = new InasistenciaDocente();

        try {
            Connection con;
            con = cone.getConnection();
            ps = (PreparedStatement) con.prepareStatement(SQL_CONSULTA_PERSONA);
            ps.setString(1, ci);
            rs = ps.executeQuery();// este método executeQuery se utiliza,cuando en una consulta SQL,
            //nos devuelve un objeto,en este caso un personaje.
            if (rs.next()) {
                String Ci = rs.getString("Ci");
                String Fecha_in = rs.getString("Fecha Inicio");
                String Fecha_Fin = rs.getString("Fecha Fin");
                String Motivo = rs.getString("Motivo");
                String Turno = rs.getString("Turno");
                String Grupo = rs.getString("Grupo");
                perso.setCi(Ci);
                perso.setFecha_in(Fecha_in);
                perso.setFecha_fin(Fecha_Fin);
                perso.setMotivo(Motivo);
                perso.setTurno(Turno);
                perso.setGrupo(Grupo);
            } else {
                throw new PersonaException("La persona no esta ingresada, por favor ingreselo");
            }//Las conexiones a la base de datos son recursos limitados y valiosos. Si no se cierran 
            //adecuadamente, 
//pueden acumularse y agotar los recursos disponibles en el servidor de la base de datos.
//Esto es especialmente crítico en entornos con un gran número de solicitudes, como aplicaciones web.
//Por tema de optimización de recursos es que se cierran.con.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            throw new PersonaException("No pude obtener el personaje");
        }

        return perso;
    } 
public void eliminarInasistencia(String ci) throws PersonaException, Exception{

        try {
            String Eliminacion = null;
            Connection conexion;
            conexion = cone.getConnection();

            ps = conexion.prepareStatement(SQL_ELIMINAR_INASISTENCIA);
            ps.setString(1, ci);
            int resultado = ps.executeUpdate();

            if (rs.next()) {
              Eliminacion = "Inasistencia Eliminada";

            } else {
                Eliminacion = "La inasistencia  que desea eliminar no se encuentra";
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
}
}
