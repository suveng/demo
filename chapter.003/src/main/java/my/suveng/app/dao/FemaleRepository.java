package my.suveng.app.dao;

import my.suveng.app.model.Female;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;

/**
 * description:
 * @author suwenguang
 * @date 2019-09-01
 * @version 1.0.0
 **/
public interface FemaleRepository extends MongoRepository<Female,String> {


	Page<Female> findAllByCreateTimeBetweenAndNameContaining(Date createTime, Date createTime2, String name, Pageable pageable);

	Page<Female> findAllByCreateTimeBefore(Date createTime, Pageable pageable);

	Page<Female> findAllByCreateTimeAfter(Date createTime, Pageable pageable);

	Page<Female> findAllByCreateTimeBetween(Date start, Date end, PageRequest pageRequest);
}
