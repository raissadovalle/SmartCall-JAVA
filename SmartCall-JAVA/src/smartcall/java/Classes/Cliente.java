package smartcall.java.Classes;

public class Cliente {

    private String cpfCnpj;
    private String nome;
    private String logradouro;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String telefone;
    private String email;
    private String representante;
    private String rg;
    private String ie;
    
    public String getEmail() { return email; }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCpfCnpj() { return cpfCnpj; }
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
    
    public String getNome() { return nome;}
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {return logradouro;}
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {return numero;}
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {return bairro;}
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {return cidade;}
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {return estado;}
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {return cep;}
    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }    
    
    public String getRepresentante() {return representante;}
    public void setRepresentante(String representante) {
        this.representante = representante;
    } 
    
    public String getRg() {return rg;}
    public void setRg(String rg) {
        this.rg = rg;
    } 
    
    public String getIe() {return ie;}
    public void setIe(String ie) {
        this.ie = ie;
    } 
}
