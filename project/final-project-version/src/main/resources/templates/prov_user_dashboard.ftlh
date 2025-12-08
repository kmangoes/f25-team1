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
                <a href="/providers/users" style="text-decoration:none;"><p class="side_items"style="color: black"><strong><i class="fa-solid fa-circle-user"></i>   Users</strong></p></a>
                <a href="/provider/events" style="text-decoration:none;"><p class="side_items" style="color: black"><strong><i class="fa-solid fa-calendar"></i>   Events</strong></p></a>
                <a href="/providers/cafes" style="text-decoration:none;"><p class="side_items" style="color: black"><strong><i class="fa-solid fa-location-dot"></i>  Cafes</strong></p></a>
                <hr>
                <a href="/provider/login"><p class="logout_btn" style="color:black"><strong><i class="fa-solid fa-arrow-left"></i>  Log out</strong></p></a>
            </div>
            <div class="main_content">
            <header class="top_elem">
                User Management
                <!-- Add a button later if you want provider to add users manually -->
                <!-- <button class="edit_btn1" onclick="window.location.href='/providers/users/add'">Add User</button> -->
            </header>
            <#list users as user>
            <main>
                <div class="user" style="background-color: #ffffff;">
                    <button class="edit_btn2" type="button" onclick="window.location.href='/providers/users/${user.userId}/details'">View Profile</button>
                    <button class="edit_btn2" type="button" onclick="window.location.href='/users/delete/${user.userId}'"> Delete User </button>
                    <p class="user_items"><strong>Name:</strong> ${user.name}</p>
                    <p class="user_items"><strong>Email:</strong> ${user.email}</p>
                    <p class="user_items"><strong>Major:</strong> ${user.username}</p>
                </div>
            </main>
            </#list>
        </div>
        </div>
    </body>
</html>