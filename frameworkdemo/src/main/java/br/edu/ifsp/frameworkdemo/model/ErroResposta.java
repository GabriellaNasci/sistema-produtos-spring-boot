package br.edu.ifsp.frameworkdemo.model;

public class ErroResposta {
    private Integer status;
    private String erro;
    private String mensagem;

    public ErroResposta(Integer status,String erro,String mensagem) {
    this.status = status;
    this.erro = erro;
    this.mensagem = mensagem;
    }
    
    public Integer getStatus() {
        return status;
    }
    public String getErro() {
        return erro;
    }
    public String getMensagem() {
        return mensagem;
    }
}

