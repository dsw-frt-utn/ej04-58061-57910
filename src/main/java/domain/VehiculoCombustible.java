package domain;

public class VehiculoCombustible extends Vehiculo {
    private double kilometrosPorLitro;
    private double litrosExtra;

    public VehiculoCombustible(String patente, Marca marca, String modelo, int anio, double capacidadCarga,
                               Sucursal sucursal, double kilometrosPorLitro, double litrosExtra) {
        super(VehiculoTipo.COMBUSTIBLE, patente, marca, modelo, anio, capacidadCarga, sucursal);
        this.kilometrosPorLitro = kilometrosPorLitro;
        this.litrosExtra = litrosExtra;
    }
    
     public double getKilometrosPorLitro() {
        return kilometrosPorLitro;
    }

    public double getLitrosExtra() {
        return litrosExtra;
    }
    
    @Override
public double calcularConsumo(double kilometros) {
    double consumoBase = kilometros / kilometrosPorLitro;
    double extra = 0;

    if ((2026 - anio) > 5) {
        extra = (kilometros / 15.0) * litrosExtra; }
        return consumoBase + extra;
    }
}