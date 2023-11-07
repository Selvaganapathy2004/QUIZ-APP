/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quiz2;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author SELVAGANAPATHY
 */
public class Quiz2 extends javax.swing.JFrame {
    //Pattern : {"Question","Option-1","Option-2","Option-3","Option-4","Correct answer"}
    private String[][] ques = new String[][]{{"Who is the author of the “Harry Potter” book series?","Shakespeare","J.K. Rowling","Agatha Christie","Barbara Cartland","J.K. Rowling"},
                                             {"In which year did World War I begin?","1939","1941","1955","1914","1914"},
                                             {"What is the capital of France?","Paris","Berlin","Moscow","Tokyo","Paris"},
                                             {"Which ocean is the deepest on Earth?","The Pacific Ocean","Indian ocean","Antartica Ocean","Arctic Ocean","The Pacific Ocean"},
                                             {"What is the largest planet in our solar system?","Mercury","Earth","Jupiter","Saturn","Jupiter"}};
    private JButton[] btns = new JButton[4];
    private JLabel lblQuestion = new JLabel();
    private JPanel pnl = new JPanel();
    int quesNumber = -1;
    
    private void updateContent() {     
        quesNumber++;           
        if(quesNumber == ques.length) {//means all questions all over
            for(int i = 0; i < 4; i++) {                
                pnl.remove(btns[i]);
            }
            repaint();//to apply the changes made in GUI -> removing the buttons.
            lblQuestion.setText("Thank you for attending the quiz!!");
            lblQuestion.setBounds(130, 160, 400, 50);
        } else {//question avaialble, update the content to show the current question
            lblQuestion.setText((quesNumber+1) + ".) " + ques[quesNumber][0]);
            for(int i = 0; i < 4; i++) {
                btns[i].setText(ques[quesNumber][i+1]);
            }
        }
    }
    
    private final void showGUI() {//to set up initial position for displaying UI elements
        pnl.setSize(500, 400);        
        for(int i = 0; i < 4; i++) {
            final int INDEX = i;
            btns[INDEX] = new JButton();
            btns[INDEX].addActionListener(event -> {
                if(btns[INDEX].getText().equals(ques[quesNumber][5])) {//Correct answer index is always stored in index '5' of every question in 'ques' string array and 'quesNumber' is the current question.
                    updateContent();
                }
            });
            pnl.add(btns[i]);
        }
        final int BUTTON_WIDTH = 140, BUTTON_HEIGHT = 60;
        btns[0].setBounds(85,160,BUTTON_WIDTH,BUTTON_HEIGHT);
        btns[1].setBounds(265,160,BUTTON_WIDTH,BUTTON_HEIGHT);
        btns[2].setBounds(85,240,BUTTON_WIDTH,BUTTON_HEIGHT);
        btns[3].setBounds(265,240,BUTTON_WIDTH,BUTTON_HEIGHT);
        pnl.add(lblQuestion);
        lblQuestion.setBounds(80,80,400,50);
        JLabel lblTitle = new JLabel("My Quiz App");
        pnl.add(lblTitle);
        lblTitle.setBounds(220,20,400,50);
        pnl.setLayout(null);
        this.add(pnl);
        //Look and feel if needed de-comment the below line
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch(Exception e) {
            System.err.println("Unable to apply Look And Feel");
        }*/
        this.setVisible(true);
        this.setSize(500,400);
        this.setResizable(false);
        // 'this' refers to JFrame as the class 'Quiz2' is now inherits all the properties of 'JFrame'
        this.setLocationRelativeTo(null);
        this.setTitle("QUIZ");
        this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        updateContent();
    }
    
    public static void main(String[] args) {
        new Quiz2().showGUI();
    }
}
