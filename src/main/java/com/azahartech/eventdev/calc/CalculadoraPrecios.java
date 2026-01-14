package com.azahartech.eventdev.calc;

public class CalculadoraPrecios {
    // Metodo para calcular precio total
    // p: precio base, n: número entradas, t: tipo(1=estudiante, 2=vip)
    public double calc(double p, int n, int t) {
        double r = p * n;
        if (t == 1) {
// Descuento estudiante
            if (r > 100) {
                r = r - (r * 0.10);
            } else {
                r = r - (r * 0.05);
            }
        } else if (t == 2) {
// Recargo VIP por servicios extra
            r = r + 50;
        }
// Impuesto
        r = r + (r * 0.21);
        return r;
    }
}
