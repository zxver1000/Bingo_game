package test1123;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.JTextField;



public class Frame extends JFrame{

	private CardLayout cards = new CardLayout();
	int number=0;
	public int[][] user_board;
	public int[][] computer_borad;
	public int[][] user_check_board;
	public int[][] computer_check_board;
	public computer_ui com_ui;
	
	public VocManager voc=new VocManager("11");
	public File file;
	public int com_rate=0;
	public int com_bingo=0;
	public int user_bingo=0;
	public int user_rate=0;
	public int draw_rate=0;
	
	public int game_procces_counting=0;
	
	
	
	void board_setting() {
		
		System.out.println("201814115 고현호");
		
		
			try {
				file=new File("rate.txt");
				
				if(!file.exists())
				{
					file.createNewFile();
					//FileWriter fw=new FileWriter(file);
					//PrintWriter writer=new PrintWriter(fw);
					//writer.println("0");
					//writer.println("0");
					user_rate=0;
					//writer.close();
					com_rate=0;
					draw_rate=0;
				}
				else
				{
					//파일잇음
					System.out.println("file exist");
					int idx=0;
					try(Scanner scan = new Scanner(new File("rate.txt"))){
						user_rate=Integer.parseInt(scan.nextLine());
						com_rate=Integer.parseInt(scan.nextLine());
						draw_rate=Integer.parseInt(scan.nextLine());
						
						System.out.println("user : "+user_rate);
						System.out.println("com : "+com_rate);
						System.out.println("draw : "+draw_rate);
						
					}catch(Exception e)
					{
						
					}
					
				}
			
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
	  
		
		
		int[] arr1=new int[number*number];
		int[] arr2=new int[number*number];
		for(int i=0;i<number*number;i++)
		{
			//개수제한 1~150개 있음

			int p=(int)(Math.random()*(149));
			arr1[i]=p;
			for(int j=0;j<i;j++)
			{
				if(arr1[i]==arr1[j])
				{
					i--;
					break;
				}
				
				
			}
				
		}
		
		for(int i=0;i<number*number;i++)
		{
			//개수제한 1~150개 있음

			int p=(int)(Math.random()*(149));
			arr2[i]=p;
			for(int j=0;j<i;j++)
			{
				if(arr2[i]==arr2[j])
				{
					i--;
					break;
				}
				
				
			}
				
		}
		
		
		for(int i=0;i<number;i++)
		{
			for(int j=0;j<number;j++)
			{
				user_board[i][j]=arr1[i*number+j];
				computer_borad[i][j]=arr2[i*number+j];
			}
		}
		
		
		
		
	}
	
	
	
	public Frame() {
		
		setSize(330, 120);
		voc.makeVoc("1");
		//voc.n();
		getContentPane().setLayout(cards);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
      
      
      
      getContentPane().add("One", new start_ui(this));
	//getContentPane().add("Two", new user_ui(this));
		
		setVisible(true);
  
	
		
	}
	
	public void changePanel(Frame f) {
		
		if(f.getContentPane().getComponentCount()>2)
		{
			f.getContentPane().remove(0);
		}
		
		cards.next(this.getContentPane());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new Frame();
	}

}
