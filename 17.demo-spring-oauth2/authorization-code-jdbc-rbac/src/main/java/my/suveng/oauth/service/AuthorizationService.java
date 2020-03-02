package my.suveng.oauth.service;

import my.suveng.oauth.dao.AuthorizationDao;
import my.suveng.oauth.entity.TbPermission;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 认证服务
 * @author suwenguang
 **/
@Service
public class AuthorizationService {


	@Resource
	private AuthorizationDao authorizationDao;
	/**
	 * 根据userId获取权限
	 * @author suwenguang
	 */
	public ArrayList<GrantedAuthority> getGrantedAuthorityByUserId(long userId){
		ArrayList<GrantedAuthority> result = new ArrayList<>();
		ArrayList<TbPermission> permissions = authorizationDao.getGrantedAuthorityByUserId(userId);
		permissions.removeAll(Collections.singleton(null));

		if (CollectionUtils.isEmpty(permissions) || permissions.isEmpty()) {

			return null;
		}
		permissions.parallelStream().forEach((permission)->{
			result.add(new SimpleGrantedAuthority(permission.getEnname()));
		});

		return result;
	}
}
