const express = require('express');
const dotenv = require('dotenv');
const connectDB = require('./config/db');


dotenv.config();
const app = express();

connectDB();

app.use(express.json());

const userRoutes = require('./routes/userRoutes');
const blogRoutes = require('./routes/blogRoutes');

app.use('/api/v1/users', userRoutes);
app.use('/api/v1/blogs', blogRoutes);

module.exports = app;

