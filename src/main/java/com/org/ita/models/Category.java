package com.org.ita.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {
    APPLE("Apple ", "6961"),
    SMARTPHONES_AND_PHONES("Смартфони і телефони", "telecommunication"),
    LAPTOPS_AND_COMPUTERS("Ноутбуки та комп'ютерна техніка", "comp-and-periphery"),
    SMART_GADGETS("Смарт-гаджети", "gadgets"),
    TABLETS_AND_EBOOK("Планшети та електронні книги", "tablet_el_knigi"),
    PHOTO_VIDEO_AUDIO("Фото, Відео, Аудіо", "foto_video"),
    TV_PROJECTORS("ТВ, проектори", "7759"),
    HOUSEHOLD_APPLIANCES("Побутова техніка", "bt"),
    ELECTRONICS_ACCESSORIES("Аксесуари до електроніки", "acsessor"),
    HOUSEHOLD_GOODS_AND_CARS("Товари для дому та авто", "tovary_dlya_doma"),
    TOOLS_AND_GARDEN_EQUIPMENT("Інструмент та садова техніка", "instrument"),
    GHILDRENS_WORLD("Дитячий світ", "detskij_mir"),
    PLAYING_AREA("Гральна зона", "game_zone"),
    SERVICES("Послуги", "uslugi"),
    DISCOUNTED_GOODS("Уцінені товари", "");

    private final String name;
    private final String linkPartForSubcategoryPopular;
}
