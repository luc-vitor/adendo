package org.study.processamentoplanilhas.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.study.processamentoplanilhas.domain.DieboldAtmEntity;
import org.study.processamentoplanilhas.domain.ProcessStatus;
import org.study.processamentoplanilhas.domain.ProcessStatusReturnDto;
import org.study.processamentoplanilhas.repository.DieboldAtmRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.function.Consumer;

@Slf4j
@Service
public class ProcessSpreadsheetServiceDiebold {

    private final DieboldAtmRepository dieboldAtmRepository;
    private ProcessStatus processStatus = ProcessStatus.FINISHED;

    public ProcessSpreadsheetServiceDiebold(DieboldAtmRepository dieboldAtmRepository) {
        this.dieboldAtmRepository = dieboldAtmRepository;
    }

    public ProcessStatusReturnDto getProcessStatus() {
        return new ProcessStatusReturnDto(processStatus);
    }

    public HSSFWorkbook getSpreadsheet() {

        log.info("Get spreadsheet FROM database");
      Iterable<DieboldAtmEntity> dieboldAtmList = dieboldAtmRepository.findAll();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("DieboldAtm");
        HSSFRow row = sheet.createRow(0);

        row.createCell(0).setCellValue("nro_univ");
        row.createCell(1).setCellValue("nome_do_contrato");
        row.createCell(2).setCellValue("fornecedor");
        row.createCell(3).setCellValue("prf_insl");
        row.createCell(4).setCellValue("sag_inls");
        row.createCell(5).setCellValue("dependencia");
        row.createCell(6).setCellValue("municipio");
        row.createCell(7).setCellValue("codmunicipio");
        row.createCell(8).setCellValue("uf");
        row.createCell(9).setCellValue("cat");
        row.createCell(10).setCellValue("cat_resp");
        row.createCell(11).setCellValue("regional");
        row.createCell(12).setCellValue("dist");
        row.createCell(13).setCellValue("distanciabb");
        row.createCell(14).setCellValue("criticidade");
        row.createCell(15).setCellValue("semat");
        row.createCell(16).setCellValue("vlr_parceiros");
//        row.createCell(17).setCellValue("PRF-SB");
        row.createCell(17).setCellValue("endereco");
        row.createCell(18).setCellValue("bairro");
        row.createCell(19).setCellValue("cep");
        row.createCell(20).setCellValue("telefone");
        row.createCell(21).setCellValue("cnpj");
        row.createCell(22).setCellValue("tempo_aquisicao");
        row.createCell(23).setCellValue("lote");
        row.createCell(24).setCellValue("valor_residual");
        row.createCell(25).setCellValue("valor_aquisicao");

        log.info("Preenchendo a planilha");

        int rowNum = 1;
        for (DieboldAtmEntity dieboldAtmEntity : dieboldAtmList) {
            HSSFRow dataRow = sheet.createRow(rowNum);
            safeSetValue(dataRow.createCell(0)::setCellValue, dieboldAtmEntity.getNroUniv());
            safeSetValue(dataRow.createCell(1)::setCellValue, dieboldAtmEntity.getNomeDoContrato());
            safeSetValue(dataRow.createCell(2)::setCellValue, dieboldAtmEntity.getFornecedor());
            safeSetValue(dataRow.createCell(3)::setCellValue, dieboldAtmEntity.getPrfInsl());
            safeSetValue(dataRow.createCell(4)::setCellValue, dieboldAtmEntity.getSagInsl());
            safeSetValue(dataRow.createCell(5)::setCellValue, dieboldAtmEntity.getDependencia());
            safeSetValue(dataRow.createCell(6)::setCellValue, dieboldAtmEntity.getMunicipio());
            safeSetValue(dataRow.createCell(7)::setCellValue, dieboldAtmEntity.getCodMunicipio());
            safeSetValue(dataRow.createCell(8)::setCellValue, dieboldAtmEntity.getUf());
            safeSetValue(dataRow.createCell(9)::setCellValue, dieboldAtmEntity.getCat());
            safeSetValue(dataRow.createCell(10)::setCellValue, dieboldAtmEntity.getCatResp());
            safeSetValue(dataRow.createCell(11)::setCellValue, dieboldAtmEntity.getRegional());
            safeSetValue(dataRow.createCell(12)::setCellValue, dieboldAtmEntity.getDist());
            safeSetValue(dataRow.createCell(13)::setCellValue, dieboldAtmEntity.getDistanciabb());
            safeSetValue(dataRow.createCell(14)::setCellValue, dieboldAtmEntity.getCriticidade());
            safeSetValue(dataRow.createCell(15)::setCellValue, dieboldAtmEntity.getSemat());
            safeSetValue(dataRow.createCell(16)::setCellValue, dieboldAtmEntity.getVlrParceiros());
            //safeSetValue(dataRow.createCell(17)::setCellValue, dieboldAtmEntity.getPrfSb);
            safeSetValue(dataRow.createCell(18)::setCellValue, dieboldAtmEntity.getEndereco());
            safeSetValue(dataRow.createCell(19)::setCellValue, dieboldAtmEntity.getBairro());
            safeSetValue(dataRow.createCell(20)::setCellValue, dieboldAtmEntity.getCep());
            safeSetValue(dataRow.createCell(21)::setCellValue, dieboldAtmEntity.getTelefone());
            safeSetValue(dataRow.createCell(22)::setCellValue, dieboldAtmEntity.getCnpj());
            safeSetValue(dataRow.createCell(23)::setCellValue, dieboldAtmEntity.getTempoAquisicao());
            safeSetValue(dataRow.createCell(24)::setCellValue, dieboldAtmEntity.getLote());
            safeSetValue(dataRow.createCell(25)::setCellValue, dieboldAtmEntity.getValorResidual());
            safeSetValue(dataRow.createCell(26)::setCellValue, dieboldAtmEntity.getValorAquisicao());
            rowNum = rowNum + 1;
        }

        log.info("AutoSizing colunas");
        for (int i = 0; i < 27; i++) {
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
