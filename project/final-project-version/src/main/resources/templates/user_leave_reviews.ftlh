<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/css/reviews.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"> 
        <script src="https://kit.fontawesome.com/e346597b68.js" crossorigin="anonymous"></script>
        <meta charset="utf-8">
        <title>Page for USER to LEAVE reviews</title>
    </head>
    <body style="background-color: white;">
        <div class="topbar">
            <a href="/users/cafes" style="text-decoration: none;"><img class="logo" src="/img/cafequest_logo.png" alt="cafequest_logo"></a> 
            <h5 class="page_header">Leave a Review for ${cafe.cafeName}</h5>
        </div>
        <div>
            <form class="review_form" action="/users/reviews/${cafe.cafeId}" method="post">
                <input class="review_item" type="number" id="starRating" name="starRating" min="1" max="5" placeholder="Rate 1-5 stars" required>
                <br>
                <input class="review_item" type="description" id="reviewText" name="reviewText" placeholder="Write your review here..." required>
                <br>
                <button class="review_item" type="submit">Submit Review</button>
            </form>     
        </div>
    </body>
</html>