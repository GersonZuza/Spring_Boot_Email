package models;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import enums.StatusEmail;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_EMAIL")
public class EmailModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long emailId;
	private String ownerRef;
	private String emailFrom;
	private String emailTo;
	private String subject;
	@Column(columnDefinition = "TEXT")
	private String text;
	private LocalDateTime sendDateEmail;
	private StatusEmail statusEmail;
	public void setSendEmail(LocalDateTime now) {
		
		
	}
	public String getEmailFrom() {
		
		return null;
	}
	public String getSubject() {
		
		return null;
	}
	public String getText() {
		
		return null;
	}
	public void setSendEmail(StatusEmail sent) {
		
		
	}
	

}
