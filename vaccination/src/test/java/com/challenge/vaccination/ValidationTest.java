package com.challenge.vaccination;


import com.challenge.vaccination.Helpers.validations;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.Assert.*;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ValidationTest {

    @Test
    public void isWrongDni(){
        String dni = "1111111111";
        boolean validation = validations.DniValidation(dni);
        Assert.assertFalse(validation);
    }
    @Test
    public void isWrongLength(){
        String dni = "11111";
        boolean validation = validations.DniValidation(dni);
        Assert.assertFalse(validation);
    }
    @Test
    public void isAssertDni(){
        String dni = "1757568637";
        boolean validation = validations.DniValidation(dni);
        Assert.assertTrue(validation);
    }
    @Test
    public void isWrongString(){
        String name= "asd494123@!#";
        boolean validation = validations.StringValidation(name);
        Assert.assertFalse(validation);
    }
    @Test
    public void isAssertString(){
        String name= "jorge";
        boolean validation = validations.StringValidation(name);
        Assert.assertTrue(validation);
    }
    @Test
    public void isWrongMail(){
        String name= "jorge";
        boolean validation = validations.MailValidation(name);
        Assert.assertFalse(validation);
    }
    @Test
    public void isAssertMail(){
        String name= "jorge@gmail.com";
        boolean validation = validations.MailValidation(name);
        Assert.assertTrue(validation);
    }

}
