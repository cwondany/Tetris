package tetris;

/**
 *
 * @author cw
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class View implements Runnable {

    private final int RowsOfGrid = 3;
    private final int ColOfGrid = 1;

    private JPanel panelSinglePlayer;
    private JPanel panelMultiPlayer;
    private JFrame frame;

    private DrawingBoard board;
    JButton startBtn;
    JButton button2;

    private Box box;
    Thread helloRunnable;
    ScheduledExecutorService executor;

    public View() {

        frame = new JFrame("Tetris");

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JPanel menuPanel = new JPanel();
        GridLayout grid = new GridLayout(RowsOfGrid, ColOfGrid);
        menuPanel.setLayout(grid);

        JLabel label = new JLabel("Menu", SwingConstants.CENTER);
        startBtn = new JButton();
        button2 = new JButton();

        panelSinglePlayer = new JPanel();
        panelMultiPlayer = new JPanel();
//        panelSinglePlayer.setBackground(Color.BLUE);
        panelMultiPlayer.setBackground(Color.RED);

        Border border = BorderFactory.createLineBorder(Color.lightGray, 8);
        startBtn.setBorder(border);
        button2.setBorder(border);
        startBtn.setText("1 Player");
        startBtn.setPreferredSize(new Dimension(200, 50));
        button2.setText("2 Player");
//        startBtn.addActionListener(new PanelListener(panelSinglePlayer));
//        button2.addActionListener(new PanelListener(panelMultiPlayer));

        menuPanel.add(label);
        menuPanel.add(startBtn);
        menuPanel.add(button2);
        panel.add(menuPanel);

        frame.add(panel);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void run() {

    }

    private void createComponents(Container container) {
        box = new Box(0, 0, 40, 40);
        board = new DrawingBoard(box);
        container.add(board);

    }

    public void startGame() {

        frame.getContentPane().removeAll();
        createComponents(frame.getContentPane());
        frame.validate();
        frame.repaint();

        startBoxFalling();         

    }

    public void startBoxFalling() {
        helloRunnable = new Thread() {
            public void run() {

                if (box.getY()+box.getHeight() + 40 < 500) {
                    System.out.println("I believe I can fall");

                    frame.validate();
                    frame.repaint();
                    box.move(0, 20);
                } else {
                    System.out.println("Thread beendet.");
                    executor.shutdown();
                }

            }
        };

        executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0, 500, TimeUnit.MILLISECONDS);
    }

    /**
     * Adds to all existing button an ActionController (called in main class)
     *
     * @param controller Controller
     */
    public void addController(ActionListener controller) {
        startBtn.addActionListener(controller);
    }

    public JFrame getFrame() {
        return frame;
    }

    public Box getBox() {
        return box;
    }

    public JButton getButton() {
        return startBtn;
    }
    //    public class PanelListener implements ActionListener {
//
//        private JPanel panel;
//
//        private PanelListener(JPanel pnl) {
//            this.panel = pnl;
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            changePanel(panel);
//        }
//    }
//    private void changePanel(JPanel panel) {
//
//        frame.getContentPane().removeAll();
//        frame.getContentPane().add(panel, BorderLayout.CENTER);
//        frame.getContentPane().doLayout();
//        createComponents(frame.getContentPane());
//        frame.validate();
//        frame.repaint();
//    }   

}
