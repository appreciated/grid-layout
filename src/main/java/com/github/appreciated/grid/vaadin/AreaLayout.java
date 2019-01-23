package com.github.appreciated.grid.vaadin;

import com.github.appreciated.grid.TemplateAreaParser;
import com.vaadin.flow.component.*;

@Tag("div")
public class AreaLayout extends Component implements HasStyle, HasOrderedComponents<Component>, HasSize, GridLayoutComponent {
    private TemplateAreaParser templateAreaParser;

    /**
     * @param components
     */
    public AreaLayout(Component... components) {
        this();
        this.add(components);
    }

    /**
     *
     */
    public AreaLayout() {
        getStyle().set("display", "grid");
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        getElement().callFunction("setAttribute", "style", "display:-ms-grid; " + getElement().getAttribute("style"));
    }
}
