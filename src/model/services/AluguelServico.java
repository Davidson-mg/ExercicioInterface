/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

import model.entities.AluguelCarro;
import model.entities.Fatura;

/**
 *
 * @author David
 */
public class AluguelServico {
    
    private Double precoPorHora;
    private Double precoPorDia;
    
    private BrasilTaxaServico brasilTaxaServico;

    public AluguelServico(Double precoPorHora, Double precoPorDia, BrasilTaxaServico brasilTaxaServico) {
        this.precoPorHora = precoPorHora;
        this.precoPorDia = precoPorDia;
        this.brasilTaxaServico = brasilTaxaServico;
    }

    
    public void processamentoFatura(AluguelCarro aluguelCarro){
    
        long t1 = aluguelCarro.getRetirada().getTime();
        long t2 = aluguelCarro.getEntrega().getTime();
        
        double horas = (double)(t1 - t2) /1000 /60 / 60; /*o double entre parenteses serve apenas para garantir que o resultado será em double*/
        /*(t1 - t2) vai dar o resultado em milesegundos. pra converter milesegundos pra segundos, eu divido por 1000.
        pra converter de segundos pra minutos, eu divido 60. Pra converter de minutos pra horas, eu divido por 60 denovo*/
        
        double pagamentoBasico;
        
        if(horas <=12.0){
        
            pagamentoBasico = Math.ceil(horas) * precoPorHora; /*Math.cei é uma função para arredondar para cima*/
        
        }
        
        else{
        
            pagamentoBasico = Math.ceil(horas / 24) * precoPorDia;
        
        }
        
        double taxa = brasilTaxaServico.taxa(pagamentoBasico);
        
        aluguelCarro.setFatura(new Fatura (pagamentoBasico, taxa));
    }
    
}
