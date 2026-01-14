package com.azahartech.eventdev.util;

import java.time.LocalDate;

public class UtilidadValidacion {

        public static boolean esEmailValido(String email) {
            if (email == null || email.isEmpty()) {
                return false;
            }
            int indiceArroba = email.indexOf('@');
            int indicePunto = email.lastIndexOf('.');
            return indiceArroba > 0 && indicePunto > indiceArroba;
        }
    public static boolean esPuntiacionValida(int puntuacion) {
        return (puntuacion >=1) && (puntuacion <=5);
    }
    public static boolean esFechaFutura(LocalDate fecha) {
        LocalDate fechaActual = LocalDate.now();
        return fechaActual.isBefore(fecha);
    }
}
