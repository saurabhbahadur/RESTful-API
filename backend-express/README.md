<h1 align="center" > RESTful-API </h1> <p align="center"> (RestFul API using Express JS)</p>

### A RESTful API (Representational State Transfer API) is an architectural style for designing networked applications. It is based on the principles of REST, which stands for Representational State Transfer, and it utilizes HTTP protocols for communication.

## [Demo](https://www.linkedin.com/posts/saurabhbahadur_connections-mernstack-mernstackdevelopment-activity-7132318224523665408--vES?utm_source=share&utm_medium=member_desktop)

## Use of HTTP Verbs: RESTful APIs use HTTP methods such as `GET` ,  `POST` , `PUT` , `DELETE` , etc., to perform different operations on resources:
+ Four Method are used for `CRUD` operation:
    + `GET`  requests retrieve data from a server
    + `POST` sends data to a server to create a new resource
    + `PUT` updates an existing resource
    - `DELETE` removes a resource
---

# Getting Started

### Run this command in terminal :
```ruby
npm i express
```
---
### Code Start :
```js
const express = require("express"); // require express 
const app = express();
// Creating server connection 
let port = 8080;
app.listen(port);
```

   ### Home Page:
```js
// setting home page using ejs templates
app.get("/", (req, res) => {
    res.render("home.ejs");
});
```
### Enter this on your browser url 
```
http://localhost:8080/
```

### Index Page ( READ Operation ) :
```js
app.get("/blogs", (req, res) => {
    res.render("index.ejs", { blogs });
});
```
### New blog Page ( CREATE Operation ) :
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
### Show Details of Blog:Id ( READ by Id Operation ) :
```js
// show route (Read)
app.get("/blogs/:id", (req, res) => {
    let { id } = req.params;
    let blog = blogs.find((p) => id === p.id);
    console.log(blog);
    res.render("show.ejs", { blog });
});
```
 ### Edit of Blog:Id ( UPDATE Operation ) :
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
### Delete any Blog:Id ( DELETE Operation ) :
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
***
### RESTful APIs are widely used due to their simplicity, scalability, and the ability to work well with different client types and HTTP-based systems. They are commonly used in web services, mobile applications, and various other software systems for enabling communication between different components.


# License

`RESTful-API` is licensed under **`MIT license`**. View [license](https://github.com/saurabhbahadur/RESTful-API/blob/main/LICENSE).<br>
Copyright (c) [**Saurabh Bahadur**](https://github.com/saurabhbahadur).

***



<h3 align="center">Connect with me:</h3>
<p align="center">
<a href="https://twitter.com/saurabhbahadur" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/twitter.svg" alt="saurabhbahadur" height="30" width="40" /></a>
<a href="https://linkedin.com/in/saurabhbahadur" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/linked-in-alt.svg" alt="saurabhbahadur" height="30" width="40" /></a>
<a href="https://fb.com/singhsaurabhbahadur" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/facebook.svg" alt="singhsaurabhbahadur" height="30" width="40" /></a>
<a href="https://instagram.com/saurabhbahadur_" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/instagram.svg" alt="saurabhbahadur_" height="30" width="40" /></a>
<a href="https://www.youtube.com/c/mighty saur" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/youtube.svg" alt="mighty saur" height="30" width="40" /></a>
<a href="https://www.hackerrank.com/saurabhbahadur" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/hackerrank.svg" alt="saurabhbahadur" height="30" width="40" /></a>
<a href="https://discord.gg/aQR27Bg7de" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/discord.svg" alt="aQR27Bg7de" height="30" width="40" /></a>
</p>
