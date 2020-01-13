package com.kim.p2p.common.utils;

import com.kim.p2p.common.model.pojo.ValidateCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

@Component
public class ValidateCodeUtils {

    private ByteArrayOutputStream generator(ValidateCode validateCode){

//        return validateCode.write(homePath, ImageUtils.FORMAT_PNG);
        return validateCode.write(ImageUtils.FORMAT_PNG);
//        OutputStream os = new FileOutputStream();
//        validateCode.write();
    }

    public ValidateCode getCode(int width, int height){
        ValidateCode validateCode = new ValidateCode(width, height);
        ByteArrayOutputStream memoryOs = generator(validateCode);
        validateCode.setOutputStream(memoryOs);
        return validateCode;
    }

    public ValidateCode getCode(int width, int height, int codeCount, int lineCount){
        ValidateCode validateCode = new ValidateCode(width, height, codeCount, lineCount);

        ByteArrayOutputStream memoryOs = generator(validateCode);
        validateCode.setOutputStream(memoryOs);
        return validateCode;
    }

    public ValidateCode getCode(){
        ValidateCode validateCode = new ValidateCode();
        ByteArrayOutputStream memoryOs = generator(validateCode);
        validateCode.setOutputStream(memoryOs);
        return validateCode;
    }
}
