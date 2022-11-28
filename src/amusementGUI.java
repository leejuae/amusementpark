import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;

public class amusementGUI extends JFrame {

    public static int MAX = 11;
    public static Attraction[] a_info = new Attraction[MAX];
    public static Route[] r_info = new Route[MAX];
    public static double[][] edge = new double[MAX][MAX];
    public static int[] order = new int[MAX];
    public static int cnt = 0;
    Main algorithm;
    public static int num = 1;
    public static int buttonCount = 0; //���씠湲곌뎄 諛묒뿉 踰꾪듉留뚮뱾�뼱�꽌 �겢由��븯硫댁꽌 �떎�쓬 諛⑸Ц ���씠湲곌뎄 李� �쓣�슱 �븣 �궗�슜�븷寃�!!
    public static int[][] saveRoute = new int[MAX][MAX];
    //--> gui�떎�뻾�븯硫댁꽌 �뒪���듃 踰꾪듉 �늻瑜닿퀬 吏��룄 �쓣�슦�뒗�룞�븞 �븿�닔媛� �쟾遺� �떎�뻾�릺�뼱踰꾨┝!! 洹몃옒�꽌 �븿�닔 �떎�뻾�븯�뒗�룞�븞 �룎由щ뒗 �떆媛꾨퀎 猷⑦듃瑜� �뵲濡� ���옣�빐�꽌 �굹以묒뿉 異쒕젰�븷�븣 �궗�슜�븷 寃�!



    Font f1 = new Font("SanSerif", Font.BOLD, 20);
    Font f2 = new Font("SanSerif", Font.PLAIN, 40);
    Font f3 = new Font("SanSerif", Font.ITALIC | Font.BOLD, 70);
    Font f4 = new Font("SanSerif", Font.BOLD, 30);
    Font f5 = new Font("SanSerif", Font.ITALIC | Font.BOLD, 18);
    Font f6 = new Font("SanSerif", Font.BOLD, 16);

