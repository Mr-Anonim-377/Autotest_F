package com.ruSkidex.HelperClasses;

public  class Expectation {
    public static void wait (int millisecond){
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
