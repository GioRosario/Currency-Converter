/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyconverter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import javafx.stage.Stage;

/**
 *
 * @author John
 */
public class CurrencyConverter extends Application {
    
    @Override
    public void start(Stage primaryStage){      
        GridPane root = new GridPane();
        root.setStyle("-fx-padding: 10 0 0 40");
        
        // Create title and set font
        Text title = new Text();
        title.setText("Currency Converter");
        title.setFill(Color.web("7B70BD"));
        title.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        root.add(title,0,0); // add title to root
        
        // Create labels
        // Hbox for labels
        HBox labelRow = new HBox();
        labelRow.setStyle("-fx-padding: 20 0 0 0");
        
        // Labels
        Text amountLabel = new Text();
        amountLabel.setText("Convert this amount:   ");
        
        Text fromCurrencyLabel = new Text();
        fromCurrencyLabel.setText("From this currency:           ");
        
        Text toCurrencyLabel = new Text();
        toCurrencyLabel.setText("To this currency: ");
        
        // add labels and hbox to root
        labelRow.getChildren().addAll(amountLabel, fromCurrencyLabel, toCurrencyLabel);
        root.add(labelRow,0,1);
        
        // Create text field and dropdowns
        HBox convertCurrency = new HBox(7);
        
        TextField amount = new TextField("1");
        amount.setPrefWidth(112);
                       
        ComboBox fromCurrency = new ComboBox();
        fromCurrency.getItems().addAll("Australian Dollar", "Euro", "Philippine Peso",
                                    "Thai Baht", "US Dollar"); 
        fromCurrency.getSelectionModel().selectLast();
        
        ComboBox toCurrency = new ComboBox();
        toCurrency.getItems().addAll("Australian Dollar", "Euro", "Philippine Peso",
                                    "Thai Baht", "US Dollar");
        toCurrency.getSelectionModel().selectFirst();
        
        // Add to Hbox and root
        convertCurrency.getChildren().addAll(amount, fromCurrency, toCurrency);
        root.add(convertCurrency,0,2);
        
        // Result text and textbox
        HBox resultBox = new HBox(5);
        resultBox.setStyle("-fx-padding: 50 0 0 120");
        Text result = new Text();
        result.setText("Result");
        result.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        
        TextField finalExchange = new TextField();
        finalExchange.setPrefWidth(100);
        
        resultBox.getChildren().addAll(result, finalExchange);
        root.add(resultBox, 0, 3);
        
        // Create buttons
        HBox btnBox = new HBox(10);
        btnBox.setStyle("-fx-padding: 30 0 0 225");
                
        Button btnConvert = new Button();
        btnConvert.setText("Convert");
        btnConvert.setPrefWidth(70);
        btnConvert.setPrefHeight(30);
        
        Button btnClose = new Button();
        btnClose.setText("Close");
        btnClose.setPrefWidth(70);
        btnClose.setPrefHeight(30);
        
        btnBox.getChildren().addAll(btnConvert, btnClose);
        root.add(btnBox, 0, 4);
        
        // btnConvert functionality
        btnConvert.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                String x = amount.getText();
                try {
                    double calc = Integer.parseInt(x);
                    
                    if (calc >= 0){
                        if (fromCurrency.getValue() == "Australian Dollar" && toCurrency.getValue() == "Euro"){
                            calc *= 0.66;
                        } else if (fromCurrency.getValue() == "Australian Dollar" && toCurrency.getValue() == "Philippine Peso"){
                            calc *= 37.21;
                        } else if (fromCurrency.getValue() == "Australian Dollar" && toCurrency.getValue() == "Thai Baht"){
                            calc *= 24.42;
                        } else if (fromCurrency.getValue() == "Australian Dollar" && toCurrency.getValue() == "US Dollar"){
                            calc *= 0.69;
                        } else if (fromCurrency.getValue() == "Euro" && toCurrency.getValue() == "Australian Dollar"){
                            calc *= 37.21; 
                        } else if (fromCurrency.getValue() == "Euro" && toCurrency.getValue() == "Philippine Peso"){
                            calc *= 1.51;
                        } else if (fromCurrency.getValue() == "Euro" && toCurrency.getValue() == "Thai Baht"){
                            calc *= 36.96;
                        } else if (fromCurrency.getValue() == "Euro" && toCurrency.getValue() == "US Dollar"){
                            calc *= 1.05;
                        } else if (fromCurrency.getValue() == "Philippine Peso" && toCurrency.getValue() == "Australian Dollar"){
                            calc *= 0.027;
                        } else if (fromCurrency.getValue() == "Philippine Peso" && toCurrency.getValue() == "Euro"){
                            calc *= 0.018;
                        } else if (fromCurrency.getValue() == "Philippine Peso" && toCurrency.getValue() == "Thai Baht"){
                            calc *= 0.66;
                        } else if (fromCurrency.getValue() == "Philippine Peso" && toCurrency.getValue() == "US Dollar"){
                            calc *= 0.018;
                        } else if (fromCurrency.getValue() == "Thai Baht" && toCurrency.getValue() == "Australian Dollar"){
                            calc *= 0.041;
                        } else if (fromCurrency.getValue() == "Thai Baht" && toCurrency.getValue() == "Euro"){
                            calc *= 0.027;
                        } else if (fromCurrency.getValue() == "Thai Baht" && toCurrency.getValue() == "Philippine Peso"){
                            calc *= 1.52; 
                        } else if (fromCurrency.getValue() == "Thai Baht" && toCurrency.getValue() == "US Dollar"){
                            calc *= 0.028;
                        } else if (fromCurrency.getValue() == "US Dollar" && toCurrency.getValue() == "Australian Dollar"){
                            calc *= 1.44;
                        } else if (fromCurrency.getValue() == "US Dollar" && toCurrency.getValue() == "Euro"){
                            calc *= 0.95;
                        } else if (fromCurrency.getValue() == "US Dollar" && toCurrency.getValue() == "Philippine Peso"){
                            calc *= 53.76; 
                        } else if (fromCurrency.getValue() == "US Dollar" && toCurrency.getValue() == "Thai Baht"){
                            calc *= 35.28; 
                        } else {
                            calc *= 1;
                        }
                        String conv = String.valueOf(String.format("%.2f", calc));
                        finalExchange.setText(conv);
                    } else{
                        finalExchange.setText("Error!");
                    }
                } catch(Exception e){
                    finalExchange.setText("Error!");
                }
            }
        });
        
        // btnClose functionality
        btnClose.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) btnClose.getScene().getWindow();
                stage.close();
            }
        });
        
        // Create scene
        Scene scene = new Scene(root, 500, 250);
        scene.setFill(Color.web("#eaeaea")); // set background color
        
        primaryStage.setTitle("Currency Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
