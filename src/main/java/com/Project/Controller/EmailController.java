package com.Project.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Service.EmailService;

@RestController
@RequestMapping("/api/email")
@CrossOrigin("*")
public class EmailController {

	private final EmailService service;

	public EmailController(EmailService service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public String sendEmail(
			
			@RequestParam String to,
			@RequestParam String subject,
			@RequestParam String text
			
	) {
		service.sendEmail(to, subject, text);
		return "Email Sent Successfully";
	}

}
