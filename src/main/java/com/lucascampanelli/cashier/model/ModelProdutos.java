package com.lucascampanelli.cashier.model;

/**
 *
 * @author lucas
 */
public class ModelProdutos {
    
    private String nome;
    private String marca;
    private String codBarras;
    private int quant;
    private double preco;
    
    //Construtor se houver código de barras
    public ModelProdutos(String nome, String marca, String codBarras, int quant, double preco){
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
    
}
