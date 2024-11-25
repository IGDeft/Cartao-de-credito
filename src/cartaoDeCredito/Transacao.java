package cartaoDeCredito;

import java.util.Date;

public class Transacao {

    private Date data;
    private float valor;
    private String descricao;

    public Transacao(Date data, float valor, String descricao) {
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
        
    }

    public Date getData(){
        return data;
    }
    public float getValor(){
        return valor;
    }
    public String descricao(){
        return descricao;
    }

    public String exibirDetalhes(){
        return "Data: " + data + ", Valor: R$" + valor + ", Descricão: " + descricao;
    }

}
