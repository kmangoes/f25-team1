<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"> 
        <!-- includes bootstrap -->
        <link rel="stylesheet" href="/css/login.css">
        <meta name ="description" content="This is the provider side for the final Cafe Quest Version">
        <script src="https://www.google.com/recaptcha/api.js" async defer></script> <!--for recaptcha -->
        <meta charset="utf-8">
        <title>PROVIDER Side Signup Page </title>
    </head>
    <body>
        <div class="top_bar" style="background-color:#fffcf7;">
            <!--logo will be used as home button-->
            <img class="logo" src="/img/cafequest_logo.png" alt="cafequest_logo" width="3%" height="3%">
        </div>
        <form action="/provider" method="post">
        <div class="text-center">
            <header class="fw-bold fs-5" style="margin-bottom:35px;"><strong>Admin</strong> Signup</header>
            <input autocomplete="off" style="width: 400px;" type="text" name="name" placeholder="Full Name" required oninput="this.value=this.value.replace(/\b\w/g, c => c.toUpperCase())"> 
            <br>
            <input autocomplete="off" style="width: 400px;" type="text" name="username" placeholder="Username" required>
            <br>
            <input autocomplete="off" style="width: 400px;" type="text" name="email" placeholder="Email" required pattern="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$">
            <br>
            <input style="width: 400px;" type="password" name="password" placeholder="Password" required>
            <br>
            <input class="rounded-pill" style="background-color: black; color: white; width: 400px;" type="submit" value="Sign Up">
        </div>
        </form>
    </body>
</html>