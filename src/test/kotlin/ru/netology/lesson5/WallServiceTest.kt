package ru.netology.lesson5

import org.junit.Test

import org.junit.Assert.*
import org.junit.runners.Parameterized

class WallServiceTest {

    @Test fun add_checkIndex() {
        WallService.clear()
        val post = Post(
            id = 0,
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = 0,
            text = "",
            replyOwnerId = 0,
            replyPostId = 0,
            friendsOnly = false,
            comments = CommentsDesc(
                count = 0,
                canPost = false,
                groupsCanPost = false,
                canClose = false,
                canOpen = false
            ),
            copyright = Copyright(id = 0, link = "", name = "", type = ""),
            likes = Likes(count = 0, userLikes = false, canLike = false, canPublish = false),
            reposts = Reposts(count = 0, userReposted = false),
            views_count = 0,
            postType = "",
            signerId = 0,
            canPin = false,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = VkDonut(
                isDonut = false,
                paidDuration = 0,
                placeholder = "",
                canPublishFreeCopy = false,
                editMode = ""
            ),
            postponedId = 0
        )

        val result = WallService.add(post)

        assertEquals(0, result)
    }


}