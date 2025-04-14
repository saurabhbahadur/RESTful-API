const { createBlog } = require("../services/blogService");



const create = async (req, res) => {

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

module.exports = { create };