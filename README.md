ProjectAppStuff
===============

This is the CSE 201 group project. This is for team Snow (team name is subject to change)

P.S. I am awesome

So random notes below

Database:
  information to store:
    user objects
    each individual app object
      in the data of each app object will include the data for each forum dedicated to each individual app (as specified in our outline (also to be confirmed with our customer that this is what is wanted))
    
    That is it as far as I know. I do not know how the databases work or how the webpage settup needs to be made so this is as deduced by me without expertise. When we meet for a group meeting we will talk about it more.


Code Structure:

  Objects/ Classes:
    
    Users
      Instance variables
        Will have a string for name and password
        Will have 2 booleans to determine if the user is an administrator and/ or moderator
        
        
      Methods
        Will need some method that allows the user objects to be sorted (so a method that returns a number or something similar that allows it to be distinguished from the other objects when it is searched for)
        will need to be able to post on the forums of apps
        will need to be able to submit requests for new apps to be added to database
        (could make it so that a boolean determins if the User is a registered user and we have a get funstion like isRegistered() to use to see if the current User can do specific actions)
        
    (subclass Guest) (inherits Users) //this will have limited usability on the site until login or sign up (also, because this is the default user type upon loading our site, this could be a singleton object so that the amount of memory these objects will be constant and one is not created every time someone loads the webpage)
    
    (subclass Moderator) (inherits Users)
      methods
        one that will allow the Moderator to delete a forum entry
    
    (subclass Administrator) (inherits Moderator) //this is if we make it so all Administrators will also be able to be Moderators (ask the client because if it is like this things will be easier to code but if not we can manage)
      Questions
        Do we want to make it so that the Administrator needs to have a request to add an app for them to be able to add in a new app to the database or is there a way for them to add apps without a request?
        Because Administrators have the ability to add apps, do they need to ability to submit a request to add an app? (will have to be yes if the Administrators do need a request in order to add an App to the database)
    
    App
      instance variables
        One set of fourm entries and whatnot (possibly a forum object (others probably have a better idea for how to handle this part of the app object)
        a string for a name
        string Developer
        string or link object thing for link to Developer page
        something for a rating on the app (need a way to make sure users only rate a product once (they can change their rating but they do not get more than one rating of each app))
        
      methods
        add an entry to the forum (this could be a method to put in the User objects (I think it should be an operator that is implemented by the original User class that chacks to see if the user is registered before allowing them to enter a post to add or this all could be taken care of by having the webpage form according to what type of user is currently browsing the site (like most sites do) (the only reason I am offering alternative possibilities is because I am not familiar with a lot of HTML right now and, as said before, less with databases so I don't know if these simple designs incorperated into most sites today are easy to implement or hard)))
        
        
That is it for now. More to be added by me and as a group. I have a good start here organizing information in a more usable manner with descriptions (almost like user stories except it's not).

________________________________________________

User Stories:
________________________________________________

User Friendliness & Practicality

As a product owner, I want users to have the capability of viewing applications by category.

As a product owner, I want my application pages to include the developer-provided descriptions.

As a product owner, I want users to be able to have public discussions (for apps?).

As a product owner, I want ProjectAppStuff to include applications of various platforms (e.g. Apple, Droid, Windows, Google…).

As a product owner, I want to provide users with customized filtration for their searches (e.g. what platforms they want to see, price range, ratings, popularity, etc.).

As a product owner, I want users to request additions to the database, and I want to require that they provide a link to their requested application’s download page.

As a product owner, I want ProjectAppStuff’s interface to be as simple & sleek as possible (adhering to common style & user interface guidelines).
__________________________________________________

Security & Efficiency

As a product owner, I want there to be a consistent search bar on every page that does a string sort on all of the applications’ respective fields. 

As a product owner, I want to provide administrators with an “Outstanding Request” page - allowing them to view, approve/reject, and/or comment on users’ addition requests.

As a product owner, I want to require users to login before contributing to forums.

As a product owner, I want to provide a “Moderator” role that bears the power to delete posts from forums.  Administrators can also be moderators, and both can also be users.

As a product owner, I want the backend of the repository and user login information to be implemented in a database.
___________________________________________________

Accessibility

As a product owner, I want to provide a way for users to be redirected to application download pages.

As a product owner, I need ProjectAppStuff to work on desktop & mobile.
___________________________________________________
