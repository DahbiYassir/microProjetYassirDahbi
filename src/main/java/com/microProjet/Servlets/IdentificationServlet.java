package com.microProjet.Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.microProjet.beans.Inscription;
import com.microProjet.connection.SqlConnection;

/**
 * Servlet implementation class IdentificationServlet
 */
@WebServlet("/IdentificationServlet")
public class IdentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdentificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("txt_email");
		String mdp=request.getParameter("txt_password");
		
		
		
		Inscription inscription =new Inscription();
		inscription.setEmail(email);
		inscription.setMotDePasse(mdp);
		
		SqlConnection loginConnection= new SqlConnection();
		try {
			boolean loginValidate = loginConnection.login(inscription);
			if(loginValidate==true) {
				try {
					String query="select * from clients where Email='"+email+"'";
					Connection conn = SqlConnection.getConnection();
					Statement st;
					st = conn.createStatement();
					ResultSet rs = st.executeQuery(query);
					if(rs.next()) {
						String nom = rs.getString("Nom");
						String prenom = rs.getString("Prenom");
						HttpSession session = request.getSession();
						session.setAttribute("nom", nom);
						session.setAttribute("prenom",prenom);
						request.getRequestDispatcher("accueil1.jsp").forward(request, response);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else request.getRequestDispatcher("identifier.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
