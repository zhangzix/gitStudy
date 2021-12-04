package experiment;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * 实验8 图形用户界面设计
 */
public class example8 {
    public static void main(String[] args) {
        JFrame frame = new Test1JFrame();
    }
}

/**
 * 1、算数运算
 * 编写一个应用程序，设计一个窗体，其中有4个按钮，分别命名为 “ 加”、“减”、“乘”、“除”，
 * 以及3个文本框，单击相应的按钮，将两个文本框的数字做算术运算，在第3个文本框中显示结果。
 * 要求处理NumberFormatException。
 */
class Test1JFrame extends JFrame {
    JPanel panelBtn = new JPanel();
    JPanel panelText = new JPanel();
    JButton btnAdd = new JButton("＋");//加
    JButton btnSub = new JButton("－");//减
    JButton btnMui = new JButton("×");//乘
    JButton btnDiv = new JButton("÷");//除
    JTextField text1 = new JTextField(10);
    JTextField text2 = new JTextField(10);
    JTextField JTextRes = new JTextField(10);

    public String formatString(double value) {
        return String.format("%.3f", value).toString();
    }

    public void getNum(char type) {
        double Res = 0.0;
        try {
            double num1 = Double.parseDouble(text1.getText());
            double num2 = Double.parseDouble(text2.getText());
            switch (type) {
                case '＋':Res = num1 + num2;break;
                case '－':Res = num1 - num2;break;
                case '×': Res = num1 * num2;break;
                case '÷': Res = num1 / num2;break;
                default: throw new Exception("出现未知算法");
            }
            JTextRes.setText(formatString(Res));
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException异常");
            JOptionPane.showMessageDialog(panelText, "请输入数字", "警告", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Test1JFrame() {
        this.setTitle("算数运算");
        this.setSize(500, 500);
        setLayout(new BorderLayout(20, 30));
        add(panelBtn, BorderLayout.NORTH);
        panelBtn.add(btnAdd);
        panelBtn.add(btnSub);
        panelBtn.add(btnMui);
        panelBtn.add(btnDiv);
        add(panelText, BorderLayout.CENTER);
        panelText.add(text1);
        panelText.add(text2);
        panelText.add(JTextRes);
        setVisible(true);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        btnAdd.addActionListener(new MyAction());
        btnSub.addActionListener(new MyAction());
        btnMui.addActionListener(new MyAction());
        btnDiv.addActionListener(new MyAction());
    }
    class MyAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            getNum(e.getActionCommand().charAt(0));
        }
    }
}

/**
 * 2、算术测试
 * 实验要求：编写一个算术测试小软件，用来训练小学生的算术能力。
 * 其中两个操作数及运算符都是在点击获取题目时随机生成。
 */
class Test2JFrame extends JFrame {
    String[] arr = {"＋", "－", "×", "÷"};
    JPanel panel = new JPanel();
    Random random = new Random();
    JButton btnGet = new JButton("获取题目");//加
    JButton btnSubmit = new JButton("确认答案");//除
    JTextField text1 = new JTextField(10);
    JTextField text2 = new JTextField(10);
    JTextField JTextRes = new JTextField(15);
    JLabel operator = new JLabel(" ? ");
    JLabel Info = new JLabel();
    int num1;int num2;
    public Test2JFrame() {
        setTitle("算数测试");
        setSize(600, 160);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panel);
        panel.add(btnGet);
        panel.add(text1);
        panel.add(operator);
        panel.add(text2);
        panel.add(new JLabel("="));
        Font font = new Font("黑体", Font.PLAIN, 20);
        text1.setFont(font);
        text2.setFont(font);
        text1.setBackground(Color.lightGray);
        text2.setBackground(Color.lightGray);
        text1.setCaretColor(Color.BLACK);
        text2.setCaretColor(Color.BLACK);
        panel.add(JTextRes);
        panel.add(btnSubmit);
        panel.add(Info);
        operator.setFont(new Font("黑体",Font.BOLD,20));
        panel.repaint();
        btnGet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = random.nextInt(100);
                text1.setText(num1 + "");
                num2 = random.nextInt(100);
                text2.setText(num2 + "");
                operator.setText(arr[random.nextInt(arr.length)]);
            }
        });
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int tRes = Integer.parseInt(JTextRes.getText());
                    int res=0;
                    switch (operator.getText()) {
                        case "＋": res = num1 + num2;break;
                        case "－":res = num1 - num2;break;
                        case "×": res = num1 * num2;break;
                        case "÷":res = num1 / num2;break;
                    }
                    if (res == tRes) Info.setText("恭喜你，答对了！");
                    else Info.setText("抱歉，您答错了！" + res);
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(panel, "请输入数字", "警告", JOptionPane.WARNING_MESSAGE);
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });
    }
}

/**
 * 3、编写一个应用程序，设计一个窗体，布局为BorderLayout，北面添加一个Choice组件，
 * 该组件有4个课程名称的选项。中心添加一个文本区，
 * 当选择Choice组件中的某个选项后，文本区显示对该课程的介绍。
 */
class Test3JFrame extends JFrame {
    Choice choice = new Choice();
    JTextArea textArea = new JTextArea();
    String[] Courses = {"Language", "Maths", "English", "IT"};

