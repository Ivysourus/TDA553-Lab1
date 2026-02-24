package org.tda553group22.lab3.ui;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

final class ResourcesHandler {
    static BufferedImage volvoWorkshopImage;
    static BufferedImage volvoImage;
    static BufferedImage saabImage;
    static BufferedImage scaniaImage;

    public static final ResourcesHandler instance = new ResourcesHandler();

    private ResourcesHandler() {
        try {
            volvoWorkshopImage = ImageIO.read(ResourcesHandler.class.getResourceAsStream("/pics/VolvoBrand.jpg"));
            volvoImage = ImageIO.read(ResourcesHandler.class.getResourceAsStream("/pics/Volvo240.jpg"));
            saabImage = ImageIO.read(ResourcesHandler.class.getResourceAsStream("/pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(ResourcesHandler.class.getResourceAsStream("/pics/Scania.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
