# RESTful-API
### A RESTful API (Representational State Transfer API) is an architectural style for designing networked applications. It is based on the principles of REST, which stands for Representational State Transfer, and it utilizes HTTP protocols for communication.
## Use of HTTP Verbs: RESTful APIs use HTTP methods such as `GET` ,  `POST` , `PUT` , `DELETE` , etc., to perform different operations on resources:
+ Four Method are used for `CRUD` operation:
    + `GET`  requests retrieve data from a server
    + `POST` sends data to a server to create a new resource
    + `PUT` updates an existing resource
    - `DELETE` removes a resource
---
# Getting Started
#### Run this command in terminal
```ruby
npm i express
```
   __Code Start:__
```js
const express = require("express"); // require express 
const app = express();
// Creating server connection 
let port = 8080;
app.listen(port);
```

   __Home Page:__
```js
// setting home page using ejs templates
app.get("/", (req, res) => {
    res.render("home.ejs");
});
```
   __Index Page ( READ Operation ) :__
```js
app.get("/blogs", (req, res) => {
    res.render("index.ejs", { blogs });
});
```
   __New blog Page ( CREATE Operation ) :__
```js
// New Blog Form
app.get("/blogs/new", (req, res) => {
    res.render("new.ejs");
});

// Post request for blog (Create)
app.post("/blogs", (req, res) => {
    let id = uuidv4();
    let { username, content } = req.body;
    blogs.push({ id, username, content });
    console.log(req.body);
    res.redirect("/blogs")
});
```
   __Show Details of Blog:Id ( READ by Id Operation ) :__
```js
// show route (Read)
app.get("/blogs/:id", (req, res) => {
    let { id } = req.params;
    let blog = blogs.find((p) => id === p.id);
    console.log(blog);
    res.render("show.ejs", { blog });
});
```
 __Edit of Blog:Id ( UPDATE Operation ) :__
```js
//patch edit (Update)
app.patch("/blogs/:id", (req, res) => {
    let { id } = req.params;
    let blog = blogs.find((p) => id === p.id);
    let newContent = req.body.content;
    blog.content = newContent;
    console.log(blog);
    res.redirect("/blogs");
});

//edit route (Form appear) 
app.get("/blogs/:id/edit", (req, res) => {
    let { id } = req.params;
    let blog = blogs.find((p) => id === p.id);
    res.render("edit.ejs", { blog });
});
```
__Delete any Blog:Id ( DELETE Operation ) :__
```js
//delete route (Delete)
app.delete("/blogs/:id", (req, res) => {
    let { id } = req.params;
    blogs = blogs.filter((p) => id !== p.id);
    res.redirect("/blogs");
});
```

#### Some important line of code
```js
app.use(express.urlencoded({ extended: true })); // It is a middleware used to parse incoming requests with URL-encoded payloads.
app.use(methodOverride('_method')); // middleware in Express.js allows you to use HTTP verbs such as PUT or DELETE in places where the client doesn't support it
app.use(express.static("public")); // (Static files server middleware) setting directory for css and js files 
app.set("view engine", "ejs");  // setting view engine to ejs for ejs templates
app.set("views", path.join(__dirname, "/views")); // application to specify the directory where the application's views (templates) are located
```



