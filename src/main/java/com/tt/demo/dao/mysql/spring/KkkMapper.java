package com.tt.demo.dao.mysql.spring;

import com.tt.demo.domain.mysql.spring.Kkk;
import com.tt.demo.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface KkkMapper extends MyMapper<Kkk> {
}