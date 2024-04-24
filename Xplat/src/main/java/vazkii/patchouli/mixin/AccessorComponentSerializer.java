package vazkii.patchouli.mixin;

import com.google.gson.JsonElement;

import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Component.Serializer.class)
public interface AccessorComponentSerializer {
	@Invoker("serialize")
	public static JsonElement invokeSerialize(Component component, HolderLookup.Provider provider) {
		throw new AssertionError();
	}
}
