
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
public class Ebank {

    public static final Scanner sc = new Scanner(System.in);
    ArrayList<Account> accountList = new ArrayList<>();

    void mockData() {
        accountList.add(new Account("1234567891", "abcd123456"));
        accountList.add(new Account("1234567892", "abcd123455"));
        accountList.add(new Account("1234567893", "abcd123454"));
        accountList.add(new Account("1234567894", "abcd123453"));
        accountList.add(new Account("1234567895", "abcd123452"));

    }

    void loginVietnamese() {
        Locale localeVie = new Locale("Vi");
        loginSystem(localeVie);
    }

    void loginEnglish() {
        Locale localeEng = new Locale("En");
        loginSystem(localeEng);
    }

    private void loginSystem(Locale locale) {
        ResourceBundle languageBundle = ResourceBundle.getBundle("Language", locale);
       String accountName = Utility.getString(languageBundle.getString("accountNumber"),
       languageBundle.getString("accountError"), Utility.REGEX_USERNAME);

        String password = Utility.getString(languageBundle.getString("Password"),
        languageBundle.getString("PasswordError"), Utility.REGEX_PASSWORD);

        handleCaptcha(languageBundle.getString("Captcha"),
                languageBundle.getString("CaptchaInput"),
                languageBundle.getString("CaptchaError"));
        //if user enter correct accountName and password->tell success
        if(checkAccount(accountName, password)){
            System.out.println(languageBundle.getString("loginSuccess"));
        } 
        //else tell error
        else {
            System.out.println(languageBundle.getString("loginFail"));
        }
    }
    

    private void handleCaptcha(String Captcha, String CaptchaInput, String Captchaerror) {
        //generate captcha
        String generateCaptcha = generateCaptcha();
        System.out.println(Captcha + generateCaptcha);

        while (true) {
            //input captcha
            String inputCaptcha = Utility.getString(CaptchaInput,"Captcha must be alphanumeric",
                    Utility.REGEX_CAPTCHA);

            //compare captcha generate with input catpcha
            if (!generateCaptcha.contains(inputCaptcha)) {
                System.out.println(Captchaerror);
            } else {
                break;
            }
        }
    }

    private String generateCaptcha() {
        Random random = new Random();
        String captcha = "";
        String characters = "";
        //loop to add normal letter in string
        for (char c = 'a'; c <= 'z' ; c++) {
            characters += c;
        }
        //loop to add capital letter in string
        for (char c = 'A'; c <= 'Z'; c++) {
            characters +=c;
        }
        //loop to add number in string
        for (int i = 0; i < 10; i++) {
            characters +=i;
        }
        char[] Characters = characters.toCharArray();
        
        //loop to generate 5 random character
        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(Characters.length);
            captcha += Characters[randomIndex];
        }
        return captcha;
        
    }
    private boolean checkAccount(String account,String password){
        for (Account account1 : accountList) {
            //if user enter AccountName and password equal account in accountList->return true
            //else ->return false
            if(account1.getAccountName().equals(account)&&account1.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

}
