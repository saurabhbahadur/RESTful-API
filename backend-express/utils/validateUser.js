const Joi = require('joi');

const registerSchema = Joi.object({
  email: Joi.string().email().required(),
  password: Joi.string().min(6).required(),
  username: Joi.string().min(3).required(),
  name: Joi.string().required(),
  gender: Joi.string().valid('MALE', 'FEMALE', 'OTHER').required(),
  dob: Joi.date().required()
});

module.exports = { registerSchema };
