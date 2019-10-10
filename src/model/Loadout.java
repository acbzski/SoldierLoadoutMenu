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
@Table(name="loadout")
public class Loadout {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LOADOUT_ID")
	private int loadout_id;
	@Column(name="LOADOUT_NAME")
	private String loadout_name;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="SOLDIER_ID")
	private Soldier soldier;
	@OneToMany(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	@JoinTable(name="LOAD_ASSIGNMENT",
			joinColumns={ @JoinColumn(name="LOADOUT_ID", referencedColumnName="LOADOUT_ID") },
			inverseJoinColumns={ @JoinColumn(name="ITEM_ID", referencedColumnName="ITEM_ID", unique=true) })
	private List<LoadItems> listOfItems;

	public Loadout() {
		super();
	}

	public Loadout (int loadout_id, String loadout_name, Soldier soldier, List<LoadItems> listOfItems) {
		this.loadout_id = loadout_id;
		this.loadout_name = loadout_name;
		this.soldier = soldier;
		this.listOfItems = listOfItems;
	}
	
	public Loadout (String loadout_name, Soldier soldier, List<LoadItems> listOfItems) {
		this.loadout_name = loadout_name;
		this.soldier = soldier;
		this.listOfItems = listOfItems;
	}
	
	public Loadout (String loadout_name, Soldier soldier) {
		this.loadout_name = loadout_name;
		this.soldier = soldier;
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

	public Soldier getSoldier() {
		return soldier;
	}

	public void setSoldier(Soldier soldier) {
		this.soldier = soldier;
	}

	public List<LoadItems> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<LoadItems> listOfItems) {
		this.listOfItems = listOfItems;
	}

	@Override
	public String toString() {
		return "Loadout [loadout_id=" + loadout_id + ", loadout_name=" + loadout_name + ", soldier=" + soldier
				+ ", listOfItems=" + listOfItems + "]";
	}
}
