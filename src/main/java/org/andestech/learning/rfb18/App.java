package org.andestech.learning.rfb18;


import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import java.lang.reflect.*;


enum AccountTypes
{ UserAccount, IOTAccount, VirtualAccount, ABSAccount; }


enum LogLevels
{NotLogged, Minimal, Medium, All;}
//@Documented


@Retention(RetentionPolicy.RUNTIME)
@interface AccountType
{
    AccountTypes acctype();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Logging
{
    LogLevels value() default LogLevels.NotLogged;
}

@Retention(RetentionPolicy.RUNTIME)
@interface Active
{}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface methDatas
{}


@AccountType(acctype=AccountTypes.UserAccount)
@Logging(LogLevels.Medium)
@Active
class Account
{
    private int id;
    //...

    @methDatas
    public int getId(){return id;}

}

//@methDatas
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
