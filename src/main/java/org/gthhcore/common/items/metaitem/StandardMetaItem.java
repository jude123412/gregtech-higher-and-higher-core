package org.gthhcore.common.items.metaitem;
import org.gthhcore.common.items.metaitem.GTHHMetaItem;

public class StandardMetaItem extends GTHHMetaItem<GTHHMetaItem<?>.GTHHMetaValueItem> {
    public StandardMetaItem() {
        super((short) 0);
    }
    public StandardMetaItem(short GTHHMetaItemOffset) {
        super(GTHHMetaItemOffset);
    }
    @Override
    protected GTHHMetaValueItem constructMetaValueItem(short metaValue, String unlocalizedName) {
        return new GTHHMetaValueItem(metaValue, unlocalizedName);
    }
}
