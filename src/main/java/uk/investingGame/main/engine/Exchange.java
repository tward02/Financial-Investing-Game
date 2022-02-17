package uk.investingGame.main.engine;


import java.util.ArrayList;
import uk.investingGame.main.engine.stocks.Stock;
import uk.investingGame.main.engine.stocks.StockReader;
import uk.investingGame.main.engine.traders.Player;

public class Exchange {

  private static ArrayList<Stock> STOCKS;

  public Exchange(Player player) {
    StockReader stockReader = new StockReader();
    STOCKS = stockReader.getStocks();
  }

  public Stock getStock(int id) {
    for (Stock stock : STOCKS) {
      if (stock.getId() == id) {
        return stock;
      }
    }
    System.out.println("error stock not found");
    return null;
  }

  public ArrayList<Stock> getSTOCKS() {
    return STOCKS;
  }

}
