import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.AncestorListener;
public class game_interface extends JFrame{
	int mouseAtX = 0;
	int mouseAtY = 0;
	Random r=new Random();
	int A=2;
	int B=1;
	int sum=0;
	String temp=" ";
	JTextField num = new JTextField();
	JTextField result = new JTextField();
	//�ύ�����Աȵ�4������
	int[]answers=new int[4];
	Number number;
	int step=0;
	public game_interface()
	{   number=new Number(4);
		number.randomNumber();	
		this.setUndecorated(true);
		//����ͼƬ
		ImageIcon background = new ImageIcon("C:\\Users\\lenovo\\Desktop\\����������\\diy\\��Ϸ����.png");	
		JLabel label = new JLabel(background);		
		label.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
		
	
		//����û���
		Font font1 = new Font("����", Font.PLAIN,20);
		JLabel name = new JLabel("�û�����"+first_interface.user);		
		name.setBounds(40,40,200,40);
		name.setFont(font1);
		
		//��λ���ֵ�����
		Font font = new Font("����", Font.PLAIN, 45);
		num.setFont(font);
		num.setBounds(47,129,392,98);
		num.setEditable(false);
		num.setBackground(new Color(255,255,255));
		
		//������ɵ���������
		
		result.setFont(font);
		result.setBounds(47,379,392,98);
		result.setEditable(false);
		result.setBackground(new Color(255,255,255));
		
		//ʮ������Ķ���
		Font font2 = new Font("����", Font.PLAIN,30);
		JLabel[] nums = new JLabel[10];
		for (int i=0; i<10; i++) {
			nums[i] = new JLabel(Integer.toString(i));
			nums[i].setFont(font2);
		}
		nums[0].setBounds(230,692,30,30);
		nums[1].setBounds(125,517,30,30);
		nums[2].setBounds(230,517,30,30);
		nums[3].setBounds(350,517,30,30);
		nums[4].setBounds(125,577,30,30);
		nums[5].setBounds(230,577,30,30);
		nums[6].setBounds(350,577,30,30);
		nums[7].setBounds(125,637,30,30);
		nums[8].setBounds(230,637,30,30);
		nums[9].setBounds(350,637,30,30);
		
		for (int i=0; i<10; i++) {
			int j=i;
			nums[i].addMouseListener(new MouseListener(){
				public void mouseClicked(MouseEvent e) {
					if(sum==4) {
						JOptionPane.showMessageDialog(null,"û��ʣ��λ��",null,JOptionPane.ERROR_MESSAGE);
					}
					else {
							temp=temp+"  "+Integer.toString(j);
							num.setText(temp);
							answers[sum]=j;
							sum++;
						
						
					}
					
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
		}
		
		JLabel confirm = new JLabel("ȷ��");
		confirm.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				step++;
				boolean flag=false;
				int[] num=new int[2];
				//************
				int num123[]=number.getRandomNumber();
				//************
				System.out.println(num123[0]+""+num123[1]+""+num123[2]+""+num123[3]);
				number.setInputNumber(answers[0],answers[1],answers[2],answers[3]);
				num=number.compareNomber();
				if(num[0]==number.getN()) {
					flag=true;
					JOptionPane.showMessageDialog(null,"��ϲ��ش���ȷ!����"+step+"��",null,JOptionPane.ERROR_MESSAGE);
					Rank rank=new Rank();
					rank.readFile();
					rank.compare(first_interface.user, step);
			        rank.writeFile();
				}else {
					flag=false;
					result.setText("  A: "+num[0]+"   B: "+num[1]);
				}
					
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
		
		JLabel clear = new JLabel("����");
		clear.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {	
				for (int i=0; i<4; i++) {
					answers[i]=11;
					sum=0;
					temp=" ";
					num.setText(temp);
				}
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
		
		
		
		
		confirm.setFont(font2);
		clear.setFont(font2);
		confirm.setBounds(102,690,200,40);
		clear.setBounds(325,690,200,40);
		//���Ͻ��˳�
		ImageIcon exit_picture = new ImageIcon("C:\\Users\\lenovo\\Desktop\\����������\\diy\\\\�˳�.png");	
		JLabel exit = new JLabel(exit_picture);		
		exit.setBounds(445,12,exit_picture.getIconWidth(),exit_picture.getIconHeight());
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
		
		
		
		
		
							
		//�ύ���ְ�ť
		ImageIcon up_picture = new ImageIcon("C:\\Users\\lenovo\\Desktop\\����������\\diy\\�ύ����.png");	
		JLabel up = new JLabel(up_picture);		
		up.setBounds(120,260,up_picture.getIconWidth(),up_picture.getIconHeight());
		
		
		
		//��ͼƬ�Ͱ�ť���뵽��ǩmyPanel
		JPanel myPanel = (JPanel)this.getContentPane();		
		myPanel.setOpaque(false);
		myPanel.add(label);
		myPanel.add(exit);
		myPanel.add(num);
		myPanel.add(result);
		myPanel.add(up);
		myPanel.add(name);
		myPanel.add(confirm);
		myPanel.add(clear);
		for (int i=0; i<10; i++) {
			myPanel.add(nums[i]);
		 }

		//��ͼƬ�Ͱ�ť��ӵ��ҵ������
		for (int i=0; i<10; i++) {
			this.getLayeredPane().add(nums[i], new Integer(Integer.MIN_VALUE));
		 }
		this.getLayeredPane().add(confirm, new Integer(Integer.MIN_VALUE));
		this.getLayeredPane().add(clear, new Integer(Integer.MIN_VALUE));
		this.getLayeredPane().add(name, new Integer(Integer.MIN_VALUE));
		this.getLayeredPane().add(up, new Integer(Integer.MIN_VALUE));
		this.getLayeredPane().add(result, new Integer(Integer.MIN_VALUE));
		this.getLayeredPane().add(num, new Integer(Integer.MIN_VALUE));
		this.getLayeredPane().add(exit, new Integer(Integer.MIN_VALUE));
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
		 new game_interface();
		 }
}