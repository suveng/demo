package my.suveng.app.dao;

import my.suveng.app.model.Female;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Date;
import java.util.List;

/**
 * description:
 * 
 * @author suwenguang
 * 
 * @date 2019-09-01
 * 
 * @version 1.0.0
 **/
public interface FemaleRepository extends MongoRepository<Female, String>, QuerydslPredicateExecutor<Female> {
    Page<Female> findAllByCreateTimeBefore(Date createTime, Pageable pageable);

    List<Female> findAllByCreateTimeAfter(Date createTime, Pageable pageable);

    Page<Female> findByCreateTimeBetween(Date createTime, Date createTime2, Pageable pageable);

}
