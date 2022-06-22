package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CancionDao {
    
    Connection con; //Objeto de conexion
    PreparedStatement ps; //Objeto para sentencias preparadas
    ResultSet rs; //Objeto pa almacenar consultas
    String sql=null; //Variable para guardar sentencias
    int filas; //Cantidad de filas que devuelve una sentencia

    //Registrar
    public int registrar(CancionVo cancion) throws SQLException{
        sql="INSERT INTO Cancion(nombreCancion, fechaGrabacion, duracionGrabacion, estadoCancion) values(?,?,?,?)";
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.setString(1, cancion.getNombreCancion());
            ps.setString(2, cancion.getFechaGrabacion());
            ps.setString(3, cancion.getDuracionGrabacion());
            ps.setBoolean(4, cancion.isEstadoCancion());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se registró la Cancion correctamente");
        }catch(Exception e){
            System.out.println("Error en el registró "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return filas;
    }

    //Listar
    public List<CancionVo> listar() throws SQLException{
        List<CancionVo> cancion=new ArrayList<>();
        sql="SELECT *FROM Cancion";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                CancionVo filas=new CancionVo();
                //Escribir  en el setter cada valor encontrado
                filas.setIdCancion(rs.getInt("idCancion"));
                filas.setNombreCancion(rs.getString("nombreCancion"));
                filas.setFechaGrabacion(rs.getString("fechaGrabacion"));
                filas.setDuracionGrabacion(rs.getString("duracionGrabacion"));
                filas.setEstadoCancion(rs.getBoolean("estadoCancion"));
                cancion.add(filas);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return cancion;
    }

    //Eliminar 
    public void eliminar (int idCancion) throws SQLException {
        sql="DELETE FROM Cancion WHERE idCancion="+idCancion;
        try {
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se elimino correctamente");
        }catch(Exception e){
            System.out.println("Error al eliminar "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
    }

    //Estado
    public void estado(Boolean estadoCancion, int idCancion) throws SQLException {
        sql="UPDATE Cancion SET estadoCancion="+estadoCancion+" WHERE idCancion="+idCancion;
        try { 
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se cambio el estado a "+estadoCancion+" correctamente");
        }catch(Exception e){
            System.out.println("Error no se puede cambiar el estado "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
    }

     //Editar
     public List<CancionVo> cancion(int idCancion) throws SQLException{
        List<CancionVo> cancion=new ArrayList<>();
        sql="SELECT * FROM Cancion WHERE idCancion="+idCancion;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                CancionVo filas=new CancionVo();
                //Escribir  en el setter cada valor encontrado
                filas.setIdCancion(rs.getInt("idCancion"));
                filas.setNombreCancion(rs.getString("nombreCancion"));
                filas.setFechaGrabacion(rs.getString("fechaGrabacion"));
                filas.setDuracionGrabacion(rs.getString("duracionGrabacion"));
                filas.setEstadoCancion(rs.getBoolean("estadoCancion"));
                cancion.add(filas);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return cancion;
    }

    //Actualizar
    public int actualizar (CancionVo cancion) throws SQLException {
        sql="UPDATE Cancion SET nombreCancion=?, fechaGrabacion=?, duracionGrabacion=?, estadoCancion=? WHERE idCancion=?";
        try { 
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.setInt(1, cancion.getIdCancion());
            ps.setString(2, cancion.getNombreCancion());
            ps.setString(3, cancion.getFechaGrabacion());
            ps.setString(4, cancion.getDuracionGrabacion());
            ps.setBoolean(5, cancion.isEstadoCancion());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se edito la Cancion correctamente");

        }catch(Exception e){
            System.out.println("Error al editar "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return filas;
    }
}
