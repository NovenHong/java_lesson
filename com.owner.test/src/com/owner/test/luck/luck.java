package com.owner.test.luck;

import java.util.Random;
import java.util.Scanner;

public class luck {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String username = null;
		String password = null;
		int cardno = 0000;
		boolean isRegister = false;
		boolean isLogin = false;
		String continueChoice = "n";
		int choice = 0;
		
		do {
			
			System.out.println("\n*****��ӭ���뽱�͸���ϵͳ*****");
			System.out.println("\t 1.ע��");
			System.out.println("\t 2.��½");
			System.out.println("\t 3.�齱");
			System.out.println("******************************\n");
			System.out.print("��ѡ��˵���");
			
			try {
				choice = input.nextInt();
			} catch (Exception e) {
				System.out.println("������������");
				break;
			}
			
			switch(choice) {
				case 1 :
					System.out.println("[���͸���ϵͳ>ע��]");
				    System.out.println("����д����ע����Ϣ");
				    System.out.print("�û�����");
				    username = input.next();
				    
				    System.out.print("���룺");
				    password = input.next();
				    
				    System.out.println("ע��ɹ�����Ǻ����Ļ�Ա����");				
				    System.out.println("�û���\t"+"����\t"+"��Ա����");
				    
				    cardno = new Random().nextInt(9999-1000)+1000;
				    System.out.println(username + "\t" + password + "\t" + cardno);
				    
				    isRegister = true;
					break;
					
				case 2 :
					System.out.println("[���͸���ϵͳ>��½]");
					if(isRegister) {
						
						for (int i = 1; i <= 3; i++) {
							System.out.print("�������û�����");
							String inputUsername = input.next();
							System.out.print("���������룺");
							String inputPassword = input.next();
							
							if(username.equals(inputUsername) && password.equals(inputPassword)) {
								
								System.out.println("��ӭ����"+inputUsername);
								isLogin = true;
								break;
								
							}else if (i < 3) {
								System.out.println("�û�������������󣬻���"+(3-i)+"����"+"\n");
							}else {
								System.out.println("��3�ξ��������");
							}
						}
					}else {
						System.out.println("����ע�ᣬ�ٵ�½");
					}
					break;
					
				case 3 :
					System.out.println("[���͸���ϵͳ>�齱]");
					if(isLogin) {
						int[] luckNum = new int[10];
						for (int i = 0; i < luckNum.length; i++) {
							luckNum[i] = new Random().nextInt(9999-1000)+1000;
						}
						
						System.out.print("��������Ŀ���:");
						int yourCardno = input.nextInt();
						
						System.out.println("\n���յ���������Ϊ��");
						for (int i = 0; i < luckNum.length; i++) {
							System.out.println(luckNum[i]);
						}
						
						int i = 0;
						for (i = 0; i < luckNum.length; i++) {
							if(yourCardno == luckNum[i]) {
								System.out.println("\n��ϲ!���Ǳ��յ����˻�Ա!");
								break;
							}
						}
						
						if(i == luckNum.length) {
							System.out.println("\n��Ǹ!�����Ǳ��յ����˻�Ա!");
						}
						
						
					}else {
						 System.out.println("���ȵ�¼���ٳ齱!");
						 System.out.println("�����𣿣�y/n��");
						 continueChoice = input.next();
					}
					
					break;
					
					default:
				        System.out.println("������������");
				        break;
			}
			
			System.out.println("�����𣿣�y/n����");
			continueChoice = input.next();
			
		}while("y".equals(continueChoice));
		
		if("n".equals(continueChoice)){
			
			System.out.println("ϵͳ�˳���ллʹ��!");
			
		}
			
	}

}
