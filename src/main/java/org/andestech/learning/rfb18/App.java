package org.andestech.learning.rfb18;


import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import java.lang.reflect.*;


enum AccountTypes
{ UserAccount, IOTAccount, VirtualAccount, ABSAccount; }

//@Documented


@Retention(RetentionPolicy.RUNTIME)
@interface AccountType
{
    AccountTypes acctype();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Logging
{
    boolean isLogged() default true;
}

@Retention(RetentionPolicy.RUNTIME)
@interface Active
{}


@AccountType(acctype=AccountTypes.UserAccount)
@Logging
@Active
class Account
{
    private int id;
    //...

    public int getId(){return id;}

}

public class App 
{
    public static void main( String[] args )
    {

        Account acc = new Account();

        Class<?> accClass = acc.getClass();

        for(Annotation an: accClass.getAnnotations())
        { System.out.println(an);
         if( an instanceof AccountType){
           AccountType aa  = accClass.getAnnotation(AccountType.class);
           System.out.println(aa.acctype());}

         if(an instanceof Active)  {
             //....
             //....
             System.out.println("+++");
         }
        }

    }
}
