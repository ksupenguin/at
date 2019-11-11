package ui;

import enums.LocatorType;

public class Element extends AbstractElement<Element> {

    public Element(String locatorString, LocatorType locatorType) {
        super(locatorString, locatorType);
    }
}
