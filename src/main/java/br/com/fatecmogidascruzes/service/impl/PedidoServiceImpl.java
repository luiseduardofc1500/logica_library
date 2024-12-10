package br.com.fatecmogidascruzes.service.impl;

import br.com.fatecmogidascruzes.model.entity.Pedido;
import br.com.fatecmogidascruzes.model.repository.PedidoRepository;
import br.com.fatecmogidascruzes.service.PedidoService;

import java.util.ArrayList;
import java.util.List;

public class PedidoServiceImpl implements PedidoService {

    @Override
    public void adicionarPedido(Pedido pedido) {
		PedidoRepository.save(pedido);
        System.out.println("Pedido efetivado com sucesso!");
    }

    @Override
	public List<Pedido> buscarPedido(int opcao, String valorBuscar) {	
	    List<Pedido> pedidosEncontrados = new ArrayList<>();

		switch(opcao){
			case 1:
                pedidosEncontrados.add(PedidoRepository.findById(Integer.parseInt(valorBuscar)));
                break;
			case 2:
				pedidosEncontrados = PedidoRepository.findByEmailCliente(valorBuscar);
				break;
			case 3:
				pedidosEncontrados = PedidoRepository.findByTituloLivro(valorBuscar);
				break;			
			case 4:
				pedidosEncontrados = PedidoRepository.findByStatus(Integer.parseInt(valorBuscar));
				break;
			default:
				System.out.println("Opção invalida.");
				break;
		}
		
	    if (pedidosEncontrados == null || pedidosEncontrados.isEmpty()) {
			System.out.println("Pedido não encontrado por " + valorBuscar + " informado.");
	    }
	    
		return pedidosEncontrados;
	}

}