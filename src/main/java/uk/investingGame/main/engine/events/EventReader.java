package uk.investingGame.main.engine.events;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import uk.investingGame.main.engine.stocks.Stock;
import uk.investingGame.main.engine.utils.Utilities;

public class EventReader {

  private BufferedReader reader;
  private Utilities utilities;

  public EventReader() {
    utilities = new Utilities();
    try {
      reader = new BufferedReader(new FileReader("data/events.txt"));
    } catch (FileNotFoundException e) {
      System.err.println("events.txt not found");
    }
  }

  // id,name,description,stock ids,date/nd
  //sort out for new event types
  public ArrayList<Event> getEvents() {
    String line;
    ArrayList<Event> events = new ArrayList<>();
    ArrayList<String> nonFormatted = new ArrayList<>();
    try {
      while ((line = reader.readLine()) != null) {
        nonFormatted.add(line);
      }
    } catch (IOException e) {
      System.out.println("error unable to read events file");
    }
    for (String eventLine : nonFormatted) {
      String[] splitLine = eventLine.split(",");
      if (splitLine.length == 5) {
        Date date = new Date();
        String[] splitDate = splitLine[4].split(".");
        date.setDate(Integer.parseInt(splitDate[0]));
        date.setMonth(Integer.parseInt(splitDate[1]));
        date.setYear(Integer.parseInt(splitDate[2]));
        String[] stockStrings = splitLine[3].split(".");
        Stock[] stocks = new Stock[stockStrings.length];
        for (int i = 0; i < stocks.length; i++) {
          stocks[i] = utilities.getStock(Integer.parseInt(stockStrings[i]));
        }
        //events.add(
            //new Event(Integer.parseInt(splitLine[0]), splitLine[1], splitLine[2], stocks, date));
      } else {
        String[] stockStrings = splitLine[3].split(".");
        Stock[] stocks = new Stock[stockStrings.length];
        for (int i = 0; i < stocks.length; i++) {
          stocks[i] = utilities.getStock(Integer.parseInt(stockStrings[i]));
        }
        //events.add(new Event(Integer.parseInt(splitLine[0]), splitLine[1], splitLine[2], stocks));
      }
    }
    return events;
  }
}
