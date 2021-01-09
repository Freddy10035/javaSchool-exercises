

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

class ProjectX extends JFrame implements ChangeListener, ActionListener
{
    static int choice = 0;
    static String line = "--------------------------------";
    DataInputStream inputData = new DataInputStream(System.in);
    private Registration studentDetails = new Registration();
    int topScore = studentDetails.getTopScore();
    int passMarks = studentDetails.getPassMarks();
    int firstClass = studentDetails.getFirstClass();
    int secondClass = studentDetails.getSecondClass();

    JTabbedPane tabbedPane = new JTabbedPane();
    JLabel statusLabel = new JLabel();
    JLabel titleLabel = new JLabel("Student Software Beta Edition");
    JPanel addStudentPanel = new JPanel();
    JTextField studentName = new JTextField();
    JTextField physicsMarks = new JTextField();
    JTextField biologyMarks = new JTextField();
    JTextField mathsMarks = new JTextField();
    JButton submitDetails = new JButton("Submit Details");
    JPanel studentDetailsPanel = new JPanel();
    JTextField studentID1 = new JTextField();
    JTextArea studentInfo = new JTextArea();
    JButton submitID1 = new JButton("Submit ID");
    JPanel studentGradePanel = new JPanel();
    JTextField studentID2 = new JTextField();
    JTextArea studentGrade = new JTextArea();
    JButton submitID2 = new JButton("Submit ID");
    JPanel numberPassedPanel = new JPanel();
    JTextArea studentPassed = new JTextArea();
    JPanel classTopperPanel = new JPanel();
    JTextArea studentTopper = new JTextArea();

    public ProjectX(String frameTitle)
    {
        super(frameTitle);
        setResizable(true);
        setSize(400,400);
        submitDetails.addActionListener(this);
        submitID1.addActionListener(this);
        submitID2.addActionListener(this);

        getContentPane().setLayout(new BorderLayout());

        getContentPane().add(titleLabel,"North");

        tabbedPane.addTab("Add Student",addStudentPanel);
        addStudentPanel.setLayout(new GridLayout(8,2,5,5));
        addStudentPanel.add(new JLabel("Student Name: "));
        addStudentPanel.add(studentName);
        addStudentPanel.add(new JLabel("Physics Marks: "));
        addStudentPanel.add(physicsMarks);
        addStudentPanel.add(new JLabel("Biology Marks: "));
        addStudentPanel.add(biologyMarks);
        addStudentPanel.add(new JLabel("Maths Marks: "));
        addStudentPanel.add(mathsMarks);
        addStudentPanel.add(submitDetails);

        tabbedPane.addTab("Student Details",studentDetailsPanel);
        studentDetailsPanel.add(new JLabel("Enter Student ID: "));
        studentDetailsPanel.add(studentID1);
        studentDetailsPanel.add(submitID1);
        studentDetailsPanel.add(new JLabel("Student Details:"));
        studentDetailsPanel.add(studentInfo);

        tabbedPane.addTab("Student Grade",studentGradePanel);
        studentGradePanel.setLayout(new GridLayout(5,2,5,5));
        studentGradePanel.add(new JLabel("Enter Student ID: "));
        studentGradePanel.add(studentID2);
        studentGradePanel.add(submitID2);
        studentGradePanel.add(new JLabel("Student Grade:"));
        studentGradePanel.add(studentGrade);

        tabbedPane.addTab("Passed Student",numberPassedPanel);
        numberPassedPanel.setLayout(new GridLayout(2,2,5,5));
        numberPassedPanel.add(new JLabel("Number of Student Passed: "));
        numberPassedPanel.add(studentPassed);

        tabbedPane.addTab("Class Topper",classTopperPanel);
        classTopperPanel.setLayout(new GridLayout(2,2,5,5));
        classTopperPanel.add(new JLabel("Here are the class Toppers: "));
        classTopperPanel.add(studentTopper);

        tabbedPane.addChangeListener(this);
        getContentPane().add(tabbedPane,"Center");

        statusLabel.setText("Status: Normal");
        getContentPane().add(statusLabel,"South");

        setVisible(true);

    }

