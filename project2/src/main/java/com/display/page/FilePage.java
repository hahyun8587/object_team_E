package com.display.page;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;
 
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.display.FramePage;
import com.display.listener.MoveFowardActionListener;
import com.display.page.mainpage.MainPage;
import com.std.User;

public class FilePage extends FramePage {
    JTextArea ta;
    File f;

    Color color;
    public FilePage(User user, Color color) {
        super(user, color);

        this.color = color;

        setTitle("제목없음");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenu mfile = new JMenu("파일");
        
        JMenuItem mOpen= new JMenuItem("열기");
        JMenuItem mNew= new JMenuItem("새파일");
        JMenuItem mSave= new JMenuItem("저장");
        final JMenuItem mSaveAs = new JMenuItem("다른이름으로 저장");
        JMenuItem mExit= new JMenuItem("끝내기");
        JMenuItem back = new JMenuItem("뒤로가기");

        mfile.add(mOpen);
        mfile.add(mNew);
        mfile.add(mSave);
        mfile.add(mSaveAs);
        mfile.addSeparator();
        mfile.add(mExit);
        mfile.add(back);
        
        JMenuBar mb = new JMenuBar();
        mb.add(mfile);
        setJMenuBar(mb);
        
        ta=new JTextArea();
        JScrollPane jsp=new JScrollPane();
        jsp.setViewportView(ta);
        add(jsp);
        
        mNew.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                ta.setText("");
                setTitle("제목없음");
            }
        });
        
        mOpen.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc=new JFileChooser();
                if(fc.showOpenDialog(FilePage.this)==JFileChooser.CANCEL_OPTION)
                    return;
                f=fc.getSelectedFile(); 
                setTitle(f.getName());
                fileRead(f);
            }
        });
 
        mSave.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                if(getTitle().equals("제목없음")) { 
                    mSaveAs.doClick();
                }else {
                    fileSave(f);
                }
            }
        });
 
        mSaveAs.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc=new JFileChooser();
                if(fc.showSaveDialog(FilePage.this)==JFileChooser.CANCEL_OPTION)
                    return;
                f=fc.getSelectedFile();
                fileSave(f);
                setTitle(f.getName());
            }
        });
        
        mExit.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        back.addActionListener(new moveActionListener());
        
        
        setSize(500,400);    
    }

    private void fileRead(File f) {
        try {
            FileReader fr=new FileReader(f);
            StringWriter sw=new StringWriter();
            while(true) {
                int ch=fr.read();
                if(ch==-1) break;
                sw.write(ch);
            }
            ta.setText(sw.toString());
            sw.close();
            fr.close();
        } catch (FileNotFoundException n) {
            n.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
 
    private void fileSave(File f) {
        try {
            PrintStream ps=new PrintStream(f);
            ps.println(ta.getText());
            ps.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }

	public class moveActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new MainPage(user, color).display();
		}
	}
}
