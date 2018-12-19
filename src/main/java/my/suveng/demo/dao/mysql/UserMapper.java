package my.suveng.demo.dao.mysql;

import java.util.List;
import my.suveng.demo.model.domain.User;
import my.suveng.demo.util.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends MyMapper<User> {

  /**
   * @param user
   * @return
   */
  List<User> selectByPageNumSize(
      @Param("user") User user);
}