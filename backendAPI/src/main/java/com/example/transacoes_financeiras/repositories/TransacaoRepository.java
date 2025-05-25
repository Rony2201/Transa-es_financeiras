package com.example.transacoes_financeiras.repositories;

import com.example.transacoes_financeiras.entities.TipoTransacao;
import com.example.transacoes_financeiras.entities.Transacao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findByTipoTransacao(TipoTransacao TipoTransacao);
    
}
