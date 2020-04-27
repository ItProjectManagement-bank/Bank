package cn.sdut.main;

import java.util.List;
import java.util.Scanner;

import cn.sdut.dao.AccountDao;
import cn.sdut.po.Account;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int op;
		System.out.println("**���й���ϵͳ");
		System.out.println("1-���� 2-���� 3-��Ǯ 4-ȡǮ 5-ת�� 6-��ʾȫ�� 0-�˳�");
		while ((op = sc.nextInt()) != 0) {
			
			AccountDao dao=new AccountDao();
			switch (op) {
			case 1:// ����
				System.out.println("�������˻����ƺͳ�ʼ���");
				String name1=sc.next();
				double initMoney=sc.nextDouble();
				
				Account account=new Account(0,name1, initMoney);
				int result=dao.addAccount(account);
				if(result==1)
				{
					System.out.println("�����ɹ�!");
				}
				
				break;
			case 2:// ����
				System.out.println("������Ҫע�����˻�id");
				int id5=sc.nextInt();
				int delAccount = dao.delAccount(id5);
				if(delAccount==1)
				{
					System.out.println("�����ɹ�!");
				}
				break;

			case 3:// ��Ǯ
				System.out.println("�������˻�id�ʹ�����");
				int id=sc.nextInt();
				double change=sc.nextDouble();
				int update1=dao.updateAccountMoney(id, change);
				if(update1==1)
				{
					System.out.println("����ɹ���");
				}
				break;
			case 4:// ȡǮ
				System.out.println("�������˻�id��ȡǮ���");
				int idqv=sc.nextInt();
				double changeqv=sc.nextDouble();
				int updateqv=dao.updateAccountMoney(idqv, changeqv);
				if(updateqv==1)
				{
					System.out.println("ȡǮ�ɹ���");
				}
				break;
			case 5:// ת��
				System.out.println("������ת���˻���ת���˻���ת�˽��");
				int idOut=sc.nextInt();
				int idIn=sc.nextInt();
				double change1=sc.nextDouble();
				int turnMoney = dao.turnMoney(idOut, idIn, change1);
				if(turnMoney==1)
				{
					System.out.println("ת�˳ɹ���");
					
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
			
			System.out.println("1-���� 2-���� 3-��Ǯ 4-ȡǮ 5-ת�� 6-��ʾȫ�� 0-�˳�");
		}
	}

}
