package com.TT.demo.dao.spring;

import com.TT.demo.domain.spring.Kkk;
import com.TT.demo.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface KkkMapper extends MyMapper<Kkk> {
}