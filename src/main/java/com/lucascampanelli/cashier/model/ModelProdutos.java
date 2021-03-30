package com.lucascampanelli.cashier.model;

/**
 *
 * @author lucas
 */
public class ModelProdutos {
    
    private int cod;
    private String nome;
    private String marca;
    private int qtdVenda;
    private double valVendaTotal;
    private String dataEntrada;
    private String codBarras;
    private int quant;
    private double preco;
    
    //Construtor para listagem da base de dados
    public ModelProdutos(
            String nome,
            String marca,
            String codBarras,
            int quant,
            double preco,
            int cod,
            int qtdVenda,
            double valVendaTotal,
            String dataEntrada){
        
        this.nome = nome;
        this.marca = marca;
        this.codBarras = codBarras;
        this.quant = quant;
        this.preco = preco;
        this.cod = cod;
        this.qtdVenda = qtdVenda;
        this.valVendaTotal = valVendaTotal;
        this.dataEntrada = dataEntrada;
        
    }
    
    //Construtor para insert da base de dados
    public ModelProdutos(String nome, String marca, String codBarras, int quant, double preco){
        this.nome = nome;
        this.marca = marca;
        this.codBarras = codBarras;
        this.quant = quant;
        this.preco = preco;
    }
    
    //Construtor para update da base de dados
    public ModelProdutos(int cod, String nome, String marca, String codBarras, int quant, double preco){
        this.cod = cod;
        this.nome = nome;
        this.marca = marca;
        this.codBarras = codBarras;
        this.quant = quant;
        this.preco = preco;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getQtdVenda() {
        return qtdVenda;
    }

    public void setQtdVenda(int qtdVenda) {
        this.qtdVenda = qtdVenda;
    }

    public double getValVendaTotal() {
        return valVendaTotal;
    }

    public void setValVendaTotal(double valVendaTotal) {
        this.valVendaTotal = valVendaTotal;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    
}
