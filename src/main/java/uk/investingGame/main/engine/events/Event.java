package uk.investingGame.main.engine.events;



import java.util.Date;
import uk.investingGame.main.engine.stocks.Stock;

public abstract class Event {

  private final int id;
  private final String eventName;
  private final String eventDescription;
  private Date date;
  private final EventType eventType;
  // needs more work
  // add effect to stock
  // possibly implement positive/egative effect to stock??? needs more work
  public Event(
      int id, String eventName, String eventDescription, Date date, EventType eventType) {
    this.eventName = eventName;
    this.eventDescription = eventDescription;
    this.id = id;
    this.date = date;
    this.eventType = eventType;
  }

  public Event(int id, String eventName, String eventDescription, EventType eventType) {
    this.eventName = eventName;
    this.eventDescription = eventDescription;
    this.id = id;
    this.eventType = eventType;
  }

  public String getEventName() {
    return eventName;
  }

  public String getEventDescription() {
    return eventDescription;
  }

  public int getId() {
    return id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public EventType getEventEffect() {
    return null;
  }

  public class stockEvent extends Event {

    private final Stock[] stocksEffected;

    public stockEvent(
        int id, String eventName, String eventDescription, Stock[] stocksEffected, Date date, EventType eventType) {
      super(id, eventName, eventDescription, date, eventType);
      this.stocksEffected = stocksEffected;
    }

    public stockEvent(int id, String eventName, String eventDescription, Stock[] stocksEffected, EventType eventType) {
      super(id, eventName, eventDescription, eventType);
      this.stocksEffected = stocksEffected;
    }

    public Stock[] getStocksEffected() {
      return stocksEffected;
    }
  }

  public class marketEvent extends Event {

    public marketEvent(int id, String eventName, String eventDescription, Date date, EventType eventType) {
      super(id, eventName, eventDescription, date, eventType);
    }

    public marketEvent(int id, String eventName, String eventDescription, EventType eventType) {
      super(id, eventName, eventDescription, eventType);
    }
  }

  public enum EventType {

    PANIC_BUY() {
      @Override
      public float[] getEffect(Stock[] stocks) {
        return null;
      }

      @Override
      public String eventToString() {
        return null;
      }
    },
    PANIC_SELL() {
      @Override
      public float[] getEffect(Stock[] stocks) {
        return null;
      }

      @Override
      public String eventToString() {
        return null;
      }
    },
    MARKET_BUBBLE() {
      @Override
      public float[] getEffect(Stock[] stocks) {
        return null;
      }

      @Override
      public String eventToString() {
        return null;
      }
    },
    MARKET_CRASH() {
      @Override
      public float[] getEffect(Stock[] stocks) {
        return null;
      }

      @Override
      public String eventToString() {
        return null;
      }
    },
    RECESSION() {
      @Override
      public float[] getEffect(Stock[] stocks) {
        return null;
      }

      @Override
      public String eventToString() {
        return null;
      }
    };

    public abstract float[] getEffect(Stock[] stocks);
    public abstract String eventToString();

  }
}
