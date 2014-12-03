package br.edu.ifc.luciano.savestick.control;

import br.edu.ifc.luciano.savestick.model.ActorObject;

import java.awt.*;

public interface ColisionObserver {
    public boolean isCollision(int pontoX, int pontoY, int x, int y, int w, int h);
    public boolean isCollision(Point point, ActorObject actorObjectColliser);
    public void readyMapCollision(ActorObject actorObjectA, ActorObject actorObjectB);
}