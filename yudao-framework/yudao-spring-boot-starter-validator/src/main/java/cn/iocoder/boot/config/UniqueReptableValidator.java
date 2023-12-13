package cn.iocoder.boot.config;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueReptableValidator implements ConstraintValidator<UniqueName,String> {
    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        //TODO 自定义字段校验器，在这里定义业务
        if (StringUtils.isEmpty(name)) return true;
        return false;
    }
}
