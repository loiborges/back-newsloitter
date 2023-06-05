package br.com.loi.newsloitter.controller;


import br.com.loi.newsloitter.DTO.ClienteDTO;
import br.com.loi.newsloitter.entity.Cliente;
import br.com.loi.newsloitter.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> findAllClientes(){
        return clienteService.findAllClientes();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Integer id) {
        return clienteService.findById(id);
    }

    @PostMapping
    public Cliente save(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.save(clienteDTO);
    }

    @PutMapping("/{id}")
    public Cliente update(@RequestBody ClienteDTO clienteDTO, @PathVariable Integer id){
        return clienteService.update(clienteDTO, id);
    }

    @DeleteMapping("/id")
    public void delete(@PathVariable Integer id) {
        clienteService.delete(id);
    }
}
