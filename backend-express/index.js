const express = require("express");
const app = express();
const path = require("path"); // requiring path to set directory of ejs
const { v4: uuidv4 } = require('uuid');
const methodOverride = require('method-override');

app.use(express.urlencoded({ extended: true })); // It is a middleware used to parse incoming requests with URL-encoded payloads.
app.use(methodOverride('_method')); // middleware in Express.js allows you to use HTTP verbs such as PUT or DELETE in places where the client doesn't support it
app.use(express.static("public")); // (Static files server middleware) setting directory for css and js files 
app.set("view engine", "ejs");  // setting view engine to ejs for ejs templates
app.set("views", path.join(__dirname, "/views")); // application to specify the directory where the application's views (templates) are located


//demo data (blogs)
let blogs = [
    {
        id: uuidv4(),
        username: "technical",
        content: "The innovative new design features back glass that has color infused throughout the material. A custom dual ion-exchange process for the glass, and an aerospace-grade aluminum enclosure, help make iPhone 15 incredibly durable.",
    },
    {
        id: uuidv4(),
        username: "lifeTruth",
        content: "You’ve gotta dance like there’s nobody watching, love like you’ll never be hurt, sing like there’s nobody listening, and live like it’s heaven on earth",
    },
    {
        id: uuidv4(),
        username: "devProject",
        content: "cherryJS is next future",
    },
];


// Home page
app.get("/", (req, res) => {
    res.render("home.ejs");
});

// Index Route Page
app.get("/blogs", (req, res) => {
    res.render("index.ejs", { blogs });
});

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


// show route (Read)
app.get("/blogs/:id", (req, res) => {
    let { id } = req.params;
    let blog = blogs.find((p) => id === p.id);
    console.log(blog);
    res.render("show.ejs", { blog });
});

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

//delete route (Delete)
app.delete("/blogs/:id", (req, res) => {
    let { id } = req.params;
    blogs = blogs.filter((p) => id !== p.id);
    res.redirect("/blogs");
});

// Creating server connection 
let port = 8080;
app.listen(port);