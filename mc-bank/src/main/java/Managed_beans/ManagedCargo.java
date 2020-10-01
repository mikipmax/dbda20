package Managed_beans;

import EJB_Entity.Cargo;
import EJB_Session.CargoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(  "ManagedCargo")
@SessionScoped
public class ManagedCargo implements Serializable {

    @Inject
    private CargoFacadeLocal manejadorCargo;
    private Cargo cargo;
    private List<Cargo> listaCargos;

    @PostConstruct
    public void init() {
        cargo = new Cargo();
        recuperarTCargo();
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Cargo> getListaCargos() {
        return listaCargos;
    }

    public void setListaCargos(List<Cargo> listaCargos) {
        this.listaCargos = listaCargos;
    }

    public void recuperarTCargo() {
        try {
            listaCargos = manejadorCargo.findAll();
        } catch (Exception e) {
        }

    }

    public void grabarCargo() {
        try {

            manejadorCargo.create(cargo);

        } catch (Exception e) {
        } finally {
            cargo = new Cargo();
            recuperarTCargo();
        }
    }

    public void editarCargos() {
        try {
            manejadorCargo.edit(cargo);

        } catch (Exception e) {
        } finally {
            cargo = new Cargo();
            recuperarTCargo();
        }

    }

    public void leerFilaCargo(Cargo cargoSeleccion) {

        cargo = cargoSeleccion;
    }

    public void salir() {

        cargo = new Cargo();
    }
}
