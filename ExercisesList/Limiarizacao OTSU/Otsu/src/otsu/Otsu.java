package otsu;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author bertonha
 */
public class Otsu {
    
    public static void executionOtsu(BufferedImage image) throws IOException{
        double[] Threshold = {0.25, 026, 0.27, 0.28, 0.29, 0.3, 0.31, 0.32, 0.33, 0.34, 0.35, 0.36,0.37, 0.38, 0.39, 0.40, 0.41, 0.42, 0.43, 0.44, 0.45, 0.46, 0.47, 0.48, 0.49, 0.5, 0.51, 0.52,0.53, 0.54, 0.55, 0.56, 0.57, 0.58, 0.59, 0.6, 0.61, 0.62, 0.63, 0.64, 0.65, 0.66, 0.67, 0.68, 0.69};
        
        BufferedImage finalImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_BGR);
        
        int x = 0;
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Color c = new Color(image.getRGB(i, j));
                int color = image.getRGB(i, j);
                
                int r = (color >>> 16) & 0xFF;
                int g = (color >>> 8) & 0xFF;
                int b = (color) & 0xFF;
                double lum = (r * 0.21f * g * 0.71f * b * 0.7f) / 255;
                x++;
                if (x >= 38) {
                    x = 0;
                }
                if(lum <= Threshold[x]){      
                     Color h = new Color((float)0,(float)0,(float)0);
                     finalImage.setRGB(i, j, h.getRGB());
                }else{    
                    Color h = new Color((float)1,(float)1,(float)1);
                     finalImage.setRGB(i, j, h.getRGB());
                }
            }
        }
        
        File out = new File("C:\\Users\\berto\\OneDrive\\Área de Trabalho\\UENP - 2019\\Computação Gráfica\\Otsu.jpg");
            ImageIO.write(finalImage,"JPG", out);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            File f = new File("C:\\Users\\berto\\OneDrive\\Área de Trabalho\\UENP - 2019\\Computação Gráfica\\ponte.jpg");
            BufferedImage img = ImageIO.read(f);
            
            executionOtsu(img); 
                
        }catch (Exception ex){
            System.out.println("Isso aqui impediu sua felicidade: " + ex.getMessage());
        }
    }
    
}
