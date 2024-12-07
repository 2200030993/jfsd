package com.klef.jfsd.exam.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class CommentService {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public CommentService() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    public List<Map<String, Object>> fetchAllComments() {
        String url = "https://jsonplaceholder.typicode.com/comments";
        Map<String, Object>[] comments = restTemplate.getForObject(url, Map[].class);
        return Arrays.asList(comments);
    }
}
