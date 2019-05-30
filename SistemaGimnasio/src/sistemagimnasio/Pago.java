/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemagimnasio;

import java.time.LocalDate;

/**
 *
 * @author Maria Saarayim Gonzalez Hernandez
 * @author Mauricio Cruz Portilla
 */
public class Pago {

    private int id;
    private int monto;
    private LocalDate fecha;
    private int idCliente;
    private int idMembresia;
    private LocalDate fechaVencimiento;

    public Pago() {
    }

    public Pago(
        int id, int idCliente, int idMembresia, int monto, LocalDate fecha, 
        LocalDate fechaVencimiento
    ) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idMembresia = idMembresia;
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getId() {
        return id;
    }

    public int getMonto() {
        return monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdMembresia() {
        return idMembresia;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdMembresia(int idMembresia) {
        this.idMembresia = idMembresia;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

}
