package br.com.fatecmogidascruzes.service;

import br.com.fatecmogidascruzes.model.entity.Pedido;

import java.util.List;

public interface PedidoService {

    void adicionarPedido(Pedido pedido);
    List<Pedido> buscarPedido(int opcao, String valorBuscar);

}
