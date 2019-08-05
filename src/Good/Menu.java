package Good;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.Border;

public class Menu extends  JFrame{
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JLabel p;
	private JLabel p1;
	public Menu() {
		setTitle("物品管理信息系统");
	    setBounds(750, 200, 400, 400);
	    setLayout(null);
	    setResizable(false);
		Toolkit tk=Toolkit.getDefaultToolkit();
		Image image=tk.createImage("src\\Good\\22.jpg"); 
		this.setIconImage(image);
		
		p=new JLabel("欢迎来到物品信息管理系统！！！");
		p.setToolTipText(" ^_^感谢使用^_^");
		add(p);
		p.setBounds(40,25,330,30);
		p.setFont(new Font("宋体", Font.BOLD, 21));
		
		p1=new JLabel("请选择您的操作：");
		add(p1);
		p1.setBounds(120,60,150,30);
		p1.setFont(new Font("宋体", Font.BOLD,15));
		
		b1=new JButton("添加物品");
		b1.setFont(new Font("宋体", Font.BOLD, 18));
	    Border bored = BorderFactory.createLineBorder(Color.white);
	    b1.setBorder(bored);
		b1.setBackground(Color.PINK);
		b1.setBounds(110, 100, 150, 40);
     	add(b1);
		
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {	
			new f1( Menu.this);	
			}
		});
		
		b2=new JButton("修改物品");
		b2.setBounds(110, 160, 150, 40);
		b2.setFont(new Font("宋体", Font.BOLD, 18));
	    Border bored1 = BorderFactory.createLineBorder(Color.white);
	    b2.setBorder(bored1);
		b2.setBackground(Color.PINK);
		add(b2);
		b2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			new f2( Menu.this);
			}
		});
		
		
		b3=new JButton("查询物品");
		b3.setBounds(110, 220, 150, 40);
		b3.setFont(new Font("宋体", Font.BOLD, 18));
	    Border bored3 = BorderFactory.createLineBorder(Color.white);
	    b3.setBorder(bored3);
		b3.setBackground(Color.PINK);
		add(b3);
		b3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			new f3( Menu.this);
			}
		});
		
		b4=new JButton("删除物品");
		b4.setBounds(110, 280, 150, 40);
		b4.setFont(new Font("宋体", Font.BOLD, 18));
	    Border bored4 = BorderFactory.createLineBorder(Color.white);
	    b4.setBorder(bored4);
		b4.setBackground(Color.PINK);
		add(b4);
		b4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			new f4( Menu.this);
			}
			
		});

		((JPanel)this.getContentPane()).setOpaque(false); 
		ImageIcon img = new ImageIcon("src\\Good\\3.jpg"); 
		JLabel background = new JLabel(img);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE)); 
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setVisible(true);
	}
	
	public static void main(String[] args) {
		Menu t=new Menu();
	}
}
