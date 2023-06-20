package com.fx.studygroupproject.user.service;

import com.fx.studygroupproject.user.Member;
import lombok.Getter;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.UUID;

@Getter
@Service
public class EmailService {
    private final JavaMailSender sender;
    private String authCode;

    public EmailService(JavaMailSender sender) {
        this.sender = sender;
    }

    /**
     * 이메일 보내는 함수
     * @param member
     * @throws Exception
     */
    public String sendAuthMessage(Member member) throws Exception {
        authCode = generateAuthCode();
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(member.getEmail());            // 받는 주소
        helper.setSubject(" 다같이에서 보내는 인증 번호입니다!");         // 제목
        helper.setText(" 인증 번호 : " + authCode);          // 내용
        try {
            sender.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("authCode = " + authCode);
        return authCode;
    }

    /**
     * 인증번호를 만드는 함수
     * @return
     */
    public String generateAuthCode() {
        UUID uuid = UUID.randomUUID();
        long mostSignificantBits = uuid.getMostSignificantBits();
        return String.format("%05d", Math.abs(mostSignificantBits) % 100000);
    }
}