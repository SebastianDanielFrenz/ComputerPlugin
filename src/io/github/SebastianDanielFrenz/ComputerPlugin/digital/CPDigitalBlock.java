package io.github.SebastianDanielFrenz.ComputerPlugin.digital;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.util.Vector;

import io.github.SebastianDanielFrenz.BML.core.game.block.BMLBlock;
import io.github.SebastianDanielFrenz.ComputerPlugin.ComputerPlugin;

public abstract class CPDigitalBlock extends BMLBlock {

	public abstract void CPpacketRecieveEvent(DigitalPacket packet);

	public List<CPDigitalBlock> getConnectedBlocks() {
		List<CPDigitalBlock> out = new ArrayList<CPDigitalBlock>();

		int[][] pos = new int[][] { new int[] { 1, 0, 0 }, new int[] { 0, 1, 0 }, new int[] { 0, 0, 1 },
				new int[] { -1, 0, 0 }, new int[] { 0, -1, 0 }, new int[] { 0, 0, -1 }, };

		BMLBlock rawblock;
		for (int i = 0; i < pos.length; i++) {
			rawblock = ComputerPlugin.engine.getPlacedBlockStorage()
					.getBlockAt(location.add(new Vector(pos[i][0], pos[i][1], pos[i][2])));
			if (rawblock != null) {
				if (rawblock instanceof CPDigitalBlock) {
					out.add((CPDigitalBlock) rawblock);
				}
			}
		}
		return out;
	}

	/**
	 * gets all surrounding DigitalBlocks without returning the data source.
	 */
	public List<CPDigitalBlock> getConnectedBlocks(CPDigitalBlock source) {
		List<CPDigitalBlock> out = new ArrayList<CPDigitalBlock>();

		int[][] pos = new int[][] { new int[] { 1, 0, 0 }, new int[] { 0, 1, 0 }, new int[] { 0, 0, 1 },
				new int[] { -1, 0, 0 }, new int[] { 0, -1, 0 }, new int[] { 0, 0, -1 }, };

		BMLBlock rawblock;
		for (int i = 0; i < pos.length; i++) {
			rawblock = ComputerPlugin.engine.getPlacedBlockStorage()
					.getBlockAt(location.add(new Vector(pos[i][0], pos[i][1], pos[i][2])));
			if (rawblock != null) {
				if (rawblock instanceof CPDigitalBlock) {
					if (rawblock != source) {
						out.add((CPDigitalBlock) rawblock);
					}
				}
			}
		}
		return out;
	}

	/**
	 * gets all surrounding DigitalBlocks without returning the data source.
	 */
	public List<CPDigitalBlock> getConnectedBlocks(CPDigitalBlock[] path) {
		List<CPDigitalBlock> out = new ArrayList<CPDigitalBlock>();

		int[][] pos = new int[][] { new int[] { 1, 0, 0 }, new int[] { 0, 1, 0 }, new int[] { 0, 0, 1 },
				new int[] { -1, 0, 0 }, new int[] { 0, -1, 0 }, new int[] { 0, 0, -1 }, };

		BMLBlock rawblock;
		boolean contains = false;
		for (int i = 0; i < pos.length; i++) {
			rawblock = ComputerPlugin.engine.getPlacedBlockStorage()
					.getBlockAt(location.add(new Vector(pos[i][0], pos[i][1], pos[i][2])));
			if (rawblock != null) {
				if (rawblock instanceof CPDigitalBlock) {
					contains = false;

					// reverse loop in order to improve efficiency; at least the
					// previous block in the signal chain should be detected
					// first this way.

					for (int j = path.length - 1; j >= 0; j--) {
						if (rawblock == path[j]) {
							contains = true;
							break;
						}
					}
					if (!contains) {
						out.add((CPDigitalBlock) rawblock);
					}
				}
			}
		}
		return out;
	}

	public void sendData(byte[] data) {
		forwardPacket(new DigitalPacket(this, data, new CPDigitalBlock[] {}));
	}

	public void forwardPacket(DigitalPacket packet) {
		DigitalPacket newPacket = new DigitalPacket(packet, this);

		for (CPDigitalBlock block : getConnectedBlocks(packet.path)) {
			block.CPpacketRecieveEvent(newPacket);
		}
	}

}
