package com.hitbtc.mytrades.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.hitbtc.mytrades.model.enums.Currency;
import com.hitbtc.mytrades.model.payload.Ticker;
import com.hitbtc.mytrades.service.MyTradeService;
import com.hitbtc.mytrades.utils.UrlApi;

public class BytecoinJob extends QuartzJobBean {
	
	@Autowired
	MyTradeService service;
	
	private String name;

	// Invoked if a Job data map entry with that name
	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		RestTemplate template = new RestTemplate();
		Ticker ticker = null;
		try{
			ticker  = template.getForObject(UrlApi.Ticker_BCN.getUrl(), Ticker.class);
		}
		catch (RestClientException e) {
			return;
		}
		service.checkTrade(Currency.BYTECOIN, ticker);
	}

}
