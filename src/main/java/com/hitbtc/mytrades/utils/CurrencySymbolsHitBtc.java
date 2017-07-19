package com.hitbtc.mytrades.utils;

public enum CurrencySymbolsHitBtc {
	
	BCNBTC("BCNBTC"),
	ZECBTC("ZECBTC");
	
	private String symbol;

	private CurrencySymbolsHitBtc(String symbol) {
		this.symbol = symbol;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	

}