    public static void main(String args[])
    {
        ProjectX outputScreen = new ProjectX("Case Study");
    }

    public String setStudentInfo()
    {
        int id = studentDetails.addStudent(studentName.getText(),
                Integer.parseInt(physicsMarks.getText()),
                Integer.parseInt(biologyMarks.getText()),
                Integer.parseInt(mathsMarks.getText()));
        return                                                                    (""  + line                                                                                                                                                                            +
                "Record Created For " + studentName + " "                                                                                                                                                                            +
        "Student ID: " + id       + " "                                                                                                                                                                                            +
        line                                                                                                                                                                                            );
    }

    public String getStudentInfo()
    {
        int id = Integer.parseInt(studentID1.getText());
        if(studentDetails.getStudentDetails(id))
            return                                                                    (" "                                                                                                                                                                            +
        line                                                                                                                                                            + "Student Details "   +
        line                                                                                                                                                               +
                "Student ID:" + "	" + id + " "                                                                                      +
        "Student Name:" + "	" + studentDetails.studentName + " "   +
        "Physics Marks:" + "	" + studentDetails.physicsMarks + " " +
        "Biology Marks:" + "	" + studentDetails.biologyMarks + " " +
        "Maths Marks:" + "	" + studentDetails.mathsMarks + " "                    +
        line                                                                                                                                                                                                                                                                                                          );
                                 else
        return("Records Not Found for ID " + id);

    }

    public String getStudentGrade()
    {
        int id = Integer.parseInt(studentID2.getText());
        studentDetails.getStudentDetails(id);
        String grade;
        if(studentDetails.studentName == null)
        {
            System.out.println("Records Not Found for ID " + id);
            return null;
        }
        if(studentDetails.physicsMarks < passMarks ||
                studentDetails.biologyMarks < passMarks || studentDetails.mathsMarks <
                passMarks)
        {
            grade = "Failed";
        }
        else
        {
            int avgMarks = (studentDetails.physicsMarks +
                    studentDetails.biologyMarks + studentDetails.mathsMarks)/3;
            if(avgMarks >= passMarks && avgMarks < secondClass) grade = "Pass Class";
                                                  else if(avgMarks >= secondClass && avgMarks < firstClass) grade =
                "Second Class";
        else if(avgMarks >= firstClass && avgMarks < topScore) grade = "First Class";
            else grade = "Distinction";
        }
        return(line + "Grade For " + studentDetails.studentName + " is " + grade
                + " " + line);
    }

    public String getNumberPasses()
    {
        int lastID = Registration.getNextID() -1;
        boolean passed = true;
        int numberPassed = 0;
        for(int id = 1; id <= lastID; id++)
        {
            studentDetails.getStudentDetails(id);
            if(studentDetails.physicsMarks >= passMarks &&
                    studentDetails.biologyMarks >= passMarks && studentDetails.mathsMarks >=
                    passMarks) numberPassed++;
        }
        return(line + "Number of Student Passed: " + numberPassed + " " +
        line);
    }

    public String getClassTopper()
    {
        int lastID = Registration.getNextID() -1;
        String classTopper;
        StringBuffer buffer = new StringBuffer(500);
        int topMarks = 0;
        for(int id = 1; id <= lastID; id++)
        {
            studentDetails.getStudentDetails(id);
            int studentMarks = studentDetails.physicsMarks +
                    studentDetails.biologyMarks + studentDetails.mathsMarks;
            if(studentMarks > topMarks) topMarks = studentMarks;
        }
        buffer.append(line + "Student Having Top Marks: ");
        for(int id = 1; id <= lastID; id++)
        {
            studentDetails.getStudentDetails(id);
            int studentMarks = studentDetails.physicsMarks +
                    studentDetails.biologyMarks + studentDetails.mathsMarks;
            if(studentMarks == topMarks)
            {
                buffer.append(studentDetails.studentName + " Having Total Marks: " +
                                topMarks + " ");
            }
        }
        buffer.append(line);
        return(buffer.toString());
    }

