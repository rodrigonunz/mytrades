package com.hitbtc.mytrades.model.jpa;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.hitbtc.mytrades.model.enums.Currency;

@Entity
public class History {
	
	@Id
	@Enumerated(EnumType.STRING)
	@Column
	private Currency currency;
	
	@Column(precision = 12, scale = 10)
	private BigDecimal lastPrice;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date lastTrade;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date lastNotification;

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public BigDecimal getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(BigDecimal lastPrice) {
		this.lastPrice = lastPrice;
	}

	public Date getLastTrade() {
		return lastTrade;
	}

	public void setLastTrade(Date lastTrade) {
		this.lastTrade = lastTrade;
	}

	public Date getLastNotification() {
		if(lastNotification == null)
			lastNotification = new Date();
		return lastNotification;
	}

	public void setLastNotification(Date lastNotification) {
		this.lastNotification = lastNotification;
	}

}
