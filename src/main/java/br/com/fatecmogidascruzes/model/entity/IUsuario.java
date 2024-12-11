package br.com.fatecmogidascruzes.model.entity;

public interface IUsuario {
    String getNome();
    void setNome(String nome);
    String getEmail();
    void setEmail(String email);
    String getSenha();
    void setSenha(String senha);
    String getEndereco();
    void setEndereco(String endereco);
    String getTelefone();
    void setTelefone(String telefone);
}

