package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Person;
import view.GUI;

public class PersonController {
    GUI personview;

    public PersonController(GUI personview) {
        this.personview = personview;

        personview.bsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fullName = personview.getFname().getText();
                String nim = personview.getFname().getText();
                String examScore = personview.getExamScore().getText();
                double exam = Double.parseDouble(examScore);
                String codingScore = personview.getCodingScore().getText();
                double coding = Double.parseDouble(codingScore);
                String interviewScore = personview.getInterviewScore().getText();
                double interview = Double.parseDouble(interviewScore);

                Person person = new Person(fullName, nim, exam, coding, interview);
            }
        });
    }
}