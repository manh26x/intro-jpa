package com.kitclub.introjpa.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CaPheResponse {
    private Integer caPheId;
    private String caPheName;
    private String hangName;
}
