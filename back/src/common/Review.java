public class Review {
    private int id;
    private int courseId;
    private int rating;
    private string comment;

    public Review(int courseId, int rating, String comment){
        this.courseId = courseId;
        this.rating = rating;
        this.comment = comment;
    }

    public getCourseId(){
        return courseId;
    }

    public setCourseId(){
        this.courseId = courseId;
    }

    public getRating(){
        return rating;
    }

    public setRating(){
        this.rating = rating;
    }

    public getComment(){
        return comment;
    }

    public setComment(){
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