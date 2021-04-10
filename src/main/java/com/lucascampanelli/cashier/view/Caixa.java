package com.lucascampanelli.cashier.view;

import com.lucascampanelli.cashier.controller.ControllerCaixa;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lucas
 */
public class Caixa extends JFrame{
    
    JLabel title, caixaList, produtosList, financeiroList, relatoriosList, vendasList,
           produtosTitle, subTotalLabel, totalLabel, subTotalValue, totalValue, 
           finalizarLabel, sairLabel;
    
    JComboBox corLista;
    
    JPanel header, navbar, vendasPanel;
    
    JButton exitButton, finalizarButton, cancelarButton;
    
    JTable produtos;
    
    JTextField codInput;
    
    JScrollPane scrollPane;
    
    String fontTitle, fontText, colorYellowLight,
           colorBlueLight, colorYellowDark, colorBlueDark, colorGray;
    
    ControllerCaixa controlador = new ControllerCaixa();
    
    double subTotal = 0.0, total = 0.0;
    
    public Caixa(){
        super("Caixa - Cashier");
        
        fontTitle = "Impact";
        fontText = "Yu Gothic UI";
        colorYellowLight = "255, 206, 31";
        colorYellowDark = "255, 155, 40";
        colorBlueLight = "38, 105, 212";
        colorBlueDark = "23, 60, 120";
        colorGray = "143, 144, 146";
        
        Container canvas = getContentPane();
        
        setLayout(null);
        
        vendasPanel = new JPanel();
        vendasPanel.setBounds(150, 120, 500, 410);
        //vendasPanel.setLayout(null);
        canvas.add(vendasPanel);
        
        produtos = new JTable(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        produtos.setBounds(0, 600, 800, 300);
        produtos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        produtos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        produtos.getTableHeader().setResizingAllowed(false);
        produtos.setRowHeight(35);
        produtos.getTableHeader().setBackground(new java.awt.Color(255, 155, 40));
        produtos.getTableHeader().setForeground(new java.awt.Color(255, 255, 255));
        produtos.getTableHeader().setFont(new java.awt.Font(fontText, 1, 14));
        produtos.setShowGrid(false);
        produtos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, 
                                                           Object value, 
                                                           boolean isSelected, 
                                                           boolean hasFocus, 
                                                           int row, 
                                                           int column)
            {
                final Component c = super.getTableCellRendererComponent(table,
                                                                        value,
                                                                        isSelected,
                                                                        hasFocus,
                                                                        row,
                                                                        column);
                c.setBackground(row % 2 == 0 ? new java.awt.Color(255, 255, 255) : new java.awt.Color(226, 226, 226));
                return c;
            }
        });
        vendasPanel.add(produtos);
        
        scrollPane = new JScrollPane(produtos);
        scrollPane.setPreferredSize(new Dimension(500,410));
        vendasPanel.add(scrollPane);
        
        subTotalLabel = new JLabel("Subtotal");
        subTotalLabel.setBounds(1093, 500, 80, 50);
        subTotalLabel.setFont(new java.awt.Font(fontText, 1, 17));
        subTotalLabel.setForeground(new java.awt.Color(0, 0, 0));
        canvas.add(subTotalLabel);
        
        subTotalValue = new JLabel("R$ 0,00");
        subTotalValue.setBounds(1177, 500, 87, 50);
        subTotalValue.setFont(new java.awt.Font(fontText, 1, 17));
        subTotalValue.setForeground(new java.awt.Color(0, 0, 0));
        canvas.add(subTotalValue);
        
        totalLabel = new JLabel("Total");
        totalLabel.setBounds(1093, 540, 80, 50);
        totalLabel.setFont(new java.awt.Font(fontText, 1, 17));
        totalLabel.setForeground(new java.awt.Color(0, 0, 0));
        canvas.add(totalLabel);
        
        totalValue = new JLabel("R$ 0,00");
        totalValue.setBounds(1177, 540, 87, 50);
        totalValue.setFont(new java.awt.Font(fontText, 1, 17));
        totalValue.setForeground(new java.awt.Color(0, 0, 0));
        canvas.add(totalValue);
        
        codInput = new JTextField();
        codInput.setBounds(150, 620, 500, 35);
        codInput.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    carregarTabela(controlador.listarProdutos(codInput.getText()));
                    total += controlador.valorTotal(codInput.getText());
                    subTotal += controlador.valorTotal(codInput.getText());
                    subTotalValue.setText("RS "+subTotal);
                    totalValue.setText("RS "+total);
                }
            }
        });
        canvas.add(codInput);
        
        finalizarLabel = new JLabel("F1 - Finalizar venda");
        finalizarLabel.setBounds(1080, 103, 160, 50);
        finalizarLabel.setFont(new java.awt.Font(fontText, 1, 17));
        finalizarLabel.setForeground(new java.awt.Color(86, 86, 86));
        canvas.add(finalizarLabel);
        
        sairLabel = new JLabel("F2 - Cancelar venda");
        sairLabel.setBounds(1080, 123, 160, 50);
        sairLabel.setFont(new java.awt.Font(fontText, 1, 17));
        sairLabel.setForeground(new java.awt.Color(86, 86, 86));
        canvas.add(sairLabel);
        
        finalizarButton = new JButton("Finalizar");
        finalizarButton.setBounds(1150, 613, 100, 42);
        finalizarButton.setFont(new java.awt.Font(fontText, 1, 17));
        finalizarButton.setBackground(new java.awt.Color(38,105,212));
        finalizarButton.setForeground(new java.awt.Color(255, 255, 255));
        finalizarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        finalizarButton.setBorderPainted(false);
        finalizarButton.setFocusPainted(false);
        finalizarButton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                controlador.finalizarCompra(produtos, "", total, 0.00);
                /*int quantProdutos = produtos.getModel().getRowCount();
                for(int i = 0; i < quantProdutos; i++){
                    System.out.println(produtos.getModel().getValueAt(WIDTH, ICONIFIED));
                }*/
            }
            
        });
        canvas.add(finalizarButton);
        
        cancelarButton = new JButton("Cancelar");
        cancelarButton.setBounds(1030, 613, 100, 42);
        cancelarButton.setFont(new java.awt.Font(fontText, 1, 17));
        cancelarButton.setBackground(new java.awt.Color(143, 144, 146));
        cancelarButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancelarButton.setBorderPainted(false);
        cancelarButton.setFocusPainted(false);
        cancelarButton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
            
        });
        canvas.add(cancelarButton);
        
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
                System.exit(0);
            }
            
        });
        
        Frame.getFrames();
        
        canvas.add(title);
        canvas.add(exitButton);
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
    
    public void carregarTabela(DefaultTableModel model){
        produtos.setModel(model);
        produtos.getColumnModel().getColumn(0).setPreferredWidth(80);
        produtos.getColumnModel().getColumn(1).setPreferredWidth(200);
        produtos.getColumnModel().getColumn(2).setPreferredWidth(112);
        produtos.getColumnModel().getColumn(3).setPreferredWidth(90);
    }
    
    public static void main(String args[]){
        Caixa caixa = new Caixa();
    }
    
}
