package org.andestech.learning.rfb18;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Driver{

    private String driverDate = "asdagdsjhg12312";

    public void abc_LOAD12(){
        System.out.println("abc_LOAD12 run!!!");

    }

    public void abc_UNLOAD(){
        System.out.println("abc_UNLOAD run!!!");

    }

    public void abc_CHECK(){
        System.out.println("abc_CHECK run!!!");

    }

    public void def_CHECK(){
        System.out.println("def_CHECK run!!!");

    }

    public void def_CHECK(int a){
        System.out.println("def_CHECK run!!! Params:" + a);

    }

    ////

    private void doInternalDriverWork(){
        System.out.println("Internal works....!!!");

    }
}


public class AppRefl {


    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Driver driver = new Driver();

        Class<?> dd = Driver.class;

        for(Method m: dd.getDeclaredMethods())
        {
            System.out.println("meth: " + m.getName());

            if(m.getName().startsWith("abc"))
            {
                m.invoke(driver);
            }
        }

    }

}
