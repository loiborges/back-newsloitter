package br.com.loi.newsloitter.service;

import br.com.loi.newsloitter.DTO.ClienteDTO;
import br.com.loi.newsloitter.entity.Cliente;
import br.com.loi.newsloitter.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Integer id) {
        return clienteRepository.findById(id).orElseThrow();
    }

    public Cliente save(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO);
        return clienteRepository.save(cliente);
    }

    public Cliente update(ClienteDTO clienteDTO, Integer id) {
        Cliente cliente = findById(id);

        if (clienteDTO.getNome() != null) {
            cliente.setNome(clienteDTO.getNome());
        }
        if (clienteDTO.getEmail() != null) {
            cliente.setEmail(clienteDTO.getEmail());
        }
        if (clienteDTO.getCategoria() != null) {
            cliente.setCategoria(clienteDTO.getCategoria());
        }
        if (clienteDTO.getAceite() != null) {
            cliente.setAceite(clienteDTO.getAceite());
        }

        return clienteRepository.save(cliente);
    }

    public void delete(Integer id) {
        clienteRepository.deleteById(id);
    }

    public List<Cliente> findAllClienteByCategoria(Integer idCategoria) {
        return clienteRepository.findAllClientesByCategoria(idCategoria);
    }
}
