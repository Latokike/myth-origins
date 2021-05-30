package latokike.mythorigins.common.power.factory.action;

import io.github.apace100.origins.Origins;
import io.github.apace100.origins.power.factory.action.ActionFactory;
import io.github.apace100.origins.registry.ModRegistries;
import io.github.apace100.origins.util.SerializableData;
import io.github.apace100.origins.util.SerializableDataType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;

public class ItemActions {

    @SuppressWarnings("unchecked")
    public static void init() {

    }

    private static void register(ActionFactory<ItemStack> actionFactory) {
        Registry.register(ModRegistries.ITEM_ACTION, actionFactory.getSerializerId(), actionFactory);
    }
}
