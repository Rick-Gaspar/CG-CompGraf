package hsi;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author bertonha
 */
public class Hsi {

        public static double delimitador(double x) {
            if (x < 0) {
                return 0;
            } else if (x > 255) {
                return 255;
            }
        return x;
}
    
    public static void executionHsi(BufferedImage img) throws IOException{
        BufferedImage redImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        BufferedImage greenImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        BufferedImage blueImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        int cont = 0;
        
        
        for (int x = 0; x < img.getWidth(); x++) {
            for (int z = 0; z < img.getHeight(); z++) {
                  Color pixel = new Color(img.getRGB(x, z));
                  
                    double r = pixel.getRed() / 255.0;
                    double g = pixel.getGreen() / 255.0;
                    double b = pixel.getBlue() / 255.0;

                    double var = Math.acos((0.5 * (r - g) + (r - b)) / (Math.pow(Math.pow(r - g, 2) + (r - b) * (g - b), 0.5)));
                    double h;
                    if (b <= g) {
                        h = var;
                    } else {
                        h = 2 * Math.PI - var;
                    }
                    double i = (r + g + b) / 3;
                    double s = 1 - (3 / (r + g + b)) * Math.min(Math.min(r, g), b);

                    h = delimitador(h * 255);
                    s = delimitador(s * 255);
                    i = delimitador(i * 255);

                    redImage.setRGB(x, z, new Color((int) h, (int) h, (int) h).getRGB());
                    greenImage.setRGB(x, z, new Color((int) s, (int) s, (int) s).getRGB());
                    blueImage.setRGB(x, z, new Color((int) i, (int) i, (int) i).getRGB());
                    
                    cont++;
                    
                   
            }
        }
        
         File out = new File("C:\\Users\\berto\\OneDrive\\Área de Trabalho\\UENP - 2019\\Computação Gráfica\\H.jpg");
                        ImageIO.write(redImage, "JPG", out);
                    out = new File("C:\\Users\\berto\\OneDrive\\Área de Trabalho\\UENP - 2019\\Computação Gráfica\\S.jpg");
                        ImageIO.write(greenImage, "JPG", out);
                    out = new File("C:\\Users\\berto\\OneDrive\\Área de Trabalho\\UENP - 2019\\Computação Gráfica\\I.jpg");
                        ImageIO.write(blueImage, "JPG", out);
        
    }
    
    
    public static void main(String[] args) {
        try{
            File f = new File("C:\\Users\\berto\\OneDrive\\Área de Trabalho\\UENP - 2019\\Computação Gráfica\\ponte.jpg");
            BufferedImage img = ImageIO.read(f);
            
            executionHsi(img); 
                
        }catch (Exception ex){
            System.out.println("Isso aqui impediu sua felicidade: " + ex.getMessage());
        }
    }
    
}
