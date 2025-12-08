<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/css/cafe_dashboard.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"> 
        <script src="https://kit.fontawesome.com/e346597b68.js" crossorigin="anonymous"></script>
        <!-- includes bootstrap -->
        <meta name ="description" content="This is the provider side for the final Cafe Quest Version">
        <meta charset="utf-8">
        <title>Provider-Side Cafes Dashboard</title>
    </head>
    <body style="background-color: #f4efe7">
        <div class="topbar">
            <img class="logo" src="/img/cafequest_logo.png" alt="cafequest_logo">
        </div>
        <div class="dashboard">
        <!---split into side navbar and main content-->
            <div class="side_navbar">
                <!--FIXED sidebar to navigate to all other pages-->
                <p><strong><i class="fa-solid fa-circle-user"></i>   Users</strong></p>
                <a href="/events" style="text-decoration:none;"><p><strong><i class="fa-solid fa-calendar"></i>   Events</strong></p></a>
                <a href="/cafes" style="text-decoration:none;"><p style="color: black"><strong><i class="fa-solid fa-location-dot"></i>  Cafes</strong></p></a>
                <hr>
                <a href="/login"><p class="logout_btn" style="color:black"><strong><i class="fa-solid fa-arrow-left"></i>  Log out</strong></p></a>
            </div>
            <div class="main_content">
                <!--Main content; two rows, top designating bar and rest of content-->
                <!--HEADER CHANGES based on selected option in side navbar-->
                <header class="top_elem">
                        Cafe Management     
                        <button class="edit_btn1" type="button" onclick="window.location.href='/cafes/createForm'">Add Cafe</button>
                </header>
                <#list cafesList as cafe> <!-- START cafes loop -->
                <main> 
                    <div class="cafe" onclick="window.open('https://www.google.com/search?q=${cafe.cafeName?url}')"> <!--MAIN CONTENT MADE UP COMPLETELY OF CARDS-->
                            <button class="edit_btn2" type="button" onclick="event.stopPropagation(); window.location.href='cafes/delete/${cafe.cafeId}'">Remove Cafe</button>
                            <button class="edit_btn2" type="button" onclick="event.stopPropagation(); window.location.href='cafes/updateForm/${cafe.cafeId}'">Edit Cafe</button>
                            <button class="edit_btn2" type="button" onclick="event.stopPropagation(); window.location.href='reviews/${cafe.cafeId}'">View Reviews</button>
                            <p class="cafe_items"><strong>Cafe:</strong> ${cafe.cafeName} </p>
                            <p class="cafe_items"><strong>Location:</strong> ${cafe.address}</p>
                            <p class="cafe_items"><strong>Hours:</strong> ${cafe.hours}</p>
                    </div>
                </main>
                </#list> <!-- END cafes loop -->
            </div>
        </div>
    </body>
</html>