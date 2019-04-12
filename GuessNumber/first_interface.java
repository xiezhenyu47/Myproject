import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;

import javax.swing.*;
import javax.swing.event.AncestorListener;
public class first_interface extends JFrame{
	int mouseAtX = 0;
	int mouseAtY = 0;
	static String user=null;
	public first_interface()
	{   
		this.setUndecorated(true);
		//背景图片
		ImageIcon background = new ImageIcon("C:\\Users\\lenovo\\Desktop\\面向对象课设\\diy\\背景.png");	
		JLabel label = new JLabel(background);		
		label.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
		
		//点击图标
		ImageIcon begin_picture = new ImageIcon("C:\\Users\\lenovo\\Desktop\\面向对象课设\\diy\\\\点击图标.png");
		JLabel begin = new JLabel(begin_picture);
		begin.setBounds(175,370,begin_picture.getIconWidth(),begin_picture.getIconHeight());
		begin.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				new input_interface();
				dispose();
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub					
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub					
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub					
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub		
			}
	});
	
		//右上角退出
		ImageIcon exit_picture = new ImageIcon("C:\\Users\\lenovo\\Desktop\\面向对象课设\\diy\\\\退出.png");	
		JLabel exit = new JLabel(exit_picture);		
		exit.setBounds(482,15,exit_picture.getIconWidth(),exit_picture.getIconHeight());
		exit.addMouseListener(new MouseListener(){
					public void mouseClicked(MouseEvent e) {
						System.exit(0);
					}
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub					
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub					
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub					
					}
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub		
					}
			});
		
		//排行榜
		ImageIcon rank_picture = new ImageIcon("C:\\Users\\lenovo\\Desktop\\面向对象课设\\diy\\排行榜.png");	
		JLabel rank = new JLabel(rank_picture);		
		rank.setBounds(50,670,rank_picture.getIconWidth(),rank_picture.getIconHeight());
		

		
		
		//将图片和按钮加入到标签myPanel
		JPanel myPanel = (JPanel)this.getContentPane();		
		myPanel.setOpaque(false);					
		myPanel.add(label);
		myPanel.add(begin);
		myPanel.add(exit);
		myPanel.add(rank);
		
		
		//把图片和按钮添加到我的面板里
		this.getLayeredPane().add(begin, new Integer(Integer.MIN_VALUE));
		this.getLayeredPane().add(exit, new Integer(Integer.MIN_VALUE));
		this.getLayeredPane().add(rank, new Integer(Integer.MIN_VALUE));
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		
		
		//设置界面属性
		this.setTitle("Click to continue");
		this.setBounds(650, 150, background.getIconWidth(), background.getIconHeight());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addMouseListener(new MouseAdapter() 
        {
            public void mousePressed(MouseEvent e) 
            { 
                mouseAtX = e.getPoint().x;
                mouseAtY = e.getPoint().y;
            }
         });      
		this.addMouseMotionListener(new MouseMotionAdapter()
          {
              public void mouseDragged(MouseEvent e) 
              {
                  setLocation((e.getXOnScreen()-mouseAtX),(e.getYOnScreen()-mouseAtY));//设置拖拽后，窗口的位置
              }
          });

	}


	 public static void main(String[] args) {
		 new first_interface();
		 }
}
