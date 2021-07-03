package com.te.mailsimulation.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.mailsimulation.beans.EmailInfoBean;
import com.te.mailsimulation.exceptions.EmailException;

@Repository
public class EmailDAOHibernateImpl implements EmailDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public EmailInfoBean getEmailData(String email) {

		EntityManager manager = factory.createEntityManager();
		EmailInfoBean infoBean = manager.find(EmailInfoBean.class, email);
		if (infoBean != null) {
			infoBean.setPassword(null);
		}
		manager.close();
		return infoBean;
	}

	@Override
	public boolean deleteEmailData(String email) {
		boolean isDeleted = false;

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			EmailInfoBean infoBean = manager.find(EmailInfoBean.class, email);
			manager.remove(infoBean);
			transaction.commit();
			isDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw new EmailException("Data asssociated with email " + email+ "  not Found");
		}

		return isDeleted;
	}

	@Override
	public boolean addEmailData(EmailInfoBean emailInfoBean) {
		boolean isInserted = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			manager.persist(emailInfoBean);
			transaction.commit();
			isInserted = true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

		return isInserted;
	}

	@Override
	public boolean updateRecord(EmailInfoBean emailInfoBean) {
		boolean isUpdated = false;

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			EmailInfoBean actualInfo = manager.find(EmailInfoBean.class, emailInfoBean.getEmail());

			if (emailInfoBean.getEmail() != null && emailInfoBean.getEmail() != "") {
				actualInfo.setEmail(emailInfoBean.getEmail());
			}

			if (emailInfoBean.getName() != "") {
				actualInfo.setName(emailInfoBean.getName());
			}

			if (emailInfoBean.getPassword() != null && emailInfoBean.getPassword() != "") {
				actualInfo.setPassword(emailInfoBean.getPassword());
			}

			transaction.commit();
			isUpdated = true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}

		return isUpdated;
	}

	@Override
	public List<EmailInfoBean> getAllEmail() {

		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("from EmployeeInfoBean");
		ArrayList<EmailInfoBean> emailInfoBeans = new ArrayList<EmailInfoBean>();
		try {
			emailInfoBeans = (ArrayList<EmailInfoBean>) query.getResultList();
			for (EmailInfoBean emailInfoBean : emailInfoBeans) {
				emailInfoBean.setPassword(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			emailInfoBeans = null;

		}

		return emailInfoBeans;
	}
	
	

}