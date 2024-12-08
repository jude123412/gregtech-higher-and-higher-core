package org.gthhcore.common.items.metaitem;

import codechicken.lib.model.ModelRegistryHelper;
import codechicken.lib.texture.TextureUtils;
import codechicken.lib.util.TransformUtils;
import com.enderio.core.common.interfaces.IOverlayRenderAware;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;
import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.capability.GregtechCapabilities;
import gregtech.api.capability.IElectricItem;
import gregtech.api.capability.IFilteredFluidContainer;
import gregtech.api.capability.IPropertyFluidFilter;
import gregtech.api.capability.impl.CombinedCapabilityProvider;
import gregtech.api.capability.impl.ElectricItem;
import gregtech.api.gui.ModularUI;
import gregtech.api.items.OreDictNames;
import gregtech.api.items.gui.ItemUIFactory;
import gregtech.api.items.gui.PlayerInventoryHolder;
import gregtech.api.items.metaitem.DefaultSubItemHandler;
import gregtech.api.items.metaitem.FoodUseManager;
import gregtech.api.items.metaitem.stats.*;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.api.util.LocalizationUtils;
import gregtech.api.util.Mods;
import gregtech.common.ConfigHolder;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import it.unimi.dsi.fastutil.shorts.Short2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.shorts.Short2ObjectMap;
import it.unimi.dsi.fastutil.shorts.Short2ObjectOpenHashMap;
import morph.avaritia.api.ICosmicRenderItem;
import morph.avaritia.api.IHaloRenderItem;
import morph.avaritia.api.registration.IModelRegister;
import morph.avaritia.init.AvaritiaTextures;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.fluids.capability.IFluidTankProperties;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.gthhcore.api.util.GTHHUtility;
import org.gthhcore.client.render.item.GTHHCosmicItemRender;
import org.gthhcore.client.utils.ToolChargeBarRenderer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


import java.time.Duration;
import java.time.Instant;
import java.util.*;

@Optional.Interface(
        modid = Mods.Names.ENDER_CORE,
        iface = "com.enderio.core.common.interfaces.IOverlayRenderAware")
