package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneroDao {

    Connection con; //Objeto de conexion
    PreparedStatement ps; //Objeto para sentencias preparadas
    ResultSet rs; //Objeto pa almacenar consultas
    String sql=null; //Variable para guardar sentencias
    int filas; //Cantidad de filas que devuelve una sentencia

    //Registrar
    public int registrar(GeneroVo Genero) throws SQLException{
        sql="INSERT INTO Genero(nombreGenero, estadoGenero) values(?,?)";
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            ps.setString(1, Genero.getNombreGenero());
            ps.setBoolean(2, Genero.isEstadoGenero());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se registró el Genero correctamente");
        }catch(Exception e){
            System.out.println("Error en el regisro "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return filas;
    }
    //Listar
    public List<GeneroVo> listar() throws SQLException{
        List<GeneroVo> Genero=new ArrayList<>();
        sql="SELECT *FROM Genero";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                GeneroVo filas=new GeneroVo();
                //Escribir  en el setter cada valor encontrado
                filas.setIdGenero(rs.getInt("idGenero"));
                filas.setNombreGenero(rs.getString("nombreGenero"));
                filas.setEstadoGenero(rs.getBoolean("estadoGenero"));
                Genero.add(filas);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return Genero;
    }

    //Eliminar 
    public void eliminar (int idGenero) throws SQLException {
        sql="DELETE FROM Genero WHERE idGenero="+idGenero;
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
    public void estado(Boolean estadoGenero, int idGenero) throws SQLException {
        sql="UPDATE Genero SET estadoGenero="+estadoGenero+" WHERE idGenero="+idGenero;
        try { 
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se cambio el estado a "+estadoGenero+" correctamente");
        }catch(Exception e){
            System.out.println("Error no se puede cambiar el estado "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
    }

    //Editar
    public List<GeneroVo> Genero(int idGenero) throws SQLException{
        List<GeneroVo> Genero=new ArrayList<>();
        sql="SELECT * FROM Genero WHERE idGenero="+idGenero;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                GeneroVo filas=new GeneroVo();
                //Escribir  en el setter cada valor encontrado
                filas.setIdGenero(rs.getInt("idGenero"));
                filas.setNombreGenero(rs.getString("nombreGenero"));
                filas.setEstadoGenero(rs.getBoolean("estadoGenero"));
                Genero.add(filas);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return Genero;
    }

    //Actualizar
    public int actualizar (GeneroVo Genero) throws SQLException {
        sql="UPDATE Genero SET nombreGenero=?, estadoGenero=? WHERE idGenero=?";
        try { 
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.setInt(1, Genero.getIdGenero());
            ps.setString(2, Genero.getNombreGenero());
            ps.setBoolean(3, Genero.isEstadoGenero());
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


