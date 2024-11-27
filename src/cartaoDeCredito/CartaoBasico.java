package cartaoDeCredito;

import java.util.Date;

public class CartaoBasico extends cartaoDeCredito {

    public CartaoBasico(String numero, Cliente cliente, float limite, float saldo, float cashBack){
        super(numero, cliente, limite, saldo, cashBack);
    }

    @Override

    public void realizarTransacao(float valor){
        if (valor <= getLimite()) {
            setLimite(getLimite() - valor);
            historicoDeTransacoes.add(new Transacao(new Date(), valor, "Compra com cartão básico"));
            System.out.println("Compra no cartão basico realizada com sucesso");

        } else {
            System.out.println("Saldo insuficiente no cartão básico.");
        }
    }

}
