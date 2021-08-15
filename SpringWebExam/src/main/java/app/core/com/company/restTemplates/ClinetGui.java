package app.core.com.company.restTemplates;



import app.core.com.company.beans.Employee;
import app.core.com.company.beans.Job;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClinetGui extends JFrame{
    private static final int WIDTH = 1300;
    private static final int HEIGHT = 820;

    private CompanyClient client = new CompanyClient();


    private JTextArea tfRespons;

    private JTextField tfId;
    private JTextField tfName;
    private JTextField tfSalary;
    private JTextField tfJob1;
    private JTextField tfJob2;
    private JTextField tfJob3;

    JScrollPane scroll;

    private JButton btnAdd;
    private JButton btnGet;
    private JButton btnGetAll;
    private JButton btnGetAllByName;

    private JPanel panel;

    private JLabel lbId;
    private JLabel lbName;
    private JLabel lbSalary;
    private JLabel lbJob1;
    private JLabel lbJob2;
    private JLabel lbJob3;

    public ClinetGui(){
        setTitle("Company System - Employee Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        initializeLabels();
        initializeTexts();
        initializeButtons();
        initializePanel();
        add(panel);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    private void initializeLabels(){
        lbId = new JLabel("Id: ");
        lbName = new JLabel("Name: ");
        lbSalary = new JLabel("Salary: ");
        lbJob1 = new JLabel("Job 1: ");
        lbJob2 = new JLabel("Job 2: ");
        lbJob3 = new JLabel("Job 3: ");

        lbId.setBounds(50,50, 150,50);
        lbId.setForeground(new Color(0,125,0));
        lbId.setFont(new Font("MB Boli", Font.BOLD, 22));

        lbName.setBounds(50,120, 150,50);
        lbName.setForeground(new Color(0,125,0));
        lbName.setFont(new Font("MB Boli", Font.BOLD, 22));

        lbSalary.setBounds(50,190, 150,50);
        lbSalary.setForeground(new Color(0,125,0));
        lbSalary.setFont(new Font("MB Boli", Font.BOLD, 22));

        lbJob1.setBounds(50,260, 150,50);
        lbJob1.setForeground(new Color(0,125,0));
        lbJob1.setFont(new Font("MB Boli", Font.BOLD, 22));

        lbJob2.setBounds(50,330, 150,50);
        lbJob2.setForeground(new Color(0,125,0));
        lbJob2.setFont(new Font("MB Boli", Font.BOLD, 22));

        lbJob3.setBounds(50,400, 150,50);
        lbJob3.setForeground(new Color(0,125,0));
        lbJob3.setFont(new Font("MB Boli", Font.BOLD, 22));

    }
    private void initializeTexts(){
        tfRespons = new JTextArea();
        tfId = new JTextField();
        tfName = new JTextField();
        tfSalary = new JTextField();
        tfJob1 = new JTextField();
        tfJob2 = new JTextField();
        tfJob3 = new JTextField();

        tfId.setBounds(210,50, 300,50);
        tfId.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        tfId.setForeground(new Color(0,125,0));
        tfId.setBackground(new Color(25,25,25));
        tfId.setFont(new Font("MB Boli", Font.BOLD, 22));

        tfName.setBounds(210,120, 300,50);
        tfName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        tfName.setForeground(Color.white);
        tfName.setBackground(new Color(25,25,25));
        tfName.setFont(new Font("MB Boli", Font.BOLD, 22));

        tfSalary.setBounds(210,190, 300,50);
        tfSalary.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        tfSalary.setForeground(Color.white);
        tfSalary.setBackground(new Color(25,25,25));
        tfSalary.setFont(new Font("MB Boli", Font.BOLD, 22));

        tfJob1.setBounds(210,260, 550,50);
        tfJob1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        tfJob1.setForeground(Color.white);
        tfJob1.setBackground(new Color(25,25,25));
        tfJob1.setFont(new Font("MB Boli", Font.BOLD, 22));

        tfJob2.setBounds(210,330, 550,50);
        tfJob2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        tfJob2.setForeground(Color.white);
        tfJob2.setBackground(new Color(25,25,25));
        tfJob2.setFont(new Font("MB Boli", Font.BOLD, 22));

        tfJob3.setBounds(210,400, 550,50);
        tfJob3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        tfJob3.setForeground(Color.white);
        tfJob3.setBackground(new Color(25,25,25));
        tfJob3.setFont(new Font("MB Boli", Font.BOLD, 22));

        tfRespons.setBackground(new Color(50,50,50));
        tfRespons.setBorder(BorderFactory.createBevelBorder(1));
        tfRespons.setBounds(50,470,1200,300);
        tfRespons.setFont(new Font("MB Boli", Font.BOLD, 22));
        tfRespons.setForeground(Color.white);
        tfRespons.setEditable(false);
        tfRespons.setLineWrap(true);
        tfRespons.setWrapStyleWord(true);
    }
    private void initializeButtons(){
        btnAdd  = new JButton("Add");
        btnGet  = new JButton("Get");
        btnGetAll = new JButton("Get All");
        btnGetAllByName = new JButton("Get All By Name");

        btnGet.setBorder(new EmptyBorder(10,10,10,10));
        btnGet.setBackground(Color.RED);
        btnGet.setBounds(550,50, 80,50);
        btnGet.setFont(new Font("MB Boli", Font.BOLD, 22));
        btnGet.setForeground(new Color(25,25,25));
        btnGet.setFocusable(false);
        btnGet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long id = Long.parseLong( tfId.getText());
                    Object resBody = client.getOne(id);
                    if(resBody instanceof Employee){
                        tfRespons.setForeground(Color.white);
                        Employee employee = (Employee) resBody;
                        String response = "id: " + employee.getId() +
                                '\n' + "Name:" + employee.getName() +
                                '\n' +  "Salary: " +  employee.getSalary() +
                                '\n' + "Jobs: " + employee.getJobs() + '\n';
                        tfRespons.setText(response);
                    } else {
                        String entry = (String) resBody;
                        tfRespons.setForeground(Color.RED);
                        tfRespons.setText(entry);
                    }
                }catch (NumberFormatException ex){
                    tfRespons.setForeground(Color.red);
                    tfRespons.setText("Invalid Employee id!");
                }
            }
        });

        btnGetAll.setBorder(new EmptyBorder(10,10,10,10));
        btnGetAll.setBackground(Color.RED);
        btnGetAll.setBounds(650,50, 120,50);
        btnGetAll.setFont(new Font("MB Boli", Font.BOLD, 22));
        btnGetAll.setForeground(new Color(25,25,25));
        btnGetAll.setFocusable(false);
        btnGetAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder response = new StringBuilder();
                List<Employee> employess = client.getAll();
                if(employess.size() == 0 ){
                    tfRespons.setForeground(Color.red);
                    tfRespons.setText("No Employee are available!");
                }else {
                    for(Object obj : employess){
                        response.append(obj.toString()).append('\n');
                    }
                    tfRespons.setForeground(Color.white);
                    tfRespons.setText(response.toString());
                }
            }
        });

        btnAdd.setBorder(new EmptyBorder(10,10,10,10));
        btnAdd.setBackground(Color.RED);
        btnAdd.setBounds(550,120, 80,50);
        btnAdd.setFont(new Font("MB Boli", Font.BOLD, 22));
        btnAdd.setForeground(new Color(25,25,25));
        btnAdd.setFocusable(false);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    tfRespons.setForeground(Color.white);
                    List<Job> jobs = new ArrayList<>();
                    jobs.add(new Job(0, tfJob1.getText(), LocalDate.now().plusDays((int)Math.random() * 8) ));
                    jobs.add(new Job(0, tfJob2.getText(), LocalDate.now().plusDays((int)Math.random() * 8) ));
                    jobs.add(new Job(0, tfJob3.getText(), LocalDate.now().plusDays((int)Math.random() * 8) ));
                    tfRespons.setForeground(Color.white);

                    Object response = client.add(new Employee(
                            0,
                            tfName.getText(),
                            Double.parseDouble(tfSalary.getText()),
                            jobs
                    ));
                    if (!(response instanceof Long)){
                        tfRespons.setForeground(Color.red);
                    }
                    tfRespons.setText(response.toString());
                }catch (NumberFormatException ex){
                    tfRespons.setForeground(Color.red);
                    tfRespons.setText("Invalid details (salary should be in numbers!)");
                }
            }
        });

        btnGetAllByName.setBorder(new EmptyBorder(10,10,10,10));
        btnGetAllByName.setBackground(Color.RED);
        btnGetAllByName.setBounds(650,120, 190,50);
        btnGetAllByName.setFont(new Font("MB Boli", Font.BOLD, 22));
        btnGetAllByName.setForeground(new Color(25,25,25));
        btnGetAllByName.setFocusable(false);
        btnGetAllByName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder response = new StringBuilder();
                List<Employee> employess = client.getAllByName(tfName.getText());
                if(employess.size() == 0 ){
                    tfRespons.setForeground(Color.red);
                    tfRespons.setText("No such Employees with the name: \"" + tfName.getText() + "\"");
                }else {
                    for(Object obj : employess){
                        response.append(obj.toString()).append('\n');
                    }
                    tfRespons.setForeground(Color.white);
                    tfRespons.setText(response.toString());
                }
            }
        });
    }
    private void initializePanel(){
        panel = new JPanel();
        panel.setSize(WIDTH,HEIGHT);
        panel.setBackground(new Color(25,25,25));
        panel.setLayout(null);

        panel.add(lbId);
        panel.add(lbName);
        panel.add(lbSalary);
        panel.add(tfId);
        panel.add(tfName);
        panel.add(tfSalary);
        panel.add(tfRespons);
        panel.add(btnAdd);
        panel.add(btnGet);
        panel.add(btnGetAll);
        panel.add(btnGetAllByName);
        panel.add(btnGetAllByName);
        panel.add(lbJob1);
        panel.add(lbJob2);
        panel.add(lbJob3);
        panel.add(tfJob1);
        panel.add(tfJob2);
        panel.add(tfJob3);
    }


    public static void main(String[] args) {
        ClinetGui clientGui = new ClinetGui();

    }
}
