package com.M2I.gc.beans;

import java.math.BigDecimal;

import javax.persistence.*;


@Entity
@Table(name = "tfacture")
public class Facture {
	@Id //Not Null KP
	@Column(name="idfacture")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="idclient")
	private int idClient;
	
	@Column(name="adressefacture")
	private String adresseFacture;
	
	@Column(name="montantfacture")
	private double montantFacture;
	
	@Column(name = "descriptionfacture")
	private  String descriptionFacture;
	
	@Column( name = "payerfacture")
	private Boolean isPaid;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;	
	}	
	
	public int getIdClient() {
		return idClient;
		}
		
	public void setIdClient(int idClient) {
		this.idClient = idClient;
		}
	
	public String getAdresseFacture() {
		return adresseFacture;
	}
	
	public void setAdresseFacture(String adresseFacture){
		this.adresseFacture = adresseFacture;
	}
	
	public double getMontantFacture() {
		return montantFacture;
	}
	
	public void setMontantFacture(double montantFacture) {
		this.montantFacture = montantFacture;
	}
	
	public String getDescriptionFacture() {
		return descriptionFacture;
	}
	
	public void setDescriptionFacture(String descriptionFacture) {
		this.descriptionFacture = descriptionFacture;
	}
	
	public boolean getPayerFacture() {
		return isPaid;
	}
	
	public void setPayerFacture(boolean isPaid) {
		this.isPaid = isPaid;
	}
	

}//class Facture
	
