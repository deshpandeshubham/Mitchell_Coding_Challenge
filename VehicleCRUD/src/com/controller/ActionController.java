package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.VehicleBean;
import com.dao.VehicleDao;

/**
 * Servlet implementation class ActionController
 */
@WebServlet("/ActionController")
public class ActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ActionController() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("insert")) {
			VehicleBean vb=new VehicleBean();
			vb.setYear(Integer.parseInt(request.getParameter("year")));
			vb.setMake(request.getParameter("make"));
			vb.setModel(request.getParameter("model"));
			VehicleDao.doInsert(vb);
			response.sendRedirect("show.jsp");
		}
		else if (action.equalsIgnoreCase("edit")) {
			int id=Integer.parseInt(request.getParameter("id"));
			VehicleBean s=VehicleDao.getVehicleById(id);
			request.setAttribute("s", s);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
		
		else if(action.equalsIgnoreCase("update")){
			VehicleBean s=new VehicleBean();
			s.setId(Integer.parseInt(request.getParameter("id")));
			s.setYear(Integer.parseInt(request.getParameter("year")));
			s.setMake(request.getParameter("make"));
			s.setModel(request.getParameter("model"));
			VehicleDao.updateVehicle(s);
			response.sendRedirect("show.jsp");
		}
		
		else if(action.equalsIgnoreCase("delete")){
			int id=Integer.parseInt(request.getParameter("id"));
			VehicleDao.delete(id);
			response.sendRedirect("show.jsp");
		}
	}
}
