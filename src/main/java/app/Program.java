package app;

import data.Persistencia;
import java.util.InvalidPropertiesFormatException;
import views.MenuPrincipal;

public class Program {
    public static void main(String[] args) throws IllegalArgumentException, InvalidPropertiesFormatException {
        Persistencia.inicializar();
        MenuPrincipal view = new MenuPrincipal();
        view.setVisible(true);
    }
}
