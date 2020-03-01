/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.util.Date;

/**
 *
 * @author David
 */
public class AluguelCarro {
    
    private Date retirada;
    private Date entrega;
   
    private Fatura fatura;
    private Veiculo veiculo;

    public AluguelCarro(Date retirada, Date entrega, Fatura fatura, Veiculo veiculo) {
        this.retirada = retirada;
        this.entrega = entrega;   
        this.veiculo = veiculo;
    }
    
    public AluguelCarro (Date entrega, Date retirada, Veiculo veiculo){
    
        this.retirada = retirada;
        this.entrega = entrega;   
        this.veiculo = veiculo;
    
    }

    public Date getRetirada() {
        return retirada;
    }

    public void setRetirada(Date retirada) {
        this.retirada = retirada;
    }

    public Date getEntrega() {
        return entrega;
    }

    public void setEntrega(Date entrega) {
        this.entrega = entrega;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    
    
    
}
