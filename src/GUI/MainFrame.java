package GUI;

import javax.swing.*;
import java.awt.*;
import Logic.*;

public class MainFrame extends JFrame {

    private Fleet fleet;
    private OutputPanel outputPanel;
    private AddShipPanel addShipPanel;
    private FunctionSelectionPanel functionSelectionPanel;

    public MainFrame() {
        setTitle("Fleet Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(800, 600);
        fleet = new Fleet(); // Инициализируем флот

        // Создаем панели
        outputPanel = new OutputPanel();
        functionSelectionPanel = new FunctionSelectionPanel(fleet, outputPanel);
        addShipPanel = new AddShipPanel(fleet);

        // Добавляем панели в окно
        add(functionSelectionPanel, BorderLayout.EAST);
        add(outputPanel, BorderLayout.SOUTH);
        add(addShipPanel, BorderLayout.CENTER);

        // Отображение окна
        setVisible(true);
    }

    // Метод для запуска главного окна
    public void startMainFrame() {
        setVisible(true);
    }
}
