const express = require('express');

const { create } = require('../controllers/blogController');
const authenticateToken = require('../middleware/authenticateToken');
const isLoggedIn = require('../middleware/isLoggedIn');
const router = express.Router();


router.post('/create', authenticateToken, isLoggedIn, create);
router.patch('/edit');
router.delete('/delete');

module.exports = router;