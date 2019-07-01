# CELUM PROGRAMMING TEST
## Scope

This exercise requires a web application to manage school courses. Relevant entities with their properties are:
 1. **Course:** Name*, Date*
 2. **Student:** First Name*, Last Name*, Email*, Phone
(*mandatory)

Administrators of the application needs to be able to see all CRUD (database create, read update and delete) operations. In addition an administrator has also the ability to assign and remove students to/from courses.

The back-end part has been implemented  in a Apache Maven based Java project architecture. This was setup using the [Spring Boot Initializr](https://start.spring.io/) (Spring Boot version 2.1.6). Data has been stored in a [MongoDB](https://www.mongodb.com/) document database.

From front-end side, everything is based on [Angular ](https://angular.io/). A command line interface (Angular CLI) was used to build the project. All Angular components as well as the service have also been generated this way.
The front-end project is based on this great [YouTube video](https://www.youtube.com/watch?v=5wtnKulcquA).

At this point, the project has not been finished yet. Up to now, about 2 days of work have been used to create the currently available code base. Specific points should be considered when evaluating this project:

 - **Short Notice**: I haven't had time to prepare for the task, as it has never been mentioned before. Thus no time could have been planned to work on the task.
 - **Full Time Job**: As I am working full time, only two days could be used for implementing the task
 - **No previous knowledge:** All technologies have been entirely new to me. Learning new things properly usually consumes quite some time, which has just not been available.
 - **Heat:** During the weekend of implementation, it was extremely hot (about 30°C in the apartment)

# Open Tasks

## Back-end

 - More detailed research to "Spring Data"
 - Comment code to be able to generate JavaDocs and make maintenance easier
 - Write test cases (mostly Unit Test cases) and think about integration testing
 - Clean up code and refactor (due to lack of previous experience regarding technologies unnecessary REST endpoints and code fragments for manual testing are still part of the project. As a result many back-end requests are highly inefficient)
 - Think about a login approach. In most scenarios, there is usually an *Active Directory* or another user database available. Using an OAuth2 authentication would be the best way to handle users.
 - Figure out what NgRx is about
 - Reduce CRUD logging by refactoring endpoints to only provide relevant information

## Front-end

 - Implement bonus task "up to 5 students can participate in a course. Additionally, a student can take up to 3 different courses"
 - Work out a solid (possibly session secure using cookies) login
 - Distinguish between administrators and regular users (students) and display content accordingly

## Optional

 - Clear CRUD logs, that are older than a certain amount of time (e.g. 24 hours,  a week or 30 days)
 - Apply a nicer styling to pages
 - Think about front-end testing
 - UML diagrams in readme to make it easier to understand the flow

# Current Status

 - Students, Courses, Registrations/Assignments, Users and CRUD operations can be stored in the MongoDB
 - Information like a student profile as well as courses for a student (both, enrolled and available) can be displayed in the Angular front-end.
 - CRUD operations can be displayed in the Angular front-end
 - REST endpoints for student, course, user and CRUD operation information are available (although mostly inefficient and will be restructured)
 - A rather bad login has been implemented. Based on the effort, this will be replaced by an OAuth2 authentication.
 - Parts of the pages have been slightly styled
 - A massive amount of time has been spent to learn new technologies
 - A classic architecture for data access favoring dependency injection has been implemented
 
 ## HOME
[![Home Page](http://puu.sh/DNlm9/96164630d3.png)](http://puu.sh/DNlm9/96164630d3.png)
## Courses
[![Home Page](http://puu.sh/DNlpN/d745017ae2.png)](http://puu.sh/DNlpN/d745017ae2.png)
## OPERATIONS
[![Home Page](http://puu.sh/DNltf/0276ffc60a.png)](http://puu.sh/DNltf/0276ffc60a.png)

# Other content

 - Changes will still  be implemented and committed to this repository in the next couple of days
 - [stackedit.io](https://stackedit.io/app#) has been used to create this mark down file
