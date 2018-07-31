package com.M2I.gc.beans;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tclients")
public class Clients {
	 	@Id //Not Null KP
	 	@Column(name="idclient")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	 	
	 	@Column(name="nomclient",nullable=true) //Null par défaut
	    private String nom;

	    @Column(name="adresseclient")
	    private String adresse;

	    @Column(name="villeclient")
	    private String ville;

	    @Column(name="cdpclient")
	    private String cdp;
	    
	    @Column(name="datecreationclient")
	    @Temporal(TemporalType.DATE)
	    private Date datecreation;

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getAdresse() {
			return adresse;
		}

		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}

		public String getVille() {
			return ville;
		}

		public void setVille(String ville) {
			this.ville = ville;
		}

		public String getCdp() {
			return cdp;
		}

		public void setCdp(String cdp) {
			this.cdp = cdp;
		}

		public Date getDatecreation() {
			return datecreation;
		}

		public void setDatecreation(Date datecreation) {
			this.datecreation = datecreation;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}


}