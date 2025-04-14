const express = require('express');

const { create } = require('../controllers/blogController');
const authenticateToken = require('../middleware/authenticateToken');
const router = express.Router();


router.post('/create', authenticateToken, create);

module.exports = router;