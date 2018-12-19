package my.suveng.demo.service;

import com.github.pagehelper.PageInfo;
import my.suveng.demo.model.domain.User;

/**
 * @author 苏文广 created at 2018/12/18
 * @Description:
 */
public interface UserService extends IService<User> {
  PageInfo selectByPageNumSize(User user, int pageNum, int pageSize);

}
