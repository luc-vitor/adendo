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

    public void getSpreadsheet() {

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
            dataRow.createCell(0).setCellValue(pertoAtmEntity.getNroUniv());
            dataRow.createCell(1).setCellValue(pertoAtmEntity.getNomeDoContrato());
            dataRow.createCell(2).setCellValue(pertoAtmEntity.getFornecedor());
            dataRow.createCell(3).setCellValue(pertoAtmEntity.getPrfInsl());
            dataRow.createCell(4).setCellValue(pertoAtmEntity.getSagInsl());
            dataRow.createCell(5).setCellValue(pertoAtmEntity.getDependencia());
            dataRow.createCell(6).setCellValue(pertoAtmEntity.getMunicipio());
            dataRow.createCell(7).setCellValue(pertoAtmEntity.getCodMunicipio());
            dataRow.createCell(8).setCellValue(pertoAtmEntity.getUf());
            dataRow.createCell(9).setCellValue(pertoAtmEntity.getCat());
            dataRow.createCell(10).setCellValue(pertoAtmEntity.getCatResp());
            dataRow.createCell(11).setCellValue(pertoAtmEntity.getRegional());
            dataRow.createCell(12).setCellValue(pertoAtmEntity.getDist());
            dataRow.createCell(13).setCellValue(pertoAtmEntity.getDistanciabb());
            dataRow.createCell(14).setCellValue(pertoAtmEntity.getCriticidade());
            dataRow.createCell(15).setCellValue(pertoAtmEntity.getSemat());
            dataRow.createCell(16).setCellValue(pertoAtmEntity.getVlrParceiros());
            //dataRow.createCell(17).setCellValue(pertoAtmEntity.getPrfSb);
            dataRow.createCell(18).setCellValue(pertoAtmEntity.getEndereco());
            dataRow.createCell(19).setCellValue(pertoAtmEntity.getBairro());
            dataRow.createCell(20).setCellValue(pertoAtmEntity.getCep());
            dataRow.createCell(21).setCellValue(pertoAtmEntity.getTelefone());
            dataRow.createCell(22).setCellValue(pertoAtmEntity.getCnpj());
            dataRow.createCell(23).setCellValue(pertoAtmEntity.getTempoAquisicao());
            dataRow.createCell(24).setCellValue(pertoAtmEntity.getLote());
            dataRow.createCell(25).setCellValue(pertoAtmEntity.getValorResidual());
            dataRow.createCell(26).setCellValue(pertoAtmEntity.getValorAquisicao());
            rowNum = rowNum + 1;
        }

        log.info("AutoSizing colunas");
        // todo: lembrar de alterar o 3 quando tiver + colunas
        for (int i = 0; i < 27; i++) {
            sheet.autoSizeColumn(i);
        }

        log.info("Creating file");
        File currentDir = new File(".");
        String currentDirPath = currentDir.getAbsolutePath();
        String fileLocation = currentDirPath.substring(0, currentDirPath.length()-1) + "PertoAtm.xls";

        try {
            FileOutputStream fos = new FileOutputStream(fileLocation);
            workbook.write(fos);
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