public abstract class GTHHMetaItem<T extends GTHHMetaItem<?>.GTHHMetaValueItem> extends Item
        implements ItemUIFactory, IOverlayRenderAware, IHaloRenderItem, ICosmicRenderItem, IModelRegister{

    private static final List<GTHHMetaItem<?>> META_ITEMS = new ArrayList<>();

    public static List<GTHHMetaItem<?>> getMetaItems() {
        return Collections.unmodifiableList(META_ITEMS);
    }

    private final Map<String, T> names = new Object2ObjectOpenHashMap<>();
    protected final Short2ObjectMap<T> metaItems = new Short2ObjectLinkedOpenHashMap<>();
    protected final Short2ObjectMap<ModelResourceLocation> metaItemsModels = new Short2ObjectOpenHashMap<>();
    protected final Short2ObjectMap<ModelResourceLocation[]> specialItemsModels = new Short2ObjectOpenHashMap<>();
    protected static final ModelResourceLocation MISSING_LOCATION = new ModelResourceLocation("builtin/missing",
            "inventory");

    protected final short GTHHMetaItemOffset;

    private CreativeTabs[] defaultCreativeTabs = new CreativeTabs[] { GregTechAPI.TAB_GREGTECH };
    private final Set<CreativeTabs> additionalCreativeTabs = new ObjectArraySet<>();

    private String translationKey = "gthhmetaitem";

    public GTHHMetaItem(short GTHHMetaItemOffset) {
        setHasSubtypes(true);
        this.GTHHMetaItemOffset = GTHHMetaItemOffset;
        META_ITEMS.add(this);
    }

    @SideOnly(Side.CLIENT)
    public void registerColor() {
        Minecraft.getMinecraft().getItemColors().registerItemColorHandler(this::getColorForItemStack, this);
    }
    @SideOnly(Side.CLIENT)
    public void registerModels() {
        for (short itemMetaKey : metaItems.keySet()) {
            T metaValueItem = metaItems.get(itemMetaKey);
            int numberOfModels = metaValueItem.getModelAmount();
            ModelResourceLocation[] resourceLocations = new ModelResourceLocation[numberOfModels];
            if (numberOfModels > 1) {

                for (int i = 0; i <resourceLocations.length; i++){
                    ResourceLocation resourceLocation = createItemModelPath(metaValueItem, "/" + (i + 1));
                    ModelBakery.registerItemVariants(this, resourceLocation);
                    resourceLocations[i] = new ModelResourceLocation(resourceLocation, "inventory");
                    ModelResourceLocation location = new ModelResourceLocation(resourceLocation, "inventory");
                    IBakedModel wrapped = new GTHHCosmicItemRender(TransformUtils.DEFAULT_ITEM, (modelRegistry) -> modelRegistry.getObject(location));
                    ModelRegistryHelper.register(location, wrapped);
                }

                specialItemsModels.put((short) (GTHHMetaItemOffset + itemMetaKey), resourceLocations);
                continue;
            }
            ResourceLocation resourceLocation = createItemModelPath(metaValueItem, "");
            if (numberOfModels > 0) {
                ModelBakery.registerItemVariants(this, resourceLocation);
            }

            metaItemsModels.put((short) (GTHHMetaItemOffset + itemMetaKey), new ModelResourceLocation(resourceLocation, "inventory"));

            ModelResourceLocation location = new ModelResourceLocation(resourceLocation, "inventory");
            IBakedModel wrapped = new GTHHCosmicItemRender(TransformUtils.DEFAULT_ITEM, (modelRegistry) -> modelRegistry.getObject(location));
            ModelRegistryHelper.register(location, wrapped);

        }
    }

    @SideOnly(Side.CLIENT)
    public void registerTextureMesh() {
        ModelLoader.setCustomMeshDefinition(this, itemStack -> {
            short itemDamage = formatRawItemDamage((short) itemStack.getItemDamage());
            if (specialItemsModels.containsKey(itemDamage)) {
                int modelIndex = getModelIndex(itemStack);
                return specialItemsModels.get(itemDamage)[modelIndex];
            }
            if (metaItemsModels.containsKey(itemDamage)) {
                return metaItemsModels.get(itemDamage);
            }
            return MISSING_LOCATION;
        });
    }
    public ResourceLocation createItemModelPath(T metaValueItem, String postfix) {
        return GTHHUtility.gthhId(formatModelPath(metaValueItem) + postfix);
    }
    protected String formatModelPath(T metaValueItem) {
        return "metaitems/" + metaValueItem.unlocalizedName;
    }

    protected int getModelIndex(ItemStack itemStack) {
        T metaValueItem = getItem(itemStack);

        // Electric Items
        IElectricItem electricItem = itemStack.getCapability(GregtechCapabilities.CAPABILITY_ELECTRIC_ITEM, null);
        if (electricItem != null) {
            return (int) Math.min(((electricItem.getCharge() / (electricItem.getMaxCharge() * 1.0)) * 7), 7);
        }

        // Integrated (Config) Circuit
        if (metaValueItem != null) {
            return IntCircuitIngredient.getCircuitConfiguration(itemStack);
        }
        return 0;
    }

    @SideOnly(Side.CLIENT)
    protected int getColorForItemStack(ItemStack stack, int tintIndex) {
        T metaValueItem = getItem(stack);
        if (metaValueItem != null && metaValueItem.getColorProvider() != null)
            return metaValueItem.getColorProvider().getItemStackColor(stack, tintIndex);
        return 0xFFFFFF;
    }

    @Override
    public boolean showDurabilityBar(@NotNull ItemStack stack) {
        // meta items now handle durability bars via custom rendering
        return false;
    }

    @Override
    public double getDurabilityForDisplay(@NotNull ItemStack stack) {
        T metaValueItem = getItem(stack);
        if (metaValueItem != null && metaValueItem.getDurabilityManager() != null) {
            return metaValueItem.getDurabilityManager().getDurabilityForDisplay(stack);
        }
        return -1.0;
    }

    protected abstract T constructMetaValueItem(short metaValue, String unlocalizedName);

    public final T addItem(int metaValue, String unlocalizedName){
        Validate.inclusiveBetween(0, Short.MAX_VALUE - 1, metaValue + GTHHMetaItemOffset,
                "GTHHMetaItem ID should be in range from 0 to Short.MAX_VALUE-1");
        T metaValueItem = constructMetaValueItem((short) metaValue, unlocalizedName);
        if (metaItems.containsKey((short) metaValue)) {
            T registeredItem = metaItems.get((short) metaValue);
            throw new IllegalArgumentException(
                    String.format("MetaId %d is already occupied by item %s (requested by item %s)", metaValue,
                            registeredItem.unlocalizedName, unlocalizedName));
        }
        metaItems.put((short) metaValue, metaValueItem);
        names.put(unlocalizedName, metaValueItem);
        return metaValueItem;
    }
    public final Collection<T> getAllItems() {
        return Collections.unmodifiableCollection(metaItems.values());
    }

    @Nullable
    public final T getItem(short metaValue) {
        return metaItems.get(formatRawItemDamage(metaValue));
    }

    @Nullable
    public final T getItem(String valueName) {
        return names.get(valueName);
    }
    @Nullable
    public final T getItem(ItemStack itemStack) {
        return getItem((short) (itemStack.getItemDamage() - GTHHMetaItemOffset));
    }
    protected short formatRawItemDamage(short metaValue) {
        return metaValue;
    }
    public void registerSubItems() {}

    @Override
    public ICapabilityProvider initCapabilities(@NotNull ItemStack stack, @Nullable NBTTagCompound nbt) {
        T metaValueItem = getItem(stack);
        if (metaValueItem == null) {
            return null;
        }
        ArrayList<ICapabilityProvider> providers = new ArrayList<>();
        for (IItemComponent itemComponent : metaValueItem.getAllStats()) {
            if (itemComponent instanceof IItemCapabilityProvider provider) {
                providers.add(provider.createProvider(stack));
            }
        }
        return new CombinedCapabilityProvider(providers);
    }
    @Override
    public int getItemBurnTime(@NotNull ItemStack itemStack) {
        T metaValueItem = getItem(itemStack);
        if (metaValueItem == null) {
            return super.getItemBurnTime(itemStack);
        }
        return metaValueItem.getBurnValue();
    }

    private IItemUseManager getUseManager(ItemStack itemStack) {
        T metaValueItem = getItem(itemStack);
        if (metaValueItem == null) {
            return null;
        }
        return metaValueItem.getUseManager();
    }

    public List<IItemBehaviour> getBehaviours(ItemStack itemStack) {
        T metaValueItem = getItem(itemStack);
        if (metaValueItem == null) {
            return ImmutableList.of();
        }
        return metaValueItem.getBehaviours();
    }

    @Override
    public int getItemStackLimit(@NotNull ItemStack stack) {
        T metaValueItem = getItem(stack);
        if (metaValueItem == null) {
            return 64;
        }
        return metaValueItem.getMaxStackSize(stack);
    }

    @NotNull
    @Override
    public EnumAction getItemUseAction(@NotNull ItemStack stack) {
        IItemUseManager useManager = getUseManager(stack);
        if (useManager != null) {
            return useManager.getUseAction(stack);
        }
        return EnumAction.NONE;
    }

    @Override
    public int getMaxItemUseDuration(@NotNull ItemStack stack) {
        IItemUseManager useManager = getUseManager(stack);
        if (useManager != null) {
            return useManager.getMaxItemUseDuration(stack);
        }
        return 0;
    }

    @Override
    public void onUsingTick(@NotNull ItemStack stack, @NotNull EntityLivingBase player, int count) {
        if (player instanceof EntityPlayer) {
            IItemUseManager useManager = getUseManager(stack);
            if (useManager != null) {
                useManager.onItemUsingTick(stack, (EntityPlayer) player, count);
            }
        }
    }

    @Override
    public void onPlayerStoppedUsing(@NotNull ItemStack stack, @NotNull World world, @NotNull EntityLivingBase player,
                                     int timeLeft) {
        if (player instanceof EntityPlayer) {
            IItemUseManager useManager = getUseManager(stack);
            if (useManager != null) {
                useManager.onPlayerStoppedItemUsing(stack, (EntityPlayer) player, timeLeft);
            }
        }
    }

    @NotNull
    @Override
    public ItemStack onItemUseFinish(@NotNull ItemStack stack, @NotNull World world, @NotNull EntityLivingBase player) {
        if (player instanceof EntityPlayer) {
            IItemUseManager useManager = getUseManager(stack);
            if (useManager != null) {
                return useManager.onItemUseFinish(stack, (EntityPlayer) player);
            }
        }
        return stack;
    }

    @Override
    public boolean onLeftClickEntity(@NotNull ItemStack stack, @NotNull EntityPlayer player, @NotNull Entity entity) {
        boolean returnValue = false;
        for (IItemBehaviour behaviour : getBehaviours(stack)) {
            if (behaviour.onLeftClickEntity(stack, player, entity)) {
                returnValue = true;
            }
        }
        return returnValue;
    }

    @Override
    public boolean itemInteractionForEntity(@NotNull ItemStack stack, @NotNull EntityPlayer playerIn,
                                            @NotNull EntityLivingBase target, @NotNull EnumHand hand) {
        boolean returnValue = false;
        for (IItemBehaviour behaviour : getBehaviours(stack)) {
            if (behaviour.itemInteractionForEntity(stack, playerIn, target, hand)) {
                returnValue = true;
            }
        }
        return returnValue;
    }

    @NotNull
    @Override
    public ActionResult<ItemStack> onItemRightClick(@NotNull World world, EntityPlayer player, @NotNull EnumHand hand) {
        ItemStack itemStack = player.getHeldItem(hand);
        for (IItemBehaviour behaviour : getBehaviours(itemStack)) {
            ActionResult<ItemStack> behaviourResult = behaviour.onItemRightClick(world, player, hand);
            itemStack = behaviourResult.getResult();
            if (behaviourResult.getType() != EnumActionResult.PASS) {
                return ActionResult.newResult(behaviourResult.getType(), itemStack);
            } else if (itemStack.isEmpty()) {
                return ActionResult.newResult(EnumActionResult.PASS, ItemStack.EMPTY);
            }
        }
        IItemUseManager useManager = getUseManager(itemStack);
        if (useManager != null && useManager.canStartUsing(itemStack, player)) {
            useManager.onItemUseStart(itemStack, player);
            player.setActiveHand(hand);
            return ActionResult.newResult(EnumActionResult.SUCCESS, itemStack);
        }
        return ActionResult.newResult(EnumActionResult.PASS, itemStack);
    }

    @NotNull
    @Override
    public EnumActionResult onItemUseFirst(EntityPlayer player, @NotNull World world, @NotNull BlockPos pos,
                                           @NotNull EnumFacing side, float hitX, float hitY, float hitZ,
                                           @NotNull EnumHand hand) {
        ItemStack itemStack = player.getHeldItem(hand);
        for (IItemBehaviour behaviour : getBehaviours(itemStack)) {
            EnumActionResult behaviourResult = behaviour.onItemUseFirst(player, world, pos, side, hitX, hitY, hitZ,
                    hand);
            if (behaviourResult != EnumActionResult.PASS) {
                return behaviourResult;
            } else if (itemStack.isEmpty()) {
                return EnumActionResult.PASS;
            }
        }
        return EnumActionResult.PASS;
    }

    @NotNull
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, @NotNull World world, @NotNull BlockPos pos,
                                      @NotNull EnumHand hand, @NotNull EnumFacing facing, float hitX, float hitY,
                                      float hitZ) {
        ItemStack stack = player.getHeldItem(hand);
        ItemStack originalStack = stack.copy();
        for (IItemBehaviour behaviour : getBehaviours(stack)) {
            ActionResult<ItemStack> behaviourResult = behaviour.onItemUse(player, world, pos, hand, facing, hitX, hitY,
                    hitZ);
            stack = behaviourResult.getResult();
            if (behaviourResult.getType() != EnumActionResult.PASS) {
                if (!ItemStack.areItemStacksEqual(originalStack, stack))
                    player.setHeldItem(hand, stack);
                return behaviourResult.getType();
            } else if (stack.isEmpty()) {
                player.setHeldItem(hand, ItemStack.EMPTY);
                return EnumActionResult.PASS;
            }
        }
        return EnumActionResult.PASS;
    }

    @NotNull
    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(@NotNull EntityEquipmentSlot slot,
                                                                     @NotNull ItemStack stack) {
        HashMultimap<String, AttributeModifier> modifiers = HashMultimap.create();
        T metaValueItem = getItem(stack);
        if (metaValueItem != null) {
            for (IItemBehaviour behaviour : getBehaviours(stack)) {
                modifiers.putAll(behaviour.getAttributeModifiers(slot, stack));
            }
        }
        return modifiers;
    }

    @Override
    public boolean isEnchantable(@NotNull ItemStack stack) {
        T metaValueItem = getItem(stack);
        if (metaValueItem != null) {
            IEnchantabilityHelper helper = metaValueItem.getEnchantabilityHelper();
            return helper != null && helper.isEnchantable(stack);
        }
        return super.isEnchantable(stack);
    }

    @Override
    public int getItemEnchantability(@NotNull ItemStack stack) {
        T metaValueItem = getItem(stack);
        if (metaValueItem != null) {
            IEnchantabilityHelper helper = metaValueItem.getEnchantabilityHelper();
            return helper == null ? 0 : helper.getItemEnchantability(stack);
        }
        return super.getItemEnchantability(stack);
    }

    @Override
    public boolean canApplyAtEnchantingTable(@NotNull ItemStack stack, @NotNull Enchantment enchantment) {
        T metaValueItem = getItem(stack);
        if (metaValueItem != null) {
            IEnchantabilityHelper helper = metaValueItem.getEnchantabilityHelper();
            return helper != null && helper.canApplyAtEnchantingTable(stack, enchantment);
        }
        return super.canApplyAtEnchantingTable(stack, enchantment);
    }

    @Override
    public boolean shouldCauseReequipAnimation(@NotNull ItemStack oldStack, @NotNull ItemStack newStack,
                                               boolean slotChanged) {
        // if item is equal, and old item has electric item capability, remove charge tags to stop reequip animation
        // when charge is altered
        if (ItemStack.areItemsEqual(oldStack, newStack) &&
                oldStack.hasCapability(GregtechCapabilities.CAPABILITY_ELECTRIC_ITEM, null) &&
                oldStack.hasTagCompound() && newStack.hasTagCompound()) {
            oldStack = oldStack.copy();
            newStack = newStack.copy();
            NBTTagCompound oldTag = oldStack.getTagCompound();
            NBTTagCompound newTag = newStack.getTagCompound();
            if (oldTag != null && newTag != null) {
                oldTag.removeTag("Charge");
                newTag.removeTag("Charge");
                if (oldTag.hasKey("terminal")) {
                    oldTag.getCompoundTag("terminal").getCompoundTag("_hw").removeTag("battery");
                    newTag.getCompoundTag("terminal").getCompoundTag("_hw").removeTag("battery");
                }
            }
        }
        return !ItemStack.areItemStacksEqual(oldStack, newStack);
    }

    @NotNull
    @Override
    public GTHHMetaItem<T> setTranslationKey(@NotNull String key) {
        this.translationKey = Objects.requireNonNull(key, "key == null");
        return this;
    }

    @NotNull
    @Override
    public String getTranslationKey() {
        return getTranslationKey((T) null);
    }

    @NotNull
    @Override
    public String getTranslationKey(@NotNull ItemStack stack) {
        return getTranslationKey(getItem(stack));
    }

    @NotNull
    protected String getTranslationKey(@Nullable T metaValueItem) {
        return metaValueItem == null ? this.translationKey : this.translationKey + "." + metaValueItem.unlocalizedName;
    }

    @NotNull
    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        if (stack.getItemDamage() >= GTHHMetaItemOffset) {
            T item = getItem(stack);
            if (item == null) {
                return "invalid item";
            }
            String unlocalizedName = getTranslationKey(item) + ".name";
            if (item.getNameProvider() != null) {
                return item.getNameProvider().getItemStackDisplayName(stack, unlocalizedName);
            }
            IFluidHandlerItem fluidHandlerItem = ItemHandlerHelper.copyStackWithSize(stack, 1)
                    .getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null);
            if (fluidHandlerItem != null) {
                FluidStack fluidInside = fluidHandlerItem.drain(Integer.MAX_VALUE, false);
                return LocalizationUtils.format(unlocalizedName, fluidInside == null ?
                        LocalizationUtils.format("gthhmetaitem.fluid_cell.empty") :
                        fluidInside.getLocalizedName());
            }
            return LocalizationUtils.format(unlocalizedName);
        }
        return super.getItemStackDisplayName(stack);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(@NotNull ItemStack itemStack, @Nullable World worldIn, @NotNull List<String> lines,
                               @NotNull ITooltipFlag tooltipFlag) {
        T item = getItem(itemStack);
        if (item == null) return;
        String unlocalizedTooltip = getTranslationKey(item) + ".tooltip";
        if (I18n.hasKey(unlocalizedTooltip)) {
            Collections.addAll(lines, LocalizationUtils.formatLines(unlocalizedTooltip));
        }

        IElectricItem electricItem = itemStack.getCapability(GregtechCapabilities.CAPABILITY_ELECTRIC_ITEM, null);
        if (electricItem != null) {
            if (electricItem.canProvideChargeExternally()) {
                addDischargeItemTooltip(lines, electricItem.getMaxCharge(), electricItem.getCharge(),
                        electricItem.getTier());
            } else {
                lines.add(I18n.format("gthhmetaitem.generic.electric_item.tooltip",
                        electricItem.getCharge(),
                        electricItem.getMaxCharge(),
                        GTValues.VNF[electricItem.getTier()]));
            }
        }

        IFluidHandlerItem fluidHandler = ItemHandlerHelper.copyStackWithSize(itemStack, 1)
                .getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null);
        if (fluidHandler != null) {
            IFluidTankProperties fluidTankProperties = fluidHandler.getTankProperties()[0];
            FluidStack fluid = fluidTankProperties.getContents();

            lines.add(I18n.format("gthhmetaitem.generic.fluid_container.tooltip",
                    fluid == null ? 0 : fluid.amount,
                    fluidTankProperties.getCapacity(),
                    fluid == null ? "" : fluid.getLocalizedName()));

            if (fluidHandler instanceof IFilteredFluidContainer filtered &&
                    filtered.getFilter() instanceof IPropertyFluidFilter propertyFilter) {
                propertyFilter.appendTooltips(lines, false, true);
            }
        }

        for (IItemBehaviour behaviour : getBehaviours(itemStack)) {
            behaviour.addInformation(itemStack, lines);
        }

        if (ConfigHolder.misc.debug) {
            lines.add("gthhmetaitem Id: " + item.unlocalizedName);
        }
    }

    private static void addDischargeItemTooltip(List<String> tooltip, long maxCharge, long currentCharge, int tier) {
        if (currentCharge == 0) { // do not display when empty
            tooltip.add(I18n.format("gthhmetaitem.generic.electric_item.tooltip", currentCharge, maxCharge,
                    GTValues.VNF[tier]));
            return;
        }
        Instant start = Instant.now();
        Instant end = Instant.now().plusSeconds((long) ((currentCharge * 1.0) / GTValues.V[tier] / 20));
        Duration duration = Duration.between(start, end);
        double percentRemaining = currentCharge * 1.0 / maxCharge * 100; // used for color

        long timeRemaining;
        String unit;
        if (duration.getSeconds() <= 180) {
            timeRemaining = duration.getSeconds();
            unit = I18n.format("gthhmetaitem.battery.charge_unit.second");
        } else if (duration.toMinutes() <= 180) {
            timeRemaining = duration.toMinutes();
            unit = I18n.format("gthhmetaitem.battery.charge_unit.minute");
        } else {
            timeRemaining = duration.toHours();
            unit = I18n.format("gthhmetaitem.battery.charge_unit.hour");
        }
        tooltip.add(I18n.format("gthhmetaitem.battery.charge_detailed", currentCharge, maxCharge, GTValues.VNF[tier],
                percentRemaining < 30 ? 'c' : percentRemaining < 60 ? 'e' : 'a',
                timeRemaining, unit));
    }

    @Override
    public boolean hasContainerItem(@NotNull ItemStack itemStack) {
        T item = getItem(itemStack);
        if (item == null) {
            return false;
        }
        return item.getContainerItemProvider() != null;
    }

    @NotNull
    @Override
    public ItemStack getContainerItem(@NotNull ItemStack itemStack) {
        T item = getItem(itemStack);
        if (item == null) {
            return ItemStack.EMPTY;
        }
        itemStack = itemStack.copy();
        itemStack.setCount(1);
        IItemContainerItemProvider provider = item.getContainerItemProvider();
        return provider == null ? ItemStack.EMPTY : provider.getContainerItem(itemStack);
    }

    @NotNull
    @Override
    public GTHHMetaItem<T> setCreativeTab(@NotNull CreativeTabs tab) {
        this.defaultCreativeTabs = new CreativeTabs[] { tab };
        return this;
    }

    public void addAdditionalCreativeTabs(@NotNull CreativeTabs @NotNull... tabs) {
        for (CreativeTabs tab : tabs) {
            if (!ArrayUtils.contains(defaultCreativeTabs, tab) && tab != CreativeTabs.SEARCH) {
                additionalCreativeTabs.add(tab);
            }
        }
    }

    @Override
    public void getSubItems(@NotNull CreativeTabs tab, @NotNull NonNullList<ItemStack> subItems) {
        if (!isInCreativeTab(tab)) return;
        for (T item : metaItems.values()) {
            if (!item.isInCreativeTab(tab)) continue;
            item.getSubItemHandler().getSubItems(item.getStackForm(), tab, subItems);
        }
    }
    @Override
    protected boolean isInCreativeTab(@NotNull CreativeTabs tab) {
        return tab == CreativeTabs.SEARCH ||
                ArrayUtils.contains(defaultCreativeTabs, tab) ||
                additionalCreativeTabs.contains(tab);
    }
    @NotNull
    @Override
    public CreativeTabs @NotNull [] getCreativeTabs() {
        if (additionalCreativeTabs.isEmpty()) return defaultCreativeTabs; // short circuit
        Set<CreativeTabs> tabs = new ObjectArraySet<>(additionalCreativeTabs);
        tabs.addAll(Arrays.asList(defaultCreativeTabs));
        return tabs.toArray(new CreativeTabs[0]);
    }

    @Override
    public ModularUI createUI(PlayerInventoryHolder holder, EntityPlayer entityPlayer) {
        ItemStack itemStack = holder.getCurrentItem();
        T metaValueItem = getItem(itemStack);
        ItemUIFactory uiFactory = metaValueItem == null ? null : metaValueItem.getUIManager();
        return uiFactory == null ? null : uiFactory.createUI(holder, entityPlayer);
    }

    // IOverlayRenderAware
    @Override
    public void renderItemOverlayIntoGUI(@NotNull ItemStack stack, int xPosition, int yPosition) {
        ToolChargeBarRenderer.renderBarsItem(this, stack, xPosition, yPosition);
    }



    @Override @SideOnly(Side.CLIENT)
    public boolean shouldDrawHalo(ItemStack stack) {
        T metaValueItem = getItem(stack);
        if (metaValueItem == null){
            return false;
        }
        return metaValueItem.registerHalo(stack);
    }

    @Override @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getHaloTexture(ItemStack stack) {
        T metaValueItem = getItem(stack);
        assert metaValueItem != null;
        if (metaValueItem.registerHaloTexture(stack) == 1){
            return AvaritiaTextures.HALO;
        } else if (metaValueItem.registerHaloTexture(stack) == 2){
            return AvaritiaTextures.HALO_NOISE;
        }
        return null;
    }

    @Override @SideOnly(Side.CLIENT)
    public int getHaloColour(ItemStack stack) {
        T metaValueItem = getItem(stack);
        if (metaValueItem == null){
            return 0;
        }
        return metaValueItem.registerHaloColour(stack);
    }

    @Override @SideOnly(Side.CLIENT)
    public int getHaloSize(ItemStack stack) {
        T metaValueItem = getItem(stack);
        if (metaValueItem == null){
            return 0;
        }
        return metaValueItem.registerHaloSize(stack);
    }

    @Override @SideOnly(Side.CLIENT)
    public boolean shouldDrawPulse(ItemStack stack) {
        T metaValueItem = getItem(stack);
        if (metaValueItem == null){
            return false;
        }
        return metaValueItem.registerHaloPulse(stack);
    }

    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getMaskTexture(ItemStack stack, EntityLivingBase player) {
        T metaValueItem = getItem(stack);
        assert metaValueItem != null;
        if (metaValueItem.registerMaskTexture(stack) == 1){
            return GTHHCosmicTextures.PROCESSOR;
        } else if (metaValueItem.registerMaskTexture(stack) == 2){
            return GTHHCosmicTextures.ASSEMBLY;
        } else if (metaValueItem.registerMaskTexture(stack) == 3){
            return GTHHCosmicTextures.COMPUTER;
        } else if (metaValueItem.registerMaskTexture(stack) == 4){
            return GTHHCosmicTextures.MAINFRAME;
        } else if (metaValueItem.registerMaskTexture(stack) == 5){
            return GTHHCosmicTextures.BOARD;
        } else if (metaValueItem.registerMaskTexture(stack) == 6){
            return GTHHCosmicTextures.CIRCUIT_BOARD;
        } else if (metaValueItem.registerMaskTexture(stack) == 7){
            return GTHHCosmicTextures.SMD;
        } else if (metaValueItem.registerMaskTexture(stack) == 8){
            return GTHHCosmicTextures.SMALL_BATTERY;
        } else if (metaValueItem.registerMaskTexture(stack) == 9){
            return GTHHCosmicTextures.MEDIUM_BATTERY;
        } else if (metaValueItem.registerMaskTexture(stack) == 10){
            return GTHHCosmicTextures.LARGE_BATTERY;
        } else
        return AvaritiaTextures.INFINITY_SWORD_MASK;
    }


    @SideOnly(Side.CLIENT)
    public float getMaskOpacity(ItemStack stack, EntityLivingBase player) {
        T metaValueItem = getItem(stack);
        if (metaValueItem == null){
            return 0.0f;
        }
        return metaValueItem.registerMaskOpacity(stack);
    }

    public static class GTHHCosmicTextures implements TextureUtils.IIconRegister {
        private static TextureMap map;
        public static TextureAtlasSprite PROCESSOR;
        public static TextureAtlasSprite ASSEMBLY;
        public static TextureAtlasSprite COMPUTER;
        public static TextureAtlasSprite MAINFRAME;
        public static TextureAtlasSprite BOARD;
        public static TextureAtlasSprite CIRCUIT_BOARD;
        public static TextureAtlasSprite SMD;
        public static TextureAtlasSprite SMALL_BATTERY;
        public static TextureAtlasSprite MEDIUM_BATTERY;
        public static TextureAtlasSprite LARGE_BATTERY;

        public GTHHCosmicTextures() {
        }

        public void registerIcons(TextureMap textureMap) {
            map = textureMap;
            PROCESSOR = register("gthhcore:items/cosmic/mask/processor");
            ASSEMBLY = register("gthhcore:items/cosmic/mask/assembly");
            COMPUTER = register("gthhcore:items/cosmic/mask/computer");
            MAINFRAME = register("gthhcore:items/cosmic/mask/mainframe");
            BOARD = register("gthhcore:items/cosmic/mask/board");
            CIRCUIT_BOARD = register("gthhcore:items/cosmic/mask/circuit_board");
            SMD = register("gthhcore:items/cosmic/mask/smd");
            SMALL_BATTERY = register("gthhcore:items/cosmic/mask/small_battery");
            MEDIUM_BATTERY = register("gthhcore:items/cosmic/mask/medium_battery");
            LARGE_BATTERY = register("gthhcore:items/cosmic/mask/large_battery");

        }
        private static TextureAtlasSprite register(String sprite) {
            return map.registerSprite(new ResourceLocation(sprite));
        }
    }

    public class GTHHMetaValueItem {

        public GTHHMetaItem<T> getMetaItem() {
            return GTHHMetaItem.this;
        }

        public final int metaValue;

        private IItemNameProvider nameProvider;
        private IItemMaxStackSizeProvider stackSizeProvider;
        private IItemContainerItemProvider containerItemProvider;
        private ISubItemHandler subItemHandler = DefaultSubItemHandler.INSTANCE;
        public final String unlocalizedName;

        private final List<IItemComponent> allStats = new ArrayList<>();
        private final List<IItemBehaviour> behaviours = new ArrayList<>();
        private IItemUseManager useManager;
        private ItemUIFactory uiManager;
        private IItemColorProvider colorProvider;
        private IItemDurabilityManager durabilityManager;
        private IEnchantabilityHelper enchantabilityHelper;
        private EnumRarity rarity;

        private int burnValue = 0;
        private int maxStackSize = 64;
        private int modelAmount = 1;


        @Nullable
        private CreativeTabs[] creativeTabsOverride;


        private boolean drawHalo;
        private int haloTexture;
        private int haloColour;
        private int haloSize;
        private boolean haloPulse;
        private int maskTexture;
        private float maskOpacity;



        protected GTHHMetaValueItem(int metaValue, String unlocalizedName) {
            this.metaValue = metaValue;
            this.unlocalizedName = unlocalizedName;
        }

        public GTHHMetaValueItem setMaterialInfo(ItemMaterialInfo materialInfo) {
            if (materialInfo == null) {
                throw new IllegalArgumentException("Cannot add null ItemMaterialInfo.");
            }
            OreDictUnifier.registerOre(getStackForm(), materialInfo);
            return this;
        }

        public GTHHMetaValueItem setUnificationData(OrePrefix prefix, @Nullable Material material) {
            if (prefix == null) {
                throw new IllegalArgumentException("Cannot add null OrePrefix.");
            }
            OreDictUnifier.registerOre(getStackForm(), prefix, material);
            return this;
        }

        public GTHHMetaValueItem addOreDict(String oreDictName) {
            if (oreDictName == null) {
                throw new IllegalArgumentException("Cannot add null OreDictName.");
            }
            OreDictionary.registerOre(oreDictName, getStackForm());
            return this;
        }

        public GTHHMetaValueItem addOreDict(OreDictNames oreDictName) {
            if (oreDictName == null) {
                throw new IllegalArgumentException("Cannot add null OreDictName.");
            }
            OreDictionary.registerOre(oreDictName.name(), getStackForm());
            return this;
        }

        public GTHHMetaValueItem setCreativeTabs(CreativeTabs... tabs) {
            this.creativeTabsOverride = tabs;
            GTHHMetaItem.this.addAdditionalCreativeTabs(tabs);
            return this;
        }

        public GTHHMetaValueItem setInvisibleIf(boolean hide) {
            if (hide) this.creativeTabsOverride = new CreativeTabs[0];
            return this;
        }
        public GTHHMetaValueItem setInvisible() {
            this.creativeTabsOverride = new CreativeTabs[0];
            return this;
        }

        public GTHHMetaValueItem setMaxStackSize(int maxStackSize) {
            if (maxStackSize <= 0) {
                throw new IllegalArgumentException("Cannot set Max Stack Size to negative or zero value.");
            }
            this.maxStackSize = maxStackSize;
            return this;
        }

        public GTHHMetaValueItem setBurnValue(int burnValue) {
            if (burnValue <= 0) {
                throw new IllegalArgumentException("Cannot set Burn Value to negative or zero number.");
            }
            this.burnValue = burnValue;
            return this;
        }

        public GTHHMetaValueItem disableModelLoading() {
            this.modelAmount = 0;
            return this;
        }

        public GTHHMetaValueItem setModelAmount(int modelAmount) {
            if (modelAmount <= 0) {
                throw new IllegalArgumentException("Cannot set amount of models to negative or zero number.");
            }
            this.modelAmount = modelAmount;
            return this;
        }

        public GTHHMetaValueItem setRarity(EnumRarity rarity) {
            this.rarity = rarity;
            return this;
        }

        public GTHHMetaValueItem addComponents(IItemComponent... stats) {
            addItemComponentsInternal(stats);
            return this;
        }

        public GTHHMetaValueItem cosmicProperties(boolean shouldDrawHalo, int haloTexturePath, int haloColourInt, int haloSizeInt) {
            this.drawHalo = shouldDrawHalo;
            this.haloTexture = haloTexturePath;
            this.haloColour = haloColourInt;
            this.haloSize = haloSizeInt;
            return this;
        }
        public GTHHMetaValueItem cosmicProperties(boolean shouldDrawHalo, int haloTexturePath, int haloColourInt, int haloSizeInt, boolean shouldDrawHaloPulse) {
            this.drawHalo = shouldDrawHalo;
            this.haloTexture = haloTexturePath;
            this.haloColour = haloColourInt;
            this.haloSize = haloSizeInt;
            this.haloPulse = shouldDrawHaloPulse;
            return this;
        }
        public GTHHMetaValueItem cosmicProperties(boolean shouldDrawHalo, int haloTexturePath, int haloColourInt, int haloSizeInt, boolean shouldDrawHaloPulse, int maskTextureString, float maskOpacityFloat) {
            this.drawHalo = shouldDrawHalo;
            this.haloTexture = haloTexturePath;
            this.haloColour = haloColourInt;
            this.haloSize = haloSizeInt;
            this.haloPulse = shouldDrawHaloPulse;
            this.maskTexture = maskTextureString;
            this.maskOpacity = maskOpacityFloat;
            return this;
        }

        protected void addItemComponentsInternal(IItemComponent... stats) {
            for (IItemComponent itemComponent : stats) {
                if (itemComponent instanceof IItemNameProvider) {
                    this.nameProvider = (IItemNameProvider) itemComponent;
                }
                if (itemComponent instanceof IItemMaxStackSizeProvider) {
                    this.stackSizeProvider = (IItemMaxStackSizeProvider) itemComponent;
                }
                if (itemComponent instanceof ISubItemHandler) {
                    this.subItemHandler = (ISubItemHandler) itemComponent;
                }
                if (itemComponent instanceof IItemContainerItemProvider) {
                    this.containerItemProvider = (IItemContainerItemProvider) itemComponent;
                }
                if (itemComponent instanceof IItemDurabilityManager) {
                    this.durabilityManager = (IItemDurabilityManager) itemComponent;
                }
                if (itemComponent instanceof IItemUseManager) {
                    this.useManager = (IItemUseManager) itemComponent;
                }
                if (itemComponent instanceof IFoodBehavior) {
                    this.useManager = new FoodUseManager((IFoodBehavior) itemComponent);
                }
                if (itemComponent instanceof ItemUIFactory)
                    this.uiManager = (ItemUIFactory) itemComponent;

                if (itemComponent instanceof IItemColorProvider) {
                    this.colorProvider = (IItemColorProvider) itemComponent;
                }
                if (itemComponent instanceof IItemBehaviour) {
                    this.behaviours.add((IItemBehaviour) itemComponent);
                    ((IItemBehaviour) itemComponent).addPropertyOverride(getMetaItem());
                }
                if (itemComponent instanceof IEnchantabilityHelper) {
                    this.enchantabilityHelper = (IEnchantabilityHelper) itemComponent;
                }
                this.allStats.add(itemComponent);
            }
        }

        public int getMetaValue() {
            return metaValue;
        }

        public List<IItemComponent> getAllStats() {
            return Collections.unmodifiableList(allStats);
        }

        public List<IItemBehaviour> getBehaviours() {
            return Collections.unmodifiableList(behaviours);
        }

        public ISubItemHandler getSubItemHandler() {
            return subItemHandler;
        }

        @Nullable
        public IItemDurabilityManager getDurabilityManager() {
            return durabilityManager;
        }

        @Nullable
        public IItemUseManager getUseManager() {
            return useManager;
        }

        @Nullable
        public ItemUIFactory getUIManager() {
            return uiManager;
        }

        @Nullable
        public IItemColorProvider getColorProvider() {
            return colorProvider;
        }

        @Nullable
        public IItemNameProvider getNameProvider() {
            return nameProvider;
        }

        @Nullable
        public IItemContainerItemProvider getContainerItemProvider() {
            return containerItemProvider;
        }

        @Nullable
        public IEnchantabilityHelper getEnchantabilityHelper() {
            return enchantabilityHelper;
        }

        public int getBurnValue() {
            return burnValue;
        }

        public int getMaxStackSize(ItemStack stack) {
            return stackSizeProvider == null ? maxStackSize : stackSizeProvider.getMaxStackSize(stack, maxStackSize);
        }

        public boolean isVisible() {
            return creativeTabsOverride == null || creativeTabsOverride.length > 0;
        }

        public int getModelAmount() {
            return modelAmount;
        }

        public EnumRarity getRarity() {
            return rarity;
        }

        public ItemStack getStackForm(int amount) {
            return new ItemStack(GTHHMetaItem.this, amount, GTHHMetaItemOffset + metaValue);
        }

        public boolean isItemEqual(ItemStack itemStack) {
            return itemStack.getItem() == GTHHMetaItem.this && itemStack.getItemDamage() == (GTHHMetaItemOffset + metaValue);
        }

        public ItemStack getStackForm() {
            return getStackForm(1);
        }

        public ItemStack getInfiniteChargedStack() {
            ItemStack itemStack = getStackForm(1);
            IElectricItem electricItem = itemStack.getCapability(GregtechCapabilities.CAPABILITY_ELECTRIC_ITEM, null);
            if (!(electricItem instanceof ElectricItem)) {
                throw new IllegalStateException("Not a supported electric item.");
            }
            ((ElectricItem) electricItem).setInfiniteCharge(true);
            return itemStack;
        }

        public ItemStack getChargedStack(long chargeAmount) {
            ItemStack itemStack = getStackForm(1);
            IElectricItem electricItem = itemStack.getCapability(GregtechCapabilities.CAPABILITY_ELECTRIC_ITEM, null);
            if (electricItem == null) {
                throw new IllegalStateException("Not an electric item.");
            }
            electricItem.charge(chargeAmount, Integer.MAX_VALUE, true, false);
            return itemStack;
        }

        public ItemStack getMaxChargeOverrideStack(long maxCharge) {
            ItemStack itemStack = getStackForm(1);
            IElectricItem electricItem = itemStack.getCapability(GregtechCapabilities.CAPABILITY_ELECTRIC_ITEM, null);
            if (electricItem == null) {
                throw new IllegalStateException("Not an electric item.");
            }
            if (!(electricItem instanceof ElectricItem)) {
                throw new IllegalStateException(
                        "Only standard ElectricItem implementation supported, but this item uses " +
                                electricItem.getClass());
            }
            ((ElectricItem) electricItem).setMaxChargeOverride(maxCharge);
            return itemStack;
        }

        public ItemStack getChargedStackWithOverride(IElectricItem source) {
            ItemStack itemStack = getStackForm(1);
            IElectricItem electricItem = itemStack.getCapability(GregtechCapabilities.CAPABILITY_ELECTRIC_ITEM, null);
            if (electricItem == null) {
                throw new IllegalStateException("Not an electric item.");
            }
            if (!(electricItem instanceof ElectricItem)) {
                throw new IllegalStateException(
                        "Only standard ElectricItem implementation supported, but this item uses " +
                                electricItem.getClass());
            }
            ((ElectricItem) electricItem).setMaxChargeOverride(source.getMaxCharge());
            long charge = source.discharge(Long.MAX_VALUE, Integer.MAX_VALUE, true, false, true);
            electricItem.charge(charge, Integer.MAX_VALUE, true, false);
            return itemStack;
        }

        public boolean isInCreativeTab(CreativeTabs tab) {
            CreativeTabs[] tabs = this.creativeTabsOverride != null ? this.creativeTabsOverride :
                    GTHHMetaItem.this.defaultCreativeTabs;
            return tabs.length > 0 && (tab == CreativeTabs.SEARCH || ArrayUtils.contains(tabs, tab));
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("metaValue", metaValue)
                    .append("unlocalizedName", unlocalizedName)
                    .toString();
        }

        public boolean registerHalo (ItemStack stack) {
            return drawHalo;
        }

        public int registerHaloTexture(ItemStack stack) {
            return haloTexture;

        }

        public int registerHaloColour (ItemStack stack) {
            return haloColour;
        }

        public int registerHaloSize (ItemStack stack) {
            return haloSize;
        }

        public boolean registerHaloPulse (ItemStack stack) {
            return haloPulse;
        }

        public int registerMaskTexture (ItemStack stack) {
            return maskTexture;
        }

        public float registerMaskOpacity (ItemStack stack) {
            return maskOpacity;
        }
    }
}
