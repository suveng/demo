package my.suveng.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import javax.annotation.Resource;
import my.suveng.demo.dao.mysql.UserMapper;
import my.suveng.demo.model.domain.User;
import my.suveng.demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 苏文广 created at 2018/12/18
 * @Description:
 */
@Service
public class UserServiceImpl extends BaseService<User> implements UserService {

  @Resource
  UserMapper userMapper;
  @Override
  public PageInfo selectByPageNumSize(User user, int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<User> users = userMapper.selectByPageNumSize(user);
    return new PageInfo<>(users);
  }
}
