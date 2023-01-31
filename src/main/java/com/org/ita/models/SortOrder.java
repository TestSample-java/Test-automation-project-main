package com.org.ita.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SortOrder {
    FROM_CHEAP("1"),
    FROM_EXPENSIVE("2"),
    POPULAR("4");

    private final String sortOrderOption;
}

