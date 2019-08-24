package my.suveng.campus.modules.recruit.dao;

import my.suveng.campus.modules.recruit.model.Applicant;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * description:
 * @author suwenguang
 * @date 2019-08-24
 * @version 1.0.0
 **/
public interface ApplicantRepository  extends MongoRepository<Applicant,String> {
}
