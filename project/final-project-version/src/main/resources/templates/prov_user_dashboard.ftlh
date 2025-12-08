<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name ="description" content="This is the provider side for the final Cafe Quest Version">
        <title>User Dashboard</title>
        <link rel="stylesheet" href="/css/user_dashboard.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"> 
        <script src="https://kit.fontawesome.com/e346597b68.js" crossorigin="anonymous"></script>
        <title>Provider-Side Dashboard of Active Users</title>
    </head>
    <body style="background-color: #f4efe7"> 
        <div class="topbar">
            <img class="logo" src="/img/cafequest_logo.png" alt="cafequest_logo">
        </div>
        <div class="dashboard">
            <div class="side_navbar">
                <!--FIXED sidebar to navigate to all other pages-->
                <p><strong><i class="fa-solid fa-circle-user"></i>   Users</strong></p>
                <a href="/events" style="text-decoration:none;"><p><strong><i class="fa-solid fa-calendar"></i>   Events</strong></p></a>
                <a href="/providers/cafes" style="text-decoration:none;"><p style="color: black"><strong><i class="fa-solid fa-location-dot"></i>  Cafes</strong></p></a>
                <hr>
                <a href="/provider/login"><p class="logout_btn" style="color:black"><strong><i class="fa-solid fa-arrow-left"></i>  Log out</strong></p></a>
            </div>

            
        </div>
    </body>
</html>