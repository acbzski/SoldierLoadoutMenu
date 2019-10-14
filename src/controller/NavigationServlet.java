package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
			if (act.equals("View Loadouts")) {
				request.setAttribute("allItems", lih.showAllItems());
				if (lih.showAllItems().isEmpty()) {
					request.setAttribute("allItems", null);
				}
				request.setAttribute("allLoadouts", lh.showAllLoadouts());
				if (lh.showAllLoadouts().isEmpty()) {
					request.setAttribute("allLoadouts", null);
				}
				act = null;
				getServletContext().getRequestDispatcher("/CreateLoadout.jsp").forward(request, response);
			} else if (act.equals("View Equipment")) {
				//add items to table
				request.setAttribute("allItems", lih.showAllItems());
				if (lih.showAllItems().isEmpty()) {
					request.setAttribute("allItems", null);
				}
				act = null;
				getServletContext().getRequestDispatcher("/CreateItems.jsp").forward(request, response);
			}
		
			/****** LOADOUT ACTIONS ******/
			else if (act.equals("Add Loadout")) {
				//pull information for soldier object
				String soldierName = request.getParameter("soldierName");
				String month = request.getParameter("month");
				String day = request.getParameter("day");
				String year = request.getParameter("year");
				//parse date into LocalDate format
				LocalDate bd;
				try {
					bd = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
				} catch (NumberFormatException e) {
					bd = LocalDate.now();
				}
				//pull information for loadout object
				String loadName = request.getParameter("loadoutName");
				String[] selectedItems = request.getParameterValues("allItems");
				List<LoadItems> selectedItemsInList = new ArrayList<LoadItems>();
				if (selectedItems !=null && selectedItems.length > 0) {
					for (int i=0; i<selectedItems.length; i++) {
						LoadItems li = lih.searchForLoadItemsById(Integer.parseInt(selectedItems[i]));
						selectedItemsInList.add(li);
					}
				}
				//create objects and insert into table
				Soldier soldier = new Soldier(soldierName, bd);
				Loadout load = new Loadout(loadName, soldier);
				load.setListOfItems(selectedItemsInList);
				lh.insertLoadout(load);
				//refresh page
				act = "View Loadouts";
			} else if (act.equals("Edit Loadout")) {
				try {
					Integer tempId = Integer.parseInt(request.getParameter("id"));
					Loadout loadoutToEdit = lh.searchForLoadoutById(tempId);
					request.setAttribute("loadoutToEdit", loadoutToEdit);
					request.setAttribute("allItems", lih.showAllItems());
					getServletContext().getRequestDispatcher("/EditLoadout.jsp").forward(request, response);
				} catch (NumberFormatException e) {
					System.out.println("Forgot to select a loadout to edit!");
				} finally {
					act = "View Loadouts";
				}
			} else if (act.equals("Submit Edited Loadout")) {
				//pull information for soldier object
				String soldierName = request.getParameter("soldierName");
				String month = request.getParameter("month");
				String day = request.getParameter("day");
				String year = request.getParameter("year");
				LocalDate bd;
				//parse date into LocalDate format
				try {
					bd = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
				} catch (NumberFormatException ex) {
					bd = LocalDate.now();
				}
				Soldier soldier = new Soldier(soldierName, bd);
				//pull information for loadout object
				String loadName = request.getParameter("loadoutName");
				String[] selectedItems = request.getParameterValues("allItems");
				List<LoadItems> selectedItemsInList = new ArrayList<LoadItems>();
				//populate list with loaditems objects
				if (selectedItems !=null && selectedItems.length > 0) {
					for (int i=0; i<selectedItems.length; i++) {
						LoadItems li = lih.searchForLoadItemsById(Integer.parseInt(selectedItems[i]));
						selectedItemsInList.add(li);
					}
				}
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				//create updated object and update table records
				Loadout loadToEdit = lh.searchForLoadoutById(tempId);
				loadToEdit.setLoadout_name(loadName);
				loadToEdit.setSoldier(soldier);
				loadToEdit.setListOfItems(selectedItemsInList);
				lh.editLoadout(loadToEdit);
				//reset view conditional statement
				act = "View Loadouts";
			} else if (act.equals("Delete Loadout")) {
				try {
					Integer tempId = Integer.parseInt(request.getParameter("id"));
					Loadout loadoutToDelete = lh.searchForLoadoutById(tempId);
					lh.deleteLoadout(loadoutToDelete);

				} catch (NumberFormatException e) {
					System.out.println("Forgot to select a loadout to delete!");
				} finally {
					act = "View Loadouts";
				}
			}
		
			/****** ITEM ACTIONS ******/
			else if (act.equals("Add Item")) {
				//pull information for loaditems object
				String desc = request.getParameter("description");
				int weight = Integer.parseInt(request.getParameter("weight"));
				//create object and insert into table
				LoadItems l = new LoadItems(desc, weight);
				lih.insertItem(l);
				//refresh page
				act = "View Equipment";
			} else if (act.equals("Edit Item")) {
				try {
					Integer tempId = Integer.parseInt(request.getParameter("id"));
					LoadItems itemToEdit = lih.searchForLoadItemsById(tempId);
					request.setAttribute("itemToEdit", itemToEdit);
					getServletContext().getRequestDispatcher("/EditItems.jsp").forward(request, response);
				} catch (NumberFormatException e) {
					System.out.println("Forgot to select an item to edit!");					
				} finally {
					//reset view conditional statement
					act = "View Equipment";
				}
			} else if (act.equals("Submit Edited Item")) {
				String desc = request.getParameter("description");
				int weight = Integer.parseInt(request.getParameter("weight"));
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				//create updated object and update table records
				LoadItems itemToEdit = lih.searchForLoadItemsById(tempId);
				itemToEdit.setDescription(desc);
				itemToEdit.setWeight(weight);
				lih.editItem(itemToEdit);
				//reset view conditional statement
				act = "View Equipment";
			} else if (act.equals("Delete Item")) {
				try {
					Integer Item_Id = Integer.parseInt(request.getParameter("id"));
					LoadItems itemToDelete = lih.searchForLoadItemsById(Item_Id);
					lih.deleteItem(itemToDelete);
				} catch (NumberFormatException e) {
					System.out.println("Forgot to select an item to delete!");
				} finally {
					act = "View Equipment";
				}
			}
		}
	}
}
