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

    String display()
    {return title+":"+textContent+"("+dateCreated+")";}
}
