package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForumStatisticsTest {
    private Statistics statisticsMock;
    private ForumStatistics forumStatistics;

    @BeforeEach
    void setUp() {
        statisticsMock = Mockito.mock(Statistics.class);
        forumStatistics = new ForumStatistics();
    }

    @Test
    void testCalculateAdvStatistics_ZeroPosts() {
        List<String> users = Arrays.asList("user1", "user2", "user3");
        Mockito.when(statisticsMock.usersNames()).thenReturn(users);
        Mockito.when(statisticsMock.postsCount()).thenReturn(0);
        Mockito.when(statisticsMock.commentsCount()).thenReturn(10);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(0, forumStatistics.getAvgPostsPerUser());
    }

    @Test
    void testCalculateAdvStatistics_ThousandPosts() {
        List<String> users = Arrays.asList("user1", "user2", "user3");
        Mockito.when(statisticsMock.usersNames()).thenReturn(users);
        Mockito.when(statisticsMock.postsCount()).thenReturn(1000);
        Mockito.when(statisticsMock.commentsCount()).thenReturn(500);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(333.33, forumStatistics.getAvgPostsPerUser(), 0.01);
    }

    @Test
    void testCalculateAdvStatistics_ZeroComments() {
        List<String> users = Arrays.asList("user1", "user2", "user3");
        Mockito.when(statisticsMock.usersNames()).thenReturn(users);
        Mockito.when(statisticsMock.postsCount()).thenReturn(100);
        Mockito.when(statisticsMock.commentsCount()).thenReturn(0);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(0, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatistics_CommentsLessThanPosts() {
        List<String> users = Arrays.asList("user1", "user2", "user3");
        Mockito.when(statisticsMock.usersNames()).thenReturn(users);
        Mockito.when(statisticsMock.postsCount()).thenReturn(100);
        Mockito.when(statisticsMock.commentsCount()).thenReturn(50);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(0.5, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatistics_CommentsMoreThanPosts() {
        List<String> users = Arrays.asList("user1", "user2", "user3");
        Mockito.when(statisticsMock.usersNames()).thenReturn(users);
        Mockito.when(statisticsMock.postsCount()).thenReturn(50);
        Mockito.when(statisticsMock.commentsCount()).thenReturn(100);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(2, forumStatistics.getAvgCommentsPerPost());
    }

    @Test
    void testCalculateAdvStatistics_ZeroUsers() {
        List<String> users = new ArrayList<>();
        Mockito.when(statisticsMock.usersNames()).thenReturn(users);
        Mockito.when(statisticsMock.postsCount()).thenReturn(100);
        Mockito.when(statisticsMock.commentsCount()).thenReturn(200);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(0, forumStatistics.getAvgPostsPerUser());
    }

    @Test
    void testCalculateAdvStatistics_HundredUsers() {
        List<String> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            users.add("user" + i);
        }
        Mockito.when(statisticsMock.usersNames()).thenReturn(users);
        Mockito.when(statisticsMock.postsCount()).thenReturn(500);
        Mockito.when(statisticsMock.commentsCount()).thenReturn(1000);

        forumStatistics.calculateAdvStatistics(statisticsMock);

        assertEquals(5, forumStatistics.getAvgPostsPerUser());
    }
}