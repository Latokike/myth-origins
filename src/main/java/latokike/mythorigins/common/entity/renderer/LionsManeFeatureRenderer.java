package latokike.mythorigins.common.entity.renderer;

import latokike.mythorigins.common.registry.MOPowers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.ModelWithHead;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

@Environment(EnvType.CLIENT)
public class LionsManeFeatureRenderer<T extends LivingEntity, M extends EntityModel<T> & ModelWithHead> extends FeatureRenderer<T, M> {
    private final float xScale;
    private final float yScale;
    private final float zScale;

    public LionsManeFeatureRenderer(FeatureRendererContext<T, M> featureRendererContext) {
        this(featureRendererContext, 1.0F, 1.0F, 1.0F);
    }

    public LionsManeFeatureRenderer(FeatureRendererContext<T, M> featureRendererContext, float f, float g, float h) {
        super(featureRendererContext);
        this.xScale = f;
        this.yScale = g;
        this.zScale = h;
    }

    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l) {
        this.renderHead(matrixStack, vertexConsumerProvider, i, livingEntity);
    }

    public void renderHead(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity) {
        if (MOPowers.LIONS_MANE.isActive(livingEntity)) {
            Item item = Items.BROWN_WOOL;
            ItemStack itemStack = item.getDefaultStack();
            matrixStack.push();
            matrixStack.scale(this.xScale, this.yScale, this.zScale);

            (this.getContextModel()).getHead().rotate(matrixStack);
            matrixStack.translate(0.0D, -0.25D, 0.1D);
            matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(180.0F));
            matrixStack.scale(0.61F, -0.61F, -0.61F);

            MinecraftClient.getInstance().getHeldItemRenderer().renderItem(livingEntity, itemStack, ModelTransformation.Mode.HEAD, false, matrixStack, vertexConsumerProvider, i);
            matrixStack.pop();
        }
    }
}