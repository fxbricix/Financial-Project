package poo.util; // Package
import poo.modelo.Financiamento;

import java.util.InputMismatchException;
import java.util.Scanner;
public class InterfaceUsuario {

    Scanner leitor = new Scanner(System.in);

    public double pedirValorImovel(Scanner leitor){ //  Pede valor do imovel usando o parametro leitor ( scanner )
        double valor = 0;
        boolean erro = false; // Usei um video de base para utilizar loopings e try e catch(https://www.youtube.com/watch?v=GlTvLWJxBWM)
        do {
            erro = false;
            try {
                System.out.println("Informe o valor do Imovel: ");
                valor = leitor.nextDouble();
                if (valor <= 0) {
                    System.out.println("O sistema não aceita valores zerados ou negativos!");
                    erro = true;
                }
            } catch (Exception e) {
                System.out.println("Digite o valor do imovel utilizando os valores corretos!");
                erro = true;
                leitor.nextLine();
            }
        }while (erro);
        return valor;
    }

    public int pedirPrazoFinanciamento(Scanner leitor) { // Pede prazo do financiamento usando o parametro leitor ( scanner )
        int prazo = 0;
        boolean erro = false;
        do {
            erro = false;
            try {
                System.out.println("Digite o prazo seguindo o padrão em anos, do financiamento: ");
                prazo = leitor.nextInt();
                if (prazo <= 0) {
                    System.out.println("O sistema não aceita prazos zerados ou negativos!");
                    erro = true;
                }
            } catch (Exception e) {
                System.out.println("Digite o prazo do financiamento corretamente!");
                erro = true;
                leitor.nextLine();
            }
        } while (erro);
        return prazo;
    }

    public double pedirTaxaJuros(Scanner leitor) { // Pede a taxa de juros  do financiamento usando o parametro leitor ( scanner )
        double taxa = 0;
        boolean erro = false;
        do {
            erro = false;
            try {
                System.out.println("Digite o valor da taxa de juros do financiamento: ");
                taxa = leitor.nextDouble();
                if (taxa <= 0) {
                    System.out.println("Nosso sistema não aceita valores negativos ou zerados!");
                    erro = true;
                } else if (taxa >= 13 && taxa > 0) { // Máximo de Juros em 12 % pois é o máximo permitido em lei, que foi usada de base para definir um limite max
                    System.out.println("As taxas acima de 12% não são aceitas!");
                    erro = true;
                }
            } catch (Exception e){
                System.out.println("Por favor digite valores válidos para taxa de juros!\nO Sistema só aceita numerais!\n");
                erro = true;
                leitor.nextLine();
            }
        } while (erro);
        return taxa;
    }

    public String pedirZona(Scanner leitor){
        String zona;
        System.out.println("\nZonas:\n-Comercial\n-Urbana\n-Industrial");
        System.out.println("Digite a zona onde o terreno se encontra: ");
        zona = leitor.next();
        return zona;

    }
    
    public static double receberDesconto() {
        Scanner leitor = new Scanner(System.in);
        double valorDesconto;
        while (true) {
            try {
                System.out.println("Favor informe o valor do desconto!\nO valor não pode ser zerado e nem acima de 100!");
                valorDesconto = leitor.nextDouble();
                if (valorDesconto <= 0 || valorDesconto > 100) {
                    System.out.println("Valores não aceitos pelo sistema!");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido!");
                leitor.next();
            }
        }
        return valorDesconto;
    }
    public int receberAndarApartamento(Scanner leitor) {
        int numAndar;
        while (true) {
            try {
                System.out.println("Informe o andar do apartamento: ");
                numAndar = leitor.nextInt();
                if (numAndar < 0) {
                    System.out.println("Não existem andares negativos!");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println(("Utilize numeros inteiros para informar o andar do apartamento!"));
                leitor.next();
            }
        } return numAndar;
    }

    public int receberNumeroGaragem(Scanner leitor) {
        int numGaragem;
        while (true){
            try {
                System.out.println("Informe o numero da garagem: ");
                numGaragem = leitor.nextInt();
                if (numGaragem < 0 ){
                    System.out.println("Favor utilizar valores positivos para informar o numero da garagem!");
                } break;
            } catch (InputMismatchException e){
                System.out.println("Utilize numeros inteiros para informar o numero da garagem!");
            }
        } return numGaragem;
    }

    public double receberTamanhoTerreno(Scanner leitor) {
        double tamTerreno;
        while (true){
            try{
                System.out.println("Informe o tamanho do terreno: ");
                tamTerreno = leitor.nextDouble();
                if (tamTerreno < 0){
                    System.out.println("Favor utilizar valores positivos para informar o tamanho do terreno!");
                } break;
            } catch(InputMismatchException e){
                System.out.println("Utilize numerais positivos!");
            }
        } return tamTerreno;
    }

    public double receberAreaConstruida(Scanner leitor) {
        double tamAreaConstruida;
        while (true){
            try{
                System.out.println("Informe a area construida: ");
                tamAreaConstruida = leitor.nextDouble();
                if (tamAreaConstruida < 0){
                    System.out.println("Favor utilizar valores positivos para informar a area construida!");
                } break;
            } catch(InputMismatchException e){
                System.out.println("Utilize numerais positivos!");
            }
        } return tamAreaConstruida;
    }

}