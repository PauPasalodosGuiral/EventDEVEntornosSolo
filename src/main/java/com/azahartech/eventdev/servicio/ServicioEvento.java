package com.azahartech.eventdev.servicio;

import com.azahartech.eventdev.modelo.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ServicioEvento {
    private Evento eventoDePrueba;
    private Usuario usuarioDePrueba;
    private Evento[] carteleraDestacados;
    //EVENTOS
    private Evento evento1;
    private Evento evento2;
    private Evento evento3;

    public ServicioEvento() {
        //RECINTOS
        Recinto recinto1 = new Recinto("Estadio Castalia", "Castellón", 1000);
        Recinto recinto2 = new Recinto("Bar Manolo", "Castellon", 100);
        Recinto recinto3 = new Recinto("Bodas M&V","Benicasim",150);

        //EVENTOS
        evento1 = new Evento("caca",LocalDate.now(), recinto1,10);
        evento2 = new Evento("tata",LocalDate.now(), recinto2,15);
        evento3 = new Evento("laca",LocalDate.now(), recinto3,20);

        Recinto recintoDePrueba = new Recinto("mercandona", "Calle Mayor", 100);
        DetallePago detallePagoDePrueba = new DetallePago("credito","1122334455667788");
        this.eventoDePrueba = new Evento("Comprar", LocalDate.of(2025, 12, 01), recintoDePrueba, 10);
        this.usuarioDePrueba = new Usuario("pau","pau@gmail.com", detallePagoDePrueba);
        carteleraDestacados = new Evento[5];
    }
    public Evento getEvento1() {
        return evento1;
    }
    public Evento getEvento2() {
        return evento2;
    }
    public Evento getEvento3() {
        return evento3;
    }

    public boolean añadirdestacado(Evento evento, int posicion) {
        posicion = posicion -1;

            if (posicion >= 0 && posicion <= 4) {
                carteleraDestacados[posicion]= evento;
                return true;
            }
            return false;
    }

    public void mostrarCartelera() {
        for (int i = 0; i < carteleraDestacados.length; i++) {
            if (carteleraDestacados[i] == null) {
                System.out.println("Espacio disponible");
            } else {
                carteleraDestacados[i].mostrarInformacion();
            }
        }
    }

    public Evento buscarDestacadoMasCaro() {
        if (carteleraDestacados == null) {
            return null;
        }
        Evento eventoMasCaro = null;
        for (int i = 0; i < carteleraDestacados.length; i++) {
            Evento evento = carteleraDestacados[i];
            if (evento != null ) {
                if (eventoMasCaro == null || evento.getPrecioEntrada() > eventoMasCaro.getPrecioEntrada()) {
                    eventoMasCaro = evento;
                }
            }
        }
        return eventoMasCaro;
    }

    public Tique realizarCompra(int cantidad) {
        double costeTotal = eventoDePrueba.getPrecioEntrada() * cantidad;
        Tique tique = new Tique(eventoDePrueba,usuarioDePrueba);
        System.out.println("El coste total es: " + costeTotal);
        //Realizar pago del usuario
        this.usuarioDePrueba.getDetallePago().realizarPago(costeTotal, this.usuarioDePrueba.getDetallePago().getTipoTarjeta());
        //Evento registra una venta
        this.eventoDePrueba.registrarVenta(cantidad);
        return tique;
    }
}
