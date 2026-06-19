package com.performance_analyze.utils;

import com.performance_analyze.entity.PostData;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UtilMethods {

    public List<PostData> getTop3ByEngagement(List<PostData> posts){
        return posts.stream()
                .sorted(Comparator.comparingInt((PostData post)-> post.getCommentCount()+ post.getLikeCount()).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public Map<String, Integer> getLikesByDayOfWeek(List<PostData> posts){
        return posts.stream()
                .collect(Collectors.groupingBy(post -> post.getCreatedTime().getDayOfWeek().toString(),
                        Collectors.summingInt(PostData::getLikeCount)));
    }
}
