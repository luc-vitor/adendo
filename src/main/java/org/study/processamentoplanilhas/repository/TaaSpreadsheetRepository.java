package org.study.processamentoplanilhas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.study.processamentoplanilhas.domain.TaaSpreadsheetEntity;

@Repository
public interface TaaSpreadsheetRepository extends CrudRepository<TaaSpreadsheetEntity, Long> {
}
