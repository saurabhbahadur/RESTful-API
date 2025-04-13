const express = require('express');
const dotenv = require('dotenv');
const connectDB = require('./config/db');


dotenv.config();
const app = express();

connectDB();

app.use(express.json());

const userRoutes = require('./routes/userRoutes');
app.use('/api/v1/users', userRoutes);

module.exports = app;

