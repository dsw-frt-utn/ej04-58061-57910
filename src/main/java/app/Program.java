package app;

import data.Persistencia;
import java.util.InvalidPropertiesFormatException;
import views.AgregarVehiculoView;
import views.ListarVehiculosView;

public class Program {
    public static void main(String[] args) throws IllegalArgumentException, InvalidPropertiesFormatException {
        Persistencia.inicializar();
        AgregarVehiculoView view = new AgregarVehiculoView();
        view.setVisible(true);
        ListarVehiculosView v = new ListarVehiculosView();
        v.setVisible(true);
    }
}
