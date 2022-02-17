package uk.investingGame.main.engine.utils;

import java.util.ArrayList;
import java.util.HashMap;
import uk.investingGame.main.engine.stocks.Stock;
import uk.investingGame.main.engine.stocks.StockReader;

public class Utilities {

  private static final HashMap<Integer, Stock> STOCKTOID = new HashMap<>();

  public Utilities() {
    StockReader stockReader = new StockReader();
    ArrayList<Stock> stocks = stockReader.getStocks();
    for (Stock stock : stocks) {
      STOCKTOID.put(stock.getId(), stock);
    }
  }

  public HashMap<Integer, Stock> getStocksToID() {
    return STOCKTOID;
  }

  public Stock getStock(int id) {
    return STOCKTOID.get(id);
  }
}
