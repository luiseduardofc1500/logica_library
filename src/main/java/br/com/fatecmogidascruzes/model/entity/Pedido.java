package br.com.fatecmogidascruzes.model.entity;

import java.time.LocalDate;

public class Pedido {

    /*@ spec_public @*/
    private long id;

    /*@ spec_public @*/
    private String emailCliente;

    /*@ spec_public @*/
    private String tituloLivro;

    /*@ spec_public @*/
    private LocalDate dataPedido;

    /*@ spec_public @*/
    private int statusPedido = 1;

    /*@ spec_public @*/
    private double precoTotal;

    /*@ spec_public @*/
    private String enderecoEntrega;

    /*@
      @ requires emailCliente != null && !emailCliente.isEmpty();
      @ requires tituloLivro != null && !tituloLivro.isEmpty();
      @ requires dataPedido != null;
      @ requires statusPedido >= 1 && statusPedido <= 3;
      @ requires precoTotal >= 0;
      @ requires endrecoEntrega != null && !endrecoEntrega.isEmpty();
      @
      @ ensures this.emailCliente == emailCliente;
      @ ensures this.tituloLivro == tituloLivro;
      @ ensures this.dataPedido == dataPedido;
      @ ensures this.statusPedido == statusPedido;
      @ ensures this.precoTotal == precoTotal;
      @ ensures this.enderecoEntrega == endrecoEntrega;
      @*/
    public Pedido(String emailCliente, String tituloLivro, LocalDate dataPedido, int statusPedido, double precoTotal, String endrecoEntrega) {
        this.emailCliente = emailCliente;
        this.tituloLivro = tituloLivro;
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
        this.precoTotal = precoTotal;
        this.enderecoEntrega = endrecoEntrega;
    }

    //@ pure
    public long getId() {
        return id;
    }

    //@ pure
    public String getEmailCliente() {
        return emailCliente;
    }

    //@ pure
    public String getTituloLivro() {
        return tituloLivro;
    }

    //@ pure
    public LocalDate getDataPedido() {
        return dataPedido;
    }

    //@ pure
    public int getStatusPedido() {
        return statusPedido;
    }

    //@ pure
    public double getPrecoTotal() {
        return precoTotal;
    }

    //@ pure
    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    /*@
      @ requires id >= 0;
      @ ensures this.id == id;
      @*/
    public void setId(long id) {
        this.id = id;
    }
}
