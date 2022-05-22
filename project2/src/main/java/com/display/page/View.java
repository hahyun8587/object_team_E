package com.display.page;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class View implements Displayable {
	String[] options = {"Staff", "PartTime", "TeamLeader"};
	
    JFrame jframe = new JFrame();
    JPanel jpanel = new JPanel();
    JTextField t1 = new JTextField();
    JComboBox<String> t2 = new JComboBox<>(options);
    JTextField t3 = new JTextField();
    JTextField t4 = new JTextField();
    JTextArea ta = new JTextArea();
    JButton btn1, btn2, btn3, btn4, btn5;
    JLabel ㅣ1 = new JLabel("회의제목 : ");
    JLabel ㅣ2 = new JLabel("참여 : ");
    JLabel ㅣ3 = new JLabel("회의날짜 : ");
    JLabel ㅣ4 = new JLabel("검색내용 : ");

    View() {
        GUI_init();
    }

    public void GUI_init() {
        jframe.setTitle("회의 CRUD");
        jframe.setBounds(50, 50, 480, 450);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        jpanel.setLayout(null);
        jframe.add(jpanel);

        t1.setBounds(75, 25, 70, 25);
        jpanel.add(t1);
        ㅣ1.setBounds(17, 21, 70, 30);
        jpanel.add(ㅣ1);

        t2.setBounds(193, 25, 100, 25);
        jpanel.add(t2);
        ㅣ2.setBounds(150, 21, 70, 30);
        jpanel.add(ㅣ2);

        t3.setBounds(372, 25, 80, 25);
        jpanel.add(t3);
        ㅣ3.setBounds(310, 21, 70, 30);
        jpanel.add(ㅣ3);

        t4.setBounds(213, 105, 80, 25);
        jpanel.add(t4);
        ㅣ4.setBounds(150, 100, 70, 30);
        jpanel.add(ㅣ4);

        JScrollPane jsp = new JScrollPane(ta);
        jsp.setBounds(23, 145, 420, 250);
        jpanel.add(jsp);

        jpanel.add(btn1 = new JButton("등록"));
        btn1.setBounds(40, 60, 80, 30);

        jpanel.add(btn2 = new JButton("목록"));
        btn2.setBounds(145, 60, 80, 30);

        jpanel.add(btn3 = new JButton("수정"));
        btn3.setBounds(250, 60, 80, 30);

        jpanel.add(btn4 = new JButton("삭제"));
        btn4.setBounds(350, 60, 80, 30);

        jpanel.add(btn5 = new JButton("검색"));
        btn5.setBounds(300, 100, 80, 30);

//        Controller dao = new Controller();

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ta.setText("");

                String title = t1.getText();
                String rank = t2.getItemAt(t2.getSelectedIndex());
                String date = t3.getText();

//                dao.insertMeeting(new Model(title, rank, date));

                ta.append("입력 완료 \n");

                t1.setText("");
                t3.setText("");
                t4.setText("");
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ta.setText("");
                ArrayList<Model> arr = new ArrayList<Model>();
//                arr = dao.readMeeting();

                ta.append("\t" + "title" + "\t" + "rank" + "\t" + "date\n");
                ta.append("\t" + "------------------------------------------------------------\n");

                for (int i = 0; i < arr.size(); i++) {
                    ta.append("\t" + arr.get(i).getTitle() + " \t " + arr.get(i).getRank() + " \t " + arr.get(i).getDate()
                            + "\n");
                }
            }
        });
        
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ta.setText("");

                String title = t1.getText();
                String rank = t2.getItemAt(t2.getSelectedIndex());
                String date = t3.getText();

//                dao.updateMeeting(title, date);
                ta.append("수정 완료 \n");

                t1.setText("");
                t3.setText("");
                t4.setText("");
            }
        });

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ta.setText("");

                String title = t1.getText();
//                dao.deleteMeeting(title);
                ta.append("삭제 완료 \n");

                t1.setText("");
                t3.setText("");
                t4.setText("");
            }
        });

        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ta.setText("");
                String content = t4.getText();

                ArrayList<Model> arr = new ArrayList<Model>();
//                arr = dao.searchMeeting(content);
                ta.append(" \n");

                ta.append("\t" + "title" + "\t" + "rank" + "\t" + "date\n");
                ta.append("\t" + "------------------------------------------------------------\n");

                for (int i = 0; i < arr.size(); i++) {
                    ta.append("\t" + arr.get(i).getTitle() + " \t " + arr.get(i).getRank() + " \t " + arr.get(i).getDate()
                            + "\n");
                }

                t1.setText("");
                t3.setText("");
                t4.setText("");
            }
        });
    }
    
	public void display() {
		jframe.setVisible(true);
	};
}