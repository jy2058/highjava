package basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/*
 * 이름, 주소, 전화번호 속성을 갖는 Phone클래스를 만들고, 이 Phone클래스를 이용하여 
  전화번호 정보를 관리하는 프로그램을 완성하시오.
  이 프로그램에는 전화번호를 등록, 수정, 삭제, 검색, 전체출력하는 기능이 있다.
  
  전체의 전화번호 정보는 Map을 이용하여 관리한다.
  (key는 '이름'으로 하고 value는 'Phone클래스의 인스턴스'로 한다.)


실행예시)
===============================================
   전화번호 관리 프로그램(파일로 저장되지 않음)
===============================================

  메뉴를 선택하세요.
  1. 전화번호 등록
  2. 전화번호 수정
  3. 전화번호 삭제
  4. 전화번호 검색
  5. 전화번호 전체 출력
  0. 프로그램 종료
  번호입력 >> 1  <-- 직접 입력
  
  새롭게 등록할 전화번호 정보를 입력하세요.
  이름 >> 홍길동  <-- 직접 입력
  전화번호 >> 010-1234-5678  <-- 직접 입력
  주소 >> 대전시 중구 대흥동 111  <-- 직접 입력
  
   메뉴를 선택하세요.
  1. 전화번호 등록
  2. 전화번호 수정
  3. 전화번호 삭제
  4. 전화번호 검색
  5. 전화번호 전체 출력
  0. 프로그램 종료
  번호입력 >> 5  <-- 직접 입력
  
  =======================================
  번호   이름       전화번호         주소
  =======================================
   1    홍길동   010-1234-5678    대전시
   ~~~~~
   
  =======================================
  출력완료...
  
  메뉴를 선택하세요.
  1. 전화번호 등록
  2. 전화번호 수정
  3. 전화번호 삭제
  4. 전화번호 검색
  5. 전화번호 전체 출력
  0. 프로그램 종료
  번호입력 >> 0  <-- 직접 입력
  
  프로그램을 종료합니다...

 */
public class Phone181110 {
	HashMap<String, Phone> map = new HashMap<String, Phone>();
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Phone181110 phone = new Phone181110();
		boolean isContinue = true;
		while (isContinue) {

			System.out.println("===========================================");
			System.out.println("      전화번호 관리 프로그램(파일로 저장되지 않음");
			System.out.println("===========================================");
			System.out.println();
			System.out.println("메뉴를 선택하세요.");
			System.out.println("1. 전화번호 등록");
			System.out.println("2. 전화번호 수정");
			System.out.println("3. 전화번호 삭제");
			System.out.println("4. 전화번호 검색");
			System.out.println("5. 전화번호 전체 출력");
			System.out.println("0. 프로그램 종료");
			System.out.print("번호 입력 >> ");
			
			int input = s.nextInt();
			
			switch (input) {
			case 1:
				phone.join();
				break;
			case 2:
				phone.change();
				break;
			case 3:
				phone.remove();
				break;
			case 4:
				phone.search();
				break;
			case 5:
				phone.view();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다...");
				System.exit(0);
			default:
				System.out.println("잘못된 입력 입니다.");
				isContinue = false;
			}
		}
	}

	//전화번호 등록 메서드
	void join() {
		Phone user = new Phone();
		Scanner s = new Scanner(System.in);
		
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요");
		System.out.print("이름 >> ");
		user.setName(s.nextLine());
		System.out.print("전화번호 >> ");
		user.setNumber(s.nextLine());
		System.out.print("주소 >> ");
		user.setAdd(s.nextLine());
		
		map.put(user.name, user);
		
	}
	//전화번호 수정 메서드
	void change() {
		
		Phone user = new Phone();
		Scanner s = new Scanner(System.in);
		
		System.out.println("수정할 번호의 이름을 입력하세요 >> ");
		String inputName = s.nextLine();
		
			if(map.containsKey(inputName)) {	//map의 키 값과 입력받은 이름이 같으면.
				System.out.println("현재 전화번호 : " + map.get(inputName).number);
				System.out.print("새로운 전화번호를 입력하세요 >> ");
				String newNumber = s.nextLine();
				
				String copyAdd = map.get(inputName).add;	//인스턴스를 새로 만들어서 저장하기 때문에 주소가 사라진다. 그래서 기존 인스턴스에서 가져와 새로 저장
				user.setAdd(copyAdd);
				user.setNumber(newNumber);
				map.put(inputName, user);	//map은 키값이 동일하면 value가 덮어쓰기 됨.
				
				System.out.println("변경이 완료 되었습니다.");
				System.out.println("이름 : " + inputName + " 전화번호 : " + map.get(inputName).number);
			}else
				System.out.println("일치하는 정보가 없습니다.");
		}
		
	//전화번호 삭제 메서드
	void remove() {
		Scanner s = new Scanner(System.in);
		System.out.println("삭제할 번호의 이름을 입력하세요 >> ");
		String inputName = s.nextLine();
	
		if(map.containsKey(inputName)){
			System.out.println("이름 : " + inputName + " 전화번호 : " + map.get(inputName).number);
			System.out.println("!!!!! 정말 삭제하시겠습니까? !!!!!  [ Y | N ]");
			String inputCheck = s.nextLine();
			
			if(inputCheck.equalsIgnoreCase("y")) {
				map.remove(inputName);
				System.out.println("삭제 되었습니다.");
			}else
				System.out.println("취소되었습니다.");
		}else
			System.out.println("일치하는 정보가 없습니다.");
		
		
	}
	//전화번호 검색 메서드
	void search() {
		Scanner s = new Scanner(System.in);
		System.out.println("이름을 입력하세요 >> ");
		String inputName = s.nextLine();
	
		if(map.containsKey(inputName)){
			System.out.println("전화번호 : " + map.get(inputName).number);
		}else
			System.out.println("일치하는 정보가 없습니다.");
	
	}
	//전화번호 전체 출력 메서드
	void view() {
		Set<String> keys = map.keySet();
		Iterator<String> itr = keys.iterator();
		int i = 1;
		
		System.out.println("===========================================");
		System.out.println("번호\t이름\t전화번호\t\t주소");
		System.out.println("===========================================");
		
		while (itr.hasNext()) {
			String name = itr.next();
			String number = map.get(name).number;	//map.get(name) -> 'name' 키 값의 인스턴스 가져오기/ .number -> 그 인스턴스의 number 가져옴.
			String add = map.get(name).add;
			
			System.out.print(i+"\t");
			System.out.print(name+"\t");
			System.out.print(number+"\t");
			System.out.println(add);
			
			i++;
		}
		System.out.println("===========================================");
	}
}

class Phone{
	
	String name;
	String add;
	String number;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
}
