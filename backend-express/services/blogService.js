const Blog = require("../models/blogs");


const createBlog = async (userId, title, content) => {

    console.log("Create Blog Service Called");
    console.log("UserID received in service:", userId);

    if (!title || !content) { throw new Error("Title and Content are required "); }

    const blog = new Blog({ title, content, author: userId, });

    return await blog.save();

};





module.exports = { createBlog };