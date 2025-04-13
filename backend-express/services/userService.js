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
        { id: user._id, email: user.email },
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
