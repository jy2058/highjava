package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는
	  Student클래스를 만든다.
	  생성자는 학번, 이름, 국어, 영어, 수학 점수만 매개변수로 받아서 처리한다.
	  
	  이 Student객체들은 List에 저장하여 관리한다.
	  List에 저장된 데이터들을 학번의 오름차순으로 정렬하여 출력하는 부분과
	  총점의 역순으로 정렬하는 부분을 프로그램 하시오.
	  (총점이 같으면 학번의 내림차순으로 정렬되도록 한다.)
	  (학번 정렬기준은 Student클래스 자체에서 제공하도록 하고,
	   총점 정렬기준은 외부클래스에서 제공하도록 한다.)
 */
public class StudentClass {
	public static void main(String[] args) {
		
		// 학생 정보 추가
		StudentClass stdTest = new StudentClass();
		ArrayList<Student1> stdList = new ArrayList<>();
		
		stdList.add(new Student1("201801", "김지연", 90, 95, 80));
		stdList.add(new Student1("201803", "박까미", 90, 75, 70));
		stdList.add(new Student1("201807", "황수정", 95, 95, 80));
		stdList.add(new Student1("201805", "김난경", 80, 95, 90));
		stdList.add(new Student1("201802", "꼬롱이", 100, 85, 80));
		stdList.add(new Student1("201804", "이한화", 60, 65, 60));
		stdList.add(new Student1("201806", "김솔", 90, 100, 90));
		
		stdTest.setRanking(stdList);	//등수를 구하는 메서드 호출
		
	      System.out.println("정렬 전------------------------------------------------------------------------");
	      for(Student1 std : stdList) {
	         System.out.println(std);
	      }
	      System.out.println("=============================================================================");
	      
	      //학번의 오름차순으로 정렬
	      Collections.sort(stdList);
	      System.out.println("학번의 오름차순으로 정렬 후...");
	      for(Student1 std : stdList) {
	         System.out.println(std);
	      }
	      System.out.println("=============================================================================");
	      
	      
	      //총점의 내림차순으로 정렬하기
	      Collections.sort(stdList, new SortByTotal()); //직접 정의한 정렬 메서드
	      System.out.println("총점의 내림차순 정렬 후...");
	      for(Student1 std : stdList) {
	         System.out.println(std);
	      }
	      System.out.println("=============================================================================");
	}
	/*
	 * 등수를 처리하는 메서드
	 */
	public void setRanking(List<Student1> stdList) {
		for(Student1 std : stdList) {	//std에 모든 학생의 등수를 1등으로 초기화
			int rank = 1;
			for(Student1 std2 : stdList) {
				if(std.getTotal() < std2.getTotal()) { // 1등으로 초기화 된 학생들과 모든 학생의 점수를 비교
					rank++;	// 비교 대상보다 점수가 작으면 등수를 +1 한다.
				}
			}
			std.setRank(rank);	// 비교하여 더한 등수를 저장한다. 
		}
	}
}

//정의된 정렬 메서드를 사용하기 위해 Comparable 인터페이스 이용
class Student1 implements Comparable<Student1>{
	private String num;	//학번
	private String name; //이름
	private int kor;	//국어점수
	private int eng;	//영어점수
	private int math;	//수학점수
	private int total; 	//총점
	private int rank;	//순위
	
	public Student1(String num, String name, int kor, int eng, int math) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	/*
	 * 학번을 기준으로 오름차순이 되도록 설정하기
	 */
	@Override
	public int compareTo(Student1 std) {	//Comparable에 오버로딩 되는 메서드
		
		return num.compareTo(std.getNum());
	}
	
	/*
 	 * 화면에 학생정보 출력 포맷을 정의함
	 */
	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math
				+ ", total=" + total + ", rank=" + rank + "]";
	}
	
}
/*
 * 총점의 역순으로 정렬하는 데 총점이 같으면 학번의 내림차순으로 정렬되도록 한다.
 */

class SortByTotal implements Comparator<Student1>{

	@Override
	public int compare(Student1 std1, Student1 std2) {
		if(std1.getTotal() == std2.getTotal()) { // 같을 때 
			return std1.getNum().compareTo(std2.getNum()) * -1;
		}else {	//같지 않을때 그냥 내림차순으로 정렬
			return Integer.compare(std1.getTotal(), std2.getTotal()) * -1;
		}
	}
	
}