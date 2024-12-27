package org.study.processamentoplanilhas.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.study.processamentoplanilhas.domain.TaaSpreadsheetEntity;

@Repository
public interface TaaSpreadsheetRepository extends CrudRepository<TaaSpreadsheetEntity, Long> {

    @Transactional
    @Modifying
    @Query(value = "truncate table adendo50", nativeQuery = true)
    void truncate();

//    @Procedure("criar_anexo_banco_do_brasil")
//    void runProcedureCriarBancoDoBrasil();

//    @Transactional
//    @Query(value = "criar_anexo_banco_do_brasil()", nativeQuery = true)
//    void criarAnexoBancoDoBrasil();

    @Transactional
    @Query(value = "SELECT gered_disat.criar_anexo_banco_do_brasil();", nativeQuery = true)
    void criarAnexoBancoDoBrasil();

}