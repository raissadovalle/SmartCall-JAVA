package smartcall.java.Classes;

public class Chamado {

    private int codigo;
    private String descricao;
    private String assunto;
    private String status;
    private String idSetor;
    private String nomeSetor;
    private String chv_funcionario;
    private String nomeFuncionario;
    private String chv_cliente;
    private String nomeCliente;
    private String dataInicial;
    private String dataFinal;
    
    public int getCodigo() { return codigo;}
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() { return descricao;}
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAssunto() { return assunto;}
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdSetor() {return idSetor;}
    public void setIdSetor(String idSetor) { 
        this.idSetor = idSetor;
    }
    
    public String getNomeSetor() {return nomeSetor;}
    public void setNomeSetor(String nomeSetor) { 
        this.nomeSetor = nomeSetor;
    }

    public String getChv_funcionario() {return chv_funcionario;}
    public void setChv_funcionario(String chv_funcionario) {
        this.chv_funcionario = chv_funcionario;
    }

    public String getChv_cliente() {return chv_cliente;}
    public void setChv_cliente(String chv_cliente) {
        this.chv_cliente = chv_cliente;
    }

    public String getDataInicial() {return dataInicial;}
    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {return dataFinal; }
    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }
}
