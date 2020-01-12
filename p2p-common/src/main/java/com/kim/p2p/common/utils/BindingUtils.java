package com.kim.p2p.common.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BindingUtils {

    public static Map<String, String> judgeBinding(BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            Map<String, String> data = new HashMap<>();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error: errors){
                data.put(error.getField(), error.getDefaultMessage());
            }
            return data;
        }
        return null;
    }
}
