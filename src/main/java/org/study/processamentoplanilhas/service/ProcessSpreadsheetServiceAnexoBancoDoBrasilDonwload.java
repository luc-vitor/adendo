package org.study.processamentoplanilhas.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.study.processamentoplanilhas.domain.AnexoBbSpreadsheetEntity;
import org.study.processamentoplanilhas.domain.ProcessStatus;
import org.study.processamentoplanilhas.domain.ProcessStatusReturnDto;
import org.study.processamentoplanilhas.repository.AnexoBbSpreadsheetRepository;

import java.util.function.Consumer;

@Slf4j
@Service
public class ProcessSpreadsheetServiceAnexoBancoDoBrasilDonwload {

    private final AnexoBbSpreadsheetRepository anexoBbSpreadsheetRepository;
    private ProcessStatus processStatus = ProcessStatus.FINISHED;

    public ProcessSpreadsheetServiceAnexoBancoDoBrasilDonwload(AnexoBbSpreadsheetRepository anexoBbSpreadsheetRepository) {
        this.anexoBbSpreadsheetRepository = anexoBbSpreadsheetRepository;
    }

    public ProcessStatusReturnDto getProcessStatus() {
        return new ProcessStatusReturnDto(processStatus);
    }

    public HSSFWorkbook getSpreadsheet() {

        log.info("Get spreadsheet FROM database");
      Iterable<AnexoBbSpreadsheetEntity> anexoBancoDoBrasilDownloadList = anexoBbSpreadsheetRepository.findAll();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("AnexoBancoDoBrasil");
        HSSFRow row = sheet.createRow(0);

        row.createCell(0).setCellValue("referencia");
        row.createCell(1).setCellValue("numerobem");
        row.createCell(2).setCellValue("nomenocontrato");
        row.createCell(3).setCellValue("grupo");
        row.createCell(4).setCellValue("modelo");
        row.createCell(5).setCellValue("fornecedor");
        row.createCell(6).setCellValue("contrato");
        row.createCell(7).setCellValue("criticidade");
        row.createCell(8).setCellValue("valor");
        row.createCell(9).setCellValue("vlr_parceiros");
        row.createCell(10).setCellValue("agencia");
        row.createCell(11).setCellValue("sag");
        row.createCell(12).setCellValue("lat");
        row.createCell(13).setCellValue("cat_faturamento");
        row.createCell(14).setCellValue("cat_atendimento");
        row.createCell(15).setCellValue("lat_servico");
        row.createCell(16).setCellValue("semat");
        row.createCell(17).setCellValue("configuracao");
        row.createCell(18).setCellValue("componentedobem");
        row.createCell(19).setCellValue("proprietario");
        row.createCell(20).setCellValue("numeroserie");
        row.createCell(21).setCellValue("quantidade");
        row.createCell(22).setCellValue("dataemservico");
        row.createCell(23).setCellValue("dataemabsorcao");
        row.createCell(24).setCellValue("empregado");
        row.createCell(25).setCellValue("timerecurso");

        log.info("Preenchendo a planilha");

        int rowNum = 1;
        for (AnexoBbSpreadsheetEntity anexoBancoDoBrasilEntity : anexoBancoDoBrasilDownloadList) {
            HSSFRow dataRow = sheet.createRow(rowNum);
            safeSetValue(dataRow.createCell(0)::setCellValue, anexoBancoDoBrasilEntity.getReferencia());
            safeSetValue(dataRow.createCell(1)::setCellValue, anexoBancoDoBrasilEntity.getNumeroBem());
            safeSetValue(dataRow.createCell(2)::setCellValue, anexoBancoDoBrasilEntity.getNomeNoContrato());
            safeSetValue(dataRow.createCell(3)::setCellValue, anexoBancoDoBrasilEntity.getGrupo());
            safeSetValue(dataRow.createCell(4)::setCellValue, anexoBancoDoBrasilEntity.getModelo());
            safeSetValue(dataRow.createCell(5)::setCellValue, anexoBancoDoBrasilEntity.getFornecedor());
            safeSetValue(dataRow.createCell(6)::setCellValue, anexoBancoDoBrasilEntity.getContrato());
            safeSetValue(dataRow.createCell(7)::setCellValue, anexoBancoDoBrasilEntity.getCriticidade());
            safeSetValue(dataRow.createCell(8)::setCellValue, anexoBancoDoBrasilEntity.getValor());
            safeSetValue(dataRow.createCell(9)::setCellValue, anexoBancoDoBrasilEntity.getVlrParceiros());
            safeSetValue(dataRow.createCell(10)::setCellValue, anexoBancoDoBrasilEntity.getAgencia());
            safeSetValue(dataRow.createCell(11)::setCellValue, anexoBancoDoBrasilEntity.getSag());
            safeSetValue(dataRow.createCell(12)::setCellValue, anexoBancoDoBrasilEntity.getLat());
            safeSetValue(dataRow.createCell(13)::setCellValue, anexoBancoDoBrasilEntity.getCatFaturamento());
            safeSetValue(dataRow.createCell(14)::setCellValue, anexoBancoDoBrasilEntity.getCatAtendimento());
            safeSetValue(dataRow.createCell(15)::setCellValue, anexoBancoDoBrasilEntity.getLatServico());
            safeSetValue(dataRow.createCell(16)::setCellValue, anexoBancoDoBrasilEntity.getSemat());
            safeSetValue(dataRow.createCell(17)::setCellValue, anexoBancoDoBrasilEntity.getConfiguracao());
            safeSetValue(dataRow.createCell(18)::setCellValue, anexoBancoDoBrasilEntity.getComponenteDoBem());
            safeSetValue(dataRow.createCell(19)::setCellValue, anexoBancoDoBrasilEntity.getProprietario());
            safeSetValue(dataRow.createCell(20)::setCellValue, anexoBancoDoBrasilEntity.getNumeroSerie());
            safeSetValue(dataRow.createCell(21)::setCellValue, anexoBancoDoBrasilEntity.getQuantidade());
            safeSetValue(dataRow.createCell(22)::setCellValue, anexoBancoDoBrasilEntity.getDataEmServico());
            safeSetValue(dataRow.createCell(23)::setCellValue, anexoBancoDoBrasilEntity.getDataAbsorcao());
            safeSetValue(dataRow.createCell(24)::setCellValue, anexoBancoDoBrasilEntity.getEmpregado());
            safeSetValue(dataRow.createCell(25)::setCellValue, anexoBancoDoBrasilEntity.getTimeRecurso());
            rowNum = rowNum + 1;
        }

        log.info("AutoSizing colunas");
        for (int i = 0; i < 26; i++) {
            sheet.autoSizeColumn(i);
        }

        return workbook;
    }

    private <T> void safeSetValue(Consumer<T> setCellValue, T value) {
        if (value != null) {
            setCellValue.accept(value);
        }
    }
}