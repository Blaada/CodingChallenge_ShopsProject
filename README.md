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

