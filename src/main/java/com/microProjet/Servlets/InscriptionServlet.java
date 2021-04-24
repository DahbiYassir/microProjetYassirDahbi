package com.microProjet.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microProjet.beans.Inscription;
import com.microProjet.connection.JpaConnection;
import com.microProjet.connection.SqlConnection;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
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
		String nom=request.getParameter("txt_nom");
		String prenom=request.getParameter("txt_prenom");
		String adresse=request.getParameter("txt_adresse");
		int tel=Integer.parseInt(request.getParameter("txt_tel"));
		String email=request.getParameter("txt_email");
		String motDePasse=request.getParameter("txt_mdp");
		
		Inscription inscription = new Inscription();
		
		inscription.setNom(nom);
		inscription.setPrenom(prenom);
		inscription.setAdresse(adresse);
		inscription.setTel(tel);
		inscription.setEmail(email);
		inscription.setMotDePasse(motDePasse);
		
		String registerValidate = JpaConnection.jpaRegister(inscription);
		
		if(registerValidate.equals("Inscription réussie"))
			request.getRequestDispatcher("accueil.jsp").forward(request, response);
		else 
			request.getRequestDispatcher("inscrire.jsp").forward(request, response);
	}

}
