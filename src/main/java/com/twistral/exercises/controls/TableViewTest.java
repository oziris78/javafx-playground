package com.twistral.exercises.controls;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Locale;


public class TableViewTest extends Application {

    TextField tfFullName;
    TextField tfAge;
    TextField tfGender;
    TextField tfNetWorth;

    static enum Gender{ MALE, FEMALE }

    public static class Person{
        String fullName;
        int age;
        Gender gender;
        double netWorth;
        Person(String fullName, int age, Gender gender, double netWorth){
            this.fullName = fullName; this.age = age; this.gender = gender; this.netWorth = netWorth;
        }
        public String getFullName() { return fullName; }
        public void setFullName(String fullName) { this.fullName = fullName; }
        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }
        public Gender getGender() { return gender; }
        public void setGender(Gender gender) { this.gender = gender; }
        public double getNetWorth() { return netWorth; }
        public void setNetWorth(double netWorth) { this.netWorth = netWorth; }
    }

    public void start(Stage stage) {
        VBox pane = new VBox();

        // get the data
        ObservableList<Person> people = FXCollections.observableArrayList(
            new Person("Oguzhan Topaloglu", 20, Gender.MALE, 0d),
            new Person("Yunus Emre Cay", 20, Gender.MALE, 99999d),
            new Person("Charlie Cox", 40, Gender.MALE, 9999d),
            new Person("Merve Kacmaz", 22, Gender.FEMALE, 50000d),
            new Person("Jennifer Aniston", 52, Gender.FEMALE, 5165d)
        );

        // create the table and then the columns
        TableView<Person> tableView = new TableView<>();

        TableColumn<Person, String> fullNameColumn = new TableColumn<>("FullName");
        fullNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName")); // needs to be same as the field name
        fullNameColumn.setMinWidth(200d);

        TableColumn<Person, String> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age")); // needs to be same as the field name
        ageColumn.setMinWidth(100d);

        TableColumn<Person, String> genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender")); // needs to be same as the field name
        genderColumn.setMinWidth(100d);

        TableColumn<Person, String> netWorthColumn = new TableColumn<>("Net Worth");
        netWorthColumn.setCellValueFactory(new PropertyValueFactory<>("netWorth")); // needs to be same as the field name
        netWorthColumn.setMinWidth(100d);

        tableView.setItems(people);
        tableView.getColumns().addAll(fullNameColumn, ageColumn, genderColumn, netWorthColumn);

        // adding and deleting
        HBox hBox = new HBox();
        tfFullName = new TextField();
        tfFullName.setPromptText("Full Name");
        tfAge = new TextField();
        tfAge.setPromptText("Age");
        tfGender = new TextField();
        tfGender.setPromptText("Gender");
        tfNetWorth = new TextField();
        tfNetWorth.setPromptText("Net Worth");
        Button btnAdd = new Button("ADD");
        btnAdd.setOnAction(e -> {
            people.add(new Person(
               tfFullName.getText(), Integer.parseInt(tfAge.getText()),
               tfGender.getText().toLowerCase(Locale.ROOT).startsWith("m") ? Gender.MALE : Gender.FEMALE,
                Double.parseDouble(tfNetWorth.getText())
            ));
        });
        Button btnDelete = new Button("DELETE");
        btnDelete.setOnAction(e -> {
            Person selectedPerson = tableView.getSelectionModel().getSelectedItem();
            people.remove(selectedPerson);
        });
        hBox.getChildren().addAll(tfFullName, tfAge, tfGender, tfNetWorth, btnAdd, btnDelete);
        for(Node child : hBox.getChildren()) HBox.setMargin(child, new Insets(15));

        pane.getChildren().addAll(tableView, hBox);

        for(Node child : pane.getChildren()) VBox.setMargin(child, new Insets(15));
        pane.setPadding(new Insets(15));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }


}