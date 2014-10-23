ProjectAppStuff
===============

This is the CSE 201 group project. This is for team Snow (team name is subject to change)

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
        
    (subclass Guest) (inherits Users) //this will have limited usability on the site until login or sign up
    
    (subclass Moderator) (inherits Users)
    
    (subclass Administrator) (inherits Moderator) //this is if we make it so all Administrators will also be able to be Moderators (ask the client because if it is like this things will be easier to code but if not we can manage)
    
    
    App
      instance variables
        One set of fourm entries and whatnot (possibly a forum object (others probably have a better idea for how to handle this part of the app object)
        a string for a name
        string Developer
        string or link object thing for link to Developer page
        something for a rating on the app (need a way to make sure users only rate a product once (they can change their rating but they do not get more than one rating of each app))
        
      methods
        add an entry to the forum
        
        
That is it for now. More to be added by me and as a group. I have a good start here organizing information in a more usable manner with descriptions.
