package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Column(name = "SOLDIER_ID")
	private String soldier_id;

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

	public String getSoldier_id() {
		return soldier_id;
	}

	public void setSoldier_id(String soldier_id) {
		this.soldier_id = soldier_id;
	}

	@Override
	public String toString() {
		return "Loadout [id=" + loadout_id + ", name=" + loadout_name + ", soldier id=" + soldier_id + "]";
	}

}
