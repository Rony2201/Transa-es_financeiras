package com.example.transacoes_financeiras.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.transacoes_financeiras.entities.TipoTransacao;
import com.example.transacoes_financeiras.entities.Transacao;
import com.example.transacoes_financeiras.repositories.TransacaoRepository;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository repository;

    public List<Transacao> findAll() {
        return repository.findAll();
    }

    public Transacao findById(Long id) {
        Optional<Transacao> obj = repository.findById(id);
        return obj.get();
    }

    public List<Transacao> findByTipoTransacao(TipoTransacao tipo) {
        return repository.findByTipoTransacao(tipo);
    }

    public Transacao save(Transacao transacao) {
        return repository.save(transacao);
    }

    public void delete(Long Id) {
        repository.deleteById(Id);
    }
    public Transacao buscarPorId(Long id) {    
        
        return repository.findById(id).orElse(null);
    }

    public Transacao Editar(Transacao transacao) {
        return repository.save(transacao);
    }

    public Double atualizarTotal(Double totalAtual, Transacao transacao) {
        if (transacao == null || transacao.getValor() == null || transacao.getTipoTransacao() == null) {
            return totalAtual;
        }

        if (transacao.getTipoTransacao() == TipoTransacao.RECEITA) {
            return totalAtual + transacao.getValor();
        } else if (transacao.getTipoTransacao() == TipoTransacao.DESPESA) {
            return totalAtual - transacao.getValor();
        }
        return totalAtual;
    }
    public Double calcularTotalGeral() {
    List<Transacao> todasTransacoes = repository.findAll();

    Double total = 0.0;
    for (Transacao t : todasTransacoes) {
        total = atualizarTotal(total, t);
    }
    return total;
    }
    


}
