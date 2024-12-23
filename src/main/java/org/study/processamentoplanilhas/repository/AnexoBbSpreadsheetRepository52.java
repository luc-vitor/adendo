package org.study.processamentoplanilhas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.study.processamentoplanilhas.domain.AnexoBbSpreadsheetEntity52;

@Repository
public interface AnexoBbSpreadsheetRepository52 extends CrudRepository<AnexoBbSpreadsheetEntity52, Long> {

//    @Transactional
//    @Modifying
//    @Query(value = "truncate table anexo_banco_do_brasil", nativeQuery = true)
//    void truncate();
}
