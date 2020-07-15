package com.friend.finder.nodelFake;

import com.friend.finder.models.Post;

import java.util.List;

public class PostFake {
    private String accountName;
    private String content;
    private String comment;
    private String image;

    public PostFake(String accountName, String content, String comment, String image) {
        this.accountName = accountName;
        this.content = content;
        this.comment = comment;
        this.image = image;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


//    public List<PostFake> getPostContent(List<Post> postList){
//        for(Post post : postList)
//    }
}
