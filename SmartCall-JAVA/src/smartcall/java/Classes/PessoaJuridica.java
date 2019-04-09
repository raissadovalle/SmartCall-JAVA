package smartcall.java.Classes;

public class PessoaJuridica extends Entidade{

    private String ie;
    private String representante;
    private String cnpj;

    public String getIe() {return ie; }
    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getRepresentante() {return representante;}
    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getCnpj() {return cnpj;}
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }    
}
