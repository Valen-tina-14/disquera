package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GeneroDao;
import model.GeneroVo;

public class generoController  extends HttpServlet {
    GeneroVo gv=new GeneroVo();
    GeneroDao gd=new GeneroDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String accion=req.getParameter("accion");
        System.out.println(accion);

        switch(accion){
              case "abrirGenero":
              abrirGenero(req, resp);
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
             add(req, resp);
             break;
             case "editar":
             edit (req, resp);
             break;
       }
     }


    //Listar 
     private void listar(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List Genero=gd.listar();
            req.setAttribute("Generos", Genero);
            req.getRequestDispatcher("views/genero/listGenero.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }

    //Registrar 
    private void abrirGenero(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/genero/addGenero.jsp").forward(req, resp);
            System.out.println("Se ha registrado correctamente");
        }catch(Exception e){
                System.out.println("No se ha registrado"+e.getMessage().toString());
        }
    }

    //Eliminar
    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("idGenero") != null) {
            gv.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
        }
        try {
            gd.eliminar(gv.getIdGenero());
            System.out.println("El estado se ha eliminado correctamente");
            listar(req, resp);
        } catch (Exception e) {
            System.out.println("El estado no se pudo eliminar "+e.getMessage().toString() );
        }
    }

    //Estado
    private void estado(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idGenero")!=null) {
            gv.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
        }

        if(req.getParameter("estadoGenero")!=null) {
            gv.setEstadoGenero(Boolean.parseBoolean(req.getParameter("estadoGenero")));
        }

        try {
            gd.estado(gv.isEstadoGenero(), gv.getIdGenero());
            System.out.println("El estado se ha cambiando correctamente");
            listar(req, resp);
        } catch (Exception e) {
            System.out.println("Error no se pudo cambiar el estado "+e.getMessage().toString() );
        }
    }

    //Editar
    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idGenero")!=null){
            gv.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
        }
        try {
            List Generos=gd.Genero(gv.getIdGenero());
            req.setAttribute("Generos", Generos);
            req.getRequestDispatcher("views/genero/editGenero.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
     }
    
     
    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("nombreGenero")!=null){
            gv.setNombreGenero(req.getParameter("nombreGenero"));
        }
        if(req.getParameter("estadoGenero")!=null){
            gv.setEstadoGenero(true);
        }
        else{
            gv.setEstadoGenero(false);
        }
        try {
            gd.registrar(gv);
            System.out.println("Registro insertado correctamente");
            listar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("idGenero")!=null) {
            gv.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
        }

        if(req.getParameter("nombreGenero")!=null){
            gv.setNombreGenero(req.getParameter("nombreGenero"));
        }

        if(req.getParameter("estadoGenero")!=null){
            gv.setEstadoGenero(true);
        }

        else{
            gv.setEstadoGenero(false);
        }

        try {
            gd.actualizar(gv);
            System.out.println("Editar el registro del genero correctamente");
            listar(req, resp);
        } catch (Exception e) {
            System.out.println("Error no se edito el registro "+e.getMessage().toString());
        }
    }
}

