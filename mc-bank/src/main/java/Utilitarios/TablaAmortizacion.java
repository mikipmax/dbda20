/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.io.Serializable;

/**
 *
 * @author stal
 */
public class TablaAmortizacion {

    private int periodo;
    private double capital;
    private double saldo;
    private double tazaInteres;
    private Integer nPagos;
    private double pagoCuota;
    private double interes;
    private double amortizacion;
    private String fechas;

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public double getTazaInteres() {
        return tazaInteres;
    }

    public void setTazaInteres(double tazaInteres) {
        this.tazaInteres = tazaInteres;
    }

    public Integer getnPagos() {
        return nPagos;
    }

    public void setnPagos(Integer nPagos) {
        this.nPagos = nPagos;
    }

    public double getPagoCuota() {
        return pagoCuota;
    }

    public void setPagoCuota(double pagoCuota) {
        this.pagoCuota = pagoCuota;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getAmortizacion() {
        return amortizacion;
    }

    public void setAmortizacion(double amortizacion) {
        this.amortizacion = amortizacion;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getFechas() {
        return fechas;
    }

    public void setFechas(String fechas) {
        this.fechas = fechas;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
