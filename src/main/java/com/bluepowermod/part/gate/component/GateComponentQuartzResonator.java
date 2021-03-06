package com.bluepowermod.part.gate.component;

import net.minecraft.util.IIcon;

import com.bluepowermod.client.render.IconSupplier;
import com.bluepowermod.part.gate.GateBase;

public class GateComponentQuartzResonator extends GateComponentButton {

    public GateComponentQuartzResonator(GateBase<?, ?, ?, ?, ?, ?> gate, int color) {

        super(gate, color);
    }

    public GateComponentQuartzResonator(GateBase<?, ?, ?, ?, ?, ?> gate, double x, double z) {

        super(gate, x, z);
    }

    @Override
    protected IIcon getIcon() {

        return IconSupplier.quartzResonator;
    }

}
