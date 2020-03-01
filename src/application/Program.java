/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.AluguelCarro;
import model.entities.Veiculo;
import model.services.AluguelServico;
import model.services.BrasilTaxaServico;

/**
 *
 * @author David
 */
public class Program {

    
    public static void main(String[] args) throws ParseException {
        
        Scanner leia = new Scanner (System.in);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
        
        System.out.println("Inserir dados do aluguel");
        
        System.out.print("Modelo do carro: ");
        String modeloCarro = leia.nextLine();
        
        System.out.print("Data de saida (dd/mm/yyyy hh:ss): ");
        Date dataSaida = sdf.parse(leia.nextLine());
        
        System.out.print("Data de retorno (dd/mm/yyyy hh:ss): ");
        Date dataRetorno = sdf.parse(leia.nextLine());
        
        
        AluguelCarro ac = new AluguelCarro (dataSaida, dataRetorno, new Veiculo(modeloCarro));
        
        
        System.out.print("Informe o preço por hora: ");
        double precoHora = leia.nextDouble();
        
        System.out.print("Informe o preço por dia: ");
        double precoDia = leia.nextDouble();
        
        AluguelServico aluguelServico = new AluguelServico (precoHora, precoDia, new BrasilTaxaServico());
       
        aluguelServico.processamentoFatura(ac);
        
        System.out.println("Pagamento basico: "+String.format("%.2f", ac.getFatura().getPagamentoBasico()));
        System.out.println("Taxa: "+String.format("%.2f", ac.getFatura().getTaxa()));
        System.out.println("Pagamento total: "+String.format("%.2f", ac.getFatura().getPagamentoTotal()));
        
        
    }
    
}
