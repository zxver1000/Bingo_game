package test1123;

public class Word  implements Comparable<Word>{

	
	public String eng;
	public String kor;
	public int real_cnt=0;
	public int error_int=0;
	public Word(String eng, String kor) {
		super();
		this.eng = eng;
		this.kor = kor;
	}
	
	
	
	@Override
	public String toString() {
		
		System.out.println(this.eng+" 뜻 : "+this.kor);
		System.out.println("출제 횟수 : "+this.real_cnt+"       오답횟수 : "+this.error_int);
		System.out.println("----------------------------------");
		return "";
	}



	@Override
	public int compareTo(Word o) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
	
}
