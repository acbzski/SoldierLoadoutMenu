package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "loadout")
public class Loadout {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOADOUT_ID")
	private int loadout_id;
	@Column(name = "LOADOUT_NAME")
	private String loadout_name;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="ITEM_ID")
	private LoadItems loaditems;
	@OneToMany(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	@JoinTable(name="LOAD_ASSIGNMENT",
			joinColumns={ @JoinColumn(name="LOADOUT_ID", referencedColumnName="LOADOUT_ID") },
			inverseJoinColumns={ @JoinColumn(name="ITEM_ID", referencedColumnName="ITEM_ID", unique=true) })
	private List<LoadItems> listOfItems;

	public Loadout() {
		super();
	}

	public Loadout(String loadout_name, int loadout_id) {
		super();
		this.loadout_name = loadout_name;
		this.loadout_id = loadout_id;
	}

	public int getLoadout_id() {
		return loadout_id;
	}

	public void setLoadout_id(int loadout_id) {
		this.loadout_id = loadout_id;
	}

	public String getLoadout_name() {
		return loadout_name;
	}

	public void setLoadout_name(String loadout_name) {
		this.loadout_name = loadout_name;
	}

	public LoadItems getLoaditems() {
		return loaditems;
	}

	public void setLoaditems(LoadItems loaditems) {
		this.loaditems = loaditems;
	}

	public List<LoadItems> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<LoadItems> listOfItems) {
		this.listOfItems = listOfItems;
	}

	@Override
	public String toString() {
		return "Loadout [loadout_id=" + loadout_id + ", loadout_name=" + loadout_name + ", Loaditems=" + loaditems
				+ ", listOfItems=" + listOfItems + "]";
	}
}
