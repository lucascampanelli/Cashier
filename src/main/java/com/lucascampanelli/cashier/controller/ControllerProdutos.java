package com.lucascampanelli.cashier.controller;

import com.lucascampanelli.cashier.model.ModelProdutos;
import com.lucascampanelli.cashier.DAO.DaoProdutos;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lucas
 */
public class ControllerProdutos {
    
    DaoProdutos DAO = new DaoProdutos();
    
    public void inserirProduto(String nome, String marca, String codBarras, int quant, double preco){
        //Criando modelo com os atributos passados pela view (com código de barras)
        ModelProdutos produto = new ModelProdutos(nome, marca, codBarras, quant, preco);
        System.out.println(nome + "" + marca + "" + codBarras + "" + quant + "" + preco);
        //Enviando modelo para o DAO realizar a inserção
        DAO.inserirProduto(produto);
    }
    
    public DefaultTableModel listarProduto(){
        ArrayList<ModelProdutos> lista = new ArrayList<>();
        lista = DAO.listarProduto();
        String[] columns = {
        "Cód.",
        "Cód Barras",
        "Nome",
        "Marca",
        "Quant Estoque",
        "Preço",
        "Qnt Vendido",
        "Val Total Vendido",
        "Data cadastro"
        };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        for(int i = 0; i < lista.size(); i++){
            model.addRow(new Object[]{
                lista.get(i).getCod(),
                lista.get(i).getCodBarras(),
                lista.get(i).getNome(),
                lista.get(i).getMarca(),
                lista.get(i).getQuant(),
                lista.get(i).getPreco(),
                lista.get(i).getQtdVenda(),
                lista.get(i).getValVendaTotal(),
                lista.get(i).getDataEntrada()
            });
        }
        
        return model;
    }
    
}
