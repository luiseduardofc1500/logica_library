package br.com.fatecmogidascruzes.model.repository;

import br.com.fatecmogidascruzes.model.entity.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoRepository {

    private static final List<Pedido> pedidos = new ArrayList<>();
    private static long ultimoId = 0;

    public static void save(Pedido pedido){
            pedido.setId(++ultimoId);
            pedidos.add(pedido);
    }
    
    public static List<Pedido> findAll(){
        return pedidos;
    }

    public static Pedido findById(Integer id) {
        return pedidos.stream()
                .filter(pedido -> pedido.getId() == id)
                .findFirst().orElse(null);
    }
    
    public static List<Pedido> findByEmailCliente(String emailCliente) {
        return pedidos.stream()
                .filter(pedido -> pedido.getEmailCliente().toUpperCase().contains(emailCliente.toUpperCase()))
                .collect(Collectors.toList());
    }

    public static List<Pedido> findByTituloLivro(String tituloLivro){
        return pedidos.stream()
                .filter(pedido -> pedido.getTituloLivro().toUpperCase().contains(tituloLivro.toUpperCase()))
                .collect(Collectors.toList());
    }

    public static List<Pedido> findByStatus(int statusPedido) {
        return pedidos.stream()
                .filter(pedido -> pedido.getStatusPedido() == statusPedido)
                .collect(Collectors.toList());
    }
}

