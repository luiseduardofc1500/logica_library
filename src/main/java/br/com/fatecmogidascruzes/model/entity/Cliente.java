package br.com.fatecmogidascruzes.model.entity;



import java.time.LocalDate;


public class Cliente extends Usuario {

    private String metodoPagamento;

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    private LocalDate dataCadastro;

    public Cliente(String email, String nome, String senha, String endereco, String telefone,String metodoPagamento, LocalDate dataCadastro) {
        super(email, nome, senha, endereco, telefone);
        setMetodoPagamento(metodoPagamento);
        setDataCadastro(dataCadastro);
    }

    @Override
    public void setId(long id) {
        super.setId(id);
    }

    public void setMetodoPagamento(String metodoPagamento) {
        try {
            if (metodoPagamento == null || metodoPagamento.isEmpty()) {
                throw new IllegalArgumentException("Metodo de pagamento do cliente não pode ser vazio.");
            }
            this.metodoPagamento = metodoPagamento;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira um metodo de pagamento válido.");
        }
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        try {
            if (dataCadastro == null) {
                throw new IllegalArgumentException("Data de cadastro do cliente não pode ser vazio.");
            }
            this.dataCadastro = dataCadastro;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " Por favor insira uma data de cadastro para o cliente.");
        }
    }

    @Override
    public String toString() {
        return "\n Cliente {" +
                "\n  Id = " + getId() +
                "\n  Email = " + getEmail() +
                "\n  Nome = " + getNome() +
                "\n  Endereco = " + getEndereco() +
                "\n  Telefone = " + getTelefone() +
                "\n  Metodo de Pagamento = " + metodoPagamento +
                "\n  Data de Cadastro = " + dataCadastro +
                "\n }\n";
    }
}