/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.InputOutputModule;

import com.icog.yanetu.stt_tts.AudioPackage;
import com.icog.yanetu.stt_tts.MediaConverter;
import com.icog.yanetu.stt_tts.MediaPackage;
import com.icog.yanetu.stt_tts.TextPackage;

/**
 *
 * @author biniam
 */
public class InputProcessor{
    
    private MediaPackage input;
    private MediaPackage output;
    private QueryBuilder builder;
    private String query;
    private ResultProvider provider;
    private InputReceiver receiver = InputReceiver.getInstance();
    
    
    InputProcessor(){
        builder = new QueryBuilder();
    }
    /*
    uses TTS and STT modules to convert mediaPackages
    */
    public MediaPackage convertInput(MediaPackage mediaPackage , MediaConverter converter){
        
        MediaPackage media =  converter.convertInput(mediaPackage);
        return media;
    }
    /*
    retrives answer from chat script
    */
    public MediaPackage getAnswer(String query){
        return null;
    }
    /*
    processes the mediaPackage input
    */
    public void processInput(MediaPackage mediaPackage , MediaConverter converter){
        if (mediaPackage.getClass().isInstance(new TextPackage())) {
            
            builder.checkLanguage(((TextPackage)mediaPackage).getTextString());
            MediaPackage media = new TextPackage(builder.getProcessedInput());
            setOutput(media);
            //adds input-output pair to resultQueue of receiver
            receiver.getResultQueue().put(mediaPackage, media);
            
        } else if (mediaPackage.getClass().isInstance(new AudioPackage())) {
            
            TextPackage text = (TextPackage)convertInput(mediaPackage, converter);
            builder.checkLanguage(text.getTextString());
            MediaPackage media = new TextPackage(builder.getProcessedInput());
            setOutput(media);
            //adds input-output pair to resultQueue of receiver
            receiver.getResultQueue().put(mediaPackage, (MediaPackage)text);
        }
    }
    
    /**
     * @return the output
     */
    public MediaPackage getOutput() {
        return output;
    }

    /**
     * @param output the output to set
     */
    public void setOutput(MediaPackage output) {
        this.output = output;
    }

    
    
}
