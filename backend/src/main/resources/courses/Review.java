package src.main.resources.courses;

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

    public void setRating(){
        this.rating = rating;
    }

    public String getComment(){
        return comment;
    }

    public void setComment(){
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id && courseId == review.courseId && rating == review.rating && Objects.equals(comment, review.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseId, rating, comment);
    }
}
