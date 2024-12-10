import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener {

    String[] questions = {
            "Jika 5 + 3 x 2 = ?, maka hasilnya adalah?",
            "Berapakah nilai dari (10 - 2) ÷ 2?",
            "Jika X = 3 dan Y = 4, maka berapakah nilai X^2 + Y^2?",
            "Sebuah bilangan dikalikan 2, kemudian dikurangi 6, hasilnya adalah 10. Berapakah bilangan tersebut?"
    };
    String[][] options = {
            {"16", "11", "10", "12"},
            {"4", "8", "6", "5"},
            {"25", "18", "16", "20"},
            {"5", "7", "8", "10"}
    };
    char[] answers = {'B', 'A', 'A', 'C'};
    char answer;
    int index;
    int correct_guesses = 0;
    int total_questions = questions.length;
    int seconds = 10;

    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();
    JTextArea textarea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();
    JLabel time_label = new JLabel("Time Left");
    JLabel seconds_left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();
    Timer timer;

    public Quiz() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.getContentPane().setBackground(new Color(240, 240, 240));
        frame.setLayout(null);
        frame.setResizable(false);

        textfield.setBounds(0, 0, 700, 50);
        textfield.setBackground(new Color(50, 50, 50));
        textfield.setForeground(Color.WHITE);
        textfield.setFont(new Font("Arial", Font.BOLD, 30));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);

        textarea.setBounds(50, 60, 600, 60);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(240, 240, 240));
        textarea.setForeground(Color.BLACK);
        textarea.setFont(new Font("Arial", Font.PLAIN, 20));
        textarea.setEditable(false);

        buttonA.setBounds(50, 150, 250, 50);
        buttonB.setBounds(50, 220, 250, 50);
        buttonC.setBounds(50, 290, 250, 50);
        buttonD.setBounds(50, 360, 250, 50);
        configureButton(buttonA, "A");
        configureButton(buttonB, "B");
        configureButton(buttonC, "C");
        configureButton(buttonD, "D");

        answer_labelA.setBounds(320, 150, 300, 50);
        answer_labelB.setBounds(320, 220, 300, 50);
        answer_labelC.setBounds(320, 290, 300, 50);
        answer_labelD.setBounds(320, 360, 300, 50);
        configureAnswerLabel(answer_labelA);
        configureAnswerLabel(answer_labelB);
        configureAnswerLabel(answer_labelC);
        configureAnswerLabel(answer_labelD);

        time_label.setBounds(580, 20, 100, 25);
        time_label.setFont(new Font("Arial", Font.BOLD, 16));

        seconds_left.setBounds(580, 50, 100, 50);
        seconds_left.setBackground(new Color(50, 50, 50));
        seconds_left.setForeground(Color.RED);
        seconds_left.setFont(new Font("Arial", Font.BOLD, 40));
        seconds_left.setHorizontalAlignment(JTextField.CENTER);

        frame.add(time_label);
        frame.add(seconds_left);
        frame.add(textfield);
        frame.add(textarea);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);
        frame.setVisible(true);

        nextQuestion();
    }

    private void configureButton(JButton button, String text) {
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBackground(new Color(0, 102, 204));
        button.setForeground(Color.WHITE);
        button.setFocusable(false);
        button.setText(text);
        button.addActionListener(this);
    }

    private void configureAnswerLabel(JLabel label) {
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setForeground(Color.BLACK);
    }

    public void nextQuestion() {
        if (index >= total_questions) {
            results();
        } else {
            textfield.setText("Question " + (index + 1));
            textarea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);
            timer = new Timer(1000, e -> {
                seconds--;
                seconds_left.setText(String.valueOf(seconds));
                if (seconds <= 0) {
                    displayAnswer();
                }
            });
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.stop();
        if (e.getSource() == buttonA) answer = 'A';
        if (e.getSource() == buttonB) answer = 'B';
        if (e.getSource() == buttonC) answer = 'C';
        if (e.getSource() == buttonD) answer = 'D';

        if (answer == answers[index]) correct_guesses++;
        displayAnswer();
    }

    public void displayAnswer() {
        if (answers[index] != 'A') answer_labelA.setForeground(Color.RED);
        if (answers[index] != 'B') answer_labelB.setForeground(Color.RED);
        if (answers[index] != 'C') answer_labelC.setForeground(Color.RED);
        if (answers[index] != 'D') answer_labelD.setForeground(Color.RED);

        Timer pause = new Timer(2000, e -> {
            answer_labelA.setForeground(Color.BLACK);
            answer_labelB.setForeground(Color.BLACK);
            answer_labelC.setForeground(Color.BLACK);
            answer_labelD.setForeground(Color.BLACK);
            index++;
            nextQuestion();
        });
        pause.setRepeats(false);
        pause.start();
    }

    public void results() {
        textfield.setText("Results");
        textarea.setText("Correct: " + correct_guesses + "/" + total_questions);
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
    }
}
