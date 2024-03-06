package com.example.marketplaceservice.dto.request;

import java.util.List;
import lombok.Data;

@Data
public class GetPixelsRequestDto {
    private List<String> pixelIds;
}
