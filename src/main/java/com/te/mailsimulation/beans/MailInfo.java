package com.te.mailsimulation.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.te.mailsimulation.beans.EmailInfoBean;

import lombok.Data;

@Data
@Entity
@Table(name="user_info")
@XmlRootElement(name="user-info")
@JsonRootName("userInfo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MailInfo implements Serializable{

	@Column
	@XmlElement
	@JsonProperty
	private int id;
	
	@Id
	@Column
	@XmlElement
	@JsonProperty
	private String mail;
	
	@Column
	@XmlElement
	@JsonProperty
	private String user;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public List<EmailInfoBean> getEmailInfoBean() {
		return emailInfoBean;
	}

	public void setEmailInfoBean(List<EmailInfoBean> emailInfoBean) {
		this.emailInfoBean = emailInfoBean;
	}

	@ManyToMany(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="email_mail", joinColumns=@JoinColumn(name="mail"),inverseJoinColumns=@JoinColumn(name="email"))
	private List<EmailInfoBean> emailInfoBean;
	

}
