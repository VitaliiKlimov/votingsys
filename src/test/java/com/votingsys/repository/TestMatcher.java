package com.votingsys.repository;



import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestMatcher<T> {
    private final Class<T> clazz;
    private final String[] fieldsToIgnore;

    private TestMatcher(Class<T> clazz, String... fieldsToIgnore) {
        this.clazz = clazz;
        this.fieldsToIgnore = fieldsToIgnore;
    }

    public static <T> TestMatcher<T> usingIgnoringFieldsComparator(Class<T> clazz, String... fieldsToIgnore) {
        return new TestMatcher<>(clazz, fieldsToIgnore);
    }

    public void assertMatch(T actual, T expected) {
        assertThat(actual).usingRecursiveComparison().ignoringFields(fieldsToIgnore).isEqualTo(expected);
    }

    public void assertMatch(Iterable<T> actual, T... expected) {
        assertMatch(actual, List.of(expected));
    }

    public void assertMatch(Iterable<T> actual, Iterable<T> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields(fieldsToIgnore).isEqualTo(expected);
    }

}
