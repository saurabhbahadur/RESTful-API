const User = require('../models/users');
const bcrypt = require('bcryptjs');

const registerUser = async (userData) => {
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

module.exports = { registerUser };