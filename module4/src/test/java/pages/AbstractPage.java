package pages;

import annotations.Locator;
import enums.LocatorType;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.tuple.Pair;
import reporter.Reporter;
import waiters.PageWaiter;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;

public abstract class AbstractPage {

    public AbstractPage() {
        initializeLocators(getPageFields());
    }

    private List<Field> getPageFields() {
        return FieldUtils.getAllFieldsList(this.getClass());
    }

    private void initializeLocators(List<Field> fields) {
        for (Field field : fields) {
            if (field.isAnnotationPresent(Locator.class)) {
                initializeLocator(field);
            }
        }
    }

    private void initializeLocator(Field field) {
        Locator locator = field.getAnnotation(Locator.class);
        field.setAccessible(true);
        Pair<String, LocatorType> locatorData = getLocatorData(locator);
        String locatorString = locatorData.getLeft();
        LocatorType locatorType = locatorData.getRight();

        Constructor<?> constructor;
        try {
            constructor = field.getType().getConstructor(String.class, LocatorType.class);
            field.set(this, constructor.newInstance(locatorString, locatorType));
        } catch (Exception e) {
            Reporter.error(String.format("Page Object initialization error in %s. Check Locator annotations.",
                    this.getClass().getSimpleName()));
            e.printStackTrace();
        }
    }

    private Pair<String, LocatorType> getLocatorData(Locator locator) {
        String locatorString = null;
        LocatorType locatorType = null;

        if (!locator.value().isEmpty()) {
            locatorString = locator.value();
            locatorType = LocatorType.XPATH;
        } else if (!locator.xpath().isEmpty()) {
            locatorString = locator.xpath();
            locatorType = LocatorType.XPATH;
        } else if (!locator.id().isEmpty()) {
            locatorString = locator.id();
            locatorType = LocatorType.ID;
        } else if (!locator.css().isEmpty()) {
            locatorString = locator.css();
            locatorType = LocatorType.CSS;
        } else if (!locator.name().isEmpty()) {
            locatorString = locator.name();
            locatorType = LocatorType.NAME;
        }
        return Pair.of(locatorString, locatorType);
    }

    public PageWaiter waitFor() {
        return new PageWaiter();
    }
}

