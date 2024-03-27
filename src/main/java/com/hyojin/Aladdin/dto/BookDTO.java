package com.hyojin.Aladdin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private String version;
    private String logo;
    private String title;
    private String link;
    private String pubDate;
    private int totalResults;
    private int startIndex;
    private int itemsPerPage;
    private String query;
    private int searchCategoryId;
    private String searchCategoryName;
    private List<Item> item;

    @Getter @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Item {
        private String title;
        private String author;
        private String publisher;
        private String pubDate;
        private int priceStandard;
        private String isbn13;
        private String categoryName;
        private String cover;
        private String link;

        private String description;
        private subInfo subInfo;

    }
    @Getter @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class subInfo {
        private int itemPage;
        private String originalTitle;

    }

}
