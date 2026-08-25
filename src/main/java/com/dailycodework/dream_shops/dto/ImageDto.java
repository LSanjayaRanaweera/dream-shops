package com.dailycodework.dream_shops.dto;

import lombok.Data;

@Data                                       //from lombok
public class ImageDto {
    private Long imageId;
    private String imageName;
    private String downloadUrl;

}
