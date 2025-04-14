<h1 align="center">RESTful-API</h1>
<p align="center">(RESTful API using Express.js)</p>

---

## 🛠️ Project Overview

This project demonstrates a basic RESTful API built using **Express.js**, implementing **User Authentication** and **Blog Creation** features. It follows a clean folder structure using:


Also includes **middleware** for secure JWT-based authentication.

---

## 🔐 Authentication Middleware

```js
// middleware/authenticateToken.js

const jwt = require("jsonwebtoken");

const authenticateToken = (req, res, next) => {
    const token = req.header('Authorization')?.replace('Bearer ', '');

    if (!token) return res.status(401).send('Access Denied');

    try {
        const decoded = jwt.verify(token, process.env.JWT_SECRET);
        console.log("Decoded JWT:", decoded);
        req.user = decoded; // attaches user info to request
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
// services/userService.js

const User = require('../models/users');
const bcrypt = require('bcryptjs');
const jwt = require("jsonwebtoken");

const registerUser = async (userData) => {
    console.log("Register Service called");
    const existingUser = await User.findOne({ email: userData.email });
    if (existingUser) throw new Error('Email already registered');

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

## ✍️ Blog Service - Create Blog

```js

// services/blogService.js

const Blog = require("../models/blogs");

const createBlog = async (userId, title, content) => {
    console.log("Create Blog Service Called");
    console.log("UserID received in service:", userId);

    if (!title || !content) throw new Error("Title and Content are required");

    const blog = new Blog({ title, content, author: userId });

    return await blog.save();
};

module.exports = { createBlog };


```


## 🔁 Blog Route with Auth Middleware

```js
// routes/blogRoutes.js

const express = require('express');
const { create } = require('../controllers/blogController');
const authenticateToken = require('../middleware/authenticateToken');

const router = express.Router();

router.post('/create', authenticateToken, create);

module.exports = router;

```

## 🔗 Connect with Me




<p align="center"> <a href="https://twitter.com/saurabhbahadur" target="blank"><img src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/twitter.svg" height="30" width="40" /></a> <a href="https://linkedin.com/in/saurabhbahadur" target="blank"><img src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/linked-in-alt.svg" height="30" width="40" /></a> <a href="https://fb.com/singhsaurabhbahadur" target="blank"><img src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/facebook.svg" height="30" width="40" /></a> <a href="https://instagram.com/saurabhbahadur_" target="blank"><img src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/instagram.svg" height="30" width="40" /></a> <a href="https://www.youtube.com/c/mightysaur" target="blank"><img src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/youtube.svg" height="30" width="40" /></a> <a href="https://www.hackerrank.com/saurabhbahadur" target="blank"><img src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/hackerrank.svg" height="30" width="40" /></a> <a href="https://discord.gg/aQR27Bg7de" target="blank"><img src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/discord.svg" height="30" width="40" /></a> </p>