import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel messageLabel;

    public LoginFrame() {
        setTitle("User Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel utama untuk form login
        JPanel mainPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Label dan field untuk username
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();

        // Label dan field untuk password
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        // Tombol login
        loginButton = new JButton("Login");

        // Tambahkan komponen ke panel
        mainPanel.add(usernameLabel);
        mainPanel.add(usernameField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);

        // Panel untuk tombol dan pesan
        JPanel actionPanel = new JPanel(new BorderLayout());
        messageLabel = new JLabel("", SwingConstants.CENTER);
        actionPanel.add(loginButton, BorderLayout.SOUTH);
        actionPanel.add(messageLabel, BorderLayout.CENTER);

        // Tambahkan panel utama dan action panel ke frame
        add(mainPanel, BorderLayout.CENTER);
        add(actionPanel, BorderLayout.SOUTH);

        // Tambahkan event listener ke tombol login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });
    }

    private void performLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Verifikasi login (sederhana untuk demo)
        if ("admin".equals(username) && "1234".equals(password)) {
            messageLabel.setText("Login successful!");
            messageLabel.setForeground(Color.GREEN);
        } else {
            messageLabel.setText("Invalid username or password.");
            messageLabel.setForeground(Color.RED);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
        });
    }
}
