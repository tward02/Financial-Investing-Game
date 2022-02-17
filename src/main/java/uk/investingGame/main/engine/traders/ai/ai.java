package uk.investingGame.main.engine.traders.ai;

import uk.investingGame.main.engine.stocks.Stock;
import uk.investingGame.main.engine.traders.ExchangeStock;
import uk.investingGame.main.engine.traders.Trader;

public class ai extends Trader implements ExchangeStock {

  public ai(float money) {
    super(money);
  }

  @Override
  public void buyStock(Stock stock, int amount) {

  }

  @Override
  public void sellStock(Stock stock, int amount) {

  }
}
