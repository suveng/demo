package com.TT.demo.service.impl;

import com.TT.demo.dao.mysql.spring.KkkMapper;
import com.TT.demo.domain.mysql.spring.Kkk;
import com.TT.demo.service.KkkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 苏文广 on 2018/11/19
 */
@Service("kkkService")
public class KkkServiceImpl extends BaseService<Kkk> implements KkkService<Kkk> {
    @Autowired
    KkkMapper kkkMapper;
}
