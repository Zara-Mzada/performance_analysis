package com.performance_analyze.controller;

import com.performance_analyze.entity.PostData;
import com.performance_analyze.service.MetaApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/meta")
@RequiredArgsConstructor
public class PostController {
    private final MetaApiService metaApiService;

    @GetMapping("/posts")
    public List<PostData> getPosts(){
        return metaApiService.getPosts();
    }

    @GetMapping("/analysis")
    public Map<String, Object> getAnalysis(){
        return metaApiService.getSummary();
    }
}
