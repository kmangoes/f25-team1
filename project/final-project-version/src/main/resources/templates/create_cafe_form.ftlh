<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/css/create_cafe_form.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"> 
        <script src="https://kit.fontawesome.com/e346597b68.js" crossorigin="anonymous"></script>
        <meta name ="description" content="This is the provider side for the final Cafe Quest Version">
        <meta charset="utf-8">
        <title>Create New Cafe Form</title>
    </head>
    <body style="background-color: #f4efe7;">
        <div class="topbar">
            <a href="/cafes" style="text-decoration: none;"><img class="logo" src="/img/cafequest_logo.png" alt="cafequest_logo" height="3%"></a>
            <h5 class="page_header">Create New Cafe</h5>
        </div>
        <div class="form_inputs">
        <form action="/cafes" method="post">
            <input type="text" id="cafeName" name="cafeName" placeholder="Cafe Name" value="${cafe.cafeName!''}" required style="text-transform: capitalize;" oninput="this.value=this.value.replace(/\b\w/g, c => c.toUpperCase())">
            <br>
            <input type="text" id="address" name="address" placeholder="Address" value="${cafe.address!''}" required style="text-transform: capitalize;" oninput="this.value=this.value.replace(/\b\w/g, c => c.toUpperCase())">
            <br>
            <input type="text" id="hours" name="hours" placeholder="Hours (Format: XX:XX AM - XX:XX PM)" value="${cafe.hours!''}" required pattern="^(0?[1-9]|1[0-2]):[0-5][0-9] (AM|PM|am|pm) - (0?[1-9]|1[0-2]):[0-5][0-9] (AM|PM|am|pm)$">
            <br>
            <input type="text" id="description" name="description" placeholder="Description" value="${cafe.description!''}" required>
            <br>
            <input type="number" step="0.01" id="rating" name="rating" placeholder="Rating (0.00 - 5.00)" value="${cafe.rating!''}" required>
            <br>
            <input class="rounded-pill" style="background-color: black; color: white; width: 400px;" type="submit" value="Send">
        </form>
        </div>
    </body>
</html>