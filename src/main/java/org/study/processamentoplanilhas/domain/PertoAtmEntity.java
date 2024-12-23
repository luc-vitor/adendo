package org.study.processamentoplanilhas.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "tb_perto_atm")
public class PertoAtmEntity {

    @Id
    @Column(name = "nro_univ")
    private String nroUniv;

    @Column(name = "nome_do_contrato")
    private String nomeDoContrato;

    @Column(name = "fornecedor")
    private String fornecedor;

    @Column(name = "prf_insl")
    private String prfInsl;

    @Column(name = "sag_insl")
    private String sagInsl;

    @Column(name = "dependencia")
    private String dependencia;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "codmunicipio")
    private String codMunicipio;

    @Column(name = "uf")
    private String uf;

    @Column(name = "cat")
    private String cat;

    @Column(name = "cat_resp")
    private String catResp;

    @Column(name = "regional")
    private String regional;

    @Column(name = "dist")
    private String dist;

    @Column(name = "distanciabb")
    private String distanciabb;

    @Column(name = "criticidade")
    private String criticidade;

    @Column(name = "semat")
    private String semat;

    @Column(name = "vlr_parceiros")
    private String vlrParceiros;

   // @Column(name = "PRF-SB")
   // private String prfSb;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cep")
    private String cep;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "tempo_aquisicao")
    private String tempoAquisicao;

    @Column(name = "lote")
    private String lote;

    @Column(name = "valor_residual")
    private String valorResidual;

    @Column(name = "valor_aquisicao")
    private String valorAquisicao;

    public String getNroUniv() {
        return nroUniv;
    }

    public void setNroUniv(String nroUniv) {
        this.nroUniv = nroUniv;
    }

    public String getNomeDoContrato() {
        return nomeDoContrato;
    }

    public void setNomeDoContrato(String nomeDoContrato) {
        this.nomeDoContrato = nomeDoContrato;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getPrfInsl() {
        return prfInsl;
    }

    public void setPrfInsl(String prfInsl) {
        this.prfInsl = prfInsl;
    }

    public String getSagInsl() {
        return sagInsl;
    }

    public void setSagInsl(String sagInsl) {
        this.sagInsl = sagInsl;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(String codmunicipio) {
        this.codMunicipio = codmunicipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getCatResp() {
        return catResp;
    }

    public void setCatResp(String catResp) {
        this.catResp = catResp;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getDistanciabb() {
        return distanciabb;
    }

    public void setDistanciabb(String distanciab) {
        this.distanciabb = distanciab;
    }

    public String getCriticidade() {
        return criticidade;
    }

    public void setCriticidade(String criticidade) {
        this.criticidade = criticidade;
    }

    public String getSemat() {
        return semat;
    }

    public void setSemat(String semat) {
        this.semat = semat;
    }

    public String getVlrParceiros() {
        return vlrParceiros;
    }

    public void setVlrParceiros(String vlrParceiros) {
        this.vlrParceiros = vlrParceiros;
    }

 //   public String getPrfSb() {
  //      return prfSb;
  //  }

 //   public void setPrfSb(String PRFSB) {
 //       this.prfSb = PRFSB;
 //   }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTempoAquisicao() {
        return tempoAquisicao;
    }

    public void setTempoAquisicao(String tempoAquisicao) {
        this.tempoAquisicao = tempoAquisicao;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getValorResidual() {
        return valorResidual;
    }

    public void setValorResidual(String valorResidual) {
        this.valorResidual = valorResidual;
    }

    public String getValorAquisicao() {
        return valorAquisicao;
    }

    public void setValorAquisicao(String valorAquisicao) {
        this.valorAquisicao = valorAquisicao;
    }

    @Override
    public String toString() {
        return "PertoAtmEntity{" +
                "nroUniv='" + nroUniv + '\'' +
                ", nomeDoContrato='" + nomeDoContrato + '\'' +
                ", fornecedor='" + fornecedor + '\'' +
                ", prfInsl='" + prfInsl + '\'' +
                ", sagInsl='" + sagInsl + '\'' +
                ", dependencia='" + dependencia + '\'' +
                ", municipio='" + municipio + '\'' +
                ", codmunicipio='" + codMunicipio + '\'' +
                ", uf='" + uf + '\'' +
                ", cat='" + cat + '\'' +
                ", catResp='" + catResp + '\'' +
                ", regional='" + regional + '\'' +
                ", dist='" + dist + '\'' +
                ", distanciab='" + distanciabb + '\'' +
                ", criticidade='" + criticidade + '\'' +
                ", semat='" + semat + '\'' +
                ", vlrParceiros='" + vlrParceiros + '\'' +
      //          ", PRFSB='" + prfSb + '\'' +
                ", endereco='" + endereco + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", tempoAquisicao='" + tempoAquisicao + '\'' +
                ", lote='" + lote + '\'' +
                ", valorResidual='" + valorResidual + '\'' +
                ", valorAquisicao='" + valorAquisicao + '\'' +
                '}';
    }
}

