package my.suveng.datawaydemo.service;

import net.hasor.core.ApiBinder;
import net.hasor.core.DimModule;
import net.hasor.db.JdbcModule;
import net.hasor.db.Level;
import net.hasor.spring.SpringModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 *
 * @author suwenguang
 **/
@DimModule
@Component
public class ExampleModule implements SpringModule {
	@Autowired
	private DataSource dataSource;

	@Override
	public void loadModule(ApiBinder apiBinder) throws Throwable {
		// .DataSource form Spring boot into Hasor
		apiBinder.installModule(new JdbcModule(Level.Full, this.dataSource));
		// .custom DataQL
		//apiBinder.tryCast(QueryApiBinder.class).loadUdfSource(apiBinder.findClass(DimUdfSource.class));
		//apiBinder.tryCast(QueryApiBinder.class).bindFragment("sql", SqlFragment.class);
	}
}
