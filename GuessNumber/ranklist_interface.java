
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
public class ranklist_interface extends JFrame{
	int mouseAtX = 0;
	int mouseAtY = 0;
	JLabel[]rank=new JLabel[6];
	public ranklist_interface()
	{   
		this.setUndecorated(true);		
		//背景图片
		ImageIcon background = new ImageIcon("C:\\\\Users\\\\lenovo\\\\Desktop\\\\面向对象课设\\\\diy\\\\排行榜背景.png");	
		JLabel label = new JLabel(background);		
		label.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
		

		JPanel myPanel = (JPanel)this.getContentPane();		
		myPanel.setOpaque(false);					
		
		
		//6个排名
		Font font = new Font("黑体", Font.PLAIN,20);
		String[] strings=new String[6];
		Rank rank1=new Rank();
    	rank1.readFile();
    	strings=rank1.display();
		for(int i=0;i<6;i++) {
			rank[i]= new JLabel("第"+(i+1)+"名  "+strings[i]);		
			rank[i].setFont(font);
		}
		rank[0].setBounds(120,35,1200,20);
		rank[1].setBounds(120,120,1200,20);
		rank[2].setBounds(120,205,1200,20);
		rank[3].setBounds(120,285,1200,20);
		rank[4].setBounds(120,368,1200,20);
		rank[5].setBounds(120,450,1200,20);
		
		//右上角退出
		ImageIcon exit_picture = new ImageIcon("C:\\\\Users\\\\lenovo\\\\Desktop\\\\面向对象课设\\\\diy\\\\退出.png");	
		JLabel exit = new JLabel(exit_picture);		
		exit.setBounds(385,10,exit_picture.getIconWidth(),exit_picture.getIconHeight());
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
		
		//将图片和按钮加入到标签myPanel
		for(int i=0;i<6;i++) {
			myPanel.add(rank[i]);
		}
		myPanel.add(label);
		myPanel.add(exit);
		
		
		
		//把tthis.getLayeredPane().add(confirm, new Integer(Integer.MIN_VALUE));his.getLayeredPane().add(confirm, new Integer(Integer.MIN_VALUE));图片和按钮添加到我的面板里
		for(int i=0;i<6;i++) {
			this.getLayeredPane().add(rank[i], new Integer(Integer.MIN_VALUE));
		}
		this.getLayeredPane().add(exit, new Integer(Integer.MIN_VALUE));
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		
		
		//设置界面属性
		this.setTitle("Click to continue");
		this.setBounds(650, 250, background.getIconWidth(), background.getIconHeight());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		this. addMouseListener(new MouseAdapter() 
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
		 new ranklist_interface();
		 }
}