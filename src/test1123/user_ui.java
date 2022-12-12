package test1123;

import javax.swing.border.LineBorder;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;
public class user_ui extends JPanel{
	
	JPanel word_panel;
	JLabel[][] label;
	 JPanel text_panel=new JPanel();
	 JLabel text_cor=new JLabel("엔터를 입력하여 빙고를시작하세용");


	 
	 
Word score_calculation(int n,Frame f)
{
	int cnt=0;
	//row 점수계산
	for(int i=0;i<n;i++)
	{
		cnt=0;
		for(int j=0;j<n;j++)
		{
			f.com_ui.score_table[i][j]=0;
			if(f.computer_check_board[i][j]==1)
				cnt++;
			
		}
		f.com_ui.row[i]=cnt*n;
	}
	//col 점수계산
	for(int i=0;i<n;i++)
	{
		cnt=0;
		for(int j=0;j<n;j++)
		{
			
			if(f.computer_check_board[j][i]==1)
				cnt++;
			
		}
		f.com_ui.col[i]=cnt*n;
	}
	cnt=0;
	for(int i=0;i<n;i++)
	{
		if(f.computer_check_board[i][i]==1)
			cnt++;
		
	}
	f.com_ui.diag[0]=cnt*n;
	cnt=0;
	for(int i=0;i<n;i++)
	{
		if(f.computer_check_board[i][n-1-i]==1)
			cnt++;	
	}
	f.com_ui.diag[1]=cnt*n;
	
	
	System.out.println("diag score is : "+f.com_ui.diag[1]);
	
	
	
	for(int i=0;i<n;i++)
	{
		
		for(int j=0;j<n;j++)
		{
			//점수합산
			if(f.computer_check_board[i][j]==0)
			{
				f.com_ui.score_table[i][j]=f.com_ui.row[i]+f.com_ui.col[j];
			if(i==j)
			{
				f.com_ui.score_table[i][j]+=f.com_ui.diag[0];
			}
			
			}
			
				
			
		}
		
		
	}
	
	
	for(int i=0;i<n;i++)
	{
		if(f.computer_check_board[i][n-1-i]==0)
		{
			if(i==n-1-i)
			{
				continue;
			}
			f.com_ui.score_table[i][n-1-i]+=f.com_ui.diag[1];
		}
		
	}
	int min=-1;
	int idx_i=0;
	int idx_j=0;
	int min_row=0;
	int min_col=0;
	int mint_dia=0;
   int max_num=-1;
	//점수가 가장 큰애 찾기!!
	for(int i=0;i<n;i++)
	{
		
		for(int j=0;j<n;j++)
		{
			if(min<f.com_ui.score_table[i][j])
			{
				min=f.com_ui.score_table[i][j];
				idx_i=i;
				idx_j=j;
		      
			}
			
		}
	}
	
	
	
	
	for(int i=0;i<n;i++)
	{
		
		for(int j=0;j<n;j++)
		{
		  if(min==f.com_ui.score_table[i][j])
		  {
			  // 점수 같은애들 중 비교
		       int max_n=-1;
		       max_n=Math.max(f.com_ui.row[i],f.com_ui.col[j]);
			   int flagss=0;
			   
			   if(i==j)
			   {
				   //오른족 대각선일때
				   max_n=Math.max(max_n, f.com_ui.diag[0]);
			   }
			   
			   
				for(int k=0;k<n;k++)
				{
					//k는 0~n-1까지고
					//0,2
					//1,0 n 3  k1 
					if(k==i&&(n-1-k)==j)
					{
						flagss=1;
					}
					
				}
				if(flagss==1)
				{
					max_n=Math.max(max_n, f.com_ui.diag[1]);
				}
			  
				if(max_n>max_num)
				{
					max_num=max_n;
					idx_i=i;
					idx_j=j;
				
				}
					
			  
			  
		  }
			
		}
		
	}
	
	f.computer_check_board[idx_i][idx_j]=1;
	f.com_ui.label[idx_i][idx_j].setText("O");
	Word ks=f.voc.voc.get(f.computer_borad[idx_i][idx_j]);
	//컴퓨터햇으니유저골라라
	check_text_users(ks.eng,n,f);
	
	return ks;
}

	
	 
	 
Word computer_turn(int n ,Frame f)
{
	
	//홀수일때 --> 무조건가운데먹어야됨
	if(n%2==1)
	{
		if(f.computer_check_board[n/2][n/2]==0)
		{
			f.computer_check_board[n/2][n/2]=1;
			f.com_ui.label[n/2][n/2].setText("O");
			Word ks=f.voc.voc.get(f.computer_borad[n/2][n/2]);
			check_text_users(ks.eng,n,f);
			return ks;
		}
		
	}
	
	return score_calculation(n,f);
	

	
	
	
}


void check_text_users(String text,int n,Frame f)
{
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			Word next_check=f.voc.voc.get(f.user_board[i][j]);
			if(next_check.eng.equals(text))
			{
				//정답쓰
				label[i][j].setText("O");
				f.user_check_board[i][j]=1;
				return;
			}
			
			
		}
		
	}
	
	
}


