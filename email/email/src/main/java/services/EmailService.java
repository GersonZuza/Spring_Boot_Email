package services;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import enums.StatusEmail;
import models.EmailModel;
import repositories.EmailRepository;

@Service
public class EmailService {


	@Autowired
	EmailRepository emailRepository;
	
	@Autowired
	private JavaMailSender emailSender;

	public EmailModel sendEmail(EmailModel emailModel) {
		emailModel.setSendEmail(LocalDateTime.now());
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(emailModel.getEmailFrom());
			message.setTo(emailModel.getEmailFrom());
			message.setSubject(emailModel.getSubject());
			message.setText(emailModel.getText());
			emailSender.send(message);
			
			emailModel.setSendEmail(StatusEmail.SENT);
		} catch (MailException e) {
			emailModel.setSendEmail(StatusEmail.ERROR);
		} finally {
			return emailRepository.save(emailModel);
		}
	}
}
