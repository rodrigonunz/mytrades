package com.hitbtc.mytrades.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hitbtc.mytrades.model.enums.Currency;
import com.hitbtc.mytrades.model.jpa.History;
import com.hitbtc.mytrades.model.payload.Ticker;
import com.hitbtc.mytrades.repository.HistoryRepository;

@Service
public class MyTradeService {

	@Autowired
	HistoryRepository repo;

	@Autowired
	EmailService mailService;

	public void checkTrade(Currency currency, Ticker ticker) {
		Optional<History> find = repo.findById(currency);
		if (find.isPresent()) {
			History histo = find.get();
			BigDecimal lastPrice = histo.getLastPrice().setScale(8, RoundingMode.HALF_EVEN);
			BigDecimal bid = ticker.getBid().setScale(8, RoundingMode.HALF_EVEN);

			// se o preço que paguei é menor que o atual, eu faço a conta
			if (lastPrice.compareTo(bid) == -1) {
				BigDecimal multiply = bid.multiply(new BigDecimal("100"));
				BigDecimal divide = multiply.divide(lastPrice, 10, RoundingMode.HALF_EVEN);

				BigDecimal result = divide.subtract(new BigDecimal("100"));

				if (result.compareTo(new BigDecimal("60")) >= 1) {
					StringBuilder sb = new StringBuilder();
					sb.append("Vendendo BYTECOIN agora você tem ");
					sb.append(result.setScale(0, RoundingMode.HALF_EVEN));
					sb.append("% de lucro sobre sua ultima compra ");
					sb.append("\n");
					sb.append("Ultima compra " + lastPrice.toPlainString());
					sb.append(" ");
					sb.append("em " + new SimpleDateFormat("dd/MM/yyy HH:mm:ss").format(histo.getLastTrade()));
					sb.append("\n");
					sb.append("Preço atual " + bid.toPlainString());
					sb.append(" ");
					sb.append("em " + new SimpleDateFormat("dd/MM/yyy HH:mm:ss").format(ticker.getTimestamp()));

					String msg = sb.toString();

					System.out.println(msg);
					
					Date now = new Date();
					Date lastNotification = histo.getLastNotification();
					boolean dia = now.getDay() == lastNotification.getDay();
					boolean hora = now.getHours() == lastNotification.getHours();
					
					if (!(dia && hora)) {
						mailService.sendSimpleMessage("rodrigonunes@live.com", "Vender Bytecoin na HitBTC", msg);
						histo.setLastNotification(new Date());
						repo.save(histo);
					}
				}
			}

		}

	}

}
