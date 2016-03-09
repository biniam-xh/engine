/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.InputOutputModule;

import com.icog.yanetu.stt_tts.MediaPackage;
import com.icog.yanetu.stt_tts.TextPackage;

/**
 *
 * @author biniam
 */
public class Test {
    
    public static void main(String[] args) {
        // TODO code application logic here
        //new Test().languageTest("dictionary $^^86 filter 56651 jaca dfgdf test ");
        MediaPackage mediaPackage = new TextPackage("sdklf hey 32435 man jedffl33");       
        new Test().responceTest(mediaPackage);
    }
    public void responceTest(MediaPackage mediaPackage){
        
        InputReceiver receiver = InputReceiver.getInstance();
        ResultProvider provider = receiver.handleInput(mediaPackage);
        MediaPackage pac = provider.getResult();
        
        if(pac.getClass().isInstance(new TextPackage())){
           
           System.out.println("input media package type: TextPackage");
           System.out.println("--------------------------------------");
           System.out.println(" output text: "+((TextPackage)pac).getTextString()); 
           System.out.println("--------------------------------------");
           
        }
        
    }
    public void languageTest(String input){
        QueryBuilder builder = new QueryBuilder();
        builder.checkLanguage(input);
        
        System.out.println("input text filter test based on american-english dictionary");
        System.out.println("-----------------------------------------");
        System.out.println("input text: "+ builder.getInputText());
        System.out.println("output text: "+ builder.getProcessedInput());
        System.out.println("invalid strings text: "+ builder.getInvalidStrings());
        System.out.println("-----------------------------------------");
    }
    public void printResult(QueryBuilder builder){
        System.out.println("input text filter test based on american-english dictionary");
        System.out.println("-----------------------------------------");
        System.out.println("input text: "+ builder.getInputText());
        System.out.println("output text: "+ builder.getProcessedInput());
        System.out.println("invalid strings text: "+ builder.getInvalidStrings());
        System.out.println("-----------------------------------------");
    }
}
