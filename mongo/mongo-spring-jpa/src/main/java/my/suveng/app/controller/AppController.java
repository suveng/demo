package my.suveng.app.controller;

import cn.hutool.core.bean.BeanUtil;
import my.suveng.app.model.Female;
import my.suveng.app.model.FemaleVo;
import my.suveng.app.model.result.Result;
import my.suveng.app.model.result.ResultBuilder;
import my.suveng.app.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * description:
 * 
 * @author suwenguang
 * 
 * @date 2019-09-01
 * 
 * @version 1.0.0
 **/
@Controller
@RequestMapping("/app")
public class AppController {

    @Autowired
    private AppService appService;

    /**
     * description: 增加/修改 author: suwenguang date: 2019-09-01
     */
    @RequestMapping("/save")
    @ResponseBody
    public Result save(Female vo) {
        return appService.save(vo);
    }

    /**
     * description: 删除 author: suwenguang date: 2019-09-01
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(String id) {
        return appService.delete(id);
    }

    /**
     * description: 查询 author: suwenguang date: 2019-09-01
     */
    @RequestMapping("/list")
    @ResponseBody
    public Result list(@RequestBody FemaleVo vo) {
        return appService.list(vo);
    }
}
