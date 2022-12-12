package test1123;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class computer_ui extends JPanel{

	JPanel word_panel;
	JLabel[][] label;
	 JPanel text_panel=new JPanel();
	 JLabel text_cor=new JLabel("엔터를 입력하여 빙고를시작하세용");
	
	 int[][] score_table;
	 int[] row;
	 int[] col;
	 int[] diag=new int[2];
	computer_ui(Frame f){
		label=new JLabel[f.number][f.number];
		//f.setSize(700,700);
	  score_table=new int[f.number][f.number];
		row=new int[f.number];
		col=new int[f.number];
		
	  setLayout(new BorderLayout());
		
		JPanel top_panel=new JPanel();
		top_panel.setLayout(new BorderLayout());
		JLabel k=new JLabel("Computer 현황판");
		top_panel.add(k,BorderLayout.CENTER);
		JButton btn=new JButton("user 화면이동");
		
		btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				f.changePanel(f);
			}
			
			});
		top_panel.add(btn,BorderLayout.EAST);
		
		
		k.setHorizontalAlignment(JLabel.CENTER);
		JLabel k2=new JLabel("현황판2");
		add(top_panel,BorderLayout.NORTH);
		
		word_panel=new JPanel(new GridLayout(f.number,f.number));
		
		for(int i=0;i<f.number;i++)
		{
			for(int j=0;j<f.number;j++)
			{
				LineBorder rr=new LineBorder(Color.black,1,true);
				JLabel k3=new JLabel("X");
				k3.setBorder(rr);
				k3.setBackground(Color.cyan);
				k3.setForeground(Color.black);
				k3.setFont(new Font("Serif",Font.BOLD,16));
				k3.setHorizontalAlignment(JLabel.CENTER);
				Word sk=f.voc.voc.get(f.computer_borad[i][j]);
				
				k3.setText(sk.eng);
				label[i][j]=k3;
				word_panel.add(label[i][j]);
			  
			}
				
			
		}
	
		
		LineBorder rr=new LineBorder(Color.black,1,true);
		JLabel k3=new JLabel("O");
		k3.setBorder(rr);
		k3.setBackground(Color.cyan);
		k3.setForeground(Color.black);
		k3.setFont(new Font("Serif",Font.BOLD,30));
		k3.setHorizontalAlignment(JLabel.CENTER);
	
	
	   JButton ss=new JButton("ektl");
	   
	   
	  
	   text_panel.setLayout(new BorderLayout());
	   
	   
	   text_cor.setHorizontalAlignment(JLabel.CENTER);
	   JTextField text_input=new JTextField();
	   
	
		add(word_panel,BorderLayout.CENTER);
		add(text_panel,BorderLayout.SOUTH);
		
           
		
	}
}
