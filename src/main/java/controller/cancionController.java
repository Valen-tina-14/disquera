package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CancionDao;
import model.CancionVo;

public class cancionController extends HttpServlet{
    
    CancionVo cv=new CancionVo();
    CancionDao cd=new CancionDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String accion=req.getParameter("accion");
        System.out.println(accion);

        switch(accion){
              case "abrirCancion":
              registrar(req, resp);
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
             case "registrar":
             add (req, resp);
             break;
             case "editar":
             edit (req, resp);
             break;
       }
     }

     // Registrar
    private void registrar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/cancion/addCancion.jsp").forward(req, resp);
            System.out.println("Se ha registrado correctamente");
        }catch(Exception e){
                System.out.println("No se ha registrado"+e.getMessage().toString());
        }
    }
    //Listar
    private void listar(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List cancion=cd.listar();
            req.setAttribute("canciones", cancion);
            req.getRequestDispatcher("views/cancion/listCancion.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }
    //Eliminar 
    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("idCancion") != null) {
            cv.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));
        }
        try {
            cd.eliminar(cv.getIdCancion());
            System.out.println("El estado se ha eliminado correctamente");
            listar(req, resp);
        } catch (Exception e) {
            System.out.println("El estado no se pudo eliminar "+e.getMessage().toString() );
        }
    }
    //Estado
    private void estado(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idCancion")!=null) {
            cv.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));
        }

        if(req.getParameter("estadoCancion")!=null) {
            cv.setEstadoCancion(Boolean.parseBoolean(req.getParameter("estadoCancion")));
        }

        try {
            cd.estado(cv.isEstadoCancion(), cv.getIdCancion());
            System.out.println("El estado se ha cambiando correctamente");
            listar(req, resp);
        } catch (Exception e) {
            System.out.println("Error no se pudo cambiar el estado "+e.getMessage().toString() );
        }
    }
    //Editar
    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idCancion")!=null){
            cv.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));
        }
        try {
            List cancion=cd.cancion(cv.getIdCancion());
            req.setAttribute("canciones", cancion);
            req.getRequestDispatcher("views/cancion/editCancion.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("nombreCancion")!=null){
            cv.setNombreCancion(req.getParameter("nombreCancion"));
        }
        if(req.getParameter("fechaGrabacion")!=null){
            cv.setFechaGrabacion(req.getParameter("fechaGrabacion"));
        }
        if(req.getParameter("duracionGrabacion")!=null){
            cv.setDuracionGrabacion(req.getParameter("duracionGrabacion"));
        }
        if(req.getParameter("estadoCancion")!=null){
            cv.setEstadoCancion(true);
        }
        else{
            cv.setEstadoCancion(false);
        }
        try {
            cd.registrar(cv);
            System.out.println("Registro insertado correctamente");
            listar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idCancion")!=null) {
            cv.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));
        }

        if(req.getParameter("nombreCancion")!=null){
            cv.setNombreCancion(req.getParameter("nombreCancion"));
        }

        if(req.getParameter("fechaGrabacion")!=null){
            cv.setFechaGrabacion(req.getParameter("fechaGrabacion"));
        }

        if(req.getParameter("duracionGrabacion")!=null){
            cv.setDuracionGrabacion(req.getParameter("duracionGrabacion"));
        }

        if(req.getParameter("estadoCancion")!=null){
            cv.setEstadoCancion(true);
        }

        else{
            cv.setEstadoCancion(false);
        }

        try {
            cd.actualizar(cv);
            System.out.println("Editar el registro de la Cancion correctamente");
            listar(req, resp);
        } catch (Exception e) {
            System.out.println("Error no se edito el registro "+e.getMessage().toString());
        }
    }
    
}
