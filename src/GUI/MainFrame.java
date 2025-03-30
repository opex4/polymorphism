package GUI;

import javax.swing.*;
import java.awt.*;
import Logic.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        // Настраиваем главное окно
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(800, 600);
        Fleet fleet = new Fleet();

        // Создаем панели
        OutputPanel outputPanel = new OutputPanel();
        FunctionSelectionPanel functionSelectionPanel = new FunctionSelectionPanel(fleet, outputPanel);
        AddShipPanel addShipPanel = new AddShipPanel(fleet);

        // Добавляем панели в окно
        add(functionSelectionPanel, BorderLayout.EAST);
        add(outputPanel, BorderLayout.SOUTH);
        add(addShipPanel, BorderLayout.CENTER);
    }

    public void startMainFrame(){
        setVisible(true);
    }
}
