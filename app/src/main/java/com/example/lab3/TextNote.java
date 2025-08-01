package com.example.lab3;

public class TextNote extends Note{
    //Attribute
    String textContent;

    //Getter method
    public String getTextContent(){
        return textContent;
    }
    //Setter method
    public void setTextContent(String inputText){
        this.textContent = inputText;
    }

    @Override
    void display() {
        System.out.println(title + ":" + textContent + "(" + dateCreated + ")");
    }
}
