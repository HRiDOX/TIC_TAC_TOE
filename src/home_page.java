import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;




public class home_page extends ThemeChangingPanel implements ActionListener, MouseListener {
    String lab;
   
    JLabel mainName,imgName,name1,name2,name3,name4,circ1,circ2,circ3;
    JButton onep;
    JButton twop;
    JButton threep;



    public home_page(){
        super(1);


        setLayout(null);

        mainName = new JLabel("Tic Tac Toe");
        mainName.setForeground(Color.MAGENTA);
        mainName.setBorder(null);
        mainName.setLayout(null);
        mainName.setBackground(Color.WHITE);
        mainName.setBounds(380,25,300,30);
        URL url = home_page.class.getResource("/img/icon3.png");

        //imgName = new JLabel("X");
        imgName = new JLabel();
        imgName.setIcon(new ImageIcon(url));
        imgName.setBounds(60,30,200,200);

        Font f1  = new Font("Arial",Font.BOLD,80);
        Font f2 = new Font("Arial",Font.PLAIN,20);

        mainName.setFont(f2);

        name1 = new JLabel("X");
        name1.setBorder(null);
        name1.setLayout(null);
        name1.setFont(f1);
        name1.setBackground(Color.black);
        name1.setForeground(Color.cyan);
        name1.setBounds(300,40,100,100);

        name2 = new JLabel("O");
        name2.setBorder(null);
        name2.setLayout(null);
        name2.setFont(f1);
        name2.setBackground(Color.black);
        name2.setForeground(Color.WHITE);
        name2.setBounds(370,40,100,100);

        name3 = new JLabel("X");
        name3.setBorder(null);
        name3.setLayout(null);
        name3.setFont(f1);
        name3.setBackground(Color.black);
        name3.setForeground(Color.CYAN);
        name3.setBounds(450,40,100,100);

        name4 = new JLabel("O");
        name4.setBorder(null);
        name4.setLayout(null);
        name4.setFont(f1);
        name4.setBackground(Color.BLACK);
        name4.setForeground(Color.white);
        name4.setBounds(520,40,100,100);

        Font f3 = new Font("Arial",Font.BOLD,38);

        URL url1 = home_page.class.getResource("/img/cir2.png");

        circ1 = new JLabel();
        circ1.setLayout(null);
        circ1.setIcon(new ImageIcon(url1));
        //circ1.setContentAreaFilled(false);
        circ1.setOpaque(false);
        circ1.setBorder(null);
        circ1.setVisible(false);
        circ1.setBounds(200,275,50,50);

        circ2 = new JLabel();
        circ2.setLayout(null);
        circ2.setIcon(new ImageIcon(url1));
        //circ1.setContentAreaFilled(false);
        circ2.setOpaque(false);
        circ2.setBorder(null);
        circ2.setVisible(false);
        circ2.setBounds(200,375,50,50);

        circ3 = new JLabel();
        circ3.setLayout(null);
        circ3.setIcon(new ImageIcon(url1));
        //circ1.setContentAreaFilled(false);
        circ3.setOpaque(false);
        circ3.setBorder(null);
        circ3.setVisible(false);
        circ3.setBounds(200,475,50,50);

        onep = new JButton("One Player");
        onep.setBackground(null);
        onep.setBounds(240,250,300,100);
        onep.setOpaque(false);
        onep.setContentAreaFilled(false);
        onep.setBorderPainted(false);
        onep.setFocusable(false);
        onep.setForeground(Color.decode("#e3a624"));
        onep.setFont(f3);

        twop = new JButton("Two Player");
        twop.setBackground(null);
        twop.setBounds(240,350,300,100);
        twop.setOpaque(false);
        twop.setContentAreaFilled(false);
        twop.setBorderPainted(false);
        twop.setFocusable(false);
        twop.setForeground(Color.decode("#3a624"));
        twop.setFont(f3);

        threep = new JButton("Change Theme");
        threep.setBackground(null);
        threep.setBounds(240,450,380,100);
        threep.setOpaque(false);
        threep.setContentAreaFilled(false);
        threep.setBorderPainted(false);
        threep.setFocusable(false);
        threep.setForeground(Color.decode("#3a624"));
        threep.setFont(f3);


        onep.setActionCommand("one");
        twop.setActionCommand("two");
        threep.setActionCommand("three");

        onep.addActionListener(this);
        onep.addMouseListener(this);
        twop.addActionListener(this);
        twop.addMouseListener(this);
        threep.addActionListener(this);
        threep.addMouseListener(this);

        add(mainName);
        add(imgName);
        add(name1);
        add(name2);
        add(name3);
        add(name4);
        add(circ1);
        add(circ2);
        add(circ3);
        add(onep);
        add(twop);
        add(threep);


    }









    @Override
    public void actionPerformed(ActionEvent e) {
         lab = e.getActionCommand();


    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    AbstractButton EventSource = (AbstractButton)e.getSource();

    if (EventSource.equals(onep)){
        EventSource.setForeground(Color.CYAN);
        circ1.setVisible(true);
    }
    else if (EventSource.equals(twop)){
      EventSource.setForeground(Color.CYAN);
      circ2.setVisible(true);
    }
    else if (EventSource.equals(threep)){
        EventSource.setForeground(Color.CYAN);
        circ3.setVisible(true);
    }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        AbstractButton EventSource = (AbstractButton)e.getSource();

        if (EventSource.equals(onep)){
            EventSource.setForeground(Color.decode("#e3a624"));
            circ1.setVisible(false);
        }
        else if (EventSource.equals(twop)){
            EventSource.setForeground(Color.decode("#e3a624"));
            circ2.setVisible(false);
        }
        else if (EventSource.equals(threep)){
            EventSource.setForeground(Color.decode("#e3a624"));
            circ3.setVisible(false);
        }
    }
}
