<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/css/reviews.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"> 
        <script src="https://kit.fontawesome.com/e346597b68.js" crossorigin="anonymous"></script>
        <meta charset="utf-8">
        <title>PROVIDER side view of reviews (no interaction w/ reviews)</title>
    </head>
    <body style="background-color: #f4efe7;">
        <div class="topbar">
            <a href="/providers/cafes" style="text-decoration: none;"><img class="logo" src="/img/cafequest_logo.png" alt="cafequest_logo"></a> 
            <h5 class="page_header">${cafe.cafeName} Reviews</h5>
        </div>
        <div class="reviews_section">
            <#list reviews as review>
                <div class="reviews">
                    <p><strong>${review.starRating} ★</strong></p>
                    <p>${review.reviewText}</p>
                    <p><small>By ${review.user.username}</small></p>
                </div>
            </#list>
        </div>
    </body>
</html>