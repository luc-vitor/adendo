package org.study.processamentoplanilhas.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.study.processamentoplanilhas.domain.AnexoBbSpreadsheetEntity52;
import org.study.processamentoplanilhas.domain.ProcessStatus;
import org.study.processamentoplanilhas.domain.ProcessStatusReturnDto;
import org.study.processamentoplanilhas.repository.AnexoBbSpreadsheetRepository52;

import java.io.InputStream;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;

@Slf4j
@Service
public class ProcessSpreadsheetServiceAnexoBb52 {

    private final AnexoBbSpreadsheetRepository52 anexoBbSpreadsheetRepository52;
    private ProcessStatus processStatus = ProcessStatus.FINISHED;

    public ProcessSpreadsheetServiceAnexoBb52(AnexoBbSpreadsheetRepository52 anexoBbSpreadsheetRepository52) {
        this.anexoBbSpreadsheetRepository52 = anexoBbSpreadsheetRepository52;
    }

    public ProcessStatusReturnDto getProcessStatus() {
        return new ProcessStatusReturnDto(processStatus);
    }

    @Transactional
    public void processExcelFile(MultipartFile file) {
        if (ProcessStatus.PROCESSING.equals(processStatus)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anexo Banco do Brasil 52, já está sendo processado! Tente novamente mais tarde.");
        }
        Executors.newSingleThreadExecutor().execute(() -> executeProcess(file));
    }

