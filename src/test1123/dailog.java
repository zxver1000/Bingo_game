package test1123;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class dailog extends JDialog{
	
	
	
	dailog(Frame f,String k)
	{
		setTitle("빙고게임");
		setSize(300,150);
		setLayout(new BorderLayout());
		
		JLabel com=new JLabel(k);
		add(com,BorderLayout.NORTH);
		
		JButton okButton=new JButton("OK");
		add(okButton,BorderLayout.SOUTH);
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
			
		});
		
		
	}
	
	dailog(Frame f,String k,int flag)
	{
		
		if(flag==1)
		{
			setTitle("게임 승리를 축하드립니다");
		}
		else if(flag==0)
		{
			setTitle("아쉽지만 게임에 패배하였습니다");
		}
		else
		{
			setTitle("Draw 무승부입니다!");
		}
		
		setSize(300,150);
		setLayout(new BorderLayout());
		
		JLabel com=new JLabel(k);
		add(com,BorderLayout.NORTH);
		
		JButton okButton=new JButton("OK");
		add(okButton,BorderLayout.SOUTH);
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(1);
			}
			
		});
		
		
	}
	
	
}
