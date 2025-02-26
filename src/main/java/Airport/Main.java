package Airport;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * Description: Entry point for the Airport Simulation project
 */
public class Main {
    public static void main(String[] args) {
        // Create GUI Frame
        JFrame frame = new JFrame("Airport Simulation");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create a log area with styling
        JTextArea logArea = new JTextArea();
        logArea.setEditable(false);
        logArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        logArea.setBackground(new Color(240, 248, 255)); // Light blue background
        JScrollPane scrollPane = new JScrollPane(logArea);
        
        // Create a control panel
        JPanel controlPanel = new JPanel();
        JButton startButton = new JButton("Start Simulation");
        startButton.setFont(new Font("Arial", Font.BOLD, 16));
        startButton.setBackground(new Color(50, 205, 50)); // Green button
        startButton.setForeground(Color.WHITE);
        startButton.setFocusPainted(false);
        
        // Action listener for starting simulation
        startButton.addActionListener(e -> {
            startButton.setEnabled(false); // Disable button after start
            Airport airport = new Airport(3, 2); // Example: 3 Gates, 2 Runways
            Simulation simulation = new Simulation(airport);
            new Thread(() -> simulation.run(logArea)).start(); // Run simulation in new thread
        });

        // Add components to control panel
        controlPanel.add(startButton);
        controlPanel.setBackground(new Color(70, 130, 180)); // Steel blue background

        // Add components to frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
