package com.mydaytodo.template.springbootreact.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.java.Log;

@Data
@ToString
@Log
@Builder
public class ApiResponse {
    private int responseCode;
    private Object data;
    private String message; // to be populated in case of an error
}
