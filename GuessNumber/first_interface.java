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
		//����ͼƬ
		ImageIcon background = new ImageIcon("C:\\Users\\lenovo\\Desktop\\����������\\diy\\����.png");	
		JLabel label = new JLabel(background);		
		label.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
		
		//���ͼ��
		ImageIcon begin_picture = new ImageIcon("C:\\Users\\lenovo\\Desktop\\����������\\diy\\\\���ͼ��.png");
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
	
		//���Ͻ��˳�
		ImageIcon exit_picture = new ImageIcon("C:\\Users\\lenovo\\Desktop\\����������\\diy\\\\�˳�.png");	
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
		
		//���а�
		ImageIcon rank_picture = new ImageIcon("C:\\Users\\lenovo\\Desktop\\����������\\diy\\���а�.png");	
		JLabel rank = new JLabel(rank_picture);		
		rank.setBounds(50,670,rank_picture.getIconWidth(),rank_picture.getIconHeight());
		

		
		
		//��ͼƬ�Ͱ�ť���뵽��ǩmyPanel
		JPanel myPanel = (JPanel)this.getContentPane();		
		myPanel.setOpaque(false);					
		myPanel.add(label);
		myPanel.add(begin);
		myPanel.add(exit);
		myPanel.add(rank);
		
		
		//��ͼƬ�Ͱ�ť��ӵ��ҵ������
		this.getLayeredPane().add(begin, new Integer(Integer.MIN_VALUE));
		this.getLayeredPane().add(exit, new Integer(Integer.MIN_VALUE));
		this.getLayeredPane().add(rank, new Integer(Integer.MIN_VALUE));
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		
		
		//���ý�������
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
                  setLocation((e.getXOnScreen()-mouseAtX),(e.getYOnScreen()-mouseAtY));//������ק�󣬴��ڵ�λ��
              }
          });

	}


	 public static void main(String[] args) {
		 new first_interface();
		 }
}
