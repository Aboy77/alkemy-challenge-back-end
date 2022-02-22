# alkemy-challenge-back-end
API to explore the world of Disney, which will allow knowing and modifying the characters that compose it and understand in which films they participated. On the other hand, you must expose the information so that any frontend can consume it.

with this API you can




*User

-Create an account, of course

when you create an account you will be able to create or get list of characters, films, genders, create one of them, edit it and much more

at the following endpoint:

/auth/register - POST

you need give the params needed, they are user and password, for exmaple:

/register?user=user@gmail.com&password=1234 - POST

you will received an email of confirmation.




*Movies

Once created you will be able to: 

-GET movies list, following this endpoint: 

/movies - GET

-seach movies by params, for that you need only give a param, can be, name - idGender - order list ascending(ASC) or descending(DESC) , for example

good way: /movies?name=the mouse - GET

but not send more than 2 params

bad way: /movies?name=the mouse&idGender=2 - GET

*Note: you can receive a list of movies in ascendent or descendent, just in the param "order" put ASC(ascendent) or DESC(descendet) to received in that way


-CREATE new movies, following the same endpoint:

/movies - POST (no name at requirements 😐)

for create you need add the following params img (String) - title (String) - qualification (Byte/int), for example:

/movies?img=/img/img4&title=magical christmas&qualification=5 - POST

-EDIT movies, you can edit the movies choosing it or putting his id number at the following endpoint:

/movies?id=1 - PUT 

we take his id, it's "1", and then putting the params to edit

/movies?id=1&img=/img/newImg&title=awesome christmas&qualification=5 - PUT

-DELETE the movies, only we need choose it or putting his id to delete at following endpoint:

/movies?id=2 - DELETE 




*Characters

-GET characters list, following this endpoint: 

/characters - GET

-seach characters by params, for that you need only give a param, can be, name - age - idMovie, for example

good way: characters?name=Mickey - GET

but not send more than 2 params

bad way: characters?name=Mickey&age=10


-CREATE new characters, following the same endpoint:

/characters - POST (no name at requirements 😐)

for create you need add the following params img (String) - name (String) - age (Short/int) - weight (String) - story (String), for example:

/characters?img=/img/img4&name=Donald&age=11&weight=10kg&story=A duck - POST


-EDIT character, you can edit the character choosing it or putting his id number at the following endpoint:

/characters?id=2 - PUT 

we take his id, it's "2", and then putting the params to edit

/characters?id=2&img=/img/img5&name=Pluto&age=7&weight=5kg&story=A good dog - PUT

-DELETE the characters, only we need choose it or putting his id to delete at following endpoint:

/characters?id=2 - DELETE

