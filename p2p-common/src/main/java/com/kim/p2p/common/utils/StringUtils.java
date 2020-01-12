package com.kim.p2p.common.utils;

import java.util.regex.Pattern;

public class StringUtils {

    public static boolean containDigitAndCharacter(String text){
        if(containCharacter(text) && containDigit(text)){
            return true;
        }
        return false;
    }

    public static boolean containDigit(String text){
        return Pattern.compile("[0-9]").matcher(text).find();
    }

    public static boolean containCharacter(String text){
        return Pattern.compile("[a-zA-Z]").matcher(text).find();
    }
}
