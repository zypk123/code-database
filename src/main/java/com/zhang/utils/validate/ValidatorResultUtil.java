package com.zhang.utils.validate;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 校验工具类
 *
 * @author zhangyu
 */
public class ValidatorResultUtil {

    public static String getMessage(BindingResult result) {
        List<FieldError> fieldErrorList = null;
        String errorMsg = null;
        if (result.hasErrors()) {
            fieldErrorList = result.getFieldErrors();
            errorMsg = fieldErrorList.stream().map(FieldError -> FieldError.getField() + ":" + FieldError.getDefaultMessage())
                    .collect(Collectors.joining("|")).replace("\"", "");
        }
        return errorMsg;
    }
}
