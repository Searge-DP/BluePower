/*
 * This file is part of Blue Power.
 *
 *     Blue Power is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Blue Power is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Blue Power.  If not, see <http://www.gnu.org/licenses/>
 */

package net.quetzi.bluepower.client.renderers;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.quetzi.bluepower.api.part.BPPart;
import net.quetzi.bluepower.api.part.PartRegistry;

public class RenderItemBPPart implements IItemRenderer {
    
    private List<BPPart> parts = new ArrayList<BPPart>();
    
    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
    
        return true;
    }
    
    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
    
        return true;
    }
    
    @SuppressWarnings("incomplete-switch")
    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
    
        BPPart part = null;
        for (BPPart p : parts)
            if (p.getType().equals(PartRegistry.getPartIdFromItem(item))) {
                part = p;
                break;
            }
        if (part == null) {
            part = PartRegistry.createPartFromItem(item);
            parts.add(part);
        }
        
        GL11.glPushMatrix();
        {
            switch (type) {
                case ENTITY:
                    GL11.glScaled(0.5, 0.5, 0.5);
                    GL11.glTranslated(-0.5, 0, -0.5);
                    break;
                case EQUIPPED:
                    break;
                case EQUIPPED_FIRST_PERSON:
                    break;
                case INVENTORY:
                    GL11.glTranslated(0, -0.15, 0);
                    break;
            }
            part.renderItem(type, item, data);
        }
        GL11.glPopMatrix();
    }
    
}