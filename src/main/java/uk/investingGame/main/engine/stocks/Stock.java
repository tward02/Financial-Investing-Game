package uk.investingGame.main.engine.stocks;

import java.util.Currency;
import java.util.Locale;
import uk.investingGame.main.engine.events.Event;

public class Stock {

  private static final Currency CURRENCY = Currency.getInstance(Locale.UK);
  private final String name;
  private final String abv;
  private final int id;
  private float marketCap;
  private final int outstandingShares;
  private float price;
  private int availableToSell;
  private float percentageChange;

  public Stock(int id, String abv, String name, float marketCap, float price) {
    this.name = name;
    this.abv = abv;
    this.marketCap = marketCap;
    this.price = price;
    this.id = id;
    //calc sold shares, unsold shares - possibly make share an object
    outstandingShares = (int) (marketCap / price);
  }

  public String getName() {
    return name;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getAbv() {
    return abv;
  }

  public int getOutstandingShares() {
    return outstandingShares;
  }

  public int getId() {
    return this.id;
  }

  private int calculateStockPrice() {
    //work out an algorithm that we calculate price of a stock based on supply and demand and also external events - might not need to return anything
    return 0;
  }

  public float getSharesPrice(int amount) {
    float price = 0;
    if (amount > availableToSell) {
      price = availableToSell * this.price;
      availableToSell = 0;
    } else {
      price = amount * this.price;
    }
    return price;
  }

  public int buyStock(int amount) {
    //rewrite
    return 0;
  }

  public void sellStock(int amount) {
    availableToSell -= amount;
  }

  @Override
  public String toString() {
    return abv + ": " +  CURRENCY.toString() + " " + price;
  }

  public void updateStock(Event event) {
    //calculate stock price using principles of supply and demand + any occurring events
    //recalc market cap
    if (event == null) {
      //...
    } else {
      //...
    }
  }
}
