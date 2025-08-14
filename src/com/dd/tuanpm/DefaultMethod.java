package com.dd.tuanpm;

import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.CHAR_ARRAY;
import javax.sound.midi.MidiDevice.Info;

interface vehicle {
	void start();

	default void fuel() {
		System.out.println("Using petrol");
	}

	default void stop() {
		System.out.println("Vehicle stopped");
	}

	static void info() {
		System.out.println("All vehicle must follew traffic rules");
	}
}

class car implements vehicle {

	@Override
	public void start() {
		// TODO Auto-generated method
		System.out.println("Car started");
	}

}

class electricCar implements vehicle {
	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void fuel() {
		// TODO Auto-generated method stub
		System.out.println("Using electricity");
	}
}

public class DefaultMethod {
	public static void main(String[] args) {
		car car = new car();
		car.start();
		car.fuel();
		car.stop();
		
		System.out.println("\nElectric Car:");
		electricCar eCar = new electricCar();
		eCar.start();
		eCar.fuel();
		
		vehicle.info();
	}
}
