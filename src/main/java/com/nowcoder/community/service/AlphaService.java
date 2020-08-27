package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class AlphaService {
    @Autowired
    private AlphaDao alphaDao;

    public AlphaService() {
        System.out.println("构造方法执行...");
    }

    @PostConstruct  // 在构造方法之后调用
    public void init() {
        System.out.println("构造方法之后init执行...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("销毁方法destroy执行...");
    }

    public String find() {
        return alphaDao.select();
    }

}
