package com.challenge.vaccination.Helpers;

public class validations {

    public void DniValidation(String dni){
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
            System.out.println("valida");
        }else{
            if(10-suma%10 == Integer.parseInt(a[9])){
                System.out.println("valida");
            }else{
                System.out.println("lenin");
            }
        }
    }
}
