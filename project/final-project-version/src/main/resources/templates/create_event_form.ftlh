<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/css/create_event_form.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"> 
        <script src="https://kit.fontawesome.com/e346597b68.js" crossorigin="anonymous"></script>
        <meta name ="description" content="This is the provider side for the final Cafe Quest Version">
        <meta charset="utf-8">
        <title>Create New Event Form</title>
    </head>
    <body style="background-color: #f4efe7;">
        <div class="topbar">
            <a href="/events" style="text-decoration: none;"><img class="logo" src="/img/cafequest_logo.png" alt="cafequest_logo" height="3%"></a>
            <h5 class="page_header">Create New Event</h5>
        </div>
        <div class="form_inputs">
        <form action="/events" method="post">
            <input type="text" id="eventName" name="eventName" placeholder="Event Name" value="${event.eventName!''}" required style="text-transform:capitalize;" oninput="this.value=this.value.replace(/\b\w/g, c => c.toUpperCase())">
            <br>
            <input type="text" id="eventType" name="eventType" placeholder="Event Type" value="${event.eventType!''}" required style="text-transform:capitalize;" oninput="this.value=this.value.replace(/\b\w/g, c => c.toUpperCase())">
            <br>
            <input type="date" id="eventDate" name="eventDate" placeholder="Event Date" value="${event.eventDate!''}" required>
            <br>
            <input type="text" id="description" name="description" placeholder="Description" value="${event.description!''}" required>
            <br>
            <div class="location_select">
                <select class="text-center border-2" style="background-color: white; padding: 5px; width:400px; border-color: black; border-radius: 8px; border-width: 2px;" name="location" required>
                    <option value="Choose a cafe" class="non-option" disabled selected>Choose a cafe</option>
                    <#list cafes as cafe>
                    <option value="${cafe.cafeName}">${cafe.cafeName}</option>
                    </#list>
                </select>
            </div>
            <input class="rounded-pill" style="margin-top: 40px; background-color: black; color: white; width: 400px;" type="submit" value="Send">
        </form>
        </div>
    </body>
</html>