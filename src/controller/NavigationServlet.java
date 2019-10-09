package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Loadout;
import model.Soldier;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SoldierHelper sh = new SoldierHelper();
		LoadoutHelper lh = new LoadoutHelper();
		LoadItemsHelper lih = new LoadItemsHelper();
		String act = request.getParameter("doThis");

		if (act == null) {

		} else if (act.equals("addSoldier")) {
			getServletContext().getRequestDispatcher("/addSoldier.jsp").forward(request, response);
		} else if (act.equals("editSoldier")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Soldier soldierToEdit = sh.searchForSoldierById(tempId);
				request.setAttribute("soldierToEdit", soldierToEdit);
				getServletContext().getRequestDispatcher("/editSoldier.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/").forward(request, response);
			}
		} else if (act.equals("deleteSoldier")) {

			try {
				Integer Item_Id = Integer.parseInt(request.getParameter("id"));
				ListItem itemToDelete = lih.searchForItemById(Item_Id);
				lih.deleteItem(itemToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
			}

		} else if (act.equals("addLoadout")) {
			getServletContext().getRequestDispatcher("/addLoadout.jsp").forward(request, response);
		} else if (act.equals("editLoadout")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Loadout loadoutToEdit = lh.searchForLoadoutById(tempId);
				request.setAttribute("loadoutToEdit", loadoutToEdit);
				getServletContext().getRequestDispatcher("/editLoadout.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/").forward(request, response);
			}
		} else if (act.equals("deleteLoadout")) {

			try {
				Integer Item_Id = Integer.parseInt(request.getParameter("id"));
				ListItem itemToDelete = lih.searchForItemById(Item_Id);
				lih.deleteItem(itemToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
			}

		} else if (act.equals("addItem")) {
			getServletContext().getRequestDispatcher("/addItem.jsp").forward(request, response);
		} else if (act.equals("editItem")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Soldier soldierToEdit = sh.searchForSoldierById(tempId);
				request.setAttribute("soldierToEdit", soldierToEdit);
				getServletContext().getRequestDispatcher("/editSoldier.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllCarsServlet").forward(request, response);
			}
		} else if (act.equals("deleteItem")) {

			try {
				Integer Item_Id = Integer.parseInt(request.getParameter("id"));
				ListItem itemToDelete = lih.searchForItemById(Item_Id);
				lih.deleteItem(itemToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
			}

		}
	}

}
