<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"> 
        <!-- includes bootstrap -->
        <link rel="stylesheet" href="/css/login.css">
        <meta name ="description" content="This is the provider side for the final Cafe Quest Version">
        <script src="https://www.google.com/recaptcha/api.js" async defer></script> <!--for recaptcha -->
        <meta charset="utf-8">
        <title>Provider Side Login Page</title>
    </head>
    <body style="background-color:#f4efe7;">
        <div class="top_bar" style="background-color:#f4efe7;">
            <!--logo will be used as home button-->
            <img class="logo" src="/img/cafequest_logo.png" alt="cafequest_logo" width="3%" height="3%">
        </div>
        <form action="/login" method="post">
        <div class="text-center">
            <header class="fw-bold fs-5"><strong>Admin</strong> Login</header>
            <br>
            <input autocomplete="off" style="width: 400px;" type="text" name="email" placeholder="Email">  
            <br>
            <input autocomplete="off" style="width: 400px;" type="password" name="password" placeholder="Password">
            <br>
            <input class="rounded-pill" style="background-color: black; color: white; width: 400px;" type="submit" value="Login">
            <!-- recaptcha API content START -->
            <div style="display: flex; justify-content: center; width: 92%;">            
            <div class="g-recaptcha" data-sitekey="6Lfk3SIsAAAAAGjXahciVuCV2s8QqCjSDBAHdjUQ"></div>
            </div>
            <!-- recaptcha API content END -->
        </div>
        </form>
        <!-- Popup for incorrect login START -->
        <#if error??> <!--if error is an attribute, then execute if body-->
            <script>alert("${error}");</script>
        </#if>
        <!-- Popup for incorrect login END -->
        <p class="text-center"><strong>Looking for the user login? <a href="/userLogin">Go here</a></strong></p>
    </body>
</html>