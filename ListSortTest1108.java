package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest1108 {

   public static void main(String[] args) {
      ArrayList<Student> studentList = new ArrayList<>();
      
      studentList.add(new Student(1, "박선희", 60, 80, 91));
      studentList.add(new Student(4, "김지연", 60, 80, 91));
      studentList.add(new Student(2, "황수정", 75, 80, 81));
      studentList.add(new Student(5, "이한화", 80, 80, 81));
      studentList.add(new Student(3, "김난경", 60, 80, 91));
      studentList.add(new Student(6, "황금옥", 70, 50, 60));
      studentList.add(new Student(7, "김솔이", 70, 50, 60));
      studentList.add(new Student(8, "박까미", 50, 65, 60));
      
      System.out.println("정렬 전");
      for (Student student : studentList) {
         System.out.println(student);
      }

      System.out.println("=================================================================");
      
      Collections.sort(studentList);   // 정렬하기
      
      System.out.println("학번의 오름차순으로 정렬 후");
      for(Student student : studentList) {
         System.out.println(student);
      }

      System.out.println("=================================================================");
      
      // 외부 정렬 기준을 이용한 정렬하기
      Collections.sort(studentList, new SortTotalDesc());
      
      // 총점 내림차순 정렬을 이용한 석차 구하기
      int count = 1;
      studentList.get(0).setRank(count);
      Student temp = studentList.get(0);
      for (int i = 1; i < studentList.size(); i++) {
         if (temp.getTotal() == studentList.get(i).getTotal()) {
            count++;
            studentList.get(i).setRank(temp.getRank());
            temp = studentList.get(i);
         }
         else if (temp.getTotal() > studentList.get(i).getTotal()) {
            count++;
            studentList.get(i).setRank(count);
            temp = studentList.get(i);
         }
      }
      
      System.out.println("총점의 내림차순으로 정렬 후");
      for(Student student : studentList) {
         System.out.println(student);
      }
   }

}

// 총점(total)의 내림차순으로 정렬 (총점이 같으면 학번의 내림차순으로 정렬)
class SortTotalDesc implements Comparator<Student> {

   @Override
   public int compare(Student s1, Student s2) {
      if (s1.getTotal() > s2.getTotal()) {
         return -1;
      }
      else if (s1.getTotal() == s2.getTotal()) {
         return Integer.compare(s1.getNum(), s2.getNum()) * -1;
      }
      else {
         return 1;
      }
   }
   
}

class Student implements Comparable<Student> {
   private int num;
   private String name;
   private int kor;
   private int eng;
   private int math;
   private int total;
   private int rank;
   
   public Student(int num, String name, int kor, int eng, int math) {
      super();
      this.num = num;
      this.name = name;
      this.kor = kor;
      this.eng = eng;
      this.math = math;
      this.total = kor + eng + math;
   }

   public int getNum() {
      return num;
   }

   public void setNum(int num) {
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

   @Override
   public String toString() {
      return "Student [학번:" + num + ", 이름:" + name + ", 국어:" + kor + ", 영어:" 
            + eng + ", 수학:" + math + ", 총점:" + total + ", 석차:" + rank + "]";
   }
   
   // 학번(num)의 오름차순으로 정렬
   @Override
   public int compareTo(Student student) {
      return Integer.compare(getNum(), student.getNum());
   }
   
}