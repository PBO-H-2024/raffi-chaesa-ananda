package view;

import javax.swing.*;

public class GUI extends JFrame {
    // text field
    JLabel lname = new JLabel("Name: ");
    JTextField fname = new JTextField();

    JLabel lnim = new JLabel("NIM: ");
    JTextField nim = new JTextField();

    JLabel lexam = new JLabel("Writing exam: ");
    JTextField exam = new JTextField();

    JLabel lcoding = new JLabel("Coding test: ");
    JTextField coding = new JTextField();

    JLabel linterview = new JLabel("Interview test: ");
    JTextField interview = new JTextField();

    // button
    public JButton bsubmit = new JButton("Submit");

    // constructor
    public GUI() {
        setTitle("PT. OOP");
        setSize(300, 200);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(lname);
        add(fname);
        add(lnim);
        add(nim);
        add(lexam);
        add(exam);
        add(lcoding);
        add(coding);
        add(linterview);
        add(interview);
        add(bsubmit);

        lname.setBounds(10, 10, 120, 20);
        fname.setBounds(130, 10, 150, 20);
        lnim.setBounds(10, 35, 120, 20);
        nim.setBounds(130, 35, 150, 20);
        lexam.setBounds(10, 60, 150, 20);
        exam.setBounds(130, 60, 150, 20);
        lcoding.setBounds(10, 85, 120, 20);
        coding.setBounds(130, 85, 150, 20);
        linterview.setBounds(10, 110, 150, 20);
        interview.setBounds(130, 110, 150, 20);
        bsubmit.setBounds(100, 140, 120, 20);
    }

    public JTextField getFname() {
        return fname;
    }

    public JTextField getNIM() {
        return nim;
    }

    public JTextField getExamScore() {
        return exam;
    }

    public JTextField getCodingScore() {
        return coding;
    }

    public JTextField getInterviewScore() {
        return interview;
    }

    public JButton getBsubmit() {
        return bsubmit;
    }

    public void setBsubmit(JButton bsubmit) {
        this.bsubmit = bsubmit;
    }
}