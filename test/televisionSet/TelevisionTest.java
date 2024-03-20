package televisionSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import televisionset.Television;

import static org.junit.jupiter.api.Assertions.*;

public class TelevisionTest {

    private Television myTelevision;

    @BeforeEach
    public void initializeTv (){
        myTelevision = new Television();
    }

    @Test
    public void turnTvOn_TvComesOnTest(){
        assertFalse(myTelevision.isOn());
        myTelevision.toggle();

        assertTrue(myTelevision.isOn());
    }

    @Test
    public void turnTvOff_tvGoesOffTest(){
        assertFalse(myTelevision.isOn());
        myTelevision.toggle();
        assertTrue(myTelevision.isOn());

        myTelevision.toggle();
        assertFalse(myTelevision.isOn());
    }

    @Test
    public void increaseTvVolume_tvVolumeIncreasesTest(){
        assertFalse(myTelevision.isOn());
        myTelevision.toggle();
        assertTrue(myTelevision.isOn());

        myTelevision.increaseButton();
        assertEquals(1, myTelevision.getVolume());

    }

    @Test
    public void decreaseTvVolume_tvVolumeDecreasesTest(){
        assertFalse(myTelevision.isOn());
        myTelevision.toggle();
        assertTrue(myTelevision.isOn());
        myTelevision.increaseButton();
        assertEquals(1, myTelevision.getVolume());

        myTelevision.decreaseButton();
        assertEquals(0,myTelevision.getVolume());
    }

    @Test
    public void increaseVolumeWhenTvIsOff_volumeDoesNotIncreaseTest(){
        assertFalse(myTelevision.isOn());

        myTelevision.increaseButton();

        assertEquals(0,myTelevision.getVolume());
    }

    @Test
    public void decreaseVolumeWhenTvIsOff_volumeDoesNotDecreaseTest(){
        assertFalse(myTelevision.isOn());

        myTelevision.increaseButton();

        assertEquals(0,myTelevision.getVolume());
    }

    @Test
    public void pressIncreaseButtonFiveTimes_volumeIncreasesFiveTimesTest(){
        assertFalse(myTelevision.isOn());
        myTelevision.toggle();
        assertTrue(myTelevision.isOn());

        for(int count = 0; count < 5; count++){
            myTelevision.increaseButton();
        }
        assertEquals(5, myTelevision.getVolume());
    }

    @Test
    public void pressDecreaseButtonFiveTimes_volumeDecreasesFiveTimesTest(){
        assertFalse(myTelevision.isOn());
        myTelevision.toggle();
        assertTrue(myTelevision.isOn());

        for(int count = 0; count < 5; count++){
            myTelevision.increaseButton();
        }
        assertEquals(5, myTelevision.getVolume());
        for(int count = 0; count < 5; count++){
            myTelevision.decreaseButton();
        }
        assertEquals(0, myTelevision.getVolume());
    }


    @Test
    public void increaseVolumeAboveHundred_volumeRemainsAtHundredTest(){
        assertFalse(myTelevision.isOn());
        myTelevision.toggle();
        assertTrue(myTelevision.isOn());

        for(int count = 0; count < 100; count++){
            myTelevision.increaseButton();
        }
        assertEquals(100, myTelevision.getVolume());
        myTelevision.increaseButton();

        assertEquals(100, myTelevision.getVolume());
    }

    @Test
    public void addChannel_channelIsAddedTest(){
        assertFalse(myTelevision.isOn());
        myTelevision.toggle();
        assertTrue(myTelevision.isOn());

        myTelevision.addChannel();
        myTelevision.addChannel();
        assertEquals(2, myTelevision.getChannels().size() );

    }

    @Test
    public void viewChannelWithoutSetting_noChannelIsViewedTest(){
        assertFalse(myTelevision.isOn());
        myTelevision.toggle();
        assertTrue(myTelevision.isOn());

        assertEquals(0, myTelevision.getChannels().size() );

    }

    @Test
    public void viewChannelWithoutTurningTvOn_noChannelIsViewedTest(){
        assertFalse(myTelevision.isOn());

        assertEquals(null, myTelevision.viewChannels() );

    }

    @Test
    public void changeChannelForward_channelIsChangedTest(){
        assertFalse(myTelevision.isOn());
        myTelevision.toggle();
        assertTrue(myTelevision.isOn());

        myTelevision.addChannel();
        myTelevision.addChannel();
        assertEquals(2, myTelevision.getChannels().size() );

        myTelevision.changeChannelForward();


    }

}
