package br.com.loi.newsloitter.controller;

import br.com.loi.newsloitter.DTO.EnvioDTO;
import br.com.loi.newsloitter.entity.Envio;
import br.com.loi.newsloitter.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/envio")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @GetMapping
    public List<Envio> findAllEnvios(){
        return envioService.findAllEnvios();
    }

    @GetMapping("/{id}")
        public Envio findById(@PathVariable Integer id) {
        return envioService.findById(id);
    }

    @PostMapping
    public Envio save(@RequestBody EnvioDTO envioDTO) {
        return envioService.save(envioDTO);
    }

    @PutMapping("/{id}")
    public Envio update(@RequestBody EnvioDTO envioDTO, @PathVariable Integer id){
        return envioService.update(envioDTO, id);
    }

    @DeleteMapping("/id")
    public void delete(@PathVariable Integer id) {
        envioService.delete(id);
    }
}