    private void executeProcess(MultipartFile file) {
        List<AnexoBbSpreadsheetEntity52> entities = new ArrayList<>();
        Instant start = Instant.now();
        processStatus = ProcessStatus.PROCESSING;

        // CONVERTENDO A PLANILHA PARA JAVA

        log.info("Processando Planilha Anexo Banco do Brasil 52...");
        try (InputStream is = file.getInputStream()) {
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            boolean isFirstRow = true;

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                if (isFirstRow) {
                    isFirstRow = false; // Skip header row
                    continue;
                }

                //  pega valores da planilha na linha

                final String referencia = getStringCellValue(row.getCell(0));
                final Long numeroBem = getLongCellValue(row.getCell(1));
                final String nomeNoContrato = getStringCellValue(row.getCell(2));
                final String grupo = getStringCellValue(row.getCell(3));
                final String modelo = getStringCellValue(row.getCell(4));
                final String fornecedor = getStringCellValue(row.getCell(5));
                final String contrato = getStringCellValue(row.getCell(6));
                final Long criticidade = getLongCellValue(row.getCell(7));
                final String valor = getStringCellValue(row.getCell(8));
                final String vlrParceiros = getStringCellValue(row.getCell(9));
                final String agencia = getStringCellValue(row.getCell(10));
                final String sag = getStringCellValue(row.getCell(11));
                final String lat = getStringCellValue(row.getCell(12));
                final String catFaturamento = getStringCellValue(row.getCell(13));
                final String catAtendimento = getStringCellValue(row.getCell(14));
                final String latServico = getStringCellValue(row.getCell(15));
                final String setmat = getStringCellValue(row.getCell(16));
                final String configuracao = getStringCellValue(row.getCell(17));
                final String componenteDoBem = getStringCellValue(row.getCell(18));
                final String proprietario = getStringCellValue(row.getCell(19));
                final String numeroSerie = getStringCellValue(row.getCell(20));
                final String quantidade = getStringCellValue(row.getCell(21));
                final String dataEmServico = getStringNotacaoCientifica(row.getCell(22));
                final String dataAbsorcao = getStringNotacaoCientifica(row.getCell(23));
                final String empregado = getStringCellValue(row.getCell(24));
                final String timeRecurso = getStringCellValue(row.getCell(25));

                //   VALIDA SE A LINHA ESTÁ PREENCHIDA

                final boolean hasReferencia = referencia != null && !referencia.isEmpty();
                final boolean hasNumeroBem = numeroBem != null;
                final boolean hasNomeNoContrato = nomeNoContrato != null && !nomeNoContrato.isEmpty();
                final boolean hasGrupo = grupo != null && !grupo.isEmpty();
                final boolean hasModelo = modelo != null && !modelo.isEmpty();
                final boolean hasFornecedor = fornecedor != null && !fornecedor.isEmpty();
                final boolean hasContrato = contrato != null && !contrato.isEmpty();
                final boolean hasCriticidade = criticidade != null;
                final boolean hasValor = valor != null && !valor.isEmpty();
                final boolean hasVlrParceiros = vlrParceiros != null && !vlrParceiros.isEmpty();
                final boolean hasAgencia = agencia != null && !agencia.isEmpty();
                final boolean hasSag = sag != null && !sag.isEmpty();
                final boolean hasLat = lat != null && !lat.isEmpty();
                final boolean hasCatFaturamento = catFaturamento != null && !catFaturamento.isEmpty();
                final boolean hasCatAtendimento = catAtendimento != null && !catAtendimento.isEmpty();
                final boolean hasLatServico = latServico != null && !latServico.isEmpty();
                final boolean hasSetmat = setmat != null && !setmat.isEmpty();
                final boolean hasConfiguracao = configuracao != null && !configuracao.isEmpty();
                final boolean hasComponenteDoBem = componenteDoBem != null && !componenteDoBem.isEmpty();
                final boolean hasProprietario = proprietario != null && !proprietario.isEmpty();
                final boolean hasNumeroSerie = numeroSerie != null && !numeroSerie.isEmpty();
                final boolean hasQuantidade = quantidade != null && !quantidade.isEmpty();
                final boolean hasDataEmServico = dataEmServico != null && !dataEmServico.isEmpty();
                final boolean hasDataAbsorcao = dataAbsorcao != null && !dataAbsorcao.isEmpty();
                final boolean hasEmpregado = empregado != null && !empregado.isEmpty();
                final boolean hasTimeRecurso = timeRecurso != null && !timeRecurso.isEmpty();

                // SETA OS VALORES DA LINHA EM UM OBJETO

                if (hasReferencia || hasNumeroBem || hasNomeNoContrato || hasGrupo || hasModelo || hasFornecedor || hasContrato || hasCriticidade || hasValor || hasVlrParceiros || hasAgencia || hasSag || hasLat || hasCatFaturamento || hasCatAtendimento || hasLatServico || hasSetmat || hasConfiguracao || hasComponenteDoBem || hasProprietario || hasNumeroSerie || hasQuantidade || hasDataEmServico || hasDataAbsorcao || hasEmpregado || hasTimeRecurso) {
                    AnexoBbSpreadsheetEntity52 entity = new AnexoBbSpreadsheetEntity52();
                    entity.setReferencia(referencia);
                    entity.setNumeroBem(numeroBem);
                    entity.setNomeNoContrato(nomeNoContrato);
                    entity.setGrupo(grupo);
                    entity.setModelo(modelo);
                    entity.setFornecedor(fornecedor);
                    entity.setContrato(contrato);
                    entity.setCriticidade(criticidade);
                    entity.setValor(valor);
                    entity.setVlrParceiros(vlrParceiros);
                    entity.setAgencia(agencia);
                    entity.setSag(sag);
                    entity.setLat(lat);
                    entity.setCatFaturamento(catFaturamento);
                    entity.setCatAtendimento(catAtendimento);
                    entity.setLatServico(latServico);
                    entity.setSemat(setmat);
                    entity.setConfiguracao(configuracao);
                    entity.setComponenteDoBem(componenteDoBem);
                    entity.setProprietario(proprietario);
                    entity.setNumeroSerie(numeroSerie);
                    entity.setQuantidade(quantidade);
                    entity.setDataEmServico(dataEmServico);
                    entity.setDataAbsorcao(dataAbsorcao);
                    entity.setEmpregado(empregado);
                    entity.setTimeRecurso(timeRecurso);
                    entities.add(entity);
                }
            }

            log.info("Planilha Anexo Banco do Brasil 52 processada com sucesso!");

            // Bloco de truncate

//            log.info("Iniciando Truncate!");
//            AnexoBbSpreadsheetRepository.truncate();
//            log.info("Truncate finalizado!");

            // Bloco do Salvando

            log.info("Planilha Anexo Bando do Brasil 52 salvando no banco... | qtdLinhas: {}", entities.size());
            anexoBbSpreadsheetRepository52.saveAll(entities);
            log.info("Planilha Anexo Banco do Brasil 52 salva no banco | qtdLinhas: {}", entities.size());
            Instant finish = Instant.now();
            Duration duration = Duration.between(start, finish);
            log.info("Tempo de processamento: Segundos={} | Minutos={} | Horas={}",duration.toSeconds(),duration.toMinutes(),duration.toHours());

        } catch (Exception e) {
            log.warn("Erro ao tentar processar a planilha.", e);
            processStatus=ProcessStatus.FAILED;
            throw new RuntimeException(e);
        }

    }

    private Long getLongCellValue(Cell cell) {
        if (cell == null || cell.getCellType() != CellType.NUMERIC) {
            return null;
        }
        return Double.valueOf(cell.getNumericCellValue()).longValue();
    }

    private Double getDoubleCellValue(Cell cell) {
        if (cell == null || cell.getCellType() != CellType.NUMERIC) {
            return null;
        }
        return cell.getNumericCellValue();
    }

    private String getStringNotacaoCientifica(Cell cell) {
        Double cellValue = getDoubleCellValue(cell);
        if(cellValue == null) {
            return null;
        }
        return String.format("%.0f", cellValue);
    }

    private String getStringCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        return cell.getCellType() == CellType.STRING ? cell.getStringCellValue() : cell.toString();
    }
}