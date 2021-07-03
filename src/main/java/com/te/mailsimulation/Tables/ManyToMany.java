package com.te.mailsimulation.Tables;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.te.mailsimulation.beans.EmailInfoBean;
import com.te.mailsimulation.beans.MailInfo;

public class ManyToMany {
	
	public static void main(String[] args) {
		EmailInfoBean eb1=new EmailInfoBean();
		
		eb1.setEmail("Fahad@ty.in");
		eb1.setName("Fahad");
		eb1.setPassword("123456");
		
		EmailInfoBean eb2=new EmailInfoBean();
		
		eb2.setEmail("Quraishi@ty.in");
		eb2.setName("Fahd");
		eb2.setPassword("135790");
		
		MailInfo mi=new MailInfo();
		
		mi.setId(1);
		mi.setMail("Fahad@ty.in");
		mi.setUser("Rohan");
		
		MailInfo mi2=new MailInfo();
		
		mi2.setId(2);
		mi2.setMail("Quraishi@ty.in");
		mi2.setUser("Mohan");
		
		ArrayList<EmailInfoBean> emailList=new ArrayList<EmailInfoBean>();
		
		emailList.add(eb1);
		emailList.add(eb2);
		
		ArrayList<MailInfo> mailList=new ArrayList<MailInfo>();
		mailList.add(mi);
		mailList.add(mi2);
		
		eb1.setMailInfo(mailList);
		
		ArrayList<EmailInfoBean> emailList1=new ArrayList<EmailInfoBean>();
		emailList1.add(eb1);
		
		eb2.setMailInfo(mailList);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager em=emf.createEntityManager();
		EntityTransaction trans=em.getTransaction();
		
		trans.begin();
		
		em.persist(eb1);
		em.persist(eb2);
		trans.commit();
	}

}
