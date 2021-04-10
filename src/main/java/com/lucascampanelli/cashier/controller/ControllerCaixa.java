package com.lucascampanelli.cashier.controller;

import com.lucascampanelli.cashier.DAO.DaoProdutos;
import com.lucascampanelli.cashier.model.ModelProdutos;
import com.lucascampanelli.cashier.DAO.DaoVenda;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lucas
 */
public class ControllerCaixa {
    
    private String[] columns = {
        "Código",
        "Nome",
        "Marca",
        "Preço Unitário",
    };
    private DefaultTableModel model = new DefaultTableModel(columns, 0);
    private DaoProdutos DAO = new DaoProdutos();
    private DaoVenda DAOVenda = new DaoVenda();
    
    public DefaultTableModel listarProdutos(String cod){
        ArrayList<ModelProdutos> lista = new ArrayList<>();
        lista = this.DAO.listarProduto("select * from produto where cod_barras = '"+cod+"'");
        for(int i = 0; i < lista.size(); i++){
            this.model.addRow(new Object[]{
                lista.get(i).getCodBarras(),
                lista.get(i).getNome(),
                lista.get(i).getMarca(),
                lista.get(i).getPreco()
            });
        }
        
        return model;
    }
    
    public double valorTotal(String cod){
        ArrayList<ModelProdutos> lista = new ArrayList<>();
        lista = this.DAO.listarProduto("select * from produto where cod_barras = '"+cod+"'");
        for(int i = 0; i < lista.size(); i++){
            return lista.get(i).getPreco();
        }
        
        return 0;
    }
    
    public boolean finalizarCompra(JTable produtos, String cpf, double valTotal, double valDesconto){
        int quantProdutos = produtos.getModel().getRowCount();
        int venda = DAOVenda.criarVenda(cpf, valTotal, valDesconto, quantProdutos);
        ArrayList<ModelProdutos> lista = new ArrayList<>();
        
        if(venda > 0){
            for(int i = 0; i < quantProdutos; i++){
                
                lista = DAO.listarProduto("select * from produto where cod_barras = '"+
                                     produtos.getModel().getValueAt(i, 0)+"'");
                
                if(!(DAOVenda.inserirItem(lista.get(0).getCod(),
                                         lista.get(0).getPreco(),
                                         venda))){

                    return false;

                }
                
            }
            return true;
        }
        else{
            return false;
        }
    }
    
}
