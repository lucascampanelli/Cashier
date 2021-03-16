package com.lucascampanelli.cashier.controller;

import com.lucascampanelli.cashier.model.ModelProdutos;
import com.lucascampanelli.cashier.DAO.DaoProdutos;

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
    
}
