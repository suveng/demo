package my.suveng.oauth.controller;

import my.suveng.oauth.entity.OauthClientDetails;
import my.suveng.oauth.service.OauthClientDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (OauthClientDetails)表控制层
 *
 * @author makejava
 * @since 2020-02-28 17:04:55
 */
@RestController
@RequestMapping("oauthClientDetails")
public class OauthClientDetailsController {
    /**
     * 服务对象
     */
    @Resource
    private OauthClientDetailsService oauthClientDetailsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public OauthClientDetails selectOne(String id) {
        return this.oauthClientDetailsService.queryById(id);
    }

}