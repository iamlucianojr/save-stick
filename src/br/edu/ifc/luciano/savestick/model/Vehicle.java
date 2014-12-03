package br.edu.ifc.luciano.savestick.model;

public class Vehicle extends ActorObject {
    protected static int HEIGHT = 50;
    protected static int WIDTH = 50;

    @Override
    public int getWidth() {
        return HEIGHT;
    }

    @Override
    public int getHeight() {
        return WIDTH;
    }

}
