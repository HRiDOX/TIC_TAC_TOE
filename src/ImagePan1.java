import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class ImagePan1 extends JPanel {
    private BufferedImage img;
    public ImagePan1()  {
        try{
            img = ImageIO.read(new File("Tic_Tac_toe/img/cover3.jpg"));
        }catch (IOException ex){
            System.out.println("Error : "+ex.getMessage());

        }
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img,0,0,null);
    }
}

