package modelo;

import java.util.*;
import java.io.IOException;

public enum ParentArea {
    AFRICA, ASIA, EUROPE, N_C_AMERICA, OCEANIA, SOUTH_AMERICA, WORLD;

    public String toValue() {
        switch (this) {
        case AFRICA: return "Africa";
        case ASIA: return "Asia";
        case EUROPE: return "Europe";
        case N_C_AMERICA: return "N/C America";
        case OCEANIA: return "Oceania";
        case SOUTH_AMERICA: return "South America";
        case WORLD: return "World";
        }
        return null;
    }

    public static ParentArea forValue(String value) throws IOException {
        if (value.equals("Africa")) return AFRICA;
        if (value.equals("Asia")) return ASIA;
        if (value.equals("Europe")) return EUROPE;
        if (value.equals("N/C America")) return N_C_AMERICA;
        if (value.equals("Oceania")) return OCEANIA;
        if (value.equals("South America")) return SOUTH_AMERICA;
        if (value.equals("World")) return WORLD;
        throw new IOException("Cannot deserialize ParentArea");
    }
}
