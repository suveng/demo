package my.suveng.jpa.vendor.druid;

import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.StatementProxy;
import org.springframework.stereotype.Component;

/**
 *
 * @author suwenguang
 * @version 1.0.0
 **/
@Component(value = "me")
public class MeFilter extends FilterEventAdapter {
	private String hello;
	private String user;

	@Override
	protected void statementExecuteAfter(StatementProxy statement, String sql, boolean result) {
		System.out.println("###############################suveng#######################################"+this.hello+this.user);
		super.statementExecuteAfter(statement, sql, result);
	}

	public String getHello() {
		return hello;
	}

	public void setHello(String hello) {
		this.hello = hello;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}
