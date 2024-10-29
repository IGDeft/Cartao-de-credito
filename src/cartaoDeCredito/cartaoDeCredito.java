package cartaoDeCredito;

public class cartaoDeCredito {

    private String numero;
    private String nomeTitular;
    private String cpfTitular;
    private float limite;
    private float saldo;

    public String getNumero(){
        return numero;
    }
    public String getNomeTitular(){
        return nomeTitular;
    }

    public String getCpfTitular(){
        return cpfTitular;
    }

    public float getLimite(){
        return limite;
    }

    public float getSaldo(){
        return saldo;
    }

    public void setNumero(String numero){
        this.numero = numero;
    }

    public void setNomeTitular(String nomeTitular){
        this.nomeTitular = nomeTitular;
    }

    public void setCpfTitular(String cpfTitular){
        this.cpfTitular = cpfTitular;
    }

    public void setLimite(float limite){
        this.limite = limite;
    }

    public void setSaldo(float saldo){
        this.saldo = saldo;
    }

    public float consultarLimite(){
        return limite;

    }

    public float consultartotalSaldo() {
        return saldo;

    }

    public void realizarTransacao(float valor) {
        if (valor <= getLimite()) {
            float limiteAnterior = this.getLimite();
            this.setLimite(limiteAnterior - valor);
            float total = this.getSaldo();
            this.setSaldo(total + valor);

        } else {
            System.out.println("Você não possui saldo suficiente");
        }
    }

    public void alterarLimite(float novoLimite){
        if(novoLimite >= 0){
            this.setLimite(novoLimite);
            System.out.println("Limite atualizado com sucesso para: " + this.getLimite());

        } else {
            System.out.println("Valor limite inválido");
        }
    }

}
