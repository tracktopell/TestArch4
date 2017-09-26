package com.tracktopell.testarch4.web.servlet;

import com.tracktopell.testarch4.api.PersonService;
import com.tracktopell.testarch4.dto.Person;
import com.tracktopell.testarch4.remote.PersonRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alfredo.estrada
 */
@WebServlet(name = "PersonServlet", urlPatterns = {"/person"})
@Named("personServlet")
public class PersonServlet extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	
	/*
	java:global/TestArch4BackEnd-ear-1.0/TestArch4BackEnd-ws-1.0/personServiceBean!com.tracktopell.testarch4.remote.PersonRemote
	java:app/TestArch4BackEnd-ws-1.0/personServiceBean!com.tracktopell.testarch4.remote.PersonRemote
	java:module/personServiceBean!com.tracktopell.testarch4.remote.PersonRemote
	java:jboss/exported/TestArch4BackEnd-ear-1.0/TestArch4BackEnd-ws-1.0/personServiceBean!com.tracktopell.testarch4.remote.PersonRemote
	
	java:global/TestArch4BackEnd-ear-1.0/TestArch4BackEnd-ws-1.0/personServiceBean
	java:app/TestArch4BackEnd-ws-1.0/personServiceBean
	java:module/personServiceBean	
	*/
	@EJB(lookup = "java:global/TestArch4BackEnd-ear-1.0/TestArch4BackEnd-ws-1.0/personServiceBean!com.tracktopell.testarch4.remote.PersonRemote")	
	PersonRemote personRemote;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		List<Person> personList = null;
		try (PrintWriter out = response.getWriter()) {
			/* TODO output your page here. You may use following sample code. */
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>TestArch4Web-PersonServlet</title>");			
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>TestArch4Web-PersonServlet PersonServlet at " + request.getContextPath() + "</h1>");
			//out.println("<h2>PersonRemote :" + personRemote + "</h2>");
			if(personRemote != null){
				personList = personRemote.getAll();
				out.println("   <table border='1'>");
				out.println("      <tr>");
				out.println("         <td>ID</td>");
				out.println("         <td>NAME</td>");
				out.println("         <td>ADDRESS</td>");
				out.println("         <td>PHONE LIST</td>");
				out.println("      </tr>");
				for(Person p:personList){
					out.println("      <tr>");
					out.println("         <td>"+p.getId()+"</td>");
					out.println("         <td>"+p.getName()+" "+p.getSurname()+"</td>");
					out.println("         <td>"+p.getAddress().getAddress()+", "+p.getAddress().getCity()+" "+p.getAddress().getState()+"</td>");
					out.println("         <td>"+p.getPhoneList()+"/<td>");
					out.println("      </tr>");
				}
				out.println("   </table>");
			}
			out.println("</body>");
			out.println("</html>");
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
