package Managed_beans;

import EJB_Entity.Empleado;
import EJB_Entity.EstadoCredito;
import EJB_Entity.ProcesoAsignacion;
import EJB_Entity.TipoCredito;
import EJB_Session.EmpleadoFacadeLocal;
import EJB_Session.EstadoCreditoFacade;
import EJB_Session.EstadoCreditoFacadeLocal;
import EJB_Session.ProcesoAsignacionFacadeLocal;
import Utilitarios.Controlador;
import static Utilitarios.Controlador.variarFecha;
import Utilitarios.TablaAmortizacion;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(  "ManagedPrAsignacion")
@SessionScoped
public class ManagedPrAsignacion implements Serializable {

    @Inject
    private ProcesoAsignacionFacadeLocal manejadorPrAsign;
    @Inject
    private EmpleadoFacadeLocal manejadorEmpleados;
    @Inject
    private EstadoCreditoFacadeLocal manejadorEstados;
    private ProcesoAsignacion procesoAsignacion;
    List<ProcesoAsignacion> listaPrAsign;
    List<ProcesoAsignacion> listaPrAsignAux;
    List<ProcesoAsignacion> listaPrAsignAuxEmp;
    List<Empleado> listaEmpleados;
    List<EstadoCredito> listaEstados;
    //Para la Tabla de AmotizaciÃ³n
    private TablaAmortizacion tb;
    private TipoCredito tc;
    private List<TablaAmortizacion> tbAmortizacion;
    private Integer indiceTA;
    private Integer npagos;
    private double tasa;
    private double capital;

    @PostConstruct
    public void init() {
        procesoAsignacion = new ProcesoAsignacion();
        recuperarPrAsign();
        llenarAux();
        llenarEstadosAux();
    }

    public List<ProcesoAsignacion> getListaPrAsignAuxEmp() {
        return listaPrAsignAuxEmp;
    }

    public void setListaPrAsignAuxEmp(List<ProcesoAsignacion> listaPrAsignAuxEmp) {
        this.listaPrAsignAuxEmp = listaPrAsignAuxEmp;
    }

    public ProcesoAsignacion getProcesoAsignacion() {
        return procesoAsignacion;
    }

    public void setProcesoAsignacion(ProcesoAsignacion procesoAsignacion) {
        this.procesoAsignacion = procesoAsignacion;
    }

    public List<ProcesoAsignacion> getListaPrAsign() {
        return listaPrAsign;
    }

    public void setListaPrAsign(List<ProcesoAsignacion> listaPrAsign) {
        this.listaPrAsign = listaPrAsign;
    }

    public List<ProcesoAsignacion> getListaPrAsignAux() {
        return listaPrAsignAux;
    }

    public void setListaPrAsignAux(List<ProcesoAsignacion> listaPrAsignAux) {
        this.listaPrAsignAux = listaPrAsignAux;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<EstadoCredito> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(List<EstadoCredito> listaEstados) {
        this.listaEstados = listaEstados;
    }

    public void grabarPrAign() {
        try {


            //  recuperarPrAsign();
            llenarAux();
            llenarEstadosAux();
        } catch (Exception e) {
        }
    }

    public void recuperarPrAsign() {
        try {

            listaPrAsign = manejadorPrAsign.findAll();

        } catch (Exception e) {
        }

    }

    public void recuperarEmp() {
        try {
            listaEmpleados = manejadorEmpleados.findAll();
        } catch (Exception e) {
        }
    }

    public void recuperarEstados() {
        try {
            listaEstados = manejadorEstados.findAll();
        } catch (Exception e) {
        }
    }

    public void editarPr() {
        try {

            this.procesoAsignacion.setIdEstado(procesoAsignacion.getIdEstado());


            this.procesoAsignacion.setDniEmpleado(manejadorEmpleados.find(procesoAsignacion.getDniEmpleado().getIdCredenciales().getDni().getDni()));
            manejadorPrAsign.edit(procesoAsignacion);

            recuperarPrAsign();
            llenarAux();
            llenarEstadosAux();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public void llerFilaPr(ProcesoAsignacion procesoSeleccion) {
        llenarAux();
        llenarEstadosAux();
    
        procesoAsignacion = procesoSeleccion;
        capital = procesoAsignacion.getIdProcesoCredito().getMonto();
        npagos = procesoAsignacion.getIdProcesoCredito().getPlazo();
        indiceTA = procesoAsignacion.getIdProcesoCredito().getIdTipoAmortizacion().getIdTipoAmortizacion();
        tasa = procesoAsignacion.getIdProcesoCredito().getIdTipoCredito().getInteresBase();
        calcular();

    }

    public void llenarAux() {
        try {

            listaPrAsignAuxEmp = new ArrayList<>();
            recuperarEmp();

            for (int i = 0; i < listaEmpleados.size(); i++) {


                procesoAsignacion = new ProcesoAsignacion();
                procesoAsignacion.setDniEmpleado(listaEmpleados.get(i));
                if (listaEmpleados.get(i).getIdCargo().getIdCargo() == 1) {
                    listaPrAsignAuxEmp.add(procesoAsignacion);
                }


            }
            for (int j = 0; j < listaPrAsignAux.size(); j++) {
                System.out.println(listaPrAsignAux.get(j).getDniEmpleado());
            }


        } catch (Exception e) {
        }


    }

    public void llenarEstadosAux() {
        try {
            listaPrAsignAux = new ArrayList<>();
            recuperarEstados();

            for (int i = 0; i < listaEstados.size(); i++) {

                procesoAsignacion = new ProcesoAsignacion();
                procesoAsignacion.setIdEstado(listaEstados.get(i));
                listaPrAsignAux.add(procesoAsignacion);
            }
        } catch (Exception e) {
        }
    }

    //<editor-fold desc="ENCAPSULAMIENTO">
    public TipoCredito getTc() {
        return tc;
    }

    public void setTc(TipoCredito tc) {
        this.tc = tc;
    }

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
