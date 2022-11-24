package com.example.delivery.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveFinalDirectionResource {
    @NotBlank
    @NotNull
    @Size(max = 250)
    private String name;

    public String getName() {
        return name;
    }

    public SaveFinalDirectionResource setName(String name) {
        this.name = name;
        return this;
    }
}