    public void stateChanged(ChangeEvent e)
    {
        switch(tabbedPane.getSelectedIndex())
        {
            case 3: studentPassed.setText(getNumberPasses());
                break;
            case 4: studentTopper.setText(getClassTopper());
                break;
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == submitID1)
        {
            studentInfo.setText(getStudentInfo());
        }
        else if(e.getSource() == submitID2)
        {
            studentGrade.setText(getStudentGrade());
        }
        if(e.getSource() == submitDetails)
        {
            setStudentInfo();
        }
    }

}


//Registration Class
class Registration
{
    private int topScore = 90;
    private int passMarks = 35;
    private int firstClass = 65;
    private int secondClass = 45;
    private static String idFile = "id.dat";
    private static String studentFile = "studentfile.dat";

    public int id;
    public String studentName;
    public int physicsMarks;
    public int biologyMarks;
    public int mathsMarks;

    public int addStudent(String studentName, int physicsMarks, int
            biologyMarks, int mathsMarks)
    {
        int id = 0;
        try
        {
            FileWriter fileOutput = new FileWriter(Registration.studentFile,true);
            id = Registration.getNextID();
            String buffer = id + "|" + studentName + "|" + physicsMarks + "|" +
                    biologyMarks + "|" + mathsMarks + " ";
            fileOutput.write(buffer);
            fileOutput.close();
            Registration.setID(id);
        }
        catch(IOException e)
        {
            System.err.println(e.toString());
            System.exit(1);
        }
        return id;

    }

    //Function to get the details of a student given the ID
    public boolean getStudentDetails(int id)
    {
        try
        {
            FileReader fileInput = new FileReader(Registration.studentFile);
            BufferedReader br = new BufferedReader(fileInput);
            {

                String str;
                while((str = br.readLine()) != null)
                {
                    StringTokenizer fields = new StringTokenizer(str,"|");
                    if(Integer.parseInt(fields.nextToken()) == id)
                    {
                        this.id = id;
                        this.studentName = fields.nextToken();
                        this.physicsMarks = Integer.parseInt(fields.nextToken());
                        this.biologyMarks = Integer.parseInt(fields.nextToken());
                        this.mathsMarks = Integer.parseInt(fields.nextToken());
                        return true;
                    }
                }
            }

        }

        catch(IOException e)
        {
            System.err.println(e.toString());
            System.exit(1);
        }

        return false;
    }

    public int getTopScore()
    {
        return topScore;
    }

    public int getPassMarks()
    {
        return passMarks;
    }

    public int getFirstClass()
    {
        return firstClass;
    }

    public int getSecondClass()
    {
        return secondClass;
    }

    //Function to get the next ID available
    public static int getNextID()
    {
        int id = 0;
        try
        {
            RandomAccessFile studentIDFile = new
                    RandomAccessFile(Registration.idFile,"rw");
            if(studentIDFile.length() == 0)
            {
                id = 0;
            }
            else id = studentIDFile.readInt();
            id++;
            studentIDFile.close();
        }

        catch(IOException e)
        {
            System.err.println(e.toString());
            System.exit(1);
        }
        return id;
    }

    //Function to Store current ID in a file
    public static void setID(int id)
    {
        try
        {
            RandomAccessFile studentIDFile = new
                    RandomAccessFile(Registration.idFile,"rw");
            studentIDFile.seek(0);
            studentIDFile.writeInt(id);
            studentIDFile.close();
        }

        catch(IOException e)
        {
            System.err.println(e.toString());
            System.exit(1);
        }
    }
}
