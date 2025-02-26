package Airport;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * Description: Entry point for the Airport Simulation project
 */
public class Main {
    public static void main(String[] args) {
        // Create GUI Frame
        JFrame frame = new JFrame("Airport Simulation");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a log area
        JTextArea logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);

        // Create a start button
        JButton startButton = new JButton("Start Simulation");
        startButton.addActionListener(e -> {
            startButton.setEnabled(false); // Disable button after start
            Airport airport = new Airport(3, 2); // Example: 3 Gates, 2 Runways
            Simulation simulation = new Simulation(airport);
            new Thread(() -> simulation.run(logArea)).start(); // Run simulation in new thread
        });

        // Add components to frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(startButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
