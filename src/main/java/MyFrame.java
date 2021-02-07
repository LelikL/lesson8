import  javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    private final JTextField textField;
    private char operation;
    private double total;
    private boolean isFirstDigit;


    public MyFrame(){
        setTitle("Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 170, 280);
        //setVisible(true);
        isFirstDigit = true;

        total = 0;

        JPanel jPanel = new JPanel();

        textField = new JTextField(12);
        textField.setEditable(false);

        jPanel.add(textField);

        JButton[] jbs = new JButton[9];
        for (int i=0; i < jbs.length; i++){
            jbs[i] = new JButton(String.valueOf(i + 1));
            jbs[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    action(e);
                }
            });
            jPanel.add(jbs[i]);
        }//for

        JButton buttonZero = new JButton("0");
        JButton buttonPlus = new JButton("+");
        JButton buttonMinus = new JButton("-");
        JButton buttonEquals = new JButton("=");
        JButton buttonMulti = new JButton("*");
        JButton buttonDiv = new JButton("/");
        JButton buttonPoint = new JButton(".");

        buttonZero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });

        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });

        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });

        buttonMulti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });

        buttonDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });

        buttonPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });

        buttonEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculating(e);
            }
        });

        jPanel.add(buttonPlus);
        jPanel.add(buttonZero);
        jPanel.add(buttonMinus);
        jPanel.add(buttonMulti);
        jPanel.add(buttonDiv);
        jPanel.add(buttonEquals);
        jPanel.add(buttonPoint);

        add(jPanel);
        setVisible(true);
    }//MyFrame----------------------------------------------------------------------------------

    public void action(ActionEvent event){
        textField.setText(textField.getText() + event.getActionCommand());
    }//action----------------------------------------------------------------------------------

    private void calculating(ActionEvent e){
        String text = textField.getText();
        String digit = "";
        for (int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            if (c == '-' || c == '+' || c == '*' || c == '/'){
                double currentValue = Double.parseDouble(digit);
                if (isFirstDigit){
                    total += currentValue;
                    isFirstDigit = false;
                }else {
                    if (operation == '-'){
                        total -= currentValue;
                    }else if ( operation == '+'){
                        total += currentValue;
                    }else if ( operation == '*'){
                        total *= currentValue;
                    }else if ( operation == '/'){
                        total /= currentValue;
                    }
                }//else

                digit = "";
                operation = c;
                continue;
            }//if
            digit += c;
        }//for

        double currentValue = Double.parseDouble(digit);
        if (operation == '-'){
            total -= currentValue;
        }else if (operation == '+'){
            total += currentValue;
        }else if ( operation == '*'){
            total *= currentValue;
        }else if ( operation == '/'){
            total /= currentValue;
        }

        isFirstDigit = true;
        textField.setText(String.valueOf(total));
        total = 0;
    }//calculating--------------------------------------------------------------------------

}//class MyFrame
