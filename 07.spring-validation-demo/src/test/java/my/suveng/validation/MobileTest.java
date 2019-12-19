package my.suveng.validation;

import my.suveng.validation.model.Mobile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Set;

/**
 *
 * @author suwenguang
 * @version 1.0.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ValidationApplication.class)
public class MobileTest {

	public void setMobile(@Mobile String mobile){
		// to do
	}

	private static ExecutableValidator executableValidator;


	@Test
	public void manufacturerIsNull() throws NoSuchMethodException {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		executableValidator = factory.getValidator().forExecutables();

		MobileTest mobileTest = new MobileTest();

		Method method = MobileTest.class.getMethod("setMobile", String.class);
		Object[] parameterValues = {"1111111"};
		Set<ConstraintViolation<MobileTest>> violations = executableValidator.validateParameters(
			mobileTest, method, parameterValues);

		violations.forEach(violation -> System.out.println(violation.getMessage()));
	}
}
