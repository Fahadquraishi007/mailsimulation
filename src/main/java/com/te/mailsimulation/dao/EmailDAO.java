package com.te.mailsimulation.dao;

import java.util.List;

import com.te.mailsimulation.beans.EmailInfoBean;

public interface EmailDAO {

	public EmailInfoBean getEmailData(String email);
	
	public boolean deleteEmailData(String email);
	
	public boolean addEmailData(EmailInfoBean emailInfoBean);
	
	public boolean updateRecord(EmailInfoBean emailInfoBean);
	
	public List<EmailInfoBean> getAllEmail();
}
