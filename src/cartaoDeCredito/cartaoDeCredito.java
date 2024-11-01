package cartaoDeCredito;

public class cartaoDeCredito {

    private String numero;
    private String nomeTitular;
    private String cpfTitular;
    private float limite;
    private float saldo;
    private float cashBack;

    public cartaoDeCredito(String numero, String nomeTitular, String cpfTitular, float limite, float saldo, float cashBack){
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.cpfTitular = cpfTitular;
        this.limite = limite;
        this.saldo = saldo;
        this.cashBack = cashBack;
    }
    
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
    public float getCashBack(){
        return cashBack;
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
    public void setCashBack(float cashBack){
        this.cashBack = cashBack;
    }

    public float consultarLimite(){
        return limite;

    }

    public float consultarTotalSaldo() {
        return saldo;

    }

    public void realizarTransacao(float valor) {
        if (valor <= limite) {
            float limiteAnterior = this.getLimite();
            this.setLimite(limiteAnterior - valor);
            System.out.println("Compra realizada com Sucesso!!! Valor: R$" + valor);
        } else {
            System.out.println("Saldo insuficiente. Limite disponível: R$" + limite);
        }
    }
    public void realizarTransacao(float valor, float taxaCashBack) {
        if (valor <= getLimite()) {
            float limiteAnterior = this.getLimite();
            this.setLimite(limiteAnterior - valor);

            float cashBack =  valor * (taxaCashBack / 100);
            this.setLimite(this.getLimite() + cashBack);

            float total = this.getSaldo();
            this.setSaldo(total + valor);

            System.out.println("Compra realizada com Sucesso!!! Valor: R$" + valor);
            System.out.println("Cashback de R$" + cashBack);
            System.out.println();

        } else {
            System.out.println("Você não possui limite suficiente... Seu limite é de: R$" + getLimite());
        }
    }

    public void alterarLimite(float novoLimite){
        if(novoLimite >= 0){
            this.setLimite(novoLimite);
            System.out.println("Limite atualizado com sucesso para: R$" + this.getLimite());

        } else {
            System.out.println("Valor limite inválido");
        }
    }

}
