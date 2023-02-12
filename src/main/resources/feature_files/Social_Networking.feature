Feature: Social_Networking
#  Imagine you are building a social network. Starting from simple functionality. Users are now able to make posts and comment on them.
#  You are working in the backend team that exposes the service: https://jsonplaceholder.typicode.com/ which has the following endpoints:
#
#  1. Make posts: https://jsonplaceholder.typicode.com/posts
#  2. Comment on posts: https://jsonplaceholder.typicode.com/comments
#  3. List of users: https://jsonplaceholder.typicode.com/users
#  @smokeTest
  Scenario Outline: Get a specific Comment
    Given jsonplaceholder service is up and running
    When I search for comment with "<id>" with a GET method
    Then I should get status code of 200 and "<id>", "<name>" and "<email>"

    Examples:
      | id | name                          | email               |
      | 3  | odio adipisci rerum aut animi | Nikita@garfield.biz |

  @smokeTest
  Scenario Outline: Create a Comment
    Given jsonplaceholder service is up and running
    When I create a new comment with details "<postId>", "<name>", "<email>" and "<body>" using post method
    Then I should get status code of 201 and "<postId>", "<name>", "<email>" and "<body>"

    Examples:
      | postId | name              | email                      | body             |
      | 9      | Lateef Abdulsalam | Abdulsalam1220@gardner.biz | I like this post |



