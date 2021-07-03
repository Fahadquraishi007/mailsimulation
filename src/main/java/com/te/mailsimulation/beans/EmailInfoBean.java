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

import lombok.Data;

@Data
@Entity
@Table(name="email_info")
@XmlRootElement(name="email-info")
@JsonRootName("emailInfo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmailInfoBean implements Serializable {
	
	@Id
	@Column
	@XmlElement
	@JsonProperty
	private String email;
	
	@Column
	@XmlElement
	@JsonProperty
	private String name;
	
	@Column
	@XmlElement
	@JsonProperty
	private String password;
	@ManyToMany(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="email_mail", joinColumns=@JoinColumn(name="email"),inverseJoinColumns=@JoinColumn(name="mail"))
	private List<MailInfo> mailInfo;

	public List<MailInfo> getMailInfo() {
		return mailInfo;
	}

	public void setMailInfo(List<MailInfo> mailInfo) {
		this.mailInfo = mailInfo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
