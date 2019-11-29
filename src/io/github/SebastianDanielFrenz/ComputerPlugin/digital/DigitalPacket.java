package io.github.SebastianDanielFrenz.ComputerPlugin.digital;

public class DigitalPacket {

	public DigitalPacket(CPDigitalBlock source, byte[] data, CPDigitalBlock[] path) {
		this.source = source;
		this.data = data;
		this.path = path;
	}

	public DigitalPacket(DigitalPacket recievedPacket, CPDigitalBlock reciever) {
		this.source = recievedPacket.source;

		path = new CPDigitalBlock[recievedPacket.path.length + 1];
		for (int i = 0; i < recievedPacket.path.length; i++) {
			path[i] = recievedPacket.path[i];
		}
		path[recievedPacket.path.length] = reciever;

		this.data = recievedPacket.data;
	}

	public final CPDigitalBlock source;
	public final CPDigitalBlock[] path;
	public final byte[] data;
}
