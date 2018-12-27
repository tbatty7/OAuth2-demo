# OAuth2-demo
This project uses OAuth2 and Spring Boot to create an Authorization Server.
- The Authorization server expects a client id and secret
- To get a token from this server after firing it up, use this curl:
    - curl service-account-1:service-account-1-secret@localhost:8080/auth/oauth/token -d grant_type=client_credentials
    - This sends the client id and secret before the protocol and url and the -d adds the grant type
- I had to tweak the config to encode the client secret due to the latest version of Security
- I need to set it up to use jwt tokens next.

In an OAuth2 scenario, the client must first hit the Auth server to get a token.
Spring Boot AuthN resource server is only hit once the client has already gotten a token by whatever grant type specified.
The token comes on http header of Authorization with value 
Bearer [whatever the token is, but not in square brackets]
