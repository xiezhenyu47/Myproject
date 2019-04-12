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
public class input_interface extends JFrame{
	int mouseAtX = 0;
	int mouseAtY = 0;
	
	public input_interface()
	{   
		this.setUndecorated(true);	
		
		//背景图片
		ImageIcon background = new ImageIcon("C:\\Users\\lenovo\\Desktop\\面向对象课设\\diy\\输入用户名.png");	
		JLabel label = new JLabel(background);		
		label.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
		
		JLabel input = new JLabel();
		input.setText("Please Input Your ID :");
		input.setBounds(90,90,150,30);
		
		JTextField name = new JTextField();
		name.setBounds(220,90,150,30);
		
		
		ImageIcon left_picture = new ImageIcon("C:\\Users\\lenovo\\Desktop\\面向对象课设\\diy\\左.png");	
		JLabel back = new JLabel(left_picture);	
		back.setBounds(80,150,left_picture.getIconWidth(),left_picture.getIconHeight());
		back.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				new first_interface();
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
		
		ImageIcon right_picture = new ImageIcon("C:\\Users\\lenovo\\Desktop\\面向对象课设\\diy\\右.png");	
		JLabel confirm = new JLabel(right_picture);	
		confirm.setBounds(330,150,right_picture.getIconWidth(),right_picture.getIconHeight());
		confirm.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {	
				first_interface.user=name.getText();
				
				new game_interface();
				
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
		
		
	
		
		JPanel myPanel = (JPanel)this.getContentPane();		
		myPanel.setOpaque(false);					
		
		
		
		
		//将图片和按钮加入到标签myPanel
		myPanel.add(label);
		myPanel.add(name);
		myPanel.add(confirm);
		myPanel.add(back);		
		myPanel.add(input);
		
		
		//把tthis.getLayeredPane().add(confirm, new Integer(Integer.MIN_VALUE));his.getLayeredPane().add(confirm, new Integer(Integer.MIN_VALUE));图片和按钮添加到我的面板里
		this.getLayeredPane().add(confirm, new Integer(Integer.MIN_VALUE));
		this.getLayeredPane().add(back, new Integer(Integer.MIN_VALUE));
		this.getLayeredPane().add(input, new Integer(Integer.MIN_VALUE));
		this.getLayeredPane().add(name, new Integer(Integer.MIN_VALUE));
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		
		
		//设置界面属性
		this.setTitle("Click to continue");
		this.setBounds(650, 350, background.getIconWidth(), background.getIconHeight());
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
		 new input_interface();
		 }
}