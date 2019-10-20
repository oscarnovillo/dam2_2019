package modelo;

import java.util.*;

public class CurrentSeason {
    private long id;
    private String startDate;
    private String endDate;
    private Long currentMatchday;
    private Object winner;

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public String getStartDate() { return startDate; }
    public void setStartDate(String value) { this.startDate = value; }

    public String getEndDate() { return endDate; }
    public void setEndDate(String value) { this.endDate = value; }

    public Long getCurrentMatchday() { return currentMatchday; }
    public void setCurrentMatchday(Long value) { this.currentMatchday = value; }

    public Object getWinner() { return winner; }
    public void setWinner(Object value) { this.winner = value; }
}
