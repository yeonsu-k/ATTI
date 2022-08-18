package com.ssafy.api.response;

import java.time.LocalDateTime;

import com.ssafy.db.entity.depart.Post;

import lombok.Getter;

@Getter
public class PostViewOneRes {
	
	private Long postId;
	
	private String postTitle;
	
	private String postContent;
	
	private LocalDateTime postRegDate;
	
//	private LocalDateTime postUpdDate;
	
	private String userId = "익명";
	
	boolean myPostLike;
	
	Long postLikeCount;
	
	public PostViewOneRes(Post post, boolean myPostLike, Long postLikeCount) {
		this.postId = post.getPostId();
		this.postTitle = post.getPostTitle();
		this.postContent = post.getPostContent();
		this.postRegDate = post.getPostRegDate();
		if(post.getUser() != null) {
			this.userId = post.getUser().getUserId();
		}
		this.myPostLike = myPostLike;
		this.postLikeCount = postLikeCount;
	}
}
