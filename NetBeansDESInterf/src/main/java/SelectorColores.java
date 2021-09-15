

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Programa que ofrece tres deslizadores JSlider con valores
 * entre 0 y 255.
 * Cada valor sirve para establecer uno de los tres canales de colores RGB
 * con los cuales modificaremos el color de un panel.
 *
 * @author Kabuto
 */
public class SelectorColores extends JFrame {

    private PanelSelectores panelSelectores;
    private PanelColor panelColor;

    public SelectorColores() {

        panelSelectores = new PanelSelectores();
        panelColor = new PanelColor();

        setLayout(new BorderLayout());
        JPanel pnNorte = new JPanel();
        pnNorte.add(new JLabel("Use los deslizadores para seleccionar color RGB"));

        JPanel pnCentro = new JPanel();
        pnCentro.add(panelColor);
        pnCentro.add(panelSelectores);

        add(pnNorte, BorderLayout.NORTH);
        add(pnCentro, BorderLayout.CENTER);


        setTitle("Selector RGB");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Este es el panel que cambiará de color.
     * Incluye un método para recibir el Color
     * que ha de establecerse.
     */
    private class PanelColor extends JPanel {

        public PanelColor() {
            setOpaque(true);
            setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK),
                    BorderFactory.createEmptyBorder(150, 150, 150, 150)));
            setColor(panelSelectores.getColor());
        }

        public void setColor(Color color) {
            setBackground(color);
        }
    }

    /**
     * Este será el panel que contiene los tres
     * objetos Selector(JSlider).
     * Incluye un método para retornar el Color
     * configurado según los valores seleccionados
     * en los JSlider
     */
    private class PanelSelectores extends JPanel {

        private Selector canalRojo;
        private Selector canalVerde;
        private Selector canalAzul;

        public PanelSelectores() {

            canalRojo = new Selector(0, 255);
            canalVerde = new Selector(0, 255);
            canalAzul = new Selector(0, 255);

            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            PanelSelector pnRojo = new PanelSelector("Canal Rojo", canalRojo);
            PanelSelector pnVerde = new PanelSelector("Canal Verde", canalVerde);
            PanelSelector pnAzul = new PanelSelector("Canal Azul", canalAzul);
            add(pnRojo);
            add(pnVerde);
            add(pnAzul);

        }

        public Color getColor() {
            int r = canalRojo.getValue();
            int v = canalVerde.getValue();
            int a = canalAzul.getValue();

            return new Color(r, v, a);
        }
    }

    /**
     * Clase para personalizar un JSlider.
     * Necesitamos 3 JSlider con cierta configuración.
     * Para no repetir 3 veces este código, creamos esta clase
     * y así escribimos 1 sola vez.
     */
    private class Selector extends JSlider {

        public Selector(int min, int max) {
            super(min, max);
            setPaintTicks(true);
            setPaintTrack(true);
            setPaintLabels(true);
            setMajorTickSpacing(255);
            setMinorTickSpacing(5);
            addChangeListener(new CambioSelector());
        }

    }

    /**
     * Clase sencilla que hereda de JPanel.
     * Recibe por constructor un texto para el borde titulado y +
     * un objeto Selector(un JSlider) para colocarlo en el panel.
     * Puesto que vamos a tener tres Selector con el mismo aspecto,
     * creando esta clase solo hay que escribir este código 1 sola vez
     * y lo podemos usar para los 3 Selector.
     * De lo contrario, habría que escribir esto tres veces.
     */
    private class PanelSelector extends JPanel {

        public PanelSelector(String titulo, Selector selector) {
            add(selector);
            setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(titulo),
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        }
    }

    /**
     * Listener que detecta cuando el deslizador asociado
     * cambia su valor actual.
     * Cuando se detecta cualquier cambio, lo que se hace
     * es actualizar el color del panel con los nuevos valores
     */
    private class CambioSelector implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            panelColor.setColor(panelSelectores.getColor());
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SelectorColores();
            }
        });
    }

}
