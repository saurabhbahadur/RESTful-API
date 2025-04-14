const jwt = require("jsonwebtoken");

const authenticateToken = (req, res, next) => {
    const token = req.header('Authorization')?.replace('Bearer ', '');

    if (!token) {
        return res.status(401).send('Access Denied');
    }

    try {
        const decoded = jwt.verify(token, process.env.JWT_SECRET);
        console.log("Decoded JWT:", decoded);
        req.user = decoded; // ✅ yahi pe user info aa rha hai
        next();
    } catch (err) {
        console.error("Token Error:", err.message);
        res.status(400).send('Invalid Token');
    }
};

module.exports = authenticateToken;
