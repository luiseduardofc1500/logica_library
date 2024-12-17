package br.com.fatecmogidascruzes.model.entity;

public class Usuario implements IUsuario {
    private String nome; //@ in nome2;
    private String email; //@ in email2;
    private String senha;//@ in senha2;
    private String endereco;//@ in endereco2;
    private String telefone;//@ in telefone2;


    //@ private represents nome2 = this.nome;
    //@ private represents email2 = this.email;
    //@ private represents senha2 = this.senha;
    //@ private represents endereco2 = this.endereco;
    //@ private represents telefone2 = this.telefone;



    //@ public normal_behavior
    //@ 	requires nome != "";
    //@		requires email != "";
    //@		requires senha != "" && senha.length() >= 8;
    //@		requires endereco != "";
    //@		requires telefone != "";
    //@ 	ensures nome2 == nome;
    //@		ensures email2 == email;
    //@ 	ensures senha2 == senha;
    //@ 	ensures endereco2 == endereco;
    public Usuario(String nome, String email, String senha, String endereco, String telefone) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
        this.telefone = telefone;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
         this.nome = nome;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getSenha() {
        return senha;
    }


    public void setSenha(String senha) {
       this.senha = senha;
    }


    public String getEndereco() {
        return endereco;
    }


    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public String getTelefone() {
        return telefone;
    }


    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


}
