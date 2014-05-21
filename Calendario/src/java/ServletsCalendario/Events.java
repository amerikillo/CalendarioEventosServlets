/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ServletsCalendario;

import Clases.ConectionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.*;

/**
 *
 * @author Amerikillo
 */
public class Events extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        ConectionDB con = new ConectionDB();
        JSONObject json = new JSONObject();
        JSONArray jsona = new JSONArray();
        
        try {
            String ban = request.getParameter("ban");
            if (ban.equals("1")) {
                try {
                    con.conectar();
                    try {
                        ResultSet rset = con.consulta("SELECT * FROM evenement ORDER BY id;");
                        while (rset.next()) {
                            json.put("id", rset.getString("id"));
                            json.put("title", rset.getString("title"));
                            json.put("start", rset.getString("start"));
                            json.put("end", rset.getString("end"));
                            json.put("url", rset.getString("url"));
                            json.put("allDay", rset.getString("allDay"));
                            jsona.add(json);
                            json = new JSONObject();
                        }
                        response.setContentType("text/html;charset=UTF-8");
                        out.println(jsona);
                        System.out.println(jsona);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    con.cierraConexion();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            if (ban.equals("2")) {
                try {
                    con.conectar();
                    try {
                        String start=request.getParameter("start");
                        String end=request.getParameter("end");
                        
                        if(start.equals("")){
                            start="0000-00-00 00:00:00";
                        }
                        if(end.equals("")){
                            end="0000-00-00 00:00:00";
                        }
                        
                        con.actualizar("UPDATE evenement SET title='"+request.getParameter("title")+"', start='"+start+"', end='"+end+"' WHERE id='"+request.getParameter("id")+"'");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        ResultSet rset = con.consulta("SELECT * FROM evenement ORDER BY id;");
                        while (rset.next()) {
                            json.put("id", rset.getString("id"));
                            json.put("title", rset.getString("title"));
                            json.put("start", rset.getString("start"));
                            json.put("end", rset.getString("end"));
                            json.put("url", rset.getString("url"));
                            json.put("allDay", rset.getString("allDay"));
                            jsona.add(json);
                            json = new JSONObject();
                        }
                        response.setContentType("text/html;charset=UTF-8");
                        out.println(jsona);
                        System.out.println(jsona);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    con.cierraConexion();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            if (ban.equals("3")) {
                try {
                    con.conectar();
                    try {
                        String start=request.getParameter("start");
                        String end=request.getParameter("end");
                        
                        if(start.equals("")){
                            start="0000-00-00 00:00:00";
                        }
                        if(end.equals("")){
                            end="0000-00-00 00:00:00";
                        }
                        
                        con.actualizar("INSERT INTO evenement (title, start, end, url) values ('"+request.getParameter("title")+"', '"+start+"', '"+end+"', '"+request.getParameter("url")+"' )");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        ResultSet rset = con.consulta("SELECT * FROM evenement ORDER BY id;");
                        while (rset.next()) {
                            json.put("id", rset.getString("id"));
                            json.put("title", rset.getString("title"));
                            json.put("start", rset.getString("start"));
                            json.put("end", rset.getString("end"));
                            json.put("url", rset.getString("url"));
                            json.put("allDay", rset.getString("allDay"));
                            jsona.add(json);
                            json = new JSONObject();
                        }
                        response.setContentType("text/html;charset=UTF-8");
                        out.println(jsona);
                        System.out.println(jsona);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    con.cierraConexion();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
