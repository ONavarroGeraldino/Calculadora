/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package calculadora;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import jdk.nashorn.internal.runtime.ParserException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import jdk.nashorn.internal.runtime.ParserException;

/**
 *
 * @author Latitude-3500
 */
public class viewController{
    @FXML
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,bnt0,btnClean,btnDelete,btnPorcentage,btnDivision,btnMultiplication,btnAddition,btnSubtraction,btnEqual,btnAns,btnpoint;
    @FXML
    private TextField txtNumeros;
    @FXML
    private Pane panelBackgroud,paneOperations;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private Tab tabOperations;
    @FXML
    private Boolean operationOn = true;
    private double lastOperation = 0;
    
    
    public void cleanScrean(){
   
    txtNumeros.setText("");
    operationOn = true;    
    }
    public void delete(){
        if(!(txtNumeros.getText().length() == 0)){
            txtNumeros.setText(txtNumeros.getText().substring(0, txtNumeros.getText().length() - 1 ));
        
        }
        
        
    }
    
    public void nakeOperation(){
    
    String operationS = txtNumeros.getText();

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        try {
            Object operation = engine.eval(txtNumeros.getText().replaceAll("x", "*"));
            txtNumeros.setText("" + operation);
            lastOperation = Double.parseDouble(txtNumeros.getText());
        } catch (ScriptException | ParserException e) {
            txtNumeros.setText("");
        }
    }
    public void getLastOperation(){
    
       if(!(lastOperation == 0)){
           txtNumeros.setText(txtNumeros.getText() + lastOperation);
       
       }
    }
    
   @FXML
    public void addOperation(ActionEvent event) {
        if(operationOn){
            txtNumeros.setText(txtNumeros.getText() + ((Button)event.getSource()).getText() );
            operationOn = false;
        }
    }

    @FXML
    public void addValue(ActionEvent event) {
        txtNumeros.setText(txtNumeros.getText() + ((Button)event.getSource()).getText());
        operationOn = true;
    }

  
    @FXML
    private void changeColor(ActionEvent event) {
        String n = colorPicker.getValue().toString().substring(2, colorPicker.getValue().toString().length() - 2);
        paneOperations.setStyle("-fx-background-color: #" + n);
        panelBackgroud.setStyle("-fx-background-color: #" + n);
        tabOperations.setStyle("-fx-background-color: #"+ n);
    }
     
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    */

    

