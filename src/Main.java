import exeptions.WrongLoginExeption;
import exeptions.WrongPasswordException;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String loggin = "loggin";
        String password = "password";
        String confirmPassword = "password";
        try {
            chekInfo(loggin,password,confirmPassword);
        } catch (WrongLoginExeption | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void chekInfo(String loggin, String password, String confirmPassword) throws WrongLoginExeption, WrongPasswordException {
        logginCorrect(loggin);
        passwordCorrect(password, confirmPassword);

    }

    public static void logginCorrect(String loggin) throws WrongLoginExeption {
        int maxLogginLenght = 20;
        if (loggin.length() > maxLogginLenght) {
            throw new WrongLoginExeption(" Логин должен быть короче");
        }
        Pattern p = Pattern.compile("^[A-Za-z0-9]{1,20}$");
        if (!p.matcher(loggin).matches()) {
            throw new WrongLoginExeption("Логин не подходит по требованиям");
        }
    }

    public static void passwordCorrect(String password,String confirmPassword) throws WrongPasswordException {
        int maxPasswordLenght = 20;
        if (password.length() > maxPasswordLenght) {
            throw new WrongPasswordException(" Пароль должен быть короче");
        }
        Pattern p = Pattern.compile("^[A-Za-z0-9]{1,20}$");
        if (!p.matcher(password).matches()) {
            throw new WrongPasswordException("Пароль не подходит по требованиям");
        }
        if (!password.equals(confirmPassword)){throw new WrongPasswordException("Пароли не совпадают");}
    }
}
