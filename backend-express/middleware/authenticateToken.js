const { jwt } = require("jsonwebtoken");
const users = require("../models/users");



const autenticateToken = (req, res , next) =>{
    const token = req.header('Authorization')?.replace('Bearer ','');

    if(!token){
        return res.status(401).send('Access Denied');
    }

    try{
        const decoded = jwt.verify(token,process.env.JWT_SECRET);
        req.users = decoded;
        next();
    } catch (err){
        res.status(400).send('Invalid Token');
    }
}