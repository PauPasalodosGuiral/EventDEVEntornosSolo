package com.azahartech.eventdev.calc;

public class CalculadoraPrecios {

    public final int TIPO_VIP = 2;
    public final int TIPO_ESTUDIANTE = 1;
    public final int RECARGO_VIP = 50;
    public final double DESCUENTO_ESTUDIANTE_ALTO = 0.10;
    public final double DESCUENTO_ESTUDIANTE_BAJO = 0.05;
    public final double IVA = 0.21;

    // Metodo para calcular precio total
    // p: precio base, n: número entradas, t: tipo(1=estudiante, 2=vip)
    public double calculadoraPrecioTotal(double precio, int numEntradas, int tipo) {
        double precioBase = precio * numEntradas;
        double precioFinal = aplicarDescuentosORecargos(tipo, precioBase);
        return precioFinal;
    }

    private double aplicarDescuentosORecargos(int tipo, double precioBase) {
        double precioFinal;

        if (tipo == TIPO_ESTUDIANTE) {
            // Descuento estudiante
            if (precioBase > 100) {
                precioFinal = precioBase - (precioBase * DESCUENTO_ESTUDIANTE_ALTO);
            } else {
                precioFinal = precioBase - (precioBase * DESCUENTO_ESTUDIANTE_BAJO);
            }
        } else if (tipo == TIPO_VIP) {
            // Recargo VIP por servicios extra
            precioFinal = precioBase + RECARGO_VIP;
        } else {
            precioFinal = precioBase;
        }

        // Impuesto (aplicado sobre el precio ya calculado)
        precioFinal = precioFinal + (precioFinal * IVA);
        return precioFinal;
    }
}
