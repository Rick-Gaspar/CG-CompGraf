package grayscale;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.System.out;
import javax.imageio.ImageIO;

/**
 *
 * @author Henrique Gaspar
 */
public class GrayScale {

    public static int mediaPixel(Color corPixel){
            int r = corPixel.getRed();
            int g = corPixel.getGreen();
            int b = corPixel.getBlue();
        return (int) ((r + g + b)/3);
    }
    
    public static void imageToGrayScaleNormal(BufferedImage image) throws IOException{
            BufferedImage imageGrayNormal = new BufferedImage(image.getWidth(), image.getHeight(),BufferedImage.TYPE_BYTE_GRAY);  
            Graphics g = imageGrayNormal.getGraphics();  
            g.drawImage(image, 0, 0, null);  
            g.dispose();
            
            String outPut = "C:\\Users\\henri\\Desktop\\U2 The Joshua Tree\\telaoN.jpg";
            File out = new File(outPut);
            ImageIO.write(imageGrayNormal,"JPG",out); 
    }
    
    public static void imageToGrayScaleAverage(BufferedImage in) throws IOException {
                int x =0;
                int z =0;
                Color pixelColor = new Color(in.getRGB(x, z));
                BufferedImage newImageGray = new BufferedImage(in.getWidth(), in.getHeight(),in.getType());
                for (x = 0; x < in.getWidth(); x++) {
                    for (z = 0; z < in.getHeight(); z++) {
                        int media = mediaPixel(new Color(in.getRGB(x, z)));
                        newImageGray.setRGB(x, z, new Color(media, media, media).getRGB());
                    }
                }    
                String outPut = "C:\\Users\\henri\\Desktop\\U2 The Joshua Tree\\telaoCinza.jpg";
		File out = new File(outPut);
                ImageIO.write(newImageGray,"JPG",out);          
	}
   
    public static void main(String[] args) {
        try{
            File f = new File("C:\\Users\\henri\\Desktop\\U2 The Joshua Tree\\telao.jpg");
            BufferedImage img = ImageIO.read(f);
            
            //Escala de cinza padrão
            imageToGrayScaleNormal(img);
            
            //Escala de cinza através da média
            //imageToGrayScaleAverage(img);
                
        }catch (Exception ex){
            System.out.println("Erro " + ex.getMessage());
        }
    }
    
}
