package com.lucascampanelli.cashier.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.lucascampanelli.cashier.DAO.factory.Connect;
import javax.swing.table.DefaultTableModel;
import com.lucascampanelli.cashier.controller.ControllerProdutos;

/**
 *
 * @author lucas
 */
public class Products extends JFrame{
    
    JLabel title, screenTitleLabel, caixaList, produtosList, financeiroList, relatoriosList, vendasList,
           produtosTitle;
    
    JComboBox corLista;
    
    DefaultTableModel model;
    
    JPanel header, navbar, screenPanel;
    
    JScrollPane scrollPane;
    
    JTable produtos;
    
    JButton exitButton, addButton;
    
    String screenTitle, fontTitle, fontText, colorYellowLight,
           colorBlueLight, colorYellowDark, colorBlueDark, colorGray;
    
    ControllerProdutos controlador = new ControllerProdutos();
    
    public Products(){
        super("Produtos - Cashier");
        
        screenTitle = "Produtos";
        fontTitle = "Impact";
        fontText = "Yu Gothic UI";
        colorYellowLight = "255, 206, 31";
        colorYellowDark = "255, 155, 40";
        colorBlueLight = "38, 105, 212";
        colorBlueDark = "23, 60, 120";
        colorGray = "143, 144, 146";
        
        Container canvas = getContentPane();
        
        setLayout(null);
        
        screenPanel = new JPanel();
        screenPanel.setBounds(120, 200, 1160, 720);
        canvas.add(screenPanel);
        
        screenTitleLabel = new JLabel(screenTitle);
        screenTitleLabel.setBounds(150, 80, 200, 25);
        screenTitleLabel.setForeground(new java.awt.Color(0, 0, 0));
        screenTitleLabel.setFont(new java.awt.Font(fontText, 1, 22));
        
        header = new JPanel();
        header.setBounds(0, 0, 1280, 55);
        header.setBackground(new java.awt.Color(255, 206, 31));
        
        navbar = new JPanel();
        navbar.setBounds(0, 0, 120, 720);
        navbar.setBackground(new java.awt.Color(38, 105, 212));
        
        title = new JLabel("Cashier");
        title.setBounds(20, 10, 120, 30);
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setFont(new java.awt.Font(fontTitle, 1, 28));
        
        produtos = new JTable(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        produtos.setModel(controlador.listarProduto());
        produtos.setBounds(150, 600, 800, 300);
        produtos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for(int i = 0; i < 9; i++){
            if(i == 0)
                produtos.getColumnModel().getColumn(i).setPreferredWidth(50);
            else
                produtos.getColumnModel().getColumn(i).setPreferredWidth(129);
        }
        produtos.getTableHeader().setResizingAllowed(false);;
        screenPanel.add(produtos);
        
        scrollPane = new JScrollPane(produtos);
        scrollPane.setPreferredSize(new Dimension(1100,400));
        screenPanel.add(scrollPane);
        
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
        
        addButton = new JButton("Adicionar");
        addButton.setBounds(150, 120, 115, 42);
        addButton.setFont(new java.awt.Font(fontText, 1, 17));
        addButton.setBackground(new java.awt.Color(143, 144, 146));
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addButton.setBorderPainted(false);
        addButton.setFocusPainted(false);
        addButton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                AddProduto adicionar = new AddProduto();
                adicionar.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                setVisible(false);
            }
            
        });
        
        canvas.add(screenTitleLabel);
        canvas.add(title);
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
    
    public static void main(String[] args){
        Products produtos = new Products();
    }
    
}
