const Blog = require("../models/blogs");


const isOwner = async (req, res, next) => {

    try {
        const blogId = req.params.id;
        const blog = await Blog.findById(blogId);

        if (!blog) {
            return res.status(404).send('Blog not found');
        }

        if (blog.author.toString() !== req.user._id) {
            return res.status(403).send('Access denied. Not the blog owner');
        }

        next();

    } catch (error) {

        console.error("Owner not found ", error.message);
        res.status(500).send('Server error | Owner not found');

    }
};

module.exports = isOwner;