package com.lucascampanelli.cashier.DAO;

import com.lucascampanelli.cashier.DAO.factory.*;
import com.lucascampanelli.cashier.model.ModelProdutos;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public class DaoProdutos{
    
    public boolean inserirProduto(ModelProdutos produto){
            try{
                 Connect.getStatement().execute("insert into produto(nome, marca,"
                        + " qnt_vend, val_vend_tot, preco, quant, cod_barras) values ("
                        + "'"+produto.getNome() + "', "
                        + "'"+produto.getMarca() + "', "
                        + 0 + ", "
                        + 0.00 + ", "
                        + produto.getPreco() + ", "
                        + produto.getQuant() + ", "
                        + "'"+produto.getCodBarras() + "'"
                        + ")");
                 return true;
            }
            catch(SQLException e){
                System.out.println("Ocorreu um erro ao inserir os dados. Erro: "+e);
                return false;
            }
    }
}
