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
public final class Products extends JFrame{
    
    JLabel title, screenTitleLabel, caixaList, produtosList, financeiroList, relatoriosList, vendasList,
           produtosTitle;
    
    JComboBox corLista;
    
    DefaultTableModel model;
    
    JPanel header, navbar, screenPanel;
    
    JScrollPane scrollPane;
    
    JTable produtos;
    
    JButton exitButton, addButton, deleteButton, updateButton;
    
    String screenTitle, fontTitle, fontText, colorYellowLight,
           colorBlueLight, colorYellowDark, colorBlueDark, colorGray,
           selectedBarras, selectedNome, selectedMarca;
    
    int selectedId = -1, selectedEstoque;
    
    double selectedPreco;
    
    ControllerProdutos controlador = new ControllerProdutos();
    
    String[] colunas = {
        "Código",
        "Nome",
        "Marca",
        "Val. Unit.",
        "Quantidade"
    };
    
    String[][] dados;
    
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
        screenPanel.setBounds(120, 200, 1160, 410);
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
        
        produtos = new JTable(dados, colunas){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        carregarTabela();
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
        
        deleteButton = new JButton("Excluir");
        deleteButton.setBounds(1135, 620, 115, 42);
        deleteButton.setFont(new java.awt.Font(fontText, 1, 17));
        deleteButton.setBackground(new java.awt.Color(143, 144, 146));
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deleteButton.setBorderPainted(false);
        deleteButton.setFocusPainted(false);
        deleteButton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                int linha = produtos.getSelectedRow();
                
                if(linha >= 0){
                    selectedId = (int) produtos.getValueAt(linha, 0);
                    selectedBarras = String.valueOf(produtos.getValueAt(linha, 1));
                    selectedNome = String.valueOf(produtos.getValueAt(linha, 2));
                    selectedMarca = String.valueOf(produtos.getValueAt(linha, 3));
                    selectedEstoque = (int) produtos.getValueAt(linha, 4);
                    selectedPreco = (double) produtos.getValueAt(linha, 5);
                }
                
                if(selectedId >= 0){
                    int confirm = JOptionPane.showConfirmDialog(null,
                                    "Tem certeza que deseja remover esse produto?",
                                    "Excluir",
                                    JOptionPane.OK_CANCEL_OPTION);
                    
                    if(confirm == 0){
                        if(controlador.excluirProduto(selectedId))
                            carregarTabela();
                    }
                }
            }
            
        });
        canvas.add(deleteButton);
        
        updateButton = new JButton("Atualizar");
        updateButton.setBounds(1000, 620, 115, 42);
        updateButton.setFont(new java.awt.Font(fontText, 1, 17));
        updateButton.setBackground(new java.awt.Color(143, 144, 146));
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        updateButton.setBorderPainted(false);
        updateButton.setFocusPainted(false);
        updateButton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                int linha = produtos.getSelectedRow();
                
                if(linha >= 0){
                    selectedId = (int) produtos.getValueAt(linha, 0);
                    selectedBarras = String.valueOf(produtos.getValueAt(linha, 1));
                    selectedNome = String.valueOf(produtos.getValueAt(linha, 2));
                    selectedMarca = String.valueOf(produtos.getValueAt(linha, 3));
                    selectedEstoque = (int) produtos.getValueAt(linha, 4);
                    selectedPreco = (double) produtos.getValueAt(linha, 5);
                }
                
                if(selectedId >= 0){
                    UpdateProduto atualizar = new UpdateProduto(selectedId,
                                                                selectedNome,
                                                                selectedMarca,
                                                                selectedBarras,
                                                                selectedPreco,
                                                                selectedEstoque);
                    atualizar.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    setVisible(false);
                }
            }
            
        });
        canvas.add(updateButton);
        
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
    
    public void carregarTabela(){
        produtos.setModel(controlador.listarProduto());
        produtos.setBounds(150, 600, 800, 300);
        produtos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        produtos.getColumnModel().getColumn(0).setPreferredWidth(50);
        produtos.getColumnModel().getColumn(2).setPreferredWidth(160);
        produtos.getColumnModel().getColumn(8).setPreferredWidth(129);
        produtos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        produtos.getTableHeader().setResizingAllowed(false);
        produtos.setRowHeight(35);
    }
    
    public static void main(String[] args){
        Products produtos = new Products();
    }
    
}
