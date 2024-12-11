package br.com.fatecmogidascruzes.model.entity;



public abstract class Usuario implements IUsuario {

    private long id;
    private String email;
    private String nome;
    private String senha;
    private String endereco;
    private String telefone;

    public Usuario(String email, String nome, String senha, String endereco, String telefone) {
        setNome(nome);
        setEmail(email);
        setSenha(senha);
        setEndereco(endereco);
        setTelefone(telefone);
    }

    @Override
    public String getTelefone() {
        return telefone;
    }
    @Override

    public String getSenha() {
        return senha;
    }
    @Override
    public String getNome() {
        return nome;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        try {
            if (id < 0) {
                throw new IllegalArgumentException("ID não pode ser negativo.");
            }
            this.id = id;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Deve ser insirido um ID válido.");
        }
    }
    @Override

    public void setNome(String nome) {
        try {
            if (nome == null || nome.isEmpty()) {
                throw new IllegalArgumentException("Nome do usuário não pode ser vazio.");
            }
            this.nome = nome;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira um nome válido.");
        }
    }
    @Override

    public void setEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser vazio.");
        } 
       this.email = email;
    }
    @Override

    public void setSenha(String senha) {
        if (senha == null || senha.isEmpty()) {
            throw new IllegalArgumentException("Senha não pode ser vazia.");
        }
        this.senha = senha;
    }
    @Override

    public void setEndereco(String endereco) {
        try {
            if (endereco == null || endereco.isEmpty()) {
                throw new IllegalArgumentException("Endereco não pode ser vazio.");
            }
            this.endereco = endereco;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira um endereço válido.");
        }
    }
    @Override

    public void setTelefone(String telefone) {
        try {
            if (telefone == null || telefone.isEmpty()) {
                throw new IllegalArgumentException("Telefone não pode ser vazio.");
            }
            if (telefone.length() != 11) {
                throw new IllegalArgumentException("Telefone inválido.");
            }
            this.telefone = telefone;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira um telefone válido.");
        }
    }
    @Override

    public String getEmail() {
        return email;
    }
    @Override

    public String getEndereco() {
        return endereco;
    }
}