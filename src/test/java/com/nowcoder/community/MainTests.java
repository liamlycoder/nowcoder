package com.nowcoder.community;

import com.nowcoder.community.util.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommunityApplication.class)
public class MainTests {

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testTextMail() {
        mailClient.sendMail("luyu.real@qq.com", "TEST", "welcome to JavaMail...");
    }

    @Test
    public void testHtmlMail() {
        Context con = new Context();
        con.setVariable("username", "Sandy");
        String content = templateEngine.process("/mail/demo", con);
        mailClient.sendMail("luyu.real@qq.com", "TEST", content);
    }
}
