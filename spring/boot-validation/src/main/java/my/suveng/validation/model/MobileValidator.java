package my.suveng.validation.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 *
 * @author suwenguang
 * 
 * @version 1.0.0
 **/
public class MobileValidator implements ConstraintValidator<Mobile, String> {
    /**
     * 手机验证规则
     */
    private Pattern pattern;

    @Override
    public void initialize(Mobile mobile) {
        pattern = Pattern.compile(mobile.regexp());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return pattern.matcher(value).matches();
    }

}
