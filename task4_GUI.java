import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class bankaccount {
    private double balance;
    //constructor
    public bankaccount(double  initialbalance) {
        balance = initialbalance;
    }
    //getmethod
    public double getBalance() {
        return balance;
    }
    //method for depositing
    public void deposit(double amount) {
        balance += amount;
    }
    //method for withdrawing amount
    public boolean withdraw(double amount) {
        if (amount > balance) {
             return false;
        }
        else {
             balance=balance-amount;
             return true;
        }
    }
}

class atm_machine extends JFrame implements ActionListener {
    private bankaccount account;
    //area where balance is present.......
    private JTextField balancearea;
    //area at where amount to be entered to deposit and withdraw...
    private JTextField amountarea;
    //area at where output is displayed.......
    private JTextArea outputarea;

    public atm_machine(bankaccount account) {
        this.account = account;

        setTitle("ATM Machine");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p= new JPanel();
        p.setLayout(new GridLayout(4, 2));
        p.setBackground(Color.ORANGE);

        JLabel balanceLabel = new JLabel("Balance:");
        balancearea = new JTextField(Double.toString(account.getBalance()));
        balancearea.setEditable(false);

        JLabel amountLabel = new JLabel("Amount:");
        amountarea = new JTextField();

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.addActionListener(this);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(this);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(this);

        outputarea = new JTextArea();
        outputarea.setEditable(false);

        p.add(balanceLabel);
        p.add(balancearea);
        p.add(amountLabel);
        p.add(amountarea);
        p.add(checkBalanceButton);
        p.add(depositButton);
        p.add(withdrawButton);
        p.add(outputarea);

        add(p);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Check Balance")) {
            outputarea.setText("Your balance is: Rs. " + account.getBalance());
        } else if (e.getActionCommand().equals("Deposit")) {
            try {
                double amount = Double.parseDouble(amountarea.getText());
                if (amount > 0) {
                    account.deposit(amount);
                    balancearea.setText(Double.toString(account.getBalance()));
                    outputarea.setText("Deposit successful.");
                } else {
                    outputarea.setText("Invalid deposit amount.");
                }
            } catch (NumberFormatException ex) {
                outputarea.setText("Invalid input. Please enter a valid amount.");
            }
        } else if (e.getActionCommand().equals("Withdraw")) {
            try {
                double amount = Double.parseDouble(amountarea.getText());
                if (amount > 0 && account.withdraw(amount)) {
                    balancearea.setText(Double.toString(account.getBalance()));
                    outputarea.setText("Withdrawal successful.");
                } else {
                    outputarea.setText("Invalid withdrawal amount or insufficient balance.");
                }
            } catch (NumberFormatException ex) {
                outputarea.setText("Invalid input. Please enter a valid amount.");
            }
        }
    }
}

public class task4_GUI {
    public static void main(String[] args) {
        bankaccount user = new bankaccount(5000.000);
        atm_machine obj= new atm_machine(user);
        obj.setVisible(true);
    }
}