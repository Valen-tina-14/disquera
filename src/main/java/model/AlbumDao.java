package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumDao {

    Connection con; //Objeto de conexion
    PreparedStatement ps; //Objeto para sentencias preparadas
    ResultSet rs; //Objeto pa almacenar consultas
    String sql=null; //Variable para guardar sentencias
    int filas; //Cantidad de filas que devuelve una sentencia

    //Registrar
    public int registrar(AlbumVo album) throws SQLException{
        sql="INSERT INTO Album (nombreAlbum, anioPublicacion, estadoAlbum) values(?,?,?)";
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            ps.setString(1, album.getNombreAlbum());
            ps.setString(2, album.getAnioPublicacion());
            ps.setBoolean(3, album.isEstadoAlbum());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se registró el álbum correctamente");
        }catch(Exception e){
            System.out.println("Error en el regisro "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return filas;
    }
    //Listar
    public List<AlbumVo> listar() throws SQLException{
        List<AlbumVo> album=new ArrayList<>();
        sql="SELECT *FROM Album";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                AlbumVo filas=new AlbumVo();
                //Escribir  en el setter cada valor encontrado
                filas.setIdAlbum(rs.getInt("idAlbum"));
                filas.setNombreAlbum(rs.getString("nombreAlbum"));
                filas.setAnioPublicacion(rs.getString("anioPublicacion"));
                filas.setEstadoAlbum(rs.getBoolean("estadoAlbum"));
                album.add(filas);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return album;
    }

    //Eliminar 
    public void eliminar (int idAlbum) throws SQLException {
        sql="DELETE FROM Album WHERE idAlbum="+idAlbum;
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
    public void estado(Boolean estadoAlbum, int idAlbum) throws SQLException {
        sql="UPDATE Album SET estadoAlbum="+estadoAlbum+" WHERE idAlbum="+idAlbum;
        try { 
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se cambio el estado a "+estadoAlbum+" correctamente");
        }catch(Exception e){
            System.out.println("Error no se puede cambiar el estado "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
    }

    //Editar
    public List<AlbumVo> album(int idAlbum) throws SQLException{
        List<AlbumVo> album=new ArrayList<>();
        sql="SELECT * FROM Album WHERE idAlbum="+idAlbum;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                AlbumVo filas=new AlbumVo();
                //Escribir  en el setter cada valor encontrado
                filas.setIdAlbum(rs.getInt("idAlbum"));
                filas.setNombreAlbum(rs.getString("nombreAlbum"));
                filas.setAnioPublicacion(rs.getString("anioPublicacion"));
                filas.setEstadoAlbum(rs.getBoolean("estadoAlbum"));
                album.add(filas);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return album;
    }

    //Actualizar
    public int actualizar (AlbumVo album) throws SQLException {
        sql="UPDATE Album SET nombreAlbum=?, anioPublicacion=?, estadoAlbum=? WHERE idAlbum=?";
        try { 
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.setString(1, album.getNombreAlbum());
            ps.setString(2, album.getAnioPublicacion());
            ps.setBoolean(3, album.isEstadoAlbum());
            ps.setInt(4, album.getIdAlbum());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se edito el Genero correctamente");

        }catch(Exception e){
            System.out.println("Error al editar "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return filas;
    } 

}
