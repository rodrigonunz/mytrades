package com.hitbtc.mytrades.model.payload;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticker implements Serializable {

	private static final long serialVersionUID = 4262775128486591641L;
	
	@Column
	private BigDecimal ask; // ultima oferta de venda

	@Column
	private BigDecimal bid; // ultima oferta de compra

	@Column
	private BigDecimal last; // ultima venda

	@Column
	private BigDecimal low; // maior baixa

	@Column
	private BigDecimal high; // maior alta

	@Column
	private BigDecimal open; // abertura do dia

	@Column
	private BigDecimal volume;

	@Column
	private BigDecimal volumeQuote;

	@Column
	private Date timestamp;

	public BigDecimal getAsk() {
		return ask;
	}

	public void setAsk(BigDecimal ask) {
		this.ask = ask;
	}

	public BigDecimal getBid() {
		return bid;
	}

	public void setBid(BigDecimal bid) {
		this.bid = bid;
	}

	public BigDecimal getLast() {
		return last;
	}

	public void setLast(BigDecimal last) {
		this.last = last;
	}

	public BigDecimal getLow() {
		return low;
	}

	public void setLow(BigDecimal low) {
		this.low = low;
	}

	public BigDecimal getHigh() {
		return high;
	}

	public void setHigh(BigDecimal high) {
		this.high = high;
	}

	public BigDecimal getOpen() {
		return open;
	}

	public void setOpen(BigDecimal open) {
		this.open = open;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public BigDecimal getVolumeQuote() {
		return volumeQuote;
	}

	public void setVolumeQuote(BigDecimal volumeQuote) {
		this.volumeQuote = volumeQuote;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Ticker [ask=" + ask + ", bid=" + bid + ", last=" + last + ", low=" + low + ", high=" + high + ", open="
				+ open + ", volume=" + volume + ", volumeQuote=" + volumeQuote + ", timestamp=" + timestamp + "]";
	}

	/*
	 * "ask": "0.0000009548", "bid": "0.0000009510", "last": "0.0000009533",
	 * "low": "0.0000008900", "high": "0.0000019500", "open": "0.0000017173",
	 * "volume": "368024900", "volume_quote": "450.0000000000", "timestamp":
	 * 1499004758047
	 */


}
