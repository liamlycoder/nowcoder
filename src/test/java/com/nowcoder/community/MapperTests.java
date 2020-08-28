package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)  // 指定配置类
public class MapperTests implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Test
    public void testUserMapper() {
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);

//        User user = new User();
//        user.setUsername("wangbeibei");
//        user.setPassword("luyu522");
//        user.setSalt("lover");
//        user.setEmail("wbb@qq.com");
//        user.setHeaderUrl("http://images.nowcoder.com/head/101.png");
//        user.setCreateTime(new Date());

//        int r = userMapper.insertUser(user);
        int i = userMapper.updateHeader(152, "http://images.nowcoder.com/head/102.png");
        int i1 = userMapper.updatePassword(152, "luyu520..");
        int i2 = userMapper.updateStatus(152, 1);
    }

    @Test
    public void testSelectPosts() {
        DiscussPostMapper discussPostMapper = applicationContext.getBean(DiscussPostMapper.class);
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(149, 0, 10);
        for (DiscussPost discussPost: discussPosts) {
            System.out.println(discussPost);
        }

        int rows = discussPostMapper.selectDiscussPostsRows(149);
        System.out.println(rows);
    }

}
