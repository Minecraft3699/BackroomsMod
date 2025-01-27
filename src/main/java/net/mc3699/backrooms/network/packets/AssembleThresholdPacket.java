package net.mc3699.backrooms.network.packets;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;

import java.util.function.Supplier;

public class AssembleThresholdPacket {

    private final BlockPos assemblyPoint;

    public void encode(FriendlyByteBuf buf)
    {
        buf.writeBlockPos(assemblyPoint);
    }

    public AssembleThresholdPacket(BlockPos assemblyPoint) {
        this.assemblyPoint = assemblyPoint;
    }


}
