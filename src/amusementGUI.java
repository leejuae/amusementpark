import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class amusementGUI extends JFrame {

	Font f1 = new Font("SanSerif", Font.BOLD, 20);
	Font f2 = new Font("SanSerif", Font.PLAIN, 40);
	Font f3 = new Font("SanSerif", Font.ITALIC | Font.BOLD, 70);
	
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
		button.setFocusPainted(false); //Button 눌렀을 때 테두리 안 생기게
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
		 * button 누르면, 화면 전환
		 */
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false); //창 안 보이게 하기
				new information();
			}
			
		});
	}
	
	/**
	 * 정보 입력
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
			
			JLabel people = new JLabel("인원:");
			people.setBounds(80, 150, 50, 20);
			people.setFont(f1);
			add(people);
			
			JComboBox p = new JComboBox();
			p.setModel(new DefaultComboBoxModel(new String[] {"1인", "2인", "3인", "4인", "5인 이상"}));
			p.setBounds(145, 148, 120, 25);
			add(p);
			
			JLabel type = new JLabel("종류:");
			type.setBounds(80, 195, 50, 20);
			type.setFont(f1);
			add(type);
			
			JComboBox t = new JComboBox();
			t.setModel(new DefaultComboBoxModel(new String[] {"어드벤쳐", "매직랜드", "주토피아"}));
			t.setBounds(145, 193, 120, 25);
			add(t);
			
			/**
			 * 누르면 지도 & 현위치 보이도록
			 */
			ImageIcon loca = new ImageIcon("image/location.jpg");
			Image l = loca.getImage().getScaledInstance(45, 35, Image.SCALE_SMOOTH);
			ImageIcon location = new ImageIcon(l);
			JButton b1 = new JButton("지도", location); //Button에 텍스트 & 이미지 삽입
			b1.setHorizontalTextPosition(JButton.LEFT); //텍스트 왼쪽으로
			b1.setFocusPainted(false); //Button 눌렀을 때 테두리 안 생기게
			//b1.setOpaque(false); //투명하게
			b1.setBackground(Color.white);
			b1.setFont(f1);
			b1.setBounds(110, 245, 130, 45);
			add(b1);
			
			/**
			 * 누르면 알고리즘 실행
			 */
			JButton b2 = new JButton("놀이기구 타러가기");
			b2.setFocusPainted(false);
			b2.setBounds(65, 370, 220, 35);
			b2.setBackground(Color.pink);
			b2.setFont(f1);
			add(b2);
			
			add(pn2); add(pn1);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			/**
			 * 지도 & 현위치
			 */
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false); //창 안 보이게 하기
					new map();
				}	
			});
			
			/**
			 * 알고리즘 실행
			 */
			b2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false); //창 안 보이게 하기
					//탑승 순서!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				}
			});
		}
		
		/**
		 * 지도 & 현위치
		 */
		public class map extends JFrame {
			map() {
				
				setBounds(100, 100, 562, 500);
				setLayout(null);
				setTitle("Map");
				ImageIcon map = new ImageIcon("image/map.jpg");
				
				JPanel pn = new JPanel() {
					public void paintComponent(Graphics g) {
						g.drawImage(map.getImage(), 0, 0, 562, 500, null);
					}
				};
				pn.setBounds(0, 0, 562, 500);
				
				//알고리즘에서 위치 정보 가져와서 지도에 표시하기 
				
				add(pn);
				setVisible(true);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
		
	}
	
	public static void main(String[] args) {
		new amusementGUI();
	}

}
