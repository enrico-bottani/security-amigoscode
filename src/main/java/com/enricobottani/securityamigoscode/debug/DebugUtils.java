package com.enricobottani.securityamigoscode.debug;

public class DebugUtils {
    public static String getCurrentMethodName(){
       return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}
