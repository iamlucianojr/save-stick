package br.edu.ifc.luciano.savestick.control;

import br.edu.ifc.luciano.savestick.model.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ActorObjectFactory {

    Properties aliasActorObject = new Properties();
    public ActorObjectFactory() {
        try {
            aliasActorObject.load(new FileInputStream("/var/www/SaveStick/src/br/edu/ifc/luciano/savestick/assets/alias_actor_object.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ActorObject getActorObject(String actorClassName) {
        if(actorClassName == null) return null;

        ActorObject actorObject = null;
        String className = aliasActorObject.getProperty(actorClassName);
        try {
            Class genericClass = Class.forName(className);
            Object object = genericClass.newInstance();
            actorObject = (ActorObject) object;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return actorObject;
    }
}
