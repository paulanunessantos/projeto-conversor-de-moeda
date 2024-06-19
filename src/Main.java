import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        Consulta consulta = new Consulta();
        Api api = new Api();
        int busca = -1;

        while (busca != 7){
            System.out.println("***********************************************");
            System.out.println("Seja bem vindo(a) ao Conversor de Moeda!");
            System.out.println(" ");
            System.out.println("1) Dólar(USD)           >> Peso Argentino(ARS)");
            System.out.println("2) Peso Argentino(ARS)  >> Dólar(USD)");
            System.out.println("3) Dólar(USD)           >> Real Brasileiro(BRL)");
            System.out.println("4) Real Brasileiro(BRL) >> Dólar(USD)");
            System.out.println("5) Dólar(USD)           >> Peso Colombiano(COP)");
            System.out.println("6) Peso Colombiano(COP) >> Dólar(USD)");
            System.out.println("7) Sair");
            System.out.println("Escolha uma opção válida: ");
            System.out.println("***********************************************");

            busca = leitura.nextInt();

            switch (busca){
                case 1:
                    consulta.setMoedaBase("USD");
                    consulta.setMoedaAlvo("ARS");
                    break;
                case 2:
                    consulta.setMoedaBase("ARS");
                    consulta.setMoedaAlvo("USD");
                    break;
                case 3:
                    consulta.setMoedaBase("USD");
                    consulta.setMoedaAlvo("BRL");
                    break;
                case 4:
                    consulta.setMoedaBase("BRL");
                    consulta.setMoedaAlvo("USD");
                    break;
                case 5:
                    consulta.setMoedaBase("USD");
                    consulta.setMoedaAlvo("COP");
                    break;
                case 6:
                    consulta.setMoedaBase("COP");
                    consulta.setMoedaAlvo("USD");
                    break;
                case 7:
                    System.out.println("Programa encerrado!");
                    continue;
                default:
                    System.out.println("Digite um valor válido!");
                    continue;
            }

            System.out.println("Digite o valor que deseja converter: ");
            consulta.setValorBase(leitura.nextDouble());
            Moeda moeda = api.converte(consulta);
            System.out.println("Valor " + consulta.getValorBase() + " " +
                    consulta.getMoedaBase() + " corresponde ao valor final de >> "
                    + moeda.conversion_result() + " " + consulta.getMoedaAlvo());
        }
    }
}
