package br.edu.ifc.luciano.savestick.control;

import br.edu.ifc.luciano.savestick.model.*;
import br.edu.ifc.luciano.savestick.model.Map;
import br.edu.ifc.luciano.savestick.model.StreetMap;

public class MapFactory {

    public Map getMap(String mapType) {
        if(mapType == null){
            return null;
        }
        if(mapType.equalsIgnoreCase("STREETMAP")){
            return StreetMap.getInstance();
        } else if(mapType.equalsIgnoreCase("HIGHWAYMAP")){
            return HighwayMap.getInstance();
        }

        return null;
    }
}
