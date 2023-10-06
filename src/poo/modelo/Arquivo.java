package poo.modelo;

import poo.modelo.Financiamento;
import poo.modelo.Casa;
import poo.main.Main;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.*;
import java.util.ArrayList;

public class Arquivo {
    public static void escreverTexto(ArrayList<Financiamento> financiamentos, String arquivo) throws FileNotFoundException, IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivo))) {
            for (Financiamento financiamento : financiamentos) {
                writer.println("Valor Imóvel:" + financiamento.getValorImovel() + " | Prazo Financiamento: " +
                        financiamento.getPrazoFinanciamento() + " | Taxa Juros Anual: " + financiamento.getTaxaAnual() + "%" + " | Valor Total do Financiamento: " + financiamento.pagamentoTotal());
                if (financiamento instanceof Casa) {
                    writer.println("| Tamanho do Terreno: " + ((Casa) financiamento).getTamTerreno() + " | Area Construida: " + ((Casa) financiamento).getTamAreaConstruida() + "\n");
                } else if (financiamento instanceof Apartamento) {
                    writer.println("| Quantidade de garagens: " + ((Apartamento) financiamento).getNumGaragens() + "| Andar do Apartamento: " + ((Apartamento) financiamento).getNumeroAndar() + "\n");
                } else if (financiamento instanceof Terreno) {
                    writer.println("| Zona do Terreno: " + ((Terreno) financiamento).getTipoZona() + "\n");
                }
            }
        } catch (EOFException e) {
            System.out.println("Fim do Arquivo de Texto!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void serializarTexto(ArrayList<Financiamento> financiamentos, String arquivo) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(arquivo));
            for (Financiamento financiamento : financiamentos){
                outputStream.writeObject(financiamento);
            } outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lerTodasAsLinhasTexto() { // Le todas as linhas do txt/ Quando eu codei Eu e Deus sabiamos o pq de funcionar, agora nem Deus sabe!
        Path filepath = Paths.get("ArquivoFinanciamento.txt"); // Ele está aqui apenas para representar 4 horas de estresse!
        Charset charset = StandardCharsets.UTF_8; // Favor nao avaliar esta parte!

        try {
            Files.lines(filepath, charset).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lerBinario(String arquivo){
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(arquivo));
            Object obj = null;
            while ((obj = inputStream.readObject()) != null) {
                if (obj instanceof Financiamento) {
                    System.out.println(((Financiamento) obj).mostrarFinanciamento());
                }
            } inputStream.close();
        } catch (EOFException e){
            System.out.println("Acabou o Arquivo Serializado!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
