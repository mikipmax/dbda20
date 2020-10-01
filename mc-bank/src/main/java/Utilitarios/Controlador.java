/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author stal
 */
@Named(  "ControladorTA")
@SessionScoped
public class Controlador implements Serializable {

    /**
     * Creates a new instance of Controlador
     */
    private TablaAmortizacion tb;
    private List<TablaAmortizacion> tbAmortizacion;
    private Integer indiceTA;
    private Integer npagos;
    private double tasa;
    private double capital;

    public Controlador() {
    }

    //<editor-fold desc="ENCAPSULAMIENTO">
    public TablaAmortizacion getTb() {
        return tb;
    }

    public void setTb(TablaAmortizacion tb) {
        this.tb = tb;
    }

    public Integer getNpagos() {
        return npagos;
    }

    public void setNpagos(Integer npagos) {
        this.npagos = npagos;
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public Integer getIndiceTA() {
        return indiceTA;
    }

    public void setIndiceTA(Integer indiceTA) {
        this.indiceTA = indiceTA;
    }

    public List<TablaAmortizacion> getTbAmortizacion() {
        return tbAmortizacion;
    }

    public void setTbAmortizacion(List<TablaAmortizacion> tbAmortizacion) {
        this.tbAmortizacion = tbAmortizacion;
    }

    //</editor-fold>
    /**
     * MÃ©todo para cuotaFija la tabla de amortizaciÃ³n
     */
    //<editor-fold defaultstate="collapsed" desc="CUOTA FIJA Y DECRECIENTE">
    public void calcularCF() {
        Date fechaInicio = new Date();
        Date fechaAux;
        this.tbAmortizacion = new ArrayList();
        double totalInt = 0;
        double taT = tasa / 100;//Covertimos el valor a 0.xx
        ///AJUSTE DE TASA A 12 MESES
        double ta = taT / 12;

        /////CÃ�LCULO DE PAGO
        double p = capital * (ta / (1 - (Math.pow((1 + ta), (-npagos)))));
        //TOTAL DEL PAGO
        double totalPago = p * this.getNpagos();
        double cap = capital;
        //INTERÃ‰S, AMORTIZACIÃ“N, CAPITAL
        for (int i = 0; i < this.getNpagos(); i++) {
            TablaAmortizacion t = new TablaAmortizacion();

            t.setPeriodo(i + 1);//AÃ‘ADIMOS EL PERIODO A LA TABLA
            t.setPagoCuota(Math.round(p * 100) / 100d); //AÃ‘ADIMOS EL PAGO DE LA CUOTA A LA TABLA

            /////CALCULO DE INTERES
            double Interes = cap * ta;
            t.setInteres(Math.round(Interes * 100) / 100d);
            totalInt = totalInt + Interes;
            ///CALCULO DE AMORTIZACION
            double amortiza = p - Interes;
            t.setAmortizacion(Math.round(amortiza * 100) / 100d);
            ////CALCULO DE CAPITAL
            t.setCapital(Math.round(cap * 100) / 100d);
            ////CALCULO DE SALDO
            double saldo = cap - amortiza;
            t.setSaldo(Math.round(saldo * 100) / 100d);
            //CALCULO DE FECHAS
            fechaAux = variarFecha(fechaInicio, Calendar.DAY_OF_YEAR, 30);
            t.setFechas(formatofecha(fechaAux));
            this.tbAmortizacion.add(i, t);
            fechaInicio = fechaAux;
            cap = saldo;
        }
        System.out.println("CUOTA FIJA: " + "InterÃ©s=" + totalInt + " Pago=" + totalPago);
    }

    public void calcularCD() {
        Date fechaInicio = new Date();
        Date fechaAux;
        double totalInt = 0;
        double totalPago = 0;
        this.tbAmortizacion = new ArrayList();
        double taT = tasa / 100;//Covertimos el valor a 0.xx
        ///AJUSTE DE TASA A 12 MESES
        double ta = taT / 12;
        //CÃ�LCULO DE AMORTIZACIÃ“N
        double amortiza = capital / npagos;

        double cap = capital;

        //LLENADO DEL INTERÃ‰S, PAGO, CAPITAL
        for (int i = 0; i < this.getNpagos(); i++) {
            TablaAmortizacion t = new TablaAmortizacion();
            t.setPeriodo(i + 1);
            t.setAmortizacion(Math.round(amortiza * 100) / 100d);
            //CÃ�LCULO DEL INTERÃ‰S
            double interes = cap * ta;
            t.setInteres(Math.round(interes * 100) / 100d);
            totalInt = totalInt + interes;
            //CALCULO DEL PAGO
            double pago = amortiza + interes;
            t.setPagoCuota(Math.round(pago * 100) / 100d);
            totalPago = totalPago + pago;
            //CÃ�LCULO DEL CAPITAL
            t.setCapital(Math.round(cap * 100) / 100d);
            //CALCULO DEL SALDO
            double saldo = cap - amortiza;
            t.setSaldo(Math.round(saldo * 100) / 100d);
            //CALCULO DE FECHAS
            fechaAux = variarFecha(fechaInicio, Calendar.DAY_OF_YEAR, 30);
            t.setFechas(formatofecha(fechaAux));
            this.tbAmortizacion.add(i, t);
            fechaInicio = fechaAux;
            cap = saldo;
        }
        System.out.println("CUOTA DECRECIENTE: " + "InterÃ©s=" + totalInt + " Pago=" + totalPago);

    }
//</editor-fold>

    public void calcular() {
        try {
            if (this.indiceTA == 1) {
                calcularCF();

            } else if (this.indiceTA == 2) {
                calcularCD();

            }
            System.out.println("INDICE=" + indiceTA + ",TASA=" + tasa);
        } catch (Exception e) {
            capital = 0;
            npagos = 0;
            System.out.println("EN EL CATCH");
            System.out.println("INDICE=" + indiceTA + ",TASA=" + tasa);
        }

    }

    public String formatofecha(Date f) {
        DateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        return formato.format(f);
    }

    public static Date variarFecha(Date fecha, int campo, int valor) {
        if (valor == 0) {
            return fecha;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(campo, valor);
        return calendar.getTime();
    }
}
