package io.github.SebastianDanielFrenz.ComputerPlugin.blocks;

import org.bukkit.Material;
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

public class CableBlock extends CPDigitalBlock {

	@Override
	public void CPpacketRecieveEvent(DigitalPacket packet) {
		forwardPacket(packet);
	}

	@Override
	public Material getMaterial() {
		return Material.BLACK_WOOL;
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
		// TODO Auto-generated method stub

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
