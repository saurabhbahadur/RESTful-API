const { registerUser } = require("../services/userService");
const { registerSchema } = require("../utils/validateUser");


const register = async (req, res) => {

    try {
        const { error } = registerSchema.validate(req.body);

        if (error) return res.status(400).json({ error: error.details[0].message });

        const response = await registerUser(req.body);

        res.status(201).json(response);
    } catch (err) {
        res.status(500).json({ error: err.message })
    }

};

module.exports = { register };