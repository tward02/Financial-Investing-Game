package uk.investingGame.main.engine;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import uk.investingGame.main.engine.events.Event;
import uk.investingGame.main.engine.events.EventReader;

public class GameCalendar extends Thread { //could possibly extend thread so this can happen in background regardless of other processes - needs looking into
  //https://stackoverflow.com/questions/16441069/increment-time-in-date-variable

  private Date date;
  private static ArrayList<Event> events;
  private HashMap<Date, Event> CalendarEvents;
  private static final int[] DAYS_IN_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  private static final String[] DAYS_OF_WEEK = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
  //need to sort out events in exchange as well

  public GameCalendar() {
    date = new Date(2000, 0, 1, 0, 0, 0);
    CalendarEvents = new HashMap<>();
    EventReader eventReader = new EventReader();
    events = eventReader.getEvents();
  }

  @Override
  public void run() {
    //use .start() to run thread - need to check if this will actually work
  }

  public void incrementTime() {
    if (date.getHours() == 23) {
      date.setHours(0);
      if (date.getDate() == DAYS_IN_MONTHS[date.getMonth()]) {
        date.setDate(1);
        if (date.getMonth() == 11) {
          date.setYear(date.getYear() + 1);
          date.setMonth(0);
        } else {
          date.setMonth(date.getMonth() + 1);
        }
      } else {
        date.setDate(date.getDate() + 1);
      }
    } else {
      date.setHours(date.getHours() + 1);
    }
  }

  public Event getEventOnCurrentDate() {
    return null;
  }

  public Event getEventOnDate(Date date) {
    return null;
  }

  public void addEvent(Date date, Event event) {
    CalendarEvents.put(date, event);
  }

  public ArrayList<Event> getEVENTS() {
    return events;
  }

  private Event getRandomEvent() {
    Random rand = new Random();
    int num = rand.nextInt(events.size());
    return events.get(num);
  }

  public String getDayOfWeek() {
    return DAYS_OF_WEEK[date.getDay()];
  }

  @Override
  public String toString() {
    return date.toString();
    //check
  }
}
