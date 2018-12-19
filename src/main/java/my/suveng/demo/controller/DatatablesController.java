package my.suveng.demo.controller;

import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.util.List;
import my.suveng.demo.model.domain.User;
import my.suveng.demo.service.UserService;
import my.suveng.demo.util.datatable.DataTable;
import my.suveng.demo.util.datatable.DataTableBulid;
import my.suveng.demo.util.datatable.Order;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 苏文广 created at 2018/12/18
 * @Description: datatablesContrller
 */
@Controller
public class DatatablesController {
    private final UserService userService;

    @Autowired
    public DatatablesController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 返回视图
     * @return view
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    /**
     * 获取全部数据
     * @return list
     */
    @RequestMapping("/getList")
    @ResponseBody
    public DataTable getList(User user,Order order, Integer start,Integer length, Integer draw){
        PageInfo pageInfo = userService.selectByPageNumSize(user, start, length);
        List<User> users =  pageInfo.getList();
        long total = pageInfo.getTotal();
        return DataTableBulid.build(draw, (int) total,users);
    }

    /**
     * 手动插入一万条
     * @return string
     */
    @RequestMapping("/insert")
    @ResponseBody
    public String insert(){
        for (int i = 0; i < 1000; i++) {
            String s = RandomStringUtils.randomAscii(8);
                    User user = new User();
                    user.setName(s);
                    user.setAge(RandomUtils.nextInt(1, 1000));
                    user.setBirth(new Date());
                    user.setSex(RandomStringUtils.randomAscii(1));
                    userService.save(user);
        }
        return "success";
    }
}
