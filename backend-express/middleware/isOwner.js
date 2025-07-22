
const isOwner = (Model, idParam , userField ) => {

    return async (req, res, next) => {

        console.info("isOwner middleware......");

        try {
            const resourceId = req.params[idParam];
            const resource = await Model.findById(resourceId.trim());

            console.log("Resource Id", resourceId);
            console.log("Resource ", resource);


            if (!resource) {
                return res.status(404).send('Resource not found');
            }

            if (resource[userField].toString() !== req.user._id.toString()) {
                return res.status(403).send('Access denied. Not the blog owner');
            }

            next();

        } catch (error) {

            console.error("Owner not found ", error.message);
            res.status(500).send('Server error | Owner not found');

        }

    };
};

module.exports = isOwner;