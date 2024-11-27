package cartaoDeCredito;

import java.util.Scanner;

public class sistemaLogin {
    public static void main (String[]args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do cliente: ");
        String nomeCliente = sc.nextLine();

        System.out.println("Digite o CPF do cliente: ");
        String cpfCliente = sc.nextLine();

        System.out.println("Digite o CNPJ do cliente: ");
        String cnpjCliente = sc.nextLine();

        System.out.println("Digite o email do cliente: ");
        String emailCliente = sc.nextLine();

        System.out.println("Digite o telefone do cliente: ");
        String telefoneCliente = sc.nextLine();

        Cliente cliente = new Cliente(nomeCliente, cpfCliente, cnpjCliente, emailCliente, telefoneCliente);

        System.out.println("Digite o número do cartão: ");
        String numero = sc.nextLine();

        System.out.println("Digite o limite do cartão: ");
        float limite = sc.nextFloat();

        System.out.println("Digite o valor do cashback (%) ");
        float cashBack = sc.nextFloat();

        System.out.println();

        System.out.println("Escolha o tipo de cartão: ");
        System.out.println("1 - Cartão Basico");
        System.out.println("2 - Cartão Premium");
        System.out.println("3 - Cartão Empresarial");

        System.out.println();

        int tipoCartao = sc.nextInt();
        cartaoDeCredito c;

        switch (tipoCartao) {
            case 1:
                c = new CartaoBasico(numero, cliente, limite, limite, cashBack);
                break;
            case 2:
                System.out.println("Digite o limite extra para o Cartão Premium:");
                float limiteExtra = sc.nextFloat();
                c = new CartaoPremium(numero, cliente, limite, limite, cashBack, limiteExtra);
                break;
            case 3:
                c = new CartaoEmpresarial(numero, cliente, limite, limite, cashBack);
                break;
            default:
                System.out.println("Opção inválida. Criando um Cartão Básico por padrão.");
                c = new CartaoBasico(numero, cliente, limite, limite, cashBack);
                break;
        }
        
        boolean continuar = true;

        while(continuar) {
        
        System.out.println("    Menu de opções: ");

        System.out.println();
        
        System.out.println("1 - Consultar limite");
        System.out.println("2 - Consultar fatura");
        System.out.println("3 - Realizar compra");
        System.out.println("4 - Alterar limite");
        System.out.println("5 - Exibir histórico");
        System.out.println("6 - Realizar compra parcelada com o cartão Empresarial");
        System.out.println("7 - Sair");

        System.out.println();

        int opcao = sc.nextInt();

        switch(opcao){
            case 1:
                System.out.println("Limite disponível: R$" + c.consultarLimite());
                break;
            case 2: 
                System.out.println("Saldo atual da fatura: R$" + c.consultarTotalSaldo());
                break;
            case 3: 
                System.out.println("Digite o valor da compra: ");
                float valor = sc.nextFloat();

                System.out.println("Escolha o tipo da compra: ");
                System.out.println("1 - Compra normal");
                System.out.println("2 - Compra com cashback");
                int tipoCompra = sc.nextInt();

                if(tipoCompra == 1){
                c.realizarTransacao(valor); 

                } else if (tipoCompra == 2){
                System.out.println("Digite a taxa de cashback (%): ");
                float taxaCashBack = sc.nextFloat();
                c.realizarTransacao(valor, taxaCashBack); 

                } else {
                    System.out.println("Opção invalida, tente novamente.");
                }
                
                break;
            case 4:
                System.out.println("Digite o valor do novo limite: ");
                float novoLimite = sc.nextFloat();
                c.alterarLimite(novoLimite);
                break;
            case 5: 
                c.exibirHistorico();
                break;

            case 6: 
                if(tipoCartao == 3){
                    System.out.println("Digite o valor da compra: ");
                    float valorParcelado = sc.nextFloat();
                    System.out.println("Digite o número das parcelas: ");
                    int parcelas = sc.nextInt();
                    ((CartaoEmpresarial) c).realizarTransacaoParcela(valorParcelado, parcelas);
                } else {
                    System.out.println("Esta opção só está disponivel para o cartão Empresarial.");
                }
                break;

            case 7: 
                continuar = false;
                System.out.println("Saindo do Menu");
                break;
            default:
                System.out.println("Opção invalida, tente novamente.");
                break;
        }

    }

        sc.close();

    }

}
