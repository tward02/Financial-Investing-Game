package uk.investingGame.main.engine.stocks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StockReader {

  private BufferedReader reader;

  public StockReader() {
    try {
      reader = new BufferedReader(new FileReader("data/stocks.txt"));
    } catch (FileNotFoundException e) {
      System.err.println("stocks.txt not found");
    }
  }
  //format - id,abv,name,marketCap*1000000,price
  public ArrayList<Stock> getStocks() {
    String line;
    ArrayList<Stock> stocks = new ArrayList<>();
    ArrayList<String> nonFormatted = new ArrayList<>();
    try {
      while ((line = reader.readLine()) != null) {
        nonFormatted.add(line);
    }
    } catch (IOException e) {
      System.out.println("error unable to read stocks file");
    }
    for (String lineInFile : nonFormatted) {
      String[] splitLine = lineInFile.split(",");
      stocks.add(new Stock(Integer.parseInt(splitLine[0]), splitLine[1], splitLine[2], Float.parseFloat(splitLine[3]) * 1000000, Float.parseFloat(splitLine[4])));
    }
    return stocks;
  }
}
