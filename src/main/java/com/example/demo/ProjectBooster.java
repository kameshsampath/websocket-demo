package com.example.demo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectBooster {

    private String id;
    private String name;
    private String description;
}
