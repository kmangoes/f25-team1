# Cafe Quest - Software Design 

Version 1  
Prepared by Chase Solano, Hiwete Teshale  
Cafe Quest  
Oct 9, 2025  

Table of Contents
=================
* [Revision History](#revision-history)
* 1 [Product Overview](#1-product-overview)
* 2 [Use Cases](#2-use-cases)
  * 2.1 [Use Case Model](#21-use-case-model)
  * 2.2 [Use Case Descriptions](#22-use-case-descriptions)
    * 2.2.1 [Actor: User](#221-actor-farmer)
    * 2.2.2 [Actor: Provider](#222-actor-customer) 
* 3 [UML Class Diagram](#3-uml-class-diagram)
* 4 [Database Schema](#4-database-schema)

## Revision History
| Name | Date    | Reason For Changes  | Version   |
| ---- | ------- | ------------------- | --------- |
|  Vl  |  10/9   |   Initial Design    |     1     |
|      |         |                     |           |
|      |         |                     |           |

## 1. Product Overview
Cafe Quest is a web application designed specifically for UNCG students (at this current time) who desire ease of finding third spaces. Cafe Quest offers descriptive suggestions on cafes and study spaces for students to visit, and also schedule group meetups at. All users of Cafe Quest would be UNCG students, verified by a @uncg.edu email.

## 2. Use Cases
### 2.1 Use Case Model
<img width="853" height="580" alt="image" src="https://github.com/user-attachments/assets/018fdacd-a8a6-4117-8a44-68a0428e6dd7" />

### 2.2 Use Case Descriptions

#### 2.2.1 Actor: Provider
##### 2.2.1.1 Log In
Admin login will have a designated page (that will be, in most cases, inaccessible to users), with a fixed password, as well as valid admin email(s). There is no sign-up option on the provider side.
##### 2.2.1.2 View Customer View
A provider has access to what the current customer interface looks like.
##### 2.2.1.3 View Event Stats
Provider can view upcoming events, ordered based on relevance (the closer to the event date, the higher up they will appear), how many users have reserved spots at the event, where it is being hosted, etc.  
A provider can also edit or remove events as needed. 
##### 2.2.1.4 View Customer Stats
Provider can view a comprehensive list of all users. Providers have limited access to modification of user profiles given the scope of the provider role for this application, but they can remove users as needed.  
A short breakdown is provided, displaying statistics such as newly-created accounts.
##### 2.2.1.5 View Customer Reviews  
Provider can view and manage customer reviews. A more in-depth breakdown is given for reviews, highlighting recent reviews and higher/lower-rating ones.

#### 2.2.2 Actor: Cafe Quest User
##### 2.2.2.1 Sign Up
A customer can sign up to create their profile with their name, email, password, and address. Emails must be unique.
##### 2.2.2.2 Log In
A customer shall be able to sign in using their registred email and password. After logging in, the customer shall be directed their dashboard where they see an overview of their subscriptions.
##### 2.2.2.3 Browse Produce Boxes
A customer shall be able to view available produce boxes. They can do this from the home page or using a search function. They can also filter boxes by name, descriptions, or farm. They will also be able to select one box and view more details.
##### 2.2.1.4 Subscribe to Produce Box
Upon selecting a box, a customer shall be able to subscribe for the box using a one-click action. This box will then appear on their dashboard, and they will be able to ammend the subscription.
##### 2.2.1.5 Review Produce Box
A customer may write a review for a box they subscribed to. They will be able to rate the box based on freshness and delivery.

## 3. UML Class Diagram
![UML Class Diagram](https://github.com/kmangoes/f25-team1/blob/cSolano-milestone4/doc/Object-Oriented-Design/designDocUML.png)

## 4. Database Schema
![UML Class Diagram](https://github.com/kmangoes/f25-team1/blob/main/doc/Object-Oriented-Design/designdoc_schema.png)
