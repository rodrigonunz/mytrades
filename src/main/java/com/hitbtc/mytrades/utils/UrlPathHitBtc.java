package com.hitbtc.mytrades.utils;

public enum UrlPathHitBtc {
	
	Ticker("/api/1/public/%s/ticker");
	
	private String path;

	private UrlPathHitBtc(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}

}
