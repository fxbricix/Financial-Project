package poo.modelo;


import poo.util.InterfaceUsuario;

import java.util.InputMismatchException;

public class Casa extends Financiamento { // Define sub classe Casa usando o extends para fazer a herança da classe pai

    private double tamAreaConstruida;
    private double tamTerreno;
    private double descontoPagamento;
    private double descs;

    public double getTamAreaConstruida() {
        return tamAreaConstruida;
    }

    public double getTamTerreno() {
        return tamTerreno;
    }

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double descontoPagamento, double tamTerreno, double tamAreaConstruida) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual); // Super chama o construtor da super classe
        this.tamTerreno = tamTerreno;
        this.tamAreaConstruida = tamAreaConstruida;
        this.descontoPagamento = checarDesconto(descontoPagamento);
    }



    private double checarDesconto(Double descontoPagamento) {
        while (true) {
            try {
                if (descontoPagamento > (getValorImovel() / getPrazoFinanciamento()) * (getTaxaAnual() / 12)) {
                    throw new DescontoMaiorQueJurosException("Valor maior que a taxa mensal!");
                } else if (descontoPagamento <= 0 || descontoPagamento > 100) {
                    throw new DescontoMaiorQueJurosException("O valor tem que ser MAIOR que 0 e MENOR que 100!");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Ops! Parece que temos um valor invalido!");
                descontoPagamento = InterfaceUsuario.receberDesconto();
            } catch (DescontoMaiorQueJurosException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                descontoPagamento = InterfaceUsuario.receberDesconto();
            }
        } return descontoPagamento;
    }



    @Override
    public double pagamentoTotal() { // Realiza o parametro de desconto de acordo com o pagamento mensal
        descs = super.pagamentoTotal() - (descontoPagamento * getPrazoFinanciamento());
        return descs;
    }
}
