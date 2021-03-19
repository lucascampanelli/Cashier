package com.lucascampanelli.cashier.DAO;

import com.lucascampanelli.cashier.DAO.factory.*;
import com.lucascampanelli.cashier.model.ModelProdutos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    
    public ArrayList<ModelProdutos> listarProduto(){
        ArrayList<ModelProdutos> listaProdutos = new ArrayList<>();
        try{
            ResultSet resultado = Connect.getPreparedStatement("select * from produto").executeQuery();
            while(resultado.next()){
                ModelProdutos modelProdutos = new ModelProdutos(
                                        resultado.getString("nome"),
                                        resultado.getString("marca"),
                                        resultado.getString("cod_barras"),
                                        resultado.getInt("quant"),
                                        resultado.getDouble("preco"),
                                        resultado.getInt("cod_produto"),
                                        resultado.getInt("qnt_vend"),
                                        resultado.getDouble("val_vend_tot"),
                                        resultado.getString("data_ent")
                );
                listaProdutos.add(modelProdutos);
            }
            return listaProdutos;
        }
        catch(SQLException e){
            System.out.println("Ocorreu um erro ao buscar os dados. Erro: "+e);
            return null;
        }
    }
}
