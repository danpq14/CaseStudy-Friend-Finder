package com.friend.finder.modelFake;

import com.friend.finder.models.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentFake {
    private String content;
    private String accountName;
    private String firstName;
    private String lastName;
    private String image;


    public CommentFake() {
    }

    public CommentFake(String content, String accountName, String firstName, String lastName, String image) {
        this.content = content;
        this.accountName = accountName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public List<CommentFake> getContentComment(List<Comment> commentList){
        List<CommentFake> list=new ArrayList<>();
        for (int i = 0; i <commentList.size(); i++) {
            String content=commentList.get(i).getContent();
            String account=commentList.get(i).getAccount().getUsername();
            String firstName=commentList.get(i).getAccount().getProfile().getFirstName();
            String lastName=commentList.get(i).getAccount().getProfile().getLastName();
            String image=commentList.get(i).getAccount().getProfile().getAvatar();
            list.add(new CommentFake(content,account,firstName,lastName,image));
        }
        return list;
    }
}
