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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class f4 extends JFrame{
	 private Good.Menu menu;
	 JButton l4;
	public f4(Good.Menu menu2) {
		     this.menu=menu2;
		        setTitle("删除物品");
				FlowLayout flow=new FlowLayout(FlowLayout.CENTER,10,10);
				Toolkit tk=Toolkit.getDefaultToolkit();
    			Image image=tk.createImage("src\\Good\\16.jpg"); 
    			this.setIconImage(image);
				JLabel l=new JLabel("请输入删除物品编号:");
				setLayout(null);
				setSize(360, 300);
				setResizable(false);
				setLocation(700,300);
				add(l);
				l.setBounds(50,30,150,25);
				l.setFont(new Font("宋体",Font.BOLD, 14));
				JTextField t3=new JTextField();
				t3.setBounds(205,35,35,22);
				
				JLabel l1=new JLabel("物品名称:");
				JLabel l2=new JLabel("物品价格:");
				l1.setFont(new Font("宋体",Font.BOLD, 14));
				l2.setFont(new Font("宋体",Font.BOLD, 14));
				l1.setBounds(50,80,100,25);
				l2.setBounds(50,130,100,25);
				
				JTextField t=new JTextField();
				JTextField t1=new JTextField();
				t.setBounds(140,80,100,22);
				t1.setBounds(140,130,100,22);
				
				add(l1);  add(l2);  add(t);  add(t1);  add(t3);		
				l4=new JButton("查看");
				add(l4);
				l4.setBounds(250,30,70,25);
				setVisible(true);
				
				this.l4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String Id = t3.getText();
						Goods g = new DAO().getId(Id);
						if (g == null) {
							JOptionPane.showMessageDialog(null, "无此物品！");
						} else {
							t.setText(g.getName());
							t1.setText(g.getPrice());
						}
					}
				});
			l4=new JButton("确认删除");
			add(l4);
			l4.setBounds(90,180,90,30);
			setVisible(true);
			this.l4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int n = JOptionPane.showConfirmDialog(null, "确认删除吗?", "标题", JOptionPane.YES_NO_OPTION);
					System.out.println(n);
					String Id = t3.getText();
					if(n==0){
						int i=DAO.deleteGoods(Id);
						if(i>0)
							JOptionPane.showMessageDialog(null, "删除成功!");
						else
							JOptionPane.showMessageDialog(null, "删除失败!");
					}
				}
			});
			
			JButton b=new JButton("退出");
			add(b);
			b.setBounds(190,180,100,30);
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					new Menu();
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
