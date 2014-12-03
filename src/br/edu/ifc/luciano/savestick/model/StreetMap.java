package br.edu.ifc.luciano.savestick.model;

public class StreetMap extends Map {

    private static StreetMap instance = new StreetMap();
    private static final String PATH_IMAGE_STREETMAP = "/var/www/SaveStick/src/br/edu/ifc/luciano/savestick/assets/map.jpg";
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public static synchronized StreetMap getInstance(){
        return instance;
    }

    private StreetMap() {
        setPathImg(PATH_IMAGE_STREETMAP);
        setupUI(WIDTH, HEIGHT);
    }
}
