# Cafe Quest - Software Design 

Version 3  
Prepared by Chase Solano, Hiwete Teshale  
Cafe Quest  
Dec 8, 2025  

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
|  V2  |  12/7   | Progressing Design  |     2     |
|  V3  |  12/8   |    Final Design     |     3     |

## 1. Product Overview
Cafe Quest is a web application designed specifically for UNCG students (at this current time) who desire ease of finding third spaces. Cafe Quest offers descriptive suggestions on cafes and study spaces for students to visit, and also schedule group meetups at. All users of Cafe Quest would be UNCG students.

## 2. Use Cases
### 2.1 Use Case Model
![Use Case Model](https://github.com/kmangoes/f25-team1/blob/main/doc/Object-Oriented-Design/V2UseCaseModel.png)

### 2.2 Use Case Descriptions

#### 2.2.1 Actor: Provider
##### 2.2.1.1 Log In/Sign Up 
Admin login will have a designated page with a fixed password, as well as valid admin email(s). Login will have reCAPTCHA implemented for extra security. 
##### 2.2.1.2 User Management
A provider can view all users as well as delete them. 
##### 2.2.1.3 Cafe Management 
Providers can add/edit new and existing cafes (a provider-unique capability), delete cafes, navigate to a Google search of the cafe on clicking, and also view all user reviews. 
##### 2.2.1.4 Event Management:
Providers can add events and delete them. 

#### 2.2.2 Actor: Cafe Quest User
##### 2.2.2.1 Log In/Sign Up
A new user uses their UNCG Student email address to sign up using a valid @uncg.edu email address that is not already in teh system. After logging in, the user should be able to authenticate and have access to their account to see the home page, their profile, and events page.
##### 2.2.2.3 Browse Coffee Shops
Users will be able to see coffee shops near UNCG campus along with viewing details.
##### 2.2.2.4 Review and Rate Coffee Shops
Users can provide ratings and feedback on the coffee shops they visit.
##### 2.2.2.5 Add/Join/Leave Events
Users can add, join and leave events created by other users. 

## 3. UML Class Diagram
![UML Class Diagram](https://github.com/kmangoes/f25-team1/blob/cSolano-milestone4/doc/Object-Oriented-Design/designDocUML.png)

## 4. Database Schema
![UML Class Diagram](https://github.com/kmangoes/f25-team1/blob/main/doc/Object-Oriented-Design/designdoc_schema.png)
