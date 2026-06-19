package com.performance_analyze.service;

import com.performance_analyze.entity.PostData;
import com.performance_analyze.utils.UtilMethods;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MetaApiService {
    @Value("${meta.access.token}")
    private String accessToken;

    @Value("${meta.page.id}")
    private String pageId;

    private final UtilMethods utilMethods;

    public List<PostData> getPosts(){
        return getMockPosts();
    }

    public List<PostData> getMockPosts(){
        return List.of(new PostData("Exploring the future of AI in healthcare 🏥", ZonedDateTime.now().minusDays(1), 245, 38),
                new PostData("Monday motivation: Start your week strong 💪", ZonedDateTime.now().minusDays(16), 189, 22),
                new PostData("Our team just hit 10,000 followers! Thank you all ❤️", ZonedDateTime.now().minusDays(3), 512, 97),
                new PostData("Weekend vibes at the office 🎉", ZonedDateTime.now().minusDays(4), 301, 45),
                new PostData("New blog post: Top 5 productivity tips for developers", ZonedDateTime.now().minusDays(5), 134, 19),
                new PostData("Happy Friday everyone! What are your plans? 🎊", ZonedDateTime.now().minusDays(16), 278, 63),
                new PostData("Tech talk: Why microservices matter in 2024", ZonedDateTime.now().minusDays(7), 167, 31),
                new PostData("Behind the scenes of our latest project 🚀", ZonedDateTime.now().minusDays(8), 423, 78),
                new PostData("Wednesday wisdom: Never stop learning 📚", ZonedDateTime.now().minusDays(9), 98, 14),
                new PostData("Just launched our new website! Check it out 🌐", ZonedDateTime.now().minusDays(10), 634, 112),
                new PostData("Team lunch at our favourite spot 🍕", ZonedDateTime.now().minusDays(10), 356, 54),
                new PostData("Tuesday tip: Use keyboard shortcuts to save time ⌨️", ZonedDateTime.now().minusDays(12), 112, 17),
                new PostData("Throwback to our first office 🏢", ZonedDateTime.now().minusDays(13), 445, 89),
                new PostData("Sunday reading recommendations 📖", ZonedDateTime.now().minusDays(14), 203, 28),
                new PostData("We are hiring! Join our amazing team 🎯", ZonedDateTime.now().minusDays(15), 567, 134),
                new PostData("Saturday coding session ☕", ZonedDateTime.now().minusDays(16), 289, 41),
                new PostData("Congratulations to our employee of the month! 🏆", ZonedDateTime.now().minusDays(17), 478, 86),
                new PostData("Friday fun facts about programming 💡", ZonedDateTime.now().minusDays(18), 321, 52),
                new PostData("Spring Boot vs Node.js — which do you prefer? 🤔", ZonedDateTime.now().minusDays(19), 398, 143),
                new PostData("Thank you for 1 million impressions this month! 🎉", ZonedDateTime.now().minusDays(20), 721, 167)
        );
    }


//    Analyze

    public Map<String, Object> getSummary(){
        Map<String, Object> summary = new HashMap<>();

        var likes = getPosts().stream()
                .mapToInt(PostData::getLikeCount)
                .average()
                .orElse(0);

        var comments = getPosts().stream()
                .mapToInt(PostData::getCommentCount)
                .average()
                .orElse(0);

        var bestDay = utilMethods.getLikesByDayOfWeek(getPosts()).entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("not found");

        summary.put("Top 3 posts by engagement: ", utilMethods.getTop3ByEngagement(getPosts()));
        summary.put("Average likes: ", likes);
        summary.put("Average comments: ", comments);
        summary.put("The best day: ", bestDay);
        summary.put("Analysis of week: ", utilMethods.getLikesByDayOfWeek(getPosts()));

        return summary;
    }
}
