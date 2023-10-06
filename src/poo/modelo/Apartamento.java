package poo.modelo;

public class Apartamento extends Financiamento{ // Define a classe apartamento com sub da financiamento usando o extends para realizar a herança


    private int numGaragens;
    private int numeroAndar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaAnual, int numGaragens,int numeroAndar){
        super(valorImovel,prazoFinanciamento,taxaAnual); // Usado para chamar o construtor da superclasse / classe pai
        this.numGaragens = numGaragens;
        this.numeroAndar = numeroAndar;
    }
    @Override
    public double pagamentoTotal(){ // Segue o parametro passado na atividade para modificar o valor do pagamento mensal
        double valor = 0;
        for(int i =1; i <= getPrazoFinanciamento(); i++){
            valor += ((getTaxaAnual() / i) / 100) * pagamentoMensal();
        }
        return super.pagamentoTotal() + valor;
    }


    public int getNumGaragens() {
        return numGaragens;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }

}