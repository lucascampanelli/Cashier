package com.lucascampanelli.cashier.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.lucascampanelli.cashier.DAO.factory.Connect;
import com.lucascampanelli.cashier.util.NumberFieldFormat;
import com.lucascampanelli.cashier.util.CurrencyFieldFormat;
import com.lucascampanelli.cashier.controller.ControllerProdutos;

/**
 *
 * @author lucas
 */
public class UpdateProduto extends JFrame{
    
    JLabel title, screenTitleLabel, caixaList, produtosList, financeiroList, relatoriosList, vendasList,
           produtosTitle, nomeLabel, marcaLabel, precoLabel, quantLabel, codBarrasLabel;
    
    JTextField nomeField, marcaField, codBarrasField, precoField;
    
    JFormattedTextField quantField;
    
    JComboBox corLista;
    
    JPanel header, navbar;
    
    JButton exitButton, addButton;
    
    String screenTitle, fontTitle, fontText, colorYellowLight,
           colorBlueLight, colorYellowDark, colorBlueDark, colorGray;
    
    int codProduto;
    
    NumberFieldFormat numberFormat = new NumberFieldFormat();
    CurrencyFieldFormat currencyFormat = new CurrencyFieldFormat();
    
    public UpdateProduto(int cod, String nome, String marca, String codBarras, double preco, int quant){
        super("Atualizar produto - Cashier");
        
        codProduto = cod;
        
        screenTitle = "Atualizar produto";
        fontTitle = "Impact";
        fontText = "Yu Gothic UI";
        colorYellowLight = "255, 206, 31";
        colorYellowDark = "255, 155, 40";
        colorBlueLight = "38, 105, 212";
        colorBlueDark = "23, 60, 120";
        colorGray = "143, 144, 146";
        
        Container canvas = getContentPane();
        
        setLayout(null);
        
        screenTitleLabel = new JLabel(screenTitle);
        screenTitleLabel.setBounds(150, 80, 200, 25);
        screenTitleLabel.setForeground(new java.awt.Color(0, 0, 0));
        screenTitleLabel.setFont(new java.awt.Font(fontText, 1, 22));
        
        // Campos para cadastro
        
        nomeLabel = new JLabel("Nome");
        nomeLabel.setBounds(152, 140, 100, 15);
        
        nomeField = new JTextField("");
        nomeField.setBounds(150, 160, 250, 30);
        nomeField.setText(nome);
        
        marcaLabel = new JLabel("Marca");
        marcaLabel.setBounds(502, 140, 100, 15);
        
        marcaField = new JTextField("");
        marcaField.setBounds(500, 160, 250, 30);
        marcaField.setText(marca);
        
        precoLabel = new JLabel("Preço (R$)");
        precoLabel.setBounds(152, 200, 100, 15);
        
        //precoField = new JFormattedTextField(currencyFormat.getFormatter());
        precoField = new JTextField("");
        precoField.setBounds(150, 220, 250, 30);
        precoField.setText(String.valueOf(preco));
        
        quantLabel = new JLabel("Quantidade (Unidades)");
        quantLabel.setBounds(502, 200, 120, 15);
        
        quantField = new JFormattedTextField(numberFormat.getFormatter());
        quantField.setBounds(500, 220, 250, 30);
        quantField.setValue(quant);
        
        codBarrasLabel = new JLabel("Código de barras");
        codBarrasLabel.setBounds(152, 260, 100, 15);
        
        codBarrasField = new JTextField("");
        codBarrasField.setBounds(150, 280, 250, 30);
        codBarrasField.setText(codBarras);
        
        // ------------------------
        
        // Cabeçalho
        
        header = new JPanel();
        header.setBounds(0, 0, 1280, 55);
        header.setBackground(new java.awt.Color(255, 206, 31));
        
        title = new JLabel("Cashier");
        title.setBounds(20, 10, 120, 30);
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setFont(new java.awt.Font(fontTitle, 1, 28));
        
        // ------------------------
        
        // Barra de navegação
        
        navbar = new JPanel();
        navbar.setBounds(0, 0, 120, 720);
        navbar.setBackground(new java.awt.Color(38, 105, 212));
        
        caixaList = new JLabel("- Caixa");
        caixaList.setBounds(15, 72, 100, 15);
        caixaList.setForeground(new java.awt.Color(255, 255, 255));
        caixaList.setFont(new java.awt.Font(fontText, 1, 17));
        caixaList.setCursor(new Cursor(Cursor.HAND_CURSOR));
        caixaList.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                Caixa caixa = new Caixa();
                caixa.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                setVisible(false);
            }
                    
        });
        
        produtosList = new JLabel("- Produtos");
        produtosList.setBounds(15, 105, 100, 15);
        produtosList.setForeground(new java.awt.Color(255, 255, 255));
        produtosList.setFont(new java.awt.Font(fontText, 1, 17));
        produtosList.setCursor(new Cursor(Cursor.HAND_CURSOR));
        produtosList.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                Products produto = new Products();
                produto.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                setVisible(false);
            }
                    
        });
        
        financeiroList = new JLabel("- Financeiro");
        financeiroList.setBounds(15, 138, 100, 15);
        financeiroList.setForeground(new java.awt.Color(255, 255, 255));
        financeiroList.setFont(new java.awt.Font(fontText, 1, 17));
        financeiroList.setCursor(new Cursor(Cursor.HAND_CURSOR));
        financeiroList.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                Financeiro financeiro = new Financeiro();
                financeiro.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                setVisible(false);
            }
                    
        });
        
        relatoriosList = new JLabel("- Relatórios");
        relatoriosList.setBounds(15, 171, 100, 15);
        relatoriosList.setForeground(new java.awt.Color(255, 255, 255));
        relatoriosList.setFont(new java.awt.Font(fontText, 1, 17));
        relatoriosList.setCursor(new Cursor(Cursor.HAND_CURSOR));
        relatoriosList.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                Relatorios relatorios = new Relatorios();
                relatorios.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                setVisible(false);
            }
                    
        });
        
        vendasList = new JLabel("- Vendas");
        vendasList.setBounds(15, 204, 100, 15);
        vendasList.setForeground(new java.awt.Color(255, 255, 255));
        vendasList.setFont(new java.awt.Font(fontText, 1, 17));
        vendasList.setCursor(new Cursor(Cursor.HAND_CURSOR));
        vendasList.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                Vendas vendas = new Vendas();
                vendas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                setVisible(false);
            }
                    
        });
        
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
                Connect.desconectar();
                System.exit(0);
            }
            
        });
        
        addButton = new JButton("Atualizar");
        addButton.setBounds(583, 400, 115, 42);
        addButton.setFont(new java.awt.Font(fontText, 1, 17));
        addButton.setBackground(new java.awt.Color(143, 144, 146));
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addButton.setBorderPainted(false);
        addButton.setFocusPainted(false);
        addButton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                ControllerProdutos controlador = new ControllerProdutos();
                if(controlador.atualizarProduto(
                        codProduto,
                        nomeField.getText(),
                        marcaField.getText(),
                        codBarrasField.getText(),
                        Integer.parseInt(quantField.getText().trim()),
                        Double.parseDouble(precoField.getText())
                ))
                    JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
                else
                    JOptionPane.showConfirmDialog(null,
                    "Erro ao atualizar o produto. Consulte o administrador!");
            }
            
        });
        
        // ------------------------
        
        canvas.add(title);
        canvas.add(screenTitleLabel);
        canvas.add(nomeLabel);
        canvas.add(nomeField);
        canvas.add(marcaLabel);
        canvas.add(marcaField);
        canvas.add(precoLabel);
        canvas.add(precoField);
        canvas.add(quantLabel);
        canvas.add(quantField);
        canvas.add(codBarrasLabel);
        canvas.add(codBarrasField);
        canvas.add(exitButton);
        canvas.add(addButton);
        canvas.add(header);
        canvas.add(caixaList);
        canvas.add(produtosList);
        canvas.add(financeiroList);
        canvas.add(relatoriosList);
        canvas.add(vendasList);
        canvas.add(navbar);
        
        pack();
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    
}
