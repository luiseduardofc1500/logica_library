package br.com.fatecmogidascruzes.model.entity;

public class Usuario implements IUsuario {
    private String nome; //@ in nome2;
    private String email; //@ in email2;
    private String senha;//@ in senha2;
    private String endereco;//@ in endereco2;
    private String telefone;//@ in telefone2;
    private int id;//@ in id2;
    //@ spec_public
    private static int count = 0;

    //@ private represents nome2 = this.nome;
    //@ private represents email2 = this.email;
    //@ private represents senha2 = this.senha;
    //@ private represents endereco2 = this.endereco;
    //@ private represents telefone2 = this.telefone;
    //@ private represents id2 = this.id;



    //@ public normal_behavior
    //@ 	requires nome != "";
    //@		requires email != "";
    //@		requires senha != "" && senha.length() >= 8;
    //@		requires endereco != "";
    //@		requires telefone != "";
    //@ 	requires count < Integer.MAX_VALUE;
    //@ 	assigns count;
    //@ 	ensures nome2 == nome;
    //@		ensures email2 == email;
    //@ 	ensures senha2 == senha;
    //@ 	ensures endereco2 == endereco;
    //@ 	ensures id2 == count;
    //@ 	ensures count == \old(count) + 1;
    public Usuario(String nome, String email, String senha, String endereco, String telefone) {
        //@ assume count+1 < Integer.MAX_VALUE;
        count++;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
        this.telefone = telefone;
        this.id = count;
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


    public int getId() {
        return id;
    }


    public void setId(int id) {
       this.id = id;
    }
}
