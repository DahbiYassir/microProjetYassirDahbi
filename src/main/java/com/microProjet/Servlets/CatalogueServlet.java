package com.microProjet.Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microProjet.beans.Article;
import com.microProjet.beans.Categorie;
import com.microProjet.connection.JpaConnection;
import com.microProjet.connection.SqlConnection;

/**
 * Servlet implementation class CatalogueServlet
 */
@WebServlet("/CatalogueServlet")
public class CatalogueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Categorie> listeCategorie = JpaConnection.listCategoriesJpa();
		request.setAttribute("listeCategorie", listeCategorie);
		
		
		
		ArrayList<Article> listeArticle = new ArrayList<Article>();
		listeArticle = JpaConnection.listeProduitJpa(request.getParameter("categorie"));
		request.setAttribute("article", listeArticle);
		request.getRequestDispatcher("catalogue.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
