**Tech Stack used**

1)Spring boot

2)Hibernate

3)PostgreSQL (Did not used mySQL because my machine did not support)

4)Spring Security 


**How to start:**
1) if you are using mySQL then please remove "schema" annotaion from Entity table that is only for postgreSQL.
2) provide API key and Value same as given for third party.
3) Validation is used but if it doesn't work because of some magic. please remoced pattern annotation from Entity USER).
4) Now you can start the application.

**API:**

USER- 

1)signup = /signup

2)login = /login/{username}/{password}

3)update = /update/{userId}

COIN-

get coin data = /api/coin/{userid}


**Note:** Havn't beutified because of time constraints.