    amusementGUI() {

        setBounds(100, 100, 350, 480);
        setLayout(null);
        setTitle("Amusement Park");
        ImageIcon background = new ImageIcon("image/background.jpg");
        ImageIcon logo = new ImageIcon("image/logo.png");

        JPanel pn1 = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(background.getImage(), 0, 0, 350, 480, null);
            }
        };
        pn1.setBounds(0, 0, 350, 480);

        JPanel pn2 = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(logo.getImage(), 0, 0, 110, 110, null);
            }
        };
        pn2.setBounds(120, 30, 110, 110);

        JButton button = new JButton("Let's Go!");
        button.setFont(f1);
        button.setBounds(110, 380, 125, 40);
        button.setFocusPainted(false); //Button �닃���쓣 �븣 �뀒�몢由� �븞 �깮湲곌쾶
        button.setBackground(Color.pink);
        add(button);

        JLabel lb1 = new JLabel("welcome to");
        lb1.setFont(f2);
        lb1.setBounds(65, 150, 280, 60);
        add(lb1);

        JLabel lb2 = new JLabel("RANNO");
        lb2.setFont(f3);
        lb2.setForeground(Color.red);
        lb2.setBounds(15, 205, 280, 70);
        add(lb2);

        JLabel lb3 = new JLabel("WORLD");
        lb3.setFont(f3);
        lb3.setForeground(Color.red);
        lb3.setBounds(50, 280, 280, 70);
        add(lb3);

        add(pn2); add(pn1);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * button �늻瑜대㈃, �솕硫� �쟾�솚
         */
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false); //李� �븞 蹂댁씠寃� �븯湲�
                new information();
            }

        });
    }

    /**
     * �젙蹂� �엯�젰
     */
    public class information extends JFrame {
        information() {

            setBounds(100, 100, 350, 480);
            setLayout(null);
            setTitle("Information");
            ImageIcon bg = new ImageIcon("image/bg.jpg");

            JPanel pn1 = new JPanel();
            pn1.setBounds(0, 0, 350, 480);
            pn1.setBackground(Color.white);

            JPanel pn2 = new JPanel() {
                public void paintComponent(Graphics g) {
                    g.drawImage(bg.getImage(), 0, 0, 250, 250, null);
                }
            };
            pn2.setBounds(50, 90, 250, 250);

            JLabel zone = new JLabel("Zone");
            zone.setBounds(135, 25, 100, 30);
            zone.setFont(f4);
            zone.setForeground(Color.pink);
            add(zone);

            JLabel type1 = new JLabel("매직랜드");
            type1.setBounds(70, 80, 100, 30);
            type1.setFont(f1);
            add(type1);

            JLabel m1 = new JLabel("Gyro drop");
            m1.setBounds(170, 80, 100, 30);
            m1.setFont(f5);
            add(m1);

            JLabel m2 = new JLabel("Swing ride");
            m2.setBounds(170, 105, 100, 30);
            m2.setFont(f5);
            add(m2);

            JLabel m3 = new JLabel("Ghost house");
            m3.setBounds(170, 130, 120, 30);
            m3.setFont(f5);
            add(m3);

            JLabel type2 = new JLabel("어드벤쳐");
            type2.setBounds(70, 160, 100, 30);
            type2.setFont(f1);
            add(type2);

            JLabel m4 = new JLabel("Roller coaster");
            m4.setBounds(170, 163, 120, 30);
            m4.setFont(f5);
            add(m4);

            JLabel m5 = new JLabel("Bumper car");
            m5.setBounds(170, 185, 120, 30);
            m5.setFont(f5);
            add(m5);

            JLabel m6 = new JLabel("Log flume");
            m6.setBounds(170, 205, 120, 30);
            m6.setFont(f5);
            add(m6);

            JLabel m7 = new JLabel("Teacups");
            m7.setBounds(170, 228, 120, 30);
            m7.setFont(f5);
            add(m7);

            JLabel m8 = new JLabel("Hurricane");
            m8.setBounds(170, 250, 120, 30);
            m8.setFont(f5);
            add(m8);

            JLabel type3 = new JLabel("주토피아");
            type3.setBounds(70, 280, 100, 30);
            type3.setFont(f1);
            add(type3);

            JLabel m9 = new JLabel("Pirate ship");
            m9.setBounds(170, 283, 120, 30);
            m9.setFont(f5);
            add(m9);

            JLabel m10 = new JLabel("Amazon express");
            m10.setBounds(170, 305, 150, 30);
            m10.setFont(f5);
            add(m10);

            /**
             * �늻瑜대㈃ �븣怨좊━利� �떎�뻾
             */
            JButton b2 = new JButton("놀이기구 타러가기");
            b2.setFocusPainted(false);
            b2.setBounds(65, 350, 220, 45);
            b2.setBackground(Color.pink);
            b2.setFont(f1);
            add(b2);

            add(pn2); add(pn1);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            /**
             * �븣怨좊━利� �떎�뻾
             */
            b2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setVisible(false); //李� �븞 蹂댁씠寃� �븯湲�
                    algorithm = new Main();
                    //num = 1;
                    new route();//�깙�듅 �닚�꽌!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                }
            });
        }

        /**
         * �븣怨좊━利� �떎�뻾
         */
        public class route extends JFrame {
            route() {

                setBounds(100, 100, 600, 600);
                setLayout(null);
                setTitle("Route");
                //���씠湲곌뎄 �쐞移� 蹂댁뿬二쇨린...? random�씠�씪 �씠�긽�빐�꽌 媛� 醫뚰몴�뿉 5�뵫 怨깊븿,,
                String[] n = new String[MAX];
                JLabel[] a = new JLabel[MAX];
                JLabel[] ord = new JLabel[MAX]; //踰꾪듉 �븘�옒�뿉 �닚�꽌 踰꾪듉 蹂댁씠湲�!

                for (int i = 0; i < MAX; i++) {

                    n[i] = a_info[saveRoute[buttonCount][i]].getName();
                    a[i] = new JLabel(n[i]);
                    a[i].setBounds(a_info[saveRoute[buttonCount][i]].getX() * 5, a_info[saveRoute[buttonCount][i]].getY() * 5, 150, 50);
                    a[i].setFont(f5);

                    JButton restartButton = new JButton("START HERE!!");

                    if(buttonCount == i){    //留뚯빟 �쁽�옱 諛⑸Ц以묒씤 �끂�뱶�씪寃쎌슦!
                        restartButton.setFocusPainted(false);
                        restartButton.setBounds(a_info[saveRoute[buttonCount][i]].getX() * 5, a_info[saveRoute[buttonCount][i]].getY() * 5 + 40, 170, 20);
                        restartButton.setBackground(Color.pink);
                        restartButton.setFont(f6);

                        add(a[i]); add(restartButton);
                    }
                    else {
                        if(buttonCount > i){
                            ord[i] = new JLabel("<html><body><center><br><b>VISITED</center></body></html>");
                        }
                        else{
                            ord[i] = new JLabel("<html><body><center><br>" + i + "</center></body></html>");
                        }
                        ord[i].setBounds(a_info[saveRoute[buttonCount][i]].getX() * 5 + 30, a_info[saveRoute[buttonCount][i]].getY() * 5 + 10, 70, 50);
                        ord[i].setFont(f6);

                        add(a[i]); add(ord[i]);
                    }

                    restartButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            setVisible(false); //李� �븞 蹂댁씠寃� �븯湲�
                            buttonCount++;
                            new route();
                        }
                    });
                }

                setVisible(true);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                if(buttonCount == 10){
                    setVisible(false);
                    new endMessage();
                }

            }

        }

    }

    public class endMessage extends JFrame{

        endMessage(){
            setBounds(100, 100, 370, 220);
            setLayout(null);
            
            JPanel pn = new JPanel();
            pn.setBounds(30, 30, 295, 125);
            pn.setBackground(Color.pink);
            
            JLabel lb2 = new JLabel("See you");
            lb2.setFont(f4);
            lb2.setBounds(40, 47, 290, 40);
            add(lb2);
            
            JLabel lb3 = new JLabel("next Adventure ^o^");
            lb3.setFont(f4);
            lb3.setBounds(40, 92, 290, 40);
            add(lb3);
            /*JLabel lb2 = new JLabel("<html><body><center>See you next adventure~!</center></body></html>");
            lb2.setFont(f6);
            lb2.setForeground(Color.pink);
            lb2.setBounds(15, 205, 280, 70);
            add(lb2);*/
			
            add(pn);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    public class Main {

        Main() {

            order[0] = 0;
            //Initialize
            for(int i = 0; i < MAX; i++) {
                a_info[i] = new Attraction();
                r_info[i] = new Route();
                for (int j = 0; j < MAX; j++) {
                    edge[i][j] = 0.0;
                }
            }

            a_info[0].setName("(Entrance)");
            a_info[1].setName("Roller coaster");
            a_info[2].setName("Bumper car");
            a_info[3].setName("Swing ride");
            a_info[4].setName("Gyro drop");
            a_info[5].setName("Log flume");
            a_info[6].setName("Pirate ship");
            a_info[7].setName("Ghost house");
            a_info[8].setName("Hurricane");
            a_info[9].setName("Amazon express");
            a_info[10].setName("Teacups");


            do {
		            /*Scanner scan = new Scanner(System.in);
		            num = scan.nextInt();*/

                if (num == 1 && cnt <= 10) {
                    calEdge();
                    dijkstra(order[cnt]);	//cnt踰덉㎏ ���씠湲곌뎄瑜� �떆�옉�쑝濡� �떎�떆 嫄곕━怨꾩궛�빐 �떎�쓬 ���씠湲곌뎄 �젙�븿.
                    printAttractionRoute();
                    a_info[order[cnt]].setVisit(1);
                    cnt++;
                }
                //0�엯�젰�븯硫� 洹몃깷 醫낅즺
                else if (num == 0 && cnt <= 10) {
                    System.out.print("Stop riding. Exit");
                    break;
                }
                //cnt==11 �릺硫� ���씠湲곌뎄 �떎 �깂嫄몃줈 媛꾩＜�븯怨� 醫낅즺
                else if (cnt > 10) {
                    System.out.print("Visited all the rides!!");
                    break;
                }
                else {
                    System.out.print("Error");
                }
            } while (true);
        }
    }

    //�옖�뜡�븿�닔
    public int rand(int k){
        Random Rand = new Random();
        int iValue = Rand.nextInt(k);   //0 <- iValue < k

        return iValue;
    }


    //�궃�닔 �깮�꽦
    public void calEdge(){
        if (cnt == 0){
            for(int i = 0; i < MAX; i++){
                a_info[i].setX(rand(100));  //0-100源뚯��쓽 踰붿쐞�뿉�꽌 臾댁옉�쐞濡� 媛� �븯�굹 諛쏆븘�샂.
                a_info[i].setY(rand(100));  //�룞�씪
                a_info[i].setWaiting(rand(30)); //���씠湲곌뎄�쓽 �씤湲곕룄 0-30
                a_info[i].setVisit(0);  //�븘吏� �븘臾닿쾬�룄 �븞�깘
            }

            //嫄곕━媛믪� 蹂��븯吏� �븡湲� �븣臾몄뿉 �븳踰덈쭔 怨꾩궛�빐以�!! waiting媛믩쭔 媛�以묒튂濡� �꽕�젙�빐 min 媛� 鍮꾧탳�뿉 �씠�슜留� �븿.
            for(int i = 0; i < MAX; i++){
                for(int j = 0; j < MAX; j++){
                    if(i == j){
                        edge[i][j] = 0; //留뚯빟 i�� j媛� �룞�씪�븯�떎硫�(a���씠湲곌뎄�뿉�꽌 a���씠湲곌뎄濡� 媛��뒗 媛믪� 0) 0�쑝濡� 珥덇린�솕
                    }

                    //i吏��젏怨� j吏��젏�쓽 嫄곕━怨꾩궛
                    else{
                        edge[i][j] = Math.sqrt(Math.pow(a_info[i].getX() - a_info[j].getX(), 2) + Math.pow(a_info[i].getY() - a_info[j].getY(), 2));
                    }
                }
            }
        }

        else if(cnt >= 1){
            for(int i = 0; i < MAX; i++){
                //諛⑸Ц�븯吏� �븡�븯�떎硫� �씤湲곕룄瑜� 蹂�寃쏀빐以�
                if(a_info[i].getVisit() == 0){
                    a_info[i].setWaiting(rand(30));
                }
            }
        }

        else{
            System.out.println("calEdge error");
        }
    }

    public int mincost(){
        //鍮꾧탳瑜� �쐞�빐 媛��옣 �옉�� 媛� 留뚮뱾�뼱以�
        double min = Integer.MAX_VALUE;
        int min_index = 0;

        //�븘吏� 諛⑸Ц�븯吏� �븡�� �끂�뱶�씠怨�, 嫄곕━媛� �젣�씪 媛�源뚯슫 ���씠湲곌뎄�씪硫� min_index媛믪쓣 洹� ���씠湲곌뎄�쓽 媛믪쑝濡� 諛붽퓭以�.
        for (int v = 0; v < MAX; v++) {
            if (r_info[v].isPossible() == false && (r_info[v].getDistance() + a_info[v].getWaiting() <= min)) {
                min = r_info[v].getDistance() + a_info[v].getWaiting();
                min_index = v;
            }
        }

        //媛��옣 媛�源뚯슫 ���씠湲곌뎄�쓽 媛� 由ы꽩
        return min_index;
    }

    public void printAttractionRoute() {

        System.out.println("<" + cnt + "th visit>");
        for (int i = cnt; i < MAX; i++) {
            System.out.println("-> " + a_info[order[i]].getName() + "[" + order[i] + "] ");
            //System.out.println(saveRoute[cnt][i]);
        }

        for(int i = 0 ; i < MAX; i++)
            saveRoute[cnt][i] = order[i];

        System.out.print("\n\n");


    }

    public void dijkstra(int src)
    {
        //泥섏쓬�쓽 嫄곕━媛� 臾댄븳�쑝濡� 珥덇린�솕 && �븘吏� �뼱�뼡 ���씠湲곌뎄�뿉�룄 諛⑸Ц�쓣 �븯吏� �븡�븯�쑝�땲 0�쑝濡� 珥덇린�솕.
        for (int i = 0; i < MAX; i++) {
            r_info[i].setDistance(Integer.MAX_VALUE);
            if (a_info[i].getVisit() == 1)
                r_info[i].setPossible(true);
            else if (a_info[i].getVisit() == 0)
                r_info[i].setPossible(false);
        }

        //異쒕컻吏��뿉�꽌 異쒕컻吏�濡� 媛��뒗 嫄곕━�뒗 0�씠誘�濡� 0�쑝濡� 珥덇린�솕
        r_info[src].setDistance(0.0);

        //媛��옣 吏㏃� 嫄곕━ 李얘린
        for (int count = cnt; count < MAX; count++) {	//�뿬湲� count�옉 �쟾�뿭蹂��닔 cnt �떎瑜멸굅 瑗� �쑀�쓽�븯湲�!
            //���씠湲곌뎄 吏묓빀�뿉�꽌 媛��옣 �옉�� 嫄곕━瑜� 李얠쓬.
            //泥ル쾲吏� 諛섎났�뿉�꽌 u�뒗 異쒕컻吏��쓽 �쓽誘몃�� 吏��떂
            //-> 異쒕컻吏��뿉�꽌 異쒕컻吏�濡� 媛��뒗 嫄곕━瑜� 0�쑝濡� 珥덇린�솕�뻽湲� �븣臾몄뿉 泥ル쾲吏� 諛섎났�뿉�꽌 min媛믪� �떦�뿰�븯寃� 0�엫.
            int u = mincost();

            r_info[u].setPossible(true);	//諛⑸Ц�뻽�쑝誘�濡� 媛믪쓣 true濡� 諛붽퓭以�.
            order[count] = u;	//諛⑸Ц�븳 ���씠湲곌뎄�뱾�쓣 ���옣.

            //諛⑸Ц�븳 ���씠湲곌뎄媛� �깮寃쇱쑝�땲 嫄곕━媛믪쓣 �닔�젙�빐以�
            for (int v = 0; v < MAX; v++)
                //�븘吏� 諛⑸Ц�쓣 �븞�빐�꽌 possible媛믪씠 false�씪 �븣留� �닔�젙�빐以�!
                // �삉�븳 u�뿉�꽌 v源뚯� 媛��뒗 媛믪씠 議댁옱�븯怨�
                // u瑜� �넻�빐�꽌 異쒕컻吏��뿉�꽌 v濡� 媛��뒗 湲몄씠 routeInfo[v]�쓽 嫄곕━媛믩낫�떎 �옉�쓣 �븣留� �닔�젙
                if (!r_info[v].isPossible() && edge[u][v] != 0.0
                        && (r_info[u].getDistance() != Integer.MAX_VALUE)
                        && (r_info[u].getDistance() + edge[u][v] < r_info[v].getDistance()))
                    r_info[v].setDistance(r_info[u].getDistance() + edge[u][v]);
        }
    }



    public static void main(String[] args) {
        new amusementGUI();
    }

}
