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