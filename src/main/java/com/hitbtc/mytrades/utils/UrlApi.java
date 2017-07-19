package com.hitbtc.mytrades.utils;

import org.apache.commons.lang3.StringUtils;

public enum UrlApi {
	
	Ticker_BCN("/api/1/public/%s/ticker", CurrencySymbolsHitBtc.BCNBTC),
	Ticker_ZEC("/api/1/public/%s/ticker", CurrencySymbolsHitBtc.ZECBTC);

	private String url;
	private CurrencySymbolsHitBtc symbol;
	private static final String urlBase ="http://api.hitbtc.com"; 
	

	private UrlApi(String url, CurrencySymbolsHitBtc currencySimbol) {
		this.url = url;
		this.symbol = currencySimbol;
	}
	
	public String getUrl() {
		return StringUtils.join(urlBase, String.format(url, symbol.getSymbol()));
	}

}
