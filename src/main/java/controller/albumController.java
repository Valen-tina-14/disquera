package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AlbumDao;
import model.AlbumVo;

public class albumController  extends HttpServlet {
    AlbumVo av=new AlbumVo();
    AlbumDao ad=new AlbumDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String accion=req.getParameter("accion");
        System.out.println(accion);

        switch(accion){
              case "abrirAlbum":
              abrirAlbum(req, resp);
              break;
              case "listar":
              listar(req,resp);
              break;
              case "eliminar":
              eliminar(req,resp);
              break;
              case "esta":
              estado(req,resp);
              break;
              case "edit":
              editar(req,resp);
              break;
    
        }
     }
        
     @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         System.out.println("Entró al DoPost");
         String accion=req.getParameter("accion");
         System.out.println(accion);
        
         switch(accion){
             case "add":
             add (req, resp);
             break;
             case "editar":
             edit (req, resp);
             break;
       }
     }


    //Listar 
     private void listar(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List album=ad.listar();
            req.setAttribute("albunes", album);
            req.getRequestDispatcher("views/album/listAlbum.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }

    //Registrar 
    private void abrirAlbum(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/album/addAlbum.jsp").forward(req, resp);
            System.out.println("Se ha registrado correctamente");
        }catch(Exception e){
                System.out.println("No se ha registrado"+e.getMessage().toString());
        }
    }

    //Eliminar
    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("idAlbum") != null) {
            av.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));
        }
        try {
            ad.eliminar(av.getIdAlbum());
            System.out.println("El estado se ha eliminado correctamente");
            listar(req, resp);
        } catch (Exception e) {
            System.out.println("El estado no se pudo eliminar "+e.getMessage().toString() );
        }
    }

    //Estado
    private void estado(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idAlbum")!=null) {
            av.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));
        }

        if(req.getParameter("estadoAlbum")!=null) {
            av.setEstadoAlbum(Boolean.parseBoolean(req.getParameter("estadoAlbum")));
        }

        try {
            ad.estado(av.isEstadoAlbum(), av.getIdAlbum());
            System.out.println("El estado se ha cambiando correctamente");
            listar(req, resp);
        } catch (Exception e) {
            System.out.println("Error no se pudo cambiar el estado "+e.getMessage().toString() );
        }
    }

    //Editar
    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idAlbum")!=null){
            av.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));
        }
        try {
            List album=ad.album(av.getIdAlbum());
            req.setAttribute("albunes", album);
            req.getRequestDispatcher("views/album/editAlbum.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
     }
    
     
    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("nombreAlbum")!=null){
            av.setNombreAlbum(req.getParameter("nombreAlbum"));
        }
        if(req.getParameter("anioPublicacion")!=null){
            av.setNombreAlbum(req.getParameter("anioPublicacion"));
        }
        if(req.getParameter("estadoAlbum")!=null){
            av.setEstadoAlbum(true);
        }
        else{
            av.setEstadoAlbum(false);
        }
        try {
            ad.registrar(av);
            System.out.println("Registro insertado correctamente");
            listar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("idAlbum")!=null) {
            av.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));
        }

        if(req.getParameter("nombreAlbum")!=null){
            av.setNombreAlbum(req.getParameter("nombreAlbum"));
        }

        if(req.getParameter("anioPublicacion")!=null){
            av.setAnioPublicacion(req.getParameter("anioPublicacion"));
        }

        if(req.getParameter("estadoAlbum")!=null){
            av.setEstadoAlbum(true);
        }

        else{
            av.setEstadoAlbum(false);
        }

        try {
            ad.actualizar(av);
            System.out.println("Editar el registro del album correctamente");
            listar(req, resp);
        } catch (Exception e) {
            System.out.println("Error no se edito el registro "+e.getMessage().toString());
        }
    }
}


