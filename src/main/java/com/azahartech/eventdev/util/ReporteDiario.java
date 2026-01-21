package com.azahartech.eventdev.util;

public class ReporteDiario {
    private int idReporte = 1;
    public void generar() {
        try {
            System.out.println("Generando reporte " + idReporte);
            if (idReporte == 1) {
                System.out.println("Primer reporte");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean chequear(int x) {
        return (x == 1);
    }
}
