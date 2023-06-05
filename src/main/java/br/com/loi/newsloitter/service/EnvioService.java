package br.com.loi.newsloitter.service;

import br.com.loi.newsloitter.DTO.CategoriaDTO;
import br.com.loi.newsloitter.DTO.EnvioDTO;
import br.com.loi.newsloitter.entity.Cliente;
import br.com.loi.newsloitter.entity.Envio;
import br.com.loi.newsloitter.repository.ClienteRepository;
import br.com.loi.newsloitter.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EnvioService {

    @Autowired
    private EnvioRepository envioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EmailService emailService;

    public List<Envio> findAllEnvios() {
        return envioRepository.findAll();
    }

    public Envio findById(Integer id) {
        return envioRepository.findById(id).orElseThrow();
    }

    public Envio save(EnvioDTO envioDTO) {
        Envio envio = new Envio();
        envio.setDataEnvio(new Date());
        envio.setStatus('E');
        return envioRepository.save(envio);
    }

    public Envio update(EnvioDTO envioDTO, Integer id) {
        Envio envio = findById(id);

        if (envioDTO.getCliente() != null) {
            envio.setCliente(envioDTO.getCliente());
        }
        if (envioDTO.getDataEnvio() != null) {
            envio.setDataEnvio(envioDTO.getDataEnvio());
        }
        if (envioDTO.getStatus() != null) {
            envio.setStatus(envioDTO.getStatus());
        }
        if (envioDTO.getMsgErro() != null) {
            envio.setMsgErro(envioDTO.getMsgErro());
        }

        return envioRepository.save(envio);
    }

    public void delete(Integer id) {
        envioRepository.deleteById(id);
    }

    public void enviaEmailPorCategoria(CategoriaDTO categoriaDTO, String mensagem) {
        List<Cliente> clientes = clienteRepository.findAllClientesByCategoria(categoriaDTO.getIdCategoria());
        clientes.forEach(cliente -> {
            Cliente clienteEnvio = clienteRepository.findById(cliente.getIdCliente()).orElseThrow();
            EnvioDTO envio = new EnvioDTO();
            envio.setDataEnvio(new Date());
            envio.setCliente(clienteEnvio);

            try {
                String envioEmail = emailService.sendEmail(cliente.getEmail(), mensagem, "Notícias do dia!");
                if (envioEmail.equals("OK")) {
                    envio.setMsgErro(null);
                } else {
                    envio.setMsgErro(envioEmail);
                }

                save(envio);
            } catch (Exception e) {
                e.getMessage();
            }

        });
    }
}
