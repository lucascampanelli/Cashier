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
    
    public ArrayList<ModelProdutos> listarProduto(String query){
        ArrayList<ModelProdutos> listaProdutos = new ArrayList<>();
        try{
            ResultSet resultado = Connect.getPreparedStatement(query).executeQuery();
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
    
    public boolean atualizarProduto(ModelProdutos produto){
        try{
            if(!(produto.getCodBarras().equals(""))){
                System.out.println("update produto set "+
                                                        "nome = '"+produto.getNome()
                                                        +"', marca = '"+produto.getMarca()
                                                        +"', preco = "+produto.getPreco()
                                                        +", quant = '"+produto.getQuant()
                                                        +"', cod_barras = '"+produto.getCodBarras()
                                                        +"' where cod_produto = "+produto.getCod());
                Connect.getPreparedStatement("update produto set "+
                                                        "nome = '"+produto.getNome()
                                                        +"', marca = '"+produto.getMarca()
                                                        +"', preco = "+produto.getPreco()
                                                        +", quant = '"+produto.getQuant()
                                                        +"', cod_barras = '"+produto.getCodBarras()
                                                        +"' where cod_produto = "+produto.getCod())
                                                                                  .executeUpdate();
            }
            else{
                System.out.println("update produto set "+
                                                        "nome = '"+produto.getNome()
                                                        +"', marca = '"+produto.getMarca()
                                                        +"', preco = "+produto.getPreco()
                                                        +", quant = '"+produto.getQuant()
                                                        +"' where cod_produto = "+produto.getCod());
                Connect.getPreparedStatement("update produto set "+
                                                        "nome = '"+produto.getNome()
                                                        +"', marca = '"+produto.getMarca()
                                                        +"', preco = "+produto.getPreco()
                                                        +", quant = '"+produto.getQuant()
                                                        +"' where cod_produto = "+produto.getCod())
                                                                                  .executeUpdate();
            }
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean excluirProduto(int cod){
        try{
            Connect.getPreparedStatement("delete from produto where cod_produto = "+cod).executeUpdate();
            return true;
        }
        catch(SQLException e){
            System.out.println("Ocorreu um erro ao excluir o produto. Erro: "+e);
            return false;
        }
    }
    
}
