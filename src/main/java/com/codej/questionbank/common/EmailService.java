package com.codej.questionbank.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendLoginNotification(String to, String loginTime, String ipAddress,String username) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("jx523644@163.com");  // 确保这里的发件人地址与配置中的用户名一致
        message.setTo(to);
        message.setSubject("Login Notification");
        message.setText("你好，您的账号：" + username +"("+to+")"+"\n\n"  // 这里的 username 需要是实际的用户账号
                + "您在 " + loginTime + " 从 IP 地址 " + ipAddress + " 登录了面试题库（www.mianshitiku.com）。\n\n"
                + "如果这不是您本人操作，请立即修改密码并联系支持团队以保护您的账户安全。\n\n"
                + "谢谢，\n您的应用团队");


        mailSender.send(message);
    }
}
