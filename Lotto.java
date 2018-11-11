package basic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/*
 *  로또를 구매하는 프로그램 작성하기
 
 사용자는 로또를 구매할 때 구매할 금액을 입력하고
 입력한 금액에 맞게 로또번호를 출력한다.
 (단, 로또 한장의 금액은 1000원이고 거스름돈도 계산하여
      출력한다.)

	==========================
         Lotto 프로그램
	--------------------------
	 1. Lotto 구입
	  2. 프로그램 종료
	==========================		 
	메뉴선택 : 1  <-- 입력
			
	 Lotto 구입 시작
		 
	(1000원에 로또번호 하나입니다.)
	금액 입력 : 2500  <-- 입력
			
	행운의 로또번호는 아래와 같습니다.
	로또번호1 : 2,3,4,5,6,7
	로또번호2 : 20,21,22,23,24,25
			
	받은 금액은 2500원이고 거스름돈은 500원입니다.
			
   	 ==========================
         Lotto 프로그램
	--------------------------
	  1. Lotto 구입
	  2. 프로그램 종료
	==========================		 
	메뉴선택 : 2  <-- 입력
		
	감사합니다
 */
public class Lotto {

	int[] ran = new int[6];

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean flag = true;
		Lotto user = new Lotto();

		while (flag) {
			System.out.println("=======================================");
			System.out.println("            LOTTO 프로그램 ");
			System.out.println("---------------------------------------");
			System.out.println(" 1. Lotto 구입 ");
			System.out.println(" 2. 프로그램 종료 ");
			System.out.println("=======================================");
			System.out.print(" 메뉴 선택 : ");

			int input = s.nextInt();

			switch (input) {
			case 1: // 로또 구입
				user.buyLotto();
				break;
			case 2: // 종료
				System.out.println(" 감사합니다 ");
				System.exit(0);
				flag = false;
				break;
			default:
				System.out.println("잘못 된 입력입니다.");
				break;
			}
		}
	}

	public void buyLotto() {
		Scanner s = new Scanner(System.in);
		System.out.println(" 로또 구입 시작 ");
		System.out.println(" (1000원에 로또번호 하나 입니다.) ");
		System.out.print(" 금액 입력 : ");
		int input = s.nextInt();

		if (input >= 1000) {

			int num = input / 1000;
			int change = input % 1000;

			System.out.println(" 행운의 로또 번호는 아래와 같습니다. ");
			for (int i = 0; i < num; i++) {
				random();	// 랜덤 값 받기 위한 메서드 i 만큼 호출
				System.out.print("로또번호" + (i + 1) + " : ");
				for (int j = 0; j < ran.length; j++) {	// 배열의 각 인덱스의 값 출력
					System.out.print(j == 5 ? ran[j] : ran[j] + ","); // 마지막 값엔 쉼표 안 나오게
				}
				System.out.println();
			}
			System.out.println(" 받은 금액은 " + input + "원이고 거스름돈은 " + change + "원 입니다.");
		} else {
			System.out.println("금액이 부족합니다 ");
			return;
		}
	}

	// 랜덤 값 만들어 주는 메서드
	public void random() {

		Set<Integer> hashRandom = new HashSet<>();
		while (hashRandom.size() < 6) {
			hashRandom.add((int) (Math.random() * 45) + 1);
		}
		// 배열에 저장
		Iterator<Integer> iterRandom = hashRandom.iterator();

		int i = 0;	// 배열의 첨자 역할
		while (iterRandom.hasNext()) {
			ran[i++] = iterRandom.next();
		}
	}

}
