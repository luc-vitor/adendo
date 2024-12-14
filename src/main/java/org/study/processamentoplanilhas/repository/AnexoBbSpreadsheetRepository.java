package org.study.processamentoplanilhas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.study.processamentoplanilhas.domain.AnexobbSpreadsheetEntity;

@Repository
public interface AnexoBbSpreadsheetRepository extends CrudRepository<AnexobbSpreadsheetEntity, Long> {
}
