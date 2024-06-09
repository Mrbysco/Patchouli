package vazkii.patchouli.client.book.template.variable;

import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.Ingredient;

import vazkii.patchouli.api.IVariableSerializer;
import vazkii.patchouli.common.util.ItemStackUtil;

public class IngredientVariableSerializer implements IVariableSerializer<Ingredient> {
	@Override
	public Ingredient fromJson(JsonElement json, HolderLookup.Provider registries) {
		return (json.isJsonPrimitive()) ? ItemStackUtil.loadIngredientFromString(json.getAsString(), RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY)) : Ingredient.CODEC.parse(RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY).createSerializationContext(JsonOps.INSTANCE), json).result().orElseThrow();
	}

	@Override
	public JsonElement toJson(Ingredient stack, HolderLookup.Provider registries) {
		return Ingredient.CODEC.encodeStart(registries.createSerializationContext(JsonOps.INSTANCE), stack).result().orElseThrow();
	}
}
