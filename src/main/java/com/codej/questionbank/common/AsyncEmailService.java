package com.codej.questionbank.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import static com.codej.questionbank.constant.EmailConstant.SENDER;

//import static com.codej.questionbank.constant.EmailConstant.SENDER;


@Slf4j
@Service
public class AsyncEmailService {

    private final JavaMailSender mailSender;

    public AsyncEmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }



    @Async
    public void sendLoginNotification(String email_context, String subject, String userAccount, String loginTime, String ipAddress, String username) {
        String messageBody = String.format(email_context, username, userAccount, loginTime, ipAddress);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SENDER);
        message.setTo(userAccount);
        message.setSubject(subject);
//        message.setText("你好，您的账号：" + username +"("+userAccount+")"+"\n\n"  // 这里的 username 需要是实际的用户账号
//                + "您在 " + loginTime + " 从 IP 地址 " + ipAddress + " 登录了面试题库（www.mianshitiku.com）。\n\n"
//                + "如果这不是您本人操作，请立即修改密码并联系支持团队以保护您的账户安全。\n\n"
//                + "谢谢，\n面试题库团队(CodeJ)");

        message.setText(messageBody);
        try {
            mailSender.send(message);
        } catch (MailSendException e) {
            // 处理发送邮件失败的情况
            log.error("Failed to send email", e);
            throw e; // 根据需要重新抛出异常
        }

    }

    /**
     * 重载方法,配合封禁邮件
     *
     * @param email_context
     * @param subject
     * @param userAccount
     * @param loginTime
     * @param ipAddress
     * @param username
     * @param email
     */
    public void sendLoginNotification(String email_context, String subject, String userAccount, String loginTime, String ipAddress, String username, String email) {
        String messageBody = String.format(email_context, username, userAccount, loginTime, ipAddress, email);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SENDER);
        message.setTo(userAccount);
        message.setSubject(subject);
//        message.setText("你好，您的账号：" + username +"("+userAccount+")"+"\n\n"  // 这里的 username 需要是实际的用户账号
//                + "您在 " + loginTime + " 从 IP 地址 " + ipAddress + " 登录了面试题库（www.mianshitiku.com）。\n\n"
//                + "如果这不是您本人操作，请立即修改密码并联系支持团队以保护您的账户安全。\n\n"
//                + "谢谢，\n面试题库团队(CodeJ)");

        message.setText(messageBody);
        try {
            mailSender.send(message);
        } catch (MailSendException e) {
            // 处理发送邮件失败的情况
            log.error("Failed to send email", e);
            throw e; // 根据需要重新抛出异常
        }

    }
}
