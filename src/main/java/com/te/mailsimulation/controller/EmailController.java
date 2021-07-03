package com.te.mailsimulation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.mailsimulation.beans.EmailInfoBean;
import com.te.mailsimulation.beans.EmailResponse;
import com.te.mailsimulation.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService service;

	@GetMapping(path = "/getEmail", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public EmailResponse getEmailData(String email) {
		EmailInfoBean infoBean = service.getEmailData(email);
		EmailResponse response = new EmailResponse();
		if (infoBean != null) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data found for email : " + email);
			response.setEmailInfoBean(infoBean);
		} else {
			response.setStatusCode(404);
			response.setMsg("Failure");
			response.setDescription("Data not found for email : " + email);
		}
		return response;
	}

	@PostMapping(path = "/addEmail", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmailResponse addEmailData(@RequestBody EmailInfoBean infoBean) {
		EmailResponse response = new EmailResponse();

		if (service.addEmail(infoBean)) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data inserted Sucessfully");
		} else {
			response.setStatusCode(500);
			response.setMsg("failure");
			response.setDescription("Data Could not be inserted");
		}
		return response;
	}

	@PutMapping(path = "/updateEmail", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmailResponse updateEmailData(@RequestBody EmailInfoBean infoBean) {
		EmailResponse response = new EmailResponse();

		if (service.updateEmail(infoBean)) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data Updated Sucessfully");
		} else {
			response.setStatusCode(500);
			response.setMsg("failure");
			response.setDescription("Data Could not be updated");
		}
		return response;
	}

	@DeleteMapping(path = "/deleteEmail/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public EmailResponse deleteRecord(@PathVariable String email) {
		EmailResponse response = new EmailResponse();

		if (service.deleteEmail(email)) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data Delete Sucessfully");
		} else {
			response.setStatusCode(500);
			response.setMsg("failure");
			response.setDescription("Data Not Exist");
		}
		return response;

	}//

	@GetMapping(path = "/getAll", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public EmailResponse getAllRecord() {
		EmailResponse response = new EmailResponse();
		List<EmailInfoBean> emailInfoBeans = service.getAllEmails();
		if (emailInfoBeans != null) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data Found Sucessfully");
			response.setEmailInfoBean((EmailInfoBean) emailInfoBeans);
		} else {
			response.setStatusCode(500);
			response.setMsg("failure");
			response.setDescription("Data Not Exist");
		}
		return response;
	}

}