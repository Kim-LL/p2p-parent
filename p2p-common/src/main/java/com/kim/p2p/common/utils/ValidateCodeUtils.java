package com.kim.p2p.common.utils;

import com.kim.p2p.common.model.pojo.ValidateCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValidateCodeUtils {

    @Value(value = "${homePath}")
    private String homePath;

    private void generator(ValidateCode validateCode){

        validateCode.write(homePath, ImageUtils.FORMAT_PNG);
    }

    public ValidateCode getCode(int width, int height){
        ValidateCode validateCode = new ValidateCode(width, height);
        generator(validateCode);
        return validateCode;
    }

    public ValidateCode getCode(int width, int height, int codeCount, int lineCount){
        ValidateCode validateCode = new ValidateCode(width, height, codeCount, lineCount);

        generator(validateCode);
        return validateCode;
    }

    public ValidateCode getCode(){
        ValidateCode validateCode = new ValidateCode();
        generator(validateCode);
        return validateCode;
    }
}
