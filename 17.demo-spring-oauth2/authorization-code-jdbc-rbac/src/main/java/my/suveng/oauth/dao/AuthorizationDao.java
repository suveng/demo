package my.suveng.oauth.dao;

import my.suveng.oauth.entity.TbPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;

/**
 * 认证服务
 * @author suwenguang
 **/
public interface AuthorizationDao {


	/**
	 * 根据userId获取权限
	 * @author suwenguang
	 */
	ArrayList<TbPermission> getGrantedAuthorityByUserId(@Param("userId") long userId);
}
