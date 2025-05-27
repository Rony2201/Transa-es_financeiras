package com.example.transacoes_financeiras.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.transacoes_financeiras.entities.TipoTransacao;
import com.example.transacoes_financeiras.entities.Transacao;
import com.example.transacoes_financeiras.service.TransacaoService;

@RestController
@RequestMapping(value = "/transacoes")
public class TransacaoResource {

    @Autowired
    private TransacaoService service;

    @GetMapping
    public ResponseEntity<List<Transacao>> findAll() {
        List<Transacao> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Transacao> findById(@PathVariable Long id) {
        Transacao obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/tipo/{tipo}")
    public ResponseEntity<List<Transacao>> findByTipo(@PathVariable TipoTransacao tipo) {
        List<Transacao> list = service.findByTipoTransacao(tipo);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/total")
    public ResponseEntity<Double> obterTotal() {
        Double total = service.calcularTotalGeral();
        return ResponseEntity.ok(total);
    }

    @PostMapping(value = "/tipo/{tipo}")
    public ResponseEntity<Transacao> salvarTransacao(@RequestBody Transacao transacao) {
        Transacao novaTransacao = service.save(transacao);
        return  new ResponseEntity<>(novaTransacao, HttpStatus.CREATED);
    }
    
    @DeleteMapping(value = "/tipo/{id}")
    public ResponseEntity<Void> DeletarTransacao(@PathVariable Long id) {
        service.delete(id);
       return ResponseEntity.noContent().build();
    }

@PutMapping("/tipo/{id}")
public ResponseEntity<Transacao> atualizarTransacao(
        @PathVariable Long id,
        @RequestBody Transacao transacao) {

    Transacao existente = service.buscarPorId(id);
    if (existente == null) {
        return ResponseEntity.notFound().build();
    }
    existente.setCategoria(transacao.getCategoria());
    existente.setValor(transacao.getValor());
    existente.setTipoTransacao(transacao.getTipoTransacao());

    Transacao atualizada = service.Editar(existente);

    return ResponseEntity.ok(atualizada);
}
    


}
