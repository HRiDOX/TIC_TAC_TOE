import javax.swing.*;
import java.awt.*;

class ThemeChangingPanel extends JPanel {


    private  Color color3;
    private  Color color4;

    ThemeChangingPanel(int n) {
        int number = n;

        if (number == 1) {
            //this.GenerateRandomColor(number);
            int red, green, blue ,black;
            red = (int) (Math.random() * 255);
            green = (int) (Math.random() * 255);
            blue = (int) (Math.random() * 255);
             black=(int)(Math.random()*255);
            color3 = new Color(red, green, blue,black);
            color4 = new Color(black,blue,green,red);

        } else {
             color3 = Color.black;
             color4 = Color.GRAY;

        }

    }




    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();


        GradientPaint gp = new GradientPaint(200, 300, color3, 300, h, color4);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
}