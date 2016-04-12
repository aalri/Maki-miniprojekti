import gui.*
import logiikka.*
import referencechampion.*
import java.util.HashMap;

description 'a bibtex-file can be created'

scenario "creation successfull with an empty reference-collection", {
    given 'command make bibtex-file is selected', {
       HashMap<String, String> input = new HashMap<String,String>()

       input.put("title", "a book")
       input.put("author", "an author")
       input.put("publisher", "a publisher")

       io = new StubIO(input)
       app = new Main(io)
    }
 
    when 'a valid username and password are entered', {
      Main.run()
    }

    then 'new user is registered to system', {
      io.getPrints().shouldHave("new user registered")
    }
}

scenario "can login with succesfully generated account", {
    given 'command new user is selected', {
       userDao = new InMemoryUserDao()
       auth = new AuthenticationService(userDao)
       io = new StubIO("new", "eero", "sala1nen", "login", "eero", "sala1nen") 
       app = new App(io, auth)
    }
 
    when 'a valid username and password are entered', {
      app.run()
    }

    then  'new credentials allow logging in to system', {
       io.getPrints().shouldHave("logged in")
    }
}

scenario "creation fails with correct username and too short password", {
    given 'command new user is selected', {
       userDao = new InMemoryUserDao()
       auth = new AuthenticationService(userDao)
       io = new StubIO("new", "eero", "s1" ) 
       app = new App(io, auth)
    }
    when 'a valid username and too short password are entered', {
        app.run()
    }
    then 'new user is not be registered to system', {
        io.getPrints().shouldHave("new user not registered")
        io.getPrints().shouldNotHave("new user registered")
    }
}

scenario "creation fails with correct username and password consisting of letters", {
    given 'command new user is selected', {
       userDao = new InMemoryUserDao()
       auth = new AuthenticationService(userDao)
       io = new StubIO("new", "eero", "invalidpassword" ) 
       app = new App(io, auth)
    }
    when 'a valid username and password consisting of letters are entered', {
        app.run()
    }
    then 'new user is not be registered to system', {
        io.getPrints().shouldHave("new user not registered")
        io.getPrints().shouldNotHave("new user registered")
    }
}

scenario "creation fails with too short username and valid password", {
    given 'command new user is selected', {
       userDao = new InMemoryUserDao()
       auth = new AuthenticationService(userDao)
       io = new StubIO("new", "ee", "sala1nen")
       app = new App(io, auth)
    }
    when 'a too sort username and valid password are entered', {
        app.run()
    }
    then 'new user is not be registered to system', {
        io.getPrints().shouldHave("new user not registered")
        io.getPrints().shouldNotHave("new user registered")
    }
}

scenario "creation fails with already taken username and valid password", {
    given 'command new user is selected', {
       userDao = new InMemoryUserDao()
       auth = new AuthenticationService(userDao)
       io = new StubIO("new", "pekka", "sala1nen")
       app = new App(io, auth)
    }
    when 'an already taken username and valid password are entered', {
        app.run();
    }
    then 'new user is not be registered to system', {
        io.getPrints().shouldHave("new user not registered")
        io.getPrints().shouldNotHave("new user registered")
    }
}

scenario "can not login with account that is not successfully created", {
    given 'command new user is selected', {
       userDao = new InMemoryUserDao()
       auth = new AuthenticationService(userDao)
       io = new StubIO("new", "pekka", "invalidpassword", "login", "pekka", "invalidpassword")
       app = new App(io, auth)
    }
    when 'a invalid username/password are entered', {
        app.run();
    }
    then  'new credentials do not allow logging in to system', {
        io.getPrints().shouldHave("wrong username or password")
        io.getPrints().shouldNotHave("logged in")
    }
}