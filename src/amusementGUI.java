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
    public static int buttonCount = 0; //Make a button under the ride and click it and use it to open the window for the next visit!!
    public static int[][] saveRoute = new int[MAX][MAX];
    //--> While running the gui, all functions were executed while pressing the start button and floating the map!! So, save the time-by-time route that you turn while executing the function and use it to print it out later!



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
        button.setFocusPainted(false); //If you press Button, make sure that it doesn't have a border
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
         * Press button, switch screen
         */
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false); //To hide the window
                new information();
            }

        });
    }

    /**
     * Enter information
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
             * Press to run algorithm
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
             * Run Algorithms
             */
            b2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setVisible(false); //To hide the window
                    algorithm = new Main();
                    //num = 1;
                    new route();//Boarding order
                }
            });
        }

        /**
         * Run Algorithms
         */
        public class route extends JFrame {
            route() {

                setBounds(100, 100, 600, 600);
                setLayout(null);
                setTitle("Route");
                //Showing the location of the ride.It's weird because it's random, so multiply each coordinate by 5
                String[] n = new String[MAX];
                JLabel[] a = new JLabel[MAX];
                JLabel[] ord = new JLabel[MAX]; //Show order buttons under buttons!

                for (int i = 0; i < MAX; i++) {

                    n[i] = a_info[saveRoute[buttonCount][i]].getName();
                    a[i] = new JLabel(n[i]);
                    a[i].setBounds(a_info[saveRoute[buttonCount][i]].getX() * 5, a_info[saveRoute[buttonCount][i]].getY() * 5, 130, 50);
                    a[i].setFont(f6);

                    JButton restartButton = new JButton("!START HERE!");

                    if(buttonCount == i){    //If the node is currently visiting!
                        restartButton.setFocusPainted(false);
                        restartButton.setBounds(a_info[saveRoute[buttonCount][i]].getX() * 5, a_info[saveRoute[buttonCount][i]].getY() * 5 + 40, 150, 20);
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
                            setVisible(false); //To hide the window
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
            setBounds(100, 100, 350, 480);
            setLayout(null);

            JLabel lb2 = new JLabel("<html><body><center>See you next adventure~!</center></body></html>");
            lb2.setFont(f6);
            lb2.setForeground(Color.pink);
            lb2.setBounds(15, 205, 280, 70);
            add(lb2);

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
                    dijkstra(order[cnt]);   //Starting with the CNT ride, the distance is calculated again and the next ride is decided.
                    printAttractionRoute();
                    a_info[order[cnt]].setVisit(1);
                    cnt++;
                }
                //If you type 0, it's over
                else if (num == 0 && cnt <= 10) {
                    System.out.print("Stop riding. Exit");
                    break;
                }
                //When CNT == 11, it's considered that we're all on the ride
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

    //random function
    public int rand(int k){
        Random Rand = new Random();
        int iValue = Rand.nextInt(k);   //0 <- iValue < k

        return iValue;
    }


    //Random number generation
    public void calEdge(){
        if (cnt == 0){
            for(int i = 0; i < MAX; i++){
                a_info[i].setX(rand(100));  //Received one value at random in the range from 0 to 100.
                a_info[i].setY(rand(100));  //same as above
                a_info[i].setWaiting(rand(30)); //The popularity of rides is 0-30
                a_info[i].setVisit(0);  //Not yet on the ride
            }

            //The distance value does not change, so please calculate it just once! Only the waiting value is set as a weight and used to compare min values.
            for(int i = 0; i < MAX; i++){
                for(int j = 0; j < MAX; j++){
                    if(i == j){
                        edge[i][j] = 0; //If i and j are the same (the value from ride a to ride a is 0), initialize to zero
                    }

                    //Calculation of the distance between point i and point j
                    else{
                        edge[i][j] = Math.sqrt(Math.pow(a_info[i].getX() - a_info[j].getX(), 2) + Math.pow(a_info[i].getY() - a_info[j].getY(), 2));
                    }
                }
            }
        }

        else if(cnt >= 1){
            for(int i = 0; i < MAX; i++){
                //Change popularity if not visited
                if(a_info[i].getVisit() == 0){
                    a_info[i].setWaiting(rand(30));
                }
            }
        }

        else{
            System.out.println("calEdge Error");
        }
    }

    public int mincost(){
        //Creates the smallest value for comparison
        double min = Integer.MAX_VALUE;
        int min_index = 0;

        //If it is a node that has not yet been visited, and the ride is the closest to the distance, it changes the min_index value to the ride's value.
        for (int v = 0; v < MAX; v++) {
            if (r_info[v].isPossible() == false && (r_info[v].getDistance() + a_info[v].getWaiting() <= min)) {
                min = r_info[v].getDistance() + a_info[v].getWaiting();
                min_index = v;
            }
        }

        //Return the value of the nearest ride
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
        //Initialize the initial distance value to infinity && reset to zero since you haven't visited any rides yet.
        for (int i = 0; i < MAX; i++) {
            r_info[i].setDistance(Integer.MAX_VALUE);
            if (a_info[i].getVisit() == 1)
                r_info[i].setPossible(true);
            else if (a_info[i].getVisit() == 0)
                r_info[i].setPossible(false);
        }

        //Initiate to zero since distance from origin to origin is zero
        r_info[src].setDistance(0.0);

        //Find the shortest distance
        for (int count = cnt; count < MAX; count++) {   //Make sure to note that the count and the global variable CNT are different!
            //Finding the smallest distance in the ride collection.
            //In the first iteration, u means the place of origin
            //-> Since the distance from the origin to the origin was initialized to 0, the min value in the first iteration is naturally 0.
            int u = mincost();

            r_info[u].setPossible(true);   //Change the value to true because you visited
            order[count] = u;   //Save the rides you visited.

            //We have a new ride, so please modify the street value
            for (int v = 0; v < MAX; v++)
                //I haven't visited it yet, so please correct it only when the posible value is false!
                // There is also a value from u to v
                // Modify only when the length from origin to v through u is less than the distance value of routeInfo[v]
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
