# Nearby shops project

This application will allow users to view the nearby shops and also the possibility to like and dislike them.

## Backend 

I choosed to use Java JEE to deploy the backend ( As REST service )  of this application, with the combination of spring framework, 
the spring security infrastructure and JWT (JSON WEB TOKENS), it will be easy to secure the access.
### Authentication process

When the users write their credentials, a JWT token will be generated after the spring security authentication, this JWT will be used after in the header of all requests, to secure the communication between client and Service. 

### Technologies

```
Spring boot
JJWT
Spring Security
Spring JPA
MYSQL
```

## Frontend

To deploy a SPA ( Single Page Application ), i choosed to work with ANGULARJS, to developpe a signe page " index.html ", and also used a bootstrap template to beautify the application.


```
ANGULARJS
CSS
BOOTSTRAP
HTML
```
## Functional spec covered by this app

* A User can sign up using his email & password.
* A User can sign in using his email & password.
* A User can display the list of shops sorted by distance.
* A User can like a shop, so it can be added to his preferred shops.
* liked shops shouldn’t be displayed on the main page.
* A User can display the list of preferred shops.
* A User can remove a shop from his preferred shops list.

## Functional spec not covered by this app

* As a User, I can dislike a shop, so it won’t be displayed within “Nearby Shops” list during the next 2 hours.
* i had the idea to use " $interval ", and failed in some tests, and also run out of time but will fix it in future release.

