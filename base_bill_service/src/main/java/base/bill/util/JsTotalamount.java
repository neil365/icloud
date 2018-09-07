package base.bill.util;

import java.util.Scanner;

/**
 * 计算总金额工具类
 * @author Administrator
 * @创建人wangp
 * @创建时间2018-08-13
 */
public class JsTotalamount {
	private static void main(String args) {
		Scanner sc=new Scanner(System.in);
		//获取页面输入的数量
		int num=sc.nextInt();
		//获取页面输入的金额
		int money=sc.nextInt();
		//计算总金额
		int totalamount=num*money;
	}
}
