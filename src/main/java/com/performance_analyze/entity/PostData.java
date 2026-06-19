package com.performance_analyze.entity;

import lombok.*;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class PostData {
    private String message;
    private ZonedDateTime createdTime;
    private int likeCount;
    private int commentCount;
}
