package com.microProjet.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.microProjet.beans.Article;
import com.microProjet.beans.Categorie;
import com.microProjet.beans.Inscription;

public class SqlConnection {
	
	public static Connection getConnection(){
        Connection conn;
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        try{
            conn = DriverManager.getConnection("jdbc:mysql://mysql-25513-0.cloudclusters.net:25513/microProjet", "yassir","password");
            return conn;
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
	public static void executeQuery(String query) {
        Connection conn = SqlConnection.getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
	
	public String register(Inscription inscription) {
		String nom = inscription.getNom();
		String prenom = inscription.getPrenom();
		String adresse = inscription.getAdresse();
		int tel = inscription.getTel();
		String email = inscription.getEmail();
		String motDePasse = inscription.getMotDePasse();
		
		String query="insert into clients(Email,Nom,Prenom,Adresse,Tel,MotPasse) values(?,?,?,?,?,?)";
		Connection conn = getConnection();
		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, email);
			st.setString(2, nom);
			st.setString(3, prenom);
			st.setString(4, adresse);
			st.setInt(5, tel);
			st.setString(6, motDePasse);
			
			st.executeUpdate();
			return "Inscription réussie";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Inscription échouée";
	}
	
	public boolean login(Inscription inscription) throws SQLException {
		String email = inscription.getEmail();
		String motDePasse = inscription.getMotDePasse();
		
		String query="select * from clients where Email='"+email+"' and MotPasse='"+motDePasse+"' ";
		Connection conn = getConnection();
		Statement st=conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		if (rs.next()) return true;
		
		else return false;
	}
	
	public static ArrayList<Article> listeProduit(String categorie) {
		
			ArrayList<Article>liste=new ArrayList<Article>();
			Article article;
		try {
			Connection conn1=getConnection();
			Statement st1=conn1.createStatement();
			String query1="select * from categories where RefCat="+Integer.parseInt(categorie)+"";
			ResultSet rs1= st1.executeQuery(query1);
			
			while(rs1.next()) {
				String cat = rs1.getString("Cat");
				String query = "select * from articles where Categorie ='"+cat+"' ";
				Connection conn = getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				
				while (rs.next()) {
					article=new Article(rs.getInt("CodeArticle"),rs.getString("Designation"),rs.getDouble("Prix"),rs.getInt("Stock"),rs.getString("Categorie"),rs.getString("Photo"));
					liste.add(article);
				}
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
		
	}
	public static ArrayList<Categorie> list() {
        ArrayList<Categorie> listCategorie = new ArrayList<Categorie>();
         	
         	Connection connection = getConnection(); 
            String sql = "SELECT * FROM categories ";
            Statement statement;
			try {
				statement = connection.createStatement();
				 ResultSet result = statement.executeQuery(sql);
		            Categorie categorie;
		            while (result.next()) {
		                int id = result.getInt("RefCat");
		                String name = result.getString("Cat");
		                categorie = new Categorie(id, name);
		                     
		                listCategorie.add(categorie);
		            }          
		            

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
             
        
         
        return listCategorie;
    }
	
	public static Article ArticleDisplay(Article article) throws SQLException {
		int id = article.getCodeArticle();
		Article art=new Article();
		
			Connection conn=getConnection();
			String query ="select * from articles where CodeArticle="+id+"";
			Statement st= conn.createStatement();
			ResultSet rs= st.executeQuery(query);
			if(rs.next()) {
				art=new Article(rs.getInt("CodeArticle"),rs.getString("Designation"),rs.getDouble("Prix"),rs.getInt("Stock"),rs.getString("Categorie"),rs.getString("Photo"));

			}
			return art;
			
		
	}
	
}

