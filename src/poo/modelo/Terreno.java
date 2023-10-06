package poo.modelo;

public class Terreno extends Financiamento { // Define classe terreno usando o extends para fazer a herança da classe pai

    private String tipoZona;
    public String getTipoZona() {
        return tipoZona;
    }


    public Terreno(double valorImovel, int prazoFinanciamento, double taxaAnual, String tipoZona ) {
        super(valorImovel, prazoFinanciamento, taxaAnual);
        this.tipoZona = tipoZona;
    }



    @Override
    public double pagamentoTotal(){

        return super.pagamentoTotal() * 1.02;
    }
}
