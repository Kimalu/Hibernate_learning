package com.Kimalu.model;

import java.io.Serializable;

import org.hibernate.CallbackException;
import org.hibernate.Session;
import org.hibernate.classic.Lifecycle;


public class Dbfile  implements Lifecycle, Serializable{
	private int id;
	private String name;
	private int contractId;
	private Item item;
	
	@Override
	public boolean onDelete(Session arg0) throws CallbackException {
System.out.println(item);
		return false;
	}
	@Override
	public void onLoad(Session arg0, Serializable arg1) {
		
	}
	@Override
	public boolean onSave(Session arg0) throws CallbackException {
		return false;
	}
	@Override
	public boolean onUpdate(Session arg0) throws CallbackException {
		return false;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getContractId() {
		return contractId;
	}
	public void setContractId(int contractId) {
		this.contractId = contractId;
	}
	
}
