package cartaoDeCredito;

public class Cliente {
    private String nome;
    private String cpf;
    private String cnpj;
    private String email;
    private String telefone;

    public Cliente(String nome, String cpf, String cnpj, String email, String telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome(){
        return nome;
    }
    public String getCpf(){
        return cpf;
    }
    public String getCnpj(){
        return cnpj;
    }
    public String getEmail(){
        return email;
    }
    public String getTelefone(){
        return telefone;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

}
