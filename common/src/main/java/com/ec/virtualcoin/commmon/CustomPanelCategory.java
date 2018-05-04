package com.ec.virtualcoin.commmon;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

import com.liferay.application.list.BasePanelCategory;
import com.liferay.application.list.PanelCategory;
import com.liferay.application.list.constants.PanelCategoryKeys;

@Component(
        immediate = true,
        property = {
            "panel.category.key=" + PanelCategoryKeys.ROOT,
            "panel.category.order:Integer=200"
        },
        service = PanelCategory.class
    )
public class CustomPanelCategory extends BasePanelCategory {

    @Override
    public String getKey() {
        return "el key";
    }

    @Override
    public String getLabel(Locale locale) {
        return "control-panel";
    }
    
}