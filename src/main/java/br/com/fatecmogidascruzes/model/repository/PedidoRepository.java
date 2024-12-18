package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Pedido;
import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {

    //@ spec_public
    private static final List<Pedido> pedidos = new ArrayList<>();

    //@ spec_public
    private static long ultimoId = 0;

    /*@
      @ requires pedido != null;
      @ assignable ultimoId, pedidos;
      @ ensures pedidos.contains(pedido);
      @ ensures pedido.getId() == ultimoId;
      @ skipesc
      @*/
    public static void save(Pedido pedido) {
        pedido.setId(++ultimoId);
        pedidos.add(pedido);
    }

    /*@
      @ ensures \result != null;
      @ skipesc
      @*/
    public static List<Pedido> findAll(){
        return pedidos;
    }

    /*@
      @ ensures (\exists Pedido p; pedidos.contains(p) && p.getId() == id; \result == p)
      @     || (\forall Pedido p; pedidos.contains(p); p.getId() != id) ==> \result == null;
      @*/
    public static Pedido findById(long id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }

    /*@
      @ requires emailCliente != null;
      @ ensures \result != null;
      @*/
    public static List<Pedido> findByEmailCliente(String emailCliente) {
        List<Pedido> result = new ArrayList<>();
        String emailClienteUpper = emailCliente.toUpperCase();
        for (Pedido pedido : pedidos) {
            if (pedido.getEmailCliente().toUpperCase().contains(emailClienteUpper)) {
                result.add(pedido);
            }
        }
        return result;
    }

    /*@
      @ requires tituloLivro != null;
      @ ensures \result != null;
      @*/
    public static List<Pedido> findByTituloLivro(String tituloLivro){
        List<Pedido> result = new ArrayList<>();
        String tituloLivroUpper = tituloLivro.toUpperCase();
        for (Pedido pedido : pedidos) {
            if (pedido.getTituloLivro().toUpperCase().contains(tituloLivroUpper)) {
                result.add(pedido);
            }
        }
        return result;
    }

    /*@
      @ ensures \result != null;
      @*/
    public static List<Pedido> findByStatus(int statusPedido) {
        List<Pedido> result = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getStatusPedido() == statusPedido) {
                result.add(pedido);
            }
        }
        return result;
    }
}
