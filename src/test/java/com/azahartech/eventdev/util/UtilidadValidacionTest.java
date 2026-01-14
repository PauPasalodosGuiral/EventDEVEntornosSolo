package com.azahartech.eventdev.util;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UtilidadValidacionTest {

    @Test // Caso de exito
    void esEmailValido_DebeDevolverTrue_ParaUnEmailCorrecto() {
        String emailValido = "usuario@dominio.com";
        boolean resultado = UtilidadValidacion.esEmailValido(emailValido);
        assertTrue(resultado, "Un email válido fue marcado como inválido");
    }
    @Test //Sin @
    void esEmailValido_DebeDevolverFalse_ParaUnEmailSinArroba() {
        String emailInvalido = "usuariodominio.com";
        boolean resultado = UtilidadValidacion.esEmailValido(emailInvalido);
        assertFalse(resultado, "Un email sin '@' fue aceptado como válido");
    }
    @Test //Sin dominio '.'
    void esEmailValido_DebeDevolverFalse_ParaUnEmailSinDominio() {
        String emailInvalido = "usuario@dominiocom";
        boolean resultado = UtilidadValidacion.esEmailValido(emailInvalido);
        assertFalse(resultado, "Un email sin '.' fue aceptado como válido");
    }
    @Test //null o vacío
    void esEmailValido_DebeDevolverFalse_ParaUnInputNuloOVacio() {
        boolean resultadoNull = UtilidadValidacion.esEmailValido(null);
        boolean resultadoVacio = UtilidadValidacion.esEmailValido("");
        assertFalse(resultadoNull, "El valor null debería ser inválido");
        assertFalse(resultadoVacio, "Un String vacío debería ser inválido");
    }
}