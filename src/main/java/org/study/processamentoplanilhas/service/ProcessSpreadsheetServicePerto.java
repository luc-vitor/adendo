package org.study.processamentoplanilhas.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.study.processamentoplanilhas.domain.PertoAtmEntity;
import org.study.processamentoplanilhas.domain.ProcessStatus;
import org.study.processamentoplanilhas.domain.ProcessStatusReturnDto;
import org.study.processamentoplanilhas.repository.PertoAtmRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.function.Consumer;

@Slf4j
@Service
public class ProcessSpreadsheetServicePerto {

    private final PertoAtmRepository pertoAtmRepository;
    private ProcessStatus processStatus = ProcessStatus.FINISHED;

    public ProcessSpreadsheetServicePerto(PertoAtmRepository pertoAtmRepository) {
        this.pertoAtmRepository = pertoAtmRepository;
    }

    public ProcessStatusReturnDto getProcessStatus() {
        return new ProcessStatusReturnDto(processStatus);
    }

    public HSSFWorkbook getSpreadsheet() {

        log.info("Get spreadsheet FROM database");
      Iterable<PertoAtmEntity> pertoAtmList = pertoAtmRepository.findAll();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("PertoAtm");
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
        for (PertoAtmEntity pertoAtmEntity : pertoAtmList) {
            HSSFRow dataRow = sheet.createRow(rowNum);
            safeSetValue(dataRow.createCell(0)::setCellValue, pertoAtmEntity.getNroUniv());
            safeSetValue(dataRow.createCell(1)::setCellValue, pertoAtmEntity.getNomeDoContrato());
            safeSetValue(dataRow.createCell(2)::setCellValue, pertoAtmEntity.getFornecedor());
            safeSetValue(dataRow.createCell(3)::setCellValue, pertoAtmEntity.getPrfInsl());
            safeSetValue(dataRow.createCell(4)::setCellValue, pertoAtmEntity.getSagInsl());
            safeSetValue(dataRow.createCell(5)::setCellValue, pertoAtmEntity.getDependencia());
            safeSetValue(dataRow.createCell(6)::setCellValue, pertoAtmEntity.getMunicipio());
            safeSetValue(dataRow.createCell(7)::setCellValue, pertoAtmEntity.getCodMunicipio());
            safeSetValue(dataRow.createCell(8)::setCellValue, pertoAtmEntity.getUf());
            safeSetValue(dataRow.createCell(9)::setCellValue, pertoAtmEntity.getCat());
            safeSetValue(dataRow.createCell(10)::setCellValue, pertoAtmEntity.getCatResp());
            safeSetValue(dataRow.createCell(11)::setCellValue, pertoAtmEntity.getRegional());
            safeSetValue(dataRow.createCell(12)::setCellValue, pertoAtmEntity.getDist());
            safeSetValue(dataRow.createCell(13)::setCellValue, pertoAtmEntity.getDistanciabb());
            safeSetValue(dataRow.createCell(14)::setCellValue, pertoAtmEntity.getCriticidade());
            safeSetValue(dataRow.createCell(15)::setCellValue, pertoAtmEntity.getSemat());
            safeSetValue(dataRow.createCell(16)::setCellValue, pertoAtmEntity.getVlrParceiros());
            //dataRow.createCell(17).setCellValue(pertoAtmEntity.getPrfSb);
            safeSetValue(dataRow.createCell(17)::setCellValue, pertoAtmEntity.getEndereco());
            safeSetValue(dataRow.createCell(18)::setCellValue, pertoAtmEntity.getBairro());
            safeSetValue(dataRow.createCell(19)::setCellValue, pertoAtmEntity.getCep());
            safeSetValue(dataRow.createCell(20)::setCellValue, pertoAtmEntity.getTelefone());
            safeSetValue(dataRow.createCell(21)::setCellValue, pertoAtmEntity.getCnpj());
            safeSetValue(dataRow.createCell(22)::setCellValue, pertoAtmEntity.getTempoAquisicao());
            safeSetValue(dataRow.createCell(23)::setCellValue, pertoAtmEntity.getLote());
            safeSetValue(dataRow.createCell(24)::setCellValue, pertoAtmEntity.getValorAquisicao());
            safeSetValue(dataRow.createCell(25)::setCellValue, pertoAtmEntity.getValorAquisicao());
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