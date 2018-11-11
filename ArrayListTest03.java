package basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest03 {
	public static void main(String[] args) {
		// 문제1) 5명의 별명을 입력하여 ArrayList에 저장하고 별명의 길이가 제일 긴 별명을 출력하시오.
		//		(단, 각 별명의 길이는 모두 다르게 입력한다.)
		// 문제 2) 문제 1에서 별명의 길이가 같은 것을 여러 개 입력했을 때도 처리되도록 하시오.
		
		/*
		 * 
		//내 코드
		ArrayList<String> array = new ArrayList<String>();
		int max = 0;
		int temp = 0;
		int index = 0;
		Scanner s = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.print("별명을 입력 하세요 > ");
			String name = s.nextLine();
			array.add(name);
		}
		for (int i = 0; i < array.size(); i++) {
			temp = array.get(i).length();
			if (temp > max) {
				max = temp;
				index = i;
			}

		}
		System.out.println(array.get(index));
		
		*/
		
		//선생님 코드
		//문제1)
		ArrayList<String> aliasList = new ArrayList<>();
		Scanner scan = new Scanner(System.in);

		System.out.println("서로 다른 길이의 별명 5개를 입력하세요.");
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + " 번째 별명 : ");
			String alias = scan.next();
			aliasList.add(alias);
		}

		// maxAlias는 제일 긴 별명이 저장 될 변수
		String maxAlias = aliasList.get(0);

		for (int i = 1; i < aliasList.size(); i++) {
			if (maxAlias.length() < aliasList.get(i).length()) {
				maxAlias = aliasList.get(i);
			}
		}

		System.out.println("제일 긴 별명 : " + maxAlias);

		// 문제 2)
		System.out.println("별명 5개를 입력하세요.");
		for (int i = 1; i <= 5; i++) {
			System.out.println(i + "번째 별명 : ");
			String alias = scan.next();
			aliasList.add(alias);
		}
		// maxLen은 제일 긴 별명의 길이를 저장하는 변수
		int maxLen = aliasList.get(0).length();
		//첫번째꺼를 가져와서 max에 넣어놨으니까 1부터 시작한다
		for (int i = 1; i < aliasList.size(); i++) {
			if (maxLen < aliasList.get(i).length()) {
				maxLen = aliasList.get(i).length();
			}
		}

		System.out.println("제일 긴 별명 들");
		for (int i = 0; i < aliasList.size(); i++) {
			if(aliasList.get(i).length() == maxLen) {
			System.out.println(aliasList.get(i));
			}
		}
	}

}
