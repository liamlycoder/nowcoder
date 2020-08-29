package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service
public class AlphaService {
    @Resource
    private AlphaDao alphaDao;

    public String find() {
        return alphaDao.select();
    }

}
