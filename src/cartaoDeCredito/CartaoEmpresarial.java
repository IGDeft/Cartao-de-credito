package cartaoDeCredito;

import java.util.Date;

public class CartaoEmpresarial extends cartaoDeCredito {

    public CartaoEmpresarial(String numero, Cliente cliente, float limite, float saldo, float cashBack){
        super(numero, cliente, limite, saldo, cashBack);

    }

    public void realizarTransacaoParcela(float valor, int parcelas){
        if(parcelas > 0 && valor <= getLimite()){
            setLimite(getLimite() - valor);
            historicoDeTransacoes.add(new Transacao(new Date(), valor, "Compra Parcelada - " + parcelas + "x sem juros"));
            System.out.println("Compra no Cartão Empresarial parcelada com sucesso! Valor: R$" + valor + " em " + parcelas + "x sem juros.");

        } else {
            System.out.println("Saldo insuficiente ou número de parcelas inválido no Cartão Empresarial.");
        }
    }

    @Override

    public void realizarTransacao(float valor){
        System.out.println("Para compras utilizando o cartão empresarial, use o método realizarTransacaoParcelada.");
    }

}
