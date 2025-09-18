# Software Requirements Specification
## For <Cafe Quest>

Version 0.1  
Prepared by <author>  
<organization>  
<date created> 

Table of Contents
=================
* [Revision History](#revision-history)
* 1 [Introduction](#1-introduction)
  * 1.1 [Document Purpose](#11-document-purpose)
  * 1.2 [Product Scope](#12-product-scope)
  * 1.3 [Definitions, Acronyms and Abbreviations](#13-definitions-acronyms-and-abbreviations)
  * 1.4 [References](#14-references)
  * 1.5 [Document Overview](#15-document-overview)
* 2 [Product Overview](#2-product-overview)
  * 2.1 [Product Functions](#21-product-functions)
  * 2.2 [Product Constraints](#22-product-constraints)
  * 2.3 [User Characteristics](#23-user-characteristics)
  * 2.4 [Assumptions and Dependencies](#24-assumptions-and-dependencies)
* 3 [Requirements](#3-requirements)
  * 3.1 [Functional Requirements](#31-functional-requirements)
    * 3.1.1 [User Interfaces](#311-user-interfaces)
    * 3.1.2 [Hardware Interfaces](#312-hardware-interfaces)
    * 3.1.3 [Software Interfaces](#313-software-interfaces)
  * 3.2 [Non-Functional Requirements](#32-non-functional-requirements)
    * 3.2.1 [Performance](#321-performance)
    * 3.2.2 [Security](#322-security)
    * 3.2.3 [Reliability](#323-reliability)
    * 3.2.4 [Availability](#324-availability)
    * 3.2.5 [Compliance](#325-compliance)
    * 3.2.6 [Cost](#326-cost)
    * 3.2.7 [Deadline](#327-deadline)

## Revision History
| Name | Date    | Reason For Changes  | Version   |
| ---- | ------- | ------------------- | --------- |
|Hiwete|9/17/2025| Edit SRS info       |           |
|      |         |                     |           |
|      |         |                     |           |

## 1. Introduction

### 1.1 Document Purpose
This Software Requirements Specification (SRS) defines the requirements for Cafe Quest, a mobile/web application designed for University of North Carolina at Greensboro (UNCG) students. The purpose is to ensure a clear understanding between stakeholders (developers, testers, sponsors, and student users) about the system’s objectives and features. The intended audience includes the development team, project stakeholders, testers, and end-users.

### 1.2 Product Scope
Cafe Quest is an application that allows UNCG students to:
- Log in using their @uncg.edu email through Google API verification.
- Browse, rate, and review coffee shops nearby campus.
- Customize their personal profile page (similar to Tumblr-style pages).
- Modify and save their coffee orders.
- Connect with friends, follow their activity, and push recommendations.
- Earn badges for achievements (e.g., studing at a coffee shop during exam week).
The app is made to build a community through discovery and coffee culture that also promotes local businesses.

### 1.3 Definitions, Acronyms and Abbreviations
- UNCG: University of North Carolina at Greensboro.
- API: Application Programming Interface.
- GUI: Graphical User Interface.
- SRS: Software Requirements Specification.

### 1.4 References
List any other documents or Web addresses to which this SRS refers. These may include user interface style guides, contracts, standards, system requirements specifications, use case documents, or a vision and scope document. Provide enough information so that the reader could access a copy of each reference, including title, author, version number, date, and source or location.

### 1.5 Document Overview
Describe what the rest of the document contains and how it is organized.

## 2. Product Overview
### 2.1 Product Functions
- Authentication: Google API login with @uncg.edu email verification.
- Coffee Shop Discovery: Search and browse coffee shops around campus, with student ratings and reviews.
- Customization: Profile page customization with themes, layouts, and posts.

### 2.2 Product Constraints
- Must integrate with Google Identity API for authentication.
- Must comply with UNCG policy regarding student data.
- Should allow scalability and support several users.
  
### 2.3 User Characteristics
UNCG students will be the primary users since they are typically familiar with apps and social media platforms.

### 2.4 Assumptions and Dependencies
- Relies on Google Maps API for coffee shop location data.
- Relies on Google API for login services.
- Assumes students have mobile access to the app.

## 3. Requirements

### 3.1 Functional Requirements 

#### 3.1.1 User interfaces
-  Login Screen: Permits @uncg.edu verification
- Home Page: Lists coffee shops and ratings and popularity among students.
- Me Page: Customizable themes, order history, and badge placement.
Could be further divided into Usability and Convenience requirements.

#### 3.1.2 Hardware interfaces
- Mobile devides: Andriod or iOS
- GPS: for location-based searches

#### 3.1.3 Software interfaces
- Google Maps API: shop locations
- Cloud Database: store user data
- Notification Service

### 3.2 Non Functional Requirements 

#### 3.2.1 Performance
If there are performance requirements for the product under various circumstances, state them here and explain their rationale, to help the developers understand the intent and make suitable design choices. Specify the timing relationships for real time systems. Make such requirements as specific as possible. You may need to state performance requirements for individual functional requirements or features.

#### 3.2.2 Security
Specify any requirements regarding security or privacy issues surrounding use of the product or protection of the data used or created by the product. Define any user identity authentication requirements. Refer to any external policies or regulations containing security issues that affect the product. Define any security or privacy certifications that must be satisfied.

#### 3.2.3 Reliability
Specify the factors required to establish the required reliability of the software system at time of delivery.

#### 3.2.4 Availability
Specify the factors required to guarantee a defined availability level for the entire system such as checkpoint, recovery, and restart.

#### 3.2.5 Compliance
Specify the requirements derived from existing standards or regulations

#### 3.2.6 Cost
Specify monetary cost of the software product.

#### 3.2.7 Deadline
Specify schedule for delivery of the software product.