void check_text_com(String text,int n,Frame f)
{
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			Word next_check=f.voc.voc.get(f.computer_borad[i][j]);
			if(next_check.eng.equals(text))
			{
				//정답쓰
				f.com_ui.label[i][j].setText("O");
				f.computer_check_board[i][j]=1;
				return;
			}
			
			
		}
		
	}
	
	
}

void check_bingo_cnt(int n,Frame f)
{
	// 가로
	int user_flag=1;
	int com_flag=1;
	 
	int com_bingo_cnt=0;
	int user_bingo_cnt=0;
	for(int i=0;i<n;i++)
	{
		user_flag=1;
		com_flag=1;
	for(int j=0;j<n;j++)
	{
		if(f.computer_check_board[i][j]==0)
		{
			com_flag=0;
			break;
		}
	}
	
	for(int j=0;j<n;j++)
	{
		if(f.user_check_board[i][j]==0)
		{
			user_flag=0;
			break;
		}
	}
	
	
	if(user_flag==1) user_bingo_cnt++;
	
	if(com_flag==1)com_bingo_cnt++;
	
		
	}
	
	
	//세로
	
	for(int i=0;i<n;i++)
	{
		user_flag=1;
		com_flag=1;
	for(int j=0;j<n;j++)
	{
		if(f.computer_check_board[j][i]==0)
		{
			com_flag=0;
			break;
		}
	}
	
	for(int j=0;j<n;j++)
	{
		if(f.user_check_board[j][i]==0)
		{
			user_flag=0;
			break;
		}
	}
	
	
	if(user_flag==1) user_bingo_cnt++;
	
	if(com_flag==1)com_bingo_cnt++;
		
	}
	
	
	
	user_flag=1;
		com_flag=1;
	for(int i=0;i<n;i++)
	{
		
		if(f.user_check_board[i][i]==0)
			user_flag=0;
		if(f.computer_check_board[i][i]==0)
			com_flag=0;
		
	}
	
   if(user_flag==1) user_bingo_cnt++;
	
	if(com_flag==1)com_bingo_cnt++;
	
	
	user_flag=1;
	com_flag=1;
for(int i=0;i<n;i++)
{
	
	//n 4 4     0 3
	
	if(f.user_check_board[i][n-1-i]==0)
		user_flag=0;
	if(f.computer_check_board[i][n-1-i]==0)
		com_flag=0;
}

if(user_flag==1) user_bingo_cnt++;

if(com_flag==1)com_bingo_cnt++;
	
	
	

f.com_bingo=com_bingo_cnt;
f.user_bingo=user_bingo_cnt;


if(com_bingo_cnt>user_bingo_cnt)
{
	
	f.com_rate++;
	
	System.out.println("com win승");
	double total=f.com_rate+f.draw_rate+f.user_rate;
	double rate=Math.round((((double)f.user_rate/total)*10000.0))/100.0;
	
	Filewrite(f);
	dailog kr=new dailog(f,"<html>"+"게임종료 !!!<br>"+"user 님은 현재 "+f.user_rate+"승 "+f.com_rate+"패 "+f.draw_rate+"무 ("+rate+"%) 입니다"+"</html>",0);
	kr.setVisible(true);
	
}
else if(user_bingo_cnt>com_bingo_cnt)
{
	f.user_rate++;
	System.out.println("user in승");
	double total=f.com_rate+f.draw_rate+f.user_rate;
	double rate=Math.round((((double)f.user_rate/total)*10000.0))/100.0;
	
	Filewrite(f);
	dailog kr=new dailog(f,"<html>"+"게임종료 !!!<br>"+"user 님은 현재 "+f.user_rate+"승 "+f.com_rate+"패 "+f.draw_rate+"무 ("+rate+"%) 입니다"+"</html>",1);
	kr.setVisible(true);
	
	//System.exit(1);
	
}
else if(user_bingo_cnt==com_bingo_cnt)
{
	
	Boolean flagf=true;
	
	
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			if(f.user_check_board[i][j]==0)
			{
				return;
			}
			
		}
	}
	
	
	System.out.println("n is "+n);
	System.out.println(f.game_procces_counting+" grame count");
	f.draw_rate++;
	System.out.println("drawww");
	
	double total=f.com_rate+f.draw_rate+f.user_rate;
	double rate=Math.round((((double)f.user_rate/total)*10000.0))/100.0;
	
	Filewrite(f);
	dailog kr=new dailog(f,"<html>"+"게임종료 !!!<br>"+"user 님은 현재 "+f.user_rate+"승 "+f.com_rate+"패 "+f.draw_rate+"무 ("+rate+"%) 입니다"+"</html>",-1);
	kr.setVisible(true);
	
}





	//대각선체크!!
	
}

