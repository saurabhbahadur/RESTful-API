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