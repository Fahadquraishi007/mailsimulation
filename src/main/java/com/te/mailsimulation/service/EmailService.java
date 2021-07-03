package com.te.mailsimulation.service;

import java.util.List;

import com.te.mailsimulation.beans.EmailInfoBean;

public interface EmailService {

	public EmailInfoBean getEmailData(String email);
	
	public boolean deleteEmail(String Email);
	
	public boolean addEmail(EmailInfoBean emailInfoBean);
	
	public boolean updateEmail(EmailInfoBean emailInfoBean);
	
	public List<EmailInfoBean> getAllEmails();
}
