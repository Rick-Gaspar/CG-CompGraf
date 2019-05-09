/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagebasics;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Henrique
 */
public class ImageBasics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            File f = new File("A:\\img.jpg");
            BufferedImage img = ImageIO.read(f);
            for (int x = 0; x < img.getWidth(); x++) {
                for (int y = 0; y < img.getHeight(); y++) {
                    Color c = new Color(img.getRGB(x, y));
                    int rgb = img.getRGB(x, y);
                    System.out.print("POS = (" + x + "," + y + ")");                    
                    System.out.print("RGB: " + rgb);
                    System.out.print(" RGB HEX: " + Integer.toHexString(rgb));
                    int r = c.getRed();
                    int g = c.getGreen();
                    int b = c.getBlue();
                    System.out.println(" R = " + r + " G = " + g + " B = " + b);
                }
            }
        } catch (Exception ex) {
            System.out.println("Erro: " +ex.getMessage());
        }
    }
    
}
