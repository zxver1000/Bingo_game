package test1123;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map.Entry;

import test1123.Word;

import java.util.Scanner;
import java.util.Vector;



public class VocManager {
	private String userName;

	private HashMap<Integer,Word> voc_arry=new HashMap<Integer,Word>();
	private int number = 0;
    private int num=0;
    public List<Word>voc=new ArrayList<Word>();
	static Scanner scan = new Scanner(System.in);
	
	
	
	
	public VocManager(String userName){
		this.userName = userName;
	}
	
	public VocManager(){
	
	}
	
	
	void addWord(Word word) {
		voc_arry.put(num, word);
		voc.add(word);
		num++;
	}
	
	
	void n() {
	System.out.println("totla "+num);
	}
	
void makeVoc(String fileName) {
	while(true)
	{
		
		try(Scanner scan = new Scanner(new File(fileName))){
			while(scan.hasNextLine()) {
				String eng = scan.nextLine();
				String kor = scan.nextLine();
				this.addWord(new Word(eng,kor));
			}
			System.out.println(userName+"의 단어장이 생성되었습니다.");
		
			//this.menu();
			break;
		}catch(FileNotFoundException e) {
			//파일명 입력틀렷을시 다시
			System.out.println(userName+"의 단어장이 생성되지 않았습니다. \n파일명을 확인하세요.");
			System.out.print("파일명을 다시입력하세요 : ");
			fileName=scan.next();
			
		}catch(Exception e)
		{
			System.out.println("에러코드 : "+e);
		}
		
	}
	}





	
}
