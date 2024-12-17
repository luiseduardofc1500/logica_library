package br.com.fatecmogidascruzes.model.entity;

public class Cliente extends Usuario {
    //@ spec_public
    private String metodoPagamento;


    //@ public normal_behavior
    //@   requires nome != "";
    //@   requires email != "" && email.endsWith("@cliente.com") ;
    //@   requires senha != "" && senha.length() >= 8;
    //@   requires endereco != "";
    //@   requires telefone != "";
    //@   requires metodoPagamento != "";
    //@   ensures nome2 == nome;
    //@   ensures email2 == email;
    //@   ensures senha2 == senha;
    //@   ensures endereco2 == endereco;
    //@   ensures telefone2 == telefone;
    public Cliente(String nome, String email, String senha, String endereco, String telefone, String metodoPagamento) {
        super(nome, email, senha, endereco, telefone);
        this.metodoPagamento = metodoPagamento;
    }

    //@ public normal_behavior
    //@   ensures \result == metodoPagamento;
    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    //@ public normal_behavior
    //@   requires metodoPagamento != "";
    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
    //@ also
    //@ requires email != "" && email.endsWith("@cliente.com");
    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }
}
