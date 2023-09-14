package s21204_java_getset;

import java.util.Scanner;

class People {
	private String name;		// 성명
	private int kor;			// 국어
	private int eng;			// 영어
	private int math;			// 수학
	private int sum;			// 합계
	private double avg;			// 평균
	private int rank;			// 석차
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getSum() {
		return getKor() + getEng() + getMath();
	}
	public double getAvg() {
		return  (double)getSum() / 3;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	void printScore() {
		System.out.printf(" %3s %3d %3d %3d %3d %3.2f %3d \n",
				this.getName(),this.getKor(),this.getEng(),this.getMath(),this.getSum(),this.getAvg(),this.getRank() );
	}
}
public class S21204_GetSet_Insert {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("몇명의 성적처리를 하나요(숫자입력)? ");
		int num = input.nextInt();
		
		// 객체배열 선언
		People stu[] = new People[num];
		
		// 객체배열 초기화
		for (int i=0; i<stu.length; i++) {
			stu[i] = new People();
		}
		// 키보드 데이터입력
		for(int i=0; i<stu.length; i++) {
			System.out.print("성명을 입력하세요: ");
			stu[i].setName(input.next());
			System.out.print("국어 점수를 입력하세요: ");
			stu[i].setKor(input.nextInt());
			System.out.print("영어 점수를 입력하세요: ");
			stu[i].setEng(input.nextInt());
			System.out.print("수학 점수를 입력하세요: ");
			stu[i].setMath(input.nextInt());
		}
		// 석차 처리
		for (int i=0; i<stu.length; i++) {
			int rank=1;
			for (int j=0; j<stu.length; j++) {
				if(stu[i].getSum() < stu[j].getSum()) rank++;
			}
			stu[i].setRank(rank);
		}
		
		System.out.println("==================출력==================");
		System.out.printf("%3s %3s %2s %2s %3s %3s %4s \n","성명","국어","영어","수학","합계","평균","석차");
		// System.out.println("성명   국어   영어   수학   합계   평균   석차");
		for (int i=0; i<stu.length; i++) {
			stu[i].printScore();
		}
	}
}
