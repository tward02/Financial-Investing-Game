package uk.investingGame.main.engine.traders;

import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import uk.investingGame.main.engine.stocks.Stock;

public class Trader implements ExchangeStock {

  private float money;
  private HashMap<Integer, Integer> playerStocks = new HashMap<>();
  private static final Currency CURRENCY = Currency.getInstance(Locale.UK);

  public Trader(float money) {
    this.money = money;
  }

  @Override
  public void buyStock(Stock stock, int amount) {
    float price = stock.getSharesPrice(amount);
    if (price > money) {
      System.out.println("Not enough money!");
    } else {
      int amountBought = stock.buyStock(amount);
      playerStocks.put(stock.getId(), amountBought);
    }
  }

  @Override
  public void sellStock(Stock stock, int amount) {
    if (amount > playerStocks.get(stock.getId())) {
      System.out.println("You don't have this much stock to sell");
    } else {
      float price = stock.getSharesPrice(amount);
      int current = playerStocks.get(stock.getId());
      playerStocks.replace(stock.getId(), current - amount);
      money += price;
      playerStocks.remove(stock.getId(), 0);
    }
  }
}
