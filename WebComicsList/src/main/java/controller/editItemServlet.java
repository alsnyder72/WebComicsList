package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItem;

/**
 * Servlet implementation class editItemServlet
 */
@WebServlet("/editItemServlet")
public class editItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListItemHelper dao = new ListItemHelper();
		
		String publisher = request.getParameter("publisher");
		String title = request.getParameter("title");
		Integer volume = Integer.parseInt(request.getParameter("volume"));
		Integer issue = Integer.parseInt(request.getParameter("issue"));
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		ListItem itemToUpdate = dao.searchForItemById(tempId);
		
		itemToUpdate.setTitle(title);
		itemToUpdate.setPublisher(publisher);
		itemToUpdate.setVolume(volume);
		itemToUpdate.setIssue(issue);
		dao.updateItem(itemToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
	}

}
