package src.common;

import java.util.Objects;

public class Review {
    private int id;
    private int courseId;
    private int rating;
    private String comment;

    public Review(int courseId, int rating, String comment){
        this.courseId = courseId;
        this.rating = rating;
        this.comment = comment;
    }

    public int getCourseId(){
        return courseId;
    }

    public void setCourseId(int courseId){
        this.courseId = courseId;
    }

    public int getRating(){
        return rating;
    }

    public void setRating(int rating){
        this.rating = rating;
    }

    public String getComment(){
        return comment;
    }

    public void setComment(){
        this.comment = comment;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Review review = (Review) object;
        return id == review.id && courseId == review.courseId && rating == review.rating && java.util.Objects.equals(comment, review.comment);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), id, courseId, rating, comment);
    }
}