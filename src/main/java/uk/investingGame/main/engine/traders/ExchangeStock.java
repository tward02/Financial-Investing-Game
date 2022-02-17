package uk.investingGame.main.engine.traders;

import uk.investingGame.main.engine.stocks.Stock;

public interface ExchangeStock {

  void buyStock(Stock stock, int amount);
  void sellStock(Stock stock, int amount);

  //add more when appropriate

}
