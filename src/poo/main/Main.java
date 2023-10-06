package poo.main; // Definição de package da main
import poo.modelo.*;
import poo.util.InterfaceUsuario; // Import da  classe interface usuario

import java.io.*;
import java.util.ArrayList; // Import do Util ArrayList
import java.util.Scanner; // Import do Util Scanner ( INPUT )

/*
@author Fabricio Moreira Pedroso
 */

public class Main {
    public static void main(String[] args) throws IOException {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        ArrayList<Financiamento> financiamentos = new ArrayList<Financiamento>(); // Instanciação da ArrayList
        Casa casan1 = new Casa(350000, 23, 12, 100, 30, 23); // Instanciação da Casa Numero 1
        Casa casan2 = new Casa(280000, 22, 12, 100, 25, 20); //  Instanciação da Casa Numero 2
        Apartamento apt1 = new Apartamento(280000, 29, 12, 1, 10); // Instanciação do Apartamento Numero 1
        Apartamento apt2 = new Apartamento(290000, 15, 10, 2, 10); // Instanciação do Apartamento Numero 2
        Scanner leitor = new Scanner(System.in); // Uso do scanner para receber o input
        Terreno terreno = new Terreno(interfaceUsuario.pedirValorImovel(leitor), interfaceUsuario.pedirPrazoFinanciamento(leitor), interfaceUsuario.pedirTaxaJuros(leitor), interfaceUsuario.pedirZona(leitor));
        //Instanciação do terreno utilizando o input para atender aos parametros da classe
        financiamentos.add(casan1); // Adicionando a arraylist os itens casa n1
        financiamentos.add(casan2); // casa n2
        financiamentos.add(apt1); // Apartamento n 1
        financiamentos.add(apt2); // Apartamento n 2
        financiamentos.add(terreno); // Terreno n 2
        System.out.println(""); // Finalizando com um espaço apenas por toc.


        Arquivo.escreverTexto(financiamentos, "ArquivoFinanciamento.txt");
        Arquivo.serializarTexto(financiamentos, "Binarios.txt");



        double valorTotalImoveis = 0; // Defino valores como zerados ate que seja feito o calculo
        double valorTotalFinanciamentos = 0; // /\
        int i = 1; // Defino i como 1 para dar uma base de começo
        for (Financiamento financiamento : financiamentos) { // Percorre Arraylist
            System.out.println(financiamento.getClass().getSimpleName()); // Usado para exibir o nome da classe para deixar mais legivel para o usuario qual o financiamento esta sendo exibido
            System.out.print(financiamento.mostrarFinanciamento()); // Chama a classe que mostra os dados do financiamento.

            valorTotalImoveis += financiamento.getValorImovel(); // Adiciona o valor do imovel ao valor total, somando os que vierem após o mesmo
            valorTotalFinanciamentos += financiamento.pagamentoTotal();// Soma o valor dos financiamentos, junto dos que vierem apos.
        }

        System.out.printf("\nO valor total de todos os imóveis é de R$ %.2f \n", valorTotalImoveis); // Exibição dos dados de valores totais.
        System.out.printf("\nO valor total de todos os financiamentos é de R$ %.2f \n", valorTotalFinanciamentos);


       // System.out.println("--------------------------");
      //  Arquivo.lerTodasAsLinhasTexto();
        //System.out.println("--------------------------");

        System.out.println("--------------------------");
        Arquivo.lerBinario("Binarios.txt");
        Arquivo.lerTodasAsLinhasTexto();
    }
}


