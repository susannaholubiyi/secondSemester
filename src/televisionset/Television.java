package televisionset;

import java.util.ArrayList;

public class Television {

    private boolean isOn;
    private int volume;
    private int numberOfChannel;
    private ArrayList<String> channels;

    public Television(){
        channels = new ArrayList<> ();
        volume = 0;
    }

    public boolean isOn() {
        return isOn;
    }

    public void toggle() {
        isOn = !isOn;
    }

    public int getVolume() {
        return volume;
    }



    public int increaseButton() {
        if(isOn)
            if(volume < 100)
                return volume ++;
            else
                return volume;
        else
            return volume;
    }

    public int decreaseButton(){
        if(isOn)
            if(volume > 0)
                return volume --;
            else
                return volume;
        else
            return volume;
    }

    public void  addChannel(){
        if(isOn){
            numberOfChannel ++;
            channels.add("Channel " + numberOfChannel);
        }

    }

    public ArrayList<String> getChannels() {
        if(isOn) {
            return channels;
        }
        else
            return null;
    }



    public String changeChannelForward(){
        if (isOn ){

        }
        return null;
    }

    public ArrayList<String> viewChannels(){
        if(!isOn ) return null;

        else
            return channels;




    }
}
