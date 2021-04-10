package com.lucascampanelli.cashier.DAO;

import com.lucascampanelli.cashier.DAO.factory.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author lucas
 */
public class DaoVenda {
    
    public int criarVenda(String cpf, double valTotal,
                        double valDesconto, int qtdItens){
        
        try{            
            Date dataAtual = new Date();
            SimpleDateFormat dataFormatter = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            
            int cliente = criarCliente(cpf);
            
            if(cliente == -1)
                return -1;
            
            Connect.getStatement().execute("insert into venda(data, val_total,"
                            + " val_desconto, qtd_itens, cod_cliente) values ("
                            + "'"+ dataFormatter.format(dataAtual) + "', "
                            + valTotal + ", "
                            + valDesconto + ", "
                            + qtdItens + ", " 
                            + cliente + ")");
        }
        catch(SQLException e){
            System.out.println("Ocorreu um erro ao criar a venda. Erro: "+e);
            return -1;
        }
        
        try{
            ResultSet resultado;
            resultado = Connect
                        .getPreparedStatement("select max(id) from venda")
                                                          .executeQuery();
            return resultado.getInt("max(id)");
        }
        catch(SQLException e){
            System.out.println("Ocorreu um erro ao buscar o id da venda. Erro: "+e);
            return -1;
        }
        
    }
    
    public int criarCliente(String cpf){
        try{
            Connect.getStatement().execute("insert into cliente(cpf) values (" + 
                                                              "'" + cpf + "')");
            
            try{
                ResultSet resultado;
                resultado = Connect
                            .getPreparedStatement("select max(cod_cliente) from cliente")
                                                                         .executeQuery();
                return resultado.getInt("max(cod_cliente)");
            }
            catch(SQLException e){
                System.out.println("Ocorreu um erro ao buscar o código do cliente. Erro: "+e);
                return -1;
            }
            
        }
        catch(SQLException e){
            System.out.println("Ocorreu um erro na inserção do cliente. Erro: "+e);
            return -1;
        }
    }
    
    public boolean inserirItem(int produto, double valor, int venda){
        try{         
            Connect.getStatement().execute("insert into item_venda(cod_produto,"
                            + " valor_venda, id_venda) values ("
                            +  produto + ", "
                            + valor + ", "
                            + venda + ")");
            
            return true;
        }
        catch(SQLException e){
            System.out.println("Ocorreu um erro ao criar a venda. Erro: "+e);
            return false;
        }
    }
    
}
