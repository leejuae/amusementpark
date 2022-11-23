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
		button.setFocusPainted(false); //Button ������ �� �׵θ� �� �����
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
		 * button ������, ȭ�� ��ȯ
		 */
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false); //â �� ���̰� �ϱ�
				new information();
			}
			
		});
	}
	
	/**
	 * ���� �Է�
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
			
			JLabel people = new JLabel("�ο�:");
			people.setBounds(80, 150, 50, 20);
			people.setFont(f1);
			add(people);
			
			JComboBox p = new JComboBox();
			p.setModel(new DefaultComboBoxModel(new String[] {"1��", "2��", "3��", "4��", "5�� �̻�"}));
			p.setBounds(145, 148, 120, 25);
			add(p);
			
			JLabel type = new JLabel("����:");
			type.setBounds(80, 195, 50, 20);
			type.setFont(f1);
			add(type);
			
			JComboBox t = new JComboBox();
			t.setModel(new DefaultComboBoxModel(new String[] {"��庥��", "��������", "�����Ǿ�"}));
			t.setBounds(145, 193, 120, 25);
			add(t);
			
			/**
			 * ������ ���� & ����ġ ���̵���
			 */
			ImageIcon loca = new ImageIcon("image/location.jpg");
			Image l = loca.getImage().getScaledInstance(45, 35, Image.SCALE_SMOOTH);
			ImageIcon location = new ImageIcon(l);
			JButton b1 = new JButton("����", location); //Button�� �ؽ�Ʈ & �̹��� ����
			b1.setHorizontalTextPosition(JButton.LEFT); //�ؽ�Ʈ ��������
			b1.setFocusPainted(false); //Button ������ �� �׵θ� �� �����
			//b1.setOpaque(false); //�����ϰ�
			b1.setBackground(Color.white);
			b1.setFont(f1);
			b1.setBounds(110, 245, 130, 45);
			add(b1);
			
			/**
			 * ������ �˰��� ����
			 */
			JButton b2 = new JButton("���̱ⱸ Ÿ������");
			b2.setFocusPainted(false);
			b2.setBounds(65, 370, 220, 35);
			b2.setBackground(Color.pink);
			b2.setFont(f1);
			add(b2);
			
			add(pn2); add(pn1);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			/**
			 * ���� & ����ġ
			 */
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false); //â �� ���̰� �ϱ�
					new map();
				}	
			});
			
			/**
			 * �˰��� ����
			 */
			b2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false); //â �� ���̰� �ϱ�
					//ž�� ����!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				}
			});
		}
		
		/**
		 * ���� & ����ġ
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
				
				//�˰��򿡼� ��ġ ���� �����ͼ� ������ ǥ���ϱ� 
				
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
