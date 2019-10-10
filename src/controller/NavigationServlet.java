package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LoadItems;
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SoldierHelper sh = new SoldierHelper();
		LoadoutHelper lh = new LoadoutHelper();
		LoadItemsHelper lih = new LoadItemsHelper();
		String act = request.getParameter("doThis");

		while (act != null) {
		
			/****** VIEWS ******/
			if (act.equals("View Soldiers")) {
				request.setAttribute("allSoldiers", sh.showAllSoldiers());
				if (sh.showAllSoldiers().isEmpty()) {
					request.setAttribute("allSoldiers", " ");
				}
				getServletContext().getRequestDispatcher("/CreateSoldier.jsp").forward(request, response);
				act = null;
			} else if (act.equals("View Loadouts")) {
				getServletContext().getRequestDispatcher("/CreateLoadout.jsp").forward(request, response);
			} else if (act.equals("View Items")) {
				getServletContext().getRequestDispatcher("/CreateItems.jsp").forward(request, response);
			}
		
			/****** SOLDIER ACTIONS ******/
			else if (act.equals("Add Soldier")) {
				String name = request.getParameter("name");
				String month = request.getParameter("month");
				String day = request.getParameter("day");
				String year = request.getParameter("year");
				LocalDate bd;
				try {
					bd = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
				} catch (NumberFormatException ex) {
					bd = LocalDate.now();
				}
				Soldier s = new Soldier(name, bd);
				sh.insertSoldier(s);
				act = "View Soldiers";
			}
			else if (act.equals("Edit Soldier")) {
				try {
					Integer tempId = Integer.parseInt(request.getParameter("id"));
					Soldier soldierToEdit = sh.searchForSoldierById(tempId);
					request.setAttribute("soldierToEdit", soldierToEdit);
					getServletContext().getRequestDispatcher("/EditSoldier.jsp").forward(request, response);
				} catch (NumberFormatException e) {
					getServletContext().getRequestDispatcher("/").forward(request, response);
				}
			} else if (act.equals("Delete Soldier")) {
				try {
					Integer Item_Id = Integer.parseInt(request.getParameter("id"));
					Soldier soldierToDelete = sh.searchForSoldierById(Item_Id);
					sh.deleteSoldier(soldierToDelete);

				} catch (NumberFormatException e) {
					System.out.println("Forgot to click a button");
				} finally {
					getServletContext().getRequestDispatcher("/").forward(request, response);
				}
			}
		
			/****** LOADOUT ACTIONS ******/
			else if (act.equals("Add Loadout")) {
				String name = request.getParameter("name");
				String[] selectedItems = request.getParameterValues("allItemsToAdd");
				List<LoadItems> selectedItemsInList = new ArrayList<LoadItems>();
			
				if (selectedItems !=null && selectedItems.length > 0) {
					for (int i=0; i<selectedItems.length; i++) {
						System.out.println(selectedItems[i]);
						LoadItems li = lih.searchForLoadItemsById(Integer.parseInt(selectedItems[i]));
						selectedItemsInList.add(li);
					}
				}
			
				getServletContext().getRequestDispatcher("/CreateLoadout.jsp").forward(request, response);
			} else if (act.equals("Edit Loadout")) {
				try {
					Integer tempId = Integer.parseInt(request.getParameter("id"));
					Loadout loadoutToEdit = lh.searchForLoadoutById(tempId);
					request.setAttribute("loadoutToEdit", loadoutToEdit);
					getServletContext().getRequestDispatcher("/EditLoadout.jsp").forward(request, response);
				} catch (NumberFormatException e) {
					getServletContext().getRequestDispatcher("/").forward(request, response);
				}
			} else if (act.equals("Delete Loadout")) {

				try {
					Integer Item_Id = Integer.parseInt(request.getParameter("id"));
					Loadout loadoutToDelete = lh.searchForLoadoutById(Item_Id);
					lh.deleteLoadout(loadoutToDelete);

				} catch (NumberFormatException e) {
					System.out.println("Forgot to click a button");
				} finally {
					getServletContext().getRequestDispatcher("/").forward(request, response);
				}

			}
		
			/****** ITEM ACTIONS ******/
			else if (act.equals("Add Item")) {
				getServletContext().getRequestDispatcher("/CreateItem.jsp").forward(request, response);
			} else if (act.equals("Edit Item")) {
				try {
					Integer tempId = Integer.parseInt(request.getParameter("id"));
					LoadItems itemToEdit = lih.searchForLoadItemsById(tempId);
					request.setAttribute("itemToEdit", itemToEdit);
					getServletContext().getRequestDispatcher("/EditItem.jsp").forward(request, response);
				} catch (NumberFormatException e) {
					getServletContext().getRequestDispatcher("/").forward(request, response);
				}
			} else if (act.equals("Delete Item")) {

				try {
					Integer Item_Id = Integer.parseInt(request.getParameter("id"));
					LoadItems itemToDelete = lih.searchForLoadItemsById(Item_Id);
					lih.deleteItem(itemToDelete);

				} catch (NumberFormatException e) {
					System.out.println("Forgot to click a button");
				} finally {
					getServletContext().getRequestDispatcher("/").forward(request, response);
				}
			}
		}
	}
}
