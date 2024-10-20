package com.codej.questionbank.constant;

/**
 * 邮件常量
 */
public interface EmailConstant {
    public static final String BODY_TEMPLATE = "你好，您的账号：%s(%s)\n\n" +
            "您在 %s 从 IP 地址 %s 登录了面试题库（www.mianshitiku.com）。\n\n" +
            "如果这不是您本人操作，请立即修改密码并联系支持团队以保护您的账户安全。\n\n" +
            "谢谢，\n面试题库团队(CodeJ)";
    public static final String LOGIN_SUBJECT = "面试题库账号登录通知";

    public static final String WARNING_SUBJECT = "面试题库警告通知";
    public static final String BAN_SUBJECT = "面试题库封号通知";
    // todo 需要修改与yml spring.mail.username一致
    public static final String SENDER = "codejteam@qq.com";


    public static final String WARNING_TEMPLATE = "你好，您的账号：%s(%s)\n\n" +
            "您在 %s 从 IP 地址 %s 进行频繁访问，可能会导致您的账户受到限制。\n\n" +
            "请注意，频繁访问可能影响您的账户安全，建议适度使用。\n\n" +
            "谢谢，\n面试题库团队(CodeJ)";
    public static final String BAN_TEMPLATE = "你好，您的账号：%s(%s)<br><br>" +
            "您在 %s 从 IP 地址 %s 进行频繁访问，<strong>现账号已被封禁。</strong><br><br>" +
            "有问题，请联系面试题库团队(CodeJ)。[邮箱:%s]。<br><br>" +
            "请注意，频繁访问可能影响您的账户安全，建议适度使用。<br><br>" +
            "谢谢，<br>面试题库团队(CodeJ)";




}
