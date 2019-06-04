package Notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotepadWindow extends JFrame implements ActionListener
{
    Notepad notepad;

    JTextArea textArea;
    JMenuBar menuBar;

    JMenu mFile;
    JMenu mExit;
    JMenuItem miNew;
    JMenuItem miOpen;
    JMenuItem miSave;
    JMenuItem miExit;

    public NotepadWindow(String title, int width,int height)
    {
        notepad = new Notepad();

        setTitle(title);
        setSize(width,height);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        menuBar = new JMenuBar();
        textArea = new JTextArea();
        mFile = new JMenu("File");
        miNew = new JMenuItem("New");
        miOpen = new JMenuItem("Open");
        miSave = new JMenuItem("Save");
        miExit = new JMenuItem("Exit");
        mExit = new JMenu("Exit");

        miNew.addActionListener(this);
        miOpen.addActionListener(this);
        miSave.addActionListener(this);
        miExit.addActionListener(this);

        mFile.add(miNew);
        mFile.add(miSave);
        mFile.add(miOpen);
        mFile.add(miExit);

        menuBar.add(mFile);
        //menuBar.add(mExit);

        setJMenuBar(menuBar);
        add(textArea, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(miNew))
            notepad.newFile();

        if(e.getSource().equals(miOpen))
            textArea.setText(notepad.openFile());

        if(e.getSource().equals(miSave))
            notepad.saveFile(textArea.getText().getBytes());

        if(e.getSource().equals(miExit))
            dispose();
    }
}