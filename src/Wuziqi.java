import java.awt.*;
import java.awt.event.*;
class windialog extends Dialog implements ActionListener{
    private Label win;
    private Button ok=new Button("OK");
    private class windowcloser extends WindowAdapter{
        public void windowClosing(WindowEvent we){
            setVisible(false);
        }
    }
    public windialog(String f,Frame p){
        super(p,true);
        setBounds(750,300,800,800);
        ok.setSize(8,4);
        win=new Label(f);
        Panel p1=new Panel();
        p1.setLayout(new FlowLayout());
        p1.add(win);
        Panel p2=new Panel();
        p2.setLayout(new FlowLayout());
        p2.add(ok);
        setLayout(new BorderLayout());
        add("North",p1);
        add("Center",p2);
        ok.addActionListener(this);
        addWindowListener(new windowcloser());
        pack();
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==ok){
            setVisible(false);
        }
    }
}
class qicanvas extends Canvas{
    public int wstep=0,bstep=0;
    private Point p;
    private int x1,y1,x2,y2;
    public int flag;
    public int t=1;
    private int mat[][]=new int[390][390];
    public String hb;
    private Wuziqi f;
    private Point h1=new Point();private Point h2=new Point();
    private Point s1=new Point();private Point s2=new Point();
    private Point zx1=new Point();private Point zx2=new Point();
    private Point yx1=new Point();private Point yx2=new Point();
    private class mouse extends MouseAdapter{
        public void mousePressed(MouseEvent me){
            if(t==0){
                f.back.setEnabled(true);
                p=me.getPoint();
                for(x2=20;x2<p.x;x2+=30);
                x1=x2-30;
                for(y2=20;y2<p.y;y2+=30);
                y1=y2-30;
                if(mat[x1+20][y1+20]!=3)
                    return;
                Graphics page=getGraphics();
                if(flag==0){
                    page.setColor(Color.black);
                    mat[x1+20][y1+20]=0;  //0为黑
                    bstep++;
                }
                else{
                    page.setColor(Color.white);
                    mat[x1+20][y1+20]=1;  //1为白
                    wstep++;
                }
                f.bastep.setText("白方步数："+String.valueOf(wstep));
                f.hstep.setText("黑方步数："+String.valueOf(bstep));
                page.fillOval(x1+5, y1+5, 20, 20);
                if(check(flag,x1+20,y1+20)){
                    f.back.setEnabled(false);
                    if(flag==0)
                        hb="黑方胜";
                    else
                        hb="白方胜";
                    new windialog(hb,f);
                    page.setColor(Color.red);
                    if(h2.x-h1.x>=120)
                        page.drawLine(h1.x-5, h1.y-5, h2.x-5, h2.y-5);
                    if(s2.y-s1.y>=120)
                        page.drawLine(s1.x-5, s1.y-5, s2.x-5, s2.y-5);
                    if(yx2.x-yx1.x>=120)
                        page.drawLine(yx1.x-5, yx1.y-5, yx2.x-5, yx2.y-5);
                    if(zx2.y-zx1.y>=120)
                        page.drawLine(zx1.x-5, zx1.y-5, zx2.x-5, zx2.y-5);
                    t=1;
                }
                flag=flag^1;
            }
        }
    }
    public void back(){
        if(t==0){
            flag^=1;
            if(flag==0)
                bstep--;
            else
                wstep--;
            f.bastep.setText("白方步数："+String.valueOf(wstep));
            f.hstep.setText("黑方步数："+String.valueOf(bstep));
            Graphics page=getGraphics();
            page.setColor(new Color(145,142,32));
            page.fillRect(x1, y1, 30, 30);
            page.setColor(Color.black);
            page.drawLine(x1, y1+15, x1+30, y1+15);
            page.drawLine(x1+15, y1, x1+15, y1+30);
            mat[x1+20][y1+20]=3;
        }
    }
    public void init(){
        int i,j;
        wstep=bstep=0;
        for(i=0;i<390;i++){
            for(j=i;j<390;j++){
                mat[i][j]=mat[j][i]=3;
            }
        }
    }
    public boolean check(int wb,int x,int y)
    {
        int s=0;
        int sum;
        int xx=x;int yy=y;
        //纵向判断
        sum=0;
        while(yy-30>=0&&mat[xx][yy-30]==wb){
            sum++;
            yy-=30;
        }
        s1.x=xx;s1.y=yy;
        xx=x;yy=y;
        while(yy+30<390&&mat[xx][yy+30]==wb){
            sum++;
            yy+=30;
        }
        s2.x=xx;s2.y=yy;
        xx=x;yy=y;
        sum+=1;
        if(sum>=5)
            s++;
        //横向判断
        sum=0;
        while(xx-30>=0&&mat[xx-30][yy]==wb){
            sum++;
            xx-=30;
        }
        h1.x=xx;h1.y=yy;
        xx=x;yy=y;
        xx=x;
        while(xx+30<390&&mat[xx+30][yy]==wb){
            sum++;
            xx+=30;
        }
        h2.x=xx;h2.y=yy;
        xx=x;yy=y;
        sum+=1;
        if(sum>=5)
            s++;
        //"\"斜向判断
        sum=0;
        while(xx-30>=0&&yy-30>=0&&mat[xx-30][yy-30]==wb){
            sum++;
            xx-=30;
            yy-=30;
        }
        yx1.x=xx;yx1.y=yy;
        xx=x;yy=y;
        while(xx+30<390&&yy+30<390&&mat[xx+30][yy+30]==wb){
            sum++;
            xx+=30;
            yy+=30;
        }
        yx2.x=xx;yx2.y=yy;
        xx=x;yy=y;
        sum+=1;
        if(sum>=5)
            s++;
        //"/"斜向判断
        sum=0;
        while(xx+30<390&&yy-30>=0&&mat[xx+30][yy-30]==wb){
            sum++;
            xx+=30;
            yy-=30;
        }
        zx1.x=xx;zx1.y=yy;
        xx=x;yy=y;
        while(xx-30>=0&&yy+30<390&&mat[xx-30][yy+30]==wb){
            sum++;
            xx-=30;
            yy+=30;
        }
        zx2.x=xx;zx2.y=yy;
        xx=x;yy=y;
        sum++;
        if(sum>=5)
            s++;
        if(s>0)
            return true;
        else
            return false;
    }
    public void paint(Graphics g)
    {
        int i;
        for(i=5;i<=365;i+=30){
            g.drawLine(5, i, 365, i);
            g.drawLine(i, 5, i, 365);
        }

    }
    public qicanvas(Wuziqi p){
        super();
        setBackground(new Color(145,142,32));
        //setBackground(Color.white);
        f=p;
        init();
        addMouseListener(new mouse());
        setSize(365,365);
    }
}
public class Wuziqi extends Frame implements ActionListener{
    private qicanvas q;
    public Label hstep=new Label("黑方步数：0");
    public Label bastep=new Label("白方步数：0");
    private Button restart=new Button("开局");
    private Button heifang=new Button("黑方");
    private Button baifang=new Button("白方");
    public Button back=new Button("悔棋");
    private Label choose=new Label("请选择先下方：");
    private class windowcloser extends WindowAdapter{
        public void windowClosing(WindowEvent we){
            System.exit(0);
        }
    }
    public Wuziqi(){
        super("五子棋");
        setBounds(380,150,800,800);
        //setBackground(new Color(145,142,32));
        setBackground(Color.GREEN);
        addWindowListener(new windowcloser());
        q=new qicanvas(this);
        Panel p1=new Panel();
        p1.add(restart);
        Panel p2=new Panel();p2.setLayout(new FlowLayout());
        p2.add(choose);p2.add(heifang);p2.add(baifang);
        Panel p3=new Panel();p3.setLayout(new GridLayout(2,1));
        p3.add(hstep);p3.add(bastep);
        Panel p4=new Panel();p4.setLayout(new GridLayout(2,1));
        p4.add(p1);p4.add(p2);
        Panel p=new Panel();p.setLayout(new GridLayout(2,1));
        p.add(p4);p.add(p3);
        Panel pp=new Panel();pp.add(back);
        Panel pz=new Panel();pz.setLayout(new BorderLayout());
        pz.add("Center",p);pz.add("South",pp);
        setLayout(new BorderLayout());
        add("Center",q);
        add("East",pz);
        restart.addActionListener(this);
        heifang.addActionListener(this);
        baifang.addActionListener(this);
        back.addActionListener(this);
        back.setEnabled(false);
        pack();
        setVisible(true);
        setResizable(false);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==restart){
            q.repaint();
            q.init();
            q.t=1;
            heifang.setEnabled(true);
            baifang.setEnabled(true);
            back.setEnabled(false);
            bastep.setText("白方步数：0");
            hstep.setText("黑方步数：0");
        }
        if(ae.getSource()==heifang){
            q.t=0;
            q.flag=0;
            baifang.setEnabled(false);
            heifang.setEnabled(false);
        }
        if(ae.getSource()==baifang){
            q.t=0;
            q.flag=1;
            heifang.setEnabled(false);
            baifang.setEnabled(false);
        }
        if(ae.getSource()==back){
            q.back();
            back.setEnabled(false);
        }
    }
    public static void main(String args[]){
        Wuziqi w=new Wuziqi();
    }
}