void Filewrite(Frame f)
{
	try {
		//파일 내용 초기화
		
		
		// other operations
		
		FileWriter fw = new FileWriter(f.file);
		
		
		PrintWriter writer=new PrintWriter(fw);
		writer.print("");
		
		writer.println(f.user_rate);
		writer.println(f.com_rate);
		writer.println(f.draw_rate);
		System.out.println("write complete");
		writer.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}


void check_text(String text,int n,Frame f) {
	
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			Word next_check=f.voc.voc.get(f.user_board[i][j]);
			if(next_check.eng.equals(text)&& f.user_check_board[i][j]==0)
			{
				//정답쓰
				text_cor.setText("정답입니다   " +next_check.eng+" 뜻은 : "+next_check.kor);
				label[i][j].setText("O");
				label[i][j].setBackground(Color.blue);
				f.user_check_board[i][j]=1;
				
				//dailog kr=new dailog(f,"<html>"+next_check.eng+" 뜻은 : "+next_check.kor+" 입니다"+"<br>"+"컴퓨터는 ***을 골랐습니다!"+"</html>");
				//kr.setVisible(true);
				f.game_procces_counting++;
				
				//유저가 셋팅한거 컴퓨터 체크
				check_text_com(text,n,f);
				
				
				//컴퓨터 턴
				Word word=computer_turn(n ,f);
				dailog kr=new dailog(f,"<html>"+"Computer는 "+word.eng+"을 골랐습니다"+"</html>");
				kr.setVisible(true);
				check_bingo_cnt(n,f);
				return;
			}
			
			
		}
		
	}
	
	//오답
	Word word=computer_turn(n ,f);
	check_bingo_cnt(n,f);
	dailog kr=new dailog(f,"<html>"+"잘못 입력하셨습니다 !<br> Computer에게 TURN이 넘어갑니다.<br>"
			+ "Computer는 "+word.eng+"을 골랐습니다"+"</html>");
	kr.setVisible(true);
	text_cor.setText("빙고 단어를 입력해주세요 !");
	
	
}
	
	
	user_ui(Frame f){
		label=new JLabel[f.number][f.number];
		//f.setSize(700,700);
		System.out.println("000000000");
		System.out.println(f.number+"입니다");
		setLayout(new BorderLayout());
	
		
		JLabel k2=new JLabel("현황판2");
		
		JPanel top_panel=new JPanel();
		top_panel.setLayout(new BorderLayout());
		JLabel k=new JLabel("User 현황판");
		top_panel.add(k,BorderLayout.CENTER);
		JButton btn=new JButton("Computer 화면이동");
		
		btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				f.changePanel(f);
			}
			
			});
		top_panel.add(btn,BorderLayout.EAST);
		
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
				Word sk=f.voc.voc.get(f.user_board[i][j]);
				
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
	   
	   text_input.addActionListener(new ActionListener() {
		   @Override
		    public void actionPerformed(ActionEvent e)
		    {
			   
			   check_text(text_input.getText(),f.number,f);
			   text_input.setText("");
		      //  System.out.println(text_input.getText());
		    }
	   });
	   
	   text_panel.add(text_input,BorderLayout.SOUTH);
	   text_panel.add(text_cor,BorderLayout.NORTH);
		
		add(word_panel,BorderLayout.CENTER);
		add(text_panel,BorderLayout.SOUTH);
		
           
		
	}

}
