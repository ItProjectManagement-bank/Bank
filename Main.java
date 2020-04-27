package cn.sdut.main;

import java.util.List;
import java.util.Scanner;

import cn.sdut.dao.AccountDao;
import cn.sdut.po.Account;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int op;
		System.out.println("**银行管理系统");
		System.out.println("1-开户 2-销户 3-存钱 4-取钱 5-转账 6-显示全部 0-退出");
		while ((op = sc.nextInt()) != 0) {
			
			AccountDao dao=new AccountDao();
			switch (op) {
			case 1:// 开户
				System.out.println("请输入账户名称和初始金额");
				String name1=sc.next();
				double initMoney=sc.nextDouble();
				
				Account account=new Account(0,name1, initMoney);
				int result=dao.addAccount(account);
				if(result==1)
				{
					System.out.println("开户成功!");
				}
				
				break;
			case 2:// 销户
				System.out.println("请输入要注销的账户id");
				int id5=sc.nextInt();
				int delAccount = dao.delAccount(id5);
				if(delAccount==1)
				{
					System.out.println("销户成功!");
				}
				break;

			case 3:// 存钱
				System.out.println("请输入账户id和存入金额");
				int id=sc.nextInt();
				double change=sc.nextDouble();
				int update1=dao.updateAccountMoney(id, change);
				if(update1==1)
				{
					System.out.println("存入成功！");
				}
				break;
			case 4:// 取钱
				System.out.println("请输入账户id和取钱金额");
				int idqv=sc.nextInt();
				double changeqv=sc.nextDouble();
				int updateqv=dao.updateAccountMoney(idqv, changeqv);
				if(updateqv==1)
				{
					System.out.println("取钱成功！");
				}
				break;
			case 5:// 转账
				System.out.println("请输入转出账户，转入账户和转账金额");
				int idOut=sc.nextInt();
				int idIn=sc.nextInt();
				double change1=sc.nextDouble();
				int turnMoney = dao.turnMoney(idOut, idIn, change1);
				if(turnMoney==1)
				{
					System.out.println("转账成功！");
					
				}
				break;
			case 6:
				List<Account> all=dao.selectAll();
				for(Account acc:all)
				{
					System.out.println(acc);
				}
				System.out.println();
			}
			if(op!=6) {
				List<Account> all=dao.selectAll();
				for(Account acc:all)
				{
					System.out.println(acc);
				}
				System.out.println();
			}
			
			System.out.println("1-开户 2-销户 3-存钱 4-取钱 5-转账 6-显示全部 0-退出");
		}
	}

}
