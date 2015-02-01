package it.mexican.demo.springdatajpa.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Fields {
	
	private Date dateDelete;
	private BigDecimal userDelete;
	
	public Date getDateDelete() {
		return dateDelete;
	}
	public void setDateDelete(Date dateDelete) {
		this.dateDelete = dateDelete;
	}
	public BigDecimal getUserDelete() {
		return userDelete;
	}
	public void setUserDelete(BigDecimal userDelete) {
		this.userDelete = userDelete;
	}
}