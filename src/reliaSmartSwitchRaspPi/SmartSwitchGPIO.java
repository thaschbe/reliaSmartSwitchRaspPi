package reliaSmartSwitchRaspPi;

import java.io.IOException;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class SmartSwitchGPIO {
	
		// create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        // provision gpio pin #01-08 as an output pin and turn on
        final GpioPinDigitalOutput pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "LED#1", PinState.HIGH);
        final GpioPinDigitalOutput pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "LED#2", PinState.HIGH);
        final GpioPinDigitalOutput pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "LED#3", PinState.HIGH);
        final GpioPinDigitalOutput pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "LED#4", PinState.HIGH);
        final GpioPinDigitalOutput pin5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "LED#5", PinState.HIGH);
        final GpioPinDigitalOutput pin6 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "LED#6", PinState.HIGH);
        final GpioPinDigitalOutput pin7 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, "LED#7", PinState.HIGH);
        final GpioPinDigitalOutput pin8 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, "LED#8", PinState.HIGH);
        final GpioPinDigitalOutput pin26 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26, "LED#26", PinState.HIGH);

	
        public void GPIOInit() throws IOException, Exception {

        	System.out.println("GPIOInit ...");
			// set shutdown state for this pin
		    pin1.setShutdownOptions(true, PinState.LOW);
		    pin2.setShutdownOptions(true, PinState.LOW);
		    pin3.setShutdownOptions(true, PinState.LOW);
		    pin4.setShutdownOptions(true, PinState.LOW);
		    pin5.setShutdownOptions(true, PinState.LOW);
		    pin6.setShutdownOptions(true, PinState.LOW);
		    pin7.setShutdownOptions(true, PinState.LOW);
		    pin8.setShutdownOptions(true, PinState.LOW);
		    pin26.setShutdownOptions(true, PinState.LOW);
			
        }
	
	public void GPIOTest() throws IOException, Exception {

		System.out.println("GPIOTest ...");
		// turn on gpio pin #26 for 1 second and then off
		 pin26.pulse(1000, true); // set second argument to 'true' use a blocking call
		 
	}
}
