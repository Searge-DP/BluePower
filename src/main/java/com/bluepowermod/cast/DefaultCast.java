package com.bluepowermod.cast;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import com.bluepowermod.api.cast.ICast;

public class DefaultCast implements ICast {

    private String type;
    private String texture;
    private IIcon icon;

    public DefaultCast(String type, String texture) {

        this.type = type;
        this.texture = texture;
    }

    @Override
    public String getCastType() {

        return type;
    }

    @Override
    public void registerIcon(IIconRegister reg) {

        icon = reg.registerIcon(texture);
    }

    @Override
    public IIcon getIcon() {

        return icon;
    }

}
