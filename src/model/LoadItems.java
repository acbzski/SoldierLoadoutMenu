package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="load_items")
public class LoadItems {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ITEM_ID")
	private int id;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="WEIGHT")
	private int weight;
	
	public LoadItems() {
		super();
	}
	
	public LoadItems(String description, int weight) {
		this.description = description;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "LoadItems [id=" + id + ", description=" + description + ", weight=" + weight + "]";
	}
}
