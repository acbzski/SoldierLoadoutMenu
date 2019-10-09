package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/NavigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SoldierHelper sh = new SoldierHelper();
		LoadoutHelper lh = new LoadoutHelper();
		LoadItemsHelper lih = new LoadItemsHelper();
		String act = request.getParameter("doThis");
		
		if (act == null) {
			
		} else if (act.equals("addSoldier")) {
			
		} else if (act.equals("editSoldier")) {
			
		} else if (act.equals("deleteSoldier")) {
			
		} else if (act.equals("addLoadout")) {
			
		} else if (act.equals("editLoadout")) {
			
		} else if (act.equals("deleteLoadout")) {
			
		} else if (act.equals("addItem")) {
			
		} else if (act.equals("editItem")) {
			
		} else if (act.equals("deleteItem")) {
			
		}
	}

}
