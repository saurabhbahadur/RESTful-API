<h1 align="center">🚀 RESTful-API</h1>
<p align="center">(A Clean RESTful API using Express.js)</p>

---

## 🛠️ Project Overview

This project demonstrates a basic RESTful API built using **Express.js**, implementing:

- 🧑‍💻 User Authentication (Register/Login)
- 📝 Blog Creation, Editing, and Deletion
- ✅ JWT-based Secure Middleware
- 📁 Clean folder structure

---

## 📂 Folder Structure

```
📦 RESTful-API
├── config/
│ └── db.js
├── controllers/
├── middleware/
├── models/
├── routes/
├── services/
├── .env
├── app.js
└── server.js
```

---

## 🚀 Getting Started

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/saurabhbahadur/RESTful-API.git
```

2️⃣ Install Dependencies

```bash
npm install
```

3️⃣ Environment Setup

```
PORT=6969
MONGO_URI=mongodb://localhost:27017/your-db-name
JWT_SECRET=your_jwt_secret_key
```

4️⃣ Start the Server

```bash
nodemon server.js
```


## 🔐 Authentication Middleware

```js

const jwt = require("jsonwebtoken");

const authenticateToken = (req, res, next) => {
    console.info("authenticateToken middleware......");
    const token = req.header('Authorization')?.replace('Bearer ', '');

    if (!token) {
        return res.status(401).send('Access Denied');
    }

    try {
        const decoded = jwt.verify(token, process.env.JWT_SECRET);
        console.log("Decoded JWT:", decoded);
        req.user = decoded; 
        next();
    } catch (err) {
        console.error("Token Error:", err.message);
        res.status(400).send('Invalid Token');
    }
};

module.exports = authenticateToken;


```

## 👤 User Service - Register & Login

```js

const User = require('../models/users');
const bcrypt = require('bcryptjs');
const jwt = require("jsonwebtoken");


const registerUser = async (userData) => {
    console.log("Register Service called");
    const exsitingUser = await User.findOne({ email: userData.email });
    if (exsitingUser) throw new Error('Email already registered');

    const hashedPassword = await bcrypt.hash(userData.password, 10);

    const user = new User({
        ...userData, password: hashedPassword
    });

    const savedUser = await user.save();

    return {
        id: savedUser._id,
        username: savedUser.username,
        email: savedUser.email,
        name: savedUser.name,
        gender: savedUser.gender,
        dob: savedUser.dob,
        createdAt: savedUser.createdAt
    };
};



const loginUser = async (email, password) => {
    console.log("Login User Service called");
    const user = await User.findOne({ email });
    if (!user) throw new Error("Invalid credentials");

    const isMatch = await bcrypt.compare(password, user.password);
    if (!isMatch) throw new Error("Invalid credentials");

    const token = jwt.sign(
        { _id: user._id, email: user.email },
        process.env.JWT_SECRET,
        { expiresIn: "1h" }
    );

    return {
        username: user.username,
        email: user.email,
        token,
    };


};




module.exports = { registerUser, loginUser };


```


## ✍️ Blog Service - Create, Edit, Delete

```js

const Blog = require("../models/blogs");


const createBlog = async (userId, title, content) => {

    console.log("Create Blog Service Called");
    console.log("UserID received in service:", userId);

    if (!title || !content) { throw new Error("Title and Content are required "); }

    const blog = new Blog({ title, content, author: userId, });

    return await blog.save();

};

const updateBlog = async (blogId, title, content) => {

    console.log("Update Blog Service Called");
    console.log("BlogID received in service:", blogId);

    if (!title || !content) { throw new Error("Blog not found"); }

    const updatedBlog = await Blog.findByIdAndUpdate(blogId, { title, content }, { new: true, runValidators: true });

    if (!updatedBlog) { throw new Error("Blog not found"); }

    return updatedBlog;



};

const deleteBlog = async (blogId) => {

    console.log("Delete Blog Service Called");
    console.log("BlogID received in service:", blogId);

    const blog = await Blog.findById(blogId);

    if (!blog) { throw new Error("Blog not found"); }

    return await Blog.findByIdAndDelete(blogId);

};


module.exports = { createBlog, updateBlog, deleteBlog };

```


## 🔁 Blog Routes (with Authentication + Authorization)

```js

const express = require('express');

const { createBlogController, deleteBlogController, updateBlogController } = require('../controllers/blogController');
const authenticateToken = require('../middleware/authenticateToken');
const isLoggedIn = require('../middleware/isLoggedIn');
const isOwner = require('../middleware/isOwner');
const Blog = require('../models/blogs');
const router = express.Router();


router.post('/create', authenticateToken, isLoggedIn, createBlogController);
router.put('/edit/:id', authenticateToken, isOwner(Blog, 'id', 'author'), updateBlogController);
router.delete('/delete/:id', authenticateToken, isOwner(Blog, 'id', 'author'), deleteBlogController);

module.exports = router;

```



## 📬 Sample API Endpoints

| Method | Endpoint                   | Description          |
| ------ | -------------------------- | -------------------- |
| POST   | `/api/v1/users/register`   | Register user        |
| POST   | `/api/v1/users/login`      | Login user (get JWT) |
| POST   | `/api/v1/blogs/create`     | Create a blog post   |
| PUT    | `/api/v1/blogs/edit/:id`   | Edit blog (owner)    |
| DELETE | `/api/v1/blogs/delete/:id` | Delete blog (owner)  |

## 🔐 All blog routes require Authorization header:

```
Authorization: Bearer <your-jwt-token>
```




## 🔗 Connect with Me




<p align="center"> <a href="https://twitter.com/saurabhbahadur" target="blank"><img src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/twitter.svg" height="30" width="40" /></a> <a href="https://linkedin.com/in/saurabhbahadur" target="blank"><img src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/linked-in-alt.svg" height="30" width="40" /></a> <a href="https://fb.com/singhsaurabhbahadur" target="blank"><img src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/facebook.svg" height="30" width="40" /></a> <a href="https://instagram.com/saurabhbahadur_" target="blank"><img src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/instagram.svg" height="30" width="40" /></a> <a href="https://www.youtube.com/c/mightysaur" target="blank"><img src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/youtube.svg" height="30" width="40" /></a> <a href="https://www.hackerrank.com/saurabhbahadur" target="blank"><img src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/hackerrank.svg" height="30" width="40" /></a> <a href="https://discord.gg/aQR27Bg7de" target="blank"><img src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/discord.svg" height="30" width="40" /></a> </p>