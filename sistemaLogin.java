package cartaoDeCredito;

import java.util.Scanner;

public class sistemaLogin {
    public static void main (String[]args){

        cartaoDeCredito c = new cartaoDeCredito();

        c.numero = "1234-5678-9876-5432";
        c.nomeTitular = "Lucas Reis";
        c.cpfTitular = "123.456.789-00";
        c.limite = 1000;
        c.saldo = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("1 - Consultar limite");
        System.out.println("2 - Consultar fatura");
        System.out.println("3 - Realizar compra");

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
            default:
                System.out.println("Opção invalida, tente novamente.");
                break;
        }

        sc.close();

    }

}
