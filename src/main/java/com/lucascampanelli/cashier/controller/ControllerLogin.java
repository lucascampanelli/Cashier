package com.lucascampanelli.cashier.controller;

/**
 *
 * @author lucas
 */
public class ControllerLogin {
    
    public boolean logar(String login, String senha){
        return login.equals("login") && senha.equals("123");
    }
    
}
