package latokike.mythorigins.common.entity.renderer;

import latokike.mythorigins.common.MythOrigins;
import latokike.mythorigins.common.entity.HarpyFeatherArrowEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public abstract class HarpyFeatherArrowEntityRenderer extends ProjectileEntityRenderer<HarpyFeatherArrowEntity> {
    public static final Identifier TEXTURE = new Identifier(MythOrigins.MODID, "textures/entity/harpy/harpy_feather.png");

    public HarpyFeatherArrowEntityRenderer(Context context) {
        super(context);
    }

    public Identifier getTexture() {
        return TEXTURE;
    }
}
