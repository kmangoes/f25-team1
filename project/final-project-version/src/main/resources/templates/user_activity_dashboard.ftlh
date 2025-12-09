<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/css/activity_dashboard.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"> 
        <script src="https://kit.fontawesome.com/e346597b68.js" crossorigin="anonymous"></script>
        <!-- includes bootstrap -->
        <meta name ="description" content="This is the user side for the final Cafe Quest Version">
        <meta charset="utf-8">
        <title>USER-Side Activity Dashboard</title>
    </head>
    <body>
        <div class="topbar" style="background-color: #ffffff;">
            <img class="logo" src="/img/cafequest_logo.png" alt="cafequest_logo">
        </div>
        <div class="dashboard">
            <div class="side_navbar">
                <!--FIXED sidebar to navigate to all other pages-->
                <a href="/users/myActivity" style="text-decoration:none;"><p style="color: black;"><strong><i class="fa-solid fa-circle-user"></i>  My Activity</strong></p></a>
                <a href="/users/events" style="text-decoration:none;"><p style="color: black"><strong><i class="fa-solid fa-calendar"></i>   Events</strong></p></a>
                <a href="/users/cafes" style="text-decoration:none;"><p style="color: black"><strong><i class="fa-solid fa-location-dot"></i>  Cafes</strong></p></a>
                <hr>
                <a href="/users/login"><p class="logout_btn" style="color:black"><strong><i class="fa-solid fa-arrow-left"></i>  Log out</strong></p></a>
            </div> 
            <div class="main_content">
                <header class="top_elem">
                        ${user.name}'s Activity    
                </header>
                <div class="events-container">
                    <div class="created_events">
                        <p style="font-weight: bold; background-color: #ffffff !important;">Events Created</p>
                            <#list createdEvents as event>
                            <div class="event_card">
                                <p style="background-color: white!important;">${event.eventName}</p>
                                <p style="background-color: white!important;">${event.location}</p>
                                <p style="background-color: white!important;">${event.eventDate}</p>
                                <button class="edit_btn2" type="button" onclick="window.location.href='/events/delete/${event.eventId}'">Delete Event</button>
                            </div>
                            </#list>
                    </div>
                <div class="joined_events">
                        <p style="font-weight: bold; background-color: #ffffff !important;">Events Attending</p>
                            <#list joinedEvents as event>
                            <div class="event_card">
                                <p style="background-color: white!important;">${event.eventName}</p>
                                <p style="background-color: white!important;">${event.location}</p>
                                <p style="background-color: white!important;">${event.eventDate}</p>
                                <button class="edit_btn2" type="button" onclick="window.location.href='/users/events/leave/${event.eventId}'">Leave Event</button>
                            </div>
                            </#list>
                    </div>
            </div>
        </div>    
    </body>
</html>