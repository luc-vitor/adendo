package org.study.processamentoplanilhas.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.study.processamentoplanilhas.domain.DemaisBensSpreadsheetEntity;
import org.study.processamentoplanilhas.repository.DemaisBensSpreadsheetRepository;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Service
public class ProcessSpreadsheetServiceDemaisBens {

    public ProcessSpreadsheetServiceDemaisBens(DemaisBensSpreadsheetRepository demaisBensSpreadsheetRepository) {
        this.demaisBensSpreadsheetRepository = demaisBensSpreadsheetRepository;
    }

    private final DemaisBensSpreadsheetRepository demaisBensSpreadsheetRepository;

    public List<DemaisBensSpreadsheetEntity> processExcelFile(MultipartFile file) throws IOException {
        List<DemaisBensSpreadsheetEntity> entities = new ArrayList<>();
        Instant start = Instant.now();

        log.info("Processando Planilha Demais Bens...");
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


                // Pega valores da planilha, na linha
                final String numeroDoBem = getStringCellValue(row.getCell(0));
                final String mes = getStringCellValue(row.getCell(1));
                final String tpoPbms = getStringCellValue(row.getCell(2));
                final String clsPbms = getStringCellValue(row.getCell(3));
                final String sclPbms = getStringCellValue(row.getCell(4));
                final String seqPbms = getStringCellValue(row.getCell(5));
                final String pbms = getStringCellValue(row.getCell(6));
                final String cdCfgBem = getStringCellValue(row.getCell(7));
                final String nomeNoContrato = getStringCellValue(row.getCell(8));
                final Double vl = getDoubleCellValue(row.getCell(9));
                final Long critcidade52 = getLongCellValue(row.getCell(10));
                final String modelo = getStringCellValue(row.getCell(11));
                final String grupo = getStringCellValue(row.getCell(12));
                final String fornecedor = getStringCellValue(row.getCell(13));
                final String cdOurInls = getStringCellValue(row.getCell(14));
                final String prfDepeInls = getStringCellValue(row.getCell(15));
                final String sagInls = getStringCellValue(row.getCell(16));
                final String nomeOurInstalacao = getStringCellValue(row.getCell(17));
                final String municipioAtualizado = getStringCellValue(row.getCell(18));
                final String ufAtualizada = getStringCellValue(row.getCell(19));
                final String tipoDeDependenciaAtualizada = getStringCellValue(row.getCell(20));
                final Long lote = getLongCellValue(row.getCell(21));

                // Valida se a linha ta preenchida

                final boolean hasNumeroDoBem = numeroDoBem != null && !numeroDoBem.isEmpty();
                final boolean hasMes = mes != null && !mes.isEmpty();
                final boolean hasTpoPbms = tpoPbms != null && !tpoPbms.isEmpty();
                final boolean hasClsPbms = clsPbms != null && !clsPbms.isEmpty();
                final boolean hasSclPbms = sclPbms != null && !sclPbms.isEmpty();
                final boolean hasSeqPbms = seqPbms != null && !seqPbms.isEmpty();
                final boolean hasPbms = pbms != null && !pbms.isEmpty();
                final boolean hasCdCfgBem = cdCfgBem != null && !cdCfgBem.isEmpty();
                final boolean hasNomeNoContrato = nomeNoContrato != null && !nomeNoContrato.isEmpty();
                final boolean hasVl = vl != null;
                final boolean hasCritcidade52 = critcidade52 != null;
                final boolean hasModelo = modelo != null && !modelo.isEmpty();
                final boolean hasGrupo = grupo != null && !grupo.isEmpty();
                final boolean hasFornecedor = fornecedor != null && !fornecedor.isEmpty();
                final boolean hasCdOurInls = cdOurInls != null && !cdOurInls.isEmpty();
                final boolean hasPrfDepeInls = prfDepeInls != null && !prfDepeInls.isEmpty();
                final boolean hasSagInls = sagInls != null && !sagInls.isEmpty();
                final boolean hasNomeOurInstalacao = nomeOurInstalacao != null && !nomeOurInstalacao.isEmpty();
                final boolean hasMunicipioAtualizado = municipioAtualizado != null && !municipioAtualizado.isEmpty();
                final boolean hasUfAtualizada = ufAtualizada != null && !ufAtualizada.isEmpty();
                final boolean hasTipoDeDependenciaAtualizada = tipoDeDependenciaAtualizada != null && !tipoDeDependenciaAtualizada.isEmpty();
                final boolean hasLote = lote != null;

                // Setas os valores da LINHA em um objeto

                if (hasNumeroDoBem || hasMes || hasTpoPbms || hasClsPbms || hasSclPbms || hasSeqPbms || hasPbms || hasCdCfgBem || hasNomeNoContrato || hasVl || hasCritcidade52 || hasModelo || hasGrupo || hasFornecedor || hasCdOurInls || hasPrfDepeInls || hasSagInls || hasNomeOurInstalacao || hasMunicipioAtualizado || hasUfAtualizada || hasTipoDeDependenciaAtualizada || hasLote) {
                    DemaisBensSpreadsheetEntity entity = new DemaisBensSpreadsheetEntity();
                    entity.setNumeroDoBem(numeroDoBem);
                    entity.setMes(mes);
                    entity.setTpoPbms(tpoPbms);
                    entity.setClsPbms(clsPbms);
                    entity.setSclPbms(sclPbms);
                    entity.setSeqPbms(seqPbms);
                    //entity.setPbms(pbms);
                    entity.setCdCfgBem(cdCfgBem);
                    entity.setNomeNoContrato(nomeNoContrato);
                    entity.setVl(vl);
                    entity.setCriticidade52(critcidade52);
                    entity.setModelo(modelo);
                    entity.setGrupo(grupo);
                    entity.setFornecedor(fornecedor);
                    entity.setCdOurInsl(cdOurInls);
                    entity.setPrfDepeInsl(prfDepeInls);
                    entity.setSagInsl(sagInls);
                    entity.setNomeOurInstalacao(nomeOurInstalacao);
                    entity.setMunicipioAtualizado(municipioAtualizado);
                    entity.setUfAtualizada(ufAtualizada);
                    entity.setTipoDeDependeciaAtualizada(tipoDeDependenciaAtualizada);
                    entity.setLote(lote);
                    entities.add(entity);

                }
                }
            }

        log.info("Salvando planilha DEMAIS BENS no banco de dados | qtdLinhas: {}", entities.size());
        log.info("Demais Bens processada com sucesso!");
        demaisBensSpreadsheetRepository.saveAll(entities);
        log.info("Planilha Demais Bens salva no banco com sucesso! | qtdLinhas: {}", entities.size());
        Instant finish = Instant.now();
        Duration duration = Duration.between(start, finish);
        log.info("Tempo de processamento: Segundos={} | Minutos={} | Horas={}",duration.toSeconds(),duration.toMinutes(),duration.toHours());
        return entities;

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
