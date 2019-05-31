package smartcall.java.Classes;

public class Chamado {

    private int codigo;
    private String descricao;
    private String assunto;
    private String status;
    private String idSetor;
    private String nomeSetor;
    private String idFuncionario;
    private String nomeFuncionario;
    private String idCliente;
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
    
    public String getNomeFuncionario() {return nomeFuncionario;}
    public void setNomeFuncionario(String nomeFuncionario) { 
        this.nomeFuncionario = nomeFuncionario;
    }
    
    public String getNomeCliente() {return nomeCliente;}
    public void setNomeCliente(String nomeCliente) { 
        this.nomeCliente = nomeCliente;
    }

    public String getIdFuncionario() {return idFuncionario;}
    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getIdCliente() {return idCliente;}
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
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
