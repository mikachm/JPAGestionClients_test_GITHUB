package com.M2I.gc.beans;


import javax.persistence.*;

@Entity
@Table(name = "tfacturedet")
public class FactureDetails {
	
	
	@Id //Not Null KP
	@Column(name="idfactdet")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="idfact")
	private int idFact;
	
	@Column(name="idarticle")
	private int idArticle;
	
	@Column(name = "qtefact")
	private int qteFact;
	
	@Column(name = "txtva")
	private double txTva;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;	
	}	
	
	public int getIdFact() {
		return idFact;
	}
	
	public void setIdFact(int idFact) {
		this.idFact = idFact;	
	}	
	
	public int getIdArticle() {
		return idArticle;
	}
	
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;	
	}	
	
	public int getQteFact() {
		return qteFact;
	}
	
	public void setQteFact(int qteFact) {
		this.qteFact = qteFact;	
	}	

	public double getTxTva() {
		return txTva;
	}
	
	public void setTxTva(double txTva) {
		this.txTva = txTva;	
	}	
}//class FactureDetails
