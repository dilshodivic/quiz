package org.example;

import javax.swing.*;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizTest extends JFrame implements ActionListener {
    JLabel label;
    JRadioButton radioButtons[]=new JRadioButton[5];
    JButton btnNext,btnResult;
    ButtonGroup bg;
    int count=0,current=0,x=1,y=1,now=0;
    int m[] =new int[10];
    QuizTest (String s){
        super(s);
        label =new JLabel();
        add(label);
        bg=new ButtonGroup();
        for (int i = 0; i < 5; i++) {
          radioButtons[i]=new JRadioButton();
          add(radioButtons[i]);
          bg.add(radioButtons[i]);
        }
        btnNext=new JButton("Next");
        btnResult=new JButton("Result");
        btnResult.setVisible(false);
        btnResult.addActionListener(this);
        btnNext.addActionListener(this);
        add(btnNext);
        add(btnResult);
        setData();
        label.setBounds(30,40,450,20);
        radioButtons[0].setBounds(50,80,450,20);
        radioButtons[1].setBounds(50,110,200,20);
        radioButtons[2].setBounds(50,140,200,20);
        radioButtons[3].setBounds(50,170,200,20);
        btnNext.setBounds(100,240,100,30);
        btnResult.setBounds(270,240,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);

    }
    void  setData(){
        radioButtons[4].setSelected(true);
        if(current==0){
            label.setText("Q 1: What is the size of boolean variable? ");
            radioButtons[0].setText("8 bit ");
            radioButtons[1].setText("16 bit ");
            radioButtons[2].setText("32 bit ");
            radioButtons[3].setText("not know ");
        }
        if(current==1){
            label.setText("Q 2: What is the default value of long variable?");
            radioButtons[0].setText("0 ");
            radioButtons[1].setText("0.0 ");
            radioButtons[2].setText("0l ");
            radioButtons[3].setText("not know ");
        }
        if(current==2){
            label.setText("Q 3: Wat is the default value of boolean variable? ");
            radioButtons[0].setText("true ");
            radioButtons[1].setText("false ");
            radioButtons[2].setText("null ");
            radioButtons[3].setText("not defined ");
        }
        if(current==3){
            label.setText("Q 4: What kind of variables a class can consist of?");
            radioButtons[0].setText("A - class variables, instance variables");
            radioButtons[1].setText("B - class variables,local variables,instance variables ?");
            radioButtons[2].setText("C - class variables");
            radioButtons[3].setText("D - class variables, local variables");
        }
        if(current==4){
            label.setText("Q 5: What i function overloading?");
            radioButtons[0].setText("A - Methods with same name but different parameters.");
            radioButtons[1].setText("B - Methods with same name but different return types.");
            radioButtons[2].setText("C - Methods same name , same parameter types but different parameter names.");
            radioButtons[3].setText("C - None of the above. ");
        }
        if(current==5){
            label.setText("Q 6: What is Serialization?");
            radioButtons[0].setText("A - Serialization is the process of writing the state of an object to another object.");
            radioButtons[1].setText("B - Serialization is the process of writing the state of an object to a byte stream.");
            radioButtons[2].setText("C - Both of the above. ");
            radioButtons[3].setText("D - None of the above.");
        }
        if(current==6){
            label.setText("Q 7: Which of the following is  a thread safe?");
            radioButtons[0].setText("A - StringBuilder");
            radioButtons[1].setText("B - StringBuffer");
            radioButtons[2].setText("C - Both of the above.");
            radioButtons[3].setText("None of the above.");
        }
        if(current==7){
            label.setText("Q 8: What is the size of boolean variable?");
            radioButtons[0].setText("A - 8 bit");
            radioButtons[1].setText("B - 16 bit");
            radioButtons[2].setText("C - 32 bit");
            radioButtons[3].setText("D - not precisely defined");
        }
        if(current==8){
            label.setText("Q 9: Which is the official language for Android  Development");
            radioButtons[0].setText("Java");
            radioButtons[1].setText("Kotlin");
            radioButtons[2].setText("C++");
            radioButtons[3].setText("JavaScript");
        }
            if(current==9){
            label.setText("Q 10: What we can learn from Geeks for Geeks?");
            radioButtons[0].setText("A - C++ ");
            radioButtons[1].setText("B - Android development ");
            radioButtons[2].setText("C - Java");
            radioButtons[3].setText("D - All of the above ");
        }
        label.setBounds(30,40,450,20);
        for (int i = 0,j=0; i <= 90; i+=30,j++){
            radioButtons[j].setBounds(50,80+i,200,20);

        }
    }
    boolean checkAns(){
        if(current==0){
            return (radioButtons[1].isSelected());
        }
        if(current==1){
            return (radioButtons[2].isSelected());
        }
        if(current==2){
            return (radioButtons[1].isSelected());
        }
        if(current==3){
            return (radioButtons[1].isSelected());
        }
        if(current==4){
            return (radioButtons[0].isSelected());
        }
        if(current==5){
            return (radioButtons[1].isSelected());
        }
        if(current==6){
            return (radioButtons[1].isSelected());
        }
        if(current==7){
            return (radioButtons[1].isSelected());
        }
        if(current==8){
            return (radioButtons[1].isSelected());
        }
        if(current==9){
            return (radioButtons[3].isSelected());
        }

        return  false;
    }
    public static void main(String[] args) {
new QuizTest("Simple Quiz app");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==btnNext){
           if(checkAns()){
               count=count+1;
               current++;
               setData();
               if(current==9){
                   btnNext.setEnabled(false);
                   btnResult.setVisible(true);
                   btnResult.setText("Result");

               }
           }
           if(e.getActionCommand().equals("Result")){
               if(checkAns()){
                   count=count+1;
                   current++;
                   JOptionPane.showMessageDialog(this,"Correct answer are " +count);
                   System.exit(0);
               }
           }
       }
    }
}
