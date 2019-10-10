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
	private int item_id;
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

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public List<LoadItems> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<LoadItems> listOfItems) {
		this.listOfItems = listOfItems;
	}

	@Override
	public String toString() {
		return "Loadout [loadout_id=" + loadout_id + ", loadout_name=" + loadout_name + ", item_id=" + item_id
				+ ", listOfItems=" + listOfItems + "]";
	}
}
