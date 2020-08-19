package my.suveng.oauth.config.auth;

import cn.hutool.core.util.StrUtil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 *
 * @author suwenguang
 **/
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StrUtil.isBlank(username)) {
            throw new UsernameNotFoundException("用户名不能为空");
        }

        // 权限列表
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();

        return new User("user", new BCryptPasswordEncoder().encode("123"), authorities);

    }
}
