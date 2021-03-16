package com.lucascampanelli.cashier.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.lucascampanelli.cashier.controller.ControllerLogin;
import com.lucascampanelli.cashier.DAO.factory.Connect;

/**
 *
 * @author lucas
 */
public class Login extends JFrame {
    
    JPanel header;
    
    JLabel title, loginTitle, loginLabel, senhaLabel;
    
    JTextField login, senha;
    
    JButton exitButton, loginButton;
    
    String fontTitle, fontText, colorYellowLight,
           colorBlueLight, colorYellowDark, colorBlueDark, colorGray;
    
    public Login(){
        super("Login - Cashier");
        
        fontTitle = "Impact";
        fontText = "Yu Gothic UI";
        colorYellowLight = "255, 206, 31";
        colorYellowDark = "255, 155, 40";
        colorBlueLight = "38, 105, 212";
        colorBlueDark = "23, 60, 120";
        colorGray = "143, 144, 146";
        
        Container canvas = getContentPane();
        
        setLayout(null);
        
        title = new JLabel("Cashier");
        title.setBounds(20, 10, 120, 30);
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setFont(new java.awt.Font(fontTitle, 1, 28));
        
        loginTitle = new JLabel("Bem-vindo");
        loginTitle.setBounds(567, 100, 146, 30);
        loginTitle.setForeground(new java.awt.Color(0, 0, 0));
        loginTitle.setFont(new java.awt.Font(fontTitle, 1, 28));
        
        loginLabel = new JLabel("Login");
        loginLabel.setBounds(515, 207, 640, 30);
        loginLabel.setForeground(new java.awt.Color(0, 0, 0));
        loginLabel.setFont(new java.awt.Font(fontText, 1, 22));
        
        login = new JTextField("");
        login.setBounds(515, 240, 250, 30);
        
        senhaLabel = new JLabel("Senha");
        senhaLabel.setBounds(515, 272, 640, 30);
        senhaLabel.setForeground(new java.awt.Color(0, 0, 0));
        senhaLabel.setFont(new java.awt.Font(fontText, 1, 22));
        
        senha = new JPasswordField("");
        senha.setBounds(515, 305, 250, 30);
        
        header = new JPanel();
        header.setBounds(0, 0, 1280, 55);
        header.setBackground(new java.awt.Color(255, 206, 31));
        
        exitButton = new JButton("Sair");
        exitButton.setBounds(1150, 7, 100, 42);
        exitButton.setFont(new java.awt.Font(fontText, 1, 17));
        exitButton.setBackground(new java.awt.Color(143, 144, 146));
        exitButton.setForeground(new java.awt.Color(255, 255, 255));
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitButton.setBorderPainted(false);
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                if(Connect.exists())
                    Connect.desconectar();
                
                else
                    System.out.println("Sem conexão criada");
                
                System.exit(0);
            }
            
        });
        
        canvas.add(title);
        canvas.add(loginTitle);
        canvas.add(loginLabel);
        canvas.add(login);
        canvas.add(senhaLabel);
        canvas.add(senha);
        canvas.add(exitButton);
        canvas.add(header);
        
        loginButton = new JButton("Entrar");
        loginButton.setBounds(590, 360, 100, 42);
        loginButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginButton.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        loginButton.setFont(new java.awt.Font(fontText, 1, 17));
        loginButton.setBackground(new java.awt.Color(38, 105, 212));
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.setBorderPainted(false);
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                ControllerLogin controllerLogin = new ControllerLogin();
                if(controllerLogin.logar(login.getText(), senha.getText())){
                    Connect.conectar();
                    Principal principal = new Principal();
                    principal.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    setVisible(false);
                }
            }
            
        });
        
        canvas.add(loginButton);        
        
        pack();
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    
    public static void main(String[] args){
        Login login = new Login();
        
        login.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    
}
