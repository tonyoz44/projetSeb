package com.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.DelegatingConnection;

import com.domaine.Client;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class AfficheServlet
 */
@WebServlet("/AfficheServlet")
public class AfficheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficheServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		List<Client> clients = new ArrayList<Client>();
		
		try {
			/*
			Class.forName("com.mysql.jdbc.Driver");
			// jdbc:mysql://localhost/test?user=root&password=
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/test");
			*/
			
			// Localisation JNDI...
			// Etape 1 : Chargement du driver
			Context initialContext = null;
			try {
				initialContext = new InitialContext();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Context localContext = (Context) initialContext.lookup("java:comp/env");
			DataSource ds = (DataSource) localContext.lookup("jdbc/form");
			
			// Etape 2 : récupération de la connexion
			  Connection con = (Connection) ((DelegatingConnection) ds.getConnection()).getInnermostDelegate();


			
			Statement st = (Statement) con.createStatement();
			String sql = "SELECT * FROM client";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {

				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String adresse = rs.getString("adresse");
				String poste = rs.getString("poste");

				clients.add(new Client(nom, prenom, adresse, poste));
			}

			rs.close();
			st.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("clients", clients);
		// redirection
		RequestDispatcher disp = request
				.getRequestDispatcher("ListeClient.jsp");
		disp.forward(request, response);	
		}
}
