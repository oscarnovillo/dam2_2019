package modelo;

import java.util.*;

public class Area {
    private long id;
    private String name;
    private String countryCode;
    private String ensignURL;
    private Long parentAreaID;
    private ParentArea parentArea;

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getCountryCode() { return countryCode; }
    public void setCountryCode(String value) { this.countryCode = value; }

    public String getEnsignURL() { return ensignURL; }
    public void setEnsignURL(String value) { this.ensignURL = value; }

    public Long getParentAreaID() { return parentAreaID; }
    public void setParentAreaID(Long value) { this.parentAreaID = value; }

    public ParentArea getParentArea() { return parentArea; }
    public void setParentArea(ParentArea value) { this.parentArea = value; }
}
