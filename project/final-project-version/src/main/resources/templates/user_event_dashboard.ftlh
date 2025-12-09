<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/css/event_dashboard.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"> 
        <script src="https://kit.fontawesome.com/e346597b68.js" crossorigin="anonymous"></script>
        <!-- includes bootstrap -->
        <meta name ="description" content="This is the user side for the final Cafe Quest Version">
        <meta charset="utf-8">
        <title>USER-Side Events Dashboard</title>
    </head>
    <body style="background-color: #ffffff">
        <div class="topbar" style="background-color: #ffffff;">
            <img class="logo" src="/img/cafequest_logo.png" alt="cafequest_logo">
        </div>
        <div class="dashboard">
        <!---split into side navbar and main content-->
            <div class="side_navbar">
                <!--FIXED sidebar to navigate to all other pages-->
                <a href="/users/myActivity" style="text-decoration:none;"><p style="color: black;"><strong><i class="fa-solid fa-circle-user"></i>  My Activity</strong></p></a>
                <a href="/users/events" style="text-decoration:none;"><p style="color: black"><strong><i class="fa-solid fa-calendar"></i>   Events</strong></p></a>
                <a href="/users/cafes" style="text-decoration:none;"><p style="color: black"><strong><i class="fa-solid fa-location-dot"></i>  Cafes</strong></p></a>
                <hr>
                <a href="/users/login"><p class="logout_btn" style="color:black"><strong><i class="fa-solid fa-arrow-left"></i>  Log out</strong></p></a>
            </div> 
            <div class="main_content">
                <!--Main content; two rows, top designating bar and rest of content-->
                <!--HEADER CHANGES based on selected option in side navbar-->
                <header class="top_elem">
                        Upcoming Events     
                        <button class="edit_btn1" type="button" onclick="window.location.href='/users/events/createForm'">Add Event</button>
                </header>
                <main> 
                    <#list events as event> 
                        <div class="event" style="background-color: white;"> <!--MAIN CONTENT MADE UP COMPLETELY OF CARDS-->
                            <button style="margin-top:145px;" class="edit_btn2" type="button" onclick="window.location.href='/users/events/join/${event.eventId}'">Join Event</button>
                            <p class="user_event_items"><strong>Event:</strong> ${event.eventName} </p>
                            <p class="user_event_items"><strong>Type:</strong> ${event.eventType}</p>
                            <p class="user_event_items"><strong>Date:</strong> ${event.eventDate}</p>
                            <p class="user_event_items"><strong>Location:</strong> ${event.location}</p>
                        </div>
                    </#list>
                </main>
            </div>
        </div>
    </body>
</html>