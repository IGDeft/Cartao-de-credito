package cartaoDeCredito;

import java.util.Scanner;

public class sistemaLogin {
    public static void main (String[]args){

        cartaoDeCredito c = new cartaoDeCredito();

        c.setNumero("1234-5678-9876-5432");
        c.setNomeTitular("Lucas Reis");
        c.setCpfTitular("123.456.789-00");
        c.setLimite(1000);
        c.setSaldo(0);

        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while(continuar) {
        
        System.out.println("    Menu de opções: ");

        System.out.println();
        
        System.out.println("1 - Consultar limite");
        System.out.println("2 - Consultar fatura");
        System.out.println("3 - Realizar compra");
        System.out.println("4-  Alterar limite:");
        System.out.println("5-  Sair");

        System.out.println();

        int opçao = sc.nextInt();

        switch(opçao){
            case 1:
                System.out.println("Limite disponível: " + c.consultarLimite());
                break;
            case 2: 
                System.out.println("Saldo atual da fatura: " + c.consultartotalSaldo());
                break;
            case 3: 
                System.out.println("Digite o valor da compra: ");
                float valor = sc.nextFloat();
                c.realizarTransacao(valor);
                break;
            case 4:
                System.out.println("Digite o valor do novo limite: ");
                float novoLimite = sc.nextFloat();
                c.alterarLimite(novoLimite);
                break;
            case 5: 
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
