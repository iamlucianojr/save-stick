package br.edu.ifc.luciano.savestick.model;

public class HighwayMap extends Map {
    private static HighwayMap instance = new HighwayMap();
    private static final String PATH_IMAGE_HIGHWAY = "/var/www/SaveStick/src/br/edu/ifc/luciano/savestick/assets/map.jpg";
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public static HighwayMap getInstance() {
        if (instance == null) instance = new HighwayMap();
        return instance;
    }

    private HighwayMap() {
        setPathImg(PATH_IMAGE_HIGHWAY);
        setupUI(WIDTH, HEIGHT);
    }
}
