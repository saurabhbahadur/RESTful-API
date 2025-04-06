const express = require('express');
const dotenv = require('dotenv');
const connectDB = require('./config/db');


dotenv.config();
const app = express();

connectDB();

app.use(express.json());

app.use('/api/v1/users', require('./routes/userRoutes'));

module.exports = app;

