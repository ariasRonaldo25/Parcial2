package Controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Pais;
import Util.PaisDao;


@WebServlet("/PaisController")
public class PaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PaisDao paisDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaisController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		System.out.println(action);
		
		switch(action) {
			case "/new":
				showNewPais(request, response);
				break;
			case "/insert":
				insertPais(request, response);
				break;
			case "/delete":
			try {
				deletePais(request, response);
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
		        break;
		    case "/edit":
		        showEditPais(request, response);
		        break;
		    case "/update":
			try {
				updatePais(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        break;
			default: 
				listPais(request, response);
				break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void listPais(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   	List < Pais > listPais= paisDAO.selectAllCarro();
	        request.setAttribute("listPais", listPais);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
	        dispatcher.forward(request, response);
	}

	private void updatePais(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		 	String id  = request.getParameter("id");
	        String nombre = request.getParameter("nombre");
	        Pais p= new Pais(id, nombre);
	        paisDAO.updateCarro(p);
	        response.sendRedirect("listPais");
	}

	private void showEditPais(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 	String id = request.getParameter("id");
	        Pais existingUser =  paisDAO.selectCarro(id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("paisForm.jsp");
	        request.setAttribute("pais", existingUser);
	        dispatcher.forward(request, response);
	}

	private void deletePais(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		 String id =request.getParameter("id");
	        paisDAO.deleteCarro(id);
	        response.sendRedirect("paisList");
	}

	private void insertPais(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Pais> listPais = paisDAO.selectAllCarro();
		request.setAttribute("listPais", listPais);
        RequestDispatcher dispatcher = request.getRequestDispatcher("paisList.jsp");
        dispatcher.forward(request, response);
    }
		

	private void showNewPais(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 RequestDispatcher dispatcher = request.getRequestDispatcher("paisList.jsp");
	     dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
}
