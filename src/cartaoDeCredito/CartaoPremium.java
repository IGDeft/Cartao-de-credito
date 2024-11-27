package cartaoDeCredito;

import java.util.Date;

public class CartaoPremium extends cartaoDeCredito {

    private float limiteExtra;

    public CartaoPremium(String numero, Cliente cliente, float limite, float saldo, float cashBack, float limiteExtra){
        super(numero, cliente, limite, saldo, cashBack);
        this.limiteExtra = limiteExtra;
    }

    @Override

    public float getLimite() {
        return super.getLimite() + limiteExtra;
    }

    public void realizarTransacao(float valor) {
        if(valor <= getLimite()) {
            setLimite(getLimite() - valor);
            float cashBackValor = valor * (getCashBack() / 100);
            historicoDeTransacoes.add(new Transacao(new Date(), valor, "Compra com cartão Premium - Cashback: R$" + cashBackValor));
            System.out.println("Compra no cartão premium realizada com sucesso! Valor: R$" + valor);
            System.out.println("Cashback acumulado R$" + cashBackValor);

        } else {
            System.out.println("Saldo insuficiente no cartão premium,");

        }
    }

}
