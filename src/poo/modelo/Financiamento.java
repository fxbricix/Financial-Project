package poo.modelo;

import java.io.Serializable;

public abstract class Financiamento implements Serializable {

    // Definição das variaveis como private para limitar o acesso
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaAnual;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaAnual){ // Construtor
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaAnual = taxaAnual;
    }



    // Metodos getters para podermos utilizar as variaveis com segurança


    public Double getValorImovel(){
        return valorImovel;
    }

    public int getPrazoFinanciamento(){
        return prazoFinanciamento;
    }

    public Double getTaxaAnual(){
        return taxaAnual;
    }

    public String mostrarFinanciamento(){ // Mostrar na Tela os Dados do Financiamento.
        //Achei melhor fazer nesta classe Financiamento para não ter que ficar puxando em outra classe como na Interface Usuario
        ;
        System.out.println("");
        System.out.println("O valor do imovel é de R$ " + getValorImovel());
        System.out.println("O prazo estipulado do financiamento é de " + getPrazoFinanciamento() + " anos.");
        System.out.println("Voce está sujeito a uma taxa anual de " + getTaxaAnual() +"%" );
        System.out.println("");
        System.out.printf("Isto resulta no valor total de R$ %.2f \n", pagamentoTotal()); // o %.2f serve para definir apenas duas casas decimais após a virgula
        System.out.printf("Isto resulta no valor mensal de R$%.2f \n", pagamentoMensal()); // utilizado o printf para faze-lo, não se usa + para concatenar.
        String end = ("");
        return end; // O Famoso gato net para o codigo funcionar, uso o end para retornar uma linha vazia.
    }


    public double pagamentoMensal(){ // Calcula pagamento mensal
        double pm;
        pm = (getValorImovel() / getPrazoFinanciamento()) * (getTaxaAnual() / 12);
        return pm;
    }
    public double pagamentoTotal(){ // Calculo do pagamento total

        return pagamentoMensal() * prazoFinanciamento;
    }

}
