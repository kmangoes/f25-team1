# Project-Name Requirements Testing
## Actors
- Provider (Admin User)
- Customer (Application User) 

### Use Cases
#### 1. Provider: Create Provider Profile:
1. Provider P1 opens application for the first time and creates a profile.
2. P1 goes back to log-in page and logs in with new credentials. (*Display error cases for incorrect user/pass and unchecked reCAPTCHA*)
3. Lands on provider dashboard to conclude use case 1. 

#### 2. Provider: User Management:  
1. Navigate to user dashboard from side navigation bar. 
2. Delete a user as an example of user management. (*And show proof of deletion in Neon Console*)

#### 3. Provider: Cafe Management: 
1. Navigate to cafe dashboard from side navigation bar.
2. Demonstrate adding/editing a cafe from provider side. (*Show proof*)
3. Demonstrate deleting a cafe from provider side. (*Show proof*)
4. Demonstrate clicking on any cafe card itself leading to Google search query.
5. Demonstrate reviews popup when clicking on cafe card. 

#### 4. Provider: Event Management:  
1. Navigate to event dashboard from side navigation bar.
2. Demonstrate adding an event from provider side, using the cafe added in use case 3. (*And show proof of addition in Neon Console*)
3. Demonstrate deleting an event from provider side. (*And show proof of deletion in Neon Console*)

#### 5. User: Create User Profile: 
1. Customer C1 opens application for the first time and creates a profile.
2. For the next use cases, C2 and C3 also create new profiles. 
3. C1 goes back to log-in page and logs in with new credentials. (*No need to display error cases again*)
4. Lands on customer dashboard to conclude.

#### 6. User: Add/Join/Leave an Event: 
1. C1 navigates to event dashboard from side navigation bar and adds an event to a pre-existing cafe.
2. C2 reloads their event dashboard to see the new event, and joins.
3. C3 reloads their event dashboard as well and joins the event, but then leaves. (*Open spots for event should update*)

#### 7. User: View/Review Cafes: 
1. C1 navigates to cafes dashboard from side navigation bar.
2. C1 leaves a positive review on the cafe they have an upcoming event at.

#### 8. User: Customize Profile: 
1. After creating profile with bare necessities, C2 goes into their profile and adds further personalization.
2. After reloading, updates show up in their profile preview on the event they've joined so other users can see what kind of people will be at the event. 


