package org.study.processamentoplanilhas.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "adendo50")
public class TaaSpreadsheetEntity {

    // Colunas da tabela
    @Id
    @Column(name = "idadendo")
    private Long idAdendo;

    @Column(name = "nro_univ")
    private String nroUniv;

    @Column(name = "tpo_pbms")
    private String tpoPbms;

    @Column(name = "cls_pbms")
    private String clsPbms;

    @Column(name = "scl_pbms")
    private String sclPbms;

    @Column(name = "seq_pbms")
    private String seqPbms;

    @Column(name = "nome_do_contrato")
    private String nomeDoContrato;

    @Column(name = "prf_insl")
    private String prfInls;

    @Column(name = "sag_insl")
    private String sagInls;

    @Column(name = "nome")
    private String nome;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "uf")
    private String uf;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "criticidade")
    private Long criticidade;

    @Column(name = "fornecedor")
    private String fornecedor;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "tipo_dependencia")
    private String tipoDependencia;

    @Column(name = "semat")
    private String semat;

    @Column(name = "supridora")
    private String supridora;

    @Column(name = "nome_supridora")
    private String nomeSupridora;

    @Column(name = "distancia")
    private Long distancia;

    @Column(name = "funcao")
    private String funcao;

    @Column(name = "tempo_de_aquisicao")
    private String tempoDeAquisicao;

    @Column(name = "cod_config")
    private String codConfig;

    @Column(name = "ctr_aqsc")
    private String ctrAqsc;

    @Column(name = "competencia")
    private String competencia;

    @Column(name = "vlraquisicao")
    private String vlrAquisicao;

    @Column(name = "vlrresidual")
    private String vlrResidual;

    @Column(name = "seret")
    private String seret;

    @Column(name = "nomeseret")
    private String nomeSeret;

    @Column(name = "distanciaseret")
    private String distanciaSeret;

    public Long getIdAdendo() {
        return idAdendo;
    }

    public void setIdAdendo(Long idAdendo) {
        this.idAdendo = idAdendo;
    }

    public String getNroUniv() {
        return nroUniv;
    }

    public void setNroUniv(String nroUniv) {
        this.nroUniv = nroUniv;
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

    public String getNomeDoContrato() {
        return nomeDoContrato;
    }

    public void setNomeDoContrato(String nomeDoContrato) {
        this.nomeDoContrato = nomeDoContrato;
    }

    public String getPrfInls() {
        return prfInls;
    }

    public void setPrfInls(String prfInls) {
        this.prfInls = prfInls;
    }

    public String getSagInls() {
        return sagInls;
    }

    public void setSagInls(String sagInls) {
        this.sagInls = sagInls;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Long getCriticidade() {
        return criticidade;
    }

    public void setCriticidade(Long criticidade) {
        this.criticidade = criticidade;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoDependencia() {
        return tipoDependencia;
    }

    public void setTipoDependencia(String tipoDependencia) {
        this.tipoDependencia = tipoDependencia;
    }

    public String getSemat() {
        return semat;
    }

    public void setSemat(String semat) {
        this.semat = semat;
    }

    public String getSupridora() {
        return supridora;
    }

    public void setSupridora(String supridora) {
        this.supridora = supridora;
    }

    public String getNomeSupridora() {
        return nomeSupridora;
    }

    public void setNomeSupridora(String nomeSupridora) {
        this.nomeSupridora = nomeSupridora;
    }

    public Long getDistancia() {
        return distancia;
    }

    public void setDistancia(Long distancia) {
        this.distancia = distancia;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getTempoDeAquisicao() {
        return tempoDeAquisicao;
    }

    public void setTempoDeAquisicao(String tempoDeAquisicao) {
        this.tempoDeAquisicao = tempoDeAquisicao;
    }

    public String getCodConfig() {
        return codConfig;
    }

    public void setCodConfig(String codConfig) {
        this.codConfig = codConfig;
    }

    public String getCtrAqsc() {
        return ctrAqsc;
    }

    public void setCtrAqsc(String ctrAqsc) {
        this.ctrAqsc = ctrAqsc;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public String getVlrAquisicao() {
        return vlrAquisicao;
    }

    public void setVlrAquisicao(String vlrAquisicao) {
        this.vlrAquisicao = vlrAquisicao;
    }

    public String getVlrResidual() {
        return vlrResidual;
    }

    public void setVlrResidual(String vlrResidual) {
        this.vlrResidual = vlrResidual;
    }

    public String getSeret() {
        return seret;
    }

    public void setSeret(String seret) {
        this.seret = seret;
    }

    public String getNomeSeret() {
        return nomeSeret;
    }

    public void setNomeSeret(String nomeSeret) {
        this.nomeSeret = nomeSeret;
    }

    public String getDistanciaSeret() {
        return distanciaSeret;
    }

    public void setDistanciaSeret(String distanciaSeret) {
        this.distanciaSeret = distanciaSeret;
    }
    public String toString() {
        return "TaaSpreadsheet{" +
                "idAdendo='" + idAdendo + '\'' +
                "nroUniv'" + nroUniv + '\'' +
                "tpoPbms'" + tpoPbms + '\'' +
                "clsPbms" + clsPbms + '\'' +
                "sclPbms" + sclPbms + '\'' +
                "seqPbms" + seqPbms + '\'' +
                "nomeDoContrato" + nomeDoContrato + '\'' +
                "prfInls" + prfInls + '\'' +
                "sagInls" + sagInls + '\'' +
                "nome" + nome + '\'' +
                "municipio" + municipio + '\'' +
                "uf" + municipio + '\'' +
                "valor" + valor + '\'' +
                "criticidade" + criticidade + '\'' +
                "fornecedor" + criticidade + '\'' +
                "modelo" + modelo + '\'' +
                "tipoDependencia" + tipoDependencia + '\'' +
                "semat" + semat + '\'' +
                "supridora" + supridora + '\'' +
                "nomeSupridora" + nomeSupridora + '\'' +
                "distancia" + distancia + '\'' +
                "funcao" + funcao + '\'' +
                "tempoDeAquisicao" + tempoDeAquisicao + '\'' +
                "codConfig" + codConfig + '\'' +
                "ctrAqsc" + ctrAqsc + '\'' +
                "competencia" + competencia + '\'' +
                "vlrAquisicao" + vlrAquisicao + '\'' +
                "vlrResidual" + vlrResidual + '\'' +
                "seret" + seret + '\'' +
                "nomeSeret" + nomeSeret + '\'' +
                "distanciaSeret" + distanciaSeret + '\'' +
                '}';
    }
}
