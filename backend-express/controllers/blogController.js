const { createBlog, deleteBlog, updateBlog } = require("../services/blogService");



const createBlogController = async (req, res) => {

    console.log("Create Blog controller ....");

    const { title, content } = req.body;
    try {
        const userId = req.user._id || req.user.id;
        console.log("User id received in blog controller create ", userId);
        const blog = await createBlog(userId, title, content);
        res.status(200).json(blog);

    } catch (err) {
        res.status(500).json({ error: err.message })
    }
};

const updateBlogController = async (req, res) => {
    console.log("Update Blog controller ....");

    const blogId = req.params.id;
    const { title, content } = req.body;

    try {
        const updatedBlog = await updateBlog(blogId, title, content);
        res.status(200).send(updatedBlog);

    } catch (error) {
        res.status(500).send(error);
    }

};

const deleteBlogController = async (req, res) => {
    console.log("Delete Blog controller ....");
    try {
        const blogId = req.params.id;
        const blog = await deleteBlog(blogId);
        res.status(200).json(blog);

    } catch (error) {
        res.status(500).send('Internal server error');
    }
};

module.exports = { createBlogController, updateBlogController, deleteBlogController };