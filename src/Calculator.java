import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class Calculator extends JFrame implements ActionListener {
    DecimalFormat myFormat = new DecimalFormat("0.#######");
    int operator = 0;
    double num1 = 0, num2 = 0;
    static final JTextArea display = new JTextArea();
    final private JButton[] btns = new JButton[20];
    final private String[] labels = {
            "1", "2", "3", "CE", "4", "5", "6", "+", "7",
            "8", "9", "-", "0", ".", "/", "*", "%", "√", "x²", "="
    };

    public Calculator() {
        createIF();
    }

    public static void main(String[] args) {

        new Calculator();
    }

    private void createIF() {
        JPanel p2 = new JPanel(new BorderLayout(5, 5));
        JPanel p1 = new JPanel(new GridLayout(5, 4, 5, 5));


        for (int i = 0; i < btns.length; i++) {
            btns[i] = new JButton(labels[i]);
            btns[i].addActionListener(this);
            p1.add(btns[i]);
        }

        display.setEditable(false); // Make the display non-editable
        display.setPreferredSize(new Dimension(380, 70));
        display.setFont(new Font("Arial", Font.PLAIN, 54));
        setTitle("Calculator_1.2");
        setLayout(new BorderLayout(50, 50));
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        p2.add(display, BorderLayout.NORTH);
        p2.add(p1, BorderLayout.CENTER);
        add(p2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String check = e.getActionCommand();

            switch (check) {
                case "CE":
                    display.setText("");
                    num1 = 0;
                    num2 = 0;
                    operator = 0;
                    break;
                case ".":
                    if (display.getText().contains(".")) {
                        display.setText(display.getText());
                    } else {
                        display.setText(display.getText() + ".");
                    }
                    break;
                case "0":
                    display.setText(display.getText() + "0");
                    break;
                case "1":
                    display.setText(display.getText() + "1");
                    break;
                case "2":
                    display.setText(display.getText() + "2");
                    break;
                case "3":
                    display.setText(display.getText() + "3");
                    break;
                case "4":
                    display.setText(display.getText() + "4");
                    break;
                case "5":
                    display.setText(display.getText() + "5");
                    break;
                case "6":
                    display.setText(display.getText() + "6");
                    break;
                case "7":
                    display.setText(display.getText() + "7");
                    break;
                case "8":
                    display.setText(display.getText() + "8");
                    break;
                case "9":
                    display.setText(display.getText() + "9");
                    break;
                case "x²":
                    num1 = Double.parseDouble(display.getText());
                    display.setText(String.valueOf(myFormat.format(num1 * num1)));
                    break;
                case "√":
                    num1 = Double.parseDouble(display.getText());
                    display.setText(String.valueOf(myFormat.format(Math.sqrt(num1))));
                    break;
                case "+":
                    num1 = Double.parseDouble(display.getText());
                    operator = 1;
                    display.setText("");
                    break;
                case "-":
                    num1 = Double.parseDouble(display.getText());
                    operator = 2;
                    display.setText("");
                    break;
                case "/":
                    num1 = Double.parseDouble(display.getText());
                    operator = 3;
                    display.setText("");
                    break;
                case "*":
                    num1 = Double.parseDouble(display.getText());
                    operator = 4;
                    display.setText("");
                    break;
                case "=":
                    switch (operator) {
                        case 1:
                            num2 = Double.parseDouble(display.getText());
                            display.setText(String.valueOf(myFormat.format(num1 + num2)));
                            break;
                        case 2:
                            num2 = Double.parseDouble(display.getText());
                            display.setText(String.valueOf(myFormat.format(num1 - num2)));
                            break;
                        case 3:
                            num2 = Double.parseDouble(display.getText());
                            display.setText(String.valueOf(myFormat.format(num1 / num2)));
                            break;
                        case 4:
                            num2 = Double.parseDouble(display.getText());
                            display.setText(String.valueOf(myFormat.format(num1 * num2)));
                            break;
                    }
                    break;
                    case "%":
                            switch (operator) {
                                case 1:
                                    num2 = Double.parseDouble(display.getText());
                                    display.setText(String.valueOf(myFormat.format(num1 * (1 + num2 / 100))));
                                    break;
                                case 2:
                                    num2 = Double.parseDouble(display.getText());
                                    display.setText(String.valueOf(myFormat.format(num1 * (1 - num2 / 100))));
                                    break;
                                case 3:
                                    num2 = Double.parseDouble(display.getText());
                                    display.setText(String.valueOf(myFormat.format(num1 / (num2 / 100))));
                                    break;
                                case 4:
                                    num2 = Double.parseDouble(display.getText());
                                    display.setText(String.valueOf(myFormat.format(num1 * (num2 / 100))));
                                    break;
                                default:
                                    break;
                            }
                        default:
                            break;
                    }
            }
        }
