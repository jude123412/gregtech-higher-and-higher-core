package org.gthhcore.common.items.metaitem;

public class GTHHStandardMetaItem extends GTHHMetaItem<GTHHMetaItem<?>.GTHHMetaValueItem> {
    public GTHHStandardMetaItem() {
        super((short) 0);
    }
    public GTHHStandardMetaItem(short GTHHMetaItemOffset) {
        super(GTHHMetaItemOffset);
    }
    @Override
    protected GTHHMetaValueItem constructMetaValueItem(short metaValue, String unlocalizedName) {
        return new GTHHMetaValueItem(metaValue, unlocalizedName);
    }
}