    public Test3JFrame() {
        setTitle("第三题 JFrame");
        setSize(350, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(choice, BorderLayout.NORTH);
        choice.setFont(new Font("黑体", Font.BOLD, 16));
        textArea.setFont(new Font("黑体", Font.PLAIN, 20));
        textArea.setAlignmentX(CENTER_ALIGNMENT);
        textArea.setAlignmentY(CENTER_ALIGNMENT);
        add(textArea, BorderLayout.CENTER);
        for (int i = 0; i < Courses.length; i++) {
            choice.add(Courses[i]);
        }
        choice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                textArea.setText("\n\t简介:这是课程" + e.getItem().toString());
            }
        });


    }
}

/**
 * 4、编写一个有两个文本区的小应用程序,当一个文本区中输入若干个数时,
 * 另一个文本区同时对所输入的数进行求和运算并求出平均值,也就是说随着输入的变化,
 * 另一个文本区不断地更新求和及平均值。
 */
class Test4JFrame extends JFrame {
    double Avg = 0;
    double Sum = 0;
    int count = 0;
    JTextArea text1 = new JTextArea(10, 20);
    JTextArea text2 = new JTextArea(8, 20);
    JPanel panel = new JPanel();

    public Test4JFrame() {
        setTitle("第四题");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        add(panel, BorderLayout.CENTER);
        panel.add(text1);
        text1.setLineWrap(true);
        text2.setLineWrap(true);
        panel.add(text2);
        text1.setFont(new Font("黑体", Font.BOLD, 20));
        text2.setFont(new Font("黑体", Font.BOLD, 20));
        text2.setBackground(Color.lightGray);
        text1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                Action();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                Action();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }

    public String formatString(double value) {
        return String.format("%.2f", value).toString();
    }

    public void Action() {
        Sum = 0;
        count = 0;
        String lines = text1.getText();
        String replace = lines.replaceAll(",", " ").replaceAll("，", " ");
        String[] s = replace.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (null != s[i] && !"".equals(s[i])) {
                Sum += Double.parseDouble(s[i]);
                count++;
            }
        }
        text2.setText("总和：" + Sum + "\n平均值：" + formatString(Sum / count) + "\n数字个数：" + count);
    }
}

/**
 * 5*、编写一个应用程序，有一个Frame窗口，窗口的中心添加了一个文本区。
 * 该窗口中有有4个菜单。每个菜单里都有菜单项，每个菜单项都对应有快捷键，
 * 选择某个菜单项时窗口中心的文本区显示某些信息。
 */
class Test5JFrame extends JFrame {
    JMenuBar jmb = new JMenuBar();// 菜单栏对象
    JMenu fileMenu = new JMenu("File");
    JMenu editMenu = new JMenu("Edit");
    JMenu runMenu = new JMenu("Run");
    JMenu helpMenu = new JMenu("Help");
    Font font = new Font("黑体", Font.BOLD, 20);
    JTextArea textArea = new JTextArea("", 20, 20);
    JMenuItem newItem = new JMenuItem("New");
    JMenuItem openItem = new JMenuItem("Open");
    JMenuItem copyItem = new JMenuItem("Copy");
    JMenuItem pasteItem = new JMenuItem("Paste");
    JMenuItem runItem = new JMenuItem("Run");
    JMenuItem debugItem = new JMenuItem("Debug");
    JMenuItem helpItem = new JMenuItem("Help");
    JMenuItem aboutItem = new JMenuItem("About");
    Font itemFont = new Font("黑体", Font.BOLD, 16);

    public Test5JFrame() {
        setTitle("实验8 第五题");
        setSize(500, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(jmb, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);
        textArea.setFont(font);
        textArea.setBackground(Color.GRAY);

        jmb.add(fileMenu);
        jmb.add(editMenu);
        jmb.add(runMenu);
        jmb.add(helpMenu);
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        runMenu.add(runItem);
        runMenu.add(debugItem);
        helpMenu.add(helpItem);
        helpMenu.add(aboutItem);

        newItem.setAccelerator(KeyStroke.getKeyStroke('N', Event.CTRL_MASK));
        openItem.setAccelerator(KeyStroke.getKeyStroke('O', Event.CTRL_MASK));
        copyItem.setAccelerator(KeyStroke.getKeyStroke('C', Event.CTRL_MASK));
        pasteItem.setAccelerator(KeyStroke.getKeyStroke('V', Event.CTRL_MASK));
        runItem.setAccelerator(KeyStroke.getKeyStroke('R', Event.CTRL_MASK));
        debugItem.setAccelerator(KeyStroke.getKeyStroke('D', Event.CTRL_MASK));
        helpItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));


        for (int i = 0; i < jmb.getMenuCount(); i++) {
            JMenu menu = jmb.getMenu(i);
            menu.setFont(font);
            for (int j = 0; j < menu.getItemCount(); j++) {
                JMenuItem item = menu.getItem(j);
                item.setFont(itemFont);
                item.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textArea.setText("\n\t这是菜单" + menu.getText() + "中菜单项为" + item.getText() + "\n\t快捷键为：" + item.getAccelerator());
                    }
                });
            }
        }

    }
}