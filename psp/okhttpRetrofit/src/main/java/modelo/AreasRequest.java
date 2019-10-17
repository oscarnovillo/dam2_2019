package modelo;

import java.util.*;

public class AreasRequest {
    private long count;
    private Filters filters;
    private List<Area> areas;

    public long getCount() { return count; }
    public void setCount(long value) { this.count = value; }

    public Filters getFilters() { return filters; }
    public void setFilters(Filters value) { this.filters = value; }

    public List<Area> getAreas() { return areas; }
    public void setAreas(List<Area> value) { this.areas = value; }
}
