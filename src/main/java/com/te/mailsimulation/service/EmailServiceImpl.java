package com.te.mailsimulation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.mailsimulation.beans.EmailInfoBean;
import com.te.mailsimulation.dao.EmailDAO;

@Service
public class EmailServiceImpl implements EmailService {


	@Autowired
	EmailDAO dao;

	@Override
	public EmailInfoBean getEmailData(String email) {
		if (email=="") {
			return null;
		}
		return dao.getEmailData(email);
	}

	@Override
	public boolean deleteEmail(String email) {

		return dao.deleteEmailData(email);
	}

	@Override
	public boolean addEmail(EmailInfoBean emailInfoBean) {

		return dao.addEmailData(emailInfoBean);
	}

	@Override
	public boolean updateEmail(EmailInfoBean emailInfoBean) {
		// TODO Auto-generated method stub
		return dao.updateRecord(emailInfoBean);
	}

	@Override
	public List<EmailInfoBean> getAllEmails() {
		// TODO Auto-generated method stub
		return dao.getAllEmail();
	}

}
