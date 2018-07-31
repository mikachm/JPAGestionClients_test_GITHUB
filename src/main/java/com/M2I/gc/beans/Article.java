package com.M2I.gc.beans;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tarticle")
public class Article {
	 	@Id //Not Null KP
	 	@Column(name="idarticle")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	 	
	 	@Column(name="designationarticle",nullable=true) //Null par défaut
	    private String designation;

	    @Column(name="tarifunitaire")
	    private String tarifUnitaire;


		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public String getTarifUnitaire() {
			return tarifUnitaire;
		}
		
		public void setTarifUnitaire(String tarifUnitaire) {
			this.tarifUnitaire = tarifUnitaire;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}


}