/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.InputModule;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author biniam
 */
public class QueryBuilder {
    
    private ArrayList<String> validWords = new ArrayList();
    private ArrayList<String> invalidString = new ArrayList();
    private ArrayList<String> wordList = new ArrayList();
    
    private String[] splited;
    private String inputText = "";
    private String processedInput = "";
    private String regex = "[^A-Za-z']+";
    
    public static boolean check_for_word(String word) {
        // System.out.println(word);
     
        try {
            BufferedReader in = new BufferedReader(new FileReader(
                    "dictionary/american-english"));
            String str;
            while ((str = in.readLine()) != null) {
                if (str.indexOf(word) != -1) {
                    return true;
                }
            }
            in.close();
        } catch (IOException e) {
        }

        return false;
    }
    
    public void checkLanguage(String inputString){
        extract(inputString);
        
        for(int i=0; i< splited.length; i++){
            String str = splited[i].replaceAll(regex, "");
            if(str.length()!=0 && check_for_word(str)){
                getValidWords().add(str);
            }      
        }
        for(String s: validWords){
            setProcessedInput(getProcessedInput() + (s+" "));
        }
        getProcessedInput().trim();
        setInvalidStrings();
     
    }
    public void extract(String inputString){
        //extracted
        this.setInputText(inputString);
        this.splited = inputString.split("\\s+");
        String[] valid = new String[inputString.length()];
        
        for(String s: splited){
            getWordList().add(s);
        }
       
    }

    /**
     * @return the validWords
     */
    public ArrayList<String> getValidWords() {
        return validWords;
    }

    /**
     * @param validWords the validWords to set
     */
    public void setValidWords(ArrayList<String> validWords) {
        this.validWords = validWords;
    }

    /**
     * @return the invalidString
     */
    public ArrayList<String> getInvalidStrings() {
        return invalidString;
    }

    /**
     * @param invalidString the invalidString to set
     */
    public void setInvalidStrings() {
       for(String s: splited){
            if(!validWords.contains(s)){
                getInvalidStrings().add(s);
            }
        }
    }

    /**
     * @return the wordList
     */
    public ArrayList<String> getWordList() {
        return wordList;
    }

    /**
     * @param wordList the wordList to set
     */
    public void setWordList(ArrayList<String> wordList) {
        this.wordList = wordList;
    }

    /**
     * @return the inputText
     */
    public String getInputText() {
        return inputText;
    }

    /**
     * @param inputText the inputText to set
     */
    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    /**
     * @return the processedInput
     */
    public String getProcessedInput() {
        return processedInput;
    }

    /**
     * @param processedInput the processedInput to set
     */
    public void setProcessedInput(String processedInput) {
        this.processedInput = processedInput;
    }
    
    
    }
    

