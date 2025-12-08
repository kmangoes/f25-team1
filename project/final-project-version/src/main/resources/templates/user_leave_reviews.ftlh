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
            <a href="/providers/cafes" style="text-decoration: none;"><img class="logo" src="/img/cafequest_logo.png" alt="cafequest_logo"></a> 
            <h5 class="page_header">$Leave a Review for ${cafe.cafeName}</h5>
            <button class="btn btn-primary btn-sm" onclick="location.href='/users/reviews/${cafe.cafeId}'">Add Review</button>
        </div>
        <div class="review_form">
            <form action="/users/reviews/${cafe.cafeId}" method="post">
                <input type="number" id="starRating" name="starRating" min="1" max="5" required>
                <input type="text" id="reviewText" name="reviewText" placeholder="Write your review here..." required>
                <button type="submit">Submit Review</button>
            </form>     
        </div>
    </body>
</html>