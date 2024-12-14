package org.study.processamentoplanilhas.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "adendo52")
public class DemaisBensSpreadsheetEntity {

    // Colunas da tabela

    @Id
    @Column(name = "nro_univ")
    private String numeroDoBem;

    @Column(name = "mes")
    private String mes;

    @Column(name = "tpo_pbms")
    private String tpoPbms;

    @Column(name = "cls_pbm")
    private String clsPbms;

    @Column(name = "scl_pbms")
    private String sclPbms;

    @Column(name = "seq_pbms")
    private String seqPbms;

 //   @Column(name = "seq_pbms") TEM NA PLANILHA MAS NÃO TEM NO BD
 //   private String pbms;

    @Column(name = "cod_config")
    private String cdCfgBem;

    @Column(name = "nome_do_contrato")
    private String nomeNoContrato;

    @Column(name = "valor")
    private Double vl;

    @Column(name = "criticidade")
    private Long criticidade52;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "grupo")
    private String grupo;

    @Column(name = "fornecedor")
    private String fornecedor;

    @Column(name = "cd_uor_insl")
    private String cdOurInsl;

    @Column(name = "prf_insl")
    private String prfDepeInsl;

    @Column(name = "sag_insl")
    private String sagInsl;

    @Column(name = "nome")
    private String nomeOurInstalacao;

    @Column(name = "municipio")
    private String municipioAtualizado;

    @Column(name = "uf")
    private String ufAtualizada;

    @Column(name = "tipo_dependencia")
    private String tipoDeDependeciaAtualizada;

    @Column(name = "lote")
    private Long lote;

    public String getNumeroDoBem() {
        return numeroDoBem;
    }

    public void setNumeroDoBem(String numeroDoBem) {
        this.numeroDoBem = numeroDoBem;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getTpoPbms() {
        return tpoPbms;
    }

    public void setTpoPbms(String tpoPbms) {
        this.tpoPbms = tpoPbms;
    }

    public String getClsPbms() {
        return clsPbms;
    }

    public void setClsPbms(String clsPbms) {
        this.clsPbms = clsPbms;
    }

    public String getSclPbms() {
        return sclPbms;
    }

    public void setSclPbms(String sclPbms) {
        this.sclPbms = sclPbms;
    }

    public String getSeqPbms() {
        return seqPbms;
    }

    public void setSeqPbms(String seqPbms) {
        this.seqPbms = seqPbms;
    }

 //   public String getPbms() {
 //       return pbms;
 //   }

 //   public void setPbms(String pbms) {
 //       this.pbms = pbms;
 //   }

    public String getCdCfgBem() {
        return cdCfgBem;
    }

    public void setCdCfgBem(String cdCfgBem) {
        this.cdCfgBem = cdCfgBem;
    }

    public String getNomeNoContrato() {
        return nomeNoContrato;
    }

    public void setNomeNoContrato(String nomeNoContrato) {
        this.nomeNoContrato = nomeNoContrato;
    }

    public Double getVl() {
        return vl;
    }

    public void setVl(Double vl) {
        this.vl = vl;
    }

    public Long getCriticidade52() {
        return criticidade52;
    }

    public void setCriticidade52(Long criticidade52) {
        this.criticidade52 = criticidade52;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getCdOurInsl() {
        return cdOurInsl;
    }

    public void setCdOurInsl(String cdOurInsl) {
        this.cdOurInsl = cdOurInsl;
    }

    public String getPrfDepeInsl() {
        return prfDepeInsl;
    }

    public void setPrfDepeInsl(String prfDepeInsl) {
        this.prfDepeInsl = prfDepeInsl;
    }

    public String getSagInsl() {
        return sagInsl;
    }

    public void setSagInsl(String sagInsl) {
        this.sagInsl = sagInsl;
    }

    public String getNomeOurInstalacao() {
        return nomeOurInstalacao;
    }

    public void setNomeOurInstalacao(String nomeOurInstalacao) {
        this.nomeOurInstalacao = nomeOurInstalacao;
    }

    public String getMunicipioAtualizado() {
        return municipioAtualizado;
    }

    public void setMunicipioAtualizado(String municipioAtualizado) {
        this.municipioAtualizado = municipioAtualizado;
    }

    public String getUfAtualizada() {
        return ufAtualizada;
    }

    public void setUfAtualizada(String ufAtualizada) {
        this.ufAtualizada = ufAtualizada;
    }

    public String getTipoDeDependeciaAtualizada() {
        return tipoDeDependeciaAtualizada;
    }

    public void setTipoDeDependeciaAtualizada(String tipoDeDependeciaAtualizada) {
        this.tipoDeDependeciaAtualizada = tipoDeDependeciaAtualizada;
    }

    public Long getLote() {
        return lote;
    }

    public void setLote(Long lote) {
        this.lote = lote;
    }

    @Override
    public String toString() {
        return "DemaisBensSpreadsheet{" +
                "numeroDoBem='" + numeroDoBem + '\'' +
                ", mes='" + mes + '\'' +
                ", tpoPbms='" + tpoPbms + '\'' +
                ", clsPbms='" + clsPbms + '\'' +
                ", sclPbms='" + sclPbms + '\'' +
                ", seqPbms='" + seqPbms + '\'' +
               // ", pbms='" + pbms + '\'' +
                ", cdCfgBem='" + cdCfgBem + '\'' +
                ", nomeNoContrato='" + nomeNoContrato + '\'' +
                ", vl='" + vl + '\'' +
                ", criticidade52='" + criticidade52 + '\'' +
                ", modelo='" + modelo + '\'' +
                ", grupo='" + grupo + '\'' +
                ", fornecedor='" + fornecedor + '\'' +
                ", cdOurInsl='" + cdOurInsl + '\'' +
                ", prfDepeInsl='" + prfDepeInsl + '\'' +
                ", sagInsl='" + sagInsl + '\'' +
                ", nomeOurInstalacao='" + nomeOurInstalacao + '\'' +
                ", municipioAtualizado='" + municipioAtualizado + '\'' +
                ", ufAtualizada='" + ufAtualizada + '\'' +
                ", tipoDeDependeciaAtualizada='" + tipoDeDependeciaAtualizada + '\'' +
                ", lote='" + lote + '\'' +
                '}';
    }
}
