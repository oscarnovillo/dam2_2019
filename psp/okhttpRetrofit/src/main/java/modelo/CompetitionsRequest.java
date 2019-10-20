package modelo;

import java.util.*;

public class CompetitionsRequest {
    private long count;
    private Filters filters;
    private List<Competition> competitions;

    public long getCount() { return count; }
    public void setCount(long value) { this.count = value; }

    public Filters getFilters() { return filters; }
    public void setFilters(Filters value) { this.filters = value; }

    public List<Competition> getCompetitions() { return competitions; }
    public void setCompetitions(List<Competition> value) { this.competitions = value; }
}
