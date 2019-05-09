/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagergbtoycbcr;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Henrique
 */
public class ImageRGBtoYCbCr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            File f = new File("A:\\img.jpg");
            BufferedImage img = ImageIO.read(f);
            BufferedImage Y = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
            BufferedImage Cb = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
            BufferedImage Cr = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
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
                                        
                    Color newColor;
                    
                    double  chY = (double) +r*0.2568 + (double) g*0.5041 + (double) b*0.0979 + 16;
                    double chCb = (double) -r*0.1482 - (double) g*0.2910 + (double) b*0.4392 + 128;
                    double chCr = (double) +r*0.4392 - (double) g*0.3678 - (double) b*0.0714 + 128;
                    
                    //Normalizando
                    double nY = ((chY-16)/218)*255;
                    double nCb = ((chCb-16)/224)*255;
                    double nCr = ((chCr-16)/224)*255;
                    
                    int newColorY = (int) nY;
                    int newColorCr = (int) nCb;
                    int newColorCb = (int) nCr;
                    
                    Color novaCorY = new Color(newColorY, newColorY, newColorY);
                    Y.setRGB(x, y, novaCorY.getRGB());
                    Color novaCorCb = new Color(newColorCb, newColorCb, newColorCb);
                    Cb.setRGB(x, y, novaCorCb.getRGB());
                    Color novaCorCr = new Color(newColorCr, newColorCr, newColorCr);
                    Cr.setRGB(x, y, novaCorCr.getRGB());
                    
                }
            }
            File out = new File("A://Y.jpg");
            ImageIO.write(Y, "jpg", out);
            out = new File("A://Cb.jpg");
            ImageIO.write(Cb, "jpg", out);
            out = new File("A://Cr.jpg");
            ImageIO.write(Cr, "jpg", out);
        } catch (Exception ex) {
            System.out.println("Erro: " +ex.getMessage());
        }        
    }
    
}
