 package com.highradius.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteData
 */
@WebServlet("/deleteData")
public class deleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin","*")
		try {
            final String JDBC_DRIVER ="com.mysql.cj.jdbc.Driver";
               final String URL ="jdbc:mysql://localhost:3306/highradius";
               final String USER ="root";
               final String PASS ="";

               Class.forName(JDBC_DRIVER);
               //now establishing a connection
               Connection con = DriverManager.getConnection(URL,USER,PASS);
               //Statement stm = con.createStatement();

               String sl_no =request.getParameter("sl_no");


               System.out.println("Reached till the query");

               String query="DELETE FROM winter_internship where sl_no in (?)";


               PreparedStatement ps = con.prepareStatement(query);


               ps.setString(1, sl_no);


               System.out.println("reached till the update statement");
               ps.executeUpdate();

               ;
               ps.close();
               con.close();
               System.out.println("ALL DONE");

        }catch(Exception e) {
            e.printStackTrace();
        }
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}