/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.InputModule;

//
import com.icog.yanetu.stt_tts.MediaConverter;
import com.icog.yanetu.stt_tts.MediaPackage;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 *
 * @author biniam
 */
public class InputReceiver {
    private ArrayList<MediaPackage> inputQueue;
    private LinkedHashMap resultQueue;
    private static InputReceiver receiver  = null;
    private MediaConverter converter;
    
    private InputReceiver(){
       inputQueue = new ArrayList();
       resultQueue = new LinkedHashMap();
       converter = new MediaConverter();
       
    }
    
    public static InputReceiver getInstance(){
        if(receiver == null){
            receiver = new InputReceiver();
        }
            return receiver;
        
    }
    /*
    add every input package in queue to be processed
    dictionary filter test 
    */
    public ResultProvider handleInput(MediaPackage mediaPackage){      
        getInputQueue().add(mediaPackage);
        return processInput(mediaPackage);
    }
    
    /*
    processes every input package in the queue.
    */
    public ResultProvider processInput(MediaPackage mediaPackage){
        InputProcessor processor = new InputProcessor();
        processor.processInput(mediaPackage, converter);
        ResultProvider provider = new ResultProvider(processor.getOutput());
        return provider;
    }

    /**
     * @return the inputQueue
     */
    public ArrayList<MediaPackage> getInputQueue() {
        return inputQueue;
    }

    /**
     * @return the resultQueue
     */
    public LinkedHashMap getResultQueue() {
        return resultQueue;
    }
}
