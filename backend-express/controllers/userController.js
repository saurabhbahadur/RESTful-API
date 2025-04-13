const { registerUser, loginUser } = require("../services/userService");
const { registerSchema } = require("../utils/validateUser");


const register = async (req, res) => {

    console.log("Register controller called");


    try {
        const { error } = registerSchema.validate(req.body);

        if (error) return res.status(400).json({ error: error.details[0].message });

        const response = await registerUser(req.body);

        res.status(201).json(response);
    } catch (err) {
        res.status(500).json({ error: err.message })
    }

};


const login = async (req, res) => {
    console.log("Login controller called");
    try {
        const { email, password } = req.body;

        const data = await loginUser(email, password);
        res.status(200).json(data);
    } catch (err) {
        res.status(401).json({ msg: err.message });
    }
};




module.exports = { register, login };