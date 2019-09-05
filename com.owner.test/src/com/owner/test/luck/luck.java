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
			
			System.out.println("\n*****欢迎进入奖客富翁系统*****");
			System.out.println("\t 1.注册");
			System.out.println("\t 2.登陆");
			System.out.println("\t 3.抽奖");
			System.out.println("******************************\n");
			System.out.print("请选择菜单：");
			
			try {
				choice = input.nextInt();
			} catch (Exception e) {
				System.out.println("您的输入有误");
				break;
			}
			
			switch(choice) {
				case 1 :
					System.out.println("[奖客富翁系统>注册]");
				    System.out.println("请填写个人注册信息");
				    System.out.print("用户名：");
				    username = input.next();
				    
				    System.out.print("密码：");
				    password = input.next();
				    
				    System.out.println("注册成功，请记好您的会员卡号");				
				    System.out.println("用户名\t"+"密码\t"+"会员卡号");
				    
				    cardno = new Random().nextInt(9999-1000)+1000;
				    System.out.println(username + "\t" + password + "\t" + cardno);
				    
				    isRegister = true;
					break;
					
				case 2 :
					System.out.println("[奖客富翁系统>登陆]");
					if(isRegister) {
						
						for (int i = 1; i <= 3; i++) {
							System.out.print("请输入用户名：");
							String inputUsername = input.next();
							System.out.print("请输入密码：");
							String inputPassword = input.next();
							
							if(username.equals(inputUsername) && password.equals(inputPassword)) {
								
								System.out.println("欢迎您："+inputUsername);
								isLogin = true;
								break;
								
							}else if (i < 3) {
								System.out.println("用户名或者密码错误，还有"+(3-i)+"机会"+"\n");
							}else {
								System.out.println("您3次均输入错误");
							}
						}
					}else {
						System.out.println("请先注册，再登陆");
					}
					break;
					
				case 3 :
					System.out.println("[奖客富翁系统>抽奖]");
					if(isLogin) {
						int[] luckNum = new int[10];
						for (int i = 0; i < luckNum.length; i++) {
							luckNum[i] = new Random().nextInt(9999-1000)+1000;
						}
						
						System.out.print("请输入你的卡号:");
						int yourCardno = input.nextInt();
						
						System.out.println("\n本日的幸运数字为：");
						for (int i = 0; i < luckNum.length; i++) {
							System.out.println(luckNum[i]);
						}
						
						int i = 0;
						for (i = 0; i < luckNum.length; i++) {
							if(yourCardno == luckNum[i]) {
								System.out.println("\n恭喜!您是本日的幸运会员!");
								break;
							}
						}
						
						if(i == luckNum.length) {
							System.out.println("\n抱歉!您不是本日的幸运会员!");
						}
						
						
					}else {
						 System.out.println("请先登录，再抽奖!");
						 System.out.println("继续吗？（y/n）");
						 continueChoice = input.next();
					}
					
					break;
					
					default:
				        System.out.println("您的输入有误");
				        break;
			}
			
			System.out.println("继续吗？（y/n）：");
			continueChoice = input.next();
			
		}while("y".equals(continueChoice));
		
		if("n".equals(continueChoice)){
			
			System.out.println("系统退出，谢谢使用!");
			
		}
			
	}

}
