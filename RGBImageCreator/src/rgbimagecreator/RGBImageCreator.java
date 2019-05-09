/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rgbimagecreator;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Henrique 
 */
public class RGBImageCreator {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            File f = new File("A:\\img.jpg");
            BufferedImage img = ImageIO.read(f);
            BufferedImage redImg = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
            BufferedImage greenImg = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
            BufferedImage blueImg = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
            for (int x = 0; x < img.getWidth(); x++) {
                for (int y = 0; y < img.getHeight(); y++) {
                    Color c = new Color(img.getRGB(x, y));
                    int rgb = img.getRGB(x, y);
                    //System.out.print("POS = (" + x + "," + y + ")");                    
                    //System.out.print("RGB: " + rgb);
                    //System.out.print("RGB HEX: " + Integer.toHexString(rgb));
                    int r = c.getRed();
                    int g = c.getGreen();
                    int b = c.getBlue();                                        
                    //System.out.println(" R = " + r + " G = " + g + " B = " + b);
                    Color novaCorR = new Color(r,r,r);
                    redImg.setRGB(x, y, novaCorR.getRGB());
                    Color novaCorG = new Color(g,g,g);
                    greenImg.setRGB(x, y, novaCorG.getRGB());
                    Color novaCorB = new Color(b,b,b);
                    blueImg.setRGB(x, y, novaCorB.getRGB());                   
                }
            }
            File out = new File("A://redImg.jpg");
            ImageIO.write(redImg, "jpg", out);
            out = new File("A://greenImg.jpg");
            ImageIO.write(greenImg, "jpg", out);
            out = new File("A://blueImg.jpg");
            ImageIO.write(blueImg, "jpg", out);
        } catch (Exception ex) {
            System.out.println("Erro: " +ex.getMessage());
        }
    }
}
