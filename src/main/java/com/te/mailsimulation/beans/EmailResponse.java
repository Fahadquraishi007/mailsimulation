package com.te.mailsimulation.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@XmlRootElement(name = "response")
@JsonRootName("emailResponse")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmailResponse {
	
	@XmlElement
	@JsonProperty
	private int statusCode;
	@XmlElement
	@JsonProperty
	private String msg;
	@XmlElement
	@JsonProperty
	private String Description;
	@XmlElement
	@JsonProperty
	private EmailInfoBean emailInfoBean;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public EmailInfoBean getEmailInfoBean() {
		return emailInfoBean;
	}
	public void setEmailInfoBean(EmailInfoBean emailInfoBean) {
		this.emailInfoBean = emailInfoBean;
	}
}
