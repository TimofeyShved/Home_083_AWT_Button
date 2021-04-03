package com.AWT;

import java.awt.*;
import java.awt.event.*;

public class Main {

    // создаем в классе пееменные
    private Frame mainFrame; // фрайм и 2 метки (лэйблы)
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel; // панель

    public Main(){ // ----------------------------------------- конструктор для нашего класса
        prepareGUI(); // и вызываемый метод prepareGUI
    }

    public static void main(String[] args){
        Main  myMainClass = new Main(); // создание наешого основного класса
        myMainClass.showButtonDemo(); // и вызываемый метод showLabelDemo
    }

    // ----------------------------------------------------- описывает основное визуальное отображение
    private void prepareGUI(){
        mainFrame = new Frame("Java AWT Button"); // инициализация фрэйма
        mainFrame.setSize(400,400);// размеры
        mainFrame.setLayout(new GridLayout(3, 1)); // расположение объектов на форме

        mainFrame.addWindowListener(new WindowAdapter() { // обработка событий
            public void windowClosing(WindowEvent windowEvent){ // принажатии на кнопку "Закрыть"
                System.exit(0);
            }
        });

        // метки
        headerLabel = new Label(); // инициализация
        headerLabel.setAlignment(Label.CENTER); // в центре
        statusLabel = new Label(); // инициализация
        statusLabel.setAlignment(Label.CENTER);// в центре
        statusLabel.setSize(350,100); // размеры

        controlPanel = new Panel(); // новая панель
        controlPanel.setLayout(new FlowLayout()); // расположение объектов на форме (лайаут)

        // добавление объектов на форму
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);  // видимость формы true
    }

    //----------------------------------------------------- Что будет в кнопках
    private void showButtonDemo(){
        headerLabel.setText("Контрол в действии: Button");

        // создание кнопок
        Button okButton = new Button("OK");
        Button submitButton = new Button("Submit");
        Button cancelButton = new Button("Cancel");

        // ------------------------------- действие при нажатии на кнопку
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { // нажатие на кнопку
                statusLabel.setText("Ok - кнопка нажата"); // изменить текст статуса
            }
        });

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { // нажатие на кнопку
                statusLabel.setText("Submit - кнопка нажата");
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { // нажатие на кнопку
                statusLabel.setText("Cancel - кнопка нажата");
            }
        });

        // добавить на панель
        controlPanel.add(okButton);
        controlPanel.add(submitButton);
        controlPanel.add(cancelButton);

        statusLabel.setText("Контрол в действии: Label (statusLabel)");

        mainFrame.setVisible(true);
    }
}
