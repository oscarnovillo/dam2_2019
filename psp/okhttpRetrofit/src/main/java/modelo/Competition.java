package modelo;

import java.util.*;

public class Competition {
    private long id;
    private Area area;
    private String name;
    private String code;
    private Object emblemURL;
    private String plan;
    private CurrentSeason currentSeason;
    private long numberOfAvailableSeasons;
    private String lastUpdated;

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public Area getArea() { return area; }
    public void setArea(Area value) { this.area = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getCode() { return code; }
    public void setCode(String value) { this.code = value; }

    public Object getEmblemURL() { return emblemURL; }
    public void setEmblemURL(Object value) { this.emblemURL = value; }

    public String getPlan() { return plan; }
    public void setPlan(String value) { this.plan = value; }

    public CurrentSeason getCurrentSeason() { return currentSeason; }
    public void setCurrentSeason(CurrentSeason value) { this.currentSeason = value; }

    public long getNumberOfAvailableSeasons() { return numberOfAvailableSeasons; }
    public void setNumberOfAvailableSeasons(long value) { this.numberOfAvailableSeasons = value; }

    public String getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(String value) { this.lastUpdated = value; }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Competition{");
        sb.append("id=").append(id);
        sb.append(", area=").append(area);
        sb.append(", name='").append(name).append('\'');
        sb.append(", code='").append(code).append('\'');
        sb.append(", emblemURL=").append(emblemURL);
        sb.append(", plan='").append(plan).append('\'');
        sb.append(", currentSeason=").append(currentSeason);
        sb.append(", numberOfAvailableSeasons=").append(numberOfAvailableSeasons);
        sb.append(", lastUpdated='").append(lastUpdated).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
