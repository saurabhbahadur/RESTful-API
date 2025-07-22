

const isLoggedIn = (req, res, next) => {
    console.info("isLoggedIn middleware......");
    if (!req.user) {
        return res.status(401).send('You must be logged in');
    }
    console.log("req.user: ", req.user);
    next();
};

module.exports = isLoggedIn;