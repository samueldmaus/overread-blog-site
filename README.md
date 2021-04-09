# Overread

Overread is personal blog website. Overread discusses a variety of topics, from sports to video games to the weather. In order to read the blogs, a user must create an account. Once an account has been created, a user can read and comment on blogs.
They can go back later and edit or delete their comments if they wish. The admin of the site is the only one who has the ability to create, update, or delete blog posts. The admin also has the ability to delete user comments if they wish.

## Screenshots

## User Stories

As a site admin:
- I want to be able to post blogs
- I want to be able to edit blogs
- I want to be able to delete blogs
- I want to be able to delete comments

As a site user:
- I want to be able to create an account with my information
- I want to be able to read blogs
- I want to be able to comment on blogs
- I want to be able to edit my comments
- I want to be able to delete my comments
- I want to be able to search for blogs
- I want to be able to like comments


## Technologies
- Spring MVC
- Maven
- Hibernate
- MySQL Connector
- Spring ORM
- Spring Security
- Tomcat
- Java Server Pages
- Junit
- Mockito

## Database Schema

![db_schema](WebContent/resources/images/overread_db_schema.png)

## Technical Challenges

- Using spring security to correctly sign in users and assign them a default role
	- Lots of Google, followed the examples, and researched using spring security tags

- Handling cascading deleting with blogs and comments
	- Made sure to correctly label owning entity and cascade type

## Future Features

- Add OAuth2 support
- Turn comments into threads (users can comment on a blog, then comment on that comment, and so on)
- Update formatting of blogs to allow for customization

## Support

For any questions, concerns, or suggestions, feel free to contact me at: samueldmaus@gmail.com