/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg70;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

/**
 *
 * @author admin
 */
public class Manager {
    private final InputData inputData = new InputData();
    private final CheckData checkData = new CheckData();
    
    void VietnameseLogin() {
        Locale locale = new Locale("vi");
        ResourceBundle bundle = ResourceBundle.getBundle("pkg70//language", locale);
        Login(bundle);
    }

    void EnglishLogin() {
        Locale locale = Locale.ENGLISH;
        ResourceBundle bundle = ResourceBundle.getBundle("pkg70//language", locale);
        Login(bundle);
    }

    void Login(ResourceBundle bundle) {
        System.out.print(bundle.getString("InputAccountNumber"));
        String accountNumber = inputData.inputAccountNumber(bundle);
        System.out.print(bundle.getString("InputPassword"));
        String password = inputData.inputPassword(bundle);
        String captcha = generateRandomCaptcha(bundle);
        checkData.checkCaptcha(bundle, captcha);
        boolean checkAccount = checkData.checkAccountNumber(accountNumber);
        boolean checkPassword = checkData.checkPassword(accountNumber, password);
        if (checkAccount && checkPassword) {
            System.out.println("Login succesfully");
        } else {
            System.out.println("Login failed");
        }
    }

    String generateRandomCaptcha(ResourceBundle bundle) {
        int captchaLength = 5;
        StringBuilder randomCaptcha = new StringBuilder();
        Random random = new Random();
        String string = "";
        //According to ASCII code, use loop to get characters from 0 to 9
        for (int i = 48; i <= 57 ; i++) {
            string = string+(char)i;
        }
        //According to ASCII code, use loop to get characters from A to Z
        for (int i = 65; i <= 90 ; i++) {
            string = string+(char)i;
        }
        //According to ASCII code, use loop to get characters from a to z
        for (int i = 97; i <= 122 ; i++) {
            string = string+(char)i;
        }
        //Loop to random captcha
        for (int i = 0; i < captchaLength ; i++) {
            char c = string.charAt(random.nextInt(string.length()));
            randomCaptcha.append(c);
        }
        //Display captcha
        System.out.print(bundle.getString("DisplayCaptcha"));
        System.out.println(randomCaptcha);
        System.out.print(bundle.getString("InputCaptcha"));
        return randomCaptcha.toString();

    }
    
}
