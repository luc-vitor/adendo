package org.study.processamentoplanilhas.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.study.processamentoplanilhas.domain.AnexoBbSpreadsheetEntity;

@Repository
public interface AnexoBbSpreadsheetRepository extends CrudRepository<AnexoBbSpreadsheetEntity, String> {

    @Transactional
    @Modifying
    @Query(value = "truncate table anexo_banco_do_brasil", nativeQuery = true)
    void truncate();


}
