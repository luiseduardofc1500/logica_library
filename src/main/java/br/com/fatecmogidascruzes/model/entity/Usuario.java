package br.com.fatecmogidascruzes.model.entity;

public class Usuario implements IUsuario {
    private String nome;
    private String email;
    private String senha;
    private String endereco;
    private String telefone;
    private Long id;

    /*@ public normal_behavior
     @ ensures nome == nome;
     @ ensures email == email;
     @ ensures senha == senha;
     @ ensures endereco == endereco;
     @ ensures telefone == telefone;
     @ pure
     @*/
    public Usuario(String nome, String email, String senha, String endereco, String telefone) {
        setNome(nome);
        setEmail(email);
        setSenha(senha);
        setEndereco(endereco);
        setTelefone(telefone);
    }

    /*@ ensures \result != null && !\result.isEmpty(); @*/
    @Override
    public String getNome() {
        return nome;
    }

    /*@ requires nome != null && !nome.isEmpty(); @*/
    /*@ ensures getNome().equals(nome); @*/
    @Override
    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    /*@ ensures \result != null && !\result.isEmpty(); @*/
    @Override
    public String getEmail() {
        return email;
    }

    /*@ requires email != null && !email.isEmpty(); @*/
    /*@ ensures getEmail().equals(email); @*/
    @Override
    public void setEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("O email não pode ser nulo ou vazio.");
        }
        this.email = email;
    }

    /*@ ensures \result != null && !\result.isEmpty(); @*/
    @Override
    public String getSenha() {
        return senha;
    }

    /*@ requires senha != null && senha.length() >= 8
      @ && (\exists int i; 0 <= i < senha.length(); Character.isUpperCase(senha.charAt(i)))
      @ && (\exists int i; 0 <= i < senha.length(); !Character.isLetterOrDigit(senha.charAt(i))); @*/
    /*@ ensures getSenha().equals(senha); @*/
    @Override
    public void setSenha(String senha) {
        if (senha == null || senha.isEmpty()) {
            throw new IllegalArgumentException("A senha não pode ser nula ou vazia.");
        }
        if (senha.length() < 8) {
            throw new IllegalArgumentException("A senha deve ter pelo menos 8 caracteres.");
        }
        if (senha.chars().noneMatch(Character::isUpperCase)) {
            throw new IllegalArgumentException("A senha deve conter pelo menos uma letra maiúscula.");
        }
        if (senha.chars().noneMatch(ch -> !Character.isLetterOrDigit(ch))) {
            throw new IllegalArgumentException("A senha deve conter pelo menos um caractere especial.");
        }
        this.senha = senha;
    }

    /*@ ensures \result != null && !\result.isEmpty(); @*/
    @Override
    public String getEndereco() {
        return endereco;
    }

    /*@ requires endereco != null && !endereco.isEmpty(); @*/
    /*@ ensures getEndereco().equals(endereco); @*/
    @Override
    public void setEndereco(String endereco) {
        if (endereco == null || endereco.isEmpty()) {
            throw new IllegalArgumentException("O endereço não pode ser nulo ou vazio.");
        }
        this.endereco = endereco;
    }

    /*@ ensures \result != null && !\result.isEmpty(); @*/
    @Override
    public String getTelefone() {
        return telefone;
    }

    /*@ requires telefone != null && !telefone.isEmpty(); @*/
    /*@ ensures getTelefone().equals(telefone); @*/
    @Override
    public void setTelefone(String telefone) {
        if (telefone == null || telefone.isEmpty()) {
            throw new IllegalArgumentException("O telefone não pode ser nulo ou vazio.");
        }
        this.telefone = telefone;
    }


    /*@
   @ requires id != null;
   @ requires id >= 0;
   @ ensures this.id == id;
   @*/
    public void setId(Long id) {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("O ID não pode ser nulo ou negativo.");
        }
        this.id = id;
    }

    /*@
      @ ensures \result != null;
      @ ensures \result >= 0;
      @ ensures \result == this.id;
      @*/
    public Long getId() {
        return id;
    }
}
