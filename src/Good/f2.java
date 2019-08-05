package Good;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Menu;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class f2 extends JFrame{
    private Good.Menu menu2;
    private JButton l4;
    private JButton b;
	public f2(Good.Menu menu2) {
    	        this.menu2=menu2;
                setTitle("修改物品");
                setLayout(null);
                setResizable(false);
            	Toolkit tk=Toolkit.getDefaultToolkit();
    			Image image=tk.createImage("src\\Good\\14.jpg"); 
    			this.setIconImage(image);
				JLabel l=new JLabel("修改编号:");
			    setSize(400, 300);
				setResizable(false);
				setLocation(700,300);
				add(l);
				l.setBounds(80, 30,100,20);
				l.setFont(new Font("宋体",Font.BOLD, 15));
				JTextField t=new JTextField("请输入",15);
				add(t);
				t.setBounds(180,30,100,25);
				
				JLabel l1=new JLabel("编号修改为:");
				l1.setFont(new Font("宋体",Font.BOLD, 15));
				add(l1);
				l1.setBounds(80,70,100,20);
				JTextField t1=new JTextField("请输入",15);
				add(t1);
				t1.setBounds(180,70,100,25);
		
				
				JLabel l2=new JLabel("名称:");
				l2.setFont(new Font("宋体",Font.BOLD, 15));
				add(l2);
				l2.setBounds(80,110,100,20);
				JTextField t2=new JTextField("请输入",15);
				add(t2);
				t2.setBounds(180,110,100,25);
				
				JLabel l3=new JLabel("价格:");
				l3.setFont(new Font("宋体",Font.BOLD, 15));
				add(l3);
				l3.setBounds(80,150,100,25);
				JTextField t3=new JTextField("请输入",15);
				add(t3);
				t3.setBounds(180,150,100,25);
		
			
				l4=new JButton("确认修改");
				add(l4);
				l4.setBounds(70,210,100,30);
				
				b=new JButton("退出");
				add(b);
				b.setBounds(190,210,100,30);
				setVisible(true);
				this.l4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int n = JOptionPane.showConfirmDialog(null, "确认修改吗?", "wp", JOptionPane.YES_NO_OPTION);
						System.out.println(n);
						String id = t.getText();
						String Id=t1.getText();
						String Name=t2.getText();
						String Price=t3.getText();
						Goods g=new Goods(Id,Name,Price,id);
						DAO dao=new DAO();
						if(n==0){
							int i=dao.updateGoods(Id,Name,Price,id,g);
							if (i>0) {
							JOptionPane.showMessageDialog(null, "修改成功!");
						} else
							JOptionPane.showMessageDialog(null, "修改失败！", "物品管理系统", 0);
					}
					}
				});
				
				this.b.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
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
