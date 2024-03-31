/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Dataclass;

import Firebase.UserLoginToken;
/**
 *
 * @author phump
 */
public class CommentData {
    public static final String AUTHOR_FIELD_NAME = "author";
    public static final String COMMENT_FIELD_NAME = "comment";
    public static final String RATING_FIELD_NAME = "rating";
    
    private String author;
    private String comment;
    private long rating;
    
    public CommentData(){
        this("", "", 0l);
    }
    
    public CommentData(String author, String comment, long rating){
        this.author = author;
        this.comment = comment;
        this.rating = rating;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }
}
