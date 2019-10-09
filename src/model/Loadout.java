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
	@Column(name = "loadout_ID")
	private int loudout_id;
	@Column(name = "loudout_name")
	private String loudout_name;
	@Column(name = "soldier_id")
	private String soldier_id;

	public Loadout() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Loadout(String loudout_name, int loudout_id) {
		super();
		this.loudout_name = loudout_name;
		this.loudout_id = loudout_id;
	}

	public int getLoudout_id() {
		return loudout_id;
	}

	public void setLoudout_id(int loudout_id) {
		this.loudout_id = loudout_id;
	}

	public String getLoudout_name() {
		return loudout_name;
	}

	public void setLoudout_name(String loudout_name) {
		this.loudout_name = loudout_name;
	}

	public String getSoldier_id() {
		return soldier_id;
	}

	public void setSoldier_id(String soldier_id) {
		this.soldier_id = soldier_id;
	}

	@Override
	public String toString() {
		return "Loadout [id=" + loudout_id + ", store=" + loudout_name + ", item=" + soldier_id + "]";
	}

}
