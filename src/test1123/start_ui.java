package test1123;

import javax.swing.JPanel;
import javax.swing.text.NumberFormatter;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class start_ui extends JPanel {

	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private Frame F;
	
	public start_ui(Frame f) {
		
		f.setTitle("즐거운 빙고게임");
		f.setSize(330, 120);
	   
		F = f;
		
		lblNewLabel = new JLabel("빙고게임 크기를 설정해주세요(3~10)");
		
		add(lblNewLabel);
		
		NumberFormatter scale=new NumberFormatter();
		scale.setValueClass(Integer.class);
		scale.setMinimum(new Integer(3));
		scale.setMaximum(new Integer(10));
		JFormattedTextField text=new JFormattedTextField(scale);
		text.setColumns(10);
		add(text);
		
		
		
		btnNewButton = new JButton("시작");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
			
				
				try {
					int n=Integer.parseInt(text.getText());
					System.out.println("---"+text.getText());
					if(n>2&&n<11)
					{
					F.number=n;
					
					F.user_board=new int[n][n];
					F.computer_borad=new int[n][n];
					
					F.board_setting();
					F.add("Two", new user_ui(f));
					F.changePanel(f);
					f.com_ui=new computer_ui(f);
					F.computer_check_board=new int[n][n];
					F.user_check_board=new int[n][n];
					for(int i=0;i<n;i++)
					{
						for(int j=0;j<n;j++)
						{
							F.computer_check_board[i][j]=0;
							F.user_check_board[i][j]=0;
						}
					}
					
					F.add("three",f.com_ui);
					
				
					}
				
					
					//System.out.println(text.getText());
					
					f.setSize(500,500);
				}catch(Exception e)
				{
					System.out.println(e);
				
					JOptionPane.showMessageDialog(null, "3~10의 수를 입력하세요!");
				}
				
			}
		});
		
		add(btnNewButton);

		setVisible(true);
	}
}
