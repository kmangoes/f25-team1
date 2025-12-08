<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/css/event_dashboard.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"> 
        <script src="https://kit.fontawesome.com/e346597b68.js" crossorigin="anonymous"></script>
        <!-- includes bootstrap -->
        <meta name ="description" content="This is the provider side for the final Cafe Quest Version">
        <meta charset="utf-8">
        <title>Provider-Side Events Dashboard</title>
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
                <a href="/events" style="text-decoration:none;"><p style="color:black;"><strong><i class="fa-solid fa-calendar"></i>   Events</strong></p></a>
                <a href="/cafes" style="text-decoration:none;"><p style="color: black;"><strong><i class="fa-solid fa-location-dot"></i>  Cafes</strong></p></a>
                <hr>
                <a href="/login" style="color: black; text-decoration:none;"><p class="logout_btn"><strong><i class="fa-solid fa-arrow-left"></i>   Log out</strong></p></a>
            </div>
            <div class="main_content">
                <!--Main content; two rows, top designating bar and rest of content-->
                <!--HEADER CHANGES based on selected option in side navbar-->
                <header class="top_elem">
                        Upcoming Events     
                        <button class="edit_btn1" type="button" onclick="window.location.href='/events/createForm'">Add Event</button>
                </header>
                <main> 
                    <#list eventsList as event> 
                        <div class="event"> <!--MAIN CONTENT MADE UP COMPLETELY OF CARDS-->
                            <button style="margin-top: 145px;" class="edit_btn2" type="button" onclick="window.location.href='events/delete/${event.eventId}'">Remove Event</button>
                            <p class="event_items"><strong>Event:</strong> ${event.eventName} </p>
                            <p class="event_items"><strong>Type:</strong> ${event.eventType}</p>
                            <p class="event_items"><strong>Date:</strong> ${event.eventDate}</p>
                            <p class="event_items"><strong>Location:</strong> ${event.location}</p>
                        </div>
                    </#list>
                </main>
            </div>
        </div>
    </body>
</html>