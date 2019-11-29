package io.github.SebastianDanielFrenz.ComputerPlugin.blocks;

import java.nio.ByteBuffer;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPistonEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.block.NotePlayEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.FurnaceExtractEvent;

import io.github.SebastianDanielFrenz.BML.core.game.event.block.BMLBlockPlaceEvent;
import io.github.SebastianDanielFrenz.ComputerPlugin.digital.CPDigitalBlock;
import io.github.SebastianDanielFrenz.ComputerPlugin.digital.DigitalPacket;

public class RemoteRedstoneActivator extends CPDigitalBlock {

	@Override
	public void CPpacketRecieveEvent(DigitalPacket packet) {

	}

	@Override
	public Material getMaterial() {
		return Material.GREEN_WOOL;
	}

	@Override
	public void BMLblockPlaceEvent(BMLBlockPlaceEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void MCblockBurnEvent(BlockBurnEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void MCblockCanBuildEvent(BlockCanBuildEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void MCblockDamageEvent(BlockDamageEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void MCblockDispenseEvent(BlockDispenseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void MCblockBreakEvent(BlockBreakEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void MCfurnaceExtractEvent(FurnaceExtractEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void MCblockFadeEvent(BlockFadeEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void MCblockFromToEvent(BlockFromToEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void MCblockGrowEvent(BlockGrowEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void MCblockIgniteEvent(BlockIgniteEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void MCblockPhysicsEvent(BlockPhysicsEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void MCblockPistonEvent(BlockPistonEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void MCblockPlaceEvent(BlockPlaceEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void MCblockRedstoneEvent(BlockRedstoneEvent event) {
		System.out.println("Remove Redstone Activator: redstone event!");

		if (!(event.getOldCurrent() > 0 && event.getNewCurrent() == 0)
				|| (event.getOldCurrent() == 0 && event.getNewCurrent() > 0)) {
			return;
		}
		Block block = getMCblock().getRelative(BlockFace.UP);

		long ID = 0;

		if (block instanceof Sign) {
			Sign sign = (Sign) block;
			int radix = 10;
			if (sign.getLine(1).equals("hex")) {
				radix = 16;
			} else if (sign.getLine(1).equals("bin")) {
				radix = 2;
			}

			ID = Long.parseLong(sign.getLine(0), radix);
		}

		sendData(ByteBuffer.allocate(8).putLong(ID).put((byte) (event.getNewCurrent() > 0 ? 1 : 0)).array());
	}

	@Override
	public void MCfurnaceBurnEvent(FurnaceBurnEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void MCleavesDecayEvent(LeavesDecayEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void MCnotePlayEvent(NotePlayEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void MCsignChangeEvent(SignChangeEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void gameTickEvent() {
		// TODO Auto-generated method stub

	}

}
