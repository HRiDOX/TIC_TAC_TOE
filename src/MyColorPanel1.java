import javax.swing.*;
import java.awt.*;

class MyColorPanel1 extends JPanel
{

    MyColorPanel1()
    {	}
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        Color color1 = Color.black;
        Color color2 = Color.GRAY;
        GradientPaint gp = new GradientPaint(200, 300, color1, 200, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);

    }

}
