package com.example.transacoes_financeiras.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
