package com.tactfactory.pokemmo.net.server.processor;

import java.io.IOException;

import com.tactfactory.pokemmo.net.server.entity.PacketProcessor;

public class Pseudo extends PacketProcessor {

	@Override
	public void execute() {
		try {
			this.getConnection().setValue("pseudo", this.input.readUTF());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
