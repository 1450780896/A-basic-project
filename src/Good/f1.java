package Good;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Menu;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class f1 extends JFrame{
	private Good.Menu menu;
	private JButton b4;
	private JButton b;
	private JLabel p=new JLabel("��Ʒ���:");
	private JLabel p1=new JLabel("��Ʒ����:");
	private JLabel p2=new JLabel("��Ʒ�۸�:");
	public f1(Good.Menu menu)
    {
	         	this.menu=menu;
    			setTitle("�����Ʒ");
    			setBounds(800,300,400,300);
    			setResizable(false);
    			setSize(400,300);
    			Toolkit tk=Toolkit.getDefaultToolkit();
    			Image image=tk.createImage("src\\Good\\13.jpg"); 
    			this.setIconImage(image);
    			// ��ӽ������Ԫ��
    			JTextField t=new JTextField();
    			JTextField t1=new JTextField();
    			JTextField t2=new JTextField();
    			p.setBounds(80,40,80,20);
    			p.setToolTipText(" >_<");
    			p1.setBounds(80,80,80,20);
    			p1.setToolTipText(" ^_^");
    			p2.setBounds(80,120,80,20);
    			p2.setToolTipText(" ~.~");
    			p.setFont(new Font("����",Font.BOLD, 15));
    			p1.setFont(new Font("����",Font.BOLD, 15));
    			p2.setFont(new Font("����",Font.BOLD, 15));
    			t.setBounds(180,40,100,25);
    			t1.setBounds(180,80,100,25);
    			t2.setBounds(180,120,100,25);
    			add(t);
    			add(t1);
    			add(t2);
    			add(p);
    			add(p1);
    			add(p2);
    			setResizable(false);
    			setLayout(null);
				b4=new JButton("ȷ�����");
				JButton b=new JButton("�˳�");
				b4.setBounds(60,200,120,40);
				b.setBounds(210,200,120,40);
				add(b4);  add(b);
    			setVisible(true);
				b.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						 setVisible(false);
					}
					});
				
				
				this.b4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String id = t.getText();
						String name = t1.getText();
						String price =t2.getText();
						
						if (id.trim().equals("")) {
							JOptionPane.showMessageDialog(null, "�������ţ�", "Ա������ϵͳ", 0);
							return;
						}
						if (name.trim().equals("")) {
							JOptionPane.showMessageDialog(null, "���������ƣ�", "Ա������ϵͳ", 0);
							return;
						}
						if (price.trim().equals("")) {
							JOptionPane.showMessageDialog(null, "������۸�", "Ա������ϵͳ", 0);
							return;
						}
						
						int deptId=1;
						Goods g=new Goods(id,name,price);
						DAO dao=new DAO();
						int i=dao.addGoods(g);
						if (i>0) {
							JOptionPane.showMessageDialog(null, "��ӳɹ�!");
						} else
							JOptionPane.showMessageDialog(null, "���ʧ�ܣ�", "Ա������ϵͳ", 0);
					}
				});

				((JPanel)this.getContentPane()).setOpaque(false); 
				ImageIcon img = new ImageIcon("src\\Good\\5.jpg"); 
				JLabel background = new JLabel(img);
				this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE)); 
				background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		
			}

				public static void main(String[] args) {
    }
}