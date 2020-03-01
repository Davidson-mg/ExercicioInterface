/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;


public class BrasilTaxaServico {
    
    public double taxa(double valor){
    
       /*até 100 o imposto é de 20% */
       /*Mais de 200 reias o imposto é de 15%*/
        
        double taxa;
        if(valor <= 100){
        
            taxa = (valor /100) * 20;
            return valor = valor + taxa;
        }
        
        else {
        
            taxa = (valor /100) * 15;
            return valor = valor + taxa;
            
        }
    }
    
}
