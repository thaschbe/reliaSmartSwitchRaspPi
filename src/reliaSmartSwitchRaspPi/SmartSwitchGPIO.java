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
        final GpioPinDigitalOutput pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13, "LED#1", PinState.HIGH);
        final GpioPinDigitalOutput pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_14, "LED#2", PinState.HIGH);
        final GpioPinDigitalOutput pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_30, "LED#3", PinState.HIGH);
        final GpioPinDigitalOutput pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21, "LED#4", PinState.HIGH);
        final GpioPinDigitalOutput pin5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, "LED#5", PinState.HIGH);
        final GpioPinDigitalOutput pin6 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_23, "LED#6", PinState.HIGH);
        final GpioPinDigitalOutput pin7 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, "LED#7", PinState.HIGH);
        final GpioPinDigitalOutput pin8 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_25, "LED#8", PinState.HIGH);
  
        int LEDState;
	
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
			
        }
	
	public void GPIOTest() throws IOException, Exception {

		System.out.println("GPIOTest ...");
		// turn on gpio pin #26 for 1 second and then off
		LEDState++;
		if (LEDState%8 == 0x01)
			pin1.pulse(500);
		else if (LEDState%8 == 0x02)
			pin2.pulse(500);
		else if (LEDState%8 == 0x03)
			pin3.pulse(500);
		else if (LEDState%8 == 0x04)
			pin4.pulse(500);
		else if (LEDState%8 == 0x05)
			pin5.pulse(500);
		else if (LEDState%8 == 0x06)
			pin6.pulse(500);
		else if (LEDState%8 == 0x07)
			pin7.pulse(500);
		else 
			pin8.pulse(500);
		 	  
	}
}
