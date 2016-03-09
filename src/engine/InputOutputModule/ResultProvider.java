/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.InputOutputModule;

import com.icog.yanetu.stt_tts.MediaPackage;
import com.icog.yanetu.stt_tts.TextPackage;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author biniam
 */
public class ResultProvider {
    //private MediaPackage currentInput;
    private MediaPackage currentOutput;
    
    ResultProvider(MediaPackage output){
        //currentInput = input;
        currentOutput = output;
    }
    /*
    public void getConvertedText(TextPackage text){
       JOptionPane.showMessageDialog(null, "Converted text: "+text);
       
    }
    public void getConvertedAudio(){
        
    }
    */
    public MediaPackage getResult(){
        return currentOutput;
    }
}