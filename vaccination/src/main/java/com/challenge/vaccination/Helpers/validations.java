package com.challenge.vaccination.Helpers;

import com.challenge.vaccination.Models.Employees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validations {

    public static boolean DniValidation(String dni){
        if(dni.length() == 10){
            String[] a = dni.split("");
            String[] b = a;
            int suma = 0;
            for (int i = 0 ; i<8;i++){
                b[i] = a[i];
            }
            for (int i = 0 ; i<9 ; i++){
                if (i%2==0){
                    if(Integer.parseInt(b[i])*2 > 9){
                        b[i] = Integer.toString((Integer.parseInt(b[i])*2)-9);
                    }else{
                        b[i] = Integer.toString(Integer.parseInt(b[i])*2);
                    }
                }
                suma += Integer.parseInt(b[i]);
            }
            if(suma%10==0){
                return true;
            }else{
                if(10-suma%10 == Integer.parseInt(a[9])){
                    return true;
                }else{
                    return false;
                }
            }
        }else{
            return false;
        }
    }
    public static boolean StringValidation(String name){
        if (name!= null){
            for (int x = 0; x < name.length(); x++) {
                char c = name.charAt(x);
                if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }
    public static boolean MailValidation(String mail) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(mail);
        return mather.find();
    }
    public static boolean EmployeesValidation(Employees employees){
        if(DniValidation(employees.getDni())&&StringValidation(employees.getName())&&StringValidation(employees.getLastname())&&MailValidation(employees.getMail())){
            return true;
        }else {
            return false;
        }
    }

}
