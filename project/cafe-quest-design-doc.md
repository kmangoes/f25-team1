# Cafe Quest - Software Design 

Version 1.0  
Prepared by Chase Solano, Hiwete Teshale  
Cafe Quest  
October 18, 2025  

## Table of Contents
* [Revision History](#revision-history)
* [1. Product Overview](#1-product-overview)
* [2. Use Cases](#2-use-cases)
  * [2.1 Use Case Model](#21-use-case-model)
  * [2.2 Use Case Descriptions](#22-use-case-descriptions)
    * [2.2.1 Actor: Customer (UNCG Student)](#221-actor-customer-uncg-student)
* [3. UML Class Diagram](#3-uml-class-diagram)
* [4. Database Schema](#4-database-schema)

## Revision History
| Name | Date    | Reason For Changes  | Version   |
| ---- | ------- | ------------------- | --------- |
| V1.0 | 10/09/25 | Initial Design     | 1.0       |
| V1.1 | 10/18/25 | Complete Documentation | 1.1   |

## 1. Product Overview

Cafe Quest is a web and mobile application designed specifically for University of North Carolina at Greensboro (UNCG) students to discover, rate, and engage with local coffee shops. The platform combines social networking features with location-based discovery to help students find ideal study spaces and connect with peers over coffee culture.

**Core Features:**
- **Authentication**: UNCG student verification via @uncg.edu email
- **Discovery**: Browse and search coffee shops near campus with detailed ratings
- **Social**: Connect with friends, share recommendations, and view activity
- **Events**: Create and join study sessions and social gatherings at coffee shops
- **Personalization**: Customizable profiles with themes and saved coffee orders
- **Gamification**: Earn achievement badges for various activities

**Target Users**: Current UNCG students with valid @uncg.edu email addresses

## 2. Use Cases

### 2.1 Use Case Model

![Use Case Diagram](./use-case-diagram.png)

```
                    ┌───────────────────────────────────────────────┐
                    │         Cafe Quest System                     │
                    │                                               │
                    │   ┌─────────────────────────────────┐        │
                    │   │   Authentication                │        │
     ┌──────────┐   │   │   • Sign Up                     │        │
     │          │───┼──→│   • Log In                      │        │
     │  UNCG    │   │   │   • Verify Email                │        │
     │ Student  │   │   └─────────────────────────────────┘        │
     │          │   │                                               │
     │          │   │   ┌─────────────────────────────────┐        │
     │          │───┼──→│   Coffee Shop Discovery         │        │
     │          │   │   │   • Browse Shops                │        │
     │          │   │   │   • Search & Filter             │        │
     │          │   │   │   • View Shop Details           │        │
     │          │   │   │   • View Ratings                │        │
     └──────────┘   │   └─────────────────────────────────┘        │
          │         │                                               │
          │         │   ┌─────────────────────────────────┐        │
          │         │   │   Review & Rating               │        │
          └─────────┼──→│   • Write Review                │        │
                    │   │   • Rate Study-ability          │        │
                    │   │   • Rate Comfort                │        │
                    │   │   • Rate Accessibility          │        │
                    │   │   • Rate Coffee Quality         │        │
                    │   └─────────────────────────────────┘        │
                    │                                               │
                    │   ┌─────────────────────────────────┐        │
                    │   │   Event Management              │        │
                    │   │   • Create Event                │        │
                    │   │   • Browse Events               │        │
                    │   │   • Join/RSVP Event             │        │
                    │   │   • View My Events              │        │
                    │   └─────────────────────────────────┘        │
                    │                                               │
                    │   ┌─────────────────────────────────┐        │
                    │   │   Profile Management            │        │
                    │   │   • Customize Profile           │        │
                    │   │   • Change Theme                │        │
                    │   │   • View Badges                 │        │
                    │   │   • Save Coffee Orders          │        │
                    │   └─────────────────────────────────┘        │
                    │                                               │
                    │   ┌─────────────────────────────────┐        │
                    │   │   Social Features               │        │
                    │   │   • Add Friends                 │        │
                    │   │   • View Friend Activity        │        │
                    │   │   • Share Recommendations       │        │
                    │   │   • Push Notifications          │        │
                    │   └─────────────────────────────────┘        │
                    │                                               │
                    └───────────────────────────────────────────────┘
```

### 2.2 Use Case Descriptions

#### 2.2.1 Actor: Customer (UNCG Student)

---

##### UC-1: Sign Up
**Brief Description**: A new user creates an account using their UNCG student email address.

**Actor**: UNCG Student (not yet registered)

**Preconditions**: 
- User must have a valid @uncg.edu email address
- Email must not already be registered in the system

**Main Flow**:
1. User navigates to the Cafe Quest login page
2. User clicks "Sign Up" link
3. System displays registration form
4. User enters:
   - Full name
   - UNCG email address (@uncg.edu)
   - Password
5. User submits the form
6. System validates email format (must end with @uncg.edu)
7. System checks email is not already registered
8. System creates new user account with status "pending"
9. System creates default user profile
10. System displays success message
11. User is redirected to login page

**Postconditions**:
- New user account exists in database with "pending" status
- Default profile is created for user
- User can now log in to the system

**Alternative Flows**:
- **A1**: Invalid email format
  - System displays error: "Please use your UNCG student email (must end with @uncg.edu)"
  - User returns to step 4
- **A2**: Email already registered
  - System displays error: "This email is already registered"
  - User can proceed to login or use different email

---

##### UC-2: Log In
**Brief Description**: A registered user authenticates and accesses their account.

**Actor**: Registered UNCG Student

**Preconditions**:
- User must have a registered account
- Account status must be "active" or "pending"

**Main Flow**:
1. User navigates to login page
2. User enters UNCG email address
3. User enters password
4. User clicks "Login" button
5. System validates credentials against database
6. System checks account status
7. System updates last_login timestamp
8. System redirects user to Home page
9. Home page displays:
   - Nearby coffee shops with ratings
   - Navigation menu (Home, My Events, Me)

**Postconditions**:
- User is authenticated and logged in
- User session is created
- User can access all customer features

**Alternative Flows**:
- **A1**: Invalid credentials
  - System displays error: "Invalid email or password"
  - User returns to step 2
- **A2**: Account suspended
  - System displays message about account status
  - User cannot proceed to dashboard

---

##### UC-3: Browse Coffee Shops
**Brief Description**: User views available coffee shops near UNCG campus with ratings and details.

**Actor**: Logged-in UNCG Student

**Preconditions**:
- User must be logged in
- Coffee shops exist in database

**Main Flow**:
1. User is on Home page
2. System retrieves coffee shops from database
3. System displays list of shops, each showing:
   - Coffee shop image (placeholder if none)
   - Street address
   - Comfort description
   - Rating (displayed as coffee cup icons ☕)
4. User scrolls through list of shops
5. User can click on any shop for more details

**Postconditions**:
- User has viewed available coffee shops
- User can make informed decision about where to visit

**Alternative Flows**:
- **A1**: No coffee shops in database
  - System displays message: "No coffee shops available yet"
- **A2**: User clicks on shop
  - System proceeds to UC-4 (View Shop Details)

---

##### UC-4: View Shop Details
**Brief Description**: User views comprehensive information about a specific coffee shop.

**Actor**: Logged-in UNCG Student

**Preconditions**:
- User must be logged in
- User has selected a coffee shop from browse list

**Main Flow**:
1. User clicks on a coffee shop from the list
2. System retrieves detailed information:
   - Shop name
   - Full address
   - Operating hours
   - Contact information (phone, website)
   - Average overall rating
   - Detailed ratings:
     * Study-ability score
     * Comfort score
     * Accessibility score
     * Coffee quality score
   - Recent reviews from other students
   - Upcoming events at this location
3. System displays map with location (using Google Maps API)
4. User can:
   - Read reviews
   - Write own review (UC-5)
   - View events at this location
   - Get directions

**Postconditions**:
- User has detailed information about the coffee shop
- Shop view counter may be incremented

---

##### UC-5: Write Review and Rate Coffee Shop
**Brief Description**: User provides ratings and written feedback about their experience at a coffee shop.

**Actor**: Logged-in UNCG Student

**Preconditions**:
- User must be logged in
- User has visited or selected a coffee shop

**Main Flow**:
1. User is viewing coffee shop details
2. User clicks "Write Review" button
3. System displays review form with rating categories:
   - Study-ability (1-5 scale)
   - Comfort (1-5 scale)
   - Accessibility (1-5 scale)
   - Coffee Quality (1-5 scale)
4. User rates each category by selecting score
5. System calculates overall rating (average of four scores)
6. User optionally writes text review
7. User submits review
8. System validates all required fields
9. System saves review to database
10. System updates shop's aggregate ratings:
    - Recalculates average_rating
    - Updates individual category scores
    - Increments total_ratings count
11. System displays success message
12. Review appears in shop's review list

**Postconditions**:
- Review is saved and associated with user and shop
- Shop's ratings are updated
- Review is visible to all users
- User may earn "Critic" badge if threshold met

**Alternative Flows**:
- **A1**: Missing required ratings
  - System displays error: "Please rate all categories"
  - User returns to step 4

---

##### UC-6: View My Events
**Brief Description**: User views all events they have created or RSVP'd to attend.

**Actor**: Logged-in UNCG Student

**Preconditions**:
- User must be logged in

**Main Flow**:
1. User clicks "My Events" in bottom navigation
2. System queries database for events where:
   - User is organizer, OR
   - User has RSVP'd with status "going" or "maybe"
3. System displays list of events, each showing:
   - Event name
   - Location (coffee shop and room if applicable)
   - Date and time
   - Event type (study group, social, etc.)
4. Events are sorted by date (upcoming first)
5. User can click on event for more details

**Postconditions**:
- User sees all their upcoming events
- User can manage their schedule

**Alternative Flows**:
- **A1**: No events
  - System displays: "You haven't joined any events yet"
  - Shows button to "Browse Events"

---

##### UC-7: Create Event
**Brief Description**: User organizes a study session or social gathering at a coffee shop.

**Actor**: Logged-in UNCG Student

**Preconditions**:
- User must be logged in
- At least one coffee shop exists in system

**Main Flow**:
1. User navigates to Events page
2. User clicks "Create Event" button
3. System displays event creation form
4. User enters:
   - Event name
   - Event description
   - Event type (study group, social, competition, performance, other)
   - Coffee shop location (dropdown)
   - Date
   - Time
   - Maximum attendees (optional)
   - Public/Private setting
5. User submits form
6. System validates all required fields
7. System creates event record with:
   - organizer_id = current user
   - current_attendees = 1 (creator auto-joins)
8. System creates EventAttendee record for creator
9. System displays success message
10. User is redirected to event details page

**Postconditions**:
- New event exists in database
- Creator is automatically registered as attendee
- Event appears in browse events and creator's "My Events"
- Other users can now discover and join the event

**Alternative Flows**:
- **A1**: Missing required fields
  - System displays validation errors
  - User returns to step 4
- **A2**: Date in past
  - System displays error: "Event date must be in the future"
  - User returns to step 4

---

##### UC-8: Join Event (RSVP)
**Brief Description**: User registers to attend an event at a coffee shop.

**Actor**: Logged-in UNCG Student

**Preconditions**:
- User must be logged in
- Event must exist and be public or user is invited
- Event must not be at capacity

**Main Flow**:
1. User is viewing event details
2. System checks:
   - Event has not reached max_attendees (if set)
   - User is not already registered
3. User clicks "Join Event" button
4. System displays RSVP options:
   - Going
   - Maybe
   - Not Going
5. User selects "Going"
6. System creates EventAttendee record
7. System increments event's current_attendees count
8. System displays confirmation message
9. Event appears in user's "My Events" page

**Postconditions**:
- User is registered as event attendee
- Event attendee count is updated
- Event appears in user's event list
- Organizer may receive notification

**Alternative Flows**:
- **A1**: Event at capacity
  - System displays: "This event is full"
  - User cannot join
- **A2**: User already registered
  - System displays current RSVP status
  - User can change RSVP status

---

##### UC-9: Customize Profile
**Brief Description**: User personalizes their profile page with themes, layouts, and information.

**Actor**: Logged-in UNCG Student

**Preconditions**:
- User must be logged in
- User profile exists

**Main Flow**:
1. User clicks "Me" in bottom navigation
2. System displays current profile page with:
   - Profile picture
   - Name and major
   - Bio
   - Badges earned
   - Coffee order history
   - Current theme/layout
3. User clicks "Edit Profile" or customization option
4. System displays customization options:
   - Profile theme selection (Tumblr-style)
   - Layout options
   - Bio text editing
   - Profile picture upload
5. User makes desired changes
6. User clicks "Save"
7. System validates inputs
8. System updates Profile table in database
9. System displays success message
10. Updated profile is displayed

**Postconditions**:
- Profile changes are saved
- Changes are visible to user and friends
- Profile reflects user's personality

**Alternative Flows**:
- **A1**: Invalid profile picture format
  - System displays: "Please upload JPG or PNG"
  - User returns to step 5

---

##### UC-10: Save Coffee Order
**Brief Description**: User creates and saves their custom coffee order preferences.

**Actor**: Logged-in UNCG Student

**Preconditions**:
- User must be logged in

**Main Flow**:
1. User is on "Me" profile page
2. User clicks "My Orders" or "Add Order"
3. System displays order creation form
4. User enters:
   - Order name (e.g., "My Usual", "Exam Week Special")
   - Drink type (latte, cappuccino, americano, etc.)
   - Size (small, medium, large, extra large)
   - Customizations (milk type, shots, sweetener, etc.)
5. User marks as favorite (optional)
6. User clicks "Save"
7. System validates inputs
8. System creates UserOrder record
9. System displays success message
10. Order appears in user's saved orders list

**Postconditions**:
- Order is saved to user's account
- User can quickly reference or share their order
- Order persists across sessions

**Alternative Flows**:
- **A1**: User already has order with same name
  - System asks: "Update existing order?"
  - User can confirm or change name

---

##### UC-11: Add Friend
**Brief Description**: User connects with another UNCG student on the platform.

**Actor**: Logged-in UNCG Student

**Preconditions**:
- User must be logged in
- Target user must exist and be a verified student

**Main Flow**:
1. User searches for friend by name or email
2. System displays search results
3. User clicks on friend's profile
4. User clicks "Add Friend" button
5. System creates Friendship record with status "pending"
6. System notifies target user of friend request
7. System displays: "Friend request sent"
8. User waits for target user to accept

**Postconditions**:
- Friendship request exists with "pending" status
- Target user receives notification
- Users can see pending status

**Alternative Flows**:
- **A1**: Users are already friends
  - System displays: "You are already friends"
  - Shows "Remove Friend" option
- **A2**: Target user accepts request
  - System updates friendship status to "accepted"
  - Both users can now see each other's activity

---

##### UC-12: View Friend Activity
**Brief Description**: User sees what coffee shops their friends have visited and reviewed.

**Actor**: Logged-in UNCG Student

**Preconditions**:
- User must be logged in
- User must have accepted friends

**Main Flow**:
1. User navigates to social/friends section
2. System queries database for:
   - Recent reviews by friends
   - Recent events friends joined
   - New coffee shops friends discovered
3. System displays activity feed showing:
   - Friend name
   - Action (reviewed, visited, joined event)
   - Coffee shop name
   - Rating or comment
   - Timestamp
4. Feed is sorted by most recent first
5. User can click on activity to see full details

**Postconditions**:
- User is informed of friend activity
- User discovers new coffee shops through friends
- Social engagement is increased

**Alternative Flows**:
- **A1**: No friend activity
  - System displays: "Your friends haven't been active recently"
  - Suggests inviting more friends

---

##### UC-13: Earn Badge
**Brief Description**: User automatically receives achievement badge when criteria is met.

**Actor**: System (triggered by user actions)

**Preconditions**:
- User must be logged in and performing actions
- Badge criteria must be defined

**Main Flow**:
1. User completes an action (visit shop, write review, join event, etc.)
2. System checks badge criteria:
   - Visit-based: "Coffee Newbie" (1 visit), "Regular" (5 visits), "Connoisseur" (20 visits)
   - Review-based: "Critic" (10 reviews)
   - Event-based: "Event Organizer" (5 events hosted)
   - Social-based: "Social Butterfly" (10 friends)
   - Special: "Exam Week Warrior" (study during exam week)
3. System determines if user met criteria
4. If criteria met:
   - System creates UserBadge record
   - System displays notification: "🎉 Badge Earned: [Badge Name]!"
5. Badge appears on user's profile

**Postconditions**:
- Badge is associated with user account
- Badge is displayed on profile
- User is motivated to engage more

**Alternative Flows**:
- **A1**: User already has badge
  - System does not create duplicate
  - No notification displayed

---

## 3. UML Class Diagram

![UML Class Diagram](./class-diagram.png)

```
┌─────────────────────┐
│       User          │
├─────────────────────┤
│ - user_id: int      │
│ - email: string     │
│ - password: string  │
│ - full_name: string │
│ - status: enum      │
│ - created_at: date  │
├─────────────────────┤
│ + signUp()          │
│ + login()           │
│ + logout()          │
│ + verifyEmail()     │
└─────────────────────┘
         │ 1
         │
         │ 1
         ▼
┌─────────────────────┐         1      ┌─────────────────────┐
│      Profile        │◄───────────────│    UserOrder        │
├─────────────────────┤                ├─────────────────────┤
│ - profile_id: int   │                │ - order_id: int     │
│ - user_id: int      │                │ - user_id: int      │
│ - major: string     │                │ - order_name: str   │
│ - bio: text         │                │ - drink_type: str   │
│ - theme: string     │                │ - size: enum        │
│ - picture_url: str  │                │ - custom: text      │
├─────────────────────┤                │ - favorite: bool    │
│ + editProfile()     │                ├─────────────────────┤
│ + changeTheme()     │                │ + saveOrder()       │
│ + uploadPicture()   │                │ + modifyOrder()     │
└─────────────────────┘                │ + deleteOrder()     │
         │ 1                            └─────────────────────┘
         │
         │ *
         ▼
┌─────────────────────┐
│      Review         │
├─────────────────────┤         *      ┌─────────────────────┐
│ - review_id: int    │───────────────►│    CoffeeShop       │
│ - user_id: int      │       1        ├─────────────────────┤
│ - shop_id: int      │                │ - shop_id: int      │
│ - review_text: text │                │ - name: string      │
│ - study_rating: int │                │ - address: string   │
│ - comfort_rating    │                │ - latitude: decimal │
│ - access_rating     │                │ - longitude: decimal│
│ - coffee_rating     │                │ - avg_rating: dec   │
│ - overall_rating    │                │ - study_score: dec  │
│ - visit_date: date  │                │ - comfort_score     │
│ - created_at: date  │                │ - access_score      │
├─────────────────────┤                │ - coffee_score      │
│ + writeReview()     │                ├─────────────────────┤
│ + editReview()      │                │ + getDetails()      │
│ + calculateRating() │                │ + updateRatings()   │
└─────────────────────┘                │ + getReviews()      │
                                       └─────────────────────┘
         1                                      │ 1
         │                                      │
         │ *                                    │ *
         ▼                                      ▼
┌─────────────────────┐                ┌─────────────────────┐
│       Event         │                │     ShopHours       │
├─────────────────────┤                ├─────────────────────┤
│ - event_id: int     │                │ - hours_id: int     │
│ - name: string      │                │ - shop_id: int      │
│ - shop_id: int      │                │ - day: enum         │
│ - organizer_id: int │                │ - open_time: time   │
│ - description: text │                │ - close_time: time  │
│ - event_date: date  │                │ - is_closed: bool   │
│ - event_time: time  │                ├─────────────────────┤
│ - max_attendees: int│                │ + getHours()        │
│ - current_attend    │                └─────────────────────┘
│ - event_type: enum  │
│ - is_public: bool   │
├─────────────────────┤
│ + createEvent()     │
│ + editEvent()       │         *      ┌─────────────────────┐
│ + deleteEvent()     │───────────────►│  EventAttendee      │
│ + getAttendees()    │       1        ├─────────────────────┤
└─────────────────────┘                │ - attendance_id     │
         ▲                              │ - event_id: int     │
         │ *                            │ - user_id: int      │
         │                              │ - rsvp_status: enum │
         │ 1                            │ - rsvp_date: date   │
         │                              ├─────────────────────┤
    ┌────────┐                         │ + joinEvent()       │
    │  User  │                         │ + updateRSVP()      │
    └────────┘                         │ + leaveEvent()      │
         │ 1                            └─────────────────────┘
         │
         │ *
         ▼
┌─────────────────────┐
│    Friendship       │         *      ┌─────────────────────┐
├─────────────────────┤───────────────►│       Badge         │
│ - friendship_id     │       *        ├─────────────────────┤
│ - user_id_1: int    │                │ - badge_id: int     │
│ - user_id_2: int    │                │ - name: string      │
│ - status: enum      │                │ - description: text │
│ - created_at: date  │                │ - icon_url: string  │
│ - accepted_at: date │                │ - criteria_type     │
├─────────────────────┤                │ - criteria_value    │
│ + sendRequest()     │                ├─────────────────────┤
│ + acceptRequest()   │                │ + checkCriteria()   │
│ + removeFriend()    │                └─────────────────────┘
└─────────────────────┘                         ▲
                                                 │ *
                                                 │
                                                 │ 1
                                        ┌─────────────────────┐
                                        │    UserBadge        │
                                        ├─────────────────────┤
                                        │ - user_badge_id     │
                                        │ - user_id: int      │
                                        │ - badge_id: int     │
                                        │ - earned_at: date   │
                                        │ - is_displayed      │
                                        ├─────────────────────┤
                                        │ + earnBadge()       │
                                        │ + displayBadge()    │
                                        └─────────────────────┘
```

### Class Relationships:

**One-to-One:**
- User ↔ Profile (Each user has exactly one profile)

**One-to-Many:**
- User → Review (One user can write many reviews)
- CoffeeShop → Review (One shop can have many reviews)
- CoffeeShop → Event (One shop can host many events)
- User → Event (One user can organize many events)
- CoffeeShop → ShopHours (One shop has hours for each day)
- User → UserOrder (One user can save many orders)

**Many-to-Many:**
- User ↔ Event (through EventAttendee) - Users attend events, events have attendees
- User ↔ User (through Friendship) - Users befriend other users
- User ↔ Badge (through UserBadge) - Users earn badges, badges belong to users

---

## 4. Database Schema

### 4.1 Entity Relationship Diagram (ERD)

![ERD Diagram](./erd-diagram.png)

```
┌─────────────┐         ┌──────────────┐         ┌─────────────┐
│   Users     │────┬───→│   Reviews    │←────────│ CoffeeShops │
│             │    │    │              │         │             │
│ PK: user_id │    │    │ PK: review_id│         │ PK: shop_id │
│  email      │    │    │ FK: user_id  │         │  shop_name  │
│  password   │    │    │ FK: shop_id  │         │  address    │
│  full_name  │    │    │  review_text │         │  latitude   │
│  status     │    │    │  ratings...  │         │  longitude  │
└─────────────┘    │    └──────────────┘         │  ratings... │
      │ 1:1        │            │                └─────────────┘
      ▼            │            │                        │ 1:*
┌─────────────┐   │            │                        ▼
│   Profiles  │   │            │                ┌─────────────┐
│             │   │            │                │  ShopHours  │
│PK:profile_id│   │            │                │             │
│FK: user_id  │   │            │                │PK: hours_id │
│    major    │   │            │                │FK: shop_id  │
│    bio      │   │            │                │ day_of_week │
│    theme    │   │            │                │  open_time  │
└─────────────┘   │            │                │  close_time │
      │ 1:*       │            │                └─────────────┘
      ▼            │            │                        
┌─────────────┐   │            │                ┌─────────────┐
│UserOrders   │   └───────────────────────────→│    Events   │
│             │                │                │             │
│PK: order_id │                │                │PK: event_id │
│FK: user_id  │                │                │FK: shop_id  │
│ order_name  │                │                │FK:organizer │
│ drink_type  │                │                │  event_name │
│    size     │                │                │  event_date │
│customization│                │                │  event_time │
└─────────────┘                │                └─────────────┘
                                │                       │ 1:*
                                │                       ▼
                                │                ┌─────────────┐
                                │                │EventAttendee│
                                │                │             │
                                │                