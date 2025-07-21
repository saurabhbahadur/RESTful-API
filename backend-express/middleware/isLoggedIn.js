

const isLoggedIn = (req, res, next) => {
    if (!req.user) {
        return res.status(401).send('You must be logged in');
    }
    next();
};

module.exports = isLoggedIn;