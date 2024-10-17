package com.codej.questionbank.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class AsyncEmailService {

    private final JavaMailSender mailSender;

    public AsyncEmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async
    public void sendLoginNotification(String userAccount, String loginTime, String ipAddress, String username) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("jx523644@163.com");
        message.setTo(userAccount);
        message.setSubject("CodeJ面试题库 登录通知");
        message.setText("你好，您的账号：" + username +"("+userAccount+")"+"\n\n"  // 这里的 username 需要是实际的用户账号
                + "您在 " + loginTime + " 从 IP 地址 " + ipAddress + " 登录了面试题库（www.mianshitiku.com）。\n\n"
                + "如果这不是您本人操作，请立即修改密码并联系支持团队以保护您的账户安全。\n\n"
                + "谢谢，\n您的应用团队");
        try {
            mailSender.send(message);
        } catch (MailSendException e) {
            // 处理发送邮件失败的情况
            log.error("Failed to send email", e);
            throw e; // 根据需要重新抛出异常
        }

    }
}
