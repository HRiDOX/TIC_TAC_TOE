import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


public class GameChecker extends ThemeChangingPanel implements ActionListener,MouseListener
{
    String lab;
    static int[][] mat;
    static int[][] chk;
    static JButton b[][];
    static URL redcircle,redcross,circle,cross;
    int count;
    static String pname1,pname2;
    JLabel playername1,playername2,vs;
    JButton home;
    static JLabel info;
    static int flag=0;
    static int comp=0;
    JButton again,fourp;
    GameChecker(int count, String name1, String name2)
    {
        super(1);


        setLayout(null);

        setVisible(false);
        this.count=count;
        pname1=name1;
        if(count==2)
        {
            pname2=name2;
        }
        else
        {
            pname2="Computer";
        }
        comp=0;
        flag=0;
        Font f1=new Font("Arial",Font.BOLD,100);
        Font f2=new Font("Arial",Font.PLAIN,35);

        mat=new int[3][3];
        chk=new int[3][3];
        b=new JButton[3][3];

        redcircle = GameChecker.class.getResource("/img/game01.png");
        redcross = GameChecker.class.getResource("/img/game001.png");
        circle = GameChecker.class.getResource("/img/game02.png");
        cross = GameChecker.class.getResource("/img/game002.png");

        System.out.println(cross);

        playername1=new JLabel(pname1);
        playername1.setBounds(170,20,250,70);
        playername1.setOpaque(false);
        playername1.setFont(f2);
        playername1.setForeground(Color.decode("#c4d9f8"));

        playername2=new JLabel(pname2);
        playername2.setBounds(470,20,250,70);
        playername2.setOpaque(false);
        playername2.setFont(f2);
        playername2.setForeground(Color.decode("#c4d9f8"));

        vs=new JLabel("VS");
        vs.setBounds(360,0,150,70);
        vs.setOpaque(false);
        vs.setFont(f2);
        vs.setForeground(Color.decode("#ffd10f"));

        info=new JLabel("Chance of Player "+pname1);
        info.setBounds(170,90,500,20);
        info.setOpaque(false);
        info.setFont(new Font("Arial",Font.PLAIN,20));
        info.setForeground(Color.PINK);

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                b[j][i]=new JButton();
                b[j][i].setBounds(170+(i*150),120+(j*150),130,130);

                b[j][i].setFocusable(false);
                b[j][i].setBackground(Color.DARK_GRAY);
                b[j][i].setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.white));
                b[j][i].setLayout(null);
                b[j][i].setActionCommand("b"+j+i);
                b[j][i].addActionListener(this);
                b[j][i].addMouseListener(this);
                add(b[j][i]);
            }
        }
        home=new JButton("HOME");
        home.setBounds(680,10,100,20);
        home.setOpaque(false);
        home.setBorder(null);
        home.setContentAreaFilled(false);
        home.setBorderPainted(false);
        home.setForeground(Color.white);
        home.setFocusable(false);
        home.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hridox");

            }
        });
        again=new JButton("RePlay");
        again.setBounds(630,300,150,70);
        again.setForeground(Color.black);
        again.setBorder(null);
        again.setBackground(Color.GREEN);
        again.setFocusable(false);
        again.setFocusPainted(false);
        again.setLayout(null);
        again.setFont(new Font("TimesRoman",Font.BOLD,20));
        again.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                replay();

            }
        });
        Font f3 = new Font("Arial",Font.BOLD,15);
        fourp = new JButton("Change Theme");
        fourp .setBackground(null);
        fourp .setBounds(630,350,150,70);
        fourp .setOpaque(false);
        fourp .setContentAreaFilled(false);
        fourp .setBorderPainted(false);
        fourp .setFocusable(false);
        fourp .setForeground(Color.decode("#3a624"));
        fourp .setFont(f3);
        fourp .setActionCommand("four");
        fourp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                mat[i][j]=0;
                chk[i][j]=0;
                b[i][j].setIcon(null);
            }
        }

        add(playername1);
        add(playername2);
        add(vs);
        add(info);
        add(home);
        add(again);
        add(fourp);
    }




    public static void replay()
    {
        flag=0;
        comp=0;
        info.setText("Chance of "+pname1);
        Enablemat();
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                mat[i][j]=0;
                chk[i][j]=0;
                b[i][j].setIcon(null);
            }
        }
    }
    public static Boolean isVal(int i,int j)
    {
        if(mat[i][j]==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static int wins()
    {
        if(mat[0][0]==mat[0][1] && mat[0][1]==mat[0][2] && mat[0][0]!=0)
        {
            chk[0][0]=1;
            chk[0][1]=1;
            chk[0][2]=1;
            if(mat[0][0]==1)
            {
                b[0][0].setIcon(new ImageIcon(redcross));
                b[0][1].setIcon(new ImageIcon(redcross));
                b[0][2].setIcon(new ImageIcon(redcross));
            }
            else
            {
                b[0][0].setIcon(new ImageIcon(redcircle));
                b[0][1].setIcon(new ImageIcon(redcircle));
                b[0][2].setIcon(new ImageIcon(redcircle));
            }
            return mat[0][0];
        }
        else if(mat[1][0]==mat[1][1] && mat[1][1]==mat[1][2] && mat[1][0]!=0)
        {
            chk[1][0]=1;
            chk[1][1]=1;
            chk[1][2]=1;
            if(mat[1][0]==1)
            {
                b[1][0].setIcon(new ImageIcon(redcross));
                b[1][1].setIcon(new ImageIcon(redcross));
                b[1][2].setIcon(new ImageIcon(redcross));
            }
            else
            {
                b[1][0].setIcon(new ImageIcon(redcircle));
                b[1][1].setIcon(new ImageIcon(redcircle));
                b[1][2].setIcon(new ImageIcon(redcircle));
            }
            return mat[1][0];
        }
        else if(mat[2][0]==mat[2][1] && mat[2][1]==mat[2][2] && mat[2][0]!=0)
        {
            chk[2][0]=1;
            chk[2][1]=1;
            chk[2][2]=1;
            if(mat[2][0]==1)
            {
                b[2][0].setIcon(new ImageIcon(redcross));
                b[2][1].setIcon(new ImageIcon(redcross));
                b[2][2].setIcon(new ImageIcon(redcross));
            }
            else
            {
                b[2][0].setIcon(new ImageIcon(redcircle));
                b[2][1].setIcon(new ImageIcon(redcircle));
                b[2][2].setIcon(new ImageIcon(redcircle));
            }
            return mat[2][0];
        }
        else if(mat[0][0]==mat[1][0] && mat[1][0]==mat[2][0] && mat[0][0]!=0)
        {
            chk[0][0]=1;
            chk[1][0]=1;
            chk[2][0]=1;
            if(mat[0][0]==1)
            {
                b[0][0].setIcon(new ImageIcon(redcross));
                b[1][0].setIcon(new ImageIcon(redcross));
                b[2][0].setIcon(new ImageIcon(redcross));
            }
            else
            {
                b[0][0].setIcon(new ImageIcon(redcircle));
                b[1][0].setIcon(new ImageIcon(redcircle));
                b[2][0].setIcon(new ImageIcon(redcircle));
            }
            return mat[0][0];
        }
        else if(mat[0][1]==mat[1][1] && mat[1][1]==mat[2][1] && mat[0][1]!=0)
        {
            chk[0][1]=1;
            chk[1][1]=1;
            chk[2][1]=1;
            if(mat[0][1]==1)
            {
                b[0][1].setIcon(new ImageIcon(redcross));
                b[1][1].setIcon(new ImageIcon(redcross));
                b[2][1].setIcon(new ImageIcon(redcross));
            }
            else
            {
                b[0][1].setIcon(new ImageIcon(redcircle));
                b[1][1].setIcon(new ImageIcon(redcircle));
                b[2][1].setIcon(new ImageIcon(redcircle));
            }
            return mat[0][1];
        }
        else if(mat[0][2]==mat[1][2] && mat[1][2]==mat[2][2] && mat[0][2]!=0)
        {
            chk[0][2]=1;
            chk[1][2]=1;
            chk[2][2]=1;
            if(mat[0][2]==1)
            {
                b[0][2].setIcon(new ImageIcon(redcross));
                b[1][2].setIcon(new ImageIcon(redcross));
                b[2][2].setIcon(new ImageIcon(redcross));
            }
            else
            {
                b[0][2].setIcon(new ImageIcon(redcircle));
                b[1][2].setIcon(new ImageIcon(redcircle));
                b[2][2].setIcon(new ImageIcon(redcircle));
            }
            return mat[0][2];
        }
        else if(mat[0][0]==mat[1][1] && mat[1][1]==mat[2][2] && mat[0][0]!=0)
        {
            chk[0][0]=1;
            chk[1][1]=1;
            chk[2][2]=1;
            if(mat[0][0]==1)
            {
                b[0][0].setIcon(new ImageIcon(redcross));
                b[1][1].setIcon(new ImageIcon(redcross));
                b[2][2].setIcon(new ImageIcon(redcross));
            }
            else
            {
                b[0][0].setIcon(new ImageIcon(redcircle));
                b[1][1].setIcon(new ImageIcon(redcircle));
                b[2][2].setIcon(new ImageIcon(redcircle));
            }
            return mat[0][0];
        }
        else if(mat[0][2]==mat[1][1] && mat[1][1]==mat[2][0] && mat[0][2]!=0)
        {
            chk[0][2]=1;
            chk[1][1]=1;
            chk[2][0]=1;
            if(mat[0][2]==1)
            {
                b[0][2].setIcon(new ImageIcon(redcross));
                b[1][1].setIcon(new ImageIcon(redcross));
                b[2][0].setIcon(new ImageIcon(redcross));
            }
            else
            {
                b[0][2].setIcon(new ImageIcon(redcircle));
                b[1][1].setIcon(new ImageIcon(redcircle));
                b[2][0].setIcon(new ImageIcon(redcircle));
            }
            return mat[0][2];
        }
        int flag1=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(mat[i][j]==0)
                {
                    flag1=1;
                    break;
                }
            }
        }
        if(flag1==0)
        {
            return -1;
        }
        return 0;
    }
    public static void Enablemat()
    {
        for(int k=0;k<3;k++)
        {
            for(int l=0;l<3;l++)
            {
                b[k][l].setEnabled(true);
            }
        }
    }
    public static void Disablemat()
    {
        for(int k=0;k<3;k++)
        {
            for(int l=0;l<3;l++)
            {
                if(chk[k][l]==0)
                {
                    b[k][l].setEnabled(false);
                }
            }
        }
    }
    public static void firsttake()
    {
        if(mat[1][1]==0)
        {	mat[1][1]= 2;b[1][1].setIcon(new ImageIcon(circle));   }
        else
        {	mat[0][0]=2; b[0][0].setIcon(new ImageIcon(circle));   }

    }
    public static void sectake()
    {
        int f=0;
        if(mat[1][1]==2)
        {
            if(mat[2][0]==1 && mat[1][0]==1)
            {
                mat[0][0]=2;
                f=1;
                b[0][0].setIcon(new ImageIcon(circle));
            }
            else if(mat[0][0]==1 && mat[1][0]==1)
            {
                mat[2][0]=2;
                f=1;
                b[2][0].setIcon(new ImageIcon(circle));
            }
            else if(mat[2][0]==1 && mat[0][0]==1)
            {
                mat[1][0]=2;
                f=1;
                b[1][0].setIcon(new ImageIcon(circle));
            }
            else if(mat[2][0]==1 && mat[2][1]==1)
            {
                mat[2][2]=2;
                f=1;
                b[2][2].setIcon(new ImageIcon(circle));
            }
            else if(mat[2][0]==1 && mat[2][2]==1)
            {
                mat[2][1]=2;
                f=1;
                b[2][1].setIcon(new ImageIcon(circle));
            }
            else if(mat[1][2]==1 && mat[2][2]==1)
            {
                mat[0][2]=2;
                f=1;
                b[0][2].setIcon(new ImageIcon(circle));
            }
            else if(mat[1][2]==1 && mat[0][2]==1)
            {
                mat[2][2]=2;
                f=1;
                b[2][2].setIcon(new ImageIcon(circle));
            }
            else if(mat[0][2]==1 && mat[2][2]==1)
            {
                mat[1][2]=2;
                f=1;
                b[1][2].setIcon(new ImageIcon(circle));
            }
            else if(mat[2][2]==1 && mat[2][1]==1)
            {
                mat[2][0]=2;
                f=1;
                b[2][0].setIcon(new ImageIcon(circle));
            }
            else if(mat[0][0]==1 && mat[0][1]==1)
            {
                mat[0][2]=2;
                f=1;
                b[0][2].setIcon(new ImageIcon(circle));
            }
            else if(mat[0][2]==1 && mat[0][1]==1)
            {
                mat[0][0]=2;
                f=1;
                b[0][0].setIcon(new ImageIcon(circle));
            }
            else if(mat[0][0]==1 && mat[0][2]==1)
            {
                mat[0][1]=2;
                f=1;
                b[0][1].setIcon(new ImageIcon(circle));
            }
            else
            {
                if(mat[0][0]==1 && mat[2][2]==1)
                {
                    mat[1][0]=2;
                    b[1][0].setIcon(new ImageIcon(circle));
                }
                else if(mat[0][2]==1 && mat[2][0]==1)
                {
                    mat[1][2]=2;
                    b[1][2].setIcon(new ImageIcon(circle));
                }
                else if(mat[0][1]==1 && mat[1][2]==1){ mat[0][2]=2;b[0][2].setIcon(new ImageIcon(circle)); }
                else if(mat[0][1]==1 && mat[2][2]==1){ mat[0][2]=2;b[0][2].setIcon(new ImageIcon(circle)); }
                else if(mat[0][1]==1 && mat[2][1]==1){ mat[2][0]=2;b[2][0].setIcon(new ImageIcon(circle)); }
                else if(mat[0][1]==1 && mat[2][0]==1){ mat[2][2]=2;b[2][2].setIcon(new ImageIcon(circle)); }
                else if(mat[0][1]==1 && mat[1][0]==1){ mat[0][0]=2;b[0][0].setIcon(new ImageIcon(circle)); }
                else if(mat[1][0]==1 && mat[0][1]==1){ mat[0][0]=2;b[0][0].setIcon(new ImageIcon(circle)); }
                else if(mat[1][0]==1 && mat[2][1]==1){ mat[2][0]=2;b[2][0].setIcon(new ImageIcon(circle)); }
                else if(mat[1][0]==1 && mat[1][2]==1){ mat[0][1]=2;b[0][1].setIcon(new ImageIcon(circle)); }
                else if(mat[1][0]==1 && mat[0][2]==1){ mat[2][2]=2;b[2][2].setIcon(new ImageIcon(circle)); }
                else if(mat[1][0]==1 && mat[2][2]==1){ mat[0][2]=2;b[0][2].setIcon(new ImageIcon(circle)); }
                else if(mat[0][0]==1 && mat[2][1]==1){ mat[1][2]=2;b[1][2].setIcon(new ImageIcon(circle)); }
                else if(mat[0][0]==1 && mat[1][2]==1){ mat[2][1]=2;b[2][1].setIcon(new ImageIcon(circle)); }
                else if(mat[2][0]==1 && mat[0][1]==1){ mat[1][2]=2;b[1][2].setIcon(new ImageIcon(circle)); }
                else if(mat[2][0]==1 && mat[1][2]==1){ mat[0][1]=2;b[0][1].setIcon(new ImageIcon(circle)); }
                else if(mat[2][2]==1 && mat[1][0]==1){ mat[0][1]=2;b[0][1].setIcon(new ImageIcon(circle)); }
                else if(mat[2][2]==1 && mat[0][1]==1){ mat[1][0]=2;b[1][0].setIcon(new ImageIcon(circle)); }
                else if(mat[0][2]==1 && mat[2][1]==1){ mat[1][0]=2;b[1][0].setIcon(new ImageIcon(circle)); }
                else if(mat[0][2]==1 && mat[1][0]==1){ mat[2][1]=2;b[2][1].setIcon(new ImageIcon(circle)); }
                else if(mat[2][1]==1 && mat[1][0]==1){ mat[2][0]=2;b[2][0].setIcon(new ImageIcon(circle)); }
                else if(mat[2][1]==1 && mat[0][0]==1){ mat[0][2]=2;b[0][2].setIcon(new ImageIcon(circle)); }
                else if(mat[2][1]==1 && mat[0][1]==1){ mat[1][0]=2;b[1][0].setIcon(new ImageIcon(circle)); }
                else if(mat[2][1]==1 && mat[0][2]==1){ mat[0][0]=2;b[0][0].setIcon(new ImageIcon(circle)); }
                else if(mat[2][1]==1 && mat[1][2]==1){ mat[2][2]=2;b[2][2].setIcon(new ImageIcon(circle)); }
                else if(mat[1][2]==1 && mat[2][1]==1){ mat[2][2]=2;b[2][2].setIcon(new ImageIcon(circle)); }
                else if(mat[1][2]==1 && mat[2][0]==1){ mat[0][0]=2;b[0][0].setIcon(new ImageIcon(circle)); }
                else if(mat[1][2]==1 && mat[1][0]==1){ mat[2][0]=2;b[2][0].setIcon(new ImageIcon(circle)); }
                else if(mat[1][2]==1 && mat[0][0]==1){ mat[2][0]=2;b[2][0].setIcon(new ImageIcon(circle)); }
                else if(mat[1][2]==1 && mat[0][1]==1){ mat[0][2]=2;b[0][2].setIcon(new ImageIcon(circle)); }
            }
        }
        if(mat[0][0]==2)
        {
            if(mat[1][1]==1 && mat[2][2]==1)
            {
                mat[0][2]=2;
                b[0][2].setIcon(new ImageIcon(circle));return;
            }
            if(mat[1][1]==1 && mat[0][1]==1)  { mat[2][1]=2;b[2][1].setIcon(new ImageIcon(circle));return; }
            if(mat[1][1]==1 && mat[0][2]==1)  { mat[2][0]=2;b[2][0].setIcon(new ImageIcon(circle));return; }
            if(mat[1][1]==1 && mat[1][2]==1)  { mat[1][0]=2;b[1][0].setIcon(new ImageIcon(circle)); return;}
            if(mat[1][1]==1 && mat[1][0]==1)  { mat[1][2]=2;b[1][2].setIcon(new ImageIcon(circle)); return;}
            if(mat[1][1]==1 && mat[2][0]==1)  { mat[0][2]=2;b[0][2].setIcon(new ImageIcon(circle));return; }
            if(mat[1][1]==1 && mat[2][1]==1)  { mat[0][1]=2;b[0][1].setIcon(new ImageIcon(circle));return; }
        }

    }
    public static void thrtake()
    { int l=0;
        int f=0;
        if(mat[0][0]==2 && mat[0][1]==2 && mat[0][2]!=1 && mat[0][2]!=2)  { mat[0][2]=2;f=1;b[0][2].setIcon(new ImageIcon(circle));return; }
        if(mat[1][0]==2 && mat[1][1]==2 && mat[1][2]!=1 && mat[1][2]!=2)  { mat[1][2]=2;f=1;b[1][2].setIcon(new ImageIcon(circle));return; }
        if(mat[2][0]==2 && mat[2][1]==2 && mat[2][2]!=1 && mat[2][2]!=2)  { mat[2][2]=2;f=1;b[2][2].setIcon(new ImageIcon(circle));return; }
        if(mat[0][2]==2 && mat[0][1]==2 && mat[0][0]!=1 && mat[0][0]!=2)  { mat[0][0]=2;f=1;b[0][0].setIcon(new ImageIcon(circle));return; }
        if(mat[1][1]==2 && mat[1][2]==2 && mat[1][0]!=1 && mat[1][0]!=2)  { mat[1][0]=2;f=1;b[1][0].setIcon(new ImageIcon(circle));return; }
        if(mat[2][1]==2 && mat[2][2]==2 && mat[2][0]!=1 && mat[2][0]!=2)  { mat[2][0]=2;f=1;b[2][0].setIcon(new ImageIcon(circle));return; }
        if(mat[0][0]==2 && mat[0][2]==2 && mat[0][1]!=1 && mat[0][1]!=2)  { mat[0][1]=2;f=1 ;b[0][1].setIcon(new ImageIcon(circle));return;}
        if(mat[1][0]==2 && mat[1][2]==2 && mat[1][1]!=1 && mat[1][1]!=2)  { mat[1][1]=2;f=1;b[1][1].setIcon(new ImageIcon(circle));return; }
        if(mat[2][0]==2 && mat[2][2]==2 && mat[2][1]!=1 && mat[2][1]!=2)  { mat[2][1]=2;f=1;b[2][1].setIcon(new ImageIcon(circle));return; }
        if(mat[0][0]==2 && mat[1][0]==2 && mat[2][0]!=1 && mat[2][0]!=2)  { mat[2][0]=2;f=1;b[2][0].setIcon(new ImageIcon(circle));return; }
        if(mat[0][1]==2 && mat[1][1]==2 && mat[2][1]!=1 && mat[2][1]!=2)  { mat[2][1]=2;f=1;b[2][1].setIcon(new ImageIcon(circle));return; }
        if(mat[0][2]==2 && mat[1][2]==2 && mat[2][2]!=1 && mat[2][2]!=2)  { mat[2][2]=2;f=1;b[2][2].setIcon(new ImageIcon(circle));return; }
        if(mat[2][0]==2 && mat[1][0]==2 && mat[0][0]!=1 && mat[0][0]!=2)  { mat[0][0]=2;f=1;b[0][0].setIcon(new ImageIcon(circle));return; }
        if(mat[1][1]==2 && mat[2][1]==2 && mat[0][1]!=1 && mat[0][1]!=2)  { mat[0][1]=2;f=1;b[0][1].setIcon(new ImageIcon(circle));return; }
        if(mat[2][2]==2 && mat[1][2]==2 && mat[0][2]!=1 && mat[0][2]!=2)  { mat[0][2]=2;f=1;b[0][2].setIcon(new ImageIcon(circle));return; }
        if(mat[0][0]==2 && mat[2][0]==2 && mat[1][0]!=1 && mat[1][0]!=2)  { mat[1][0]=2;f=1;b[1][0].setIcon(new ImageIcon(circle));return; }
        if(mat[0][1]==2 && mat[2][1]==2 && mat[1][1]!=1 && mat[1][1]!=2)  { mat[1][1]=2;f=1;b[1][1].setIcon(new ImageIcon(circle));return; }
        if(mat[0][2]==2 && mat[2][2]==2 && mat[1][2]!=1 && mat[1][2]!=2)  { mat[1][2]=2;f=1;b[1][2].setIcon(new ImageIcon(circle));return; }
        if(mat[0][0]==2 && mat[1][1]==2 && mat[2][2]!=1 && mat[2][2]!=2)  { mat[2][2]=2;f=1;b[2][2].setIcon(new ImageIcon(circle));return; }
        if(mat[1][1]==2 && mat[2][2]==2 && mat[0][0]!=1 && mat[0][0]!=2)  { mat[0][0]=2;f=1;b[0][0].setIcon(new ImageIcon(circle));return; }
        if(mat[0][0]==2 && mat[2][2]==2 && mat[1][1]!=1 && mat[1][1]!=2)  { mat[1][1]=2;f=1;b[1][1].setIcon(new ImageIcon(circle));return; }
        if(mat[2][0]==2 && mat[1][1]==2 && mat[0][2]!=1 && mat[0][2]!=2)  { mat[0][2]=2;f=1;b[0][2].setIcon(new ImageIcon(circle));return; }
        if(mat[0][2]==2 && mat[1][1]==2 && mat[2][0]!=1 && mat[2][0]!=2)  { mat[2][0]=2;f=1;b[2][0].setIcon(new ImageIcon(circle));return; }
        if(mat[2][0]==2 && mat[0][2]==2 && mat[1][1]!=1 && mat[1][1]!=2)  { mat[1][1]=2;f=1;b[1][1].setIcon(new ImageIcon(circle));return;}


        if(mat[0][0]==1 && mat[0][1]==1 && mat[0][2]!=2 && mat[0][2]!=1)  { mat[0][2]=2;l=1;b[0][2].setIcon(new ImageIcon(circle));return; }
        if(mat[1][0]==1 && mat[1][1]==1 && mat[1][2]!=2 && mat[1][2]!=1)  { mat[1][2]=2;l=1;b[1][2].setIcon(new ImageIcon(circle)); return;}
        if(mat[2][0]==1 && mat[2][1]==1 && mat[2][2]!=2 && mat[2][2]!=1)  { mat[2][2]=2;l=1;b[2][2].setIcon(new ImageIcon(circle)); return;}
        if(mat[0][2]==1 && mat[0][1]==1 && mat[0][0]!=2 && mat[0][0]!=1)  { mat[0][0]=2;l=1;b[0][0].setIcon(new ImageIcon(circle)); return;}
        if(mat[1][1]==1 && mat[1][2]==1 && mat[1][0]!=2 && mat[1][0]!=1)  { mat[1][0]=2;l=1;b[1][0].setIcon(new ImageIcon(circle)); return;}
        if(mat[2][1]==1 && mat[2][2]==1 && mat[2][0]!=2 && mat[2][0]!=1)  { mat[2][0]=2;l=1;b[2][0].setIcon(new ImageIcon(circle));return; }
        if(mat[0][0]==1 && mat[0][2]==1 && mat[0][1]!=2 && mat[0][1]!=1)  { mat[0][1]=2;l=1;b[0][1].setIcon(new ImageIcon(circle));return;}
        if(mat[1][0]==1 && mat[1][2]==1 && mat[1][1]==0)  { mat[1][1]=2;l=1;b[1][1].setIcon(new ImageIcon(circle)); return;}
        if(mat[2][0]==1 && mat[2][2]==1 && mat[2][1]==0)  { mat[2][1]=2;l=1;b[2][1].setIcon(new ImageIcon(circle));return;}
        if(mat[0][0]==1 && mat[1][0]==1 && mat[2][0]==0)  { mat[2][0]=2;l=1;b[2][0].setIcon(new ImageIcon(circle));return; }
        if(mat[0][1]==1 && mat[1][1]==1 && mat[2][1]==0)  { mat[2][1]=2;l=1;b[2][1].setIcon(new ImageIcon(circle));return; }
        if(mat[0][2]==1 && mat[1][2]==1 && mat[2][2]==0)  { mat[2][2]=2;l=1;b[2][2].setIcon(new ImageIcon(circle));return; }
        if(mat[2][0]==1 && mat[1][0]==1 && mat[0][0]==0)  { mat[0][0]=2;l=1;b[0][0].setIcon(new ImageIcon(circle)); return;}
        if(mat[1][1]==1 && mat[2][1]==1 && mat[0][1]==0)  { mat[0][1]=2;l=1;b[0][1].setIcon(new ImageIcon(circle));return; }
        if(mat[2][2]==1 && mat[1][2]==1 && mat[0][2]==0)  { mat[0][2]=2;l=1;b[0][2].setIcon(new ImageIcon(circle));return; }
        if(mat[0][0]==1 && mat[2][0]==1 && mat[1][0]==0)  { mat[1][0]=2;l=1;b[1][0].setIcon(new ImageIcon(circle));return; }
        if(mat[0][1]==1 && mat[2][1]==1 && mat[1][1]==0)  { mat[1][1]=2;l=1;b[1][1].setIcon(new ImageIcon(circle));return; }
        if(mat[0][2]==1 && mat[2][2]==1 && mat[1][2]==0)  { mat[1][2]=2;l=1;b[1][2].setIcon(new ImageIcon(circle));return; }
        if(mat[0][0]==1 && mat[1][1]==1 && mat[2][2]==0)  { mat[2][2]=2;l=1;b[2][2].setIcon(new ImageIcon(circle));return; }
        if(mat[1][1]==1 && mat[2][2]==1 && mat[0][0]==0)  { mat[0][0]=2;l=1;b[0][0].setIcon(new ImageIcon(circle)); return;}
        if(mat[0][0]==1 && mat[2][2]==1 && mat[1][1]==0)  { mat[1][1]=2;l=1;b[1][1].setIcon(new ImageIcon(circle)); return;}
        if(mat[2][0]==1 && mat[1][1]==1 && mat[0][2]==0)  { mat[0][2]=2;l=1;b[0][2].setIcon(new ImageIcon(circle)); return;}
        if(mat[0][2]==1 && mat[1][1]==1 && mat[2][0]==0)  { mat[2][0]=2;l=1;b[2][0].setIcon(new ImageIcon(circle));return; }
        if(mat[2][0]==1 && mat[0][2]==1 && mat[1][1]==0)  { mat[1][1]=2;l=1;b[1][1].setIcon(new ImageIcon(circle));return;}


        if(mat[0][0]==0) { mat[0][0]=2;b[0][0].setIcon(new ImageIcon(circle));return; }
        if(mat[0][1]==0) { mat[0][1]=2;b[0][1].setIcon(new ImageIcon(circle));return; }
        if(mat[0][2]==0) { mat[0][2]=2;b[0][2].setIcon(new ImageIcon(circle));return; }
        if(mat[1][0]==0) { mat[1][0]=2;b[1][0].setIcon(new ImageIcon(circle)); return;}
        if(mat[1][1]==0) { mat[1][1]=2;b[1][1].setIcon(new ImageIcon(circle));return; }
        if(mat[1][2]==0) { mat[1][2]=2;b[1][2].setIcon(new ImageIcon(circle));return; }
        if(mat[2][0]==0) { mat[2][0]=2;b[2][0].setIcon(new ImageIcon(circle));return; }
        if(mat[2][1]==0) { mat[2][1]=2;b[2][1].setIcon(new ImageIcon(circle));return; }
        if(mat[2][2]==0) { mat[2][2]=2;b[2][2].setIcon(new ImageIcon(circle));return; }

    }
    public static void fourtake()
    {
        if(mat[0][0]==2 && mat[0][1]==2 && mat[0][2]!=1 && mat[0][2]!=2)  { mat[0][2]=2;b[0][2].setIcon(new ImageIcon(circle));return; }
        if(mat[1][0]==2 && mat[1][1]==2 && mat[1][2]!=1 && mat[1][2]!=2)  { mat[1][2]=2;b[1][2].setIcon(new ImageIcon(circle));return; }
        if(mat[2][0]==2 && mat[2][1]==2 && mat[2][2]!=1 && mat[2][2]!=2)  { mat[2][2]=2;b[2][2].setIcon(new ImageIcon(circle));return; }
        if(mat[0][2]==2 && mat[0][1]==2 && mat[0][0]!=1 && mat[0][0]!=2)  { mat[0][0]=2;b[0][0].setIcon(new ImageIcon(circle));return; }
        if(mat[1][1]==2 && mat[1][2]==2 && mat[1][0]!=1 && mat[1][0]!=2)  { mat[1][0]=2;b[1][0].setIcon(new ImageIcon(circle));return; }
        if(mat[2][1]==2 && mat[2][2]==2 && mat[2][0]!=1 && mat[2][0]!=2)  { mat[2][0]=2;b[2][0].setIcon(new ImageIcon(circle));return; }
        if(mat[0][0]==2 && mat[0][2]==2 && mat[0][1]!=1 && mat[0][1]!=2)  { mat[0][1]=2;b[0][1].setIcon(new ImageIcon(circle));return;}
        if(mat[1][0]==2 && mat[1][2]==2 && mat[1][1]!=1 && mat[1][1]!=2)  { mat[1][1]=2;b[1][1].setIcon(new ImageIcon(circle));return; }
        if(mat[2][0]==2 && mat[2][2]==2 && mat[2][1]!=1 && mat[2][1]!=2)  { mat[2][1]=2;b[2][1].setIcon(new ImageIcon(circle));return; }
        if(mat[0][0]==2 && mat[1][0]==2 && mat[2][0]!=1 && mat[2][0]!=2)  { mat[2][0]=2;b[2][0].setIcon(new ImageIcon(circle));return; }
        if(mat[0][1]==2 && mat[1][1]==2 && mat[2][1]!=1 && mat[2][1]!=2)  { mat[2][1]=2;b[2][1].setIcon(new ImageIcon(circle));return; }
        if(mat[0][2]==2 && mat[1][2]==2 && mat[2][2]!=1 && mat[2][2]!=2)  { mat[2][2]=2;b[2][2].setIcon(new ImageIcon(circle));return; }
        if(mat[2][0]==2 && mat[1][0]==2 && mat[0][0]!=1 && mat[0][0]!=2)  { mat[0][0]=2;b[0][0].setIcon(new ImageIcon(circle));return; }
        if(mat[1][1]==2 && mat[2][1]==2 && mat[0][1]!=1 && mat[0][1]!=2)  { mat[0][1]=2;b[0][1].setIcon(new ImageIcon(circle));return; }
        if(mat[2][2]==2 && mat[1][2]==2 && mat[0][2]!=1 && mat[0][2]!=2)  { mat[0][2]=2;b[0][2].setIcon(new ImageIcon(circle));return; }
        if(mat[0][0]==2 && mat[2][0]==2 && mat[1][0]!=1 && mat[1][0]!=2)  { mat[1][0]=2;b[1][0].setIcon(new ImageIcon(circle));return; }
        if(mat[0][1]==2 && mat[2][1]==2 && mat[1][1]!=1 && mat[1][1]!=2)  { mat[1][1]=2;b[1][1].setIcon(new ImageIcon(circle));return; }
        if(mat[0][2]==2 && mat[2][2]==2 && mat[1][2]!=1 && mat[1][2]!=2)  { mat[1][2]=2;b[1][2].setIcon(new ImageIcon(circle));return; }
        if(mat[0][0]==2 && mat[1][1]==2 && mat[2][2]!=1 && mat[2][2]!=2)  { mat[2][2]=2;b[2][2].setIcon(new ImageIcon(circle));return; }
        if(mat[1][1]==2 && mat[2][2]==2 && mat[0][0]!=1 && mat[0][0]!=2)  { mat[0][0]=2;b[0][0].setIcon(new ImageIcon(circle));return; }
        if(mat[0][0]==2 && mat[2][2]==2 && mat[1][1]!=1 && mat[1][1]!=2)  { mat[1][1]=2;b[1][1].setIcon(new ImageIcon(circle));return; }
        if(mat[2][0]==2 && mat[1][1]==2 && mat[0][2]!=1 && mat[0][2]!=2)  { mat[0][2]=2;b[0][2].setIcon(new ImageIcon(circle));return; }
        if(mat[0][2]==2 && mat[1][1]==2 && mat[2][0]!=1 && mat[2][0]!=2)  { mat[2][0]=2;b[2][0].setIcon(new ImageIcon(circle));return; }
        if(mat[2][0]==2 && mat[0][2]==2 && mat[1][1]!=1 && mat[1][1]!=2)  { mat[1][1]=2;b[1][1].setIcon(new ImageIcon(circle));return;}


        if(mat[0][0]==1 && mat[0][1]==1 && mat[0][2]==0)  { mat[0][2]=2; b[0][2].setIcon(new ImageIcon(circle));return;}
        if(mat[1][0]==1 && mat[1][1]==1 && mat[1][2]==0)  { mat[1][2]=2;b[1][2].setIcon(new ImageIcon(circle));return; }
        if(mat[2][0]==1 && mat[2][1]==1 && mat[2][2]==0)  { mat[2][2]=2;b[2][2].setIcon(new ImageIcon(circle));return; }
        if(mat[0][2]==1 && mat[0][1]==1 && mat[0][0]==0)  { mat[0][0]=2;b[0][0].setIcon(new ImageIcon(circle));return; }
        if(mat[1][1]==1 && mat[1][2]==1 && mat[1][0]==0)  { mat[1][0]=2;b[1][0].setIcon(new ImageIcon(circle));return; }
        if(mat[2][1]==1 && mat[2][2]==1 && mat[2][0]==0)  { mat[2][0]=2;b[2][0].setIcon(new ImageIcon(circle));return; }
        if(mat[0][0]==1 && mat[0][2]==1 && mat[0][1]==0)  { mat[0][1]=2;b[0][1].setIcon(new ImageIcon(circle));return;}
        if(mat[1][0]==1 && mat[1][2]==1 && mat[1][1]==0)  { mat[1][1]=2;b[1][1].setIcon(new ImageIcon(circle));return; }
        if(mat[2][0]==1 && mat[2][2]==1 && mat[2][1]==0)  { mat[2][1]=2;b[2][1].setIcon(new ImageIcon(circle));return;}
        if(mat[0][0]==1 && mat[1][0]==1 && mat[2][0]==0)  { mat[2][0]=2;b[2][0].setIcon(new ImageIcon(circle));return; }
        if(mat[0][1]==1 && mat[1][1]==1 && mat[2][1]==0)  { mat[2][1]=2;b[2][1].setIcon(new ImageIcon(circle));return; }
        if(mat[0][2]==1 && mat[1][2]==1 && mat[2][2]==0)  { mat[2][2]=2;b[2][2].setIcon(new ImageIcon(circle));return; }
        if(mat[2][0]==1 && mat[1][0]==1 && mat[0][0]==0)  { mat[0][0]=2;b[0][0].setIcon(new ImageIcon(circle));return; }
        if(mat[1][1]==1 && mat[2][1]==1 && mat[0][1]==0)  { mat[0][1]=2;b[0][1].setIcon(new ImageIcon(circle));return; }
        if(mat[2][2]==1 && mat[1][2]==1 && mat[0][2]==0)  { mat[0][2]=2;b[0][2].setIcon(new ImageIcon(circle));return; }
        if(mat[0][0]==1 && mat[2][0]==1 && mat[1][0]==0)  { mat[1][0]=2;b[1][0].setIcon(new ImageIcon(circle));return; }
        if(mat[0][1]==1 && mat[2][1]==1 && mat[1][1]==0)  { mat[1][1]=2;b[1][1].setIcon(new ImageIcon(circle));return; }
        if(mat[0][2]==1 && mat[2][2]==1 && mat[1][2]==0)  { mat[1][2]=2;b[1][2].setIcon(new ImageIcon(circle));return; }
        if(mat[0][0]==1 && mat[1][1]==1 && mat[2][2]==0)  { mat[2][2]=2;b[2][2].setIcon(new ImageIcon(circle));return; }
        if(mat[1][1]==1 && mat[2][2]==1 && mat[0][0]==0)  { mat[0][0]=2;b[0][0].setIcon(new ImageIcon(circle));return; }
        if(mat[0][0]==1 && mat[2][2]==1 && mat[1][1]==0)  { mat[1][1]=2;b[1][1].setIcon(new ImageIcon(circle));return; }
        if(mat[2][0]==1 && mat[1][1]==1 && mat[0][2]==0)  { mat[0][2]=2;b[0][2].setIcon(new ImageIcon(circle));return; }
        if(mat[0][2]==1 && mat[1][1]==1 && mat[2][0]==0)  { mat[2][0]=2;b[2][0].setIcon(new ImageIcon(circle));return; }
        if(mat[2][0]==1 && mat[0][2]==1 && mat[1][1]==0)  { mat[1][1]=2;b[1][1].setIcon(new ImageIcon(circle));return;}


        if(mat[0][0]==0) { mat[0][0]=2;b[0][0].setIcon(new ImageIcon(circle));return; }
        if(mat[0][1]==0) { mat[0][1]=2;b[0][1].setIcon(new ImageIcon(circle));return; }
        if(mat[0][2]==0) { mat[0][2]=2;b[0][2].setIcon(new ImageIcon(circle));return; }
        if(mat[1][0]==0) { mat[1][0]=2;b[1][0].setIcon(new ImageIcon(circle));return; }
        if(mat[1][1]==0) { mat[1][1]=2;b[1][1].setIcon(new ImageIcon(circle));return; }
        if(mat[1][2]==0) { mat[1][2]=2;b[1][2].setIcon(new ImageIcon(circle));return; }
        if(mat[2][0]==0) { mat[2][0]=2;b[2][0].setIcon(new ImageIcon(circle));return; }
        if(mat[2][1]==0) { mat[2][1]=2;b[2][1].setIcon(new ImageIcon(circle));return; }
        if(mat[2][2]==0) { mat[2][2]=2;b[2][2].setIcon(new ImageIcon(circle));return;}

    }
    public static void chanceComp()
    {
        comp++;
        flag++;
        if(comp==1)
        {
            firsttake();
            info.setText("Chance of Player "+pname1);
        }
        else if(comp==2)
        {
            sectake();
            info.setText("Chance of Player "+pname1);
        }
        else if(comp==3)
        {
            thrtake();
            info.setText("Chance of Player "+pname1);
        }
        else if(comp==4)
        {
            fourtake();
            info.setText("Chance of Player "+pname1);
        }
    }
    public void actionPerformed(ActionEvent ae)
    {

        lab=ae.getActionCommand();

        if(count==2 && lab.substring(0,1).equals("b"))
        {
            flag++;
            int i=Integer.parseInt(lab.substring(1,2));
            int j=Integer.parseInt(lab.substring(2,3));
            if(flag%2==0)
            {
                if(isVal(i,j))
                {
                    mat[i][j]=2;
                    b[i][j].setIcon(new ImageIcon(circle));
                    info.setText("Chance of "+pname1);
                }
                else
                {
                    System.out.println("Invalid : "+i+"  "+j+"  Value : "+mat[i][j]);
                    flag--;
                }
            }
            else
            {
                if(isVal(i,j))
                {
                    mat[i][j]=1;
                    b[i][j].setIcon(new ImageIcon(cross));
                    info.setText("Chance of "+pname2);
                }
                else
                {
                    System.out.println("Invalid : "+i+"  "+j+"  Value : "+mat[i][j]);
                    flag--;
                }
            }
            int w=wins();
            if(w!=0 && w>0)
            {
                if(w==1)
                {
                    info.setText("Congratulations!   "+pname1+" WINS");
                }
                else
                {
                    info.setText("Congratulations!  "+pname2+" WINS");
                }
                Disablemat();
            }
            if(w<0)
            {
                info.setText("OOPS!  Match Draw !");
                Disablemat();
            }
        }
        else if(count==1 && lab.substring(0,1).equals("b"))
        {
            flag++;
            int i=Integer.parseInt(lab.substring(1,2));
            int j=Integer.parseInt(lab.substring(2,3));
            if(flag%2!=0)
            {
                if(isVal(i,j))
                {
                    mat[i][j]=1;
                    b[i][j].setIcon(new ImageIcon(cross));
                    info.setText("Chance of Computer");
                    chanceComp();
                }
                else
                {
                    System.out.println("Invalid : "+i+"  "+j+"  Value : "+mat[i][j]);
                    flag--;
                }
            }
            int w=wins();
            if(w!=0 && w>0)
            {
                if(w==1)
                {
                    info.setText("Congratulations!  "+pname1+" WINS");
                }
                else
                {
                    info.setText("Yeah! "+pname2+" WINS");
                }
                Disablemat();
            }
            if(w<0)
            {
                info.setText("OOPS!  Match Draw !");
                Disablemat();
            }
        }

    }
    public void mouseClicked(MouseEvent e)
    {


    }
    public void mouseEntered(MouseEvent e)
    {
        AbstractButton EventSource = (AbstractButton)e.getSource();
        EventSource.setBackground(Color.decode("#ffec9f"));//#00c290"));

    }
    public void mouseExited(MouseEvent e)
    {
        AbstractButton EventSource = (AbstractButton)e.getSource();
        EventSource.setBackground(Color.DARK_GRAY);

    }
    public void mousePressed(MouseEvent e)
    {

    }
    public void mouseReleased(MouseEvent e)
    {

    }

}
