package my.suveng.app.service;

import my.suveng.app.model.Female;
import my.suveng.app.model.FemaleVo;
import my.suveng.app.model.result.Result;

/**
 * description:
 * @author suwenguang
 * @date 2019-09-01
 * @version 1.0.0
 **/
public interface AppService {
	/**
	 * description: 增加/修改
	 * author: suwenguang
	 * date: 2019-09-01
	 */
	Result save(Female vo);

	/**
	 * description: 删除
	 * author: suwenguang
	 * date: 2019-09-01
	 */
	Result delete(String id);

	/**
	 * description: 分页查询 符合条件 vo list
	 * author: suwenguang
	 * date: 2019-09-01
	 * @param vo
	 */
	Result list(FemaleVo vo);
}
