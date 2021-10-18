package com.ntuc.socialenterprises.qa.utilspackage;

public class StringOperation {


    public static String getCharacterAtPosition(String stringValue){ return String.valueOf(stringValue.charAt(0)); }

    public static String concatTwoString(String stringOne, String stringTwo, boolean isSpace){
        if (isSpace) stringOne=stringOne.concat(" ");
        return stringOne.concat(stringTwo);
    }
}
