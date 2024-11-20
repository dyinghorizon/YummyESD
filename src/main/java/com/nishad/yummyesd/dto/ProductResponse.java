package com.nishad.yummyesd.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductResponse(
        Long id,
        String name,
        Double price
) {}
